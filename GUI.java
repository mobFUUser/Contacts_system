import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class GUI implements ActionListener {

    private final JFrame frame;
    private final JLabel label, checkinfo;
    private final JPanel Blackpanel;
    private final JTextField charField, numField;
    private final JButton submiButton, delete;
    private final ImageIcon image, headIcon;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JScrollPane scrollPane;

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
        delete = new JButton();

        //table
        String[] columnNames = {"Name", "Number"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        table.setBounds(400, 320, 400, 200);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // select one row at a time
        scrollPane.setBounds(100, 320, 600, 200);

        //main panel
        Blackpanel.setBackground(Color.white);
        Blackpanel.setBounds(150, 90, 800 , 550);
        Blackpanel.setLayout(null);
    
        //the components
        label.setIcon(headIcon);
        label.setBounds(55, -50, 600, 500);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);

        checkinfo.setText("No Contacts entered");
        checkinfo.setSize(300, 300);
        checkinfo.setBounds(400, 170, 300, 100);

        charField.setPreferredSize(new Dimension(250, 40));
        charField.setBounds(400, 100, 250, 40);
        charField.setForeground(Color.DARK_GRAY);
    
        //makes the texts disappear similar to hint
        charField.setText("Enter Your Name");
        charField.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (charField.getText().equals("Enter Your Name")) {
                charField.setText("");
                charField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (charField.getText().isEmpty()) {
                charField.setText("Enter Your Name");
                charField.setForeground(Color.GRAY);
            }
        }
        });

        numField.setPreferredSize(new Dimension(250, 40));
        numField.setBounds(400, 150, 250, 40);
        numField.setForeground(Color.DARK_GRAY);

        //makes the texts disappear similar to hint
        numField.setText("Enter Your Number");
        numField.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (numField.getText().equals("Enter Your Number")) {
                numField.setText("");
                numField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (numField.getText().isEmpty()) {
                numField.setText("Enter Your Number");
                numField.setForeground(Color.GRAY);
            }
        }
        });

        //buttons 

        //submit button
        submiButton.setPreferredSize(new Dimension(100, 40));
        submiButton.setText("Submit");
        submiButton.addActionListener(this); //this means itself??
        submiButton.setBounds(400, 250, 100, 40);

        //delete button
        delete.setPreferredSize(new Dimension(100, 40));
        delete.setText("delete");
        delete.addActionListener(this); 
        delete.setBounds(520, 250, 100, 40);

        //adding the components within the blackframe to the backpanel
        Blackpanel.add(label);
        Blackpanel.add(charField);
        Blackpanel.add(numField);
        Blackpanel.add(submiButton);
        Blackpanel.add(checkinfo);
        Blackpanel.add(delete);
        Blackpanel.add(scrollPane);
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

        //load contacts
        loadContactsFromFile();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submiButton) {
            String name = charField.getText();
            String number = numField.getText();

            if (name.equals("Enter Your Name") || name.isEmpty() ||
                number.equals("Enter Your Number") || number.isEmpty()) {
                return;
            }

            try (FileWriter writer = new FileWriter("userdata.txt", true)) {
                writer.write(name + "," + number + "\n");
                checkinfo.setText("Contact saved Successfully!");
                tableModel.addRow(new Object[]{name, number}); // add to table instantly

                charField.setText("Enter Your Name");
                numField.setText("Enter Your Number");
                charField.setForeground(Color.GRAY);
                numField.setForeground(Color.GRAY);
            } catch (IOException ex) {
                checkinfo.setText("Error saving contact.");
            }
        }

         if (e.getSource() == delete) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                checkinfo.setText("Please select a contact to delete.");
                return;
            }
            String name = tableModel.getValueAt(selectedRow, 0).toString();
            String number = tableModel.getValueAt(selectedRow, 1).toString();

            tableModel.removeRow(selectedRow);
            checkinfo.setText("Contact deleted successfully!");
            // Rewrite file without deleted contact
            rewriteFile();
        }
    }

    private void rewriteFile() {
        try (FileWriter writer = new FileWriter("userdata.txt")) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                writer.write(tableModel.getValueAt(i, 0) + "," + tableModel.getValueAt(i, 1) + "\n");
            }
        } catch (IOException ex) {
            checkinfo.setText("Error updating file.");
        }
    }

    private void loadContactsFromFile() {
        tableModel.setRowCount(0); // clear old data
            try (BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Expected format: name,number
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    tableModel.addRow(new Object[]{parts[0], parts[1]});
                }
            }
            checkinfo.setText("Contacts loaded successfully!");
        } catch (IOException ex) {
            checkinfo.setText("No saved contacts found.");
            
    }
    
    }//action performed    
}//GUI
