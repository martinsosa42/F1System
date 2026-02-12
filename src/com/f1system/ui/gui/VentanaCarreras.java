package com.f1system.ui.gui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Ventana de administración de carreras.
 */
public class VentanaCarreras extends JDialog {
    private F1Manager manager;
    private VentanaPrincipal ventanaPadre;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public VentanaCarreras(VentanaPrincipal padre, F1Manager manager) {
        super(padre, "Administración de Carreras", true);
        this.ventanaPadre = padre;
        this.manager = manager;
        
        setSize(700, 600);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        crearComponentes();
    }
    
    private void crearComponentes() {
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Planificar", crearPanelPlanificar());
        tabs.addTab("Participaciones", crearPanelParticipaciones());
        tabs.addTab("Resultados", crearPanelResultados());
        tabs.addTab("Finalizar", crearPanelFinalizar());
        
        add(tabs);
    }
    
    private JPanel crearPanelPlanificar() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JComboBox<String> cmbCircuito = new JComboBox<>();
        JTextField txtFechaHora = new JTextField(20);
        JSpinner spnVueltas = new JSpinner(new SpinnerNumberModel(50, 1, 100, 1));
        
        for (Circuito c : manager.obtenerTodosCircuitos()) {
            cmbCircuito.addItem(c.getCodigo() + " - " + c.getNombre());
        }
        
        int row = 0;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCodigo, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Circuito:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbCircuito, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Fecha/Hora (dd/MM/yyyy HH:mm):"), gbc);
        gbc.gridx = 1;
        panel.add(txtFechaHora, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Número de vueltas:"), gbc);
        gbc.gridx = 1;
        panel.add(spnVueltas, gbc);
        
        JButton btnCrear = crearBoton("Planificar Carrera");
        btnCrear.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String selCircuito = (String) cmbCircuito.getSelectedItem();
                String codigoCircuito = selCircuito.split(" - ")[0];
                LocalDateTime fechaHora = LocalDateTime.parse(txtFechaHora.getText().trim(), dateTimeFormatter);
                int vueltas = (Integer) spnVueltas.getValue();
                
                Circuito circuito = manager.obtenerCircuito(codigoCircuito);
                Carrera carrera = new Carrera(codigo, nombre, circuito, fechaHora, vueltas);
                manager.registrarCarrera(carrera);
                
                JOptionPane.showMessageDialog(this, "Carrera planificada exitosamente");
                txtCodigo.setText("");
                txtNombre.setText("");
                txtFechaHora.setText("");
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnCrear, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelParticipaciones() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JComboBox<String> cmbCarrera = new JComboBox<>();
        JComboBox<String> cmbPiloto = new JComboBox<>();
        JComboBox<String> cmbAuto = new JComboBox<>();
        
        for (Carrera c : manager.obtenerTodasCarreras()) {
            cmbCarrera.addItem(c.getCodigo() + " - " + c.getNombre());
        }
        for (Piloto p : manager.obtenerTodosPilotos()) {
            cmbPiloto.addItem(p.getCodigo() + " - " + p.getNombreCompleto());
        }
        for (Auto a : manager.obtenerTodosAutos()) {
            cmbAuto.addItem(a.getCodigo() + " - " + a.getModelo());
        }
        
        int row = 0;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Carrera:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(cmbCarrera, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel("Piloto:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(cmbPiloto, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel("Auto:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(cmbAuto, gbc);
        
        JButton btnRegistrar = crearBoton("Registrar Participación");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigoCarrera = ((String) cmbCarrera.getSelectedItem()).split(" - ")[0];
                String codigoPiloto = ((String) cmbPiloto.getSelectedItem()).split(" - ")[0];
                String codigoAuto = ((String) cmbAuto.getSelectedItem()).split(" - ")[0];
                
                manager.registrarParticipacion(codigoCarrera, codigoPiloto, codigoAuto);
                
                JOptionPane.showMessageDialog(this, "Participación registrada exitosamente");
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelResultados() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JComboBox<String> cmbCarrera = new JComboBox<>();
        JComboBox<String> cmbPiloto = new JComboBox<>();
        JSpinner spnPosicion = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        JCheckBox chkVueltaRapida = new JCheckBox("Vuelta rápida");
        
        for (Carrera c : manager.obtenerTodasCarreras()) {
            cmbCarrera.addItem(c.getCodigo() + " - " + c.getNombre());
        }
        
        // Listener para cargar pilotos de la carrera seleccionada
        cmbCarrera.addActionListener(e -> {
            cmbPiloto.removeAllItems();
            String selCarrera = (String) cmbCarrera.getSelectedItem();
            if (selCarrera != null) {
                String codigoCarrera = selCarrera.split(" - ")[0];
                Carrera carrera = manager.obtenerCarrera(codigoCarrera);
                if (carrera != null) {
                    for (Participacion p : carrera.getParticipaciones()) {
                        cmbPiloto.addItem(p.getPiloto().getCodigo() + " - " + 
                                        p.getPiloto().getNombreCompleto());
                    }
                }
            }
        });
        
        int row = 0;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Carrera:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(cmbCarrera, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel("Piloto:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(cmbPiloto, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel("Posición:"), gbc);
        gbc.gridx = 1;
        panel.add(spnPosicion, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        panel.add(chkVueltaRapida, gbc);
        
        JButton btnRegistrar = crearBoton("Registrar Resultado");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigoCarrera = ((String) cmbCarrera.getSelectedItem()).split(" - ")[0];
                String codigoPiloto = ((String) cmbPiloto.getSelectedItem()).split(" - ")[0];
                int posicion = (Integer) spnPosicion.getValue();
                boolean vueltaRapida = chkVueltaRapida.isSelected();
                
                manager.registrarResultado(codigoCarrera, codigoPiloto, posicion, vueltaRapida);
                
                JOptionPane.showMessageDialog(this, "Resultado registrado exitosamente");
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelFinalizar() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JComboBox<String> cmbCarrera = new JComboBox<>();
        
        for (Carrera c : manager.obtenerTodasCarreras()) {
            if (!c.isFinalizada()) {
                cmbCarrera.addItem(c.getCodigo() + " - " + c.getNombre());
            }
        }
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Carrera:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(cmbCarrera, gbc);
        
        JButton btnFinalizar = crearBoton("Finalizar Carrera");
        btnFinalizar.addActionListener(e -> {
            try {
                String selCarrera = (String) cmbCarrera.getSelectedItem();
                if (selCarrera == null) {
                    JOptionPane.showMessageDialog(this, "No hay carreras pendientes");
                    return;
                }
                
                String codigoCarrera = selCarrera.split(" - ")[0];
                Carrera carrera = manager.obtenerCarrera(codigoCarrera);
                
                int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de finalizar esta carrera?\nNo podrá modificarla después.",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
                
                if (confirmacion == JOptionPane.YES_OPTION) {
                    carrera.finalizarCarrera();
                    JOptionPane.showMessageDialog(this, "Carrera finalizada exitosamente");
                    cmbCarrera.removeItem(selCarrera);
                    ventanaPadre.actualizar();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnFinalizar, gbc);
        
        return panel;
    }
    
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBackground(new Color(31, 71, 136));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(200, 35));
        return boton;
    }
}
