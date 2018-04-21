package com.wansmd.king.mutao.client;

import android.util.Log;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
    ServerSocket serverSocket;

    public Boolean MyServer(String dao,String userNAme,String passWord){
        Boolean bo = false;
        try {
            //创建socket对象
            Socket socket = new Socket("localhost",9999);
            //获取socket输出流
            OutputStream os = socket.getOutputStream();
            //对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(os);
            String[] str ={dao,userNAme,passWord};
            oos.writeObject(str);
            //关闭输出流
            socket.shutdownOutput();
            //获取socket输入流
            InputStream is = socket.getInputStream();
            //对象输入流
            ObjectInputStream ois = new ObjectInputStream(is);

            bo = ois.readBoolean();

            Log.d("aaaaa", "MyServer: "+bo);
            is.close();
            ois.close();
            os.close();
            oos.close();
            return bo;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bo;
    }
}
