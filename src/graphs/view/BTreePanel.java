package graphs.view;

import graphs.BasicTree;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BTreePanel<V> extends JPanel {

    public BTreePanel(boolean showGuides, Color background, Color foreground, BasicTree<V> bt) {
        this.showGuides = showGuides;
        this.background = background;
        this.foreground = foreground;
        this.scaleFactor = 1f;
        this.bt = bt;

        setup();
    }

    public BTreePanel(Color background, Color foreground, BasicTree<V> bt) {
        this(false, background, foreground, bt);
    }

    private void setup() {
        setBackground(background);
    }

    public BTreePanel(BasicTree bt) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);

        throw new UnsupportedOperationException();
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
        repaint();
        revalidate();
    }

    private boolean showGuides;
    private Color background;
    private Color foreground;
    private float scaleFactor;

    private BasicTree<V> bt;

}
