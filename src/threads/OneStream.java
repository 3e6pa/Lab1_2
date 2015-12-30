/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import pattern.SingletonVector;
import vectors.ArrayVector;
import vectors.Vector;
import utilits.Vectors;

/**
 *
 * @author viks
 */
public class OneStream extends Thread{
  
    @Override
    public void run(){
      SingletonVector.rundom(10, 1,100 );
  
    }
}
