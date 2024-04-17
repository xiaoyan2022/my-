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
    public partial class ChangeWages : Form
    {
        public ChangeWages()
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

        //****************************************************************************
        public string 流水ID;
        //****************************************************************************
        //-------------------------------------------------------------------------------------------------------------------------
        private void Over()
        {
            frmWagesManagement main = this.Owner.ActiveMdiChild as frmWagesManagement;
            DataGridViewRow row;
            if (main != null)
            {
                row = main.dataGridView1.SelectedRows[0];
                txtNO.Text = row.Cells[0].Value.ToString();
                txtEmployeeID.Text = row.Cells[1].Value.ToString();
                txt计薪年月.Text = row.Cells[2].Value.ToString();
                dateTime发放日期.Value = (DateTime)row.Cells[3].Value;
                txt月薪.Text = row.Cells[4].Value.ToString();
                txt加班费.Text = row.Cells[5].Value.ToString();
                txt实发工资.Text = row.Cells[6].Value.ToString();
                txt高温补贴.Text = row.Cells[7].Value.ToString();
                txt住房补贴.Text = row.Cells[8].Value.ToString();
                txt交通补贴.Text = row.Cells[9].Value.ToString();
                txt节假日补贴.Text = row.Cells[10].Value.ToString();
                txt其他加项.Text = row.Cells[11].Value.ToString();
                txt所得税.Text = row.Cells[12].Value.ToString();
                txt公积金.Text = row.Cells[13].Value.ToString();
                txt社会保险.Text = row.Cells[14].Value.ToString();
                txt其他扣资.Text = row.Cells[15].Value.ToString();
                txt制表人.Text = row.Cells[16].Value.ToString();
                dateTime制表时间.Value = (DateTime)row.Cells[17].Value;
                txt审核人.Text = row.Cells[18].Value.ToString();
                dateTime审核时间.Value = (DateTime)row.Cells[19].Value;
                richTextBox备注.Text=row.Cells[20].Value.ToString();


                //checkBox1.Checked = (bool)row.Cells[2].Value;
                //dateTimePicker1.Value = (DateTime)row.Cells[3].Value;
                //comboBox1.Text = row.Cells[4].Value.ToString();
            }

        }
        //---------------------------------------------------------------------------------------------------------------------------------

        //private void OwnFindWages(string id)
        //{
        //    SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
        //    SqlCommand comm = new SqlCommand("Select * from 工资表 where 流水号='" + id + "'", conn);
        //    conn.Open();
        //    SqlDataReader reader = comm.ExecuteReader();
        //    if (reader.Read())
        //    {
        //        txtNO.Text = id;
        //        txtEmployeeID.Text = reader["员工号"].ToString();
        //        txt高温补贴.Text = reader["高温补贴"].ToString();
        //        txt公积金.Text = reader["公积金"].ToString();
        //        txt计薪年月.Text = reader["计薪年月"].ToString();
        //        txt加班费.Text = reader["加班费"].ToString();
        //        txt交通补贴.Text = reader["交通补贴"].ToString();
        //        txt其他加项.Text = reader["其他加项"].ToString();
        //        txt其他扣资.Text = reader["其他扣资"].ToString();
        //        txt社会保险.Text = reader["社会保险"].ToString();
        //        txt审核人.Text = reader["审核人"].ToString();
        //        txt实发工资.Text = reader["实发工资"].ToString();
        //        txt所得税.Text = reader["所得税"].ToString();
        //        txt月薪.Text = reader["月薪"].ToString();
        //        txt制表人.Text = reader["制表人"].ToString();
        //        txt住房补贴.Text = reader["住房补贴"].ToString();
        //        txt节假日补贴.Text = reader["节假日补贴"].ToString();
        //        richTextBox备注.Text = reader["备注"].ToString();
        //        dateTime发放日期.Value = (DateTime)reader["发放日期"];
        //        dateTime审核时间.Value = (DateTime)reader["审核时间"];
        //        dateTime制表时间.Value = (DateTime)reader["制表时间"];
        //    }
        //}


        //private void btnFind_Click(object sender, EventArgs e)
        //{
        //    OwnFindWages(txtNO.Text);

        //}

        private void btnChange_Click(object sender, EventArgs e)
        {
            if (txtEmployeeID.Text == "" || txt计薪年月.Text == "" || txt月薪.Text == ""||txt实发工资.Text=="")
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                conn.Open();
                string temp = txtEmployeeID.Text;
                string SQL = "Select count(*) from 员工表 where 员工号='" + temp + "'";
                SqlCommand cmd1 = new SqlCommand(SQL, conn);
                int count1 = Convert.ToInt32(cmd1.ExecuteScalar());
                if (count1 == 0)
                {
                    MessageBox.Show("您输入的员工号不存在，请重新输入！", "操作提示");
                }
                else
                {
                    SqlCommand comm = new SqlCommand("update 工资表 set 员工号=@员工号,计薪年月=@计薪年月,发放日期=@发放日期,月薪=@月薪,加班费=@加班费,节假日补贴=@节假日补贴,高温补贴=@高温补贴,住房补贴=@住房补贴,交通补贴=@交通补贴,其他加项=@其他加项,所得税=@所得税,公积金=@公积金,社会保险=@社会保险,其他扣资=@其他扣资,实发工资=@实发工资,制表人=@制表人,制表时间=@制表时间,审核人=@审核人,审核时间=@审核时间,备注=@备注 where 流水号=@流水号", conn);
                    comm.Parameters.AddWithValue("@流水号", txtNO.Text);
                    comm.Parameters.AddWithValue("@员工号", txtEmployeeID.Text);
                    comm.Parameters.AddWithValue("@发放日期", dateTime发放日期.Value);
                    comm.Parameters.AddWithValue("@计薪年月", txt计薪年月.Text);
                    comm.Parameters.AddWithValue("@月薪", txt月薪.Text);
                    comm.Parameters.AddWithValue("@加班费", txt加班费.Text);
                    comm.Parameters.AddWithValue("@节假日补贴", txt节假日补贴.Text);
                    comm.Parameters.AddWithValue("@高温补贴", txt高温补贴.Text);
                    comm.Parameters.AddWithValue("@住房补贴", txt住房补贴.Text);
                    comm.Parameters.AddWithValue("@交通补贴", txt交通补贴.Text);
                    comm.Parameters.AddWithValue("@其他加项", txt其他加项.Text);
                    comm.Parameters.AddWithValue("@所得税", txt所得税.Text);
                    comm.Parameters.AddWithValue("@公积金", txt公积金.Text);
                    comm.Parameters.AddWithValue("@社会保险", txt社会保险.Text);
                    comm.Parameters.AddWithValue("@其他扣资", txt其他扣资.Text);
                    comm.Parameters.AddWithValue("@实发工资", txt实发工资.Text);
                    comm.Parameters.AddWithValue("@制表人", txt制表人.Text);
                    comm.Parameters.AddWithValue("@审核人", txt审核人.Text);
                    comm.Parameters.AddWithValue("@制表时间", dateTime制表时间.Value);
                    comm.Parameters.AddWithValue("@审核时间", dateTime审核时间.Value);
                    comm.Parameters.AddWithValue("@备注", richTextBox备注.Text);
                    comm.ExecuteNonQuery();
                    //----------------------更新数据库 5.17
                    frmWagesManagement main = this.Owner.ActiveMdiChild as frmWagesManagement;
                    if (main != null) main.FillData();
                    //----------------------更新数据库 5.17
                    MessageBox.Show("修改成功！");
                }
                conn.Close();
            }
        }
        private void ChangeWages_Load(object sender, EventArgs e)
        {
            Over();

        }
    }
}
