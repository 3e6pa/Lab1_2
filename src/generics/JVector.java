/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author viks
 * @param <E>
 */
public interface JVector<E>{
    
    void addLast(E value); // <<<<<<<  not object! E jbject!
    
    void addArray(E[] value); // <<<<<<<  not object! E jbject!

    void add(E value, int index); // <<<<<<<  not object! E jbject!

    void show();
    
    void remove (int index);
    
    int size();
    
    E getValue(int index); // <<<<<<<  not object! E jbject!
    
    int maxSize(JVector m, JVector n);
    
    int minSize(JVector m, JVector n);
    
    int compare(JVector m, JVector n);

    public void addArray(JVector n);
    
}
