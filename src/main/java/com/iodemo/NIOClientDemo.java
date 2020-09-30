package com.iodemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liuqian
 * @date 2019/7/19  14:46
 */
public class NIOClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
