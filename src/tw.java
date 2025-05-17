import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class GridLayoutDemo extends JFrame implements ActionListener {
    JLabel one, two, three, four;
    JTextField tname, tsalary, tcode, tdesig;
    JButton buttonSave, buttonExit, buttonReset;

    GridLayoutDemo() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2));
        FlowLayout layout = new FlowLayout();
        JPanel p2 = new JPanel();
        p2.setLayout(layout);
        
        one = new JLabel("NAME");
        tname = new JTextField(20);
        two = new JLabel("CODE");
        tcode = new JTextField(20);
        three = new JLabel("DESIGNATION");
        tdesig = new JTextField(20);
        four = new JLabel("SALARY");
        tsalary = new JTextField(20);
        
        buttonSave = new JButton("SAVE");
        buttonReset = new JButton("RESET");
        buttonExit = new JButton("EXIT");
        
        p1.add(one);
        p1.add(tname);
        p1.add(two);
        p1.add(tcode);
        p1.add(three);
        p1.add(tdesig);
        p1.add(four);
        p1.add(tsalary);
        
        p2.add(buttonSave);
        p2.add(buttonReset);
        p2.add(buttonExit);
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        buttonSave.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonExit.addActionListener(this);
        
        setTitle("Employee Database");
        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonSave) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
                PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?,?)");
                
                stmt.setString(1, tname.getText());
                stmt.setInt(2, Integer.parseInt(tcode.getText()));
                stmt.setString(3, tdesig.getText());
                stmt.setDouble(4, Double.parseDouble(tsalary.getText()));
                
                int i = stmt.executeUpdate();
                System.out.println(i + " records inserted");
                
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == buttonReset) {
            tname.setText("");
            tcode.setText("");
            tdesig.setText("");
            tsalary.setText("");
        } else if (ae.getSource() == buttonExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GridLayoutDemo();
    }
}



