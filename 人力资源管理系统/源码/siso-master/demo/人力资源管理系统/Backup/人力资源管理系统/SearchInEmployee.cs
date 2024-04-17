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
    public partial class SearchInEmployee : Form
    {
        public SearchInEmployee()
        {
            InitializeComponent();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            string sql = "select * from 员工表 where 1=1";
            if (txtID.Text != "") sql += " and 员工号 like '%" + txtID.Text + "%'";
            if (txtName.Text != "") sql += " and 姓名 like '%" + txtName.Text + "%'";
            if (cmbSex.Text != "") sql += " and 性别 like '%" + cmbSex.Text + "%'";
            if (cmbPart.Text != "") sql += " and 部门 like '%" + cmbPart.Text + "%'";
            if (txtWages.Text != "") sql += " and 月薪 like '%" + txtWages.Text + "%'";
            if (txtBankName.Text != "") sql += " and 开户行 like '%" + txtBankName.Text + "%'";
            if (txtAccount.Text != "") sql += " and 账号 like '%" + txtAccount.Text + "%'";

            //if (dateTimePicker1.Value != "") sql += " and 出生日期 like '%" + dateTimePicker1.Value + "%'";
            SqlDataAdapter da = new SqlDataAdapter(sql, conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            frmEmployeeManagement main = this.Owner.ActiveMdiChild as frmEmployeeManagement;
            main.dataGridView1.AutoGenerateColumns = false;
            main.dataGridView1.DataSource = dt;
            this.Close();
            conn.Close();
        }
    }
}
