package com.concurrent.chapter09;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/8/15
 */
public class ChannelFutureDemo {

    public static void main(String[] args) {
        // connect 是异步的，仅仅是提交异步任务
        Bootstrap bootstrap = new Bootstrap();
        SocketAddress remoteAddress = new InetSocketAddress("www.baidu.com", 80);
        ChannelFuture future = bootstrap.connect(remoteAddress);

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("Connection established");
                } else {
                    System.out.println("Connection attempt failed");
                    future.cause().printStackTrace();
                }
            }
        });
    }
}
