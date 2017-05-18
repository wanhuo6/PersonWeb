package com.ahuo.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ahuo on 17-5-16.
 */
public class TestClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 9091);
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        receive(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
            PrintWriter output =
                    new PrintWriter(client.getOutputStream(), true);


            Scanner cin = new Scanner(System.in);
            String words;
            while (cin.hasNext()) {
                words = cin.nextLine();
                output.println(words);
            }


            cin.close();
        } finally {
            client.close();
        }
    }

    private static void receive(Socket socket) throws IOException {
        boolean flag = true;
        BufferedReader input =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
         while (flag) {
             String line = input.readLine();
             if (line.equals("ends")) {
                 flag = false;
                 System.out.println("服务端请求关闭！");
             } else {
                 //output.println("客户端说"+line);
                 System.out.println("客户端说： " + line);
             }
         }

    }
}
