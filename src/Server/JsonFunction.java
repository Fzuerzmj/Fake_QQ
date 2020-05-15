package Server;

/* 此函数旨在提供json相关操作，方便服务器与客户端之间的信息交流*/
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class JsonFunction {

    public static String mapToJsonByteArray(Map<String, Object> map){   //将map转化为byte形式，实现 inputstream 和 outputstream 传输
        JSONObject json = new JSONObject(map);
        String jsonString = "";
        jsonString = json.toString();
        return jsonString;
    }

    public static JSONObject streamToJson(DataInputStream inputStream) throws IOException, JSONException {
        String strInputstream = "";
        strInputstream=inputStream.readUTF();
        JSONObject js = new JSONObject(strInputstream);
        return js;
    }
}
