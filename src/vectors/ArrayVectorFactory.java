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
public class ArrayVectorFactory implements VectorFactory{

    @Override
    public Vector newVector(int size) {
        return new ArrayVector(size);
    }
    
}
