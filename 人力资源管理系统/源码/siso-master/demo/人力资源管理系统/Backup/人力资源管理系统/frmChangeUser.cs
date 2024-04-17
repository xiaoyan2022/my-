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
    public partial class frmChangeUser : Form
    {
        public frmChangeUser()
        {
            InitializeComponent();
        }

        //**************************封装字段，隐藏按钮***********************************
        private int state;

        public int State
        {
            get { return state; }
            set { state = value; }
        }
        //**************************封装字段，隐藏按钮***********************************

        private void frmChangeUser_Load(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            //------------------自动填充用户名和类型
            SqlDataAdapter da = new SqlDataAdapter("select distinct  UserName from UserTable", conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            cmbUserName.DisplayMember = "UserName";
            cmbUserName.ValueMember = "UserName";
            cmbUserName.DataSource = dt;
            SqlDataAdapter da1 = new SqlDataAdapter("select distinct  Type from UserTable", conn);
            DataTable dt1 = new DataTable();
            da1.Fill(dt1);
            cmbType.DisplayMember = "Type";
            cmbType.ValueMember = "Type";
            cmbType.DataSource = dt1;
            conn.Close();


            //*****************************   隐藏按钮   ******************************************

            if (State==0)
            {
                btnAdd.Visible = false;
                btnChange.Visible = false;
                btnDelete.Visible = false;
            }
            else if (State==1)
            {
                btnFind.Visible = false;
                btnChange.Visible = false;
                btnDelete.Visible = false;

            }
            else if (State==2)
            {
                btnFind.Visible = false;
                btnAdd.Visible = false;
                btnDelete.Visible = false;

            }
            else if (State==3)
            {
                btnFind.Visible = false;
                btnAdd.Visible = false;
                btnChange.Visible = false;

            }

            //*****************************   隐藏按钮   ******************************************



        }

        private void btnFind_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
            conn.Open();
            SqlCommand comm = new SqlCommand("Select * from UserTable where UserName=@UserName", conn);
            comm.Parameters.AddWithValue("@UserName", cmbUserName.Text);
            SqlDataReader reader = comm.ExecuteReader();
            if (reader.Read())
            {
                txtPassWord.Text = reader["PassWord"].ToString();
                cmbType.Text = reader["Type"].ToString();
            }
            //----------------数据库有修改时，自动更新
            //SqlDataAdapter da = new SqlDataAdapter("select distinct  UserName from UserTable", conn);
            //DataTable dt = new DataTable();
            //da.Fill(dt);
            //cmbUserName.DisplayMember = "UserName";
            //cmbUserName.ValueMember = "UserName";
            //cmbUserName.DataSource = dt;
            //SqlDataAdapter da1 = new SqlDataAdapter("select distinct  Type from UserTable", conn);
            //DataTable dt1 = new DataTable();
            //da1.Fill(dt1);
            //cmbType.DisplayMember = "Type";
            //cmbType.ValueMember = "Type";
            //cmbType.DataSource = dt1;
            //conn.Close();
            conn.Close();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            //********************************    判断是否重复   ***************************************
            string id = cmbUserName.Text;
            string sql = "Select count(*) from UserTable where UserName='" + id + "'";
            SqlCommand cmd = new SqlCommand(sql, conn);
            int count = Convert.ToInt32(cmd.ExecuteScalar());
            if (count > 0)
            {
                MessageBox.Show("您添加的数据已经存在，请重新输入！","操作提示");
            }
            else//********************************    判断是否重复   ***************************************
            {

                SqlCommand comm = new SqlCommand("insert into UserTable(UserName,PassWord,Type) values(@UserName,@PassWord,@Type)", conn);
                comm.Parameters.AddWithValue("@UserName", cmbUserName.Text);
                comm.Parameters.AddWithValue("@PassWord", txtPassWord.Text);
                comm.Parameters.AddWithValue("@Type", cmbType.Text);
                comm.ExecuteNonQuery();
                MessageBox.Show("添加成功！");
                //----------------数据库有修改时，自动更新
                SqlDataAdapter da = new SqlDataAdapter("select distinct  UserName from UserTable", conn);
                DataTable dt = new DataTable();
                da.Fill(dt);
                cmbUserName.DisplayMember = "UserName";
                cmbUserName.ValueMember = "UserName";
                cmbUserName.DataSource = dt;
                SqlDataAdapter da1 = new SqlDataAdapter("select distinct  Type from UserTable", conn);
                DataTable dt1 = new DataTable();
                da1.Fill(dt1);
                cmbType.DisplayMember = "Type";
                cmbType.ValueMember = "Type";
                cmbType.DataSource = dt1;
            }
            conn.Close();
        }

        private void btnChange_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            SqlCommand comm = new SqlCommand("update UserTable set PassWord=@PassWord,Type=@Type where UserName=@UserName", conn);
            comm.Parameters.AddWithValue("@UserName", cmbUserName.Text);
            comm.Parameters.AddWithValue("@PassWord", txtPassWord.Text);
            comm.Parameters.AddWithValue("@Type", cmbType.Text);
            comm.ExecuteNonQuery();
            MessageBox.Show("修改成功！");
            //----------------数据库有修改时，自动更新
            SqlDataAdapter da = new SqlDataAdapter("select distinct  UserName from UserTable", conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            cmbUserName.DisplayMember = "UserName";
            cmbUserName.ValueMember = "UserName";
            cmbUserName.DataSource = dt;
            SqlDataAdapter da1 = new SqlDataAdapter("select distinct  Type from UserTable", conn);
            DataTable dt1 = new DataTable();
            da1.Fill(dt1);
            cmbType.DisplayMember = "Type";
            cmbType.ValueMember = "Type";
            cmbType.DataSource = dt1;
            conn.Close();

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            SqlCommand comm = new SqlCommand("delete from UserTable where UserName=@UserName", conn);
            comm.Parameters.AddWithValue("@UserName", cmbUserName.Text);
            comm.ExecuteNonQuery();
            MessageBox.Show("删除成功！");
            //----------------数据库有修改时，自动更新
            SqlDataAdapter da = new SqlDataAdapter("select distinct  UserName from UserTable", conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            cmbUserName.DisplayMember = "UserName";
            cmbUserName.ValueMember = "UserName";
            cmbUserName.DataSource = dt;
            SqlDataAdapter da1 = new SqlDataAdapter("select distinct  Type from UserTable", conn);
            DataTable dt1 = new DataTable();
            da1.Fill(dt1);
            cmbType.DisplayMember = "Type";
            cmbType.ValueMember = "Type";
            cmbType.DataSource = dt1;
            conn.Close();


        }

    }
}
