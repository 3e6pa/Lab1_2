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
public class VectorsUtil {

    public static void sort(ArrayVector m) {
        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j < m.size() - i - 1; j++) {
                if (m.getValue(j) > m.getValue(j + 1)) {
                    double temp = m.getValue(j);
                    m.add(m.getValue(j + 1), j);
                    m.add(temp, j + 1);
                }
            }
        }
    }
}
