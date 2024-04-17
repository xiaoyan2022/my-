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
    public partial class FindWages : Form
    {
        public FindWages()
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

        private void OwnFindWages(string id)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
            SqlCommand comm = new SqlCommand("Select * from 工资表 where 流水号='" + id + "'", conn);
            conn.Open();
            SqlDataReader reader = comm.ExecuteReader();
            if (reader.Read())
            {
                txtNO.Text = id;
                txtEmployeeID.Text = reader["员工号"].ToString();
                txt高温补贴.Text = reader["高温补贴"].ToString();
                txt公积金.Text = reader["公积金"].ToString();
                txt计薪年月.Text = reader["计薪年月"].ToString();
                txt加班费.Text = reader["加班费"].ToString();
                txt交通补贴.Text = reader["交通补贴"].ToString();
                txt其他加项.Text = reader["其他加项"].ToString();
                txt其他扣资.Text = reader["其他扣资"].ToString();
                txt社会保险.Text = reader["社会保险"].ToString();
                txt审核人.Text = reader["审核人"].ToString();
                txt实发工资.Text = reader["实发工资"].ToString();
                txt所得税.Text = reader["所得税"].ToString();
                txt月薪.Text = reader["月薪"].ToString();
                txt制表人.Text = reader["制表人"].ToString();
                txt住房补贴.Text = reader["住房补贴"].ToString();
                txt节假日补贴.Text = reader["节假日补贴"].ToString();
                richTextBox备注.Text = reader["备注"].ToString();
                dateTime发放日期.Value = (DateTime)reader["发放日期"];
                dateTime审核时间.Value = (DateTime)reader["审核时间"];
                dateTime制表时间.Value = (DateTime)reader["制表时间"];               
            }
            conn.Close();
        }

        private void btnFind_Click(object sender, EventArgs e)
        {
            OwnFindWages(txtNO.Text);
        }
    }
}
