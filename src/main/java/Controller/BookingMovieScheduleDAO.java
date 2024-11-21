/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author LENOVO
 */
import Models.Booking;
import Models.BookingMovieSchedule;
import Models.Movie;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingMovieScheduleDAO extends DatabaseConnection {

    public List<BookingMovieSchedule> getBookingWithMovies() throws SQLException, ClassNotFoundException {
        List<BookingMovieSchedule> bookingMovies = new ArrayList<>();

        // SQL query để lấy dữ liệu từ các bảng bookings, movies và schedule
        String query = """
            SELECT 
                b.booking_id, 
                b.user_id, 
                b.schedule_id, 
                b.booking_date, 
                b.amount, 
                b.payment_method, 
                b.is_deleted AS booking_is_deleted, 
                m.movie_id, 
                m.movie_name, 
                m.movie_description, 
                m.movie_trailer, 
                m.movie_cens, 
                m.movie_genres, 
                m.movie_release, 
                m.movie_length, 
                m.movie_poster, 
                m.is_deleted AS movie_is_deleted,
                s.room_id,
                s.schedule_date,
                s.schedule_start,
                s.schedule_end,
                s.is_deleted AS schedule_is_deleted
            FROM 
                bookings b
            JOIN 
                schedule s ON b.schedule_id = s.schedule_id
            JOIN 
                movies m ON s.movie_id = m.movie_id
            WHERE 
                b.is_deleted = 0 
                AND m.is_deleted = 0
                AND s.is_deleted = 0;
            """;

        // Kết nối cơ sở dữ liệu và thực thi câu truy vấn
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Duyệt qua từng dòng kết quả trong ResultSet
            while (rs.next()) {
                BookingMovieSchedule bookingMovieSchedule = new BookingMovieSchedule();

                // Set thông tin từ bảng bookings
                bookingMovieSchedule.setBookingId(rs.getInt("booking_id"));
                bookingMovieSchedule.setUserId(rs.getInt("user_id"));
                bookingMovieSchedule.setScheduleId(rs.getInt("schedule_id"));
                bookingMovieSchedule.setBookingDate(rs.getDate("booking_date").toLocalDate());
                bookingMovieSchedule.setAmount(rs.getDouble("amount"));
                bookingMovieSchedule.setPayMethod(rs.getString("payment_method"));
                bookingMovieSchedule.setBookingIsDelete(rs.getBoolean("booking_is_deleted"));

                // Set thông tin từ bảng movies
                bookingMovieSchedule.setMovieId(rs.getInt("movie_id"));
                bookingMovieSchedule.setMovieName(rs.getString("movie_name"));
                bookingMovieSchedule.setMovieDescription(rs.getString("movie_description"));
                bookingMovieSchedule.setMovieTrailer(rs.getString("movie_trailer"));
                bookingMovieSchedule.setMovieCens(rs.getInt("movie_cens"));
                bookingMovieSchedule.setMovieGenres(rs.getString("movie_genres"));
                bookingMovieSchedule.setMovieRelease(rs.getDate("movie_release").toLocalDate());
                bookingMovieSchedule.setMovieLength(rs.getInt("movie_length"));
                bookingMovieSchedule.setMoviePoster(rs.getString("movie_poster"));
                bookingMovieSchedule.setMovieIsDeleted(rs.getBoolean("movie_is_deleted"));

                // Set thông tin từ bảng schedule
                bookingMovieSchedule.setRoomId(rs.getInt("room_id"));
                bookingMovieSchedule.setScheduleDate(rs.getDate("schedule_date").toLocalDate());
                bookingMovieSchedule.setScheduleStart(rs.getTime("schedule_start"));
                bookingMovieSchedule.setScheduleEnd(rs.getTime("schedule_end"));
                bookingMovieSchedule.setDeleted(rs.getBoolean("schedule_is_deleted"));

                // Thêm đối tượng vào danh sách kết quả
                bookingMovies.add(bookingMovieSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        // Trả về danh sách các đối tượng BookingMovieSchedule
        return bookingMovies;
    }
}
