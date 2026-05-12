import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class brorespeta extends JFrame implements ActionListener {

    private final JButton botonStart;
    private final JButton botonSalir;
    private final JLabel titulo;
    private Font honkFont;

    public brorespeta() {
        setTitle("BRO RESPETA!");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try {
            honkFont = Font.createFont(Font.TRUETYPE_FONT,
                getClass().getResourceAsStream("/fonts/Audiowide-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(honkFont);
        } catch (Exception e) {
            honkFont = new Font("SansSerif", Font.BOLD, 40);
        }

        titulo = new JLabel("BRO RESPETA!", SwingConstants.CENTER);
        titulo.setFont(honkFont.deriveFont(Font.BOLD, 60f));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setOpaque(false);

        botonStart = new JButton("Start!");
        botonSalir = new JButton("Salir :(");

        Dimension botonSize = new Dimension(200, 40);
        botonStart.setMaximumSize(botonSize);
        botonSalir.setMaximumSize(botonSize);

        botonStart.setFont(honkFont.deriveFont(Font.PLAIN, 24f));
        botonSalir.setFont(honkFont.deriveFont(Font.PLAIN, 24f));

        botonStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonStart.addActionListener(this);
        botonSalir.addActionListener(this);

        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(botonStart);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        panelBotones.add(botonSalir);
        panelBotones.add(Box.createVerticalGlue());

        add(panelBotones, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String seleccionDif() {
        String[] choices = {"Facil", "Normal", "Dificil"};
        String input = null;
        while (input == null) {
            int resp = JOptionPane.showOptionDialog(
                this,
                "Elige la dificultad",
                "elige bro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]
            );
            if (resp >= 0 && resp < choices.length) input = choices[resp];
            else JOptionPane.showMessageDialog(this, "Tenés que elegir una dificultad para seguir");
        }
        return input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonStart) {
            String dificultad = seleccionDif();

            String audioFile;
            int vidaInicial;
            int songDurationMs;
            int velocidadFlechas; 

            switch (dificultad) {
                case "Facil":
                    audioFile = "happylos4.wav";
                    vidaInicial = 25;
                    songDurationMs = 90000;
                    velocidadFlechas = 7; 
                    break;
                case "Normal":
                    audioFile = "normal.wav";
                    vidaInicial = 20;
                    songDurationMs = 90000;
                    velocidadFlechas = 12; 
                    break;
                default:
                    audioFile = "dificil.wav";
                    vidaInicial = 10;
                    songDurationMs = 90000;
                    velocidadFlechas = 25; 
                    break;
            }

            System.out.println("Audio esperado: " + new java.io.File(audioFile).getAbsolutePath());
            System.out.println("Velocidad de flechas: " + velocidadFlechas);

            JFrame frameJuego = new JFrame("BRO RESPETA!");
            frameJuego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            
            gameplay juego = new gameplay(audioFile, vidaInicial, songDurationMs, velocidadFlechas);
            frameJuego.add(juego);
            frameJuego.pack();
            frameJuego.setLocationRelativeTo(null);
            frameJuego.setVisible(true);

            SwingUtilities.invokeLater(juego::requestFocusInWindow);
        } else if (e.getSource() == botonSalir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(brorespeta::new);
    }
}