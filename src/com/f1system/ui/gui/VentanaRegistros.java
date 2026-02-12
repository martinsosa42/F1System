package com.f1system.ui.gui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Ventana de registros con pestañas para cada tipo de entidad.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class VentanaRegistros extends JDialog {
    private F1Manager manager;
    private VentanaPrincipal ventanaPadre;
    private JTabbedPane tabbedPane;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /**
     * Constructor de la ventana de registros.
     */
    public VentanaRegistros(VentanaPrincipal padre, F1Manager manager) {
        super(padre, "Registros", true);
        this.ventanaPadre = padre;
        this.manager = manager;
        
        setSize(700, 600);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        crearComponentes();
    }
    
    /**
     * Crea los componentes de la ventana.
     */
    private void crearComponentes() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));
        
        tabbedPane.addTab("🌍 País", crearPanelPais());
        tabbedPane.addTab("🏁 Circuito", crearPanelCircuito());
        tabbedPane.addTab("🏢 Escudería", crearPanelEscuderia());
        tabbedPane.addTab("👤 Piloto", crearPanelPiloto());
        tabbedPane.addTab("🏎️ Auto", crearPanelAuto());
        tabbedPane.addTab("🔧 Mecánico", crearPanelMecanico());
        
        add(tabbedPane);
    }
    
    /**
     * Crea el panel de registro de países.
     */
    private JPanel crearPanelPais() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JTextField txtContinente = new JTextField(20);
        
        // Código
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Código (ej: AR, ES):"), gbc);
        gbc.gridx = 1;
        panel.add(txtCodigo, gbc);
        
        // Nombre
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        // Continente
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Continente:"), gbc);
        gbc.gridx = 1;
        panel.add(txtContinente, gbc);
        
        // Botón registrar
        JButton btnRegistrar = crearBotonPrimario("Registrar País");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String continente = txtContinente.getText().trim();
                
                if (codigo.isEmpty() || nombre.isEmpty()) {
                    mostrarError("Código y nombre son obligatorios");
                    return;
                }
                
                Pais pais = new Pais(codigo, nombre, continente);
                manager.registrarPais(pais);
                
                mostrarExito("País registrado exitosamente");
                limpiarCampos(txtCodigo, txtNombre, txtContinente);
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                mostrarError("Error: " + ex.getMessage());
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    /**
     * Crea el panel de registro de circuitos.
     */
    private JPanel crearPanelCircuito() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JComboBox<String> cmbPais = new JComboBox<>();
        JTextField txtLongitud = new JTextField(20);
        JTextField txtCurvas = new JTextField(20);
        
        // Cargar países
        actualizarComboPaises(cmbPais);
        
        // Campos
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
        panel.add(new JLabel("País:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbPais, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Longitud (km):"), gbc);
        gbc.gridx = 1;
        panel.add(txtLongitud, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Número de curvas:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCurvas, gbc);
        
        // Botón
        JButton btnRegistrar = crearBotonPrimario("Registrar Circuito");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String codigoPais = extraerCodigoPais(cmbPais);
                double longitud = Double.parseDouble(txtLongitud.getText().trim());
                int curvas = Integer.parseInt(txtCurvas.getText().trim());
                
                if (codigo.isEmpty() || nombre.isEmpty() || codigoPais == null) {
                    mostrarError("Todos los campos son obligatorios");
                    return;
                }
                
                Pais pais = manager.obtenerPais(codigoPais);
                if (pais == null) {
                    mostrarError("País no encontrado");
                    return;
                }
                
                Circuito circuito = new Circuito(codigo, nombre, pais, longitud, curvas);
                manager.registrarCircuito(circuito);
                
                mostrarExito("Circuito registrado exitosamente");
                limpiarCampos(txtCodigo, txtNombre, txtLongitud, txtCurvas);
                ventanaPadre.actualizar();
            } catch (NumberFormatException ex) {
                mostrarError("Longitud y curvas deben ser números válidos");
            } catch (Exception ex) {
                mostrarError("Error: " + ex.getMessage());
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    /**
     * Crea el panel de registro de escuderías.
     */
    private JPanel crearPanelEscuderia() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JComboBox<String> cmbPais = new JComboBox<>();
        JTextField txtAnio = new JTextField(20);
        
        actualizarComboPaises(cmbPais);
        
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
        panel.add(new JLabel("País sede:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbPais, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Año de fundación:"), gbc);
        gbc.gridx = 1;
        panel.add(txtAnio, gbc);
        
        JButton btnRegistrar = crearBotonPrimario("Registrar Escudería");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String codigoPais = extraerCodigoPais(cmbPais);
                int anio = Integer.parseInt(txtAnio.getText().trim());
                
                Pais pais = manager.obtenerPais(codigoPais);
                if (pais == null) {
                    mostrarError("País no encontrado");
                    return;
                }
                
                Escuderia escuderia = new Escuderia(codigo, nombre, pais, anio);
                manager.registrarEscuderia(escuderia);
                
                mostrarExito("Escudería registrada exitosamente");
                limpiarCampos(txtCodigo, txtNombre, txtAnio);
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                mostrarError("Error: " + ex.getMessage());
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    /**
     * Crea el panel de registro de pilotos.
     */
    private JPanel crearPanelPiloto() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JTextField txtApellido = new JTextField(20);
        JTextField txtFecha = new JTextField(20);
        JComboBox<String> cmbNacionalidad = new JComboBox<>();
        JSpinner spnNumero = new JSpinner(new SpinnerNumberModel(1, 0, 99, 1));
        
        actualizarComboPaises(cmbNacionalidad);
        
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
        panel.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        panel.add(txtApellido, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Fecha nac. (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1;
        panel.add(txtFecha, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Nacionalidad:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbNacionalidad, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Número (0-99):"), gbc);
        gbc.gridx = 1;
        panel.add(spnNumero, gbc);
        
        JButton btnRegistrar = crearBotonPrimario("Registrar Piloto");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                LocalDate fecha = LocalDate.parse(txtFecha.getText().trim(), dateFormatter);
                String codigoPais = extraerCodigoPais(cmbNacionalidad);
                int numero = (Integer) spnNumero.getValue();
                
                Pais nacionalidad = manager.obtenerPais(codigoPais);
                if (nacionalidad == null) {
                    mostrarError("Nacionalidad no encontrada");
                    return;
                }
                
                Piloto piloto = new Piloto(codigo, nombre, apellido, fecha, nacionalidad, numero);
                manager.registrarPiloto(piloto);
                
                mostrarExito("Piloto registrado exitosamente");
                limpiarCampos(txtCodigo, txtNombre, txtApellido, txtFecha);
                ventanaPadre.actualizar();
            } catch (DateTimeParseException ex) {
                mostrarError("Formato de fecha inválido. Use dd/MM/yyyy");
            } catch (Exception ex) {
                mostrarError("Error: " + ex.getMessage());
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    /**
     * Crea el panel de registro de autos.
     */
    private JPanel crearPanelAuto() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtModelo = new JTextField(20);
        JComboBox<String> cmbEscuderia = new JComboBox<>();
        JTextField txtAnio = new JTextField(20);
        JTextField txtMotor = new JTextField(20);
        JTextField txtPotencia = new JTextField(20);
        
        actualizarComboEscuderias(cmbEscuderia);
        
        int row = 0;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCodigo, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1;
        panel.add(txtModelo, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Escudería:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbEscuderia, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Año de fabricación:"), gbc);
        gbc.gridx = 1;
        panel.add(txtAnio, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Motor:"), gbc);
        gbc.gridx = 1;
        panel.add(txtMotor, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Potencia (HP):"), gbc);
        gbc.gridx = 1;
        panel.add(txtPotencia, gbc);
        
        JButton btnRegistrar = crearBotonPrimario("Registrar Auto");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String modelo = txtModelo.getText().trim();
                String codigoEsc = extraerCodigoEscuderia(cmbEscuderia);
                int anio = Integer.parseInt(txtAnio.getText().trim());
                String motor = txtMotor.getText().trim();
                int potencia = Integer.parseInt(txtPotencia.getText().trim());
                
                Escuderia escuderia = manager.obtenerEscuderia(codigoEsc);
                if (escuderia == null) {
                    mostrarError("Escudería no encontrada");
                    return;
                }
                
                Auto auto = new Auto(codigo, modelo, escuderia, anio, motor, potencia);
                manager.registrarAuto(auto);
                
                mostrarExito("Auto registrado exitosamente");
                limpiarCampos(txtCodigo, txtModelo, txtAnio, txtMotor, txtPotencia);
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                mostrarError("Error: " + ex.getMessage());
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    /**
     * Crea el panel de registro de mecánicos.
     */
    private JPanel crearPanelMecanico() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCodigo = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JTextField txtApellido = new JTextField(20);
        JComboBox<String> cmbEscuderia = new JComboBox<>();
        JTextField txtEspecialidad = new JTextField(20);
        JSpinner spnExperiencia = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
        
        actualizarComboEscuderias(cmbEscuderia);
        
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
        panel.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        panel.add(txtApellido, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Escudería:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbEscuderia, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Especialidad:"), gbc);
        gbc.gridx = 1;
        panel.add(txtEspecialidad, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Años de experiencia:"), gbc);
        gbc.gridx = 1;
        panel.add(spnExperiencia, gbc);
        
        JButton btnRegistrar = crearBotonPrimario("Registrar Mecánico");
        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                String codigoEsc = extraerCodigoEscuderia(cmbEscuderia);
                String especialidad = txtEspecialidad.getText().trim();
                int experiencia = (Integer) spnExperiencia.getValue();
                
                Escuderia escuderia = manager.obtenerEscuderia(codigoEsc);
                if (escuderia == null) {
                    mostrarError("Escudería no encontrada");
                    return;
                }
                
                Mecanico mecanico = new Mecanico(codigo, nombre, apellido, escuderia, 
                                                 especialidad, experiencia);
                manager.registrarMecanico(mecanico);
                
                mostrarExito("Mecánico registrado exitosamente");
                limpiarCampos(txtCodigo, txtNombre, txtApellido, txtEspecialidad);
                ventanaPadre.actualizar();
            } catch (Exception ex) {
                mostrarError("Error: " + ex.getMessage());
            }
        });
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(btnRegistrar, gbc);
        
        return panel;
    }
    
    // ========== MÉTODOS AUXILIARES ==========
    
    private void actualizarComboPaises(JComboBox<String> combo) {
        combo.removeAllItems();
        for (Pais p : manager.obtenerTodosPaises()) {
            combo.addItem(p.getCodigo() + " - " + p.getNombre());
        }
    }
    
    private void actualizarComboEscuderias(JComboBox<String> combo) {
        combo.removeAllItems();
        for (Escuderia e : manager.obtenerTodasEscuderias()) {
            combo.addItem(e.getCodigo() + " - " + e.getNombre());
        }
    }
    
    private String extraerCodigoPais(JComboBox<String> combo) {
        String seleccion = (String) combo.getSelectedItem();
        return seleccion != null ? seleccion.split(" - ")[0] : null;
    }
    
    private String extraerCodigoEscuderia(JComboBox<String> combo) {
        String seleccion = (String) combo.getSelectedItem();
        return seleccion != null ? seleccion.split(" - ")[0] : null;
    }
    
    private JButton crearBotonPrimario(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBackground(new Color(31, 71, 136));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setPreferredSize(new Dimension(200, 35));
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(46, 92, 138));
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(new Color(31, 71, 136));
            }
        });
        
        return boton;
    }
    
    private void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
    
    private void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
