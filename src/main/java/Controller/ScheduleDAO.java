/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Schedule;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ScheduleDAO extends DatabaseConnection {
    
    // Lấy tất cả lịch chiếu
    public List<Schedule> getAllSchedule() throws ClassNotFoundException {
        List<Schedule> schedules = new ArrayList<>();
        String query = "SELECT schedule_id, room_id, movie_id, schedule_date, schedule_start, schedule_end, is_deleted FROM schedule";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int scheduleId = rs.getInt("schedule_id");
                int roomId = rs.getInt("room_id");
                int movieId = rs.getInt("movie_id");

                // Lấy giá trị ngày từ cơ sở dữ liệu và chuyển sang LocalDate
                LocalDate scheduleDate = rs.getDate("schedule_date").toLocalDate();

                // Lấy giá trị giờ từ cơ sở dữ liệu và chuyển sang Time
                Time scheduleStart = rs.getTime("schedule_start");
                Time scheduleEnd = rs.getTime("schedule_end");

                // Lấy giá trị boolean
                boolean isDeleted = rs.getBoolean("is_deleted");

                // Thêm đối tượng Schedule vào danh sách
                schedules.add(new Schedule(scheduleId, roomId, movieId, scheduleDate, scheduleStart, scheduleEnd, isDeleted));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
    public Schedule getScheduleById(int scheduleId) throws ClassNotFoundException {
        String query = "SELECT * FROM [schedule] WHERE [schedule_id] = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, scheduleId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int roomId = rs.getInt("room_id");
                int movieId = rs.getInt("movie_id");
                LocalDate scheduleDate = rs.getDate("schedule_date").toLocalDate();
                Time scheduleStart = rs.getTime("schedule_start");
                Time scheduleEnd = rs.getTime("schedule_end");
                boolean isDeleted = rs.getBoolean("is_deleted");

                return new Schedule(scheduleId, roomId, movieId, scheduleDate, scheduleStart, scheduleEnd, isDeleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Nếu không tìm thấy lịch trình nào
    }
    // Kiểm tra lịch chiếu có bị trùng hay không
//    public boolean checkOverlap(int roomId, LocalDate date, LocalTime startTime, LocalTime endTime) throws SQLException, ClassNotFoundException {
//        String query = "SELECT COUNT(*) FROM schedule WHERE room_id = ? AND schedule_date = ? " +
//                       "AND ((schedule_start BETWEEN ? AND ?) OR (schedule_end BETWEEN ? AND ?) OR (? BETWEEN schedule_start AND schedule_end)) " +
//                       "AND is_deleted = 0"; // Cần kiểm tra không phải là lịch đã xóa
//
//        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, roomId);
//            stmt.setDate(2, Date.valueOf(date));
//            stmt.setTime(3, Time.valueOf(startTime));
//            stmt.setTime(4, Time.valueOf(endTime));
//            stmt.setTime(5, Time.valueOf(startTime));
//            stmt.setTime(6, Time.valueOf(endTime));
//            stmt.setTime(7, Time.valueOf(startTime));
//
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0; // Trả về true nếu có sự trùng lặp
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    public boolean checkOverlap(int roomId, LocalDate date, LocalTime startTime, LocalTime endTime) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM schedule WHERE room_id = ? AND schedule_date = ? " +
                       "AND ((schedule_start < ? AND schedule_end > ?) " +
                       "     OR (schedule_start BETWEEN ? AND ?) " +
                       "     OR (schedule_end BETWEEN ? AND ?) " +
                       "     OR (? BETWEEN schedule_start AND schedule_end)) " +
                       "AND is_deleted = 0"; // Cần kiểm tra không phải là lịch đã xóa

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, roomId);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setTime(3, Time.valueOf(startTime));
            stmt.setTime(4, Time.valueOf(endTime));
            stmt.setTime(5, Time.valueOf(startTime));
            stmt.setTime(6, Time.valueOf(endTime));
            stmt.setTime(7, Time.valueOf(startTime));
            stmt.setTime(8, Time.valueOf(endTime));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu có sự trùng lặp
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addSchedule(int roomId, int movieId, LocalDate date, LocalTime startTime, LocalTime endTime) throws SQLException, ClassNotFoundException {
        if (checkOverlap(roomId, date, startTime, endTime)) {
            return false; // Trả về false nếu có sự trùng lặp
        }

        String query = "INSERT INTO schedule (room_id, movie_id, schedule_date, schedule_start, schedule_end) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, roomId);
            stmt.setInt(2, movieId);
            stmt.setDate(3, Date.valueOf(date));
            stmt.setTime(4, Time.valueOf(startTime));
            stmt.setTime(5, Time.valueOf(endTime));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu thêm thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateSchedule(int scheduleId, int roomId, int movieId, LocalDate date, LocalTime startTime, LocalTime endTime) throws ClassNotFoundException {
        String query = "UPDATE schedule SET room_id = ?, movie_id = ?, schedule_date = ?, schedule_start = ?, schedule_end = ? " +
                       "WHERE schedule_id = ? AND is_deleted = 0";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, roomId);
            stmt.setInt(2, movieId);
            stmt.setDate(3, Date.valueOf(date));
            stmt.setTime(4, Time.valueOf(startTime));
            stmt.setTime(5, Time.valueOf(endTime));
            stmt.setInt(6, scheduleId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean softDeleteSchedule(int scheduleId) throws ClassNotFoundException {
        String query = "UPDATE schedule SET is_deleted = 1 WHERE schedule_id = ?";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, scheduleId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteScheduleForever(int scheduleId) throws ClassNotFoundException {
        // Truy vấn SQL để xóa vĩnh viễn lịch
        String query = "DELETE FROM schedule WHERE schedule_id = ? AND is_deleted = 1";  // Xóa lịch đã xóa mềm

        try (Connection connection = getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Thiết lập giá trị cho tham số
            stmt.setInt(1, scheduleId);

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

   public boolean scheduleRestore(int scheduleId) throws ClassNotFoundException {
        String query = "UPDATE schedule SET is_deleted = 0 WHERE schedule_id = ? AND is_deleted = 1";

        try (Connection connection = getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, scheduleId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        // Trả về false nếu không có dòng nào bị ảnh hưởng (không tìm thấy lịch hoặc đã bị xóa vĩnh viễn)
        return false;
    }

}
