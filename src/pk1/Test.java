

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91904
 *
 */

//Implement constructor overloading and demonstrate the working of super() and this()
/*
class Demo{
     Demo(int x){
        System.out.println("Single arg constructor invoked");
    }
    Demo(){
        this(10);
        System.out.println("No arg constructor invoked");
    }
    
}
class task extends Demo{
    task(){
        super();
        System.out.println("Sub class constructor invoked");
    }
    public static void main(String[] args){
        task o=new task(); 
    }
}*/


/*Construct a class Employee having the following attributes and functionalities 
Instance variables( private) 
name : type string 
EmpId: type int 
dept: type string 
Member functions: 
printData(): public ,to display the details 
a) Create an array of ‘n’ Employees to read and retrieve the information of n 
Employees,where n>=5. Use constructors to accomplish the task. 
b) Search for a particular EmpID from n records and if found display all the 
information related to searched EmpID,else print the message EmpId not 
present. 
*/


/*
import java.util.*;
class Employee{
    private String name;
    private int EmpId;
    private String dept;
    public void printData(){
        System.out.println("Name : "+name+"\nEmployee Id : "+EmpId+"\nDepartment : "+dept);
    }
    static Scanner sc=new Scanner(System.in);
    Employee(){
        System.out.println("Enter Name, Employee Id and department");
        this.name=sc.nextLine();
        this.EmpId=sc.nextInt();
        sc.nextLine();
        this.dept=sc.nextLine();
    }
    public static void main(String[] args){
        System.out.println("Enter number of employees");
        int n=sc.nextInt();
        sc.nextLine();
        Employee[] ob=new Employee[n];
        for(int i=0;i<n;i++){
            ob[i]=new Employee();
        }
        System.out.println("Enter Employee Id to search");
        int x=sc.nextInt();
        boolean f=false;
        for(int i=0;i<n;i++){
            if(ob[i].EmpId==x){
                ob[i].printData();
                f=true;
                break;
            }
        }
        if(f==false){
            System.out.println("EmpId not present");
        }
    }
}*/



/*3.Define a class WordExample having the following description: 
Data members/instance variables: 
private String strdata :  to store a sentence. 
Parameterized Constructor 
WordExample(String) :  Accept a sentence which may be terminated by either’.’,    
‘? ’or ’!’ only. The words may be separated by more than one blank space and are in    
UPPER CASE. 
Member Functions: 
void countWord(): Find the number of words beginning and ending with a vowel. 
void placeWord(): Place the words which begin and end with a vowel at the 
beginning, followed by the remaining words as they occur in the sentence.*/

/*
import java.util.*;
class WordExample{
    private String strdata;
    void countWord(String s){
        int c=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                c++;
                while(s.charAt(i)==' '){
                    i++;
                }
            }
        }
        System.out.println("Words : "+c);
    }
       private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
    void placeWord(String s){
         StringBuilder beginningWords = new StringBuilder();
        StringBuilder remainingWords = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length()-1; i++) {
            while (i < s.length()-1 && s.charAt(i) != ' ') {
                i++;
            }
            end = i;
            String word = s.substring(start, end);
            if (word.length() > 0 && isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                beginningWords.append(word).append(" ");
            } else {
                remainingWords.append(word).append(" ");
            }
            while (i < s.length()-1 && s.charAt(i) == ' ') {
                i++;
            }
            start = i;
            i--;
        } 
        System.out.println("Modified Sentence: " + beginningWords.toString().trim() + " " + remainingWords.toString().trim()+s.charAt(s.length()-1));
    }
    WordExample(String s){
        this.strdata=s;
        countWord(s);
        placeWord(s);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter sentence");
        String str=sc.nextLine();
        int n=str.length();
         if("!?.".indexOf(str.charAt(n))!=-1){
            WordExample ob=new WordExample(str);
        }
         else{
             System.out.println("invalid sentence");
         }
    }
}*/


