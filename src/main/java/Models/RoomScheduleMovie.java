/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class RoomScheduleMovie {
    private int roomId;      
    private String roomName; 
    private String roomType; 
    private boolean isRoomDeleted;
    
    private int scheduleId;
    private int movieId;
    private LocalDate scheduleDate;
    private Time scheduleStart;
    private Time scheduleEnd;
    private boolean isScheduleDeleted;
    
    private String movieName;
    private String movieDescription;
    private String movieTrailer;
    private int movieCens;
    private String movieGenres;
    private LocalDate movieRelease;
    private int movieLength;
    private String moviePoster;
    private Boolean isMovieDeleted;

    public RoomScheduleMovie(int roomId, String roomName, String roomType, boolean isRoomDeleted, int scheduleId, int movieId, LocalDate scheduleDate, Time scheduleStart, Time scheduleEnd, boolean isScheduleDeleted, String movieName, String movieDescription, String movieTrailer, int movieCens, String movieGenres, LocalDate movieRelease, int movieLength, String moviePoster, Boolean isMovieDeleted) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.isRoomDeleted = isRoomDeleted;
        this.scheduleId = scheduleId;
        this.movieId = movieId;
        this.scheduleDate = scheduleDate;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
        this.isScheduleDeleted = isScheduleDeleted;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieTrailer = movieTrailer;
        this.movieCens = movieCens;
        this.movieGenres = movieGenres;
        this.movieRelease = movieRelease;
        this.movieLength = movieLength;
        this.moviePoster = moviePoster;
        this.isMovieDeleted = isMovieDeleted;
    }

    public RoomScheduleMovie() {
    }
    

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setIsRoomDeleted(boolean isRoomDeleted) {
        this.isRoomDeleted = isRoomDeleted;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public void setScheduleStart(Time scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public void setScheduleEnd(Time scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    public void setIsScheduleDeleted(boolean isScheduleDeleted) {
        this.isScheduleDeleted = isScheduleDeleted;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public void setMovieCens(int movieCens) {
        this.movieCens = movieCens;
    }

    public void setMovieGenres(String movieGenres) {
        this.movieGenres = movieGenres;
    }

    public void setMovieRelease(LocalDate movieRelease) {
        this.movieRelease = movieRelease;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public void setIsMovieDeleted(Boolean isMovieDeleted) {
        this.isMovieDeleted = isMovieDeleted;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isIsRoomDeleted() {
        return isRoomDeleted;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getMovieId() {
        return movieId;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public Time getScheduleStart() {
        return scheduleStart;
    }

    public Time getScheduleEnd() {
        return scheduleEnd;
    }

    public boolean isIsScheduleDeleted() {
        return isScheduleDeleted;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public int getMovieCens() {
        return movieCens;
    }

    public String getMovieGenres() {
        return movieGenres;
    }

    public LocalDate getMovieRelease() {
        return movieRelease;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public Boolean getIsMovieDeleted() {
        return isMovieDeleted;
    }
    
    
}
