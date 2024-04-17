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
    public partial class Login : Form
    {
        
        //动画窗体调用,关闭时将向上移出屏幕
        /// <summary>
        /// 动画效果----------------------------------------------------------------------------------------------------
        /// </summary>
        /// <param name="hwnd"></param>
        /// <param name="dwTime"></param>
        /// <param name="dwFlags"></param>
        /// <returns></returns>
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
        //****************************************************************************************************************
        private void Login_Load(object sender, EventArgs e)
        {
            //动画由小渐大,现在取消
            //AnimateWindow(this.Handle, 2000, AW_CENTER | AW_ACTIVATE);

            //主界面渐变设置
            this.timer动画.Enabled = true;//让timer动画的timer值有效
            this.Opacity = 0;
            //………………………………………………
            cmbType.SelectedIndex = 0;
        }

        private void timer动画_Tick(object sender, EventArgs e)
        {
            //让背景由0变到1
            if (this.Opacity < 1)
            {
                this.Opacity = this.Opacity + 0.05;
            }
            else
            {
                this.timer动画.Enabled = false;
            }
        }



        /// <summary>
        /// 动画效果*****************************************************************************************************
        /// </summary>

        public Login()
        {
            InitializeComponent();
        }

        private bool CheckInput()//新定义一个方法，用于判断登陆是否合法
        {
            if (this.txtUserName.Text.Trim().Equals(string.Empty))
            {
                MessageBox.Show("请您输入账号！", "操作提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.txtUserName.Focus();
                return false;
            }
            else if (this.txtPassWord.Text.Trim().Equals(string.Empty))
            {
                MessageBox.Show("请您输入密码！", "操作提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.txtPassWord.Focus();
                return false;
            }
            else if (this.cmbType.Text.Trim().Equals(string.Empty))
            {
                MessageBox.Show("请选择登陆类型！", "操作提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.cmbType.Focus();
                return false;
            }
            else
            {
                return true;
            }

        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            string UserName = txtUserName.Text.Trim();
            string UserPassWord = txtPassWord.Text.Trim();
            string UserType = cmbType.Text.Trim();
            if (CheckInput())//用户名，密码，登录类型都不能为空
            {
                //添加一个登陆密码判断
                SqlConnection conn = new SqlConnection("Server=小颜\\SQLEXPRESS;Database=HR;Trusted_Connection=yes;uid=sa;pwd=677520");
                conn.Open();
                string str = "select count(*) from UserTable where UserName='" + UserName + "' and PassWord='" + UserPassWord + "'and Type='" + UserType+ "'";
                SqlCommand cmd = new SqlCommand(str, conn);
                int n = (int)cmd.ExecuteScalar();
                if (n >= 1)
                {
                    if (this.cmbType.Text.Equals("管理员"))
                    {
                        AdminForm frmAdmin = new AdminForm();//新建一个管理员窗体,打开管理员界面
                        frmAdmin.Show();
                    }
                    else//非管理员登陆进入这里
                    {
                        AdminForm frmOtherUser = new AdminForm();//新建一个非管理员界面
                        frmOtherUser.tsbUserManagement.Visible=false;
                        frmOtherUser.Show();
                    }
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("您输入的用户名，密码或类型有误，请重新输入！");
                }
                conn.Close();
            }
        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("你确定要退出么？", "操作提示", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                Application.Exit();
            }

        }

        /// <summary>
        /// 关闭时动画---------------------------------------------------------------------------------------------
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Login_FormClosing(object sender, FormClosingEventArgs e)
        {
            //关闭时动画
            AnimateWindow(this.Handle, 1000, AW_SLIDE | AW_HIDE | AW_VER_NEGATIVE);
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start("www.baidu.com");
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
        //关闭时动画------------------------------------------------------------------------------------------------
    }
}
