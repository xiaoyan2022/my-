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
    public partial class ChangeReward : Form
    {
        public ChangeReward()
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

        //----------------------------------------------------------------------------
        public string 记录ID;
        //----------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------
        private void Over()
        {
            frmRewardManagement main = this.Owner.ActiveMdiChild as frmRewardManagement;
            DataGridViewRow row;
            if (main != null)
            {
                row = main.dataGridView1.SelectedRows[0];
                txt记录号.Text = row.Cells[0].Value.ToString();
                txt员工号.Text = row.Cells[1].Value.ToString();
                //*****************************************************************************************************
                if ((string)row.Cells[2].Value=="奖")
                {
                    radioButton1.Checked = true;

                }
                else if ((string)row.Cells[2].Value=="惩")
                {
                    radioButton2.Checked = true;

                }
                //*******************************************************************************************************
                txt奖惩名称.Text = row.Cells[3].Value.ToString();
                txt奖惩金额.Text = row.Cells[4].Value.ToString();
                txt计薪年月.Text = row.Cells[5].Value.ToString();
                dateTime奖惩日期.Value = (DateTime)row.Cells[6].Value;
                richTextBox奖惩原因.Text = row.Cells[7].Value.ToString();

                //checkBox1.Checked = (bool)row.Cells[2].Value;
                //dateTimePicker1.Value = (DateTime)row.Cells[3].Value;
                //comboBox1.Text = row.Cells[4].Value.ToString();
            }

        }
        //---------------------------------------------------------------------------------------------------------------------------------

        //private void OwnFindReward(string id)
        //{
        //    SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
        //    SqlCommand comm = new SqlCommand("Select * from 奖惩表 where 员工号='" + id + "'", conn);
        //    conn.Open();
        //    SqlDataReader reader = comm.ExecuteReader();
        //    if (reader.Read())
        //    {
        //        txt员工号.Text = id;
        //        txt计薪年月.Text = reader["计薪年月"].ToString();
        //        txt奖惩金额.Text = reader["奖惩金额"].ToString();
        //        txt奖惩名称.Text = reader["奖惩名称"].ToString();
        //        txt员工号.Text = reader["员工号"].ToString();
        //        richTextBox奖惩原因.Text = reader["奖惩原因"].ToString();
        //        dateTime奖惩日期.Value = (DateTime)reader["奖惩日期"];

        //        if (reader["奖惩类型"].ToString() == "奖")
        //        {
        //            radioButton1.Checked = true;
        //        }
        //        else
        //        {
        //            radioButton2.Checked = true;
        //        }
        //    }
        //}

        //private void btnFind_Click(object sender, EventArgs e)
        //{
        //    OwnFindReward(txt员工号.Text);
        //}

        private void btnChange_Click(object sender, EventArgs e)
        {
            if (txt记录号.Text == "" || txt员工号.Text == "" || txt奖惩名称.Text == "" && (radioButton1.Checked == false && radioButton2.Checked == false))
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                conn.Open();
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
                    SqlCommand comm = new SqlCommand("update 奖惩表 set 员工号=@员工号,奖惩名称=@奖惩名称,奖惩类型=@奖惩类型,计薪年月=@计薪年月,奖惩日期=@奖惩日期,奖惩金额=@奖惩金额,奖惩原因=@奖惩原因 where 记录号=@记录号", conn);
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
                    //----------------------更新数据
                    frmRewardManagement main = this.Owner.ActiveMdiChild as frmRewardManagement;
                    if (main != null) main.FillData();
                    //----------------------更新数据
                    MessageBox.Show("修改成功！");
                }
                conn.Close();
            }
        }
        private void ChangeReward_Load(object sender, EventArgs e)
        {
            Over();

        }
    }
}
