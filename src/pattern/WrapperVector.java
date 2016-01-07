/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern;

import java.util.Iterator;
import vectors.Vector;

/**
 *
 * @author viks
 */
public class WrapperVector implements Vector {
    private Vector vector;

    public WrapperVector(Vector vector ) {
        this.vector = vector; 
    }
    
    @Override
    public synchronized void addLast(double value) {
        vector.addLast(value);
    }

    @Override
    public synchronized void addArray(double[] value) {
        vector.addArray(value);
    }

    @Override
    public synchronized void add(double value, int index) {
        vector.addLast(value);
    }

    @Override
    public synchronized void show() {
        vector.show();
    }

    @Override
    public synchronized void remove(int index) {
       vector.remove(index);
    }

    @Override
    public synchronized int size() {
        return vector.size();
    }

    @Override
    public synchronized double getValue(int index) {
        return vector.getValue(index);
    }

    @Override
    public synchronized void addArray(Vector n) {
        vector.addArray(n);
    }

    @Override
    public synchronized Iterator<Double> iterator() {
        return vector.iterator();
    }
    
    @Override
    public synchronized Object clone() {
        WrapperVector clon = new WrapperVector(vector);
        for (int i = 0; i < vector.size(); i++) {
            clon.add(vector.getValue(i), i);
        }
        return clon;
    }
}
