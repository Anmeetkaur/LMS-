/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91904
 */
import java.util.*;
public class ArratDemo {
    public static void arrayFunc(int A[],int target){
        int l=0;
        int r=A.length-1;
        boolean flag=false;
        Arrays.sort(A);
        while(l<r){
            int sum=A[l]+A[r];
            if(sum==target){
                System.out.println(A[l]+" + "+A[r]+" = "+target);
                flag=true;
                l++;
                r--;
            }
            else if(sum<target){
                l++;
            }
            else{
                r--;
            }
        }
        if(flag==false){
            System.out.println("No such pairs exist");
        }
    }
    public static void arrayFunc(int A[], int p,int B[],int q){
        int i=0,j=0,k=0;
        while(i<p&&j<q){
            if(A[i]>B[j]){
                int temp=A[i];
                A[i]=B[k];
                B[k]=temp;
                i++;
                Arrays.sort(B);
            }
            else if(B[j]>A[i]){
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        System.out.println("Array 1");
        for(int m=0;m<p;m++){
            System.out.print(A[m]+" ");
        }
        System.out.println("\nArray 2");
        for(int u=0;u<q;u++){
            System.out.print(B[u]+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of an array");
        int n=sc.nextInt();
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter target");
        int target=sc.nextInt();
        arrayFunc(A,target);
        System.out.println("Enter size of an array 1");
        int p=sc.nextInt();
        int[] C=new int[p];
        System.out.println("Enter elements");
        for(int i=0;i<p;i++){
            C[i]=sc.nextInt();
        }
        System.out.println("Enter size of an array 2");
        int m=sc.nextInt();
        int[] B=new int[m];
        System.out.println("Enter elements");
        for(int i=0;i<m;i++){
            B[i]=sc.nextInt();
        }
        arrayFunc(C,p,B,m);
    }
}
