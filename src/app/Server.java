/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.net.*;
import java.io.*;
import utilits.Vectors;
import vectors.Vector;

/**
 *
 * @author viktor
 */

public class Server {

    public static void main(String[] ar) {
        int port = 3211;
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Ожидание клиента...");

            Socket socket = ss.accept();
            System.out.println("Клиент подключен!");
            System.out.println();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            Vector vect1 = Vectors.createInstance();
            Vector vect2 = Vectors.createInstance();
            int len = 0;
            while (true) { 
                int n = in.readInt();
                if (n % 2 != 0) {
                    System.out.println("нечетное");
                    len = in.readInt();
                    System.out.println("Прием вектора " + n + " Колиичество ожидаемых значений : " + len);
                    for (int i = 0; i < len; i++) {
                        vect1.addLast(in.readDouble());
                        System.out.print(vect1.getValue(i) + " ");
                    }
                    System.out.println("Вектор " + n + " принят!");
                    out.writeUTF("Разрешаю!");
                     out.flush();
                    out.writeBoolean(false);
                } else if (n % 2 == 0) {
                    System.out.println("четное");
                    len = in.readInt();
                    System.out.println("Прием вектора " + n + " Колиичество ожидаемых значений : " + len);
                    for (int i = 0; i < len; i++) {
                        vect2.addLast(in.readDouble());
                        System.out.print(vect2.getValue(i) + " ");
                    }
                    System.out.println("Вектор " + n + " принят!");
                    out.writeUTF("Нельзя!Выполняется ссумироание...");
                    System.out.println("Выполняется ссумироание...");
                    Vector temp ;
                    temp = Vectors.sumVetors(vect1, vect2);
                    vect1 = Vectors.createInstance();
                    vect2 = Vectors.createInstance();
                    System.out.println("Выполнено!");
                    System.out.println("Отсылаем результат обратно");
                    out.writeBoolean(true);
                    out.writeInt(temp.size());
                    for (int i = 0; i < temp.size(); i++) {
                        double t = temp.getValue(i);
                        System.out.print(t+" ");
                        out.writeDouble(t);
                    }
                    System.out.println();
                     out.flush();
                }
                System.out.println("Готово!");
               // out.writeUTF("Разрешаю!");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
