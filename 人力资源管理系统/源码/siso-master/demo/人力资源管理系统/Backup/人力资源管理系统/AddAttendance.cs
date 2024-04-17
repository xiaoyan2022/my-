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
    public partial class AddAttendance : Form
    {
        public AddAttendance()
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

        /// <summary>
        /// 必须全部填完才能成功添加
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (txt记录号.Text == "" || txt计薪年月.Text == "" || txt员工号.Text == "" || txt应勤天数.Text == "" || txt实际出勤.Text == "")
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                conn.Open();
                //********************************    判断是否重复   ***************************************
                string id = txt记录号.Text;
                string sql = "Select count(*) from 考勤表 where 记录号='" + id + "'";
                SqlCommand cmd = new SqlCommand(sql, conn);
                int count = Convert.ToInt32(cmd.ExecuteScalar());
                if (count > 0)
                {
                    MessageBox.Show("您添加的数据已经存在，请重新输入！", "操作提示");
                }
                else//********************************    判断是否重复   ***************************************
                { 
                    string temp = txt员工号.Text;
                    string SQL = "Select count(*) from 考勤表 where 员工号='" + temp + "'";
                    SqlCommand cmd1 = new SqlCommand(SQL, conn);
                    int count1 = Convert.ToInt32(cmd1.ExecuteScalar());
                    if (count1 > 0)
                    {
                        MessageBox.Show("您输入的员工号已存在，请重新输入！", "操作提示");
                    }
                    else
                    {
                        string temp1 = txt员工号.Text;
                        string SQL1 = "Select count(*) from 员工表 where 员工号='" + temp1 + "'";
                        SqlCommand cmd2 = new SqlCommand(SQL1, conn);
                        int count2 = Convert.ToInt32(cmd2.ExecuteScalar());
                        if (count2 == 0)
                        {
                            MessageBox.Show("您输入的员工号不存在，请重新输入！", "操作提示");
                        }
                        else
                        {
                            SqlCommand comm = new SqlCommand("insert into 考勤表(记录号,计薪年月,员工号,应勤天数,实际出勤,加班天数,事假天数,病假天数,年假天数,婚葬产假,调休天数,矿工天数,迟到早退,备注) values(@记录号,@计薪年月,@员工号,@应勤天数,@实际出勤,@加班天数,@事假天数,@病假天数,@年假天数,@婚葬产假,@调休天数,@矿工天数,@迟到早退,@备注)", conn);
                            comm.Parameters.AddWithValue("@记录号", txt员工号.Text);
                            comm.Parameters.AddWithValue("@计薪年月", txt计薪年月.Text);
                            comm.Parameters.AddWithValue("@员工号", txt员工号.Text);
                            comm.Parameters.AddWithValue("@应勤天数", txt应勤天数.Text);
                            comm.Parameters.AddWithValue("@实际出勤", txt实际出勤.Text);
                            comm.Parameters.AddWithValue("@加班天数", txt加班天数.Text);
                            comm.Parameters.AddWithValue("@事假天数", txt事假天数.Text);
                            comm.Parameters.AddWithValue("@病假天数", txt病假天数.Text);
                            comm.Parameters.AddWithValue("@年假天数", txt年假天数.Text);
                            comm.Parameters.AddWithValue("@婚葬产假", txt婚葬产假.Text);
                            comm.Parameters.AddWithValue("@调休天数", txt调休天数.Text);
                            comm.Parameters.AddWithValue("@矿工天数", txt矿工天数.Text);
                            comm.Parameters.AddWithValue("@迟到早退", txt迟到早退.Text);
                            comm.Parameters.AddWithValue("@备注", richTextBox备注.Text);
                            comm.ExecuteNonQuery();
                            //*********************************************************************************************************
                            frmAttendanceManagement main = this.Owner.ActiveMdiChild as frmAttendanceManagement;
                            if (main != null) main.FillData();
                            //*********************************************************************************************************
                            MessageBox.Show("添加成功！");
                        }
                    }
                }
                conn.Close();
            }
        }
    }
}
