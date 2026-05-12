import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;
import java.awt.Desktop;

public class gameplay extends JPanel implements ActionListener {

    // Timers
    private javax.swing.Timer gameTimer;
    private javax.swing.Timer chartTimer;

    // Matriz para representar el tablero (20 filas x 4 columnas)
    private final int[][] matrizTablero = new int[20][4];
    private final int HIT_ZONE_Y = 800;
    private final int HIT_ZONE_X = 1000;
    private final int HIT_ZONE_MARGIN = 45;
    private final Map<String, Image> imagenesFlechas = new HashMap<>();
    private final Map<String, Integer> columnaPorTipo = new HashMap<>();

    // Imágenes
    private Image fondo;
    private Image kanyeIdle, kanyeLeft, kanyeRight, kanyeUp, kanyeDown;
    private String kanyeState = "idle";
    private int kanyeX = 350, kanyeY = 650;

    // Parámetros del nivel
    private final String audioFile;
    private int vida;
    private final int songDurationMs;
    private final int velocidadFlechas;

    // Chart generado
    private final java.util.List<ChartEvent> chart = new ArrayList<>();
    private int chartIndex = 0;

    // Estadísticas
    private int misses = 0;
    private int nices = 0;
    private int consecNices = 0;
    private boolean perfectRun = true;

    // Audio
    private Clip clip;
    private long songStartTime = 0L;

    // Estado final
    private volatile boolean ended = false;

    // Variables para control de movimiento fluido
    private double[] posicionesYFlechas = new double[20 * 4];
    private int[] posicionesXFlechas = new int[20 * 4];

