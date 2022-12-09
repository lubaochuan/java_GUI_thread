
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoButton{
  private static JFrame mainFrame;
  private static JLabel infoLabel;
  private static JLabel progressLabel;
  private static JButton leftButton;
  private static JButton rightButton;
  private static int progress = 0;

  public static void main(String[] args){
    mainFrame = new JFrame("Button Example");
    mainFrame.setSize(400, 400);
    mainFrame.setLayout(new GridLayout(2, 2));
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    infoLabel = new JLabel("Progress:", JLabel.RIGHT);
    progressLabel = new JLabel("0", JLabel.LEFT);
    leftButton = new JButton("+1");
    rightButton = new JButton("+2");
    mainFrame.add(infoLabel);
    mainFrame.add(progressLabel);
    mainFrame.add(leftButton);
    mainFrame.add(rightButton);
        
    leftButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        int temp = progress;
        pause();
        progress = temp + 1;
        progressLabel.setText(" " + progress);
      }
    });

    rightButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        int temp = progress;
        pause();
        progress = temp + 2;
        progressLabel.setText(" " + progress);
      }
    });

    mainFrame.setVisible(true);
  }

  public static void pause(){
    try{
      Thread.sleep(1000);
    } catch (InterruptedException e) { }
  }
}
