package com.f1system.ui.gui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * Ventana de informes y estadísticas.
 */
public class VentanaInformes extends JDialog {
    private F1Manager manager;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public VentanaInformes(VentanaPrincipal padre, F1Manager manager) {
        super(padre, "Informes y Estadísticas", true);
        this.manager = manager;
        
        setSize(900, 700);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        crearComponentes();
    }
    
    private void crearComponentes() {
        JTabbedPane tabs = new JTabbedPane();
        
        tabs.addTab("Ranking Pilotos", crearPanelRanking());
        tabs.addTab("Carreras", crearPanelCarreras());
        tabs.addTab("Podios/Victorias", crearPanelPodios());
        tabs.addTab("Estadísticas", crearPanelEstadisticas());
        
        add(tabs);
    }
    
    private JPanel crearPanelRanking() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        JLabel lblTitulo = new JLabel("Ranking de Pilotos por Puntos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lblTitulo, BorderLayout.NORTH);
        
        String[] columnas = {"Posición", "Piloto", "Escudería", "Puntos"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        List<Map.Entry<Piloto, Integer>> ranking = manager.obtenerRankingPilotos();
        int posicion = 1;
        for (Map.Entry<Piloto, Integer> entry : ranking) {
            Piloto p = entry.getKey();
            String escuderia = p.getEscuderiaActual() != null ? 
                p.getEscuderiaActual().getNombre() : "Sin escudería";
            modelo.addRow(new Object[]{
                posicion++,
                p.getNombreCompleto(),
                escuderia,
                entry.getValue()
            });
        }
        
        JTable tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tabla.getTableHeader().setBackground(new Color(31, 71, 136));
        tabla.getTableHeader().setForeground(Color.WHITE);
        
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearPanelCarreras() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        // Panel superior con filtros
        JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFiltro.setBackground(Color.WHITE);
        
        panelFiltro.add(new JLabel("Desde:"));
        JTextField txtDesde = new JTextField("01/01/2023", 10);
        panelFiltro.add(txtDesde);
        
        panelFiltro.add(new JLabel("Hasta:"));
        JTextField txtHasta = new JTextField("31/12/2025", 10);
        panelFiltro.add(txtHasta);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(31, 71, 136));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        
        panelFiltro.add(btnBuscar);
        panel.add(panelFiltro, BorderLayout.NORTH);
        
        // Tabla de resultados
        String[] columnas = {"Carrera", "Circuito", "Fecha", "Estado", "Ganador"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tabla.getTableHeader().setBackground(new Color(31, 71, 136));
        tabla.getTableHeader().setForeground(Color.WHITE);
        
        btnBuscar.addActionListener(e -> {
            try {
                LocalDate desde = LocalDate.parse(txtDesde.getText(), dateFormatter);
                LocalDate hasta = LocalDate.parse(txtHasta.getText(), dateFormatter);
                
                modelo.setRowCount(0);
                List<Carrera> carreras = manager.obtenerCarrerasPorRangoFechas(desde, hasta);
                
                for (Carrera c : carreras) {
                    String ganador = "-";
                    if (c.isFinalizada()) {
                        for (Participacion p : c.getParticipaciones()) {
                            if (p.getPosicionFinal() != null && p.getPosicionFinal() == 1) {
                                ganador = p.getPiloto().getNombreCompleto();
                                break;
                            }
                        }
                    }
                    
                    modelo.addRow(new Object[]{
                        c.getNombre(),
                        c.getCircuito().getNombre(),
                        c.getFechaHora().format(dateFormatter),
                        c.isFinalizada() ? "Finalizada" : "Pendiente",
                        ganador
                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);
        
        // Cargar datos iniciales
        btnBuscar.doClick();
        
        return panel;
    }
    
    private JPanel crearPanelPodios() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        // Panel superior
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.setBackground(Color.WHITE);
        
        panelSuperior.add(new JLabel("Piloto:"));
        JComboBox<String> cmbPiloto = new JComboBox<>();
        for (Piloto p : manager.obtenerTodosPilotos()) {
            cmbPiloto.addItem(p.getCodigo() + " - " + p.getNombreCompleto());
        }
        panelSuperior.add(cmbPiloto);
        
        JButton btnPodios = new JButton("Ver Podios");
        btnPodios.setBackground(new Color(31, 71, 136));
        btnPodios.setForeground(Color.WHITE);
        btnPodios.setFocusPainted(false);
        panelSuperior.add(btnPodios);
        
        JButton btnVictorias = new JButton("Ver Victorias");
        btnVictorias.setBackground(new Color(46, 92, 138));
        btnVictorias.setForeground(Color.WHITE);
        btnVictorias.setFocusPainted(false);
        panelSuperior.add(btnVictorias);
        
        panel.add(panelSuperior, BorderLayout.NORTH);
        
        // Tabla
        String[] columnas = {"Posición", "Carrera", "Circuito", "Fecha", "Puntos"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tabla.getTableHeader().setBackground(new Color(31, 71, 136));
        tabla.getTableHeader().setForeground(Color.WHITE);
        
        btnPodios.addActionListener(e -> {
            try {
                String codigoPiloto = ((String) cmbPiloto.getSelectedItem()).split(" - ")[0];
                List<Participacion> podios = manager.obtenerPodiosPiloto(codigoPiloto);
                
                modelo.setRowCount(0);
                for (Participacion p : podios) {
                    modelo.addRow(new Object[]{
                        p.getPosicionFinal() + "º",
                        p.getCarrera().getNombre(),
                        p.getCarrera().getCircuito().getNombre(),
                        p.getCarrera().getFechaHora().format(dateFormatter),
                        p.getPuntos()
                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        btnVictorias.addActionListener(e -> {
            try {
                String codigoPiloto = ((String) cmbPiloto.getSelectedItem()).split(" - ")[0];
                List<Participacion> victorias = manager.obtenerVictoriasPiloto(codigoPiloto);
                
                modelo.setRowCount(0);
                for (Participacion p : victorias) {
                    modelo.addRow(new Object[]{
                        "1º 🏆",
                        p.getCarrera().getNombre(),
                        p.getCarrera().getCircuito().getNombre(),
                        p.getCarrera().getFechaHora().format(dateFormatter),
                        p.getPuntos()
                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearPanelEstadisticas() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Estadística 1: Piloto en Circuito
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Piloto:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> cmbPiloto1 = new JComboBox<>();
        for (Piloto p : manager.obtenerTodosPilotos()) {
            cmbPiloto1.addItem(p.getCodigo() + " - " + p.getNombreCompleto());
        }
        panel.add(cmbPiloto1, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Circuito:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> cmbCircuito = new JComboBox<>();
        for (Circuito c : manager.obtenerTodosCircuitos()) {
            cmbCircuito.addItem(c.getCodigo() + " - " + c.getNombre());
        }
        panel.add(cmbCircuito, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton btnConsultar1 = new JButton("Consultar Participaciones");
        btnConsultar1.setBackground(new Color(31, 71, 136));
        btnConsultar1.setForeground(Color.WHITE);
        panel.add(btnConsultar1, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblResultado1 = new JLabel("");
        lblResultado1.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblResultado1, gbc);
        
        btnConsultar1.addActionListener(e -> {
            try {
                String codigoPiloto = ((String) cmbPiloto1.getSelectedItem()).split(" - ")[0];
                String codigoCircuito = ((String) cmbCircuito.getSelectedItem()).split(" - ")[0];
                
                int cantidad = manager.contarCarrerasPilotoEnCircuito(codigoPiloto, codigoCircuito);
                Piloto p = manager.obtenerPiloto(codigoPiloto);
                Circuito c = manager.obtenerCircuito(codigoCircuito);
                
                lblResultado1.setText(p.getNombreCompleto() + " ha corrido " + cantidad + 
                                    " veces en " + c.getNombre());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        // Separador
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.insets = new Insets(30, 10, 30, 10);
        JSeparator separador = new JSeparator();
        panel.add(separador, gbc);
        
        // Estadística 2: Carreras en Circuito
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Circuito:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> cmbCircuito2 = new JComboBox<>();
        for (Circuito c : manager.obtenerTodosCircuitos()) {
            cmbCircuito2.addItem(c.getCodigo() + " - " + c.getNombre());
        }
        panel.add(cmbCircuito2, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton btnConsultar2 = new JButton("Consultar Total de Carreras");
        btnConsultar2.setBackground(new Color(46, 92, 138));
        btnConsultar2.setForeground(Color.WHITE);
        panel.add(btnConsultar2, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7;
        JLabel lblResultado2 = new JLabel("");
        lblResultado2.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblResultado2, gbc);
        
        btnConsultar2.addActionListener(e -> {
            try {
                String codigoCircuito = ((String) cmbCircuito2.getSelectedItem()).split(" - ")[0];
                int cantidad = manager.contarCarrerasEnCircuito(codigoCircuito);
                Circuito c = manager.obtenerCircuito(codigoCircuito);
                
                lblResultado2.setText("Se han corrido " + cantidad + " carreras en " + c.getNombre());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        return panel;
    }
}
