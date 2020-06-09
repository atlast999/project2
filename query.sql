USE [master]
GO
/****** Object:  Database [OOP]    Script Date: 6/9/2020 7:04:13 PM ******/
CREATE DATABASE [OOP]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OOP', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\OOP.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'OOP_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\OOP_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [OOP] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OOP].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OOP] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OOP] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OOP] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OOP] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OOP] SET ARITHABORT OFF 
GO
ALTER DATABASE [OOP] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OOP] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OOP] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OOP] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OOP] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OOP] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OOP] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OOP] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OOP] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OOP] SET  DISABLE_BROKER 
GO
ALTER DATABASE [OOP] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OOP] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OOP] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OOP] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OOP] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OOP] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OOP] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OOP] SET RECOVERY FULL 
GO
ALTER DATABASE [OOP] SET  MULTI_USER 
GO
ALTER DATABASE [OOP] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OOP] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OOP] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OOP] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [OOP] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'OOP', N'ON'
GO
USE [OOP]
GO
/****** Object:  Table [dbo].[score]    Script Date: 6/9/2020 7:04:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[score](
	[owner] [int] NOT NULL,
	[level] [int] NOT NULL,
	[topicName] [varchar](255) NOT NULL,
	[value] [int] NOT NULL,
	[created_at] [datetime] NOT NULL DEFAULT (getdate()),
PRIMARY KEY CLUSTERED 
(
	[level] ASC,
	[created_at] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[topic]    Script Date: 6/9/2020 7:04:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[topic](
	[level] [int] NOT NULL,
	[topicId] [int] NOT NULL,
	[length] [int] NOT NULL,
	[name] [varchar](255) NOT NULL,
	[description] [varchar](255) NULL,
 CONSTRAINT [primaryKey] PRIMARY KEY CLUSTERED 
(
	[topicId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[track]    Script Date: 6/9/2020 7:04:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[track](
	[topicId] [int] NOT NULL,
	[trackId] [int] NOT NULL,
	[fileName] [varchar](255) NULL,
	[script] [varchar](255) NULL,
	[freeWord] [varchar](255) NULL,
 CONSTRAINT [primaryKey2] PRIMARY KEY CLUSTERED 
(
	[trackId] ASC,
	[topicId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 6/9/2020 7:04:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] NOT NULL,
	[name] [varchar](255) NULL,
	[username] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 50, CAST(N'2020-06-09 18:48:15.333' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 50, CAST(N'2020-06-09 18:48:15.670' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 51, CAST(N'2020-06-09 18:48:15.983' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 51, CAST(N'2020-06-09 18:48:16.293' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 52, CAST(N'2020-06-09 18:48:16.607' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 53, CAST(N'2020-06-09 18:48:16.920' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 54, CAST(N'2020-06-09 18:48:17.233' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 55, CAST(N'2020-06-09 18:48:17.547' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 56, CAST(N'2020-06-09 18:48:17.860' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 57, CAST(N'2020-06-09 18:48:18.170' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 59, CAST(N'2020-06-09 18:48:18.483' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 60, CAST(N'2020-06-09 18:48:18.800' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 62, CAST(N'2020-06-09 18:48:19.110' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 63, CAST(N'2020-06-09 18:48:19.420' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 65, CAST(N'2020-06-09 18:48:19.733' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 67, CAST(N'2020-06-09 18:48:20.040' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 68, CAST(N'2020-06-09 18:48:20.350' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 70, CAST(N'2020-06-09 18:48:20.663' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 71, CAST(N'2020-06-09 18:48:20.973' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 73, CAST(N'2020-06-09 18:48:21.283' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 74, CAST(N'2020-06-09 18:48:21.593' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 75, CAST(N'2020-06-09 18:48:21.907' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 76, CAST(N'2020-06-09 18:48:22.217' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 77, CAST(N'2020-06-09 18:48:22.530' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 78, CAST(N'2020-06-09 18:48:22.840' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 79, CAST(N'2020-06-09 18:48:23.150' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 79, CAST(N'2020-06-09 18:48:23.460' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 1, N'Love yourself', 80, CAST(N'2020-06-09 18:48:23.770' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 50, CAST(N'2020-06-09 18:48:15.460' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 50, CAST(N'2020-06-09 18:48:15.773' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 51, CAST(N'2020-06-09 18:48:16.087' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 51, CAST(N'2020-06-09 18:48:16.397' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 52, CAST(N'2020-06-09 18:48:16.710' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 53, CAST(N'2020-06-09 18:48:17.023' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 54, CAST(N'2020-06-09 18:48:17.340' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 55, CAST(N'2020-06-09 18:48:17.650' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 56, CAST(N'2020-06-09 18:48:17.963' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 57, CAST(N'2020-06-09 18:48:18.273' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 59, CAST(N'2020-06-09 18:48:18.590' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 60, CAST(N'2020-06-09 18:48:18.903' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 62, CAST(N'2020-06-09 18:48:19.217' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 63, CAST(N'2020-06-09 18:48:19.527' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 65, CAST(N'2020-06-09 18:48:19.833' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 67, CAST(N'2020-06-09 18:48:20.143' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 68, CAST(N'2020-06-09 18:48:20.457' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 70, CAST(N'2020-06-09 18:48:20.767' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 71, CAST(N'2020-06-09 18:48:21.077' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 73, CAST(N'2020-06-09 18:48:21.387' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 74, CAST(N'2020-06-09 18:48:21.697' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 75, CAST(N'2020-06-09 18:48:22.010' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 76, CAST(N'2020-06-09 18:48:22.320' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 77, CAST(N'2020-06-09 18:48:22.633' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 78, CAST(N'2020-06-09 18:48:22.940' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 79, CAST(N'2020-06-09 18:48:23.250' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 79, CAST(N'2020-06-09 18:48:23.563' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 2, N'Love yourself', 80, CAST(N'2020-06-09 18:48:23.877' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 50, CAST(N'2020-06-09 18:48:15.567' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 50, CAST(N'2020-06-09 18:48:15.880' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 51, CAST(N'2020-06-09 18:48:16.190' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 51, CAST(N'2020-06-09 18:48:16.500' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 52, CAST(N'2020-06-09 18:48:16.813' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 53, CAST(N'2020-06-09 18:48:17.127' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 54, CAST(N'2020-06-09 18:48:17.443' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 55, CAST(N'2020-06-09 18:48:17.757' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 56, CAST(N'2020-06-09 18:48:18.067' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 57, CAST(N'2020-06-09 18:48:18.380' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 59, CAST(N'2020-06-09 18:48:18.693' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 60, CAST(N'2020-06-09 18:48:19.007' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 62, CAST(N'2020-06-09 18:48:19.317' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 63, CAST(N'2020-06-09 18:48:19.630' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 65, CAST(N'2020-06-09 18:48:19.937' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 67, CAST(N'2020-06-09 18:48:20.247' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 68, CAST(N'2020-06-09 18:48:20.560' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 70, CAST(N'2020-06-09 18:48:20.870' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 71, CAST(N'2020-06-09 18:48:21.180' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 73, CAST(N'2020-06-09 18:48:21.490' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 74, CAST(N'2020-06-09 18:48:21.800' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 75, CAST(N'2020-06-09 18:48:22.113' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 76, CAST(N'2020-06-09 18:48:22.423' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 77, CAST(N'2020-06-09 18:48:22.737' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 78, CAST(N'2020-06-09 18:48:23.043' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 79, CAST(N'2020-06-09 18:48:23.353' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 79, CAST(N'2020-06-09 18:48:23.667' AS DateTime))
INSERT [dbo].[score] ([owner], [level], [topicName], [value], [created_at]) VALUES (1, 3, N'Love yourself', 80, CAST(N'2020-06-09 18:48:23.980' AS DateTime))
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (1, 1, 58, N'Try to sleep', N'Norma went to bed. It was eleven o’clock...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (1, 2, 58, N'Red, White and Blue', N'Tracy looked at the flag. The flag is red, white, and blue...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (1, 3, 58, N'A Thin Man', N'Richard is a light eater. He doesn’t eat much...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (2, 4, 81, N'Thank you mom', N'I love my mom. She took care of me when I was very young...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (2, 5, 10, N'Cold Weather', N'Thomas was not hot. He was not warm either...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (2, 6, 59, N'New Shoes', N'Lisa loves to go shopping. Tomorrow she is going shopping...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (3, 7, 63, N'Benjamin Franklin', N'Benjamin Franklin was one of the most famous people in American history...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (3, 8, 66, N'Hawaii', N'Of the fifty states in the United States...')
INSERT [dbo].[topic] ([level], [topicId], [length], [name], [description]) VALUES (3, 9, 81, N'William Shakespeare', N'There have been many great writers in the history of English literature...')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (1, 1, N'track1_1', N'Norma went to bed. It was eleven o''clock. She turned out the light.', N'Norma')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (2, 1, N'track2_1', N'Tracy looked at the flag. The flag is red, white, and blue. It has 50 white stars.', N'Tracy')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (3, 1, N'track3_1', N'Richard is a light eater. He doesn''t eat much. He isn''t a heavy eater. He eats a light breakfast, a light lunch, and a light dinner.', N'Richard')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (4, 1, N'track4_1', N'I love my mom. She took care of me when I was very young. She took care of me when I was sick.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (5, 1, N'track5_1', N'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (6, 1, N'track6_1', N'Lisa loves to go shopping. Tomorrow she is going shopping. She needs a new pair of shoes. She wants to buy a pair of red shoes.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (7, 1, N'track7_1', N'Benjamin Franklin was one of the most famous people in American history.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (8, 1, N'track8_1', N'Of the fifty states in the United States, forty-nine are located on the mainland of North America.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (9, 1, N'track9_1', N'There have been many great writers in the history of English literature, but there is no doubt about which writer was the greatest. Many people consider William Shakespeare to have been the best writer who ever lived.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (1, 2, N'track1_2', N'She lay in bed. It was dark. It was quiet. She couldn''t sleep. She closed her eyes. She tried to sleep, but she couldn''t.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (2, 2, N'track2_2', N'The white stars are on a blue square. The flag has six white stripes. It has seven red stripes. All the stripes are horizontal.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (3, 2, N'track3_2', N'Richard is not fat. He is thin. He will always be thin, because he is a light eater.', N'Richard')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (4, 2, N'track4_2', N'She taught me how to read. She taught me how to get dressed. She taught me how to button my shirt. She taught me how to tie my shoes.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (5, 2, N'track5_2', N'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (6, 2, N'track6_2', N'She thinks red shoes are pretty. She will buy a pair of shoes at the mall. Lisa usually shops at the mall.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (7, 2, N'track7_2', N'He was never a President of the United States, but he made great achievements in many areas of life, including business, literature, science, and politics.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (8, 2, N'track8_2', N'The other state is Hawaii, which consists of several islands in the middle of the Pacific Ocean. Hawaii is known as an especially beautiful and interesting place.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (9, 2, N'track9_2', N'William Shakespeare was born in the town of Stratford, England, in the year 1564. When he was a young man, Shakespeare moved to the city of London, where he began writing plays. ', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (1, 3, N'track1_3', N'She turned the light back on. She opened her book. She started to read her book. It was a good book. She read one page. Then she read another page.', N'Norma')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (2, 3, N'track2_3', N'They are not vertical. The stripes do not go up and down. They go from left to right.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (3, 3, N'track3_3', N'He eats a bowl of cereal for breakfast. He eats a bowl of cereal with milk. He eats a sandwich for lunch. Sometimes it''s a fish sandwich. He likes fish.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (4, 3, N'track4_3', N'She taught me how to brush my teeth. She taught me to be kind to others. She taught me to tell the truth.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (5, 3, N'track5_3', N'cccccccccccccccccccccccccccccccccccc', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (6, 3, N'track6_3', N'The mall is only a mile from her house. She just walks to the mall. It only takes her 20 minutes.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (7, 3, N'track7_3', N'Benjamin Franklin was born in the city of Boston, during the year 1706. In his early years, Franklin was very poor. As a young man, he worked for his older brother, who was a printer.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (8, 3, N'track8_3', N'The Hawaiian islands were formed by volcanic eruptions that pushed molten rock, called Lava above the surface of the ocean.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (9, 3, N'track9_3', N'His plays were soon very successful, and were enjoyed both by the common people of London and also by the rich and famous. In addition to his plays, Shakespeare wrote many short poems and a few longer poems. ', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (1, 4, N'track1_4', N'After a while, she felt sleepy. She closed the book. She turned out the light. She closed her eyes. She went straight to sleep.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (2, 4, N'track2_4', N'Tracy loves her flag. It is the flag of her country. It is a pretty flag. No other flag has 50 stars. No other flag has 13 stripes.', N'Tracy')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (3, 4, N'track3_4', N'He eats rice and vegetables for dinner. All he eats for dinner is rice and vegetables. He will never get fat.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (4, 4, N'track4_4', N'She taught me to be polite. She took me to school on my first day of school. She held my hand.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (5, 4, N'track5_4', N'dddddddddddddddddddddddddddddddddddd', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (6, 4, N'track6_4', N'Tomorrow she will go to four different shoe stores. Tomorrow is Saturday. The mall always has sales on Saturday.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (7, 4, N'track7_4', N'However, the two brothers soon argued with each other. Benjamin decided to leave, and he moved to the city of Philadelphia. He worked very hard and soon became a successful printer.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (8, 4, N'track8_4', N'Some of the islands no longer have any volcanic activity, but there are still active volcanoes on two Hawaiian islands, Oahu and the big island which is known simply as Hawaii.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (9, 4, N'track9_4', N'Like his plays, these poems are still famous today. Shakespeare''s most famous plays include Romeo and Juliet, Macbeth, Hamlet, King Lear, Othello, and Julius Caesar. ', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (4, 5, N'track4_5', N'She helped me with my homework. She was nice to all my friends. She always cheered me up. Next year I will graduate from high school.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (5, 5, N'track5_5', N'eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (6, 5, N'track6_5', N'If the sale price is good, Lisa might buy two pairs of shoes.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (7, 5, N'track7_5', N'He published his own newspapers, and he also published books called almanacs, which contained many wise sayings.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (8, 5, N'track8_5', N'One of these volcanoes, Mauna Loa, still erupts sometimes, with spectacular explosions of lava. Another volcano, called Mauna Kea, is now dormant.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (9, 5, N'track9_5', N'Usually, Shakespeare did not invent the stories that he told in his plays. Instead, he wrote his plays using stories that already existed.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (4, 6, N'track4_6', N'I will go to college. I will do well in college. I will do well after college. My mom has taught me well.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (7, 6, N'track7_6', N'Many of the wise sayings in Franklin''s almanacs are still repeated today.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (8, 6, N'track8_6', N'These volcanoes are both very tall and reach over 4000 metres above sea level. The air above Mauna Kea is so clear and thin that scientists use the mountain as a base for observing the stars.', N'')
INSERT [dbo].[track] ([topicId], [trackId], [fileName], [script], [freeWord]) VALUES (9, 6, N'track9_6', N'However, Shakespeare''s plays told these stories in a more interesting way than ever before. Some of the stories were tragedies, some were comedies, and some described historical events.', N'')
INSERT [dbo].[users] ([id], [name], [username], [password]) VALUES (1, N'Quaker Oats', N'myname', N'mypassword')
USE [master]
GO
ALTER DATABASE [OOP] SET  READ_WRITE 
GO
