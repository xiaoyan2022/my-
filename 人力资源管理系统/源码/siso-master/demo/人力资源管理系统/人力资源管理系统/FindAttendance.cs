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
    public partial class FindAttendance : Form
    {
        public FindAttendance()
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

        private void OwnFindAttendance(string id)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
            SqlCommand comm = new SqlCommand("Select * from 考勤表 where 记录号='" + id + "'", conn);
            conn.Open();
            SqlDataReader reader = comm.ExecuteReader();
            if (reader.Read())
            {
                txt记录号.Text = id;
                txt计薪年月.Text = reader["计薪年月"].ToString();
                txt员工号.Text = reader["员工号"].ToString();
                txt应勤天数.Text = reader["应勤天数"].ToString();
                txt实际出勤.Text = reader["实际出勤"].ToString();
                txt病假天数.Text = reader["病假天数"].ToString();
                txt迟到早退.Text = reader["迟到早退"].ToString();
                txt婚葬产假.Text = reader["婚葬产假"].ToString();
                txt加班天数.Text = reader["加班天数"].ToString();
                txt矿工天数.Text = reader["矿工天数"].ToString();
                txt年假天数.Text = reader["年假天数"].ToString();
                txt事假天数.Text = reader["事假天数"].ToString();
                txt调休天数.Text = reader["调休天数"].ToString();
                richTextBox备注.Text = reader["备注"].ToString();
            }
            conn.Close();
        }


        private void btnFind_Click(object sender, EventArgs e)
        {
            OwnFindAttendance(txt记录号.Text);

        }
    }
}
