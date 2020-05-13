/*
重写Panel类，让Panel能够自定义背景
Copywrite@郑茂基 2020-2020
 */

package UI;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    Dimension d;
    Image image;

    public ImagePanel(Dimension d, Image image) {
        super();
        this.d = d;
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
        //repaint();
    }
}