/*
import java.util.*;

class Main
{
    String name;
    String address;
    int accno;
    int balanceamount;
    void getdata()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the name of the depositor");
        name=sc.nextLine();
        System.out.println("enter the address of the depositor");
        address=sc.nextLine();
        System.out.println("enter the account number");
        accno=sc.nextInt();
        System.out.println("enter the balance amount");
        balanceamount=sc.nextInt();
    }
    void printdata()
    {
        System.out.println("name of the depositor:"+name);
        System.out.println("address the depositor:"+address);
        System.out.println("account number:"+accno);
        System.out.println("balance amount:"+balanceamount);
    }
    void addamount()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the amount you want to add");
        int add=sc.nextInt();
        balanceamount=balanceamount+add;
        System.out.println("balance amount:"+balanceamount);
    }
    void withdrawamount()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the amount you want to withdraw");
        int rem=sc.nextInt();
        balanceamount=balanceamount-rem;
        System.out.println("balance amount:"+balanceamount);
    }
    void changeaddress()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the new address");
        String newadd=sc.nextLine();
        address=newadd;
        System.out.println("address"+address);
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Main b=new Main();
	    while(true)
	    {
    	    System.out.println("enter you want to choice");
    	    System.out.println("enter 1 to enter the info");
    	    System.out.println("enter 2 to display the info");
    	    System.out.println("enter 3 to deposite some amount");
    	    System.out.println("enter 4 to withdraw some amount");
    	    System.out.println("enter 5 to change the address");
    	    int ch=sc.nextInt();
    	    switch(ch)
    	    {
    	        case 1:
    	           b.getdata();
                   break;
    	        case 2:
    	           b.printdata();
    	           break;
    	        case 3:
    	           b.addamount();
    	           break;
    	        case 4:
    	           b.withdrawamount();
    	           break;
    	        case 5:
                   b.changeaddress();
                   break;
    	        default:
    	           System.out.println("wrong choice");
    	           break;
    	   }
	    }
	}
}*/


/*
import java.util.*;
class academicmarks
{
    int m1;
    int m2;
    int m3;
    void getmarks()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the marks");
        m1=sc.nextInt();
        m2=sc.nextInt();
        m3=sc.nextInt();
    }
}
class extracurricular extends academicmarks
{
    int gp;
    int sm;
    void getextra()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the gp marks");
        gp=sc.nextInt();
        System.out.println("enter the seminar marks");
        sm=sc.nextInt();
    }
}
class Main extends extracurricular
{
    int total;
    void printdata()
    {
        System.out.println("academic marks:"+m1+" "+m2+" "+m3);
        System.out.println("gp marks:"+gp);
        System.out.println("seminar marks:"+sm);
        total=m1+m2+m3+gp+sm;
        System.out.println("total:"+total);
    }
	public static void main(String[] args) {
	    Main ob=new Main();
	    ob.getmarks();
	    ob.getextra();
	    ob.printdata();
	}
}*/

/*package pk1;

public class Test{
    private int a=1;
    int b=2;
    protected int c=3;
    public int d=4;
    public void m1(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
                
    }
  
}
class Sec extends Test{
    public void m2(){ 
        super.m1();
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);       
    }
     public static void main(String[] args){
        Sec ob=new Sec();
        ob.m2();
    }
}*/




/*5.Implement  a java program to calculate the area of a rectangle, a square and a 
circle. Create an abstract class 'Shape' with three abstract methods namely 
rectangleArea() taking two parameters, squareArea() and circleArea() taking 
one parameter each. Now create another class ‘Area’ containing all the three 
methods rectangleArea(),squareArea() and circleArea() for printing the area of 
rectangle, square and circle respectively. Create an object of class Area and call 
all the three methods. 
(Use Runtime Polymorphism) */

