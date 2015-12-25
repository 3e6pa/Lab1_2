/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viks
 */
public class JVectorAdapter implements Vector {

    private java.util.Vector<Double> vector;

    public JVectorAdapter(java.util.Vector<Double> vector) {
        this.vector = vector;
    }

    @Override
    public void addLast(double value) {
        vector.add(value);
    }

    @Override
    public void addArray(double[] value) {
        for (double element : value) {
            vector.add(element);
        }
    }

    @Override
    public void add(double value, int index) {
        vector.add(index, value);
    }

    @Override
    public void show() {
        for (double value : this) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    @Override
    public void remove(int index) {
        vector.remove(index);
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public double getValue(int index) {
        return vector.get(index);
    }

    @Override
    public void addArray(Vector n) {
        for (double value : n) {
            vector.add(value);
        }
    }

    @Override
    public Iterator<Double> iterator() {
        return vector.iterator();
    }

    @Override
    public Object clone() {
        JVectorAdapter clon;
        try {
            clon = (JVectorAdapter) super.clone();
            for (int i = 0; i < vector.size(); i++) {
                clon.add(vector.get(i), i);
                return clon;
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(JVectorAdapter.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

}
