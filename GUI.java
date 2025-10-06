import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import javax.swing.*;

public class  GUI implements ActionListener{
    
    private final JFrame frame;
    private final JLabel label;
    //private JPanel panel;
    //private JTextField namField;
    //private JTextField ageField;
    private final ImageIcon image, headIcon;
    //the User interface
    public GUI() {

        frame = new JFrame(); //creates the frame
        //panel = new JPanel();
        label = new JLabel(); //creates label

        image = new ImageIcon("icon.png"); //setting up the icon dont judge it 
        headIcon = new ImageIcon("headicon.png");

        //label side 
        label.setText("CONTACTS");
        label.setIcon(headIcon);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("TImes New Roman", Font.PLAIN, 20)); // font bold size
        label.setForeground(Color.WHITE);   
        label.setBounds(0, 0, 250, 250);    

        //main frame
        frame.getContentPane().setBackground(new Color(25, 25, 25)); // set background color to black
        frame.setSize(1000, 700); // Defult window size 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Can Exit  
        frame.setTitle("Contact System"); //The Program Titile
        frame.setIconImage(image.getImage()); //The Program icon
        frame.add(label);
        frame.setVisible(true); //Make frames visible
   
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
            
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
