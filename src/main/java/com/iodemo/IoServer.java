package com.iodemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuqian
 * @date 2019/7/4  15:21
 */
public class IoServer {

    public static void main(String[] args) throws IOException {
        // 服务端处理客户端连接请求
        ServerSocket serverSocket = new ServerSocket(3333);

        // 接收到客户端连接请求之后为客户太创建一个新的线程进行链路处理
        new Thread(() -> {
            try {
                // 阻塞方法获取新的连接
                Socket socket = serverSocket.accept();

                // 每一个新的连接都创建一个线程，负责读取数据
                new Thread(() -> {
                    try {
                        int len;
                        byte[] data = new byte[1024];
                        InputStream inputStream = socket.getInputStream();
                        // 按字节流方式读取数据
                        while ((len = inputStream.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
