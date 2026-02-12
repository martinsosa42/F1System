package com.f1system.ui.gui;

import com.f1system.service.F1Manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ventana principal del sistema con interfaz gráfica.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class VentanaPrincipal extends JFrame {
    private F1Manager manager;
    private JPanel panelPrincipal;
    private Color colorPrimario = new Color(31, 71, 136); // #1F4788
    private Color colorSecundario = new Color(46, 92, 138); // #2E5C8A
    private Color colorFondo = new Color(240, 240, 240);
    
    /**
     * Constructor de la ventana principal.
     * 
     * @param manager gestor del sistema F1
     */
    public VentanaPrincipal(F1Manager manager) {
        this.manager = manager;
        configurarVentana();
        crearComponentes();
    }
    
    /**
     * Configura las propiedades de la ventana.
     */
    private void configurarVentana() {
        setTitle("Sistema de Gestión F1 - Escuderías Unidas");
        setSize(1200, 800);
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Icono de la aplicación (si existe)
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        } catch (Exception e) {
            // Icono no disponible
        }
    }
    
    /**
     * Crea los componentes de la interfaz.
     */
    private void crearComponentes() {
        // Panel principal con BorderLayout
        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crear componentes
        panelPrincipal.add(crearPanelSuperior(), BorderLayout.NORTH);
        panelPrincipal.add(crearPanelCentral(), BorderLayout.CENTER);
        panelPrincipal.add(crearPanelInferior(), BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    /**
     * Crea el panel superior con el título.
     */
    private JPanel crearPanelSuperior() {
        JPanel panel = new JPanel();
        panel.setBackground(colorPrimario);
        panel.setPreferredSize(new Dimension(0, 80));
        panel.setLayout(new BorderLayout());
        
        // Título
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN F1", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        
        JLabel lblSubtitulo = new JLabel("Escuderías Unidas", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSubtitulo.setForeground(new Color(200, 200, 200));
        
        JPanel panelTexto = new JPanel(new GridLayout(2, 1));
        panelTexto.setBackground(colorPrimario);
        panelTexto.add(lblTitulo);
        panelTexto.add(lblSubtitulo);
        
        panel.add(panelTexto, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Crea el panel central con los botones de menú.
     */
    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(colorFondo);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        // Primera fila
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(crearBotonMenu("📝 REGISTROS", "Registrar nuevos elementos", 
            e -> abrirRegistros()), gbc);
        
        gbc.gridx = 1;
        panel.add(crearBotonMenu("⚙️ GESTIÓN", "Gestionar relaciones", 
            e -> abrirGestion()), gbc);
        
        gbc.gridx = 2;
        panel.add(crearBotonMenu("🏁 CARRERAS", "Administrar carreras", 
            e -> abrirCarreras()), gbc);
        
        // Segunda fila
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(crearBotonMenu("📊 INFORMES", "Ver estadísticas", 
            e -> abrirInformes()), gbc);
        
        gbc.gridx = 1;
        panel.add(crearBotonMenu("📋 LISTAR", "Ver todos los datos", 
            e -> abrirListado()), gbc);
        
        gbc.gridx = 2;
        panel.add(crearBotonMenu("ℹ️ ACERCA DE", "Información del sistema", 
            e -> mostrarAcercaDe()), gbc);
        
        return panel;
    }
    
    /**
     * Crea un botón de menú personalizado.
     */
    private JButton crearBotonMenu(String texto, String descripcion, ActionListener listener) {
        JButton boton = new JButton();
        boton.setLayout(new BorderLayout(10, 5));
        boton.setBackground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(colorSecundario, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel lblTexto = new JLabel(texto, SwingConstants.CENTER);
        lblTexto.setFont(new Font("Arial", Font.BOLD, 18));
        lblTexto.setForeground(colorPrimario);
        
        JLabel lblDescripcion = new JLabel(descripcion, SwingConstants.CENTER);
        lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDescripcion.setForeground(Color.GRAY);
        
        JPanel panelTexto = new JPanel(new GridLayout(2, 1, 0, 5));
        panelTexto.setOpaque(false);
        panelTexto.add(lblTexto);
        panelTexto.add(lblDescripcion);
        
        boton.add(panelTexto, BorderLayout.CENTER);
        
        // Efectos hover
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(230, 240, 255));
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(Color.WHITE);
                boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        boton.addActionListener(listener);
        
        return boton;
    }
    
    /**
     * Crea el panel inferior con información del estado.
     */
    private JPanel crearPanelInferior() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorSecundario);
        panel.setPreferredSize(new Dimension(0, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel lblEstado = new JLabel("Sistema listo | " + obtenerEstadisticas());
        lblEstado.setForeground(Color.WHITE);
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 11));
        
        panel.add(lblEstado, BorderLayout.WEST);
        
        return panel;
    }
    
    /**
     * Obtiene estadísticas rápidas del sistema.
     */
    private String obtenerEstadisticas() {
        return String.format("Pilotos: %d | Escuderías: %d | Carreras: %d",
            manager.obtenerTodosPilotos().size(),
            manager.obtenerTodasEscuderias().size(),
            manager.obtenerTodasCarreras().size());
    }
    
    /**
     * Abre la ventana de registros.
     */
    private void abrirRegistros() {
        VentanaRegistros ventana = new VentanaRegistros(this, manager);
        ventana.setVisible(true);
    }
    
    /**
     * Abre la ventana de gestión.
     */
    private void abrirGestion() {
        VentanaGestion ventana = new VentanaGestion(this, manager);
        ventana.setVisible(true);
    }
    
    /**
     * Abre la ventana de carreras.
     */
    private void abrirCarreras() {
        VentanaCarreras ventana = new VentanaCarreras(this, manager);
        ventana.setVisible(true);
    }
    
    /**
     * Abre la ventana de informes.
     */
    private void abrirInformes() {
        VentanaInformes ventana = new VentanaInformes(this, manager);
        ventana.setVisible(true);
    }
    
    /**
     * Abre la ventana de listado.
     */
    private void abrirListado() {
        VentanaListado ventana = new VentanaListado(this, manager);
        ventana.setVisible(true);
    }
    
    /**
     * Muestra el diálogo "Acerca de".
     */
    private void mostrarAcercaDe() {
        String mensaje = "<html><body style='width: 300px; font-family: Arial;'>" +
            "<h2 style='color: #1F4788;'>Sistema de Gestión F1</h2>" +
            "<p><b>Versión:</b> 1.0</p>" +
            "<p><b>Desarrollado para:</b> Escuderías Unidas</p>" +
            "<p><b>Curso:</b> Programación II - Taller 2025</p>" +
            "<p><b>Características:</b></p>" +
            "<ul>" +
            "<li>Gestión completa de campeonato F1</li>" +
            "<li>Sistema de puntuación oficial</li>" +
            "<li>Informes y estadísticas detalladas</li>" +
            "<li>Interfaz gráfica moderna</li>" +
            "</ul>" +
            "</body></html>";
        
        JOptionPane.showMessageDialog(this, mensaje, "Acerca de", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Actualiza la interfaz después de cambios.
     */
    public void actualizar() {
        // Actualizar panel inferior
        Component[] componentes = panelPrincipal.getComponents();
        for (Component comp : componentes) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                if (panel.getLayout() instanceof BorderLayout) {
                    Component[] subComp = panel.getComponents();
                    for (Component c : subComp) {
                        if (c instanceof JLabel) {
                            JLabel lbl = (JLabel) c;
                            if (lbl.getText().startsWith("Sistema listo")) {
                                lbl.setText("Sistema listo | " + obtenerEstadisticas());
                            }
                        }
                    }
                }
            }
        }
        repaint();
    }
}
