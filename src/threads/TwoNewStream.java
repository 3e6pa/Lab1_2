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
public class TwoNewStream implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000;) {
            while (!SingletonVector.canWrite) {

                SingletonVector.read();
                i++;

            }
        }
    }

    public void read() {

    }

}
