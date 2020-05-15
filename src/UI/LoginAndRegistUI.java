package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class LoginAndRegistUI extends JFrame  {

    private JPanel cardPanel = new JPanel();   //卡片布局面板
    private JPanel controlPanel = new JPanel();  //控制面板，登录和注册两个按钮
    private JButton loginSelect = new JButton("Login");  //点击此按钮跳往登录界面
    private JButton registSelect = new JButton("Regist");//点击此按钮跳往注册界面

    DataOutputStream oStream;I
    DatanputStream iStream;   //客户端的In（Out）putStream对象

    CardLayout cardLayout = new CardLayout();

    public LoginAndRegistUI(DataInputStream inputStream,DataOutputStream outputStream){
        super("假 QQ");
        setBounds(200,200,500,400); //设置起始位置和大小
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();

        // frameSize = new Dimension(600, 360);
        //ImageIcon imageIcon = new ImageIcon();
        //ImagePanel imgPanelOfLogin = new ImagePanel(frameSize, imageIcon.getImage());
        //imgPanelOfLogin.setLayout(new BorderLayout());

        //setting of cardPanel
        cardPanel.setLayout(cardLayout);  //设置卡片布局
        cardPanel.add("login",new panelOfLogin(new Dimension(600,360),new ImageIcon(Constants.IMAGE_URL_OF_LOGIN_BACKGROUND).getImage(),iStream,oStream));  //添加登陆的控制界面
        cardPanel.add("regist",new PanelOfRegist(new Dimension(600,330),new ImageIcon(Constants.IMAGE_URL_OF_REGIST_BACKGROUND).getImage()));


        //Setting of controlPane
        FlowLayout f = (FlowLayout)controlPanel.getLayout();
        f.setHgap(0);      //设置组件之间间隙
        f.setVgap(0);      //设置组件之间间隙
        f.setAlignment(0);  //去开头空位
        f.setAlignment(0);  //去开头空位
        loginSelect.setPreferredSize(new Dimension(244,30));   //设置按钮大小
        registSelect.setPreferredSize(new Dimension(240,30));  //setSize不管用，得用setPreferredSize
        loginSelect.addActionListener(new actOfChgLoginAndRegist());
        registSelect.addActionListener(new actOfChgLoginAndRegist());
        controlPanel.add(loginSelect);
        controlPanel.add(registSelect);  //添加面板顶端选择按钮到控制面板

        //add conponents to lowest layer
        c.add(controlPanel,BorderLayout.NORTH);
        c.add(cardPanel,BorderLayout.CENTER);
        setVisible(true);
    }

    /*内部类1：（事件监听器,监听登录和注册界面顶端的两个按钮，用以切换登录和注册按钮---------------------------------------------------------------------------*/
    class actOfChgLoginAndRegist implements ActionListener{   //更换登录和注册界面事件管理器
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginSelect){
                cardLayout.show(cardPanel,"login");
            }
            else if (e.getSource() == registSelect){
                cardLayout.show(cardPanel,"regist");
            }
        }
    }
    /* ------------------------------------------------------------------------------------------------------------------------------------------------------*/




    public static void main(String[] args) {
        //LoginAndRegistUI aaa = new LoginAndRegistUI();
        ///aaa.setVisible(true);
        //System.out.println(Constants.IMAGE_URL_OF_LOGIN_BACKGROUND);
    }


}



