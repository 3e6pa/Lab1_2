/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

/**
 *
 * @author User
 */
public class VectorsUtil extends Vector { 
    public VectorsUtil(int size) {
        super(size);
        this.mas = new double[size];
        
    }
    
    public static void sort(Vector m) {
        for (int i = 0; i < m.mas.length; i++) {
            for (int j = 0; j < m.mas.length - i - 1; j++) {
                if (m.mas[j] > m.mas[j + 1]) {
                    double temp = m.mas[j];
                    m.mas[j] = m.mas[j + 1];
                    m.mas[j + 1] = temp;
                }
            }
        }
    }   
}
