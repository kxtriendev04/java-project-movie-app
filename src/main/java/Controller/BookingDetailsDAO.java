/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Models.BookingDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDetailsDAO extends DatabaseConnection{
    public boolean addBookingDetail(BookingDetails bd) {
        String sql = "INSERT INTO booking_details (booking_id, seat_id, price) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) { // Không cần RETURN_GENERATED_KEYS

            // Gán các giá trị cho câu lệnh SQL
            ps.setInt(1, bd.getBookingId());
            ps.setInt(2, bd.getSeatId());
            ps.setDouble(3, bd.getPrice());

            // Thực hiện câu lệnh
            int affectedRows = ps.executeUpdate();

            // Kiểm tra nếu có dòng nào được chèn
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Trả về false nếu xảy ra lỗi
        return false;
    }
    
    public List<BookingDetails> getBookingDetailByBookingId(int bookingId) {
        List<BookingDetails> bookingDetailsList = new ArrayList<>();
        String sql = "SELECT * FROM booking_details WHERE booking_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, bookingId);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BookingDetails bd = new BookingDetails();
                    bd.setBookingDetailId(rs.getInt("booking_detail_id"));
                    bd.setBookingId(rs.getInt("booking_id"));
                    bd.setSeatId(rs.getInt("seat_id"));
                    bd.setPrice(rs.getDouble("price"));
                    bookingDetailsList.add(bd);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookingDetailsList;
    }
}

