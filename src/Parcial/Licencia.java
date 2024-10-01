package Parcial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Licencia extends JFrame implements ActionListener {
    private JLabel logotipo, nombreUsuarioLabel;
    private JTextArea areaTerminos;
    private JCheckBox aceptarTerminos;
    private JButton botonContinuar, botonNoAceptar;
    private String nombreUsuario;

    public Licencia(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        //pone imagen en vez del icono de java
        ImageIcon iconoVentana = new ImageIcon(getClass().getResource("/Imagenes/personaje.png"));
        setIconImage(iconoVentana.getImage());
        setTitle("Crunchy - Términos y Condiciones");
        setLayout(null);
        setSize(500, 450); //Ajuste del tamaño de la ventana
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar en la pantalla

        //Fondo oscuro
        getContentPane().setBackground(new Color(34, 34, 34)); //Gris oscuro

        //Logotipo
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/logoCru.png"));
        logotipo = new JLabel(imagen);
        logotipo.setBounds(85, 1, 300, 150);
        add(logotipo);

        //Mostrar el nombre del usuario
        nombreUsuarioLabel = new JLabel("Usuario: " + nombreUsuario);
        nombreUsuarioLabel.setBounds(175, 120, 300, 30);
        nombreUsuarioLabel.setFont(new Font("SansSerif", Font.BOLD, 16)); //Fuente más grande
        nombreUsuarioLabel.setForeground(new Color(255, 255, 255)); //Texto blanco
        add(nombreUsuarioLabel);

        //Área de términos y condiciones 
        areaTerminos = new JTextArea("Términos y Condiciones de la empresa Crunchy. Acepta para continuar...");
        areaTerminos.setBounds(100, 150, 300, 100);
        areaTerminos.setFont(new Font("SansSerif", Font.PLAIN, 14));
        areaTerminos.setLineWrap(true); //Texto en varias líneas
        areaTerminos.setWrapStyleWord(true);
        areaTerminos.setEditable(false); //Solo lectura
        areaTerminos.setBackground(new Color(50, 50, 50)); //Fondo oscuro
        areaTerminos.setForeground(Color.WHITE); //Texto blanco
        areaTerminos.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); //Borde gris claro
        add(areaTerminos);

        //Checkbox para aceptar los términos y condiciones
        aceptarTerminos = new JCheckBox("Aceptar Términos y Condiciones");
        aceptarTerminos.setBounds(100, 270, 250, 30);
        aceptarTerminos.setFont(new Font("SansSerif", Font.PLAIN, 14));
        aceptarTerminos.setForeground(new Color(255, 255, 255)); //Texto blanco
        aceptarTerminos.setBackground(new Color(34, 34, 34)); //Fondo del checkbox igual al fondo general
        aceptarTerminos.addActionListener(this);
        add(aceptarTerminos);

        //Botón continuar (deshabilitado inicialmente)
        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(100, 320, 150, 40);
        botonContinuar.setFont(new Font("SansSerif", Font.BOLD, 16)); //Fuente más grande
        botonContinuar.setBackground(new Color(255, 69, 0)); //Fondo rojo
        botonContinuar.setForeground(Color.WHITE); //Texto blanco
        botonContinuar.setEnabled(false); //Deshabilitado inicialmente
        botonContinuar.setBorderPainted(false); //Sin borde visible
        botonContinuar.setFocusPainted(false); //Sin borde de enfoque
        botonContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor tipo mano
        botonContinuar.addActionListener(this);
        add(botonContinuar);

        // Botón No aceptar
        botonNoAceptar = new JButton("No Aceptar");
        botonNoAceptar.setBounds(260, 320, 150, 40);
        botonNoAceptar.setFont(new Font("SansSerif", Font.BOLD, 16));
        botonNoAceptar.setBackground(new Color(100, 100, 100)); // Fondo gris para denotar acción negativa
        botonNoAceptar.setForeground(Color.WHITE);
        botonNoAceptar.setBorderPainted(false);
        botonNoAceptar.setFocusPainted(false);
        botonNoAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonNoAceptar.addActionListener(this);
        add(botonNoAceptar);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptarTerminos) {
            // Habilita o deshabilita ezl botón "Continuar" según el estado del checkbox
            botonContinuar.setEnabled(aceptarTerminos.isSelected());
        } else if (e.getSource() == botonContinuar) {
            if (aceptarTerminos.isSelected()) {
                // Abrir la interfaz principal
                Principal principal = new Principal(nombreUsuario);
                principal.setVisible(true);
                this.dispose(); // Cerrar la ventana actual
            } else {
                JOptionPane.showMessageDialog(this, "Debe aceptar los términos y condiciones para continuar.");
            }
        } else if (e.getSource() == botonNoAceptar) {
            // Volver a la pantalla de bienvenida
            Bienvenida bienvenida = new Bienvenida();
            bienvenida.setVisible(true);
            this.dispose(); // Cierra la ventana actual
        }
    }
}
