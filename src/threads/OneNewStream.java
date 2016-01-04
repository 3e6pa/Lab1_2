/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import pattern.SingletonVector;

/**
 *
 * @author viks
 */
public class OneNewStream implements Runnable {

    @Override
    public void run() {
        
        for (int i = 0; i < 10000;) {
            while (SingletonVector.canWrite) {
                    double value = (1 + (int) (Math.random() * ((1000 - 0) + 1)));// int, caz so good look it
                    SingletonVector.write(value);
                    //Thread.sleep(1000);
                    i++;
              
            }
        }
 }

    public void write() {

    }
}
