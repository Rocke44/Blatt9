import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Graphic {

    private final JFrame frame;
    private final JPanel panel;
    private ArrayList<Figure> figures = new ArrayList<>();

    @SuppressWarnings("serial")
    public Graphic(int width, int height) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (Figure figure : figures) {
                    figure.paint(g);
                }
            }
        };
        panel.setPreferredSize(new Dimension(width, height));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void update(int delay) {
        // frame.repaint();
        try {
            Thread.sleep(delay);
            SwingUtilities.invokeAndWait(() -> {
                panel.paint(panel.getGraphics());
            });
        } catch (InterruptedException | InvocationTargetException e) {
        }

    }

    public void add(Figure f) {
        figures.add(f);
    }

    public void remove(Figure f) {
        figures.remove(f);
    }
}

abstract class Figure {

    protected ArrayList<Point> points = new ArrayList<>();

    public void paint(Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x,
                    points.get(i + 1).y);
        }
    }

    public void shift(int x, int y) {
        for (Point a : points) {
            a.translate(x, y);
        }
    }
}
