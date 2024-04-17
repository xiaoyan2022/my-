package com.Gcms.view;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * @author 3sh111
 * @date 2022/7/2
 * @apiNote
 */
public class Menu extends JFrame {
    //将Menu窗体中的静态成员   方便其他方法调用
    public static Menu menu;//代表当前菜单窗体
    public static DataTable dataTable;//当前的数据表对象
    public static searchPanel searchPanel;//代表当前的搜索框窗体
    public static DataPanel dataPanel;//代表当前的数据修改面板
    public static String currentTableName = "user";//记录当前操作的表名
    public static int userStatus = 0;//记录登录的用户状态   等于0管理员  小于0被封禁   大于0小区负责人


    private static final Logger LOGGER = LoggerFactory.getLogger("Menu.class");

    public Menu() {
        //-------------------设置窗体基本属性----------------------
        LOGGER.info("构建Menu窗体");
        if (Menu.userStatus > 0) {
            setTitle("用户菜单");
        } else {
            setTitle("管理员菜单");
        }
        setBounds(100, 100, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        //-------------------设置菜单栏----------------------
        LOGGER.info("设置菜单栏");
        setJMenuBar(new myMenuBar());

        //-----------------设置数据滚动表格（center）------------------
        LOGGER.info("设置数据滚动表格");
        dataTable = new DataTable();//设置为静态成员值，方便调用
        JScrollPane jScrollPane = new JScrollPane(dataTable);
        c.add(jScrollPane, BorderLayout.CENTER);

        //--------------设置功能按钮（EAST）---------------
        LOGGER.info("设置右侧功能按钮");
        c.add(new buttonPanel(), BorderLayout.EAST);

        //-------------设置搜索框及搜索按钮（North）---------------------
        LOGGER.info("设置搜索框");
        c.add(new searchPanel(), BorderLayout.NORTH);

        menu = this;//设置为静态成员menu  方便其他方法调用
    }
}



