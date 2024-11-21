/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author LENOVO
 */
public class Room {
    private int roomId;      
    private String roomName; 
    private String roomType; 
    private boolean isDeleted; 

    // Constructor không tham số
    public Room() {}

    // Constructor với các tham số
    public Room(int roomId, String roomName, String roomType, boolean isDeleted) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.isDeleted = isDeleted;
    }

    // Getter and Setter methods
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
