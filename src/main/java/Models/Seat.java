/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Seat {

    private int seatId;
    private String seatType;
    private int roomId;
    private int scheduleId;
    private String row;
    private Integer number;
    private int seatStatus;
    private boolean isDeleted;

    // Constructor
    public Seat(int seatId, String seatType, int roomId, int scheduleId, String row, Integer number, int seatStatus, boolean isDeleted) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.roomId = roomId;
        this.scheduleId = scheduleId;
        this.row = row;
        this.number = number;
        this.seatStatus = seatStatus;
        this.isDeleted = isDeleted;
    }
    // Constructor
    public Seat(String seatType, int roomId, int scheduleId, Integer number, int seatStatus, boolean isDeleted) {
        this.seatType = seatType;
        this.roomId = roomId;
        this.scheduleId = scheduleId;
        this.number = number;
        this.seatStatus = seatStatus;
        this.isDeleted = isDeleted;
    }
    
    public Seat(int seatId, String seatType, int number) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.number = number;
    }

    // Getters and Setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(int seatStatus) {
        this.seatStatus = seatStatus;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    // Optional: Override toString() method for better readability
    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatType='" + seatType + '\'' +
                ", roomId=" + roomId +
                ", scheduleId=" + scheduleId +
                ", row='" + row + '\'' +
                ", number=" + number +
                ", seatStatus=" + seatStatus +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
