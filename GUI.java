import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    private final JFrame frame;
    private final JLabel label, checkinfo;
    private final JPanel Blackpanel;
    private final JTextField charField, numField;
    private final JButton submiButton;
    private final ImageIcon image, headIcon;

    public GUI() {
        frame = new JFrame();
        label = new JLabel();
        Blackpanel = new JPanel();
        image = new ImageIcon("headicon.png");
        headIcon = new ImageIcon("headicon.png");
        charField = new JTextField();
        numField = new JTextField();
        submiButton = new JButton();
        checkinfo = new JLabel();

        //main panel
        Blackpanel.setBackground(Color.GRAY);
        //Blackpanel.setPreferredSize(new Dimension(900, 500));
        //Blackpanel.setLayout(new FlowLayout());
        Blackpanel.setBounds(150, 90, 800 , 550);
        Blackpanel.setLayout(null);
    
        //the components
        label.setText("CONTACTS");
        label.setIcon(headIcon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setBounds(50, 0, 600, 500);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);

        checkinfo.setText("No user data entered");
        checkinfo.setSize(300, 300);
        checkinfo.setBounds(400, 220, 300, 100);

        charField.setPreferredSize(new Dimension(250, 40));
        charField.setBounds(400, 150, 250, 40);
        charField.setText("Enter Your Username");

        numField.setPreferredSize(new Dimension(250, 40));
        numField.setBounds(400, 200, 250, 40);
        numField.setText("Enter Your Password");
        
        submiButton.setPreferredSize(new Dimension(100, 40));
        submiButton.setText("Submit");
        submiButton.addActionListener(this); 
        submiButton.setBounds(400, 300, 100, 40);

        //adding the components within the blackframe
        Blackpanel.add(label);
        Blackpanel.add(charField);
        Blackpanel.add(numField);
        Blackpanel.add(submiButton);
        Blackpanel.add(checkinfo);
        frame.add(Blackpanel);

        //mainframe
        frame.getContentPane().setBackground(new Color(25, 25, 25));
        frame.setSize(1100, 750);
        frame.setResizable(false); // frame cant be resized
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Contact System");
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submiButton) {
            String username = charField.getText();
            String password = numField.getText();

            try {
            java.io.FileWriter writer = new java.io.FileWriter("userdata.txt", true); // true = append mode
            writer.write("Username: " + username + " Password: " + password + "\n");
            checkinfo.setText("User data updated Successfully");
            writer.close();
            
            } catch (java.io.IOException ex) {
            }
        }
    }

    
}
