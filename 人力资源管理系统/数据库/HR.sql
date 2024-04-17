USE [master]
GO
 
CREATE DATABASE [HR]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HR', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL.2\MSSQL\DATA\HR.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'HR_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL.2\MSSQL\DATA\HR_log.ldf' , SIZE = 3456KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [HR] SET COMPATIBILITY_LEVEL = 90
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HR].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HR] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HR] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HR] SET ANSI_PADDING OFF 
GO677520
ALTER DATABASE [HR] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HR] SET ARITHABORT OFF 
GO
ALTER DATABASE [HR] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HR] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [HR] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HR] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HR] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HR] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HR] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HR] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HR] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HR] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HR] SET  DISABLE_BROKER 
GO
ALTER DATABASE [HR] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HR] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HR] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HR] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HR] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HR] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HR] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HR] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HR] SET  MULTI_USER 
GO
ALTER DATABASE [HR] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HR] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HR] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HR] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'HR', N'ON'
GO
USE [HR]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UserTable](
	[UserName] [varchar](10) NOT NULL,
	[PassWord] [varchar](50) NOT NULL,
	[Type] [varchar](10) NOT NULL,
 CONSTRAINT [PK_UserTable] PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[部门表](
	[部门编号] [varchar](10) NOT NULL,
	[部门名称] [varchar](10) NOT NULL,
 CONSTRAINT [PK_部门] PRIMARY KEY CLUSTERED 
(
	[部门编号] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[工资表](
	[流水号] [bigint] IDENTITY(1,1) NOT NULL,
	[员工号] [varchar](10) NOT NULL,
	[计薪年月] [varchar](6) NOT NULL,
	[发放日期] [datetime] NOT NULL,
	[月薪] [varchar](10) NOT NULL,
	[加班费] [varchar](10) NULL,
	[节假日补贴] [varchar](10) NULL,
	[高温补贴] [varchar](10) NULL,
	[住房补贴] [varchar](10) NULL,
	[交通补贴] [varchar](10) NULL,
	[其他加项] [varchar](10) NULL,
	[所得税] [varchar](10) NULL,
	[公积金] [varchar](10) NULL,
	[社会保险] [varchar](10) NULL,
	[其他扣资] [varchar](10) NULL,
	[实发工资] [varchar](10) NOT NULL,
	[制表人] [varchar](10) NULL,
	[制表时间] [datetime] NULL,
	[审核人] [varchar](10) NULL,
	[审核时间] [datetime] NULL,
	[备注] [varchar](100) NULL,
 CONSTRAINT [PK_工资条] PRIMARY KEY CLUSTERED 
(
	[流水号] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[奖惩表](
	[记录号] [bigint] NOT NULL,
	[员工号] [varchar](10) NOT NULL,
	[奖惩名称] [varchar](20) NOT NULL,
	[奖惩类型] [varchar](2) NOT NULL,
	[计薪年月] [varchar](6) NULL,
	[奖惩日期] [datetime] NULL,
	[奖惩金额] [varchar](10) NULL,
	[奖惩原因] [varchar](100) NULL,
 CONSTRAINT [PK_奖罚表] PRIMARY KEY CLUSTERED 
(
	[记录号] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[考勤表](
	[记录号] [bigint] NOT NULL,
	[计薪年月] [varchar](6) NOT NULL,
	[员工号] [varchar](10) NOT NULL,
	[应勤天数] [varchar](10) NOT NULL,
	[实际出勤] [varchar](10) NOT NULL,
	[加班天数] [varchar](10) NULL,
	[事假天数] [varchar](10) NULL,
	[病假天数] [varchar](10) NULL,
	[年假天数] [varchar](10) NULL,
	[婚葬产假] [varchar](10) NULL,
	[调休天数] [varchar](10) NULL,
	[矿工天数] [varchar](10) NULL,
	[迟到早退] [varchar](10) NULL,
	[备注] [varchar](100) NULL,
 CONSTRAINT [PK_考勤表] PRIMARY KEY CLUSTERED 
(
	[记录号] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[员工表](
	[员工号] [varchar](10) NOT NULL,
	[姓名] [varchar](20) NOT NULL,
	[性别] [varchar](2) NOT NULL,
	[部门] [varchar](10) NOT NULL,
	[出生日期] [datetime] NOT NULL,
	[月薪] [varchar](10) NOT NULL,
	[开户行] [varchar](50) NULL,
	[账号] [varchar](20) NULL,
 CONSTRAINT [PK_员工表] PRIMARY KEY CLUSTERED 
(
	[员工号] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[UserTable] ([UserName], [PassWord], [Type]) VALUES (N'管理员', N'00000', N'管理员')
INSERT [dbo].[UserTable] ([UserName], [PassWord], [Type]) VALUES (N'用户1', N'11111', N'其他')
INSERT [dbo].[UserTable] ([UserName], [PassWord], [Type]) VALUES (N'用户2', N'22222', N'其他')
SET IDENTITY_INSERT [dbo].[工资表] ON 

INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10010, N'101001', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10011, N'101002', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10012, N'101003', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10013, N'101004', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10014, N'101005', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10015, N'101006', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10016, N'101007', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10017, N'101011', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10018, N'101013', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10019, N'101014', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10020, N'202001', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10021, N'202002', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10022, N'202003', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
INSERT [dbo].[工资表] ([流水号], [员工号], [计薪年月], [发放日期], [月薪], [加班费], [节假日补贴], [高温补贴], [住房补贴], [交通补贴], [其他加项], [所得税], [公积金], [社会保险], [其他扣资], [实发工资], [制表人], [制表时间], [审核人], [审核时间], [备注]) VALUES (10023, N'202004', N'201305', CAST(0x0000A1AE00000000 AS DateTime), N'3500', N'300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'3800', NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL, CAST(0x0000A1EB00000000 AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[工资表] OFF
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (2, N'101002', N'1', N'惩', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'300', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (3, N'101003', N'1', N'奖', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'300', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (4, N'101004', N'1', N'奖', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'500', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (5, N'101005', N'1', N'惩', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'400', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (6, N'101006', N'1', N'奖', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'500', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (7, N'101007', N'1', N'惩', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'200', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (8, N'101011', N'1', N'奖', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'500', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (9, N'101013', N'1', N'惩', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'300', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (10, N'101014', N'1', N'奖', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'500', NULL)
INSERT [dbo].[奖惩表] ([记录号], [员工号], [奖惩名称], [奖惩类型], [计薪年月], [奖惩日期], [奖惩金额], [奖惩原因]) VALUES (11, N'202001', N'1', N'奖', N'201306', CAST(0x0000A1C700000000 AS DateTime), N'200', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (1, N'201306', N'101001', N'235', N'235', N'37', N'21', N'5', N'20', N'0', N'12', N'12', N'16', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (2, N'201306', N'101002', N'246', N'245', N'40', N'32', N'4', N'20', N'0', N'12', N'3', N'3', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (3, N'201306', N'101003', N'244', N'244', N'57', N'10', N'6', N'20', N'0', N'12', N'9', N'11', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (4, N'201306', N'101004', N'237', N'235', N'55', N'13', N'7', N'20', N'0', N'12', N'4', N'7', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (5, N'201306', N'101005', N'235', N'235', N'32', N'13', N'5', N'20', N'0', N'12', N'7', N'6', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (6, N'201306', N'101006', N'255', N'250', N'51', N'21', N'2', N'20', N'0', N'12', N'5', N'14', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (7, N'201306', N'101007', N'257', N'255', N'35', N'18', N'3', N'20', N'0', N'12', N'8', N'13', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (8, N'201306', N'101011', N'246', N'246', N'57', N'15', N'4', N'20', N'0', N'12', N'8', N'6', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (9, N'201306', N'101013', N'237', N'235', N'45', N'12', N'9', N'20', N'0', N'12', N'7', N'3', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (10, N'201306', N'101014', N'231', N'230', N'26', N'11', N'6', N'20', N'0', N'12', N'4', N'4', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (11, N'201306', N'202001', N'265', N'254', N'57', N'18', N'12', N'20', N'0', N'12', N'6', N'9', NULL)
INSERT [dbo].[考勤表] ([记录号], [计薪年月], [员工号], [应勤天数], [实际出勤], [加班天数], [事假天数], [病假天数], [年假天数], [婚葬产假], [调休天数], [矿工天数], [迟到早退], [备注]) VALUES (13, N'201306', N'202003', N'254', N'253', N'42', N'19', N'3', N'20', N'0', N'12', N'7', N'6', NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101001', N'李宁', N'男', N'开发部', CAST(0x0000722300000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101002', N'张庆宁', N'男', N'开发部', CAST(0x000077FA00000000 AS DateTime), N'4500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101003', N'成康帅', N'男', N'开发部', CAST(0x0000713400000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101004', N'刘东', N'男', N'开发部', CAST(0x00006E0100000000 AS DateTime), N'4500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101005', N'李林莉', N'男', N'开发部', CAST(0x00007F3700000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101006', N'李广', N'男', N'开发部', CAST(0x0000722300000000 AS DateTime), N'2500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101007', N'张成', N'男', N'开发部', CAST(0x0000808F00000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101011', N'孙琳', N'男', N'开发部', CAST(0x000077FA00000000 AS DateTime), N'4500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101013', N'金莎', N'男', N'开发部', CAST(0x0000722300000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'101014', N'刘德华', N'男', N'开发部', CAST(0x0000713400000000 AS DateTime), N'5400', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'11111', N'111', N'男', N'办公室', CAST(0x0000A1EB009A558D AS DateTime), N'asa', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'202001', N'仲锦涛', N'男', N'测试部', CAST(0x000077FA00000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'202002', N'胡思芸', N'男', N'测试部', CAST(0x00006E0100000000 AS DateTime), N'2500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'202003', N'陈春燕', N'女', N'测试部', CAST(0x000077FA00000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'202006', N'张娇', N'男', N'测试部', CAST(0x0000843C00000000 AS DateTime), N'3654', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302012', N'华倩', N'男', N'综合事务部', CAST(0x0000722300000000 AS DateTime), N'4650', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302013', N'戴米娜', N'女', N'综合事务部', CAST(0x000077FA00000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302014', N'周娜', N'男', N'综合事务部', CAST(0x00007F3700000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302015', N'阮熠斐', N'女', N'综合事务部', CAST(0x00006E0100000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302016', N'周春兰', N'女', N'综合事务部', CAST(0x00007DAC00000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302017', N'周颖岚', N'女', N'综合事务部', CAST(0x000084B800000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302018', N'陆天舒', N'女', N'综合事务部', CAST(0x0000722300000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302019', N'高佩文', N'女', N'综合事务部', CAST(0x00007F3700000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302020', N'韩堰秋', N'女', N'综合事务部', CAST(0x00006E0100000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302021', N'仲彤', N'女', N'综合事务部', CAST(0x0000713400000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302022', N'顾涛', N'男', N'综合事务部', CAST(0x000077FA00000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302023', N'周昂', N'男', N'综合事务部', CAST(0x00007F5000000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302024', N'杨悦', N'男', N'综合事务部', CAST(0x00006F4900000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'302025', N'朱叶', N'男', N'综合事务部', CAST(0x00007F7A00000000 AS DateTime), N'4654', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'402026', N'王嘉辰', N'女', N'销售部', CAST(0x0000722300000000 AS DateTime), N'5465', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'402027', N'徐佳欣', N'女', N'销售部', CAST(0x000080C000000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'402028', N'张颖', N'男', N'销售部', CAST(0x0000722300000000 AS DateTime), N'3400', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'402031', N'徐宗怡', N'男', N'销售部', CAST(0x000077FA00000000 AS DateTime), N'3400', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'402033', N'高佳祺', N'男', N'销售部', CAST(0x0000713400000000 AS DateTime), N'3400', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'402036', N'吴凌霄', N'男', N'销售部', CAST(0x00007F3700000000 AS DateTime), N'3400', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'502038', N'孙浏燕', N'男', N'人力资源部', CAST(0x00006E0100000000 AS DateTime), N'4600', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'502039', N'刘孟', N'男', N'人力资源部', CAST(0x000080C000000000 AS DateTime), N'3400', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'502040', N'王建', N'男', N'人力资源部', CAST(0x0000722300000000 AS DateTime), N'3400', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'502041', N'查晓慧', N'男', N'人力资源部', CAST(0x0000722300000000 AS DateTime), N'3000', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602054', N'胡蓓', N'男', N'财务部', CAST(0x00006E0100000000 AS DateTime), N'4650', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602059', N'陈梦颖', N'男', N'财务部', CAST(0x0000722300000000 AS DateTime), N'3400', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602060', N'顾蕾', N'男', N'财务部', CAST(0x000080C000000000 AS DateTime), N'3460', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602068', N'薛玲君', N'男', N'财务部', CAST(0x0000713400000000 AS DateTime), N'3465', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602070', N'邵桂芬', N'男', N'财务部', CAST(0x00006E0100000000 AS DateTime), N'3650', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602071', N'陈倩', N'男', N'财务部', CAST(0x000077FA00000000 AS DateTime), N'3465', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602074', N'邵晓晗', N'男', N'财务部', CAST(0x00007F3700000000 AS DateTime), N'3400', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602075', N'董文婷', N'女', N'财务部', CAST(0x00007F3700000000 AS DateTime), N'4650', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602077', N'龚晓兰', N'男', N'财务部', CAST(0x0000722300000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'602080', N'冯文娟', N'男', N'财务部', CAST(0x00006E0100000000 AS DateTime), N'3500', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'702082', N'周秋香', N'男', N'保安部', CAST(0x0000722300000000 AS DateTime), N'3000', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'704040', N'丁逸枫', N'男', N'保安部', CAST(0x000080C000000000 AS DateTime), N'3000', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'704041', N'张三丰', N'男', N'保安部', CAST(0x000077FA00000000 AS DateTime), N'3000', N'', N'')
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'802029', N'韩蓉蓉', N'女', N'办公室', CAST(0x00007F3700000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'802030', N'归晴霞', N'女', N'办公室', CAST(0x000077FA00000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'802032', N'钱辛兰', N'女', N'办公室', CAST(0x0000713400000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'802034', N'石林', N'女', N'办公室', CAST(0x0000722300000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'802035', N'王怡洁', N'女', N'办公室', CAST(0x00006E0100000000 AS DateTime), N'3500', NULL, NULL)
INSERT [dbo].[员工表] ([员工号], [姓名], [性别], [部门], [出生日期], [月薪], [开户行], [账号]) VALUES (N'802037', N'居海蒙', N'女', N'办公室', CAST(0x000077FA00000000 AS DateTime), N'3300', NULL, NULL)
ALTER TABLE [dbo].[奖惩表]  WITH CHECK ADD  CONSTRAINT [FK_奖惩表_员工表] FOREIGN KEY([员工号])
REFERENCES [dbo].[员工表] ([员工号])
GO
ALTER TABLE [dbo].[奖惩表] CHECK CONSTRAINT [FK_奖惩表_员工表]
GO
ALTER TABLE [dbo].[考勤表]  WITH CHECK ADD  CONSTRAINT [FK_考勤表_员工表] FOREIGN KEY([员工号])
REFERENCES [dbo].[员工表] ([员工号])
GO
ALTER TABLE [dbo].[考勤表] CHECK CONSTRAINT [FK_考勤表_员工表]
GO
USE [master]
GO
ALTER DATABASE [HR] SET  READ_WRITE 
GO
