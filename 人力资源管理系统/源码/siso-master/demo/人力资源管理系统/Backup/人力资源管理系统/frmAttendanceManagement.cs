using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Data.SqlClient;
using System.IO;

namespace 人力资源管理系统
{
    public partial class frmAttendanceManagement : Form
    {
        public frmAttendanceManagement()
        {
            InitializeComponent();
        }
        #region ********************* 主程序
        private void frmAttendanceManagement_Load(object sender, EventArgs e)
        {
            FillData();
        }
        public void FillData()
        {
            SqlConnection conn = new SqlConnection("Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            SqlDataAdapter da = new SqlDataAdapter("select * from 考勤表", conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = dt;
            conn.Close();
        }
 
        private void btnFind_Click(object sender, EventArgs e)
        {
            FindAttendance FrmFindAttendance = new FindAttendance();
            FrmFindAttendance.Text="查询考勤信息";
            FrmFindAttendance.ShowDialog(this);
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            AddAttendance FrmAddAttendance = new AddAttendance();
            FrmAddAttendance.Text = "添加考勤记录";
            FrmAddAttendance.ShowDialog(this);
        }

        private void btnChange_Click(object sender, EventArgs e)
        {
            //ChangeAttendance FrmChangeAttendance = new ChangeAttendance();
            //FrmChangeAttendance.Show();
            //*********************************************************************************************************
            if (dataGridView1.SelectedRows.Count == 0) return;
            ChangeAttendance modify = new ChangeAttendance();
            modify.Text = "修改考勤信息";
            modify.记录ID = dataGridView1.SelectedRows[0].Cells["员工号"].Value.ToString();
            modify.ShowDialog(this);
            //**********************************************************************************************************

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            int ROW = dataGridView1.SelectedRows.Count;
            if (MessageBox.Show("确认删除选中的" + ROW.ToString() + "条记录吗？", "请确认删除", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                List<DataGridViewRow> rows = new List<DataGridViewRow>();
                foreach (DataGridViewRow row in dataGridView1.SelectedRows)
                {
                    rows.Add(row);
                }
                for (int i = 0; i < rows.Count; i++)
                {
                    SqlCommand comm = new SqlCommand("delete from 考勤表 where 员工号=@员工号", conn);
                    comm.Parameters.AddWithValue("@员工号", rows[i].Cells["员工号"].Value);
                    comm.ExecuteNonQuery();
                    dataGridView1.Rows.Remove(rows[i]);

                }
                MessageBox.Show("删除成功！");
            }
            else
            {
                MessageBox.Show("您的删除操作已取消！","操作提示");
            }
            conn.Close();
        }

        private void btnOut_Click(object sender, EventArgs e)
        {
            DataGridViewToExcel(dataGridView1);
            MessageBox.Show("导出成功！");
        }
        //********************************************************************************************************************************************************************************************
        /// <summary>   
        /// 常用方法，列之间加\t开。   
        /// </summary>   
        /// <remarks>   
        /// using System.IO;   
        /// </remarks>   
        /// <param name="dgv"></param>   
        private void DataGridViewToExcel(DataGridView dgv)
        {
            SaveFileDialog dlg = new SaveFileDialog();
            dlg.Filter = "Execl files (*.xls)|*.xls";
            dlg.CheckFileExists = false;
            dlg.CheckPathExists = false;
            dlg.FilterIndex = 0;
            dlg.RestoreDirectory = true;
            dlg.CreatePrompt = true;
            dlg.Title = "保存为Excel文件";

            if (dlg.ShowDialog() == DialogResult.OK)
            {
                Stream myStream;
                myStream = dlg.OpenFile();
                StreamWriter sw = new StreamWriter(myStream, System.Text.Encoding.GetEncoding(-0));
                string columnTitle = "";
                try
                {
                    //写入列标题   
                    for (int i = 0; i < dgv.ColumnCount; i++)
                    {
                        if (i > 0)
                        {
                            columnTitle += "\t";
                        }
                        columnTitle += dgv.Columns[i].HeaderText;
                    }
                    sw.WriteLine(columnTitle);

                    //写入列内容   
                    for (int j = 0; j < dgv.Rows.Count; j++)
                    {
                        string columnValue = "";
                        for (int k = 0; k < dgv.Columns.Count; k++)
                        {
                            if (k > 0)
                            {
                                columnValue += "\t";
                            }
                            if (dgv.Rows[j].Cells[k].Value == null)
                                columnValue += "";
                            else
                                columnValue += dgv.Rows[j].Cells[k].Value.ToString().Trim();
                        }
                        sw.WriteLine(columnValue);
                    }
                    sw.Close();
                    myStream.Close();
                }
                catch (Exception e)
                {
                    MessageBox.Show(e.ToString());
                }
                finally
                {
                    sw.Close();
                    myStream.Close();
                }
            }
        }
        //*****************************************************************************************************************************************************************************************

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            //*********************************************************************************************************
            if (dataGridView1.SelectedRows.Count == 0) return;
            ChangeAttendance modify = new ChangeAttendance();
            modify.Text = "修改考勤信息";
            modify.记录ID = dataGridView1.SelectedRows[0].Cells["员工号"].Value.ToString();
            modify.ShowDialog(this);
            //**********************************************************************************************************

        }
        #endregion
        #region ***********************右键单击
        private void 条件查找ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SearchInAttendance FrmSearchInAttendance = new SearchInAttendance();
            FrmSearchInAttendance.ShowDialog(this);
        }

        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection("Server=(local);Database=HR;Trusted_Connection=yes");
            conn.Open();
            int ROW = dataGridView1.SelectedRows.Count;
            if (MessageBox.Show("确认删除选中的" + ROW.ToString() + "条记录吗？", "请确认删除", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                List<DataGridViewRow> rows = new List<DataGridViewRow>();
                foreach (DataGridViewRow row in dataGridView1.SelectedRows)
                {
                    rows.Add(row);
                }
                for (int i = 0; i < rows.Count; i++)
                {
                    SqlCommand comm = new SqlCommand("delete from 考勤表 where 员工号=@员工号", conn);
                    comm.Parameters.AddWithValue("@员工号", rows[i].Cells["员工号"].Value);
                    comm.ExecuteNonQuery();
                    dataGridView1.Rows.Remove(rows[i]);

                }
                MessageBox.Show("删除成功！");
            }
            else
            {
                MessageBox.Show("您的删除操作已取消！", "操作提示");
            }
            conn.Close();
        }

        private void 查询FToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FindAttendance FrmFindAttendance = new FindAttendance();
            FrmFindAttendance.Text = "查询考勤信息";
            FrmFindAttendance.ShowDialog(this);

        }

        private void 添加AToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddAttendance FrmAddAttendance = new AddAttendance();
            FrmAddAttendance.Text = "添加考勤记录";
            FrmAddAttendance.ShowDialog(this);

        }

        private void 修改CToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 0) return;
            ChangeAttendance modify = new ChangeAttendance();
            modify.Text = "修改考勤信息";
            modify.记录ID = dataGridView1.SelectedRows[0].Cells["员工号"].Value.ToString();
            modify.ShowDialog(this);

        }

        private void 导出OToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DataGridViewToExcel(dataGridView1);
            MessageBox.Show("导出成功！");
        }
        #endregion
        //*******************************************************************************************************************************
        private void 显示所有VToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FillData();
        }
    }
}
