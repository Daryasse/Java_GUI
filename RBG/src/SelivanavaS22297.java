import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;

public class SelivanavaS22297 {
  public static void main(String[] args) {
    ColorSelectorFrame frame = new ColorSelectorFrame();
    frame.setVisible(true);
  }
}
class ColorSelectorFrame extends JFrame {
  private ColorSelectorPanel backgroundPanel;
  private ColorSelectorPanel foregroundPanel;
  private Drawing drawing;

  public ColorSelectorFrame() {
    super("Color Selector");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setMinimumSize(new Dimension(600, 360));
    setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

    backgroundPanel = new ColorSelectorPanel("Background");
    foregroundPanel = new ColorSelectorPanel("Foreground");
    drawing = new Drawing();

    backgroundPanel.addColorChangeListener(e -> {
      Color color = backgroundPanel.getColor();
      drawing.setBackground(color);
    });

    foregroundPanel.addColorChangeListener(e -> {
      Color color = foregroundPanel.getColor();
      drawing.setForeground(color);
    });

    add(backgroundPanel);
    add(drawing);
    add(foregroundPanel);
  }
}

class ColorChannelSliderPanel extends JPanel {
  private JSlider slider;
  private JLabel label;

  public ColorChannelSliderPanel(String title) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    Border titledBorder = BorderFactory.createTitledBorder(title);
    setBorder(titledBorder);

    slider = new JSlider(JSlider.VERTICAL, 0, 255, 255);
    label = new JLabel(Integer.toString(slider.getValue()));

    slider.addChangeListener(e -> {
      String text = Integer.toString(slider.getValue());
      label.setText(text);
    });

    add(slider);
    add(label);
  }

  public int getValue() {
    return slider.getValue();
  }

  public void addSliderChaneListener(ChangeListener listener) {
    slider.addChangeListener(listener);
  }
}

class ColorSelectorPanel extends JPanel {
  private ColorChannelSliderPanel sliderR;
  private ColorChannelSliderPanel sliderG;
  private ColorChannelSliderPanel sliderB;

  private JLabel hexLabel;

  public ColorSelectorPanel(String title) {
    setMaximumSize(new Dimension(200, Integer.MAX_VALUE));
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    TitledBorder titledBorder = BorderFactory.createTitledBorder(title);
    titledBorder.setTitleJustification(TitledBorder.CENTER);
    setBorder(titledBorder);

    sliderR = new ColorChannelSliderPanel("R");
    sliderG = new ColorChannelSliderPanel("G");
    sliderB = new ColorChannelSliderPanel("B");

    addColorChangeListener(e -> setHexLabel());

    JPanel slidersPanel = new JPanel();
    slidersPanel.add(sliderR);
    slidersPanel.add(sliderG);
    slidersPanel.add(sliderB);
    add(slidersPanel);

    JPanel hexPanel = new JPanel();
    TitledBorder hexTitle = BorderFactory.createTitledBorder("Hex");
    hexPanel.setBorder(hexTitle);
    hexLabel = new JLabel();
    setHexLabel();
    hexPanel.add(hexLabel);
    add(hexPanel);
  }

  public Color getColor() {
    int r = sliderR.getValue();
    int g = sliderG.getValue();
    int b = sliderB.getValue();

    return new Color(r, g, b);
  }

  private void setHexLabel() {
    int r = sliderR.getValue();
    int g = sliderG.getValue();
    int b = sliderB.getValue();

    int finalValue = (r * 256 * 256) + (g * 256) + b;

    String text = String.format("#%06X", finalValue);
    hexLabel.setText(text);
  }

  public void addColorChangeListener(ChangeListener listener) {
    sliderR.addSliderChaneListener(listener);
    sliderG.addSliderChaneListener(listener);
    sliderB.addSliderChaneListener(listener);
  }
}

class Drawing extends JComponent{

  private Color foregroundColor;
  private Color backgroundColor;

  int squareSize = 50;

  public Drawing() {
    foregroundColor = Color.white;
    backgroundColor = Color.white;
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    int x = (getWidth() - squareSize) / 2;
    int y = (getHeight() - squareSize) / 2;
    Rectangle2D rec = new Double(x, y, squareSize, squareSize);
    Rectangle2D fillRec = new Double(0, 0, getWidth(), getHeight());
    g2.setColor(backgroundColor);
    g2.fill(fillRec);
    g2.setColor(foregroundColor);
    g2.fill(rec);



    setForeground(foregroundColor);
    setBackground(backgroundColor);
  }

  public void setForeground(Color c) {
    super.setForeground(c);
    foregroundColor = c;
  }

  public void setBackground(Color c) {
    super.setBackground(c);
    backgroundColor = c;
  }

}