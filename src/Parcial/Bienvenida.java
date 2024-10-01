package Parcial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bienvenida extends JFrame implements ActionListener {
    private JLabel logotipo, etiquetaNombre, leyendaPie,leyendaPie2;
    private JTextField campoNombre;
    private JButton botonContinuar;
    private String nombreUsuario = "";

    public Bienvenida() {
        //pone imagen en vez del icono de java
        ImageIcon iconoVentana = new ImageIcon(getClass().getResource("/Imagenes/personaje.png"));
        setIconImage(iconoVentana.getImage());
        //Configuración general del formulario
        setTitle("Crunchy - Bienvenida");
        setLayout(null);
        setSize(500, 400); //Tamaño más grande del formulario
        setResizable(false); //No permite redimensionar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar el formulario en la pantalla

        //Establecer un fondo oscuro 
        getContentPane().setBackground(new Color(34, 34, 34)); //Fondo gris oscuro

        //Logotipo
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/logoC.png"));
        logotipo = new JLabel(imagen);
        logotipo.setBounds(125, 20, 250, 100); //Ajuste del tamaño y posición
        add(logotipo);

        //Etiqueta de "Ingrese su nombre"
        etiquetaNombre = new JLabel("Ingrese su nombre:");
        etiquetaNombre.setBounds(150, 140, 200, 30);
        etiquetaNombre.setFont(new Font("SansSerif", Font.BOLD, 16)); //Fuente más grande
        etiquetaNombre.setForeground(new Color(255, 255, 255)); //Color blanco
        add(etiquetaNombre);

        //Campo de texto para introducir el nombre
        campoNombre = new JTextField();
        campoNombre.setBounds(150, 180, 200, 35);
        campoNombre.setFont(new Font("SansSerif", Font.PLAIN, 16)); 
        campoNombre.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); //Borde gris claro
        add(campoNombre);

        //Botón "Continuar"
        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(150, 240, 200, 40);
        botonContinuar.setFont(new Font("SansSerif", Font.BOLD, 16)); // Fuente 
        botonContinuar.setBackground(new Color(255, 69, 0)); // Color de fondo rojo 
        botonContinuar.setForeground(Color.WHITE); // Texto blanco
        botonContinuar.setBorderPainted(false); // Sin borde visible
        botonContinuar.setFocusPainted(false); // Elimina el borde de enfoque
        botonContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al pasar
        botonContinuar.addActionListener(this);
        add(botonContinuar);

        //Leyenda en la parte inferior
        leyendaPie = new JLabel("©2024 - Crunchy - Angel Teret");
        leyendaPie.setBounds(175, 295, 200, 30);
        leyendaPie.setFont(new Font("SansSerif", Font.PLAIN, 14));
        leyendaPie.setForeground(new Color(180, 180, 180)); //Texto gris claro
        add(leyendaPie);
        
        leyendaPie2 = new JLabel("Programación II - Sección D");
        leyendaPie2.setBounds(175, 320, 200, 30);
        leyendaPie2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        leyendaPie2.setForeground(new Color(180, 180, 180)); //Texto gris claro
        add(leyendaPie2);

        

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonContinuar) {
            nombreUsuario = campoNombre.getText();
            if (!nombreUsuario.isEmpty()) {
                //Abrir la interfaz de Términos y Condiciones
                Licencia terminos = new Licencia(nombreUsuario);
                terminos.setVisible(true);
                this.dispose(); //Cerrar la ventana actual
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese su nombre.");
            }
        }
    }

    public static void main(String[] args) {
        Bienvenida bienvenida = new Bienvenida();
        bienvenida.setVisible(true);
    }
}
