namespace 人力资源管理系统
{
    partial class AdminForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AdminForm));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.panel1 = new System.Windows.Forms.Panel();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.tsbUserManagement = new System.Windows.Forms.ToolStripButton();
            this.tsbEmployeeManagement = new System.Windows.Forms.ToolStripButton();
            this.tsbWagesManagement = new System.Windows.Forms.ToolStripButton();
            this.tsbAttendanceManagement = new System.Windows.Forms.ToolStripButton();
            this.tsbRewardManagement = new System.Windows.Forms.ToolStripButton();
            this.tsbExit = new System.Windows.Forms.ToolStripButton();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.timer关闭动画 = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.panel1.SuspendLayout();
            this.toolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.Control;
            this.pictureBox1.BackgroundImage = global::人力资源管理系统.Properties.Resources.主界面主标题;
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.pictureBox1.Location = new System.Drawing.Point(0, 0);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(1011, 88);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.toolStrip1);
            this.panel1.Controls.Add(this.pictureBox3);
            this.panel1.Controls.Add(this.pictureBox2);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel1.Location = new System.Drawing.Point(0, 88);
            this.panel1.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(211, 592);
            this.panel1.TabIndex = 1;
            // 
            // toolStrip1
            // 
            this.toolStrip1.AutoSize = false;
            this.toolStrip1.BackgroundImage = global::人力资源管理系统.Properties.Resources.index_header_bg;
            this.toolStrip1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.toolStrip1.Dock = System.Windows.Forms.DockStyle.Left;
            this.toolStrip1.GripStyle = System.Windows.Forms.ToolStripGripStyle.Hidden;
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsbUserManagement,
            this.tsbEmployeeManagement,
            this.tsbWagesManagement,
            this.tsbAttendanceManagement,
            this.tsbRewardManagement,
            this.tsbExit});
            this.toolStrip1.LayoutStyle = System.Windows.Forms.ToolStripLayoutStyle.VerticalStackWithOverflow;
            this.toolStrip1.Location = new System.Drawing.Point(0, 32);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Padding = new System.Windows.Forms.Padding(0, 0, 2, 0);
            this.toolStrip1.RenderMode = System.Windows.Forms.ToolStripRenderMode.System;
            this.toolStrip1.Size = new System.Drawing.Size(209, 536);
            this.toolStrip1.TabIndex = 3;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // tsbUserManagement
            // 
            this.tsbUserManagement.CheckOnClick = true;
            this.tsbUserManagement.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.tsbUserManagement.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.tsbUserManagement.Image = global::人力资源管理系统.Properties.Resources.绿色按钮;
            this.tsbUserManagement.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.tsbUserManagement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbUserManagement.Margin = new System.Windows.Forms.Padding(0, 20, 0, 20);
            this.tsbUserManagement.Name = "tsbUserManagement";
            this.tsbUserManagement.Size = new System.Drawing.Size(206, 44);
            this.tsbUserManagement.Text = "用户管理";
            this.tsbUserManagement.TextImageRelation = System.Windows.Forms.TextImageRelation.Overlay;
            this.tsbUserManagement.CheckedChanged += new System.EventHandler(this.ToolStripButton_CheckedChanged);
            this.tsbUserManagement.Click += new System.EventHandler(this.tsbUserManagement_Click);
            // 
            // tsbEmployeeManagement
            // 
            this.tsbEmployeeManagement.CheckOnClick = true;
            this.tsbEmployeeManagement.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.tsbEmployeeManagement.ForeColor = System.Drawing.Color.Blue;
            this.tsbEmployeeManagement.Image = global::人力资源管理系统.Properties.Resources.蓝色按钮;
            this.tsbEmployeeManagement.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.tsbEmployeeManagement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbEmployeeManagement.Margin = new System.Windows.Forms.Padding(0, 10, 0, 20);
            this.tsbEmployeeManagement.Name = "tsbEmployeeManagement";
            this.tsbEmployeeManagement.Size = new System.Drawing.Size(206, 44);
            this.tsbEmployeeManagement.Text = "员工信息管理";
            this.tsbEmployeeManagement.TextImageRelation = System.Windows.Forms.TextImageRelation.Overlay;
            this.tsbEmployeeManagement.CheckedChanged += new System.EventHandler(this.ToolStripButton_CheckedChanged);
            this.tsbEmployeeManagement.Click += new System.EventHandler(this.tsbEmployeeManagement_Click);
            // 
            // tsbWagesManagement
            // 
            this.tsbWagesManagement.CheckOnClick = true;
            this.tsbWagesManagement.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.tsbWagesManagement.ForeColor = System.Drawing.Color.Blue;
            this.tsbWagesManagement.Image = global::人力资源管理系统.Properties.Resources.蓝色按钮;
            this.tsbWagesManagement.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.tsbWagesManagement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbWagesManagement.Margin = new System.Windows.Forms.Padding(0, 10, 0, 20);
            this.tsbWagesManagement.Name = "tsbWagesManagement";
            this.tsbWagesManagement.Size = new System.Drawing.Size(206, 44);
            this.tsbWagesManagement.Text = "工资管理";
            this.tsbWagesManagement.TextImageRelation = System.Windows.Forms.TextImageRelation.Overlay;
            this.tsbWagesManagement.CheckedChanged += new System.EventHandler(this.ToolStripButton_CheckedChanged);
            this.tsbWagesManagement.Click += new System.EventHandler(this.tsbWagesManagement_Click);
            // 
            // tsbAttendanceManagement
            // 
            this.tsbAttendanceManagement.CheckOnClick = true;
            this.tsbAttendanceManagement.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.tsbAttendanceManagement.ForeColor = System.Drawing.Color.Blue;
            this.tsbAttendanceManagement.Image = global::人力资源管理系统.Properties.Resources.蓝色按钮;
            this.tsbAttendanceManagement.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.tsbAttendanceManagement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbAttendanceManagement.Margin = new System.Windows.Forms.Padding(0, 10, 0, 20);
            this.tsbAttendanceManagement.Name = "tsbAttendanceManagement";
            this.tsbAttendanceManagement.Size = new System.Drawing.Size(206, 44);
            this.tsbAttendanceManagement.Text = "考勤管理";
            this.tsbAttendanceManagement.TextImageRelation = System.Windows.Forms.TextImageRelation.Overlay;
            this.tsbAttendanceManagement.CheckedChanged += new System.EventHandler(this.ToolStripButton_CheckedChanged);
            this.tsbAttendanceManagement.Click += new System.EventHandler(this.tsbAttendanceManagement_Click);
            // 
            // tsbRewardManagement
            // 
            this.tsbRewardManagement.CheckOnClick = true;
            this.tsbRewardManagement.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.tsbRewardManagement.ForeColor = System.Drawing.Color.Blue;
            this.tsbRewardManagement.Image = global::人力资源管理系统.Properties.Resources.蓝色按钮;
            this.tsbRewardManagement.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.tsbRewardManagement.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbRewardManagement.Margin = new System.Windows.Forms.Padding(0, 10, 0, 20);
            this.tsbRewardManagement.Name = "tsbRewardManagement";
            this.tsbRewardManagement.Size = new System.Drawing.Size(206, 44);
            this.tsbRewardManagement.Text = "奖惩管理";
            this.tsbRewardManagement.TextImageRelation = System.Windows.Forms.TextImageRelation.Overlay;
            this.tsbRewardManagement.CheckedChanged += new System.EventHandler(this.ToolStripButton_CheckedChanged);
            this.tsbRewardManagement.Click += new System.EventHandler(this.tsbRewardManagement_Click);
            // 
            // tsbExit
            // 
            this.tsbExit.CheckOnClick = true;
            this.tsbExit.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.tsbExit.ForeColor = System.Drawing.Color.Blue;
            this.tsbExit.Image = global::人力资源管理系统.Properties.Resources.蓝色按钮;
            this.tsbExit.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.tsbExit.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbExit.Margin = new System.Windows.Forms.Padding(0, 10, 0, 20);
            this.tsbExit.Name = "tsbExit";
            this.tsbExit.Size = new System.Drawing.Size(206, 44);
            this.tsbExit.Text = "退出系统";
            this.tsbExit.TextImageRelation = System.Windows.Forms.TextImageRelation.Overlay;
            this.tsbExit.CheckedChanged += new System.EventHandler(this.ToolStripButton_CheckedChanged);
            this.tsbExit.Click += new System.EventHandler(this.tsbExit_Click);
            // 
            // pictureBox3
            // 
            this.pictureBox3.BackgroundImage = global::人力资源管理系统.Properties.Resources.上边框;
            this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox3.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.pictureBox3.Location = new System.Drawing.Point(0, 568);
            this.pictureBox3.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(211, 24);
            this.pictureBox3.TabIndex = 1;
            this.pictureBox3.TabStop = false;
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackgroundImage = global::人力资源管理系统.Properties.Resources.上边框;
            this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox2.Dock = System.Windows.Forms.DockStyle.Top;
            this.pictureBox2.Location = new System.Drawing.Point(0, 0);
            this.pictureBox2.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(211, 32);
            this.pictureBox2.TabIndex = 0;
            this.pictureBox2.TabStop = false;
            // 
            // AdminForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DodgerBlue;
            this.ClientSize = new System.Drawing.Size(1011, 680);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.pictureBox1);
            this.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.IsMdiContainer = true;
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.Name = "AdminForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "管理界面";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.AdminForm_Load);
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.AdminForm_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.panel1.ResumeLayout(false);
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.ToolStripButton tsbEmployeeManagement;
        private System.Windows.Forms.ToolStripButton tsbWagesManagement;
        private System.Windows.Forms.ToolStripButton tsbAttendanceManagement;
        private System.Windows.Forms.ToolStripButton tsbRewardManagement;
        private System.Windows.Forms.ToolStripButton tsbExit;
        public System.Windows.Forms.ToolStripButton tsbUserManagement;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.Timer timer关闭动画;
    }
}