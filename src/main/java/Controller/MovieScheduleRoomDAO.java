package Controller;


import Models.MovieScheduleRoom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieScheduleRoomDAO extends DatabaseConnection {

    public List<MovieScheduleRoom> getAllMovieScheduleRoom() throws ClassNotFoundException {
        List<MovieScheduleRoom> movieScheduleRooms = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = getConnection();

            // Truy vấn SQL để lấy tất cả thông tin lịch chiếu, phòng chiếu và phim
            String query = "SELECT m.movie_id, m.movie_name, m.movie_description, m.movie_trailer, m.movie_cens, " +
                           "m.movie_genres, m.movie_release, m.movie_length, m.movie_poster, m.is_deleted AS is_movie_deleted, " +
                           "s.schedule_id, s.room_id, s.schedule_date, s.schedule_start, s.schedule_end, s.is_deleted AS is_schedule_deleted, " +
                           "r.room_name, r.room_type, r.is_deleted AS is_room_deleted " +
                           "FROM movies m " +
                           "JOIN schedule s ON m.movie_id = s.movie_id " +
                           "JOIN rooms r ON s.room_id = r.room_id " +
                           "WHERE m.is_deleted = 0 AND s.is_deleted = 0 AND r.is_deleted = 0";

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Duyệt qua kết quả và tạo đối tượng MovieScheduleRoom
            while (rs.next()) {
                MovieScheduleRoom movieScheduleRoom = new MovieScheduleRoom();
                
                // Lấy thông tin phim
                movieScheduleRoom.setMovieId(rs.getInt("movie_id"));
                movieScheduleRoom.setMovieName(rs.getString("movie_name"));
                movieScheduleRoom.setMovieDescription(rs.getString("movie_description"));
                movieScheduleRoom.setMovieTrailer(rs.getString("movie_trailer"));
                movieScheduleRoom.setMovieCens(rs.getInt("movie_cens"));
                movieScheduleRoom.setMovieGenres(rs.getString("movie_genres"));
                movieScheduleRoom.setMovieRelease(rs.getDate("movie_release").toLocalDate());
                movieScheduleRoom.setMovieLength(rs.getInt("movie_length"));
                movieScheduleRoom.setMoviePoster(rs.getString("movie_poster"));
                movieScheduleRoom.setIsMovieDeleted(rs.getBoolean("is_movie_deleted"));
                
                // Lấy thông tin lịch chiếu
                movieScheduleRoom.setScheduleId(rs.getInt("schedule_id"));
                movieScheduleRoom.setRoomId(rs.getInt("room_id"));
                movieScheduleRoom.setScheduleDate(rs.getDate("schedule_date").toLocalDate());
                movieScheduleRoom.setScheduleStart(rs.getTime("schedule_start"));
                movieScheduleRoom.setScheduleEnd(rs.getTime("schedule_end"));
                movieScheduleRoom.setIsScheduleDeleted(rs.getBoolean("is_schedule_deleted"));

                // Lấy thông tin phòng chiếu
                movieScheduleRoom.setRoomName(rs.getString("room_name"));
                movieScheduleRoom.setRoomType(rs.getString("room_type"));
                movieScheduleRoom.setIsRoomDeleted(rs.getBoolean("is_room_deleted"));

                // Thêm vào danh sách
                movieScheduleRooms.add(movieScheduleRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các đối tượng liên quan
            closeConnection(conn, stmt, rs);
        }

        return movieScheduleRooms;
    }

    // Phương thức đóng kết nối
    private void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<MovieScheduleRoom> getAllMovieScheduleRoomByMovieId(int movieId) throws ClassNotFoundException {
        List<MovieScheduleRoom> movieScheduleRooms = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = getConnection();

            // Truy vấn SQL để lấy lịch chiếu và phòng chiếu theo movie_id
            String query = "SELECT m.movie_id, m.movie_name, m.movie_description, m.movie_trailer, m.movie_cens, " +
                           "m.movie_genres, m.movie_release, m.movie_length, m.movie_poster, m.is_deleted AS is_movie_deleted, " +
                           "s.schedule_id, s.room_id, s.schedule_date, s.schedule_start, s.schedule_end, s.is_deleted AS is_schedule_deleted, " +
                           "r.room_name, r.room_type, r.is_deleted AS is_room_deleted " +
                           "FROM movies m " +
                           "JOIN schedule s ON m.movie_id = s.movie_id " +
                           "JOIN rooms r ON s.room_id = r.room_id " +
                           "WHERE m.movie_id = ? AND m.is_deleted = 0 AND s.is_deleted = 0 AND r.is_deleted = 0";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, movieId); // Gán giá trị movie_id từ tham số
            rs = stmt.executeQuery();

            // Duyệt qua kết quả và tạo đối tượng MovieScheduleRoom
            while (rs.next()) {
                MovieScheduleRoom movieScheduleRoom = new MovieScheduleRoom();

                // Lấy thông tin phim
                movieScheduleRoom.setMovieId(rs.getInt("movie_id"));
                movieScheduleRoom.setMovieName(rs.getString("movie_name"));
                movieScheduleRoom.setMovieDescription(rs.getString("movie_description"));
                movieScheduleRoom.setMovieTrailer(rs.getString("movie_trailer"));
                movieScheduleRoom.setMovieCens(rs.getInt("movie_cens"));
                movieScheduleRoom.setMovieGenres(rs.getString("movie_genres"));
                movieScheduleRoom.setMovieRelease(rs.getDate("movie_release").toLocalDate());
                movieScheduleRoom.setMovieLength(rs.getInt("movie_length"));
                movieScheduleRoom.setMoviePoster(rs.getString("movie_poster"));
                movieScheduleRoom.setIsMovieDeleted(rs.getBoolean("is_movie_deleted"));

                // Lấy thông tin lịch chiếu
                movieScheduleRoom.setScheduleId(rs.getInt("schedule_id"));
                movieScheduleRoom.setRoomId(rs.getInt("room_id"));
                movieScheduleRoom.setScheduleDate(rs.getDate("schedule_date").toLocalDate());
                movieScheduleRoom.setScheduleStart(rs.getTime("schedule_start"));
                movieScheduleRoom.setScheduleEnd(rs.getTime("schedule_end"));
                movieScheduleRoom.setIsScheduleDeleted(rs.getBoolean("is_schedule_deleted"));

                // Lấy thông tin phòng chiếu
                movieScheduleRoom.setRoomName(rs.getString("room_name"));
                movieScheduleRoom.setRoomType(rs.getString("room_type"));
                movieScheduleRoom.setIsRoomDeleted(rs.getBoolean("is_room_deleted"));

                // Thêm vào danh sách
                movieScheduleRooms.add(movieScheduleRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các đối tượng liên quan
            closeConnection(conn, stmt, rs);
        }

        return movieScheduleRooms;
    }

}



