/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import pattern.SingletonVector;

/**
 *
 * @author viks
 */
public class TwoStream extends Thread{
    
    @Override
    public void run(){
        SingletonVector.show();
    }
    
}
