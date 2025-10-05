import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class  GUI implements ActionListener{
    
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    
    private JTextField namField;
    private JTextField ageField;


    //variables
    int count = 0;

    //the User interface
    public GUI() {

        frame = new JFrame();
        panel = new JPanel();
    
      
        //The Ui 
        JButton button = new JButton("Clik me");
        button.addActionListener(this);

        label = new JLabel("Number of clicks");


        //Setting up the ui 

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));


        //the buttons and panel
        panel.add(button);
        panel.add(label);
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle("Bank Account");//title
        frame.pack();
        frame.setVisible(true);
    } 
    
    


    //do not change this 
    @Override
    public void actionPerformed(ActionEvent e) {
        

    
        
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }


    //start 
    public static void main(String[] args) {     
        new GUI();
    }
}
