package com.Gcms.view;

import com.Gcms.serviceImpl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

/**
 * @author 3sh111
 * @date 2022/7/4
 * @apiNote 更新 与 新增 数据
 */
public class DataPanel extends JDialog {

    private static final Logger LOGGER = LoggerFactory.getLogger("DataPanel.class");

    public DataPanel(Menu menu, String model) throws ArrayIndexOutOfBoundsException {
        super(menu, "数据面板", true);//使用父类的构造器，对父容器的进程进行阻塞
        LOGGER.info("构建DataPanel面板");
        setBounds(200, 200, 400, 300);
        setLayout(new GridLayout(DataTable.columnCount + 1, 3));
        Menu.dataPanel = this;

        //存储 ”插入” 和 “更新” 操作中不需要 或 不能操作的属性
        HashSet<String> insert = new HashSet<>();
        insert.add("创建时间");//user
        insert.add("用户ID");//complainant
        insert.add("报修ID");//repair
        insert.add("设备ID");//equipment
        insert.add("垃圾分类ID");//rubbishClassification
        insert.add("垃圾站ID");//rubbishStation
        insert.add("垃圾运输ID");//rubbishTransportation

        HashSet<String> update = new HashSet<>();
        update.add("用户名");//user
        update.add("用户ID");//complainant
        update.add("报修ID");//repair
        update.add("设备ID");//equipment
        update.add("垃圾站ID");//rubbishStation
        update.add("垃圾分类ID");//rubbishClassification
        update.add("垃圾运输ID");//rubbishTransportation

        //构建数据面板组件 JLabel  和  JTextField
        Vector<JTextField> jTextFields = new Vector<>();
        Vector<JLabel> jLabels = new Vector<>();
        for (int i = 0; i < DataTable.columnCount; i++) {
            //从数据表中获取列名，以列名构造JTable
            String columnName = Menu.dataTable.getColumnName(i);//获取数据模型的列名（这里是表的备注名）
            JLabel jLabel = new JLabel(columnName);
            jLabels.add(jLabel);//加入集合中
            jLabel.setHorizontalAlignment(JLabel.CENTER);//文本居中
            add(jLabel);

            //构建文本输入框
            //----------------数据更新--------------------
            if (model.equals("update")) {
                //数据回显：将所选行的数据显示到文本框中
                String content = Menu.dataTable.getValueAt(Menu.dataTable.getSelectedRow(), i).toString();
                JTextField jTextField = new JTextField(content);
                jTextField.setColumns(20);
                if (update.contains(columnName)) {//集合中存在的为不可更改的属性
                    jTextField.setEditable(false);//将文本框设置为不可编辑
                }
                add(jTextField);
                jTextFields.add(jTextField);

                //----------------数据新增----------------
            } else if (model.equals("insert")) {
                JTextField jTextField = new JTextField();
                jTextField.setColumns(20);
                if (insert.contains(columnName)) {//集合中存在的属性名为无需设置的属性  数据库中会自行设置
                    jTextField.setEditable(false);
                }
                add(jTextField);
                jTextFields.add(jTextField);
            }
        }


        //------------------编辑好后的执行SQL操作---------------------

        //获取SQL语句参数
        //将JTextField的数据转化为字符串 并传入update/insert方法中
        Vector<String> paramsV = new Vector<>();
        JButton confirm = new JButton("确定");
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;//操作完毕后 flag=true ， 数据面板会关闭
                //----------------------更新----------------------
                if (model.equals("update")) {//更新
                    for (int i = 0; i < DataTable.columnCount; i++) {
                        String text = jTextFields.get(i).getText();
                        //若“文本框无内容” 且 “该框的属性需要输入内容”时， 提醒用户输入内容
                        if (text.equals("") && !update.contains(jLabels.get(i).getText())) {
                            JOptionPane.showMessageDialog(null, "文本不能为空");
                            paramsV.removeAllElements();
                            return;
                        }
                        paramsV.add(text);
                    }
                    String[] params = paramsV.toArray(new String[0]);//将vector转化为数组
                    LOGGER.info("传入的参数为：" + Arrays.toString(params));
                    switch (Menu.currentTableName) {//判断操作哪个表
                        case "user":
                            flag = new UserServiceImpl().update(params);
                            break;
                        case "complaint_management":
                            flag = new ComplaintServiceImpl().update(params);
                            break;
                        case "equipment_list":
                            flag = new EquipmentListServiceImpl().update(params);
                            break;
                        case "repair_management":
                            flag = new RepairServiceImpl().update(params);
                            break;
                        case "rubbish_classification":
                            flag = new RubbishClassificationServiceImpl().update(params);
                            break;
                        case "rubbish_station":
                            flag = new RubbishStationServiceImpl().update(params);
                            break;
                        case "rubbish_transportation":
                            flag = new RubbishTransportationServiceImpl().update(params);
                            break;
                    }
                    //---------------------注册-------------------------
                } else if (model.equals("insert")) {//注册
                    for (int i = 0; i < DataTable.columnCount; i++) {
                        String text = jTextFields.get(i).getText();
                        if (text.equals("") && !insert.contains(jLabels.get(i).getText())) {
                            JOptionPane.showMessageDialog(null, "文本不能为空");
                            paramsV.removeAllElements();
                            return;
                        }
                        paramsV.add(text);
                    }
                    String[] params = paramsV.toArray(new String[0]);
                    LOGGER.info("传入的参数为：" + Arrays.toString(params));
                    switch (Menu.currentTableName) {
                        case "user":
                            flag = new UserServiceImpl().register(params);
                            break;
                        case "complaint_management":
                            flag = new ComplaintServiceImpl().add(params);
                            break;
                        case "equipment_list":
                            flag = new EquipmentListServiceImpl().add(params);
                            break;
                        case "repair_management":
                            flag = new RepairServiceImpl().add(params);
                            break;
                        case "rubbish_classification":
                            flag = new RubbishClassificationServiceImpl().add(params);
                            break;
                        case "rubbish_station":
                            flag = new RubbishStationServiceImpl().add(params);
                            break;
                        case "rubbish_transportation":
                            flag = new RubbishTransportationServiceImpl().add(params);
                            break;
                    }
                }

                if (flag) {//flag初始值为false，当操作执行成功后关闭数据操作窗口
                    Menu.dataPanel.dispose();
                }
            }
        });
        add(confirm);

        //--------------------重置，清空所有文本框数据----------------
        JButton reset = new JButton("重置");
        reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < DataTable.columnCount; i++) {
                    //遍历清空jTextFields集合中所有文本框的内容
                    jTextFields.get(i).setText("");
                }
                System.out.println("文本已经清空");
            }
        });
        add(reset);
    }
}
