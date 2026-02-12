package com.f1system.ui.gui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana de gestión de relaciones entre entidades.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class VentanaGestion extends JDialog {
    private F1Manager manager;
    private VentanaPrincipal ventanaPadre;
    
    public VentanaGestion(VentanaPrincipal padre, F1Manager manager) {
        super(padre, "Gestión", true);
        this.ventanaPadre = padre;
        this.manager = manager;
        
        setSize(600, 400);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        crearComponentes();
    }
    
    private void crearComponentes() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        // Título
        JLabel lblTitulo = new JLabel("Asignar Piloto a Escudería", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(31, 71, 136));
        panel.add(lblTitulo, BorderLayout.NORTH);
        
        // Panel central
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JComboBox<String> cmbPiloto = new JComboBox<>();
        JComboBox<String> cmbEscuderia = new JComboBox<>();
        
        // Cargar datos
        for (Piloto p : manager.obtenerTodosPilotos()) {
            cmbPiloto.addItem(p.getCodigo() + " - " + p.getNombreCompleto());
        }
        
        for (Escuderia e : manager.obtenerTodasEscuderias()) {
            cmbEscuderia.addItem(e.getCodigo() + " - " + e.getNombre());
        }
        
        // Piloto
        gbc.gridx = 0; gbc.gridy = 0;
        panelCentral.add(new JLabel("Piloto:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelCentral.add(cmbPiloto, gbc);
        
        // Escudería
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        panelCentral.add(new JLabel("Escudería:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelCentral.add(cmbEscuderia, gbc);
        
        panel.add(panelCentral, BorderLayout.CENTER);
        
        // Botón
        JButton btnAsignar = new JButton("Asignar");
        btnAsignar.setFont(new Font("Arial", Font.BOLD, 12));
        btnAsignar.setBackground(new Color(31, 71, 136));
        btnAsignar.setForeground(Color.WHITE);
        btnAsignar.setFocusPainted(false);
        btnAsignar.setPreferredSize(new Dimension(150, 40));
        
        btnAsignar.addActionListener(e -> {
            try {
                String selPiloto = (String) cmbPiloto.getSelectedItem();
                String selEscuderia = (String) cmbEscuderia.getSelectedItem();
                
                if (selPiloto == null || selEscuderia == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione piloto y escudería");
                    return;
                }
                
                String codigoPiloto = selPiloto.split(" - ")[0];
                String codigoEscuderia = selEscuderia.split(" - ")[0];
                
                manager.asignarPilotoEscuderia(codigoPiloto, codigoEscuderia);
                
                JOptionPane.showMessageDialog(this, 
                    "Piloto asignado exitosamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                ventanaPadre.actualizar();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.WHITE);
        panelBoton.add(btnAsignar);
        panel.add(panelBoton, BorderLayout.SOUTH);
        
        add(panel);
    }
}
