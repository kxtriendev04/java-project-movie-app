/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Cinema;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CinemaDAO extends DatabaseConnection{
    public List<Cinema> getAllCinema() throws ClassNotFoundException, SQLException {
        List<Cinema> cinemas = new ArrayList<>();
        String sql = "SELECT cinema_id, cinema_name, cinema_address, is_deleted FROM cinemas";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
           int id = rs.getInt("cinema_id");
           String name = rs.getString("cinema_name");
           String address = rs.getString("cinema_address");
           boolean isDeleted = rs.getBoolean("is_deleted");
           cinemas.add(new Cinema(id, name, address, isDeleted));
        }  
        closeConnection();
        return cinemas; 
    }
    public boolean addCinema( String name, String address) throws ClassNotFoundException, SQLException {
       String sql = "INSERT INTO cinemas (cinema_name, cinema_address, is_deleted) VALUES (?, ?, 0)";
       Connection conn = getConnection();
       PreparedStatement pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, name);
       pstmt.setString(2, address);
       int rowsInserted = pstmt.executeUpdate();
       closeConnection();
       return rowsInserted > 0;
    }
    public boolean updateCinemaById(int id, String name, String address) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE cinemas SET cinema_name = ?, cinema_address = ? WHERE cinema_id = ? AND is_deleted = 0";
        
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setString(2, address);
        pstmt.setInt(3, id);
        int rowsUpdated = pstmt.executeUpdate();
        closeConnection();
        return rowsUpdated > 0;
    }
    public boolean softDelectById(int id) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE cinemas SET is_deleted = 1 WHERE cinema_id = ?";
        
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);
        int rowsUpdated = pstmt.executeUpdate();
        closeConnection();
        return rowsUpdated > 0;
    }
}
