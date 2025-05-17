/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pk1;

/**
 *
 * @author 91904
 */
/*
import java.awt.*;
import java.awt.event.*;

class Window extends Frame implements ActionListener, WindowListener {
    Button b1 = new Button("Click here (Green)");
    Button b2 = new Button("Click here (Pink)");
    TextField f1 = new TextField(15);
    Label name = new Label("Name");

    Window() {
        // Set layout before adding components
        setLayout(new FlowLayout());
        
        // Add components to the frame
        add(name);
        add(f1);
        add(b1);
        add(b2);
        
        
        // Set frame properties
        setTitle("Form");
        setSize(400, 300);
        setVisible(true);
        
        // Add window listener
        addWindowListener(this);
        
        // Add action listeners to the buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Set text in the TextField
        f1.setText("Anmeet Kaur");
        
        // Change background color based on the source of the event
        if (e.getSource() == b1) {
            setBackground(Color.green);
        } else if (e.getSource() == b2) {
            setBackground(Color.pink);
        }
    }

    // Implement WindowListener methods
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new Window();
    }
}

*/
/*
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Window extends JFrame implements ActionListener{
    JButton b1 = new JButton("Submit");
    JButton b2 = new JButton("Reset");
    JLabel p1 = new JLabel("Name : ");
    JLabel p2 = new JLabel("Password  : ");
    JTextField t1 = new JTextField(15);
    JPasswordField t2 = new JPasswordField(15);
    Window(){
        
        setVisible(true);
        setSize(400,300);
        setLayout(new FlowLayout());
        add(p1);
        add(t1);
        add(p2);
        add(t2);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e){
        String a = t1.getText();
        String b = t2.getText();
        if(e.getSource()==b1){
            if(a.equals("Admin")&&b.equals("pass")){
                JOptionPane.showMessageDialog(this,"Successfully Login");
    
            }
            else{
                JOptionPane.showMessageDialog(this,"Incorrect Info");
            }
        }
        else if(e.getSource()==b2){
            t1.setText("");
            t2.setText("");
        }
    }
    public static void main(String[] a){
        new Window();
    }  
}
 */
 //arraylist hashset and linked list

/*
import java.util.*;
class gejkhs{
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        HashSet<Integer> ha=new HashSet<>();
        LinkedList<Integer> ll=new LinkedList<>();
        list.add("Anu");
        list.add("Golu");
        ha.add(0);
        ha.add(9);
        ll.add(8);
        ll.add(7);
        System.out.println(list);
        System.out.println(ha);
        System.out.println(ll);
        ll.add(6);
        ll.add(-1);
        ll.add(7);
        ll.add(0);
        Collections.sort(ll);
        Iterator<Integer> it = ll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
}
*/

