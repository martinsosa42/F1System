package com.f1system.ui.gui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Ventana de listado de todas las entidades.
 */
public class VentanaListado extends JDialog {
    private F1Manager manager;
    
    public VentanaListado(VentanaPrincipal padre, F1Manager manager) {
        super(padre, "Listado de Datos", true);
        this.manager = manager;
        
        setSize(900, 700);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        crearComponentes();
    }
    
    private void crearComponentes() {
        JTabbedPane tabs = new JTabbedPane();
        
        tabs.addTab("Países", crearPanelPaises());
        tabs.addTab("Circuitos", crearPanelCircuitos());
        tabs.addTab("Escuderías", crearPanelEscuderias());
        tabs.addTab("Pilotos", crearPanelPilotos());
        tabs.addTab("Autos", crearPanelAutos());
        tabs.addTab("Mecánicos", crearPanelMecanicos());
        tabs.addTab("Carreras", crearPanelCarreras());
        
        add(tabs);
    }
    
    private JPanel crearPanelPaises() {
        String[] columnas = {"Código", "Nombre", "Continente"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Pais p : manager.obtenerTodosPaises()) {
            modelo.addRow(new Object[]{p.getCodigo(), p.getNombre(), p.getContinente()});
        }
        
        return crearPanelTabla(modelo, "Total de países: " + manager.obtenerTodosPaises().size());
    }
    
    private JPanel crearPanelCircuitos() {
        String[] columnas = {"Código", "Nombre", "País", "Longitud (km)", "Curvas"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Circuito c : manager.obtenerTodosCircuitos()) {
            modelo.addRow(new Object[]{
                c.getCodigo(),
                c.getNombre(),
                c.getPais().getNombre(),
                c.getLongitudKm(),
                c.getNumeroCurvas()
            });
        }
        
        return crearPanelTabla(modelo, "Total de circuitos: " + manager.obtenerTodosCircuitos().size());
    }
    
    private JPanel crearPanelEscuderias() {
        String[] columnas = {"Código", "Nombre", "País Sede", "Año Fundación", "Pilotos", "Autos"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Escuderia e : manager.obtenerTodasEscuderias()) {
            modelo.addRow(new Object[]{
                e.getCodigo(),
                e.getNombre(),
                e.getPaisSede().getNombre(),
                e.getAnioFundacion(),
                e.getPilotos().size(),
                e.getAutos().size()
            });
        }
        
        return crearPanelTabla(modelo, "Total de escuderías: " + manager.obtenerTodasEscuderias().size());
    }
    
    private JPanel crearPanelPilotos() {
        String[] columnas = {"Código", "Nombre", "Nacionalidad", "Número", "Escudería"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Piloto p : manager.obtenerTodosPilotos()) {
            String escuderia = p.getEscuderiaActual() != null ? 
                p.getEscuderiaActual().getNombre() : "Sin escudería";
            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombreCompleto(),
                p.getNacionalidad().getNombre(),
                p.getNumeroPiloto(),
                escuderia
            });
        }
        
        return crearPanelTabla(modelo, "Total de pilotos: " + manager.obtenerTodosPilotos().size());
    }
    
    private JPanel crearPanelAutos() {
        String[] columnas = {"Código", "Modelo", "Escudería", "Año", "Motor", "Potencia (HP)"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Auto a : manager.obtenerTodosAutos()) {
            modelo.addRow(new Object[]{
                a.getCodigo(),
                a.getModelo(),
                a.getEscuderia().getNombre(),
                a.getAnioFabricacion(),
                a.getMotor(),
                a.getPotenciaHP()
            });
        }
        
        return crearPanelTabla(modelo, "Total de autos: " + manager.obtenerTodosAutos().size());
    }
    
    private JPanel crearPanelMecanicos() {
        String[] columnas = {"Código", "Nombre", "Escudería", "Especialidad", "Experiencia"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Mecanico m : manager.obtenerTodosMecanicos()) {
            modelo.addRow(new Object[]{
                m.getCodigo(),
                m.getNombreCompleto(),
                m.getEscuderia().getNombre(),
                m.getEspecialidad(),
                m.getAniosExperiencia() + " años"
            });
        }
        
        return crearPanelTabla(modelo, "Total de mecánicos: " + manager.obtenerTodosMecanicos().size());
    }
    
    private JPanel crearPanelCarreras() {
        String[] columnas = {"Código", "Nombre", "Circuito", "Fecha", "Vueltas", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Carrera c : manager.obtenerTodasCarreras()) {
            modelo.addRow(new Object[]{
                c.getCodigo(),
                c.getNombre(),
                c.getCircuito().getNombre(),
                c.getFechaHora().toLocalDate(),
                c.getNumeroVueltas(),
                c.isFinalizada() ? "Finalizada" : "Pendiente"
            });
        }
        
        return crearPanelTabla(modelo, "Total de carreras: " + manager.obtenerTodasCarreras().size());
    }
    
    private JPanel crearPanelTabla(DefaultTableModel modelo, String info) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        JTable tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tabla.getTableHeader().setBackground(new Color(31, 71, 136));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);
        
        JLabel lblInfo = new JLabel(info);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 12));
        lblInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panel.add(lblInfo, BorderLayout.SOUTH);
        
        return panel;
    }
}
