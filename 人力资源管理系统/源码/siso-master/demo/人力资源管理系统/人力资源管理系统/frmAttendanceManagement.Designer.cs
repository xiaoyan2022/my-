namespace 人力资源管理系统
{
    partial class frmAttendanceManagement
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmAttendanceManagement));
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnOut = new System.Windows.Forms.Button();
            this.btnDelete = new System.Windows.Forms.Button();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.btnChange = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnFind = new System.Windows.Forms.Button();
            this.btnAdd = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.记录号 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.员工号 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.计薪年月 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.应勤天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.矿工天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.实际出勤 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.加班天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.事假天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.病假天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.婚葬产假 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.调休天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.迟到早退 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.年假天数 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.备注 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.查询FToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.添加AToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.修改CToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.导出OToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.条件查找ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.显示所有VToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.Controls.Add(this.btnOut);
            this.panel1.Controls.Add(this.btnDelete);
            this.panel1.Controls.Add(this.pictureBox2);
            this.panel1.Controls.Add(this.btnChange);
            this.panel1.Controls.Add(this.pictureBox1);
            this.panel1.Controls.Add(this.btnFind);
            this.panel1.Controls.Add(this.btnAdd);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(688, 47);
            this.panel1.TabIndex = 2;
            // 
            // btnOut
            // 
            this.btnOut.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.btnOut.BackColor = System.Drawing.SystemColors.Control;
            this.btnOut.BackgroundImage = global::人力资源管理系统.Properties.Resources.子界面按钮背景;
            this.btnOut.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnOut.FlatAppearance.BorderColor = System.Drawing.Color.DeepSkyBlue;
            this.btnOut.FlatAppearance.BorderSize = 0;
            this.btnOut.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.btnOut.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnOut.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnOut.ForeColor = System.Drawing.Color.Gold;
            this.btnOut.Location = new System.Drawing.Point(497, 12);
            this.btnOut.Name = "btnOut";
            this.btnOut.Size = new System.Drawing.Size(90, 29);
            this.btnOut.TabIndex = 24;
            this.btnOut.Text = "导出";
            this.btnOut.UseVisualStyleBackColor = false;
            this.btnOut.Click += new System.EventHandler(this.btnOut_Click);
            // 
            // btnDelete
            // 
            this.btnDelete.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.btnDelete.BackColor = System.Drawing.SystemColors.Control;
            this.btnDelete.BackgroundImage = global::人力资源管理系统.Properties.Resources.子界面按钮背景;
            this.btnDelete.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnDelete.FlatAppearance.BorderColor = System.Drawing.Color.DeepSkyBlue;
            this.btnDelete.FlatAppearance.BorderSize = 0;
            this.btnDelete.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnDelete.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnDelete.ForeColor = System.Drawing.Color.Gold;
            this.btnDelete.Location = new System.Drawing.Point(398, 12);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(90, 29);
            this.btnDelete.TabIndex = 23;
            this.btnDelete.Text = "删除";
            this.btnDelete.UseVisualStyleBackColor = false;
            this.btnDelete.Click += new System.EventHandler(this.btnDelete_Click);
            // 
            // pictureBox2
            // 
            this.pictureBox2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.pictureBox2.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox2.BackgroundImage = global::人力资源管理系统.Properties.Resources.右;
            this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox2.Location = new System.Drawing.Point(593, -6);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(95, 47);
            this.pictureBox2.TabIndex = 19;
            this.pictureBox2.TabStop = false;
            // 
            // btnChange
            // 
            this.btnChange.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.btnChange.BackColor = System.Drawing.SystemColors.Control;
            this.btnChange.BackgroundImage = global::人力资源管理系统.Properties.Resources.子界面按钮背景;
            this.btnChange.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnChange.FlatAppearance.BorderColor = System.Drawing.Color.DeepSkyBlue;
            this.btnChange.FlatAppearance.BorderSize = 0;
            this.btnChange.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnChange.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnChange.ForeColor = System.Drawing.Color.Gold;
            this.btnChange.Location = new System.Drawing.Point(299, 12);
            this.btnChange.Name = "btnChange";
            this.btnChange.Size = new System.Drawing.Size(90, 29);
            this.btnChange.TabIndex = 22;
            this.btnChange.Text = "修改";
            this.btnChange.UseVisualStyleBackColor = false;
            this.btnChange.Click += new System.EventHandler(this.btnChange_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.pictureBox1.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox1.BackgroundImage = global::人力资源管理系统.Properties.Resources.左;
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox1.Location = new System.Drawing.Point(0, -6);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(95, 47);
            this.pictureBox1.TabIndex = 18;
            this.pictureBox1.TabStop = false;
            // 
            // btnFind
            // 
            this.btnFind.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.btnFind.BackColor = System.Drawing.SystemColors.Control;
            this.btnFind.BackgroundImage = global::人力资源管理系统.Properties.Resources.子界面按钮背景;
            this.btnFind.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnFind.FlatAppearance.BorderColor = System.Drawing.Color.DeepSkyBlue;
            this.btnFind.FlatAppearance.BorderSize = 0;
            this.btnFind.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.btnFind.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnFind.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnFind.ForeColor = System.Drawing.Color.Gold;
            this.btnFind.Location = new System.Drawing.Point(101, 12);
            this.btnFind.Name = "btnFind";
            this.btnFind.Size = new System.Drawing.Size(90, 29);
            this.btnFind.TabIndex = 20;
            this.btnFind.Text = "查询";
            this.btnFind.UseVisualStyleBackColor = false;
            this.btnFind.Click += new System.EventHandler(this.btnFind_Click);
            // 
            // btnAdd
            // 
            this.btnAdd.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.btnAdd.BackColor = System.Drawing.SystemColors.Control;
            this.btnAdd.BackgroundImage = global::人力资源管理系统.Properties.Resources.子界面按钮背景;
            this.btnAdd.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnAdd.FlatAppearance.BorderColor = System.Drawing.Color.DeepSkyBlue;
            this.btnAdd.FlatAppearance.BorderSize = 0;
            this.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAdd.Font = new System.Drawing.Font("幼圆", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnAdd.ForeColor = System.Drawing.Color.Gold;
            this.btnAdd.Location = new System.Drawing.Point(200, 12);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(90, 29);
            this.btnAdd.TabIndex = 21;
            this.btnAdd.Text = "添加";
            this.btnAdd.UseVisualStyleBackColor = false;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(57)))), ((int)(((byte)(181)))), ((int)(((byte)(235)))));
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.记录号,
            this.员工号,
            this.计薪年月,
            this.应勤天数,
            this.矿工天数,
            this.实际出勤,
            this.加班天数,
            this.事假天数,
            this.病假天数,
            this.婚葬产假,
            this.调休天数,
            this.迟到早退,
            this.年假天数,
            this.备注});
            this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView1.Location = new System.Drawing.Point(0, 47);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView1.Size = new System.Drawing.Size(688, 450);
            this.dataGridView1.TabIndex = 3;
            this.dataGridView1.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellDoubleClick);
            // 
            // 记录号
            // 
            this.记录号.DataPropertyName = "记录号";
            this.记录号.HeaderText = "记录号";
            this.记录号.Name = "记录号";
            this.记录号.ReadOnly = true;
            // 
            // 员工号
            // 
            this.员工号.DataPropertyName = "员工号";
            this.员工号.HeaderText = "员工号";
            this.员工号.Name = "员工号";
            this.员工号.ReadOnly = true;
            // 
            // 计薪年月
            // 
            this.计薪年月.DataPropertyName = "计薪年月";
            this.计薪年月.HeaderText = "计薪年月";
            this.计薪年月.Name = "计薪年月";
            this.计薪年月.ReadOnly = true;
            // 
            // 应勤天数
            // 
            this.应勤天数.DataPropertyName = "应勤天数";
            this.应勤天数.HeaderText = "应勤天数";
            this.应勤天数.Name = "应勤天数";
            this.应勤天数.ReadOnly = true;
            // 
            // 矿工天数
            // 
            this.矿工天数.DataPropertyName = "矿工天数";
            this.矿工天数.HeaderText = "矿工天数";
            this.矿工天数.Name = "矿工天数";
            this.矿工天数.ReadOnly = true;
            // 
            // 实际出勤
            // 
            this.实际出勤.DataPropertyName = "实际出勤";
            this.实际出勤.HeaderText = "实际出勤";
            this.实际出勤.Name = "实际出勤";
            this.实际出勤.ReadOnly = true;
            // 
            // 加班天数
            // 
            this.加班天数.DataPropertyName = "加班天数";
            this.加班天数.HeaderText = "加班天数";
            this.加班天数.Name = "加班天数";
            this.加班天数.ReadOnly = true;
            // 
            // 事假天数
            // 
            this.事假天数.DataPropertyName = "事假天数";
            this.事假天数.HeaderText = "事假天数";
            this.事假天数.Name = "事假天数";
            this.事假天数.ReadOnly = true;
            // 
            // 病假天数
            // 
            this.病假天数.DataPropertyName = "病假天数";
            this.病假天数.HeaderText = "病假天数";
            this.病假天数.Name = "病假天数";
            this.病假天数.ReadOnly = true;
            // 
            // 婚葬产假
            // 
            this.婚葬产假.DataPropertyName = "婚葬产假";
            this.婚葬产假.HeaderText = "婚丧产假";
            this.婚葬产假.Name = "婚葬产假";
            this.婚葬产假.ReadOnly = true;
            // 
            // 调休天数
            // 
            this.调休天数.DataPropertyName = "调休天数";
            this.调休天数.HeaderText = "调休天数";
            this.调休天数.Name = "调休天数";
            this.调休天数.ReadOnly = true;
            // 
            // 迟到早退
            // 
            this.迟到早退.DataPropertyName = "迟到早退";
            this.迟到早退.HeaderText = "迟到早退";
            this.迟到早退.Name = "迟到早退";
            this.迟到早退.ReadOnly = true;
            // 
            // 年假天数
            // 
            this.年假天数.DataPropertyName = "年假天数";
            this.年假天数.HeaderText = "年假天数";
            this.年假天数.Name = "年假天数";
            this.年假天数.ReadOnly = true;
            // 
            // 备注
            // 
            this.备注.DataPropertyName = "备注";
            this.备注.HeaderText = "备注";
            this.备注.Name = "备注";
            this.备注.ReadOnly = true;
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.查询FToolStripMenuItem,
            this.添加AToolStripMenuItem,
            this.修改CToolStripMenuItem,
            this.删除ToolStripMenuItem,
            this.导出OToolStripMenuItem,
            this.条件查找ToolStripMenuItem,
            this.显示所有VToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(153, 180);
            // 
            // 查询FToolStripMenuItem
            // 
            this.查询FToolStripMenuItem.Name = "查询FToolStripMenuItem";
            this.查询FToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.查询FToolStripMenuItem.Text = "查询(&F)";
            this.查询FToolStripMenuItem.Click += new System.EventHandler(this.查询FToolStripMenuItem_Click);
            // 
            // 添加AToolStripMenuItem
            // 
            this.添加AToolStripMenuItem.Name = "添加AToolStripMenuItem";
            this.添加AToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.添加AToolStripMenuItem.Text = "添加(&A)";
            this.添加AToolStripMenuItem.Click += new System.EventHandler(this.添加AToolStripMenuItem_Click);
            // 
            // 修改CToolStripMenuItem
            // 
            this.修改CToolStripMenuItem.Name = "修改CToolStripMenuItem";
            this.修改CToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.修改CToolStripMenuItem.Text = "修改(&C)";
            this.修改CToolStripMenuItem.Click += new System.EventHandler(this.修改CToolStripMenuItem_Click);
            // 
            // 删除ToolStripMenuItem
            // 
            this.删除ToolStripMenuItem.Name = "删除ToolStripMenuItem";
            this.删除ToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.删除ToolStripMenuItem.Text = "删除(&D)";
            this.删除ToolStripMenuItem.Click += new System.EventHandler(this.删除ToolStripMenuItem_Click);
            // 
            // 导出OToolStripMenuItem
            // 
            this.导出OToolStripMenuItem.Name = "导出OToolStripMenuItem";
            this.导出OToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.导出OToolStripMenuItem.Text = "导出(&O)";
            this.导出OToolStripMenuItem.Click += new System.EventHandler(this.导出OToolStripMenuItem_Click);
            // 
            // 条件查找ToolStripMenuItem
            // 
            this.条件查找ToolStripMenuItem.Name = "条件查找ToolStripMenuItem";
            this.条件查找ToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.条件查找ToolStripMenuItem.Text = "条件查找(&S)";
            this.条件查找ToolStripMenuItem.Click += new System.EventHandler(this.条件查找ToolStripMenuItem_Click);
            // 
            // 显示所有VToolStripMenuItem
            // 
            this.显示所有VToolStripMenuItem.Name = "显示所有VToolStripMenuItem";
            this.显示所有VToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.显示所有VToolStripMenuItem.Text = "显示所有(&V)";
            this.显示所有VToolStripMenuItem.Click += new System.EventHandler(this.显示所有VToolStripMenuItem_Click);
            // 
            // frmAttendanceManagement
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = global::人力资源管理系统.Properties.Resources.index_header_bg;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(688, 497);
            this.ContextMenuStrip = this.contextMenuStrip1;
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.panel1);
            this.DoubleBuffered = true;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "frmAttendanceManagement";
            this.Text = "考勤管理";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.frmAttendanceManagement_Load);
            this.panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btnOut;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.Button btnChange;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnFind;
        private System.Windows.Forms.Button btnAdd;
        public System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn 记录号;
        private System.Windows.Forms.DataGridViewTextBoxColumn 员工号;
        private System.Windows.Forms.DataGridViewTextBoxColumn 计薪年月;
        private System.Windows.Forms.DataGridViewTextBoxColumn 应勤天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 矿工天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 实际出勤;
        private System.Windows.Forms.DataGridViewTextBoxColumn 加班天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 事假天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 病假天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 婚葬产假;
        private System.Windows.Forms.DataGridViewTextBoxColumn 调休天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 迟到早退;
        private System.Windows.Forms.DataGridViewTextBoxColumn 年假天数;
        private System.Windows.Forms.DataGridViewTextBoxColumn 备注;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 条件查找ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 查询FToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 添加AToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 修改CToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 导出OToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 显示所有VToolStripMenuItem;
    }
}