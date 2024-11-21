package Controller;

import Models.RoomScheduleMovie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomScheduleMovieDAO extends DatabaseConnection {

    // Method to get a RoomScheduleMovie object by scheduleId
    public RoomScheduleMovie getRoomScheduleMovieByScheduleId(int scheduleId) throws ClassNotFoundException {
        // Initialize the RoomScheduleMovie object
        RoomScheduleMovie roomScheduleMovie = null;

        // SQL query to join the rooms, movies, and schedule tables based on schedule_id
        String sql = "SELECT r.room_id, r.room_name, r.room_type, r.is_deleted AS room_is_deleted, " +
                     "s.schedule_id, s.schedule_date, s.schedule_start, s.schedule_end, s.is_deleted AS schedule_is_deleted, " +
                     "m.movie_id, m.movie_name, m.movie_description, m.movie_trailer, m.movie_cens, m.movie_genres, " +
                     "m.movie_release, m.movie_length, m.movie_poster, m.is_deleted AS movie_is_deleted " +
                     "FROM schedule s " +
                     "JOIN rooms r ON s.room_id = r.room_id " +
                     "JOIN movies m ON s.movie_id = m.movie_id " +
                     "WHERE s.schedule_id = ? AND s.is_deleted = 0 AND m.is_deleted = 0 AND r.is_deleted = 0";

        // Establishing connection and executing the query
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the scheduleId parameter
            stmt.setInt(1, scheduleId);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // If a result is found, map it to a RoomScheduleMovie object
            if (rs.next()) {
                roomScheduleMovie = new RoomScheduleMovie();

                // Map room data
                roomScheduleMovie.setRoomId(rs.getInt("room_id"));
                roomScheduleMovie.setRoomName(rs.getString("room_name"));
                roomScheduleMovie.setRoomType(rs.getString("room_type"));
                roomScheduleMovie.setIsRoomDeleted(rs.getBoolean("room_is_deleted"));

                // Map schedule data
                roomScheduleMovie.setScheduleId(rs.getInt("schedule_id"));
                roomScheduleMovie.setScheduleDate(rs.getDate("schedule_date").toLocalDate());
                roomScheduleMovie.setScheduleStart(rs.getTime("schedule_start"));
                roomScheduleMovie.setScheduleEnd(rs.getTime("schedule_end"));
                roomScheduleMovie.setIsScheduleDeleted(rs.getBoolean("schedule_is_deleted"));

                // Map movie data
                roomScheduleMovie.setMovieId(rs.getInt("movie_id"));
                roomScheduleMovie.setMovieName(rs.getString("movie_name"));
                roomScheduleMovie.setMovieDescription(rs.getString("movie_description"));
                roomScheduleMovie.setMovieTrailer(rs.getString("movie_trailer"));
                roomScheduleMovie.setMovieCens(rs.getInt("movie_cens"));
                roomScheduleMovie.setMovieGenres(rs.getString("movie_genres"));
                roomScheduleMovie.setMovieRelease(rs.getDate("movie_release").toLocalDate());
                roomScheduleMovie.setMovieLength(rs.getInt("movie_length"));
                roomScheduleMovie.setMoviePoster(rs.getString("movie_poster"));
                roomScheduleMovie.setIsMovieDeleted(rs.getBoolean("movie_is_deleted"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomScheduleMovie;
    }
}
