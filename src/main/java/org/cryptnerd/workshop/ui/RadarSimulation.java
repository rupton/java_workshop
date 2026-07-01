package org.cryptnerd.workshop.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadarSimulation extends JPanel implements ActionListener {
    // Simulation configurations
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int CENTER_X = WIDTH / 2;
    private static final int CENTER_Y = HEIGHT / 2;
    private static final int MAX_RADIUS = 360;

    private double sweepAngle = 0; // Current angle of the radar beam
    private final double sweepSpeed = 1.5; // Degrees per frame
    private final List<Target> targets = new ArrayList<>();
    private final Random random = new Random();

    public RadarSimulation() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Generate mock radar targets (Aircraft)
        targets.add(new Target("TGT-01", 500, 300, -0.5, 0.2));
        targets.add(new Target("TGT-02", 300, 500, 0.4, -0.4));
        targets.add(new Target("TGT-03", 250, 250, 0.2, 0.3));

        // 60 FPS Refresh rate timer
        Timer timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update radar sweep angle
        sweepAngle = (sweepAngle + sweepSpeed) % 360;

        // Update target positions and check for radar intersections
        for (Target target : targets) {
            target.move();
            target.checkRadarDetection(sweepAngle, CENTER_X, CENTER_Y);
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawGrid(g2d);
        drawTargets(g2d);
        drawSweepLine(g2d);
    }

    // Draws concentric distance rings and crosshairs
    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(new Color(0, 100, 0));
        for (int r = 100; r <= MAX_RADIUS; r += 100) {
            g2d.drawOval(CENTER_X - r, CENTER_Y - r, r * 2, r * 2);
        }
        g2d.drawLine(CENTER_X - MAX_RADIUS, CENTER_Y, CENTER_X + MAX_RADIUS, CENTER_Y);
        g2d.drawLine(CENTER_X, CENTER_Y - MAX_RADIUS, CENTER_X, CENTER_Y + MAX_RADIUS);
    }

    // Draws the active rotating radar sweep line
    private void drawSweepLine(Graphics2D g2d) {
        double rad = Math.toRadians(sweepAngle);
        int endX = (int) (CENTER_X + MAX_RADIUS * Math.cos(rad));
        int endY = (int) (CENTER_Y + MAX_RADIUS * Math.sin(rad));

        g2d.setColor(new Color(0, 255, 0, 180));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(CENTER_X, CENTER_Y, endX, endY);
    }

    // Draws detected targets and updates their visual fade over time
    private void drawTargets(Graphics2D g2d) {
        for (Target target : targets) {
            if (target.intensity > 0) {
                // Color fades out based on time elapsed since the last radar sweep ping
                g2d.setColor(new Color(0, 255, 0, (int) (target.intensity * 255)));
                g2d.fillOval((int) target.x - 5, (int) target.y - 5, 10, 10);
                
                // Render metadata string next to target
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 11));
                g2d.drawString(target.id, (int) target.x + 8, (int) target.y - 5);
            }
        }
    }

    // Inner class representing flight targets
    private static class Target {
        String id;
        double x, y;
        double vx, vy;
        double intensity = 0; // "Blip" brightness (0.0 to 1.0)

        Target(String id, double x, double y, double vx, double vy) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
        }

        void move() {
            x += vx;
            y += vy;
            // Naturally fade out the target return signal over time
            if (intensity > 0) {
                intensity -= 0.003; 
            }
        }

        // Trigonometric assessment: does the sweeping line cross the target position?
        void checkRadarDetection(double currentSweepAngle, int cx, int cy) {
            double dx = x - cx;
            double dy = y - cy;
            double targetAngle = Math.toDegrees(Math.atan2(dy, dx));
            if (targetAngle < 0) targetAngle += 360;

            // If the sweep line passes close to the target coordinates, trigger a "ping"
            if (Math.abs(currentSweepAngle - targetAngle) < 2.0) {
                intensity = 1.0; 
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Traffic Control Radar Simulation");
        RadarSimulation radar = new RadarSimulation();
        frame.add(radar);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

