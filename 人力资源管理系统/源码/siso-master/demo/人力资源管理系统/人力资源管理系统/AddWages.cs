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
    public partial class AddWages : Form
    {
        public AddWages()
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

        private void btnFind_Click(object sender, EventArgs e)
        {
            if (txtEmployeeID.Text == "" || txt计薪年月.Text == "" || txt月薪.Text == ""||txt实发工资.Text=="")
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
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
                    SqlCommand comm = new SqlCommand("insert into 工资表(员工号,计薪年月,发放日期,月薪,加班费,节假日补贴,高温补贴,住房补贴,交通补贴,其他加项,所得税,公积金,社会保险,其他扣资,实发工资,制表人,制表时间,审核人,审核时间,备注) values(@员工号,@计薪年月,@发放日期,@月薪,@加班费,@节假日补贴,@高温补贴,@住房补贴,@交通补贴,@其他加项,@所得税,@公积金,@社会保险,@其他扣资,@实发工资,@制表人,@制表时间,@审核人,@审核时间,@备注)", conn);
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
                    frmWagesManagement main = this.Owner.ActiveMdiChild as frmWagesManagement;
                    if (main != null) main.FillData();
                    MessageBox.Show("添加成功！");
                }
                conn.Close();
            }
        }
    }
}
