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
    public partial class SearchInWages : Form
    {
        public SearchInWages()
        {
            InitializeComponent();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            string sql = "select * from 工资表 where 1=1";
            if (txtEmployeeID.Text != "") sql += " and 员工号 like '%" + txtEmployeeID.Text + "%'";
            if (txt计薪年月.Text != "") sql += " and 计薪年月 like '%" + txt计薪年月.Text + "%'";
            //if ((string)dateTime发放日期.Value != "") sql += " and 发放日期 like '%" + (string)dateTime发放日期.Value + "%'";
            if (txt月薪.Text != "") sql += " and 月薪 like '%" + txt月薪.Text + "%'";
            if (txt加班费.Text != "") sql += " and 加班费 like '%" + txt加班费.Text + "%'";
            if (txt实发工资.Text != "") sql += " and 实发工资 like '%" + txt实发工资.Text + "%'";
            if (txt高温补贴.Text != "") sql += " and 高温补贴 like '%" + txt高温补贴.Text + "%'";
            if (txt住房补贴.Text != "") sql += " and 住房补贴 like '%" + txt住房补贴.Text + "%'";
            if (txt交通补贴.Text != "") sql += " and 交通补贴 like '%" + txt交通补贴.Text + "%'";
            if (txt其他加项.Text != "") sql += " and 其他加项 like '%" + txt其他加项.Text + "%'";
            if (txt节假日补贴.Text != "") sql += " and 节假日补贴 like '%" + txt节假日补贴.Text + "%'";
            if (txt所得税.Text != "") sql += " and 所得税 like '%" + txt所得税.Text + "%'";
            if (txt公积金.Text != "") sql += " and 公积金 like '%" + txt公积金.Text + "%'";
            if (txt社会保险.Text != "") sql += " and 社会保险 like '%" + txt社会保险.Text + "%'";
            if (txt其他扣资.Text != "") sql += " and 其他扣资 like '%" + txt其他扣资.Text + "%'";
            if (txt制表人.Text != "") sql += " and 制表人 like '%" + txt制表人.Text + "%'";
            //if ((string)dateTime制表时间.Value != "") sql += " and 制表时间 like '%" + (string)dateTime制表时间.Value + "%'";
            if (txt审核人.Text != "") sql += " and 审核人 like '%" + txt审核人.Text + "%'";
            //if (dateTime审核时间.Text != "") sql += " and 审核时间 like '%" + dateTime审核时间.Text + "%'";
            if (richTextBox备注.Text != "") sql += " and 备注 like '%" + richTextBox备注.Text + "%'";
            SqlDataAdapter da = new SqlDataAdapter(sql, conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            frmWagesManagement main = this.Owner.ActiveMdiChild as frmWagesManagement;
            main.dataGridView1.AutoGenerateColumns = false;
            main.dataGridView1.DataSource = dt;
            this.Close();
            conn.Close();
        }
    }
}
