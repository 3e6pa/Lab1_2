/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern;

import java.util.logging.Level;
import java.util.logging.Logger;
import threads.OneNewStream;
import threads.TwoNewStream;
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

    private static int pos=-1;
    private static Vector vector;
    public volatile static boolean canWrite = true;
    
    OneNewStream oneStream;
    TwoNewStream twoStream;

    private SingletonVector() {
    }

    public static Vector getInstance() {
        if (vector == null) {
            vector = new ArrayVector();

        }
        return vector;
    }

    public static void rundom(int size, double min, double max) {
        if (vector == null) {
            vector = new ArrayVector();
        }
        vector = Vectors.rundom(size, min, max);
    }
/*****************************************************************/
    public static synchronized void write(double value) {
        pos++;
        if (vector == null) {
            vector = new LinkedListVector();
        }
        vector.addLast(value);
        System.out.println("Write: " + value + " to position " + pos);
        canWrite = false;       
    }
    
    public static synchronized void read() {
        if (vector == null) {
            System.out.println("Dont initialization vector!!!");
        } else {
            System.out.println("Read: " + vector.getValue(pos) + " from position " + pos);
        }
        canWrite = true;
    }
/***********************************************************************/
    public static synchronized double getValue(int i) {
        return vector.getValue(i);
    }

    public static void show() {
        int i = 0;
        for (double val : vector) {
            System.out.println("Read: " + val + " from position " + i++);
        }
    }
}
