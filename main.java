/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91904
 */
import java.util.*;
abstract class CreditCard{
    abstract boolean isValid(String s);
    abstract boolean checkprefix(String s);
    abstract boolean checklength(String s); 
}
class MasterCard extends CreditCard{
    boolean isValid(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                 s = s.replace(" ", "");
            }
        }
        for(int i=0;i<s.length();i++){
             if("0123456789".indexOf(s.charAt(i))==-1) {
                 return false;
             }
        }
        return checkprefix(s)&&checklength(s);
    }
    boolean checkprefix(String s){
        return (s.startsWith("51")||s.startsWith("52")||s.startsWith("53")||s.startsWith("54")||s.startsWith("55"));
    }
    boolean checklength(String s){
        return s.length()==16;
    }
}
class Visa extends CreditCard{
    boolean isValid(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                 s = s.replace(" ", "");
            }
        }
        for(int i=0;i<s.length();i++){
             if("0123456789".indexOf(s.charAt(i))==-1) {
                 return false;
             }
        }
        return checkprefix(s)&&checklength(s);
    }
    boolean checkprefix(String s){
        return (s.startsWith("4"));
    }
    boolean checklength(String s){
        return s.length()==13||s.length()==16;
    }
}
class AmericanExpress extends CreditCard{
    boolean isValid(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                 s = s.replace(" ", "");
            }
        }
        for(int i=0;i<s.length();i++){
             if("0123456789".indexOf(s.charAt(i))==-1) {
                 return false;
             }
        }
        return checkprefix(s)&&checklength(s);
    }
    boolean checkprefix(String s){
       return (s.startsWith("34")||s.startsWith("35")||s.startsWith("36")||s.startsWith("37"));
    }
    boolean checklength(String s){
        return s.length()==15;
    }
}
public class main{
    public static void main(String[] args){
        MasterCard ob1=new MasterCard();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter credit card number for Master Card");
        String s1=sc.nextLine();
        boolean x=ob1.isValid(s1);
        if(x==true){
        System.out.println("Valid");
        }
        else{
           System.out.println("Invalid"); 
        }
        Visa ob2=new Visa();
        System.out.println("Enter credit card number for Visa");
        String s2=sc.nextLine();
        boolean y=ob2.isValid(s2);
        if(y==true){
        System.out.println("Valid");
        }
        else{
           System.out.println("Invalid"); 
        }
        AmericanExpress ob3=new AmericanExpress();
        System.out.println("Enter credit card number for American Express");
        String s3=sc.nextLine();
        boolean z=ob3.isValid(s3);
        if(z==true){
        System.out.println("Valid");
        }
        else{
           System.out.println("Invalid"); 
        }
    }
}