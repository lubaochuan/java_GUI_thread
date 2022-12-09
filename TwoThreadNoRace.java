import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoThreadNoRace{
  private static JFrame mainFrame;
  private static JLabel infoLabel;
  private static JLabel progressLabel;
  private static JButton leftButton;
  private static JButton rightButton;
  private static Integer progress = 0;

  public static void main(String[] args){
    mainFrame = new JFrame("Two Thread Button Example");
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

    class MainWorker1 extends SwingWorker<Integer, Integer>{
      protected Integer doInBackground() throws Exception, InterruptedException{
        // Do a time-consuming task.
        Thread.sleep(1000);
        return 1;
      }

      protected void done(){
        try{
          progress = progress + get();
          progressLabel.setText(" " + progress);
        } catch (Exception e){ }
      }
    }

    class MainWorker2 extends SwingWorker<Integer, Integer>{
      protected Integer doInBackground() throws Exception, InterruptedException{
        // Do a time-consuming task.
        Thread.sleep(1000);
        return 2;
      }

      protected void done(){
        try{
          progress = progress + get();
          progressLabel.setText(" " + progress);
        } catch (Exception e){ }
      }
    }

    leftButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        new MainWorker1().execute();
      }
    });

    rightButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        new MainWorker2().execute();
      }
    });

    mainFrame.setVisible(true);
  }
}
