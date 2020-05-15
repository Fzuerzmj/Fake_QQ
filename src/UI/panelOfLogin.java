package UI;
import Server.JsonFunction;
import UI.ImagePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;

public class panelOfLogin extends UI.ImagePanel{
    private JTextField ID;
    private JPasswordField password;
    JButton loginBut;

    DataOutputStream oStream;
    DataOutputStream iStream;   //客户端的In（Out）putStream对象

    public panelOfLogin(Dimension d, Image image, DataInputStream inputStream,DataOutputStream outputStream) {
        super(d, image);
        ID = new JTextField(20);
        password = new JPasswordField(20);
        loginBut = new JButton("登录");
        setLayout(null);

        /*账号框设置*/
        JLabel tempLable1 = new JLabel("账号：");
        tempLable1.setFont(new Font("宋体",Font.BOLD,13));
        tempLable1.setForeground(Color.RED);
        tempLable1.setBounds(100,100,40,20);
        add(tempLable1);

        /*密码框设置*/
        ID.setBounds(160,100,200,20);
        add(ID);
        JLabel tempLable2 =  new JLabel("密码:");
        tempLable2.setBounds(100,150,60,20);
        tempLable2.setFont(new Font("宋体",Font.BOLD,13));
        tempLable2.setForeground(Color.RED);
        add(tempLable2);
        password.setBounds(160,150,200,20);
        add(password);

        loginBut.setBounds(200,200,100,30);  //登录按钮位置
        loginBut.setForeground(Color.blue);  //设置登录按钮字体颜色
        loginBut.addActionListener(new lsnOfLoginButton());   //为登录按钮添加事件监听器
        add(loginBut);
    }


    class lsnOfLoginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e != null) {
                String gettedID = ID.getText();   //从输入框获取ID
                char[] tempPassword = password.getPassword();
                if(gettedID == ""){    //账号为空
                    JOptionPane.showMessageDialog(null,"账号为空","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(tempPassword.length == 0){   //密码为空
                    JOptionPane.showMessageDialog(null,"密码为空","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{   //正常情况
                    String gettedPassword = new String(tempPassword);
                    gettedPassword = SHA1Encryption.getSHA1(gettedPassword);  //对密码进行SHA1加密
                    Map<String,Object> map = new HashMap<String, Object>();
                    map.put("type",1);   //类型1表示请求登录
                    map.put("ID",gettedID);  //ID
                    map.put("password",gettedPassword); //password
                    JsonFunction.mapToJsonByteArray(map);


                }
            }
        }
    }

}
