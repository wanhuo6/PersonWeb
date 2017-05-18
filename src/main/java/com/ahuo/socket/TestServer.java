package com.ahuo.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ahuo on 17-5-16.
 */
public class TestServer {

        public static void main(String[] args) throws Exception {
            ServerSocket server = new ServerSocket(9091);
            Socket client = server.accept();
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
                System.currentTimeMillis();
                    PrintWriter output2 = new PrintWriter(client.getOutputStream(), true);


                    Scanner cin = new Scanner(System.in);
                    String words;
                    while (cin.hasNext()) {
                        words = cin.nextLine();
                        output2.println(words);
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
            System.currentTimeMillis();
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

