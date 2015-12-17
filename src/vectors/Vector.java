/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

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
    
    int maxSize(Vector m, Vector n);
    
    int minSize(Vector m, Vector n);
    
    int compare(Vector m, Vector n);

    public void addArray(Vector n);
    
    public Object clone();
   

}
