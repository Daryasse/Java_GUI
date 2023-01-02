import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.*;
import java.awt.*;
public class Selivanovas22297{
  public static void main(String[] args) {
 ResizableSquareFrame fr = new ResizableSquareFrame();
    fr.setVisible(true);
 }
}
class ResizableSquareFrame extends JFrame{
  private MySlider slider;
  private Drawing drawing;
  public ResizableSquareFrame(){
    super("Resizable square");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(300, 200));
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    drawing = new Drawing();
    slider = new MySlider();

    JLabel label = new JLabel("Size of the square");
    label.setAlignmentX(LEFT_ALIGNMENT);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    slider.addChangeListener(e -> ResizeSquare());
    addComponentListener(new ComponentListener() {
      @Override
      public void componentResized(ComponentEvent e) {
        drawing.setSquareSize(slider.getValue());
      }

      @Override
      public void componentMoved(ComponentEvent e) {}

      @Override
      public void componentShown(ComponentEvent e) {}

      @Override
      public void componentHidden(ComponentEvent e) {}
    });
    add(drawing);
    panel.add(label);
    panel.add(slider);
    add(panel);
    pack();
    setSize(500, 400);
    setLocationRelativeTo(null);
  }
  private void ResizeSquare(){
    drawing.setSquareSize(slider.getValue());
    drawing.repaint();
  }
}
class MySlider extends JSlider{
    private static final Font font = new Font("Dialog", Font.BOLD, 9);

    MySlider() {
      super(JSlider.HORIZONTAL,
          0,
          100,
          80);
      setMajorTickSpacing(20);
      setMinorTickSpacing(10);
      setPaintTicks(true);
      setPaintLabels(true);
      setFont(font);
    }
}
  class Drawing extends JComponent {
  private int squareSize;
  public void setSquareSize(int percent){
    int min = Math.min(getWidth(), getHeight());
    squareSize=min*percent/100;
  }
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D fillRec = new Double(0, 0, getWidth(), getHeight());

      int x = (getWidth() - squareSize)/2;
      int y = (getHeight() - squareSize)/2;
      Rectangle2D rec= new Double(x,y,squareSize,squareSize);
      g2.setColor(Color.WHITE);
      g2.fill(fillRec);
      g2.setColor(Color.BLUE);
      g2.fill(rec);
    }
  }
