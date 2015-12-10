/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_2;
import vector.*;
/**
 *
 * @author User
 */
public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector vect1 = new Vector(2);
        vect1.addElement(2.1);
        vect1.addElement(2.1);
        vect1.addElement(2.1);     
        vect1.showArray();
        
        double[] a = {1,2,3,4,5};
        Vector vect2 = new Vector(10);
        vect2.addArray(a);   
        vect2.addArray(a);  
        vect2.addArray(a);  
        vect2.showArray();
    }
    
}
