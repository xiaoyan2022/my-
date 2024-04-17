using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Data.SqlClient;

namespace 人力资源管理系统
{
    public partial class SearchInReward : Form
    {
        public SearchInReward()
        {
            InitializeComponent();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            //string temp1;
            //string temp2;

            //if (radioButton1.Checked==true)
            //{
            //    temp1 = "奖";
            //}
            //else if (radioButton2.Checked==true)
            //{
            //    temp2 = "惩";
            //}

            SqlConnection conn = new SqlConnection("Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            string sql = "select * from 奖惩表 where 1=1";
            if (txt记录号.Text != "") sql += " and 记录号 like '%" + txt记录号.Text + "%'";
            if (txt员工号.Text != "") sql += " and 员工号 like '%" + txt员工号.Text + "%'";
            if (txt奖惩名称.Text != "") sql += " and 奖惩名称 like '%" + txt奖惩名称.Text + "%'";
            if (txt计薪年月.Text != "") sql += " and 计薪年月 like '%" + txt计薪年月.Text + "%'";
            if (txt奖惩金额.Text != "") sql += " and 奖惩金额 like '%" + txt奖惩金额.Text + "%'";
            if (richTextBox奖惩原因.Text != "") sql += " and 奖惩原因 like '%" + richTextBox奖惩原因.Text + "%'";
            //if (dateTime奖惩日期.Value != "") sql += " and 奖惩日期 like '%" + dateTime奖惩日期.Value + "%'";
            //if (radioButton1.Checked == true) sql += " and 奖惩类型 like '%" + temp1 + "%'";
            //if (radioButton2.Checked == true) sql += " and 奖惩类型 like '%" + temp2 + "%'";
            SqlDataAdapter da = new SqlDataAdapter(sql, conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            frmRewardManagement main = this.Owner.ActiveMdiChild as frmRewardManagement;
            main.dataGridView1.AutoGenerateColumns = false;
            main.dataGridView1.DataSource = dt;
            this.Close();
            conn.Close();
        }
    }
}
