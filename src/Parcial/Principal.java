package Parcial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Principal extends JFrame implements ActionListener {
    private JLabel etiquetaNombre, etiquetaApellidoPaterno, etiquetaApellidoMaterno, etiquetaDepartamento, etiquetaAntiguedad, logotipo,leyendaPie, leyendaPie2, usuario;
    private JTextField campoNombre, campoApellidoPaterno, campoApellidoMaterno;
    private JComboBox<String> comboDepartamento, comboAntiguedad;
    private JButton botonCalcular, botonLimpiar, botonRegresar;
    private JTextArea areaResultado;
    private String nombreUsuario;

    // Colores predeterminados
    private Color colorFondoActual = new Color(34, 34, 34); // Gris oscuro
    private final Color colorCian = new Color(1, 63, 89); // Cian
    private final Color colorAqua = new Color(10, 114, 114); // Aqua

    public Principal(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        
        //pone imagen en vez del icono de java
        ImageIcon iconoVentana = new ImageIcon(getClass().getResource("/Imagenes/personaje.png"));
        setIconImage(iconoVentana.getImage());
        //Configuración de la ventana
        setTitle("Crunchy - Cálculo de Vacaciones");
        setSize(700, 630);
        setLayout(null);
        setResizable(false); //No permite redimensionar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar el formulario en la pantalla
        getContentPane().setBackground(colorFondoActual); //Fondo gris oscuro

        //Agregar JMenuBar para cambiar colores y mostrar info del desarrollador
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //cambiar el color de fondo
        JMenu menuOpciones = new JMenu("Opciones");
        menuBar.add(menuOpciones);

        JMenuItem colorGris = new JMenuItem("Color Gris Oscuro");
        JMenuItem coloCianItem = new JMenuItem("Color Cian");
        JMenuItem colorAquaItem = new JMenuItem("Color Aqua");

        menuOpciones.add(colorGris);
        menuOpciones.add(coloCianItem);
        menuOpciones.add(colorAquaItem);

        //ActionListeners para cambiar color de fondo
        colorGris.addActionListener(e -> cambiarColorFondo(colorFondoActual));
        coloCianItem.addActionListener(e -> cambiarColorFondo(colorCian));
        colorAquaItem.addActionListener(e -> cambiarColorFondo(colorAqua));

        //Menú "Ayuda" para mostrar información del desarrollador
        JMenu menuDesarrolador = new JMenu("Desarrollador");
        menuBar.add(menuDesarrolador);

        JMenuItem datosDesarrollador = new JMenuItem("Datos del Desarrollador");
        menuDesarrolador.add(datosDesarrollador);

        datosDesarrollador.addActionListener(e -> mostrarDatosDesarrollador());

        //Logotipo en la parte superior izquierda
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/logoP.png"));
        logotipo = new JLabel(imagen);
        logotipo.setBounds(10, 2, 130, 100);
        add(logotipo);


        
        //Mostrar el nombre del usuario
        usuario = new JLabel("Bienvenido " + nombreUsuario);
        usuario.setBounds(240, 30, 400, 40);
        usuario.setForeground(Color.WHITE);
        usuario.setFont(new Font("Arial", Font.BOLD, 30)); //Fuente más grande para el título
        add(usuario);
        
        // Título
        JLabel titulo = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
        titulo.setBounds(180, 60, 400, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20)); //Fuente más grande para el título
        add(titulo);

        //Fuente personalizada para etiquetas y campos
        Font fuenteEtiquetas = new Font("Arial", Font.BOLD, 16);
        Font fuenteCampos = new Font("Arial", Font.PLAIN, 16);

        //Etiquetas y campos de texto
        etiquetaNombre = new JLabel("Nombre completo:");
        etiquetaNombre.setBounds(150, 100, 150, 25);
        etiquetaNombre.setForeground(Color.WHITE);
        etiquetaNombre.setFont(fuenteEtiquetas);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(320, 100, 250, 30);
        campoNombre.setFont(fuenteCampos);
        campoNombre.setBackground(new Color(50, 50, 50));
        campoNombre.setForeground(Color.WHITE);
        campoNombre.setCaretColor(Color.WHITE);
        campoNombre.setBorder(new LineBorder(Color.GRAY, 1, true)); //Borde redondeado
        add(campoNombre);

        etiquetaApellidoPaterno = new JLabel("Apellido Paterno:");
        etiquetaApellidoPaterno.setBounds(150, 140, 150, 25);
        etiquetaApellidoPaterno.setForeground(Color.WHITE);
        etiquetaApellidoPaterno.setFont(fuenteEtiquetas);
        add(etiquetaApellidoPaterno);

        campoApellidoPaterno = new JTextField();
        campoApellidoPaterno.setBounds(320, 140, 250, 30);
        campoApellidoPaterno.setFont(fuenteCampos);
        campoApellidoPaterno.setBackground(new Color(50, 50, 50));
        campoApellidoPaterno.setForeground(Color.WHITE);
        campoApellidoPaterno.setCaretColor(Color.WHITE);
        campoApellidoPaterno.setBorder(new LineBorder(Color.GRAY, 1, true));
        add(campoApellidoPaterno);

        etiquetaApellidoMaterno = new JLabel("Apellido Materno:");
        etiquetaApellidoMaterno.setBounds(150, 180, 150, 25);
        etiquetaApellidoMaterno.setForeground(Color.WHITE);
        etiquetaApellidoMaterno.setFont(fuenteEtiquetas);
        add(etiquetaApellidoMaterno);

        campoApellidoMaterno = new JTextField();
        campoApellidoMaterno.setBounds(320, 180, 250, 30);
        campoApellidoMaterno.setFont(fuenteCampos);
        campoApellidoMaterno.setBackground(new Color(50, 50, 50));
        campoApellidoMaterno.setForeground(Color.WHITE);
        campoApellidoMaterno.setCaretColor(Color.WHITE);
        campoApellidoMaterno.setBorder(new LineBorder(Color.GRAY, 1, true));
        add(campoApellidoMaterno);

        //ComboBox para el Departamento
        etiquetaDepartamento = new JLabel("Departamento:");
        etiquetaDepartamento.setBounds(150, 220, 150, 25);
        etiquetaDepartamento.setForeground(Color.WHITE);
        etiquetaDepartamento.setFont(fuenteEtiquetas);
        add(etiquetaDepartamento);

        String[] departamentos = {"Atención al Cliente", "Logística", "Gerencia"};
        comboDepartamento = new JComboBox<>(departamentos);
        comboDepartamento.setBounds(320, 220, 250, 30);
        comboDepartamento.setFont(fuenteCampos);
        comboDepartamento.setBackground(new Color(50, 50, 50));
        comboDepartamento.setForeground(Color.WHITE);
        comboDepartamento.setBorder(new LineBorder(Color.WHITE, 1, true));
        add(comboDepartamento);

        //ComboBox para la Antigüedad
        etiquetaAntiguedad = new JLabel("Antigüedad:");
        etiquetaAntiguedad.setBounds(150, 260, 150, 25);
        etiquetaAntiguedad.setForeground(Color.WHITE);
        etiquetaAntiguedad.setFont(fuenteEtiquetas);
        add(etiquetaAntiguedad);

        String[] antiguedad = {"1 año de servicio", "2 a 6 años de servicio", "7 años o más de servicio"};
        comboAntiguedad = new JComboBox<>(antiguedad);
        comboAntiguedad.setBounds(320, 260, 250, 30);
        comboAntiguedad.setFont(fuenteCampos);
        comboAntiguedad.setBackground(new Color(50, 50, 50));
        comboAntiguedad.setForeground(Color.WHITE);
        comboAntiguedad.setBorder(new LineBorder(Color.WHITE, 1, true));
        add(comboAntiguedad);

        //TextArea para mostrar el resultado
        areaResultado = new JTextArea();
        areaResultado.setBounds(125, 320, 475, 120);
        areaResultado.setBackground(new Color(50, 50, 50));
        areaResultado.setForeground(Color.WHITE);
        areaResultado.setFont(new Font("Arial", Font.BOLD, 15)); //Texto más grande
        areaResultado.setEditable(false);
        areaResultado.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(areaResultado);

        //Botones
        botonCalcular = new JButton("Calcular");
        botonCalcular.setBounds(150, 460, 120, 40);
        botonCalcular.setBackground(new Color(255, 94, 77)); //Botón con color anaranjado
        botonCalcular.setForeground(Color.WHITE);
        botonCalcular.setFont(new Font("Arial", Font.BOLD, 14));
        botonCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor tipo mano
        add(botonCalcular);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(290, 460, 120, 40);
        botonLimpiar.setBackground(new Color(255, 94, 77));
        botonLimpiar.setForeground(Color.WHITE);
        botonLimpiar.setFont(new Font("Arial", Font.BOLD, 14));
        botonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor tipo mano
        add(botonLimpiar);

        botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(430, 460, 120, 40);
        botonRegresar.setBackground(new Color(255, 94, 77));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cursor tipo mano
        add(botonRegresar);
        
        
                //Leyenda en la parte inferior
        leyendaPie = new JLabel("©2024 - Crunchy- Angel Teret");
        leyendaPie.setBounds(250, 510, 200, 30);
        leyendaPie.setFont(new Font("SansSerif", Font.PLAIN, 14));
        leyendaPie.setForeground(new Color(180, 180, 180)); //Texto gris claro
        add(leyendaPie);
        
        leyendaPie2 = new JLabel("Programación II - Sección D");
        leyendaPie2.setBounds(270, 530, 200, 30);
        leyendaPie2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        leyendaPie2.setForeground(new Color(180, 180, 180)); //Texto gris claro
        add(leyendaPie2);
        //Agregar ActionListeners a los botones
        botonCalcular.addActionListener(this);
        botonLimpiar.addActionListener(this);
        botonRegresar.addActionListener(this);
    }

    //Método para cambiar el color de fondo
    private void cambiarColorFondo(Color color) {
        getContentPane().setBackground(color);
        repaint(); //Repintar la ventana con el nuevo color
    }

    //Mostrar datos del desarrollador
    private void mostrarDatosDesarrollador() {
        String infoDesarrollador = "Desarrollador: Henry Angel Gabriel Teret Hernández\n" +
                                   "Ingeniería en sistemas de la información\n"+
                                   "Cuarto Semestre - Programación II\n"+
                                   "Fecha: Septiembre 2024";
        JOptionPane.showMessageDialog(this,
                infoDesarrollador,
                "Datos del Desarrollador",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCalcular) {
            //Obtener los valores ingresados
            String nombre = campoNombre.getText().trim();
            String apellidoPaterno = campoApellidoPaterno.getText().trim();
            String apellidoMaterno = campoApellidoMaterno.getText().trim();
            String departamento = (String) comboDepartamento.getSelectedItem();
            String antiguedadSeleccionada = (String) comboAntiguedad.getSelectedItem();
            int dias = calcularVacaciones(departamento, antiguedadSeleccionada);

            //Validar campos vacíos
            if (nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, complete todos los campos de texto.",
                        "Campos Vacíos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Formatear el resultado y mostrarlo en el JTextArea
            String resultado = String.format(
                    "El trabajador %s %s %s\nquien labora en %s con %s\nrecibe %d días de vacaciones.",
                    nombre, apellidoPaterno, apellidoMaterno, departamento, antiguedadSeleccionada, dias
            );
            areaResultado.setText(resultado);
        } else if (e.getSource() == botonLimpiar) {
            //Limpiar los campos de texto y restablecer los ComboBox y el TextArea
            campoNombre.setText("");
            campoApellidoPaterno.setText("");
            campoApellidoMaterno.setText("");
            comboDepartamento.setSelectedIndex(0);
            comboAntiguedad.setSelectedIndex(0);
            areaResultado.setText("");
        } else if (e.getSource() == botonRegresar) {
            Bienvenida bienvenida = new Bienvenida();
            bienvenida.setVisible(true);
            this.setVisible(false);
        }
    }

    //Método para calcular los días de vacaciones
    public int calcularVacaciones(String departamento, String antiguedad) {
        int dias = 0;

        switch (departamento) {
            case "Atención al Cliente":
                switch (antiguedad) {
                    case "1 año de servicio":
                        dias = 6;
                        break;
                    case "2 a 6 años de servicio":
                        dias = 14;
                        break;
                    case "7 años o más de servicio":
                        dias = 20;
                        break;
                }
                break;
            case "Logística":
                switch (antiguedad) {
                    case "1 año de servicio":
                        dias = 7;
                        break;
                    case "2 a 6 años de servicio":
                        dias = 15;
                        break;
                    case "7 años o más de servicio":
                        dias = 22;
                        break;
                }
                break;
            case "Gerencia":
                switch (antiguedad) {
                    case "1 año de servicio":
                        dias = 10;
                        break;
                    case "2 a 6 años de servicio":
                        dias = 20;
                        break;
                    case "7 años o más de servicio":
                        dias = 30;
                        break;
                }
                break;
        }

        return dias;
    }

}
