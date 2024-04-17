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
    public partial class SearchInAttendance : Form
    {
        public SearchInAttendance()
        {
            InitializeComponent();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
            conn.Open();
            string sql = "select * from 考勤表 where 1=1";
            if (txt记录号.Text != "") sql += " and 记录号 like '%" + txt记录号.Text + "%'";
            if (txt员工号.Text != "") sql += " and 员工号 like '%" + txt员工号.Text + "%'";
            if (txt计薪年月.Text != "") sql += " and 计薪年月 like '%" + txt计薪年月.Text + "%'";
            if (txt应勤天数.Text != "") sql += " and 应勤天数 like '%" + txt应勤天数.Text + "%'";
            if (txt矿工天数.Text != "") sql += " and 矿工天数 like '%" + txt矿工天数.Text + "%'";
            if (txt实际出勤.Text != "") sql += " and 实际出勤 like '%" + txt实际出勤.Text + "%'";
            if (txt加班天数.Text != "") sql += " and 加班天数 like '%" + txt加班天数.Text + "%'";
            if (txt事假天数.Text != "") sql += " and 事假天数 like '%" + txt事假天数.Text + "%'";
            if (txt病假天数.Text != "") sql += " and 病假天数 like '%" + txt病假天数.Text + "%'";
            if (txt婚葬产假.Text != "") sql += " and 婚葬产假 like '%" + txt婚葬产假.Text + "%'";
            if (txt调休天数.Text != "") sql += " and 调休天数 like '%" + txt调休天数.Text + "%'";
            if (txt迟到早退.Text != "") sql += " and 迟到早退 like '%" + txt迟到早退.Text + "%'";
            if (txt年假天数.Text != "") sql += " and 年假天数 like '%" + txt年假天数.Text + "%'";
            if (richTextBox备注.Text != "") sql += " and 备注 like '%" + richTextBox备注.Text + "%'";
            SqlDataAdapter da = new SqlDataAdapter(sql, conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            frmAttendanceManagement main = this.Owner.ActiveMdiChild as frmAttendanceManagement;
            main.dataGridView1.AutoGenerateColumns = false;
            main.dataGridView1.DataSource = dt;
            this.Close();
            conn.Close();
        }
    }
}
