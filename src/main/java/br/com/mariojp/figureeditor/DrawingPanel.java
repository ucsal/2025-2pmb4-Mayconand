
package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private final List<ShapeWithColor> shapes = new ArrayList<>();
    private Point startDrag = null;
    private Shape previewShape = null;
    private Color colorButon ;

    private static class ShapeWithColor {
        Shape shape;
        Color color;
        ShapeWithColor(Shape shape, Color color) {
            this.shape = shape;
            this.color = color;
        }
    }


    public void setColorButon(Color colorButon) {
        this.colorButon = colorButon;
    }

    DrawingPanel() {
        
        setBackground(Color.BLACK);
        setOpaque(true);
        setDoubleBuffered(true);



        var mouse = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startDrag = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Shape s =  currentFactory.createShape(startDrag, e.getPoint());

                startDrag = null;

                shapes.add(new ShapeWithColor(s, colorButon));
                previewShape = null;
                repaint();

            }

            @Override
            public void mouseDragged(MouseEvent e) {

               if (startDrag != null) {
                   previewShape=currentFactory.createShape(startDrag, e.getPoint());
                   repaint();
               }
            }

            private final ShapeFactory currentFactory = new ElliipseFactory();

            @Override public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && startDrag == null) {
                    Shape s =  currentFactory.createShape(startDrag, e.getPoint());
                    //return new Rectangle2D.Double(e.getPoint().x, e.getPoint().y, Math.max(DEFAULT_SIZE, 10), Math.max(DEFAULT_SIZE, 10));
                    shapes.add(new ShapeWithColor(s, colorButon));
                    repaint();
                }

            }
        };
        addMouseListener(mouse);        
        addMouseMotionListener(mouse);

    }



    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      /*  for (Shape s : shapes) {
            g2.setColor(new Color(30,144,255));
            g2.fill(s);
            g2.setColor(new Color(0,0,0,70));
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(s);
        }
*/

        for (ShapeWithColor s: shapes) {
            g2.setColor(s.color);
            g2.fill(s.shape);
            g2.setColor(s.color);
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(s.shape);
        }


        if(previewShape != null) {
            float[] dash = {10f, 5f};
            Stroke dashed = new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,10f,dash,0f);
            g2.setColor(colorButon);
            g2.setStroke(dashed);
            g2.draw(previewShape);
        }

        g2.dispose();
    }

}
