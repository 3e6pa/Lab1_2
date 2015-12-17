package vectors;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anla1215
 */
public class LinkedListVectorTest {
    
    public LinkedListVectorTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void testAddArray_doubleArr() {
        System.out.println("Check method addArray(double[])");
        
        double[] m = {1,2,3,4,5,6,7,8,9};
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);
        
        boolean isPass = true;
        for (int i = 0; i < instance.size(); i++) {
            if(instance.getValue(i) != m[i]){
                isPass = false;
                break;
            }
        }        
        assertTrue(isPass);
    }

    @Test
    public void testAddArray_Vector() {
        System.out.println("Check method addArray(Vector)");
        
        double[] data = {1,2,3,4,5,6,7,8,9};
        
        Vector m = new LinkedListVector();
        m.addArray(data);
        
        m.show();
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);
        
        boolean isPass = true;
        for (int i = 0; i < instance.size(); i++) {
            if(instance.getValue(i) != m.getValue(i)){
                isPass = false;
                break;
            }
        }        
        assertTrue(isPass);
    }

    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        double value = 0.0;
        LinkedListVector instance = new LinkedListVector();
        instance.addFirst(value);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddLast() {
        System.out.println("addLast");
        double value = 0.0;
        LinkedListVector instance = new LinkedListVector();
        instance.addLast(value);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        double value = 0.0;
        int index = 0;
        LinkedListVector instance = new LinkedListVector();
        instance.add(value, index);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShow() {
        System.out.println("show");
        LinkedListVector instance = new LinkedListVector();
        instance.show();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int index = 0;
        LinkedListVector instance = new LinkedListVector();
        double expResult = 0.0;
        double result = instance.getValue(index);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        LinkedListVector instance = new LinkedListVector();
        instance.removeLast();
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        LinkedListVector instance = new LinkedListVector();
        instance.remove(index);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        LinkedListVector instance = new LinkedListVector();
        instance.removeFirst();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSize() {
        System.out.println("size");
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMaxSize() {
        System.out.println("maxSize");
        Vector m = null;
        Vector n = null;
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.maxSize(m, n);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMinSize() {
        System.out.println("minSize");
        Vector m = null;
        Vector n = null;
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.minSize(m, n);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCompare() {
        System.out.println("compare");
        Vector m = null;
        Vector n = null;
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.compare(m, n);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedListVector instance = new LinkedListVector();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object m = null;
        LinkedListVector instance = new LinkedListVector();
        boolean expResult = false;
        boolean result = instance.equals(m);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        LinkedListVector instance = new LinkedListVector();
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
