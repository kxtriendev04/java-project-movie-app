/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=JavaQuanLyDatVeXemPhim;encrypt=false;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    protected static Connection connection;

    // Phương thức tạo kết nối tới cơ sở dữ liệu
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Nạp trình điều khiển SQL Server
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                // Tạo kết nối
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Ket noi thanh cong!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Ket noi that bai: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }

    // Phương thức đóng kết nối
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Da dong ket noi!");
            } catch (SQLException e) {
                System.out.println("Loi khi dong ket noi: " + e.getMessage());
            }
        }
    }
}
