package main.java.se.jdbc;

import java.sql.*;

class K02Oracle 
{
	public static void main(String[] args)
	{
		/* Oracle 数据类型：
		 * VARCHAR2 (size) 可变长度的字符串, 必须规定长度
		 * NUMBER(p,s) 数字型p是位数总长度, s是小数的长度, 可存负数
		 * DATE 日期类型
		 * CLOB 超长文本字符串
		 * BLOB 二进制文件
		 * BFILE 外部二进制文件
		 * */
		/** 假设数据库表结构
		 * create table oracle
		 * (
		 * type_varchar2 varchar2(20),
		 * type_number number(9,3),
		 * type_date date,
		 * type_clob clob,
		 * type_blob blob,
		 * type_bfile bfile
		 * );
		 * */
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String userName = "system";
		String passwordDB = "f227777777";
		Connection conn= null;
		Statement stmt= null;
		ResultSet rs= null;
		String sql = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动类
			conn = DriverManager.getConnection(url, userName, passwordDB);//创建连接实例
			stmt = conn.createStatement();//创建 Statement 实例
			
			/** varchar2  number  date 类型数据的插入*/
			sql= "inset into oracle (type_varchar2, type_number, type_date)"
					+"values('kasei', 90, to_date('1994-04-01 00:52:37','yyyy-mm-dd hh24:mi:ss'))";//编写sql语句
			int flag= stmt.executeUpdate(sql);//执行sql语句，flag > 0 成功  
			
			/** varchar2  number  date 类型数据的读取*/
			sql= "select type_varchar2, type_number, type_date from oracle";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String varchar2= rs.getString(1);
				int number= rs.getInt("type_number");
				Date date= rs.getDate(3);//import java.sql.Date;
				
			}
			
			
		
			/** clob 类型的数据的插入*/
			Clob clob= rs.getClob("type_clob");//import java.sql.Clob;
			/** clob 类型的数据的读取*/
			
			/** blob 类型的数据的插入*/
			Blob blob= rs.getBlob(5);//import java.sql.Blob;
			/** blob 类型的数据的读取*/
			
			
			/** bfile 类型数据的插入*/
			//1.先在oracle数据库中建立一个目录别名,用于将文件定位指针映射到文件系统：  
			//CREATE [OR REPLACE] DIRECTORY directory AS 'pathname';
			sql= "create directory 'PICTURE' AS 'D:/tmp'";//PICTRUE 必须大写
			//2.根据需要授权,授权该用户对该目录的读权限
			//GRANT READ[,WRITE] ON DIRECTORY directory TO username;
			sql= "grant read,write on directory tmpdir TO scott";
			//3.插入数据 
			sql= "INSERT INTO bfiletest  VALUES (1, bfilename('TMPDIR', 'a.JPG'))";
			
			/** bfile 类型数据的读取*/
		}
		catch(ClassNotFoundException e)
		{   
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
		    e.printStackTrace() ;   
		} 
		catch(SQLException se)
		{   
			System.out.println("数据库连接失败或处理出错！");
		    se.printStackTrace() ;   
		}
		finally
		{
			try 
			{
				rs.close();
				stmt.close();
				conn.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
