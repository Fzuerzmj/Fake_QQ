package Server;
import UI.LoginAndRegistUI;
import UI.panelOfLogin;
import UI.PanelOfRegist;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int port = Constant.PORT;//设置端口

    public static void main(String[] args) throws IOException {
        ExecutorService threadPoll = Executors.newCachedThreadPool();  //线程池处理线程
        Socket socketFromClient;
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(port);    //建立ServerSocket类，定义接口为5678
            System.out.println("----------服务器已经启动---------");

            System.out.println("----------正在监听客户端接入---------");
            while(true)
            {
                socketFromClient = serverSocket.accept();   //接受客户端连接
                threadPoll.execute(new haddleClientThing(socketFromClient));
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {     //定义最后操作
            threadPoll.shutdown();   //关闭线程池
            if(serverSocket != null)
                serverSocket.close();   //关闭服务器端socket
        }
    }
}

class haddleClientThing implements Runnable{
    private Socket socket;
    static int a = 0;
    public haddleClientThing(Socket socketFromClient){
        socket = socketFromClient;
    }

    @Override
    public void run() {
        try {

            DataOutputStream oStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream iStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            //将input和output转化为Data流能够直接传送字符串更方便。
            System.out.println("线程" + (++a) + "成功接入");


            JSONObject js = JsonFunction.streamToJson(iStream);
            System.out.println(js.get("ID"));
            System.out.println(js.get("password"));

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }
}
