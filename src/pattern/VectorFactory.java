/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern;

import vectors.Vector;

/**
 *
 * @author viks
 */
public interface VectorFactory {
     Vector newVector (int size);
     
     Vector newList ();
}
