/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends DatabaseConnection {

    // Lấy tất cả bookings
    public List<Booking> getAllBookings() throws SQLException, ClassNotFoundException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE is_deleted = 0";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setScheduleId(rs.getInt("schedule_id"));
                booking.setBookingDate(rs.getDate("booking_date").toLocalDate());
                booking.setBookingTime(rs.getTime("booking_time").toLocalTime());
                booking.setAmount(rs.getDouble("amount"));
                booking.setPayMethod(rs.getString("payment_method"));
                booking.setIsDelete(rs.getBoolean("is_deleted"));

                bookings.add(booking);
            }
        }

        return bookings;
    }

    // Cập nhật một booking
    public boolean updateBooking(Booking booking) {
        String query = "UPDATE bookings SET user_id = ?, schedule_id = ?, booking_date = ?, booking_time = ?, amount = ?, payment_method = ?, is_deleted = ? WHERE booking_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getScheduleId());
            ps.setDate(3, java.sql.Date.valueOf(booking.getBookingDate()));
            ps.setTime(4, java.sql.Time.valueOf(booking.getBookingTime()));
            ps.setDouble(5, booking.getAmount());
            ps.setString(6, booking.getPayMethod());
            ps.setBoolean(7, booking.isIsDelete());
            ps.setInt(8, booking.getBookingId());

            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Thêm một booking mới
//    public boolean addBooking(Booking booking) {
//        String query = "INSERT INTO bookings (user_id, schedule_id, booking_date, booking_time, amount, payment_method, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection conn = getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//
//            ps.setInt(1, booking.getUserId());
//            ps.setInt(2, booking.getScheduleId());
//            ps.setDate(3, java.sql.Date.valueOf(booking.getBookingDate()));
//            ps.setTime(4, java.sql.Time.valueOf(booking.getBookingTime()));
//            ps.setDouble(5, booking.getAmount());
//            ps.setString(6, booking.getPayMethod());
//            ps.setBoolean(7, booking.isIsDelete());
//
//            return ps.executeUpdate() > 0;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public Integer addBooking(Booking booking) {
        String query = "INSERT INTO bookings (user_id, schedule_id, booking_date, booking_time, amount, payment_method, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Gán các giá trị cho câu lệnh SQL
            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getScheduleId());
            ps.setDate(3, java.sql.Date.valueOf(booking.getBookingDate()));
            ps.setTime(4, java.sql.Time.valueOf(booking.getBookingTime()));
            ps.setDouble(5, booking.getAmount());
            ps.setString(6, booking.getPayMethod());
            ps.setBoolean(7, booking.isIsDelete());

            // Thực hiện câu lệnh
            int affectedRows = ps.executeUpdate();

            // Kiểm tra nếu có dòng nào được chèn
            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        // Lấy giá trị booking_id
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Trả về null nếu không thành công
        return null;
    }

    public Booking getBookingByUserIdAndScheduleId(int userId, int scheduleId) {
        String query = "SELECT * FROM bookings WHERE user_id = ? AND schedule_id = ? AND is_deleted = 0";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, userId);
            ps.setInt(2, scheduleId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Booking booking = new Booking();
                    booking.setBookingId(rs.getInt("booking_id"));
                    booking.setUserId(rs.getInt("user_id"));
                    booking.setScheduleId(rs.getInt("schedule_id"));
                    booking.setBookingDate(rs.getDate("booking_date").toLocalDate());
                    booking.setBookingTime(rs.getTime("booking_time").toLocalTime());
                    booking.setAmount(rs.getDouble("amount"));
                    booking.setPayMethod(rs.getString("payment_method"));
                    booking.setIsDelete(rs.getBoolean("is_deleted"));

                    return booking;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null; // Không tìm thấy booking
    }
}

