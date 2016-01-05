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

    private static int pos = -1;
    private static Vector vector;
    public volatile static boolean check = true;
    public volatile static boolean canWrite = true;
    public static int size;
    public static Thread stream1 = new Thread(new OneNewStream());
    public static Thread stream2 = new Thread(new TwoNewStream());
    private static Object lock = new Object();

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

    /**
     * **************************************************************
     */
    
    
    public static void write(double value) {
        synchronized (lock) {
            if (canWrite) {
                try {
                    while(check)
                    lock.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SingletonVector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        pos++;
        if (vector == null) {
            vector = new LinkedListVector();
        }
        vector.addLast(value);
        System.out.println("Write: " + value + " to position " + pos);
        canWrite = false;
        lock.notifyAll();
        }
    }

    public static void read() {
        synchronized (lock) {
            if (!canWrite) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SingletonVector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        if (vector == null) {
            System.out.println("Dont initialization vector!!!");
        } else {
            System.out.println("Read: " + vector.getValue(pos) + " from position " + pos);
        }
        if (pos == 10){
            check = false;
        }
        //System.out.println("--------------------------------------------");
        canWrite = true;
        lock.notifyAll();
        }
    }
    

    /**
     * ********************************************************************
     */
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
