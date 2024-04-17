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
    public partial class AddReward : Form
    {
        public AddReward()
        {
            InitializeComponent();
        }

        //*************************   Enter改变焦点   ***************************************

        protected override bool ProcessDialogKey(Keys keyData)
        {
            if (keyData == Keys.Enter)
            {
                keyData = Keys.Tab;
            }
            return base.ProcessDialogKey(keyData);
        }

        //**********************************   Enter改变焦点   ****************************************

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (txt记录号.Text == "" || txt员工号.Text == "" || txt奖惩名称.Text == ""&&(radioButton1.Checked==false&&radioButton2.Checked==false))
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                conn.Open();
                //********************************    判断是否重复   ***************************************
                string id = txt记录号.Text;
                string sql = "Select count(*) from 奖惩表 where 记录号='" + id + "'";
                SqlCommand cmd = new SqlCommand(sql, conn);
                int count = Convert.ToInt32(cmd.ExecuteScalar());
                if (count > 0)
                {
                    MessageBox.Show("您添加的数据已经存在，请重新输入！", "操作提示");
                }
                else//********************************    判断是否重复   ***************************************
                {
                    string temp = txt员工号.Text;
                    string SQL = "Select count(*) from 员工表 where 员工号='" + temp + "'";
                    SqlCommand cmd1 = new SqlCommand(SQL, conn);
                    int count1 = Convert.ToInt32(cmd1.ExecuteScalar());
                    if (count1 == 0)
                    {
                        MessageBox.Show("您输入的员工号不存在，请重新输入！", "操作提示");
                    }
                    else
                    {
                        SqlCommand comm = new SqlCommand("insert into 奖惩表(记录号,员工号,奖惩名称,奖惩类型,计薪年月,奖惩日期,奖惩金额,奖惩原因) values(@记录号,@员工号,@奖惩名称,@奖惩类型,@计薪年月,@奖惩日期,@奖惩金额,@奖惩原因)", conn);
                        comm.Parameters.AddWithValue("@记录号", txt记录号.Text);
                        comm.Parameters.AddWithValue("@员工号", txt员工号.Text);
                        comm.Parameters.AddWithValue("@奖惩名称", txt奖惩名称.Text);
                        comm.Parameters.AddWithValue("@计薪年月", txt计薪年月.Text);
                        comm.Parameters.AddWithValue("@奖惩日期", dateTime奖惩日期.Value);
                        comm.Parameters.AddWithValue("@奖惩金额", txt奖惩金额.Text);
                        comm.Parameters.AddWithValue("@奖惩原因", richTextBox奖惩原因.Text);
                        if (radioButton1.Checked == true)
                        {
                            comm.Parameters.AddWithValue("@奖惩类型", "奖");
                        }
                        else if (radioButton2.Checked == true)
                        {
                            comm.Parameters.AddWithValue("@奖惩类型", "惩");
                        }
                        comm.ExecuteNonQuery();
                        //*******************************************************************************************************************************
                        frmRewardManagement main = this.Owner.ActiveMdiChild as frmRewardManagement;
                        if (main != null) main.FillData();
                        //********************************************************************************************************************************
                        MessageBox.Show("添加成功！");
                    }
                }
                conn.Close();
            }
        }
    }
}
