/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author LENOVO
 */
public class Schedule {
    private int scheduleId;
    private int roomId;
    private int movieId;
    private LocalDate scheduleDate;
    private Time scheduleStart;
    private Time scheduleEnd;
    private boolean isDeleted;

    // Constructor
    public Schedule(int scheduleId, int roomId, int movieId, LocalDate scheduleDate, 
                    Time scheduleStart, Time scheduleEnd, boolean isDeleted) {
        this.scheduleId = scheduleId;
        this.roomId = roomId;
        this.movieId = movieId;
        this.scheduleDate = scheduleDate;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
        this.isDeleted = isDeleted;
    }

    // Getters and Setters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
