/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pk1;

/**
 *
 * @author 91904
 */
import java.util.*;
class CustmException extends Exception{
        CustmException(String s){
            super(s);
        }
    }
class hna {
     
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter age");
        try{
        int age=sc.nextInt();
        if(age<=15){
            throw new CustmException("You are safe");
        }
        }catch(CustmException e){
            System.out.println(e);
        }
    }
   
}