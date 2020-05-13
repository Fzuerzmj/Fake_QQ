package UI;
import UI.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class panelOfLogin extends UI.ImagePanel{
    private JTextField ID;
    private JPasswordField password;
    JButton loginBut;

    public panelOfLogin(Dimension d, Image image) {
        super(d, image);
        ID = new JTextField(20);
        password = new JPasswordField(20);
        loginBut = new JButton("登录");
        setLayout(null);

        JLabel tempLable1 = new JLabel("账号：");
        tempLable1.setFont(new Font("宋体",Font.BOLD,13));
        tempLable1.setForeground(Color.RED);
        tempLable1.setBounds(100,100,40,20);
        add(tempLable1);

        ID.setBounds(160,100,200,20);
        add(ID);
        JLabel tempLable2 =  new JLabel("密码:");
        tempLable2.setBounds(100,150,60,20);
        tempLable2.setFont(new Font("宋体",Font.BOLD,13));
        tempLable2.setForeground(Color.RED);
        add(tempLable2);
        password.setBounds(160,150,200,20);
        add(password);

        loginBut.setBounds(200,200,100,30);
        loginBut.setForeground(Color.blue);
        add(loginBut);
    }
}
