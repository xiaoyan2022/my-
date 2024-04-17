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
    public partial class AddEmployee : Form
    {
        public AddEmployee()
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

        private void AddEmployee_Load(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
            conn.Open();
            //------------------自动填充用户名和类型
            SqlDataAdapter da = new SqlDataAdapter("select distinct  部门 from 员工表", conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            cmbPart.DisplayMember = "部门";
            cmbPart.ValueMember = "部门";
            cmbPart.DataSource = dt;
            cmbSex.SelectedIndex = 0;
            conn.Close();

        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (txtID.Text==""||txtName.Text==""||txtWages.Text==""||cmbPart.Text==""||cmbSex.Text=="")
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {       
                SqlConnection conn = new SqlConnection("Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
                conn.Open();
                //********************************    判断是否重复   ***************************************
                string id = txtID.Text;
                string sql = "Select count(*) from 员工表 where 员工号='" + id + "'";
                SqlCommand cmd = new SqlCommand(sql, conn);
                int count = Convert.ToInt32(cmd.ExecuteScalar());
                if (count > 0)
                {                
                    MessageBox.Show("您添加的数据已经存在，请重新输入！", "操作提示");
                }
                else//********************************    判断是否重复   ***************************************
                {
                    SqlCommand comm = new SqlCommand("insert into 员工表(员工号,姓名,性别,出生日期,部门,月薪,开户行,账号) values(@员工号,@姓名,@性别,@出生日期,@部门,@月薪,@开户行,@账号)", conn);
                    comm.Parameters.AddWithValue("@员工号", txtID.Text);
                    comm.Parameters.AddWithValue("@姓名", txtName.Text);
                    comm.Parameters.AddWithValue("@性别", cmbSex.Text);
                    comm.Parameters.AddWithValue("@出生日期", dateTimePicker1.Value);
                    comm.Parameters.AddWithValue("@部门", cmbPart.Text);
                    comm.Parameters.AddWithValue("@月薪", txtWages.Text);
                    comm.Parameters.AddWithValue("@开户行", txtBankName.Text);
                    comm.Parameters.AddWithValue("@账号", txtAccount.Text);
                    comm.ExecuteNonQuery();
                    //this.Owner.ActiveMdiChild---------一级窗体下二级窗体  激活窗体
                    frmEmployeeManagement main = this.Owner.ActiveMdiChild as frmEmployeeManagement;
                    if (main != null) main.FillData();
                    MessageBox.Show("添加成功！");
                }
                conn.Close();
            }
        }
    }
}
