package com.Gcms.view;


import com.Gcms.serviceImpl.*;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author 3sh111
 * @date 2022/7/3
 * @apiNote 将JTable的一系列操作封装
 */
public class DataTable extends JTable {
    public static int SelectedRow;//用户点击--->选中的行
    public static int columnCount;//Table的属性数量
    public static String primaryKey;//主键（这里的主键都设为第一列）
    public static String[] columnNames;//表格的列名（属性）
    public static String[] LabelColumnNames;//属性的备注名
    public static Map<String, String> columnNamesMap = new HashMap<>();//键为属性，值为备注
    private static final Logger LOGGER = LoggerFactory.getLogger("DataTable.class");


    /**
     * 构造数据表 ： 设置了表格文本居中  加载的数据模型
     */
    public DataTable() {
        LOGGER.info("开始初始化数据表");
        setTableModel();
        //------------渲染单元格，设置文本居中--------------
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        setDefaultRenderer(Object.class, tcr);//设置渲染器
        //-------------------------------------------------

        columnCount = this.getColumnCount();//获取当前表的总列数
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TableModel model = getModel();
                primaryKey = model.getValueAt(getSelectedRow(), 0).toString();//设置主键：主键都被放在表结构的第一列
                SelectedRow = getSelectedRow();//设置选中的行数
                LOGGER.info("你选中的行数为：" + (SelectedRow + 1));//从0开始算 ---> 从1开始算
            }
        });//获取当前选中的行数
    }

    /**
     * 将selectAll返回的结果集转化为数据模型 并在Table中设置（实现刷新功能）
     */
    public void setTableModel() {
        DefaultTableModel dtm = null;
        switch (Menu.currentTableName) {//根据静态成员属性的值来选择显示的数据表
            case "user"://用户管理
                dtm = new UserServiceImpl().selectAll();
                break;
            case "complaint_management"://投诉管理
                dtm = new ComplaintServiceImpl().selectAll();
                break;
            case "equipment_list":
                dtm = new EquipmentListServiceImpl().selectAll();
                break;
            case "repair_management":
                dtm = new RepairServiceImpl().selectAll();
                break;
            case "rubbish_classification":
                dtm = new RubbishClassificationServiceImpl().selectAll();
                break;
            case "rubbish_station":
                dtm = new RubbishStationServiceImpl().selectAll();
                break;
            case "rubbish_transportation":
                dtm = new RubbishTransportationServiceImpl().selectAll();
                break;
        }
        //根据Menu.currentTableName来设置数据模型，显示DataTable
        if (dtm == null) {
            LOGGER.error("数据模型为空");
        } else {
            setModel(dtm);//将DataTable的数据模型设置为dtm，实现加载数据
        }

    }

    /**
     * 将结果集转化为表格数据模型 以供JTable使用
     *
     * @param resultSet
     * @return
     */
    public static DefaultTableModel toDefaultTableModel(ResultSet resultSet) {
        //------------从ResultSet中获取数据--------------
        Vector<String> headers = new Vector<>();//存储属性的备注
        Vector<String> attribute = new Vector<>();//存储属性
        Vector<Vector<String>> data = new Vector<>();//表数据
        try {
            //获取表头的属性名及备注名
            ResultSetMetaData metaData = resultSet.getMetaData();
            int column = metaData.getColumnCount();//获取属性个数
            for (int i = 1; i <= column; i++) {//从1开始
                headers.add(metaData.getColumnLabel(i));//getColumnLabel获取的是备注
                attribute.add(metaData.getColumnName(i));//getColumnName获取的是属性
                columnNamesMap.put(metaData.getColumnLabel(i), metaData.getColumnName(i));
            }

            //获取表数据 并存入data中
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();
                for (int i = 1; i <= column; i++) {
                    v.add(resultSet.getString(i));
                }
                data.add(v);
            }

            //将属性存入静态成员columnNames中，用于搜索框下拉栏调用
            columnNames = attribute.toArray(new String[0]);
            LabelColumnNames = headers.toArray(new String[0]);

            LOGGER.info(columnNamesMap.toString());
            LOGGER.info(Arrays.toString(columnNames));
            LOGGER.info(Arrays.toString(LabelColumnNames));

            //使用获取的数据构造数据模型DefaultTableModel
            return new DefaultTableModel(data, headers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 将当前GUI显示的表格导出到excel文件中
     *
     * @param jTable
     * @param file
     * @throws IOException
     */
    public static void exportTable(JTable jTable, File file) throws IOException {
        try {
            //创建输入流、数据模型
            OutputStream out = new FileOutputStream(file);
            TableModel model = jTable.getModel();
            WritableWorkbook wwb = Workbook.createWorkbook(out);
            // 创建字表，并写入数据
            WritableSheet ws = wwb.createSheet("中文", 0);
            // 添加标题
            for (int i = 0; i < model.getColumnCount(); i++) {
                jxl.write.Label labelN = new jxl.write.Label(i, 0, model.getColumnName(i));//获取列名
                try {
                    ws.addCell(labelN);//写入单元格
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
            // 添加列
            for (int i = 0; i < model.getColumnCount(); i++) {
                for (int j = 1; j <= model.getRowCount(); j++) {
                    jxl.write.Label labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());//获取数据
                    try {
                        ws.addCell(labelN);//写入单元格
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
            wwb.write();
            try {
                wwb.close();
            } catch (WriteException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "导出成功");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "导入数据前请关闭工作表");
        }
    }
}
