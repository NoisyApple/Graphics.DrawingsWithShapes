package com.noisyapple;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Drawing extends JFrame {

  int width = 800;
  int height = 500;

  public Drawing() {

    setSize(width, height);

    setTitle("Drawings");
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(new CustomCanvas());
    pack();
    setLocationRelativeTo(null);
  }

  class CustomCanvas extends JPanel {

    protected void paintComponent(Graphics g) {

      Graphics2D g2d = (Graphics2D) g;
      AffineTransform transform = g2d.getTransform();

      int gap = 25;
      int rows = 2;
      int columns = 3;
      int borderRadius = 25;

      int containerWidth = ((width - gap * 2) - (gap * (columns + 1))) / columns;
      int containerHeight = ((height - gap * 2) - (gap * (rows + 1))) / rows;

      // Antialiasing ON.
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // Background.
      g2d.setColor(Color.decode("#333333"));
      g2d.fillRect(0, 0, width, height);

      // Main container.
      g2d.setStroke(new BasicStroke(5));
      g2d.setColor(Color.decode("#DDDDDD"));
      g2d.drawRoundRect(gap, gap, width - (gap * 2), height - (gap * 2), borderRadius, borderRadius);

      // Inner containers.
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          g2d.drawRoundRect(gap + (j * containerWidth + (gap * (j + 1))), gap + (i * containerHeight + (gap * (i + 1))),
              containerWidth, containerHeight, borderRadius, borderRadius);
        }
      }

      g2d.setStroke(new BasicStroke(3));

      // Lines.
      g2d.setColor(Color.decode("#BBDDAA"));
      g2d.drawLine(containerWidth / 2 + 50, 50 + 25, 50 + 25 + 10, 50 + 60);
      g2d.drawLine(containerWidth / 2 + 50, 50 + 25, 50 - 25 - 10 + containerWidth, 50 + 60);
      g2d.drawLine(50 + 25 + 10, 50 + 60, 50 - 25 - 10 + containerWidth, 50 + 60);
      g2d.drawLine(50 + 25 + 10, 50 + 60, 50 + 25 + 10, 50 + 120);
      g2d.drawLine(50 - 25 - 10 + containerWidth, 50 + 60, 50 - 25 - 10 + containerWidth, 50 + 120);
      g2d.drawLine(50 + 25 + 10, 50 + 120, 50 - 25 - 10 + containerWidth, 50 + 120);
      g2d.drawLine(50 + 25 + 35, 50 + 120, 50 + 25 + 35, 50 + 80);
      g2d.drawLine(50 + 25 + 65, 50 + 120, 50 + 25 + 65, 50 + 80);
      g2d.drawLine(50 + 25 + 35, 50 + 80, 50 + 25 + 65, 50 + 80);
      g2d.drawLine(50 + 25 + 35, 50 + 120, 50 + 25 + 35 - 25, 50 + 150);
      g2d.drawLine(50 + 25 + 65, 50 + 120, 50 + 25 + 65 - 25, 50 + 150);
      g2d.drawString("Dibujando Lineas.", 50 + 55, 50 + 25 + 150);

      // Rectagles.
      g2d.translate(((containerWidth + gap) * 1), ((containerHeight + gap) * 0));
      g2d.setColor(Color.decode("#AABBDD"));
      g2d.drawRect(containerWidth / 2 + 50 - 10 - 40 - 20, 50 + 105, 20, 120 - 80);
      g2d.drawRect(containerWidth / 2 + 50 - 10 - 20 - 10, 50 + 85, 20, 120 - 60);
      g2d.drawRect(containerWidth / 2 + 50 - 10, 50 + 65, 20, 120 - 40);
      g2d.drawRect(containerWidth / 2 + 50 - 10 + 20 + 10, 50 + 45, 20, 120 - 20);
      g2d.drawRect(containerWidth / 2 + 50 - 10 + 40 + 20, 50 + 25, 20, 120);
      g2d.drawString("Dibujando Rectangulos.", 50 + 40, 50 + 25 + 150);

      g2d.setTransform(transform);

      // Ovals with rectangles.
      g2d.translate(((containerWidth + gap) * 2), ((containerHeight + gap) * 0));
      g2d.setColor(Color.decode("#BBAADD"));
      g2d.drawRoundRect(containerWidth / 2 + 50 - 20, 50 + 25, 40, 120, 100, 150);
      g2d.drawRoundRect(containerWidth / 2 + 50 - 80, 50 + 65, 160, 40, 150, 150);
      g2d.drawRoundRect(containerWidth / 2 + 50 - 40, 50 + 35, 80, 45, 150, 150);
      g2d.drawString("Dibujando Ovalos con Rectangulos.", 50 + 10, 50 + 25 + 150);

      g2d.setTransform(transform);

      // Circles.
      g2d.translate(((containerWidth + gap) * 0), ((containerHeight + gap) * 1));
      g2d.setColor(Color.decode("#FFFFAA"));
      g2d.drawOval(containerWidth / 2 + 50 - 55, 50 + 30, 110, 110);
      g2d.drawOval(containerWidth / 2 + 50 - 20, 50 + 85, 40, 40);
      g2d.drawOval(containerWidth / 2 + 50 - 10 - 20, 50 + 55, 20, 20);
      g2d.fillOval(containerWidth / 2 + 50 - 3 - 20, 50 + 60, 6, 6);
      g2d.drawOval(containerWidth / 2 + 50 - 10 + 20, 50 + 55, 20, 20);
      g2d.fillOval(containerWidth / 2 + 50 - 3 + 20, 50 + 60, 6, 6);
      g2d.drawString("Dibujando Circulos.", 50 + 55, 50 + 25 + 150);

      g2d.setTransform(transform);

      // Ovals with circles.
      g2d.translate(((containerWidth + gap) * 1), ((containerHeight + gap) * 1));
      g2d.setColor(Color.decode("#FFAAFF"));
      g2d.drawOval(containerWidth / 2 + 50 - 20, 50 + 25, 40, 120);
      g2d.drawOval(containerWidth / 2 + 50 - 80, 50 + 65, 160, 40);
      g2d.drawOval(containerWidth / 2 + 50 - 40, 50 + 35, 80, 45);
      g2d.drawString("Dibujando Ovalos con circulos.", 50 + 25, 50 + 25 + 150);

      g2d.setTransform(transform);

      // Triangles.
      g2d.translate(((containerWidth + gap) * 2), ((containerHeight + gap) * 1));
      g2d.setColor(Color.decode("#FFB397"));
      drawTriangle(g2d, containerWidth / 2 + 60, 50 + 80, 50 + 25 + 10, 50 + 120, 50 - 25 - 10 + containerWidth,
          50 + 120);
      drawTriangle(g2d, containerWidth / 2 + 60, 50 + 80, containerWidth / 2 + 120, 50 + 80, containerWidth / 2 + 60,
          50 + 60);
      drawTriangle(g2d, 50 + 25, 50 + 80, 50 + 25, 50 + 35, 50 + 25 + 35, 50 + 80);
      g2d.drawString("Dibujando Triangulos.", 50 + 45, 50 + 25 + 150);

    }

    public Dimension getPreferredSize() {
      return new Dimension(width, height);
    }

    public void drawTriangle(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3) {
      int[] xPoints = { x1, x2, x3 };
      int[] yPoints = { y1, y2, y3 };
      g2d.drawPolygon(xPoints, yPoints, 3);
    }

  }

}
