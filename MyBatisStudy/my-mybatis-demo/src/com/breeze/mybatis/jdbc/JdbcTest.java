package com.breeze.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	
	public static void main(String[] args) {
		
		Connection connection = null;	//	数据连接
		
		PreparedStatement preparedStatement = null;	//	预编译的 Statement，使用预编译的 Statement 提高数据库的性能
		
		ResultSet resultSet = null;	//	结果集
		
		String dbUrl = "jdbc:mysql://192.168.31.177:3306/order_manager?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");	//	加载驱动程序
			
			connection = DriverManager.getConnection(dbUrl, "root", "root");	//	通过驱动管理类获得数据库连接
			
			//	定义 SQL 语句，？表示占位符
			String sql = "SELECT * FROM `users` WHERE `name` = ?";
			
			//	获取预处理的 Statement
			preparedStatement = connection.prepareStatement(sql);
			
			//	设置参数，第一个参数为 sql 语句中参数的序号（从 1 开始），第二个参数为设置的参数值
			preparedStatement.setString(1, "张三");
			
			//	向数据库发出 sql 执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			
			//	遍历查询出来的结果集
			while (resultSet.next()) {
				System.out.println("id = " + resultSet.getString("id") + "，name = " + resultSet.getString("name"));
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			//	释放资源
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
