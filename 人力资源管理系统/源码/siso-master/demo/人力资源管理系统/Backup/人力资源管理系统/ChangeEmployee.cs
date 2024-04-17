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
    public partial class ChangeEmployee : Form
    {
        public ChangeEmployee()
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
        public string 员工号;
        //----------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------
        private void Over()
        {
            frmEmployeeManagement main = this.Owner.ActiveMdiChild as frmEmployeeManagement;
            DataGridViewRow row;
            if (main != null)
            {
                row = main.dataGridView1.SelectedRows[0];
                txtID.Text = row.Cells[0].Value.ToString();
                txtName.Text = row.Cells[1].Value.ToString();
                cmbSex.Text=row.Cells[2].Value.ToString();
                cmbPart.Text = row.Cells[3].Value.ToString();
                dateTimePicker1.Value = (DateTime)row.Cells[4].Value;
                txtWages.Text = row.Cells[5].Value.ToString();
                txtBankName.Text = row.Cells[6].Value.ToString();
                txtAccount.Text = row.Cells[7].Value.ToString();

                //checkBox1.Checked = (bool)row.Cells[2].Value;
                //dateTimePicker1.Value = (DateTime)row.Cells[3].Value;
                //comboBox1.Text = row.Cells[4].Value.ToString();
            }

        }
        //---------------------------------------------------------------------------------------------------------------------------------
        //private void FindEmployee(string id)
        //{
        //    SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
        //    SqlCommand comm = new SqlCommand("Select * from 员工表 where 员工号='" + id + "'", conn);
        //    conn.Open();
        //    SqlDataReader reader = comm.ExecuteReader();
        //    if (reader.Read())
        //    {
        //        txtID.Text = id;
        //        txtName.Text = reader["姓名"].ToString();
        //        cmbSex.Text = reader["性别"].ToString();
        //        cmbPart.Text = reader["部门"].ToString();
        //        dateTimePicker1.Value = (DateTime)reader["出生日期"];
        //        txtWages.Text = reader["月薪"].ToString();
        //        txtBankName.Text = reader["开户行"].ToString();
        //        txtAccount.Text = reader["账号"].ToString();
        //    }
        //}

        //private void btnFind_Click(object sender, EventArgs e)
        //{
        //    FindEmployee(txtID.Text);

        //}

        private void btnChange_Click(object sender, EventArgs e)
        {
            if (txtID.Text == "" || txtName.Text == "" || txtWages.Text == "" || cmbPart.Text == "" || cmbSex.Text == "")
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                conn.Open();
                string temp = txtID.Text;
                string SQL = "Select count(*) from 员工表 where 员工号='" + temp + "'";
                SqlCommand cmd1 = new SqlCommand(SQL, conn);
                int count1 = Convert.ToInt32(cmd1.ExecuteScalar());
                if (count1 == 0)
                {
                    MessageBox.Show("您输入的员工号不存在，请重新输入！", "操作提示");
                }
                else
                {
                    SqlCommand comm = new SqlCommand("update 员工表 set 姓名=@姓名,性别=@性别,出生日期=@出生日期,月薪=@月薪,部门=@部门,开户行=@开户行,账号=@账号 where 员工号=@员工号", conn);
                    comm.Parameters.AddWithValue("@员工号", txtID.Text);
                    comm.Parameters.AddWithValue("@姓名", txtName.Text);
                    comm.Parameters.AddWithValue("@性别", cmbSex.Text);
                    comm.Parameters.AddWithValue("@出生日期", dateTimePicker1.Value);
                    comm.Parameters.AddWithValue("@月薪", txtWages.Text);
                    comm.Parameters.AddWithValue("@部门", cmbPart.Text);
                    comm.Parameters.AddWithValue("@开户行", txtBankName.Text);
                    comm.Parameters.AddWithValue("@账号", txtAccount.Text);
                    comm.ExecuteNonQuery();
                    //----------------------更新数据库 5.17
                    frmEmployeeManagement main = this.Owner.ActiveMdiChild as frmEmployeeManagement;
                    if (main != null) main.FillData();
                    //----------------------更新数据库 5.17
                    MessageBox.Show("修改成功！");
                }
                conn.Close();
            }
        }

        private void ChangeEmployee_Load(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            SqlDataAdapter da = new SqlDataAdapter("select distinct  部门 from 员工表", conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            cmbPart.DisplayMember = "部门";
            cmbPart.ValueMember = "部门";
            cmbPart.DataSource = dt;

            //****************************************
            Over();

            //*****************************************
            cmbSex.SelectedIndex = 0;
            conn.Close();
        }
    }
}
