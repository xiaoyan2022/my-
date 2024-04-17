using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace 人力资源管理系统
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Login());
            //frmUserManagement
            //AdminForm
            //frmEmployeeManagement
            //frmWagesManagement
            //frmAttendanceManagement
            //frmRewardManagement
            //Login
            //AddAttendance
            //AddEmployee
            //AddReward
            //AddWages
        }
    }
}
