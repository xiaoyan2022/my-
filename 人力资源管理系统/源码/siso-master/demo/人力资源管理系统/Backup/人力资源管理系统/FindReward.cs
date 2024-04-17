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
    public partial class FindReward : Form
    {
        public FindReward()
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

        private void OwnFindReward(string id)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
            SqlCommand comm = new SqlCommand("Select * from 奖惩表 where 记录号='" + id + "'", conn);
            conn.Open();
            SqlDataReader reader = comm.ExecuteReader();
            if (reader.Read())
            {
                txt记录号.Text = id;
                txt计薪年月.Text = reader["计薪年月"].ToString();
                txt奖惩金额.Text = reader["奖惩金额"].ToString();
                txt奖惩名称.Text = reader["奖惩名称"].ToString();
                txt员工号.Text = reader["员工号"].ToString();
                richTextBox奖惩原因.Text = reader["奖惩原因"].ToString();
                dateTime奖惩日期.Value = (DateTime)reader["奖惩日期"];

                if (reader["奖惩类型"].ToString()=="奖")
                {
                    radioButton1.Checked = true;
                }
                else
                {
                    radioButton2.Checked = true;
                }
            }
            conn.Close();
        }
        private void btnFind_Click(object sender, EventArgs e)
        {
            OwnFindReward(txt记录号.Text);
        }
    }
}
