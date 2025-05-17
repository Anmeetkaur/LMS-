/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package pk1;

/**
 *
 * @author 91904
 */
/*
class Shop {
    boolean avail=false;
    int item;
    synchronized public void produce(int x){
        try{
            if(avail){
                System.out.println("Producer is waiting for consumer to consume");
                wait();
            }
            item=x;
            System.out.println(item+" Produced ");
            avail=true;
            notify();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void consume(int x){
        try{
            if(!avail){
                System.out.println("Consumer is waiting for producer to produce");
                wait();
            }
            item=x;
            System.out.println(item+" Consumed ");
            avail=false;
            notify();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Producer extends Thread{
    Shop s;
    public void run(){
        for(int i=0;i<5;i++){
            s.produce(i);
        }
    }
    Producer(Shop s){
        this.s=s;
    }
}
class Consumer extends Thread{
    Shop s;
    public void run(){
        for(int i=0;i<5;i++){
            s.consume(i);
        }
    }
    Consumer(Shop s){
        this.s=s;
    }
}
public class PCproblem{
    public static void main(String[] args){
        Shop s = new Shop();
        Producer pr = new Producer(s);
        Consumer cr = new Consumer(s);
        pr.start();
        cr.start();
    }
}







//PC Problem usinf Runnable Interface

class Shopp{
    int item;
    boolean avail=false; 
         public void produce(int x){
        synchronized(this){
        try{
        if(avail){
            System.out.println("Producer is waiting for consumer to consume");
            wait();
        }}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        item=x;
        avail=true;
        System.out.println(x+" Produced");
        notify();
        }
    }
   public void consume(int x){
       synchronized(this){
        try{
            if(!avail){
                System.out.println("Consumer is waiting for producer to produce");
                wait();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        item=x;
        avail=false;
        System.out.println(item+" Consumed");
        notify();
    }
   }
}
class Producer implements Runnable{
    Shopp s;
    public void run(){
       
            for(int i=0;i<5;i++){
                s.produce(i);
            }
        
    }
    Producer(Shopp s){
        this.s=s;
        
    }
}
class Consumer implements Runnable{
    Shopp s;
    public void run(){
        
            for(int i=0;i<5;i++){
                s.consume(i);
            }
        
    }
    Consumer(Shopp s){
        this.s=s;
        
    }
}
class PCproblem{
    public static void main(String[] ag){
        Shopp s=new Shopp();
        Producer p1=new Producer(s);
        Consumer c1=new Consumer(s);
        Thread con = new Thread(c1);
        Thread pro = new Thread(p1);
        pro.start();
        con.start();
    }
}/*


*/
/*
class print {
	boolean check=false;
	synchronized public void odd(int x) throws InterruptedException {
		if(check) {
			
			wait();
		}
                System.out.println("ODD "+x);
		check=true;
		notify();
	}
	synchronized public void even(int x) throws InterruptedException {
		if(!check) {
			
			wait();
		}
                System.out.println("EVEN "+x);
		check=false;
		notify();
	}
}
class odd extends Thread{
	print ob;
	public void run() {
		for(int i=1;i<=10;i+=2) {
			try {
				ob.odd(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	odd(print ob){
		this.ob=ob;
	}
}
class even extends Thread{
	print ob;
	public void run() {
		for(int i=2;i<=10;i+=2) {
			try {
				ob.even(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	even(print ob){
		this.ob=ob;
	}
}
class oddEVEN{
	public static void main(String[] args) {
		print o= new print();
		odd ob1=new odd(o);
		even ob2=new even(o);
		ob1.start();
		ob2.start();
	}
}*/
/*
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Demo extends JFrame
{
	public  Demo()
	{
			JLabel jl = new JLabel("number");
			add(jl);
			JTextField jt= new JTextField(5);
			add(jt);
			JButton jb  = new JButton("factorial");
			add(jb);
			setSize(400 , 400);
			setVisible(true);
			setLayout(new FlowLayout());
			setTitle("gunjan");
			JTextField jo= new JTextField(5);
			add(jo);
			JButton jr  = new JButton("reset");
			add(jr);
			ActionListener ac = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String command=e.getActionCommand();
					if(command.equals("factorial")) {
					String s = jt.getText();
					int a = Integer.parseInt(s);
					Integer output=1;
					for(int i=1 ; i<=a ; i++)
					{
						output*=i;
					}
					jo.setText(output.toString());
					}
					else if(command.equals("reset")) {
				            jt.setText("");
				            jo.setText("");
					}
				}
				
			};
			jb.addActionListener(ac);
	}
	 
}
class form {
	public static void main(String args[])
	{
		Demo obj1 = new Demo();
	}
}*/

/*

class dha{
    static int x;
        dha(){
        x=9;
    }
        public static void main(String[] args){
            dha ob= new dha();
            System.out.println(ob.x);
        }
}
*/