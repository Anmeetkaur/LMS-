/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pk2;
import pk1.Test;

/**
 *
 * @author 91904
 */
 class Ckad extends Test {
     public void m3(){
        System.out.println(c);
        System.out.println(d);       
    }
}
class Norm{
    public static void main(String[] args){
        Ckad o=new Ckad();
        o.m3();
        System.out.println(o.d);  
    }
}
