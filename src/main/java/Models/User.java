/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author LENOVO
 */
import java.security.MessageDigest;
import java.time.LocalDate;
public class User {
    private int userId;
    private String username;
    private String password;
    private String avatar;
    private String fullname;
    private LocalDate birthday;
    private int gender;
    private String email;
    private String city;
    private String phone;
    private int point;
    private String role;
    private Boolean isDeleted;

    // Constructors
    public User() {
    }

    public User(int userId, String username, String password, String avatar, String fullname, LocalDate birthday, 
                int gender, String email, String city, String phone, int point, String role, Boolean isDeleted) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.phone = phone;
        this.point = point;
        this.role = role;
        this.isDeleted = isDeleted;
    }
    public User(String username, String password, String fullname, LocalDate birthday, int gender, String email, String city, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.phone = phone;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.equals("Customer") || role.equals("Staff") || role.equals("Manager") || role.equals("Admin")) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Invalid role. Accepted values are 'Customer', 'Staff', 'Manager', 'Admin'.");
        }
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    public static String hashPassword(String password) {
        try {
            // Tạo instance của SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Băm mật khẩu và chuyển thành mảng byte
            byte[] hash = digest.digest(password.getBytes("UTF-8"));

            // Chuyển đổi mảng byte thành chuỗi hexa
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b); // Lấy giá trị hexa
                if (hex.length() == 1) hexString.append('0'); // Đảm bảo có 2 ký tự hexa
                    hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error while hashing password", ex);
        }
    }
}
