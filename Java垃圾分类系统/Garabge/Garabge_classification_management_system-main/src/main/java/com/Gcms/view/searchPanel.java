package com.Gcms.view;

/**
 * @author 3sh111
 * @date 2022/7/6
 * @apiNote
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 搜索栏容器
 */
public class searchPanel extends JPanel {
    public static JComboBox<String> comboBox;
    public static JTextField searchBar;

    public searchPanel() {
        setLayout(new FlowLayout());
        //---------------搜索的选择项------------

        comboBox = new JComboBox<>();
        setComboBox();
        add(comboBox);

        //--------------搜索框文本域------------
        searchBar = new JTextField();
        searchBar.setColumns(30);
        searchBar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.getSelect();
            }
        });
        add(searchBar);


        Menu.searchPanel = this;
    }

    public void setComboBox() {
        DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<>(DataTable.LabelColumnNames);
        comboBox.setModel(dcm);
    }
}
