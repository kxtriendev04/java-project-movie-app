/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nguye
 */
public class Booking {
    private int bookingId;
    private int userId;
    private int scheduleId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private double amount;
    private String payMethod;
    private boolean isDelete;

    public Booking() {
    }

    public Booking(int bookingId, int userId, int scheduleId, LocalDate bookingDate, LocalTime bookingTime, double amount, String payMethod, boolean isDelete) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.amount = amount;
        this.payMethod = payMethod;
        this.isDelete = isDelete;
    }

    public Booking(int userId, int scheduleId, LocalDate bookingDate, LocalTime bookingTime, double amount, String payMethod, boolean isDelete) {
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.amount = amount;
        this.payMethod = payMethod;
        this.isDelete = isDelete;
    }
    
    

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    
    
}
