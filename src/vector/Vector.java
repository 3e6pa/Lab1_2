/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

/**
 *
 * @author viks
 */
public interface Vector {

    void addLast(double value);
    
    void addArray(double[] value);

    void add(double value, int index);

    void show();
    
    void remove (int index);
    
    int size();
    
    double getValue(int index);
   

}
