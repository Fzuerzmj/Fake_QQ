package Client;

import UI.LoginAndRegistUI;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",5678);

        DataOutputStream oStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream iStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        new LoginAndRegistUI(iStream,oStream);   //将stock的inputStream和outputStream传递给前端，直接与客户端交互；（可能有点偷懒）

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("ID","00000000");
        map.put("password","我i456");
        oStream.writeUTF(JsonFunction.mapToJsonByteArray(map));
        oStream.flush();
        socket.shutdownOutput();


        socket.close();  //关闭
    }
}