package com.Gcms.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.Gcms.serviceImpl.UserServiceImpl;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

/**
 * @author 3sh111
 * @date 2022/7/2
 * apiNote
 */
public class Login extends JFrame {
    public final static Font f = new Font("Microsoft YaHei UI", Font.PLAIN, 16);
    public static int themeStatus = 0;//用于切换主题

    JTextField jt;
    JPasswordField jp;
    String username = null;
    String password = null;

    /**
     * 启动 application
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();//设置swing主题
        InitGlobalFont(f);//初始化字体
        EventQueue.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }

    /**
     * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
     *
     * @param font
     */
    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        //调用UIManager的API，给每一个组件设置字体
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }

    /**
     * 构造登录界面窗体
     */
    public Login() {
        //设置窗体属性
        setTitle("登录界面");
        setBounds(300, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //设置内容面板
        Container c = getContentPane();
        c.setLayout(null);//绝对布局

        //---------------提示标签---------------
        //欢迎标签
        JLabel jLabel1 = new JLabel();
        jLabel1.setFont(new Font("楷体", Font.PLAIN, 28));
        jLabel1.setText("垃圾管理系统");
        jLabel1.setBounds(200, 20, 300, 60);
        c.add(jLabel1);

        Font l = new Font("楷体", Font.PLAIN, 24);

        //用户名提示
        JLabel usernameLabel = new JLabel("用户名");
        usernameLabel.setFont(l);
        usernameLabel.setBounds(100, 90, 75, 50);
        c.add(usernameLabel);

        //密码提示
        JLabel passwordLabel = new JLabel("密  码");
        passwordLabel.setFont(l);
        passwordLabel.setBounds(100, 150, 75, 50);
        c.add(passwordLabel);


        //---------------用户名输入---------------
        jt = new JTextField();
        jt.setBounds(190, 100, 220, 40);
        c.add(jt);


        //---------------密码输入---------------
        jp = new JPasswordField();
        //jp.setBorder();
        jp.setBounds(190, 155, 220, 40);
        jp.setEchoChar('*');//设置密码回显的字符
        c.add(jp);

        jp.addActionListener(e -> {//给密码框添加了事件监听器  敲击回车即可执行登录
            this.doLogin();
        });


        //---------------系统登录按钮---------------
        JButton btn1 = new JButton("登录系统");
        btn1.setIcon(new ImageIcon("src/main/resources/img/登录系统.png"));
        btn1.addActionListener(e -> {
            this.doLogin();
        });
        btn1.setBounds(120, 230, 139, 40);
        c.add(btn1);

        //---------------系统退出按钮---------------
        JButton btn2 = new JButton("退出系统");
        btn2.setIcon(new ImageIcon("src/main/resources/img/退出系统.png"));
        btn2.addActionListener(e -> System.exit(0));
        btn2.setFont(f);
        btn2.setBounds(320, 230, 139, 40);
        c.add(btn2);
    }

    /**
     * 判断能否登录
     */
    public void doLogin() {
        //从swing组件中获取登录的用户名和密码
        username = jt.getText();
        password = new String(jp.getPassword());
        //调用service层的login方法进行判断
        boolean login = new UserServiceImpl().login(username, password);
        if (login) {
            if (Menu.userStatus >= 0) {//正常的登录用户
                dispose();//结束登录界面  并进入管理员选项菜单
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Menu menu = new Menu();
                        menu.setVisible(true);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "您的账号已经被封禁，请联系系统管理员");
            }
        } else {
            JOptionPane.showMessageDialog(null, "登录失败，请检查账号密码是否有误");
        }
    }
}
