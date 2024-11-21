/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.sql.Time;

import java.time.LocalDate;


public class MovieScheduleRoom {
    private int movieId;
    private String movieName;
    private String movieDescription;
    private String movieTrailer;
    private int movieCens;
    private String movieGenres;
    private LocalDate movieRelease;
    private int movieLength;
    private String moviePoster;
    private Boolean isMovieDeleted;
    
    private int scheduleId;
    private int roomId;
    private LocalDate scheduleDate;
    private Time scheduleStart;
    private Time scheduleEnd;
    private boolean isScheduleDeleted;
         // ID phòng chiếu
    private String roomName; // Tên phòng chiếu
    private String roomType; // Loại phòng (ví dụ: 2D, 3D, VIP)
    private boolean isRoomDeleted; // Trạng thái xóa mềm (0 hoặc 1)

    

    public MovieScheduleRoom() {
    }

    
    public int getMovieId() {
        return movieId;
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

    public int getScheduleId() {
        return scheduleId;
    }

    public int getRoomId() {
        return roomId;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isIsRoomDeleted() {
        return isRoomDeleted;
    }

    public void setIsRoomDeleted(boolean isRoomDeleted) {
        this.isRoomDeleted = isRoomDeleted;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
  
    
    
}

