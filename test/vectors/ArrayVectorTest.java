/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author viks
 */
public class ArrayVectorTest {
    
    public ArrayVectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAddLast1() {
        System.out.println("addLast1");
        double value = 0.0;
        Vector instance = new ArrayVector();
        instance.addLast(value);
        boolean isPass = true;
        if (instance.getValue(instance.size() - 1) != value) {
            isPass = false;
        }
        assertTrue(isPass);
    }
    
    @Test
    public void testAddLast2() {
        System.out.println("addLast2");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.5;
        Vector instance = new ArrayVector();
        instance.addArray(m);
        int size = instance.size();
        instance.addLast(value);
        boolean isPass = true;
        if ((instance.getValue(instance.size() - 1) != value)) {
            isPass = false;
        }
        assertTrue(isPass);
    }
    
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        ArrayVector instance = new ArrayVector();
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        instance.addArray(m);
        int size = instance.size();
        instance.remove(index);
         boolean isPass = true;
        if (size == instance.size()) {
            isPass = false;
        }
        assertTrue(isPass);
        //fail("The test case is a prototype.");
    }

   @Test
    public void testDel() {
        System.out.println("del");
        int begin = 2;
        int end = 4;
        int count = end - begin +1; //потому что удаляет с 2 - 4 включительно (2,3,4)
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayVector instance = new ArrayVector();
        instance.addArray(m);
        int size = instance.size();
        instance.del(begin, end);
        boolean isPass = true;
        if (size-count != instance.size()) {
            isPass = false;
        }
        assertTrue(isPass);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
   /*  @Test
    public void testBias() {
        System.out.println("bias");
        int a = 0;
        int b = 0;
        ArrayVector instance = new ArrayVector();
        instance.bias(a, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

   
   @Test
    public void testAdd() {
        System.out.println("add value = 0.0, index = 5 ");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.0;
        int index = 0;
        Vector instance = new ArrayVector();
        instance.addArray(m);
        instance.show();
        int size = instance.size();
        instance.add(value, index);
        boolean isPass = true;
        if ((instance.getValue(index) != value) || (instance.size() == size)) {
            isPass = false;

        }
        instance.show();
        assertTrue(isPass);
    }

    
     @Test
    public void testMaxSize() {
        Vector m = new ArrayVector();
        Vector n = new ArrayVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        n.addArray(a);
        m.addArray(b);
        ArrayVector instance = new ArrayVector();
        int expResult = n.size();
        int result = instance.maxSize(m, n);
        System.out.println("expResult = " + expResult + " result = " + result);
        assertEquals(expResult, result);
    }

    
    
    @Test
    public void testCompare() {
         System.out.println("compare");
        Vector m = new ArrayVector();
        Vector n = new ArrayVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        n.addArray(b);
        m.addArray(a);
        ArrayVector instance = new ArrayVector();
        int expResult = 0;
        int result = instance.compare(m, n);
        System.out.println("expResult = " + expResult + " result = " + result);
        assertEquals(expResult, result);
    }

   
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayVector instance = new ArrayVector();
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        instance.addArray(m);
        instance.show();
        int expResult = 10;
        int result = instance.size();
        System.out.println("expResult = " + expResult + " result = " + result);
        assertEquals(expResult, result);
    }

   
   @Test
    public void testMinSize() {
        System.out.println("minSize");
        Vector m = new ArrayVector();
        Vector n = new ArrayVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        n.addArray(b);
        m.addArray(a);
        ArrayVector instance = new ArrayVector();
        int expResult = n.size();
        int result = instance.minSize(m, n);
        assertEquals(expResult, result);
        System.out.println("expResult = " + expResult + " result = " + result);
    }

    
     @Test
    public void testGetValue() {
        System.out.println("getValue");
        int index = 3;
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayVector instance = new ArrayVector();
        double expResult = 4.0;
        instance.addArray(m);
        double result = instance.getValue(index);
        System.out.println("expResult = " + expResult + ", result = " + result);
        assertEquals(expResult, result, 4.0);
    }

    
  /*  @Test
    public void testAddArray_doubleArr() {
        System.out.println("addArray");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.5;
        Vector instance = new ArrayVector();
        instance.addArray(m);
        int size = instance.size();
        boolean isPass = true;
        if ((instance.getValue(instance.size() - 1) != value)) {
            isPass = false;
        }
        assertTrue(isPass);
    }
*/
    
 /*   @Test
    public void testAddArray_Vector() {
        System.out.println("addArray");
        Vector m = null;
        ArrayVector instance = new ArrayVector();
        instance.addArray(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
   
 /*   @Test
    public void testShow() {
        System.out.println("show");
        ArrayVector instance = new ArrayVector();
        instance.show();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testToString() {
        System.out.println("toString");
        ArrayVector instance = new ArrayVector();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ArrayVector instance = new ArrayVector();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        Vector m = new ArrayVector();
        ArrayVector instance = new ArrayVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        m.addArray(a);
        instance.addArray(m);
        boolean expResult = false;
        boolean result = instance.equals(m);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testClone() {
        Vector clon = new ArrayVector();
        Vector etalon = new ArrayVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        etalon.addArray(a);
        Object result = etalon.clone();
        clon = (ArrayVector) result;
        clon.show();
        etalon.add(105, 5);
        clon.show();
        boolean isPass = true;
        if (clon == etalon) {
            isPass = false;
        }
        assertTrue(isPass);
    }

}
