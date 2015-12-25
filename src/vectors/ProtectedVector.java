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
public class ProtectedVector implements Vector {
    private Vector vector;
    public ProtectedVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public void addLast(double value) {
        
    }

    @Override
    public void addArray(double[] value) {
        
    }

    @Override
    public void add(double value, int index) {
        
    }

    @Override
    public void show() {
       for (double value : vector){
           System.out.print(value+" ");
       }
       System.out.println();
    }

    @Override
    public void remove(int index) {
      
    }

    @Override
    public int size() {
        return  vector.size();
    }

    @Override
    public double getValue(int index) {
        return vector.getValue(index);
    }

    @Override
    public void addArray(Vector n) {
        
    }

    @Override
    public Iterator<Double> iterator() {
     return vector.iterator();
    }
    
    @Override
    public Object clone(){
        ProtectedVector clon = new ProtectedVector(vector);
        return clon;
    }
    
}
