/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import java.util.Iterator;

/**
 *
 * @author viks
 */
public interface Vector extends Iterable<Double> {

    void addLast(double value);
    
    void addArray(double[] value);

    void add(double value, int index);

    void show();
    
    void remove (int index);
    
    int size();
    
    double getValue(int index);

    public void addArray(Vector n);
    
    public Object clone();
    
   

}
