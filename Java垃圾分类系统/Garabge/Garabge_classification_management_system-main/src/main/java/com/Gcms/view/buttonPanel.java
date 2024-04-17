package com.Gcms.view;

/**
 * @author 3sh111
 * @date 2022/7/6
 * @apiNote
 */

import com.Gcms.dao.BaseDao;
import com.Gcms.serviceImpl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 按钮栏容器
 */
public class buttonPanel extends JPanel {
    public static final Logger LOGGER = LoggerFactory.getLogger("buttonPanel.class");

    /**
     * 从多选框和文本框中获取sql的参数，执行SQL并将数据加载到DataTable中
     */
    public static void getSelect() {//获取查找的sql
        String attribute = (String) searchPanel.comboBox.getSelectedItem();//从多选框中获取所需查询的字段
        String num = searchPanel.searchBar.getText();//从文本框中获取所需查询的值
        String sql = null;
        if (Menu.userStatus > 0 && Menu.currentTableName.equals("user")) {
            sql = "select  name as '负责人',communityName as '小区' , email as '邮箱', phone as '手机号',createTime as '创建时间' from "
                    + Menu.currentTableName + " where " + attribute + " like '%" + num +"%';";
        } else {
            StringBuilder sb = new StringBuilder("select ");
            int length = DataTable.columnNames.length;
            for (int i = 0; i < length; i++) {
                sb.append(DataTable.columnNames[i]);
                sb.append(" as ");
                sb.append(DataTable.LabelColumnNames[i]);
                if (i < length - 1) {
                    sb.append(" , ");
                }
            }
            sb.append(" from ");
            sb.append(Menu.currentTableName);
            sb.append(" where ");
            sb.append(DataTable.columnNamesMap.get(attribute));
            sb.append(" like '%");
            sb.append(num);
            sb.append("%';");
            //sql = "select * from " + Menu.currentTableName + " where " + attribute + " like '%" + num + "%';";
            sql = sb.toString();//StringBuilder转化为String
        }
        LOGGER.info("当前执行的SQL为：" + sql);
        BaseDao.openConnection();
        ResultSet rs = null;
        try {
            rs = BaseDao.execute(BaseDao.conn, null, null, sql);
            DefaultTableModel dtm = DataTable.toDefaultTableModel(rs);
            Menu.dataTable.setModel(dtm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public buttonPanel() {
        setLayout(new GridLayout(6, 1));
        //---------------查找按钮---------------
        JButton selectBtn = new JButton("查找");
        selectBtn.setIcon(new ImageIcon("src/main/resources/img/查找.png"));
        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelect();
            }
        });
        add(selectBtn);


        //------------增加按钮---------------
        JButton addBtn = new JButton("增加");
        if (Menu.userStatus > 0) {
            addBtn.setEnabled(false);
        }
        addBtn.setIcon(new ImageIcon("src/main/resources/img/增加.png"));
        addBtn.addActionListener(e -> {
            DataPanel dataPanel = new DataPanel(Menu.menu, "insert");//构建数据面板执行插入操作
            dataPanel.setVisible(true);
            Menu.dataTable.setTableModel();//刷新
        });

        //------------删除按钮---------------
        JButton deleteBtn = new JButton("删除");
        if (Menu.userStatus > 0) {
            deleteBtn.setEnabled(false);
        }
        deleteBtn.setIcon(new ImageIcon("src/main/resources/img/删除.png"));
        deleteBtn.addActionListener(e -> {
            if (Menu.dataTable.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "请选择需要删除的行");
                return;
            }
            int flag = JOptionPane.showConfirmDialog(null, "是否确定删除");
            LOGGER.info("删除确认面板（0是 1否 2取消）：" + flag);
            if (flag == 0) {//当flag为0 时 为确定
                switch (Menu.currentTableName) {
                    case "user"://用户删除
                        new UserServiceImpl().delete(DataTable.primaryKey);
                        Menu.dataTable.setTableModel();//刷新
                        break;
                    case "complaint_management":
                        new ComplaintServiceImpl().delete(Integer.parseInt(DataTable.primaryKey));
                        Menu.dataTable.setTableModel();//刷新
                        break;
                    case "equipment_list":
                        new EquipmentListServiceImpl().delete(Integer.parseInt(DataTable.primaryKey));
                        Menu.dataTable.setTableModel();//刷新
                        break;
                    case "repair_management":
                        new RepairServiceImpl().delete(Integer.parseInt(DataTable.primaryKey));
                        Menu.dataTable.setTableModel();//刷新
                        break;
                    case "rubbish_classification":
                        new RubbishClassificationServiceImpl().delete(Integer.parseInt(DataTable.primaryKey));
                        Menu.dataTable.setTableModel();//刷新
                        break;
                    case "rubbish_station":
                        new RubbishStationServiceImpl().delete(Integer.parseInt(DataTable.primaryKey));
                        Menu.dataTable.setTableModel();//刷新
                        break;
                    case "rubbish_transportation":
                        new RubbishTransportationServiceImpl().delete(Integer.parseInt(DataTable.primaryKey));
                        Menu.dataTable.setTableModel();//刷新
                        break;
                }
            }
        });

        //------------修改按钮---------------
        JButton updateBtn = new JButton("修改");
        if (Menu.userStatus > 0) {
            updateBtn.setEnabled(false);
        }
        updateBtn.setIcon(new ImageIcon("src/main/resources/img/修改.png"));
        updateBtn.addActionListener(e -> {
            if (Menu.dataTable.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(Menu.menu, "请选中所需修改行");
            } else {
                DataPanel dataPanel = new DataPanel(Menu.menu, "update");
                dataPanel.setVisible(true);
                Menu.dataTable.setTableModel();//刷新
            }
        });

        //------------刷新按钮---------------
        JButton f5 = new JButton("刷新");
        f5.setIcon(new ImageIcon("src/main/resources/img/刷新.png"));
        f5.addActionListener(e -> Menu.dataTable.setTableModel());

        //----------统计按钮---------------
        JButton count = new JButton("统计");
        count.setIcon(new ImageIcon("src/main/resources/img/统计.png"));
        count.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = Menu.dataTable.getRowCount();
                JOptionPane.showMessageDialog(null, "共有" + rowCount + "条数据");
            }
        });

        add(addBtn);
        add(deleteBtn);
        add(updateBtn);
        add(f5);
        add(count);
    }
}
