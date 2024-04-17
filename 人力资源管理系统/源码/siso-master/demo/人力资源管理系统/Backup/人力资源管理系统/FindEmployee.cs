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
    public partial class FindEmployee : Form
    {
        public FindEmployee()
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

        private void OwnFindEmployee(string id)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
            SqlCommand comm = new SqlCommand("Select * from 员工表 where 员工号='" + id + "'", conn);
            conn.Open();
            SqlDataReader reader = comm.ExecuteReader();
            if (reader.Read())
            {
                txtID.Text = id;
                txtName.Text = reader["姓名"].ToString();
                cmbSex.Text = reader["性别"].ToString();
                cmbPart.Text = reader["部门"].ToString();
                dateTimePicker1.Value = (DateTime)reader["出生日期"];
                txtWages.Text = reader["月薪"].ToString();
                txtBankName.Text = reader["开户行"].ToString();
                txtAccount.Text = reader["账号"].ToString();

            }
            conn.Close();
        }


        private void btnFind_Click(object sender, EventArgs e)
        {
            OwnFindEmployee(txtID.Text);
        }
    }
}
