package Problema;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Interfaz extends JFrame {

    private static final Color COLOR_FONDO        = new Color(45, 45, 45);
    private static final Color COLOR_PANEL        = new Color(60, 60, 60);
    private static final Color COLOR_ENCABEZADO   = new Color(35, 35, 35);
    private static final Color COLOR_COLA_HEADER  = new Color(30, 30, 30);   // negro oscuro uniforme
    private static final Color COLOR_COLA_BORDE   = new Color(85, 85, 85);   // borde gris para los 3
    private static final Color COLOR_TEXTO        = Color.WHITE;
    private static final Color COLOR_TEXTO_GRIS   = new Color(180, 180, 180);
    private static final Color COLOR_BOTON        = new Color(80, 80, 80);
    private static final Color COLOR_BOTON_HOVER  = new Color(100, 100, 100);

    private Cola Cola3raEdad = new Cola();
    private Cola ColaVip     = new Cola();
    private Cola ColaNormal  = new Cola();
    private String ultimoTipo = "";
    private int consecutivo   = 0;

    private JTextField nombreField;
    private JComboBox<String> tipoComboBox;
    private JButton botonAgregar, botonAtender;

    private DefaultListModel<String> modeloEdad   = new DefaultListModel<>();
    private DefaultListModel<String> modeloVip    = new DefaultListModel<>();
    private DefaultListModel<String> modeloNormal = new DefaultListModel<>();

    private JList<String> listaEdad, listaVip, listaNormal;
    private JLabel labelEstado;

    public Interfaz() {
        setTitle("Sistema de Tickets");
        setSize(800, 550);
        setMinimumSize(new Dimension(700, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COLOR_FONDO);

        add(crearPanelEntrada(), BorderLayout.NORTH);
        add(crearPanelColas(),   BorderLayout.CENTER);
        add(crearPanelEstado(),  BorderLayout.SOUTH);

        configurarAcciones();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ── Panel superior ────────────────────────────────────────────────────────
    private JPanel crearPanelEntrada() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(COLOR_ENCABEZADO);
        panel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(90, 90, 90)));

        JLabel titulo = new JLabel("Sistema de Atención de Tickets");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 15));
        titulo.setForeground(COLOR_TEXTO);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(COLOR_TEXTO_GRIS);
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 13));

        nombreField = new JTextField(16);
        estilizarCampo(nombreField);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setForeground(COLOR_TEXTO_GRIS);
        lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 13));

        tipoComboBox = new JComboBox<>(new String[]{"3ra Edad", "VIP", "Normal"});
        estilizarCombo(tipoComboBox);

        botonAgregar = crearBoton("+ Agregar");
        botonAtender = crearBoton("Atender Siguiente");

        JPanel fila1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        fila1.setOpaque(false);
        fila1.add(titulo);

        JPanel fila2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        fila2.setOpaque(false);
        fila2.add(lblNombre);
        fila2.add(nombreField);
        fila2.add(lblTipo);
        fila2.add(tipoComboBox);
        fila2.add(botonAgregar);
        fila2.add(botonAtender);

        fila1.setAlignmentX(CENTER_ALIGNMENT);
        fila2.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(8));
        panel.add(fila1);
        panel.add(Box.createVerticalStrut(8));
        panel.add(fila2);
        panel.add(Box.createVerticalStrut(8));

        return panel;
    }

    // ── Panel de las 3 colas ──────────────────────────────────────────────────
    private JPanel crearPanelColas() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 8, 0));
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(new EmptyBorder(12, 12, 8, 12));

        listaEdad   = crearLista(modeloEdad);
        listaVip    = crearLista(modeloVip);
        listaNormal = crearLista(modeloNormal);

        // Los 3 usan el mismo color oscuro, sin acento de color
        panel.add(crearPanelCola("3ra Edad", listaEdad));
        panel.add(crearPanelCola("VIP",      listaVip));
        panel.add(crearPanelCola("Normal",   listaNormal));

        return panel;
    }

    private JPanel crearPanelCola(String titulo, JList<String> lista) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COLOR_PANEL);
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_COLA_BORDE, 1, true),
            new EmptyBorder(0, 0, 8, 0)
        ));

        // Encabezado negro oscuro, título centrado
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(COLOR_COLA_HEADER);
        encabezado.setBorder(new EmptyBorder(7, 12, 7, 12));

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setForeground(COLOR_TEXTO);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 13));

        encabezado.add(lblTitulo, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setBackground(COLOR_PANEL);
        scroll.getViewport().setBackground(COLOR_PANEL);
        scroll.getVerticalScrollBar().setBackground(COLOR_PANEL);

        panel.add(encabezado, BorderLayout.NORTH);
        panel.add(scroll,     BorderLayout.CENTER);

        return panel;
    }

    // ── Barra de estado ───────────────────────────────────────────────────────
    private JPanel crearPanelEstado() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 6));
        panel.setBackground(COLOR_ENCABEZADO);
        panel.setBorder(new MatteBorder(1, 0, 0, 0, new Color(90, 90, 90)));

        labelEstado = new JLabel("Listo.");
        labelEstado.setForeground(COLOR_TEXTO_GRIS);
        labelEstado.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panel.add(labelEstado);

        return panel;
    }

    // ── Lista estilizada ──────────────────────────────────────────────────────
    private JList<String> crearLista(DefaultListModel<String> modelo) {
        JList<String> lista = new JList<>(modelo);
        lista.setBackground(COLOR_PANEL);
        lista.setForeground(COLOR_TEXTO);
        lista.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lista.setSelectionBackground(new Color(90, 90, 90));
        lista.setSelectionForeground(Color.WHITE);
        lista.setBorder(new EmptyBorder(4, 8, 4, 8));
        lista.setFixedCellHeight(24);
        return lista;
    }

    // ── Lógica de botones ─────────────────────────────────────────────────────
    private void configurarAcciones() {

        botonAgregar.addActionListener(e -> {
            String nombre = nombreField.getText().trim();

            // FIX 1: ventana emergente si el nombre está vacío
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar un nombre antes de agregar el ticket.",
                    "Error - Nombre requerido",
                    JOptionPane.ERROR_MESSAGE
                );
                nombreField.requestFocus();
                return;
            }

            String tipo = (String) tipoComboBox.getSelectedItem();
            Ticket nuevoTicket = new Ticket(nombre, tipo);
            String entrada = nombre + "  [" + tipo + "]";

            if (tipo.equals("3ra Edad")) {
                Cola3raEdad.enqueue(nuevoTicket);
                modeloEdad.addElement(entrada);
            } else if (tipo.equals("VIP")) {
                ColaVip.enqueue(nuevoTicket);
                modeloVip.addElement(entrada);
            } else {
                ColaNormal.enqueue(nuevoTicket);
                modeloNormal.addElement(entrada);
            }

            setEstado("Ticket agregado: " + nombre + " (" + tipo + ")");
            nombreField.setText("");
            nombreField.requestFocus();
        });

        botonAtender.addActionListener(e -> {
            // FIX 2: dos intentos — el segundo resetea los contadores si el
            // primero falla por haber agotado los límites consecutivos de todos
            // los tipos, aunque aún haya tickets en alguna cola.
            Ticket atendido = null;
            DefaultListModel<String> modeloAtendido = null;

            for (int intento = 0; intento < 2 && atendido == null; intento++) {

                if (intento == 1) {          // reset y segundo intento
                    ultimoTipo  = "";
                    consecutivo = 0;
                }

                if (!Cola3raEdad.isEmpty() && (!ultimoTipo.equals("3ra Edad") || consecutivo < 4)) {
                    atendido       = Cola3raEdad.dequeue();
                    modeloAtendido = modeloEdad;
                    // FIX 2b: actualizar ANTES de reasignar ultimoTipo
                    consecutivo    = ultimoTipo.equals("3ra Edad") ? consecutivo + 1 : 1;
                    ultimoTipo     = "3ra Edad";

                } else if (!ColaVip.isEmpty() && (!ultimoTipo.equals("VIP") || consecutivo < 2)) {
                    atendido       = ColaVip.dequeue();
                    modeloAtendido = modeloVip;
                    consecutivo    = ultimoTipo.equals("VIP") ? consecutivo + 1 : 1;
                    ultimoTipo     = "VIP";

                } else if (!ColaNormal.isEmpty() && (!ultimoTipo.equals("Normal") || consecutivo < 3)) {
                    atendido       = ColaNormal.dequeue();
                    modeloAtendido = modeloNormal;
                    consecutivo    = ultimoTipo.equals("Normal") ? consecutivo + 1 : 1;
                    ultimoTipo     = "Normal";
                }
            }

            if (atendido != null && modeloAtendido != null) {
                if (!modeloAtendido.isEmpty()) modeloAtendido.remove(0);
                setEstado("Atendiendo: " + atendido.getNombre() + " (" + atendido.getTipo() + ")");
            } else {
                setEstado("No hay tickets disponibles en este momento.");
            }
        });
    }

    private void setEstado(String mensaje) {
        labelEstado.setText(mensaje);
    }

    // ── Helpers de estilo ─────────────────────────────────────────────────────
    private void estilizarCampo(JTextField campo) {
        campo.setBackground(new Color(70, 70, 70));
        campo.setForeground(COLOR_TEXTO);
        campo.setCaretColor(COLOR_TEXTO);
        campo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        campo.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(100, 100, 100)),
            new EmptyBorder(4, 8, 4, 8)
        ));
    }

    private void estilizarCombo(JComboBox<String> combo) {
        combo.setBackground(new Color(70, 70, 70));
        combo.setForeground(COLOR_TEXTO);
        combo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        combo.setBorder(new LineBorder(new Color(100, 100, 100)));
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(COLOR_BOTON);
        btn.setForeground(COLOR_TEXTO);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(110, 110, 110)),
            new EmptyBorder(5, 14, 5, 14)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { btn.setBackground(COLOR_BOTON_HOVER); }
            public void mouseExited(java.awt.event.MouseEvent evt)  { btn.setBackground(COLOR_BOTON); }
        });
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interfaz::new);
    }
}