package com.anhen.jdbc;

import java.sql.*;
public class JDBCSphinxQL {
	public static void main(String[] argv) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://192.168.30.143:9306?characterEncoding=utf8&maxAllowedPacket=512000",
							null, null);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		try {
			st = conn.createStatement();
			System.out.println("Searching:");
			rs = st.executeQuery("SELECT * FROM testrt WHERE MATCH('some query')");
			while (rs.next()) {
				System.out.print(" id=" + rs.getString("id") + " gid="
						+ rs.getString("gid") + " latitude="
						+ rs.getString("latitude") + " longitude="
						+ rs.getString("longitude")
				);
				System.out.println();
			}
			// optional, to get total count and other stats
			System.out.println("Stats:");
			rs = st.executeQuery("SHOW META");
			while (rs.next()) {
				System.out.println(rs.getString(1) + ' ' + rs.getString(2));
			}
			// a simple insert
			st.executeUpdate("INSERT INTO testrt(id,title,content,gid,latitude,longitude)"
					+ " VALUES(104,'some title','some description',12345,32.1343,45.56534)");
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Queries failed!");
			e.printStackTrace();
			return;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}