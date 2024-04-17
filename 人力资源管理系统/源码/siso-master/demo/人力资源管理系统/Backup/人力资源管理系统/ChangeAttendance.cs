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
    public partial class ChangeAttendance : Form
    {
        public ChangeAttendance()
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
        public string 记录ID;
        //----------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------
        private void Over()
        {
            frmAttendanceManagement main = this.Owner.ActiveMdiChild as frmAttendanceManagement;
            DataGridViewRow row;
            if (main != null)
            {
                row = main.dataGridView1.SelectedRows[0];
                txt记录号.Text = row.Cells[0].Value.ToString();
                txt员工号.Text = row.Cells[1].Value.ToString();
                txt计薪年月.Text = row.Cells[2].Value.ToString();
                txt应勤天数.Text = row.Cells[3].Value.ToString();
                txt矿工天数.Text = row.Cells[4].Value.ToString();
                txt实际出勤.Text = row.Cells[5].Value.ToString();
                txt加班天数.Text = row.Cells[6].Value.ToString();
                txt事假天数.Text = row.Cells[7].Value.ToString();
                txt病假天数.Text = row.Cells[8].Value.ToString();
                txt婚葬产假.Text = row.Cells[9].Value.ToString();
                txt调休天数.Text = row.Cells[10].Value.ToString();
                txt迟到早退.Text = row.Cells[11].Value.ToString();
                txt年假天数.Text = row.Cells[12].Value.ToString();
                richTextBox备注.Text = row.Cells[13].Value.ToString();

                //checkBox1.Checked = (bool)row.Cells[2].Value;
                //dateTimePicker1.Value = (DateTime)row.Cells[3].Value;
                //comboBox1.Text = row.Cells[4].Value.ToString();
            }

        }
        //---------------------------------------------------------------------------------------------------------------------------------

        //private void OwnFindAttendance(string id)
        //{
        //    SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=.;Database=HR;Trusted_Connection=yes");
        //    SqlCommand comm = new SqlCommand("Select * from 考勤表 where 员工号='" + id + "'", conn);
        //    conn.Open();
        //    SqlDataReader reader = comm.ExecuteReader();
        //    if (reader.Read())
        //    {
        //        txt员工号.Text = id;
        //        txt计薪年月.Text = reader["计薪年月"].ToString();
        //        txt员工号.Text = reader["员工号"].ToString();
        //        txt应勤天数.Text = reader["应勤天数"].ToString();
        //        txt实际出勤.Text = reader["实际出勤"].ToString();
        //        txt病假天数.Text = reader["病假天数"].ToString();
        //        txt迟到早退.Text = reader["迟到早退"].ToString();
        //        txt婚葬产假.Text = reader["婚葬产假"].ToString();
        //        txt加班天数.Text = reader["加班天数"].ToString();
        //        txt矿工天数.Text = reader["矿工天数"].ToString();
        //        txt年假天数.Text = reader["年假天数"].ToString();
        //        txt事假天数.Text = reader["事假天数"].ToString();
        //        txt调休天数.Text = reader["调休天数"].ToString();
        //        richTextBox备注.Text = reader["备注"].ToString();
        //    }
        //}

        //private void btnFind_Click(object sender, EventArgs e)
        //{
        //    OwnFindAttendance(txt员工号.Text);
        //}

        private void btnChange_Click(object sender, EventArgs e)
        {
            if (txt记录号.Text == "" || txt员工号.Text == "" || txt计薪年月.Text == "" || txt实际出勤.Text == "" || txt应勤天数.Text == "")
            {
                MessageBox.Show("请至少将带“ * ”部分补充完整！", "操作提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                conn.Open();            
                string temp = txt员工号.Text;
                string SQL = "Select count(*) from 考勤表 where 员工号='" + temp + "'";
                SqlCommand cmd1 = new SqlCommand(SQL, conn);
                int count1 = Convert.ToInt32(cmd1.ExecuteScalar());
                if (count1 == 0)
                {
                    MessageBox.Show("您输入的员工号已存在，请重新输入！", "操作提示");
                }
                else
                {
                    //SqlConnection conn = new SqlConnection("MultipleActiveResultSets=True;Server=(local);Database=HR;Trusted_Connection=yes");
                    //conn.Open();
                    SqlCommand comm = new SqlCommand("update 考勤表 set 计薪年月=@计薪年月,员工号=@员工号,应勤天数=@应勤天数,实际出勤=@实际出勤,加班天数=@加班天数,事假天数=@事假天数,病假天数=@病假天数,年假天数=@年假天数,婚葬产假=@婚葬产假,调休天数=@调休天数,矿工天数=@矿工天数,迟到早退=@迟到早退,备注=@备注 where 记录号=@记录号", conn);
                    comm.Parameters.AddWithValue("@员工号", txt员工号.Text);
                    comm.Parameters.AddWithValue("@计薪年月", txt计薪年月.Text);
                    comm.Parameters.AddWithValue("@员工号", txt员工号.Text);
                    comm.Parameters.AddWithValue("@应勤天数", txt应勤天数.Text);
                    comm.Parameters.AddWithValue("@实际出勤", txt实际出勤.Text);
                    comm.Parameters.AddWithValue("@加班天数", txt加班天数.Text);
                    comm.Parameters.AddWithValue("@事假天数", txt事假天数.Text);
                    comm.Parameters.AddWithValue("@病假天数", txt病假天数.Text);
                    comm.Parameters.AddWithValue("@年假天数", txt年假天数.Text);
                    comm.Parameters.AddWithValue("@婚葬产假", txt婚葬产假.Text);
                    comm.Parameters.AddWithValue("@调休天数", txt调休天数.Text);
                    comm.Parameters.AddWithValue("@矿工天数", txt矿工天数.Text);
                    comm.Parameters.AddWithValue("@迟到早退", txt迟到早退.Text);
                    comm.Parameters.AddWithValue("@备注", richTextBox备注.Text);
                    comm.ExecuteNonQuery();
                    //----------------------更新数据库 5.17
                    frmAttendanceManagement main = this.Owner.ActiveMdiChild as frmAttendanceManagement;
                    if (main != null) main.FillData();
                    //----------------------更新数据库 5.17
                    MessageBox.Show("修改成功！");
                }
                conn.Close();
            }
        }

        private void ChangeAttendance_Load(object sender, EventArgs e)
        {
            Over();

        }
    }
}