/*
import java.util.*;
abstract class Shape{
   public abstract void rectangleArea(int x,int y);
   public abstract void squareArea(int x);
   public abstract void circleArea(int x);
}
class Area extends Shape{
    public void rectangleArea(int x,int y){
        System.out.println("Area="+x*y);
    }
    public void squareArea(int x){
        System.out.println("Area="+x*x);
    }
    public void circleArea(int x){
        System.out.println("Area="+2*3.14*x);
    }
    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Area ob=new Area();
		System.out.println("enter the length of the rectangle");
		int l=sc.nextInt();
		System.out.println("enter the breadth of the rectangle");
		int b=sc.nextInt();
		ob.rectangleArea(l,b);
		System.out.println("enter the side of the square");
		int s=sc.nextInt();
		ob.squareArea(s);
		System.out.println("enter the radius of the circle");
		int r= sc.nextInt();
		ob.circleArea(r);
	}

}*/
//Q6
/*
import java.util.*;
abstract class Temperature 
{
    double temp;
    public void setTempData(double t)
    {
        temp=t;
    }
    abstract void changeTemp();
}
class Fahrenheit extends Temperature
{
    double ctemp;
    public void changeTemp()
    {
        ctemp=(5.0/9.0)*(temp-32.0);
        System.out.println("changed Temperature:"+ctemp);
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Fahrenheit ob=new Fahrenheit();
		System.out.println("enter the temperature in fahrenheit");
		double t=sc.nextDouble();
		ob.setTempData(t);
		ob.changeTemp();
	}
}*/
//Q7
/*
import java.util.*;
abstract class Temperature 
{
    double temp;
    public void setTempData(double t)
    {
        temp=t;
    }
    abstract void changeTemp();
}
class Fahrenheit extends Temperature
{
    double ctemp;
    void changeTemp()
    {
        ctemp=(5.0/9.0)*(temp-32.0);
        System.out.println("changed Temperature in Celsius:"+ctemp);
    }
}
class Celsius extends Temperature
{
    double ftemp;
    void changeTemp()
    {
        ftemp=((9.0/5.0)*temp)+32;
        System.out.println("changed Temperaturein Fahrenheit:"+ftemp);
    }
    
}
class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Fahrenheit ob=new Fahrenheit();
	    Celsius ob2=new Celsius();
		System.out.println("enter the temperature in fahrenheit");
		double t=sc.nextDouble();
		ob.setTempData(t);
		ob.changeTemp();
		System.out.println("enter the temperature in Celsius");
		double te=sc.nextDouble();
		ob2.setTempData(te);
		ob2.changeTemp();
	}
}*/

//Q8/*

/*
import java.util.*;
interface I
{
    void volume();
}
class Cone implements I
{
    double r;
    double h;
    void setData(double t,double d)
    {
        r=t;
        h=d;
    }
    public void volume()
    {
        double v=(1.0/3.0)*3.14*r*r*h;
        System.out.println("volume of cone:"+v);
    }
}
class Hemisphere implements I
{
    double r;
    void setInfo(double re)
    {
        r=re;
    }
    public void volume()
    {
        double ctemp=(2.0/3.0)*3.14*r*r*r;
        System.out.println("volume of Hemisphere:"+ctemp);
    }
}
class Cylinder implements I
{
    double r;
    double h;
    void getData(double n,double k)
    {
        r=n;
        h=k;
    }
    public void volume()
    {
        double ftemp=3.14*r*r*h;
        System.out.println("volume of Cylinder:"+ftemp);
    }
    
}class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Cone ob=new Cone();
	    Hemisphere ob2=new Hemisphere();
	    Cylinder ob3=new Cylinder();
		System.out.println("enter the radius and height of cone");
		double t=sc.nextDouble();
		double d=sc.nextDouble();
		ob.setData(t,d);
		ob.volume();
		System.out.println("enter the radius of hemisphere");
		double re=sc.nextDouble();
		ob2.setInfo(re);
		ob2.volume();
		System.out.println("enter the radius and height of cylinder");
		double n=sc.nextDouble();
		double k=sc.nextDouble();
		ob3.getData(n,k);
		ob3.volume();
	}
}*/