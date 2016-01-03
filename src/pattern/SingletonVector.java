/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern;

import utilits.Vectors;
import static utilits.Vectors.createInstance;
import vectors.ArrayVector;
import vectors.LinkedListVector;
import vectors.Vector;

/**
 *
 * @author viks
 */
public class SingletonVector {

    private static Vector vector;

    private SingletonVector() {
        
    }

    public static Vector getInstance() {
        if (vector == null) {
            vector  = new ArrayVector();
        }
        return vector;
    }
    
    public static void rundom(int size, double min, double max ){
        if (vector==null) vector = new ArrayVector();
        vector = Vectors.rundom(size, min, max);
     //  vector.show();
    }
    
    public static void show(){
        int i = 0;
        for (double val : vector){
            System.out.println("Read: "+ val+ " from position "+i++);
        }
        //System.out.println("end stream");
    }
}