using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace 人力资源管理系统
{
    public partial class AdminForm : Form
    {
        //***********************************************************************************************
        /// <summary>
        /// 关闭动画
        /// </summary>
        [System.Runtime.InteropServices.DllImport("user32")]
        private static extern bool AnimateWindow(IntPtr hwnd, int dwTime, int dwFlags);
        const int AW_HOR_POSITIVE = 0x0001;
        const int AW_HOR_NEGATIVE = 0x0002;
        const int AW_VER_POSITIVE = 0x0004;
        const int AW_VER_NEGATIVE = 0x0008;
        const int AW_CENTER = 0x0010;
        const int AW_HIDE = 0x10000;
        const int AW_ACTIVATE = 0x20000;
        const int AW_SLIDE = 0x40000;
        const int AW_BLEND = 0x80000;
        //***********************************************************************************************
        public AdminForm()
        {
            InitializeComponent();
        }
        private void ToolStripButton_CheckedChanged(object sender, EventArgs e)
        {
            ToolStripButton button = sender as ToolStripButton;
            button.Image = global::人力资源管理系统.Properties.Resources.绿色按钮;
            button.ForeColor = Color.Green;
            int position = toolStrip1.Items.IndexOf(button);
            for (int i = 0; i < toolStrip1.Items.Count; i++)
            {
                if (i != position)
                {
                    ToolStripButton button1 = toolStrip1.Items[i] as ToolStripButton;
                    button1.Image = global::人力资源管理系统.Properties.Resources.蓝色按钮;
                    button1.ForeColor = Color.Blue;
                    button1.Checked = false;
                }
            }

        }

        //*****************************************************           窗体闪烁             ***************************************************

        protected override CreateParams CreateParams
        {
            get
            {
                CreateParams cp = base.CreateParams;
                cp.ExStyle |= 0x02000000;
                return cp;
            }
        }


        //*****************************************************            窗体闪烁             ***************************************************



        private void tsbExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private static frmUserManagement UserManagement;
        private void tsbUserManagement_Click(object sender, EventArgs e)
        {
            if (UserManagement == null || UserManagement.IsDisposed)
            {

                UserManagement = new frmUserManagement();

                UserManagement.MdiParent = this;

                UserManagement.Show();
            }

            else { UserManagement.Activate(); }
        }
        private static frmEmployeeManagement EmployeeManagement;
        private void tsbEmployeeManagement_Click(object sender, EventArgs e)
        {
            if (EmployeeManagement == null || EmployeeManagement.IsDisposed)
            {

                EmployeeManagement = new frmEmployeeManagement();

                EmployeeManagement.MdiParent = this;

                EmployeeManagement.Show();
            }

            else { EmployeeManagement.Activate(); }
        }
        private static frmWagesManagement WagesManagement;
        private void tsbWagesManagement_Click(object sender, EventArgs e)
        {
            if (WagesManagement == null || WagesManagement.IsDisposed)
            {

                WagesManagement = new frmWagesManagement();

                WagesManagement.MdiParent = this;

                WagesManagement.Show();
            }

            else { WagesManagement.Activate(); }
        }
        private static frmAttendanceManagement AttendanceManagement;
        private void tsbAttendanceManagement_Click(object sender, EventArgs e)
        {
            if (AttendanceManagement == null || AttendanceManagement.IsDisposed)
            {

                AttendanceManagement = new frmAttendanceManagement();

                AttendanceManagement.MdiParent = this;

                AttendanceManagement.Show();
            }

            else { AttendanceManagement.Activate(); }
        }
        private static frmRewardManagement RewardManagement;
        private void tsbRewardManagement_Click(object sender, EventArgs e)
        {
            if (RewardManagement == null || RewardManagement.IsDisposed)
            {

                RewardManagement = new frmRewardManagement();

                RewardManagement.MdiParent = this;

                RewardManagement.Show();
            }

            else { RewardManagement.Activate(); }
        }

        private void AdminForm_Load(object sender, EventArgs e)
        {
            //***************************          MDI窗体灰色背景更改       ********************************************       

            MdiClient ctlMDI;
            // Loop through all of the form's controls looking
            // for the control of type MdiClient.
            foreach (Control ctl in this.Controls)
            {
                try
                {
                    // Attempt to cast the control to type MdiClient.
                    ctlMDI = (MdiClient)ctl;

                    // Set the BackColor of the MdiClient control.
                    ctlMDI.BackColor = this.BackColor;
                }
                catch (InvalidCastException exc)
                {
                    // Catch and ignore the error if casting failed.
                }

                //***************************          MDI窗体灰色背景更改       ********************************************       

            }

        }

        private void AdminForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            AnimateWindow(this.Handle, 1000, AW_SLIDE | AW_HIDE | AW_VER_NEGATIVE);

        }

    }
}
