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
    public partial class frmUserManagement : Form
    {
        public frmUserManagement()
        {
            InitializeComponent();
        }
        private void btnFind_Click(object sender, EventArgs e)
        {
            frmChangeUser FrmFindUser = new frmChangeUser();
            FrmFindUser.Text = "查询用户信息";
            FrmFindUser.State = 0;
            FrmFindUser.Show();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            frmChangeUser FrmAddUser = new frmChangeUser();
            FrmAddUser.Text = "添加用户";
            FrmAddUser.State = 1;
            FrmAddUser.Show();

        }

        private void btnChange_Click(object sender, EventArgs e)
        {
            frmChangeUser FrmChangeUser = new frmChangeUser();
            FrmChangeUser.Text = "修改用户信息";
            FrmChangeUser.State = 2;
            FrmChangeUser.Show();

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            frmChangeUser FrmDeleteUser = new frmChangeUser();
            FrmDeleteUser.Text = "删除用户";
            FrmDeleteUser.State = 3;
            FrmDeleteUser.Show();

        }
    }
}
