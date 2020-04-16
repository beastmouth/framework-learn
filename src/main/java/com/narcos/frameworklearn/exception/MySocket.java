package com.narcos.frameworklearn.exception;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author hbj
 * @date 2020/4/16 2:58 下午
 */
public class MySocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        serverSocket.accept();
    }
}
