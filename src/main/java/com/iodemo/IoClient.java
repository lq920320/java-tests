package com.iodemo;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author liuqian
 * @date 2019/7/4  15:16
 */
public class IoClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + " : hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
