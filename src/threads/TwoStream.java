/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import pattern.SingletonVector;
import vectors.ArrayVector;
import vectors.LinkedListVector;

/**
 *
 * @author viks
 */
public class TwoStream extends Thread{
    
    @Override
    public void run(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(TwoStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayVector vector = (ArrayVector) SingletonVector.getInstance();
        int i = 0;
        for (double val : vector){
            System.out.println("Read: "+ val+ " from position "+i++);
        }
        System.out.println("Finish two stream");
    }
    
}
