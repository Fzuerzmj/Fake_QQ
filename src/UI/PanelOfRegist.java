package UI;

import UI.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class PanelOfRegist extends UI.ImagePanel{
    private JTextField userName;
    private JPasswordField password;
    private JPasswordField confirmassword;
    JButton loginBut;

    public PanelOfRegist(Dimension d, Image image) {
        super(d, image);
        userName = new JTextField(20);
        password = new JPasswordField(20);
        confirmassword = new JPasswordField(20);
        loginBut = new JButton("注册");
        setLayout(null);

        JLabel tempLable1 = new JLabel("用户名：");
        tempLable1.setFont(new Font("宋体",Font.BOLD,13));
        tempLable1.setForeground(Color.green);
        tempLable1.setBounds(100,60,60,20);
        add(tempLable1);
        userName.setBounds(160,60,200,20);
        add(userName);

        JLabel tempLable2 =  new JLabel("密码:");
        tempLable2.setBounds(100,100,60,20);
        tempLable2.setFont(new Font("宋体",Font.BOLD,13));
        tempLable2.setForeground(Color.green);
        add(tempLable2);
        password.setBounds(160,100,200,20);
        add(password);

        JLabel tempLable3 =  new JLabel("确认密码:");
        tempLable3.setBounds(100,150,60,20);
        tempLable3.setFont(new Font("宋体",Font.BOLD,13));
        tempLable3.setForeground(Color.green);
        add(tempLable3);
        confirmassword.setBounds(160,150,200,20);
        add(confirmassword);

        loginBut.setBounds(200,200,100,30);
        loginBut.setForeground(Color.BLUE);
        add(loginBut);
    }
}
