package Controller;

import Models.Seat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO extends DatabaseConnection {

    // Phương thức lấy tất cả các ghế
    public List<Seat> getAllSeat() throws ClassNotFoundException {
        List<Seat> seatList = new ArrayList<>();
        String query = "SELECT * FROM seats WHERE is_deleted = 0"; // Lọc theo điều kiện không bị xóa

        try (Connection conn = getConnection(); // Lấy kết nối từ DatabaseConnection
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Duyệt qua kết quả và ánh xạ thành các đối tượng Seat
            while (rs.next()) {
                int seatId = rs.getInt("seat_id");
                String seatType = rs.getString("seat_type");
                int roomId = rs.getInt("room_id");
                int scheduleId = rs.getInt("schedule_id");
                String row = rs.getString("row");
                Integer number = rs.getInt("number");
                int seatStatus = rs.getInt("seat_status");
                boolean isDeleted = rs.getBoolean("is_deleted");

                Seat seat = new Seat(seatId, seatType, roomId, scheduleId, row, number, seatStatus, isDeleted);
                seatList.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }
    public List<Seat> getAllSeatByScheduleId(int id) throws ClassNotFoundException {
        List<Seat> seatList = new ArrayList<>();
        String query = "SELECT * FROM seats WHERE schedule_id = ? AND is_deleted = 0"; // Lọc theo schedule_id và không bị xóa

        try (Connection conn = getConnection(); // Lấy kết nối từ DatabaseConnection
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Gán giá trị cho parameter (schedule_id)
            pstmt.setInt(1, id);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = pstmt.executeQuery()) {
                // Duyệt qua kết quả và ánh xạ thành các đối tượng Seat
                while (rs.next()) {
                    int seatId = rs.getInt("seat_id");
                    String seatType = rs.getString("seat_type");
                    int roomId = rs.getInt("room_id");
                    int scheduleId = rs.getInt("schedule_id");
                    String row = rs.getString("row");
                    Integer number = rs.getInt("number");
                    int seatStatus = rs.getInt("seat_status");
                    boolean isDeleted = rs.getBoolean("is_deleted");

                    Seat seat = new Seat(seatId, seatType, roomId, scheduleId, row, number, seatStatus, isDeleted);
                    seatList.add(seat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }
    public int addSeat(Seat seat) {
        String query = "INSERT INTO seats (seat_type, room_id, schedule_id, number, seat_status, is_deleted) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); // Kết nối đến cơ sở dữ liệu
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Gán giá trị cho các tham số trong câu lệnh SQL
            pstmt.setString(1, seat.getSeatType());
            pstmt.setInt(2, seat.getRoomId());
            pstmt.setInt(3, seat.getScheduleId());
            pstmt.setInt(4, seat.getNumber());
            pstmt.setInt(5, seat.getSeatStatus());
            pstmt.setBoolean(6, seat.isDeleted());

            // Thực thi câu lệnh SQL
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Lấy khóa chính được tạo tự động
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Trả về seat_id
                    }
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Ghi log lỗi nếu có
        }

        return -1; // Trả về -1 nếu có lỗi xảy ra hoặc không lấy được seat_id
    }

    public int[] getSeatNumbersByScheduleId(int scheduleId) throws ClassNotFoundException {
    List<Integer> seatNumbers = new ArrayList<>();
    String query = "SELECT number FROM seats WHERE schedule_id = ? AND is_deleted = 0"; // Lọc theo schedule_id và is_deleted = 0

    try (Connection conn = getConnection(); // Lấy kết nối từ DatabaseConnection
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        // Gán giá trị cho tham số scheduleId trong truy vấn
        pstmt.setInt(1, scheduleId);

        // Thực thi truy vấn và nhận kết quả
        try (ResultSet rs = pstmt.executeQuery()) {
            // Duyệt qua các kết quả và thêm vào danh sách seatNumbers
            while (rs.next()) {
                Integer number = (Integer) rs.getObject("number"); // Xử lý NULL
                if (number != null) { // Bỏ qua giá trị NULL
                    System.out.println("Number: " + number); // Debug: In giá trị lấy được
                    seatNumbers.add(number);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Debug: In lỗi truy vấn
    }

    // Chuyển danh sách thành mảng int[]
    return seatNumbers.stream().mapToInt(Integer::intValue).toArray();
}

    public boolean isSeatNumberExist(int scheduleId, int seatNumber) throws ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM seats WHERE schedule_id = ? AND number = ? AND is_deleted = 0"; // Điều kiện lọc theo schedule_id, number và is_deleted = 0
        boolean exists = false;

        try (Connection conn = getConnection(); // Lấy kết nối từ DatabaseConnection
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Gán giá trị cho các tham số trong truy vấn
            pstmt.setInt(1, scheduleId);
            pstmt.setInt(2, seatNumber);

            // Thực thi truy vấn và nhận kết quả
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Nếu COUNT(*) > 0, tức là số ghế đã tồn tại
                    exists = rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }


    // Phương thức cập nhật thông tin ghế
    public boolean updateSeat(Seat seat) throws ClassNotFoundException {
        String query = "UPDATE seats SET seat_type = ?, room_id = ?, schedule_id = ?, row = ?, " +
                       "number = ?, seat_status = ?, is_deleted = ? WHERE seat_id = ?";

        try (Connection conn = getConnection(); // Lấy kết nối từ DatabaseConnection
             PreparedStatement psmt = conn.prepareStatement(query)) {

            // Thiết lập các tham số cho câu lệnh PreparedStatement
            psmt.setString(1, seat.getSeatType());
            psmt.setInt(2, seat.getRoomId());
            psmt.setInt(3, seat.getScheduleId());
            psmt.setString(4, seat.getRow());
            psmt.setInt(5, seat.getNumber());
            psmt.setInt(6, seat.getSeatStatus());
            psmt.setBoolean(7, seat.isDeleted());
            psmt.setInt(8, seat.getSeatId());

            // Thực thi câu lệnh cập nhật
            int rowsUpdated = psmt.executeUpdate();
            return rowsUpdated > 0; // Trả về true nếu có bản ghi nào bị cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Seat> getSeatsByBookingId(int bookingId) throws SQLException, ClassNotFoundException {
        List<Seat> seats = new ArrayList<>();
        String query = """
            SELECT s.seat_id, s.seat_type, s.number, s.seat_status
            FROM booking_details bd
            JOIN seats s ON bd.seat_id = s.seat_id
            WHERE bd.booking_id = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookingId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    seats.add(new Seat(
                            rs.getInt("seat_id"),
                            rs.getString("seat_type"),
                            rs.getInt("number")
                    ));
                }
            }
        }
        return seats;
    }
}

