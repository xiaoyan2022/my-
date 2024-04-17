package com.Gcms.view;

/**
 * @author 3sh111
 * @date 2022/7/6
 * @apiNote
 */

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * 菜单栏容器
 */
public class myMenuBar extends JMenuBar {
    //-----------菜单栏设置---------------
    public myMenuBar() {
        //-----------一、小区管理-------------
        JMenu jMenu1 = new JMenu("社区管理");
        jMenu1.setIcon(new ImageIcon("src/main/resources/img/社区管理.png"));
        add(jMenu1);

        //-------------------1、小区管理人菜单项----------------------
        JMenuItem community = new JMenuItem("小区及负责人");
        community.setIcon(new ImageIcon("src/main/resources/img/小区及负责人.png"));
        community.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu.TableStatus = 1;
                Menu.currentTableName = "user";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量
            }
        });
        jMenu1.add(community);

        //-------------------2、投诉菜单项----------------------
        JMenuItem complaint = new JMenuItem("投诉管理");
        complaint.setIcon(new ImageIcon("src/main/resources/img/信息管理.png"));
        complaint.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu.TableStatus = 2;
                Menu.currentTableName = "complaint_management";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量

            }
        });
        jMenu1.add(complaint);

        //-----------二、设备管理-------------
        JMenu jMenu2 = new JMenu("设备管理");
        jMenu2.setIcon(new ImageIcon("src/main/resources/img/设备管理.png"));
        add(jMenu2);

        //-------------------1、设备与投放口菜单项----------------------
        JMenuItem device = new JMenuItem("设备与投放口");
        device.setIcon(new ImageIcon("src/main/resources/img/设备与投放口.png"));
        device.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.currentTableName = "equipment_list";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量
            }
        });
        jMenu2.add(device);


        //-------------------2、报修菜单项----------------------
        JMenuItem repair = new JMenuItem("报修信息");
        repair.setIcon(new ImageIcon("src/main/resources/img/信息管理.png"));
        repair.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu.TableStatus = 4;
                Menu.currentTableName = "repair_management";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量
            }
        });
        jMenu2.add(repair);


        //-----------三、垃圾管理-------------
        JMenu jMenu3 = new JMenu("垃圾管理");
        jMenu3.setIcon(new ImageIcon("src/main/resources/img/删除.png"));
        add(jMenu3);


        //-------------------1、垃圾分类----------------------
        JMenuItem classification = new JMenuItem("垃圾分类信息");
        classification.setIcon(new ImageIcon("src/main/resources/img/垃圾分类.png"));
        classification.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu.TableStatus = 5;
                Menu.currentTableName = "rubbish_classification";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量
            }
        });
        jMenu3.add(classification);

        //-------------------2、垃圾站----------------------
        JMenuItem station = new JMenuItem("垃圾站管理");
        station.setIcon(new ImageIcon("src/main/resources/img/垃圾站.png"));
        station.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu.TableStatus = 6;
                Menu.currentTableName = "rubbish_station";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量
            }
        });
        jMenu3.add(station);

        //-------------------3、垃圾运输----------------------
        JMenuItem transportation = new JMenuItem("垃圾运输信息");
        transportation.setIcon(new ImageIcon("src/main/resources/img/垃圾运输.png"));
        transportation.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Menu.TableStatus = 7;
                Menu.currentTableName = "rubbish_transportation";//设置当前操作表名
                Menu.dataTable.setTableModel();//重新加载DataTable的数据模型
                Menu.searchPanel.setComboBox();//重新加载搜索下拉栏的数据模型
                DataTable.columnCount = Menu.dataTable.getColumnCount();//获取当前表的属性数量
            }
        });
        jMenu3.add(transportation);

        //-------------------系统设置菜单栏----------------------
        JMenu jm4 = new JMenu("系统设置");
        jm4.setIcon(new ImageIcon("src/main/resources/img/设置.png"));
        add(jm4);
        JMenuItem sudo = new JMenuItem("退出登录");
        sudo.setIcon(new ImageIcon("src/main/resources/img/账号退出.png"));
        sudo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.menu.dispose();//关闭当前窗口
                Login login = new Login();//新建登录窗口
                login.setVisible(true);
            }
        });
        jm4.add(sudo);


        JMenuItem sudoItem = new JMenuItem("切换主题");
        sudoItem.setIcon(new ImageIcon("src/main/resources/img/主题切换.png"));
        sudoItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Login.themeStatus == 0) {
                    FlatDarkLaf.setup();
                    Login.themeStatus = 1;
                } else {
                    FlatLightLaf.setup();
                    Login.themeStatus = 0;
                }
                //关闭当前菜单并新建一个新菜单
                Menu.menu.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        jm4.add(sudoItem);

        JMenuItem exportFile = new JMenuItem("导出数据");
        exportFile.setIcon(new ImageIcon("src/main/resources/img/垃圾分类.png"));
        exportFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //构建文件选择器，选择需要保存的文件位置
                    JFileChooser jfs = new JFileChooser();
                    jfs.showSaveDialog(Menu.menu);
                    File selectedFile = jfs.getSelectedFile();
                    //调用DataTable.exportTable方法将dataTable中model数据写进选择的文件中（目前仅支持.xls格式）
                    DataTable.exportTable(Menu.dataTable, selectedFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        jm4.add(exportFile);
    }
}
