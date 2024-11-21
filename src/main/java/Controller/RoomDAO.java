/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.DatabaseConnection.closeConnection;
import static Controller.DatabaseConnection.getConnection;
import Models.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RoomDAO extends DatabaseConnection {

    // Lấy tất cả các phòng chiếu chưa bị xóa (is_deleted = 0)
    public List<Room> getAllRoom() throws ClassNotFoundException, SQLException {
        List<Room> rooms = new ArrayList<>();
        
        // Kết nối đến cơ sở dữ liệu
        Connection connection = getConnection(); // Giả sử phương thức getConnection trong DatabaseConnection
        
        // SQL query để lấy tất cả các phòng chưa bị xóa
        String query = "SELECT * FROM rooms";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                // Đọc thông tin phòng chiếu từ ResultSet và thêm vào danh sách
                int id = rs.getInt("room_id");
                String name = rs.getString("room_name");
                String type = rs.getString("room_type");
                boolean isDeleted = rs.getBoolean("is_deleted");
                
                // Tạo đối tượng Room và thêm vào danh sách
                rooms.add(new Room(id, name, type, isDeleted));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để có thể xử lý ở lớp gọi
        }
        
        return rooms;
    }
    

    // Thêm một phòng chiếu mới vào cơ sở dữ liệu
    public boolean addRoom(String name, String type) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO rooms (room_name, room_type, is_deleted) VALUES (?, ?, 0)"; // is_deleted mặc định là 0 (không bị xóa)

        // Kết nối đến cơ sở dữ liệu
        Connection connection = getConnection(); // Giả sử phương thức getConnection trong DatabaseConnection
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, type);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Nếu có ít nhất 1 hàng bị ảnh hưởng, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để có thể xử lý ở lớp gọi
        }
    }

    // Cập nhật thông tin phòng chiếu theo ID
    public boolean updateCinemaById(int id, String name, String type) throws ClassNotFoundException, SQLException {
        String query = "UPDATE rooms SET room_name = ?, room_type = ? WHERE room_id = ?";
        
        // Kết nối đến cơ sở dữ liệu
        Connection connection = getConnection(); // Giả sử phương thức getConnection trong DatabaseConnection
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setInt(3, id);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Nếu có ít nhất 1 hàng bị ảnh hưởng, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để có thể xử lý ở lớp gọi
        }
    }

    // Thực hiện xóa mềm phòng chiếu theo ID (cập nhật is_deleted = 1)
    public boolean softDeleteById(int id) throws ClassNotFoundException, SQLException {
        String query = "UPDATE rooms SET is_deleted = 1 WHERE room_id = ?";
        
        // Kết nối đến cơ sở dữ liệu
        Connection connection = getConnection(); // Giả sử phương thức getConnection trong DatabaseConnection
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Nếu có ít nhất 1 hàng bị ảnh hưởng, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để có thể xử lý ở lớp gọi
        }
    }
    public boolean roomRestore(int id) throws ClassNotFoundException, SQLException {
        String query = "UPDATE rooms SET is_deleted = 0 WHERE room_id = ?";
        
        // Kết nối đến cơ sở dữ liệu
        Connection connection = getConnection(); // Giả sử phương thức getConnection trong DatabaseConnection
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Nếu có ít nhất 1 hàng bị ảnh hưởng, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để có thể xử lý ở lớp gọi
        }
    }
    public boolean deleteRoomForever(int roomId) throws ClassNotFoundException {
        // Truy vấn SQL để xóa vĩnh viễn lịch
        String query = "DELETE FROM rooms WHERE room_id = ? AND is_deleted = 1";  // Xóa lịch đã xóa mềm

        try (Connection connection = getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Thiết lập giá trị cho tham số
            stmt.setInt(1, roomId);

            // Thực thi truy vấn
            int rowsAffected = stmt.executeUpdate();

            // Nếu có ít nhất 1 dòng bị ảnh hưởng, nghĩa là lịch đã được xóa vĩnh viễn
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }

        // Trả về false nếu không có dòng nào bị ảnh hưởng (lịch không tồn tại hoặc chưa xóa mềm)
        return false;
    }
}
