/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import utilits.Vectors;
import static utilits.Vectors.createInstance;
import vectors.Vector;

/**
 *
 * @author User
 */
public class Client {

    private static int len = 0;

    public static void main(String[] args) throws IOException {
        int serverPort = 3211;
        String address = "127.0.0.1";
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("IP: " + address + " port " + serverPort);
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Соединение установлено!");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            System.out.println("....Чтение файла...");
            String pathIn = args[0];
            String pathOut = args[1];
            FileReader vectSymble1 = new FileReader(pathIn);
            BufferedReader line = new BufferedReader(vectSymble1);
            String s = null;
            String ss = null;
            System.out.println("....Готово...");
            //  System.out.println(s);
            
            
            while ((s = line.readLine()) != null) {
                Vector buf = Vectors.createInstance();
                Vector result = Vectors.createInstance();
                ss = s.replace(".", ",");
                s = ss;
                System.out.println();
                System.out.println("....Чтение содержимого...");
                System.out.println(s);
                Scanner sc = new Scanner(s);
                while (sc.hasNext()) {
                    if (sc.hasNextDouble()) {
                        buf.addLast(sc.nextDouble());
                        // System.out.print(buf.getValue(len++)+" ");
                    } else {
                        sc.next();
                    }
                }
                len++;
                //     System.out.println();
                out.writeInt(len);
                System.out.println(len);
                System.out.println("Чтение ветора " + len + " завершено, отсылаем на сервер длину вектора...");
                out.writeInt(buf.size());
                System.out.println("Отсылаем вектор на сервер ...");
                for (int i = 0; i < buf.size(); i++) {
                    out.writeDouble(buf.getValue(i));
                    System.out.print(".");
                }
                System.out.println();
                System.out.println("Готово. Ждем согласие на разрешение послать следующий вектор");
                System.out.println(in.readUTF());
                if (in.readBoolean()) {
                    System.out.println("Прием результата выполнения операций сложения векторов");
                  PrintWriter output = new PrintWriter(new FileWriter(pathOut, true));
                  int len_in = in.readInt();
                  System.out.println("Прием в размере : "+ len_in+" элементов");
                    for (int i = 0; i <len_in; i++) {
                        result.addLast(in.readDouble());
                        System.out.print(result.getValue(i)+" "+i);
                    }
                    // System.out.println("Результат успешно принят");
                     Vectors.writeVector(result, output);
                     System.out.println("Результат успешно принят и сохранен в файл :"+ pathOut);
                }
             //   out.writeInt(buf.size());


                /*    for (int i = 0; i < buf.size(); i++) {
                    System.out.print(in.readDouble() + " ");
                }
                System.out.println();
            }*/
            }
        } catch (Exception x) {
            x.printStackTrace();
        }

    }
}
