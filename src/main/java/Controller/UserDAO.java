/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import static Controller.DatabaseConnection.getConnection;
import Models.Movie;
import Models.User;
import Views.PnlUsAcc;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
import java.sql.Statement;
import java.time.LocalDate;


public class UserDAO extends DatabaseConnection{
    public boolean addUser(User user) throws ClassNotFoundException, SQLException {
        //Câu lệnh SQL để thêm user
        String sql = "INSERT INTO users (username, password, fullname, birthday, gender, email, city, phone) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        //Kết nối cơ sở dữ liệu
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //Thiết lập các tham số
        pstmt.setString(1, user.getUsername());
        String oldpw = user.getPassword();
        String hashpw = User.hashPassword(oldpw);
        pstmt.setString(2, hashpw);
        pstmt.setString(3, user.getFullname());
        pstmt.setDate(4, user.getBirthday() == null ? null : java.sql.Date.valueOf(user.getBirthday()));
        pstmt.setInt(5, user.getGender());
        pstmt.setString(6, user.getEmail());
        pstmt.setString(7, user.getCity());
        pstmt.setString(8, user.getPhone());

        //Thực thi câu lệnh
        int result = pstmt.executeUpdate();

        return result != 0;
}

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        // Thực hiện truy vấn cơ sở dữ liệu để lấy danh sách phim
        String sql = "SELECT * FROM USERS";
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            // Lấy dữ liệu từ các cột trong cơ sở dữ liệu
            int userId = rs.getInt("user_id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String avatar = rs.getString("avatar");
            String fullname = rs.getString("fullname");
            LocalDate birthday = rs.getDate("birthday").toLocalDate(); // Chuyển từ java.sql.Date sang LocalDate
            int gender = rs.getInt("gender");
            String email = rs.getString("email");
            String city = rs.getString("city");
            String phone = rs.getString("phone");
            int point = rs.getInt("point");
            String role = rs.getString("role");
            Boolean isDeleted = rs.getBoolean("is_deleted");

            // Tạo đối tượng User và thêm vào danh sách
            User user = new User(userId, username, password, avatar, fullname, birthday, gender, email, city, phone, point, role, isDeleted);
            users.add(user);
        }
        return users;
    }
    
    public List<User> getAllUsersByName(String name) throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE fullname LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Gán tham số cho câu lệnh SQL
            pstmt.setString(1, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Lấy dữ liệu từ các cột trong cơ sở dữ liệu
                    int userId = rs.getInt("user_id");
                    String userUsername = rs.getString("username");
                    String password = rs.getString("password");
                    String avatar = rs.getString("avatar");
                    String fullname = rs.getString("fullname");
                    LocalDate birthday = rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null; // Xử lý null
                    int gender = rs.getInt("gender");
                    String email = rs.getString("email");
                    String city = rs.getString("city");
                    String phone = rs.getString("phone");
                    int point = rs.getInt("point");
                    String role = rs.getString("role");
                    Boolean isDeleted = rs.getBoolean("is_deleted");

                    // Tạo đối tượng User và thêm vào danh sách
                    User user = new User(userId, userUsername, password, avatar, fullname, birthday, gender, email, city, phone, point, role, isDeleted);
                    users.add(user);
                }
            }
        }
        return users;
    }

    public boolean updateUserByUsername(String username, String fullname, LocalDate birth, boolean gender, String email, String phone, String city, int point, String role) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE users SET fullname = ?, birthday = ?, gender = ?, email = ?, phone = ?, city = ?, point = ?, role = ? WHERE username = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
       
         // Set the parameters for the SQL query
        pstmt.setString(1, fullname);
        pstmt.setDate(2, java.sql.Date.valueOf(birth)); // Chuyển LocalDate sang java.sql.Date
        pstmt.setBoolean(3, gender);
        pstmt.setString(4, email);
        pstmt.setString(5, phone);
        pstmt.setString(6, city);
        pstmt.setInt(7, point);
        pstmt.setString(8, role);
        pstmt.setString(9, username);
        
        int result = pstmt.executeUpdate();
        return result != 0;
    }
    
    public boolean updateUserByUsernameSetting(String username, String fullname, LocalDate birth, boolean gender, String email, String phone, String city) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE users SET fullname = ?, birthday = ?, gender = ?, email = ?, phone = ?, city = ? WHERE username = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
       
         // Set the parameters for the SQL query
        pstmt.setString(1, fullname);
        pstmt.setDate(2, java.sql.Date.valueOf(birth)); // Chuyển LocalDate sang java.sql.Date
        pstmt.setBoolean(3, gender);
        pstmt.setString(4, email);
        pstmt.setString(5, phone);
        pstmt.setString(6, city);
        pstmt.setString(7, username);
        
        int result = pstmt.executeUpdate();
        return result != 0;
    }
    
    public boolean softDelete(String username) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE users SET is_deleted = ? WHERE username = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBoolean(1, true);
        pstmt.setString(2, username);
        int result = pstmt.executeUpdate();
        return result != 0;
    }
    public boolean deleteUserForever(String username) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM users WHERE username = ?"; // Xóa người dùng vĩnh viễn

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username); // Gán giá trị username vào câu truy vấn

            int rowsAffected = stmt.executeUpdate(); // Thực thi câu truy vấn
            return rowsAffected > 0; // Nếu có bản ghi bị xóa, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu không có bản ghi bị xóa
    }
    public boolean userRestore(String username) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE users SET is_deleted = ? WHERE username = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBoolean(1, false);
        pstmt.setString(2, username);
        int result = pstmt.executeUpdate();
        return result != 0;
    }
    public User getUserByUsernamePassword(String username, String password) throws ClassNotFoundException, SQLException {
        User user = null;
        String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";

        // Kết nối đến cơ sở dữ liệu
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username); // Thiết lập giá trị cho tham số SQL
            String oldpw = password;
            String hashpw = User.hashPassword(oldpw);
            pstmt.setString(2, hashpw); // Thiết lập giá trị cho tham số SQL

            // Thực hiện truy vấn
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Tạo đối tượng User từ dữ liệu trong ResultSet
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setFullname(rs.getString("fullname"));
                    user.setBirthday(rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null);
                    user.setGender(rs.getInt("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setCity(rs.getString("city"));
                    user.setPhone(rs.getString("phone"));
                    user.setPoint(rs.getInt("point"));
                    user.setRole(rs.getString("role"));
                    user.setIsDeleted(rs.getBoolean("is_deleted"));
                }
            }
        }

        return user;
    }

    public boolean checkUserByUsernamePassword(String username, String password) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";

        // Kết nối đến cơ sở dữ liệu
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username); // Thiết lập giá trị cho tham số SQL
            String oldpw = password;
            String hashpw = User.hashPassword(oldpw);
            pstmt.setString(2, hashpw); // Thiết lập giá trị cho tham số SQL

            // Thực hiện truy vấn
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
                }
            }
    } 
    
    public boolean updatePassword(String username, String password) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE users SET password = ? WHERE username = ?";

        // Kết nối đến cơ sở dữ liệu
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String hashpw = User.hashPassword(password);
            pstmt.setString(1, hashpw); // Thiết lập giá trị cho tham số SQL
            pstmt.setString(2, username); // Thiết lập giá trị cho tham số SQL

            // Thực hiện truy vấn
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            } 
    }
}
