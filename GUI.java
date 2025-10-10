import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements ActionListener {
    
    private final JFrame frame;
    private final JPanel APanel, BPanel;
    private final ImageIcon image;

    public GUI() {

        frame = new JFrame();
        image = new ImageIcon("icon.png");
        
        APanel = new JPanel();
        APanel.setBackground(Color.white); //color
        APanel.setBounds(0, 0, 350, 800);


        BPanel = new JPanel();
        BPanel.setBackground(Color.BLACK); //color
        BPanel.setBounds(350, 0, 10000, 1000);

        
        frame.add(APanel);
        frame.add(BPanel);
        
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(25, 25, 25));
        frame.setSize(1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Contact System");
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    

    //public static void main(String[] args) {
      //  new GUI();

      
    //}
}