    public gameplay(String audioFile, int vidaInicial, int songDurationMs, int velocidadFlechas) {
        this.audioFile = audioFile;
        this.vida = vidaInicial;
        this.songDurationMs = songDurationMs;
        this.velocidadFlechas = velocidadFlechas;

        // Inicializar matriz con ceros (vacío)
        for (int i = 0; i < 20; i++) {
            Arrays.fill(matrizTablero[i], 0);
        }
        
        // Inicializar posiciones
        Arrays.fill(posicionesYFlechas, -1000);
        
        // Posiciones X fijas para las columnas
        int[] posX = {HIT_ZONE_X - 150, HIT_ZONE_X - 50, HIT_ZONE_X + 50, HIT_ZONE_X + 150};
        for (int i = 0; i < 20 * 4; i++) {
            posicionesXFlechas[i] = posX[i % 4];
        }

        // Mapeo de tipos de flecha a columnas
        columnaPorTipo.put("D", 0);
        columnaPorTipo.put("F", 1);
        columnaPorTipo.put("J", 2);
        columnaPorTipo.put("K", 3);

        setFocusable(true);
        setPreferredSize(new Dimension(1900, 1000));
        setBackground(Color.darkGray);

        // Cargar recursos si están presentes
        fondo = loadImage("fondo.jpeg");
        imagenesFlechas.put("D", loadImage("left.png"));
        imagenesFlechas.put("F", loadImage("down.png"));
        imagenesFlechas.put("J", loadImage("up.png"));
        imagenesFlechas.put("K", loadImage("right.png"));

        kanyeIdle  = loadImage("kanye_idle.png");
        kanyeLeft  = loadImage("kanye_left.png");
        kanyeRight = loadImage("kanye_right.png");
        kanyeUp    = loadImage("kanye_up.png");
        kanyeDown  = loadImage("kanye_down.png");

        // Bindings press/release
        bindKeyPressRelease("D", KeyEvent.VK_D);
        bindKeyPressRelease("F", KeyEvent.VK_F);
        bindKeyPressRelease("J", KeyEvent.VK_J);
        bindKeyPressRelease("K", KeyEvent.VK_K);

        // Generar chart según BPM detectado por nombre de audio
        int bpm = detectBpmForAudio(audioFile);
        generateBeatGridChart(bpm, songDurationMs, velocidadFlechas);

        System.out.println("BPM detected: " + bpm + " | chart events: " + chart.size());
        System.out.println("Velocidad de flechas configurada: " + this.velocidadFlechas);

        // Iniciar audio
        startAudio();

        // Inicializar timers
        initTimers();

        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    private void bindKeyPressRelease(String name, int keyCode) {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0, false), name + "_PRESS");
        getActionMap().put(name + "_PRESS", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) { handleKeyPress(name); }
        });
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0, true), name + "_RELEASE");
        getActionMap().put(name + "_RELEASE", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) { kanyeState = "idle"; repaint(); }
        });
    }

    private void initTimers() {
        gameTimer = new javax.swing.Timer(16, this);
        gameTimer.setRepeats(true);
        gameTimer.start();

        chartTimer = new javax.swing.Timer(80, e -> {
            if (ended) { ((javax.swing.Timer)e.getSource()).stop(); return; }
            spawnFromChart();
            if (songFinished()) { ((javax.swing.Timer)e.getSource()).stop(); endBySongFinish(); }
        });
        chartTimer.setRepeats(true);
        chartTimer.start();
    }

    private Image loadImage(String path) {
        try {
            File f = new File(path);
            if (!f.exists()) return null;
            return new ImageIcon(path).getImage();
        } catch (Exception ex) { return null; }
    }

    private int detectBpmForAudio(String audio) {
        String a = audio == null ? "" : audio.toLowerCase();
        if (a.contains("happylos4") || a.contains("felices") || a.contains("happy")) return 94;
        if (a.contains("normal") || a.contains("raingurl") || a.contains("yaeji")) return 128;
        if (a.contains("dificil") || a.contains("latino") || a.contains("raffa")) return 125;
        return 120;
    }

    private void generateBeatGridChart(int bpm, int durationMs, int velocidad) {
        chart.clear();
        chartIndex = 0;
        double beatMs = 60000.0 / bpm;
        long t = 500;
        long duration = durationMs > 0 ? durationMs : 120000;
        Random rnd = new Random(42);

        // Factores de densidad según dificultad
        double densidadFacil = 0.5;
        double densidadNormal = 1.5;
        double densidadDificil = 5.0;

        double factorDensidad;
        if (velocidad == 7) {
            factorDensidad = densidadFacil;
        } else if (velocidad == 12) {
            factorDensidad = densidadNormal;
        } else {
            factorDensidad = densidadDificil;
        }

        while (t < duration - 500) {
            // Nota principal
            if (rnd.nextDouble() < factorDensidad) {
                chart.add(new ChartEvent(t, pickFrom(new String[]{"D","F","J","K"}, rnd)));
            }
            
            // Subdivisión con probabilidad ajustada por dificultad
            double subdivisionChance;
            if (velocidad == 7) {
                subdivisionChance = 0.06;
            } else if (velocidad == 12) {
                subdivisionChance = 0.12;
            } else {
                subdivisionChance = 0.25;
            }
            
            if (rnd.nextDouble() < subdivisionChance * factorDensidad) {
                chart.add(new ChartEvent(t + (long)(beatMs / 2.0), pickFrom(new String[]{"D","F","J","K"}, rnd)));
                
                if (velocidad > 15 && rnd.nextDouble() < 0.3) {
                    chart.add(new ChartEvent(t + (long)(beatMs * 0.75), pickFrom(new String[]{"D","F","J","K"}, rnd)));
                }
            }
            
            double skipChance = velocidad > 15 ? 0.02 : 0.08;
            t += (long)(beatMs * (rnd.nextDouble() < skipChance ? 2.0 : 1.0));
        }
        chart.sort(Comparator.comparingLong(c -> c.time));
    }

    private String pickFrom(String[] arr, Random rnd) { return arr[rnd.nextInt(arr.length)]; }

    private volatile boolean songEndedByClip = false;
    
    private void startAudio() {
        try {
            File audio = new File(audioFile);
            if (!audio.exists()) {
                System.err.println("Audio not found: " + audioFile + " — sincronizando por tiempo interno");
                songStartTime = System.currentTimeMillis();
                return;
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(audio);
            clip = AudioSystem.getClip();
            clip.open(ais);

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        songEndedByClip = true;
                        try {
                            if (clip != null) {
                                clip.stop();
                                clip.close();
                            }
                        } catch (Exception ex) { ex.printStackTrace(); }
                        SwingUtilities.invokeLater(() -> {
                            if (!ended) endBySongFinish();
                        });
                    }
                }
            });

            clip.start();
            songStartTime = System.currentTimeMillis();
        } catch (Exception ex) {
            ex.printStackTrace();
            songStartTime = System.currentTimeMillis();
        }
    }

    private boolean songFinished() {
        if (songEndedByClip) return true;
        if (songStartTime == 0L) return false;
        long elapsed = System.currentTimeMillis() - songStartTime;
        if (songDurationMs > 0 && elapsed >= songDurationMs) return true;
        if (clip != null && !clip.isActive()) return true;
        return false;
    }

    private void spawnFromChart() {
        if (chart.isEmpty() || chartIndex >= chart.size() || songStartTime == 0L) return;
        long elapsed = System.currentTimeMillis() - songStartTime;
        while (chartIndex < chart.size() && chart.get(chartIndex).time <= elapsed) {
            ChartEvent ev = chart.get(chartIndex);
            spawnChartFlecha(ev.tipo);
            chartIndex++;
        }
    }

    private void spawnChartFlecha(String tipo) {
        if (ended) return;
        
        int columna = columnaPorTipo.get(tipo);
        for (int fila = 0; fila < 20; fila++) {
            if (matrizTablero[fila][columna] == 0) {
                matrizTablero[fila][columna] = 1;
                posicionesYFlechas[fila * 4 + columna] = -40;
                break;
            }
        }
    }

    private void handleKeyPress(String name) {
        if (ended) return;
        switch (name) {
            case "D": kanyeState = "left"; break;
            case "F": kanyeState = "down"; break;
            case "J": kanyeState = "up"; break;
            case "K": kanyeState = "right"; break;
        }

        boolean hit = false;
        int columna = columnaPorTipo.get(name);
        
        FlechaMasCercana mejorFlecha = encontrarFlechaMasCercana(columna);
        
        if (mejorFlecha != null && mejorFlecha.distancia <= HIT_ZONE_MARGIN) {
            matrizTablero[mejorFlecha.fila][mejorFlecha.columna] = 0;
            posicionesYFlechas[mejorFlecha.fila * 4 + mejorFlecha.columna] = -1000;
            hit = true;
            nices++;
            consecNices++;
            if (consecNices >= 5) { 
                if (vida < 25) {
                    vida += 1; 
                }
                consecNices = 0; 
            }
        }

        if (!hit) {
            consecNices = 0;
            perfectRun = false;
            vida -= 1;
            if (vida <= 0) {
                endByLifeZero();
                return;
            }
        }
        repaint();
    }

    private FlechaMasCercana encontrarFlechaMasCercana(int columna) {
        FlechaMasCercana mejor = null;
        int mejorDistancia = Integer.MAX_VALUE;
        
        for (int fila = 0; fila < 20; fila++) {
            if (matrizTablero[fila][columna] == 1) {
                double posY = posicionesYFlechas[fila * 4 + columna];
                int distancia = (int) Math.abs(posY - HIT_ZONE_Y);
                
                if (distancia < mejorDistancia) {
                    mejorDistancia = distancia;
                    mejor = new FlechaMasCercana(fila, columna, distancia);
                }
            }
        }
        
        return mejor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ended) return;
        
        moverFlechas();
        checkMisses();
        if (vida <= 0 && !ended) { endByLifeZero(); return; }
        repaint();
    }

    private void moverFlechas() {
        double velocidadReal = velocidadFlechas * 0.5;
        
        for (int fila = 0; fila < 20; fila++) {
            for (int col = 0; col < 4; col++) {
                if (matrizTablero[fila][col] == 1) {
                    posicionesYFlechas[fila * 4 + col] += velocidadReal;
                }
            }
        }
    }

    private void checkMisses() {
        for (int fila = 0; fila < 20; fila++) {
            for (int col = 0; col < 4; col++) {
                if (matrizTablero[fila][col] == 1) {
                    double posY = posicionesYFlechas[fila * 4 + col];
                    if (posY > HIT_ZONE_Y + HIT_ZONE_MARGIN + 50) {
                        matrizTablero[fila][col] = 0;
                        posicionesYFlechas[fila * 4 + col] = -1000;
                        misses++;
                        consecNices = 0;
                        perfectRun = false;
                        vida -= 3;
                        if (vida <= 0) return;
                    }
                }
            }
        }
    }

    private synchronized void endByLifeZero() {
        if (ended) return;
        ended = true;
        stopAll();
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, "bro respeta el ritmo");
            Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
        });
    }

    private synchronized void endBySongFinish() {
        if (ended) return;
        ended = true;
        stopAll();
        final int vidaFinal = vida;
        SwingUtilities.invokeLater(() -> {
            if (misses == 0) {
                JOptionPane.showMessageDialog(null, "!!!!!");
                JOptionPane.showMessageDialog(null, "wow...");
                JOptionPane.showMessageDialog(null, "tu...");
                JOptionPane.showMessageDialog(null, "Lo conseguiste!! :D");
                JOptionPane.showMessageDialog(null, "Toma tu sorpresa!");
                try {
                    File video = new File("surprise.mp4");
                    if (video.exists()) Desktop.getDesktop().open(video);
                    else JOptionPane.showMessageDialog(null, "No se encontró surprise.mp4 en el directorio");
                } catch (Exception ex) { ex.printStackTrace(); }
            } else if (vidaFinal >= 1) {
                JOptionPane.showMessageDialog(null, "GG eres un maestro del ritmo!");
            }
            Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
        });
    }

    private void stopAll() {
        try { if (clip != null) { if (clip.isRunning()) clip.stop(); clip.close(); clip = null; } } catch (Exception ex){ ex.printStackTrace(); }
        try { if (gameTimer != null && gameTimer.isRunning()) gameTimer.stop(); } catch (Exception ex){ ex.printStackTrace(); }
        try { if (chartTimer != null && chartTimer.isRunning()) chartTimer.stop(); } catch (Exception ex){ ex.printStackTrace(); }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

        Image kanyeImg = kanyeIdle;
        switch (kanyeState) {
            case "left": kanyeImg = kanyeLeft; break;
            case "right": kanyeImg = kanyeRight; break;
            case "up": kanyeImg = kanyeUp; break;
            case "down": kanyeImg = kanyeDown; break;
        }
        if (kanyeImg != null) g.drawImage(kanyeImg, kanyeX, kanyeY, 200, 200, this);

        Image zona = loadImage("arrows.png");
        if (zona != null) g.drawImage(zona, HIT_ZONE_X - 250, HIT_ZONE_Y - 150, 500, 500, this);

        dibujarFlechasDesdeMatriz(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        g.drawString("Vida: " + vida, 20, 30);
        g.drawString("Misses: " + misses, 20, 60);
        g.drawString("Nices: " + nices, 20, 90);
    }

    private void dibujarFlechasDesdeMatriz(Graphics g) {
        String[] tipos = {"D", "F", "J", "K"};
        
        for (int fila = 0; fila < 20; fila++) {
            for (int col = 0; col < 4; col++) {
                if (matrizTablero[fila][col] == 1) {
                    double posY = posicionesYFlechas[fila * 4 + col];
                    int posX = posicionesXFlechas[fila * 4 + col];
                    String tipo = tipos[col];
                    Image img = imagenesFlechas.get(tipo);
                    if (img != null) {
                        g.drawImage(img, posX - 45, (int)posY - 20, 70, 70, this);
                    } else {
                        g.setColor(Color.WHITE);
                        g.fillOval(posX - 10, (int)posY - 10, 20, 20);
                    }
                }
            }
        }
    }

    // Clases internas auxiliares
    private static class ChartEvent { 
        long time; 
        String tipo; 
        ChartEvent(long time, String tipo){
            this.time=time;
            this.tipo=tipo;
        } 
    }
    
    private static class FlechaMasCercana {
        int fila;
        int columna;
        int distancia;
        
        FlechaMasCercana(int fila, int columna, int distancia) {
            this.fila = fila;
            this.columna = columna;
            this.distancia = distancia;
        }
    }
}