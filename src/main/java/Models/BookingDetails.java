/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class BookingDetails {
    private int bookingDetailId;
    private int bookingId;
    private int seatId;
    private double price;

    public BookingDetails() {
    }

    public BookingDetails(int bookingDetailId, int bookingId, int seatId, double price) {
        this.bookingDetailId = bookingDetailId;
        this.bookingId = bookingId;
        this.seatId = seatId;
        this.price = price;
    }
    public BookingDetails(int bookingId, int seatId, double price) {
        this.bookingId = bookingId;
        this.seatId = seatId;
        this.price = price;
    }

    public int getBookingDetailId() {
        return bookingDetailId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getSeatId() {
        return seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setBookingDetailId(int bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
