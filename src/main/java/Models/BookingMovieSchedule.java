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
import java.time.LocalDate;
import java.sql.Time;

public class BookingMovieSchedule {
    // Booking
    private int bookingId;
    private int userId;
    private int scheduleId;
    private LocalDate bookingDate;
    private double amount;
    private String payMethod;
    private boolean bookingIsDelete;

    // Movie
    private int movieId;
    private String movieName;
    private String movieDescription;
    private String movieTrailer;
    private int movieCens;
    private String movieGenres;
    private LocalDate movieRelease;
    private int movieLength;
    private String moviePoster;
    private Boolean movieIsDeleted;

    // Schedule
    private int roomId;
    private LocalDate scheduleDate;
    private Time scheduleStart;
    private Time scheduleEnd;
    private boolean isDeleted;

    // Getters and Setters

    // Booking
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public boolean isBookingIsDelete() {
        return bookingIsDelete;
    }

    public void setBookingIsDelete(boolean bookingIsDelete) {
        this.bookingIsDelete = bookingIsDelete;
    }

    // Movie
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public int getMovieCens() {
        return movieCens;
    }

    public void setMovieCens(int movieCens) {
        this.movieCens = movieCens;
    }

    public String getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(String movieGenres) {
        this.movieGenres = movieGenres;
    }

    public LocalDate getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(LocalDate movieRelease) {
        this.movieRelease = movieRelease;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public Boolean getMovieIsDeleted() {
        return movieIsDeleted;
    }

    public void setMovieIsDeleted(Boolean movieIsDeleted) {
        this.movieIsDeleted = movieIsDeleted;
    }

    // Schedule
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Time getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(Time scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public Time getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleEnd(Time scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}

