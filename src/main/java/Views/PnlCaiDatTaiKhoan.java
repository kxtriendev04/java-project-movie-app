/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.UserDAO;
import Models.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author nguye
 */
public class PnlCaiDatTaiKhoan extends javax.swing.JPanel {
    private User currentUser;
    /**
     * Creates new form PnlAdCaiDat
     */
    public PnlCaiDatTaiKhoan(User user) {
        initComponents();
        currentUser = user;
        ButtonGroup group = new ButtonGroup();
        group.add(radNam);
        group.add(radNu);
        lblErrorTK.setText("");
        lblErrorMK.setText("");
        lblErrorNLMK.setText("");
        lblErrorEmail.setText("");
        lblErrorSDT.setText("");
        lblErrorNS.setText("");
        lblErrorGT.setText("");
        lblErrorHT.setText("");
        lblErrorDC.setText("");
        txtTenTaiKhoan.setText(currentUser.getUsername());
        txtHoTen.setText(currentUser.getFullname());
        java.time.LocalDate birthday = currentUser.getBirthday();
    
        // Lấy ngày, tháng, năm từ LocalDate
        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();
        int year = birthday.getYear();

        // Hiển thị lên các JTextField
        txtNgay.setText(String.valueOf(day));
        txtThang.setText(String.valueOf(month));
        txtNam.setText(String.valueOf(year));
        
        txtDiaChi.setText(currentUser.getCity());
        txtEmail.setText(currentUser.getEmail());
        txtSoDT.setText(currentUser.getPhone());
        if(currentUser.getGender() == 1)
            radNam.setSelected(true);
        else
            radNu.setSelected(true);
        txtPw.setEnabled(false);
        txtNewPw.setEnabled(false);
        txtHoTen.setEnabled(false);
        txtNgay.setEnabled(false);
        txtThang.setEnabled(false);
        txtNam.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSoDT.setEnabled(false);
        radNam.setEnabled(false);
        radNu.setEnabled(false);
    }
    
    
    public boolean checkPw() {
        String pw = txtPw.getText(), confirmPw = txtNewPw.getText();
        // Kiểm tra độ dài
        if (pw.length() < 8 || pw.length() > 32) {
            lblErrorMK.setText("Mật khẩu phải từ 8 đến 32 ký tự. ");
            return false;
        }
        // Kiểm tra khoảng trắng
        if (pw.contains(" ")) {
            lblErrorMK.setText("Mật khẩu không được chứa dấu cách. ");
            return false;
        }
        // Kiểm tra có ít nhất một chữ số
        if (!pw.matches(".*\\d.*")) {
            lblErrorMK.setText("Mật khẩu phải có ít nhất một chữ số. ");
            return false;
        }
        // Kiểm tra có ít nhất một chữ in hoa
        if (!pw.matches(".*[A-Z].*")) {
            lblErrorMK.setText("Mật khẩu phải có ít nhất một chữ in hoa. ");
            return false;
        }
        if (confirmPw.length() < 8 || confirmPw.length() > 32) {
            lblErrorMK.setText("Mật khẩu phải từ 8 đến 32 ký tự. ");
            return false;
        }
        // Kiểm tra khoảng trắng
        if (confirmPw.contains(" ")) {
            lblErrorMK.setText("Mật khẩu không được chứa dấu cách. ");
            return false;
        }
        // Kiểm tra có ít nhất một chữ số
        if (!confirmPw.matches(".*\\d.*")) {
            lblErrorMK.setText("Mật khẩu phải có ít nhất một chữ số. ");
            return false;
        }
        // Kiểm tra có ít nhất một chữ in hoa
        if (!confirmPw.matches(".*[A-Z].*")) {
            lblErrorMK.setText("Mật khẩu phải có ít nhất một chữ in hoa. ");
            return false;
        }
        lblErrorNLMK.setText("");
        lblErrorMK.setText("");
        return true;
    }
    
    public boolean checkHT(){
        String name = txtHoTen.getText();
        if(name.equals("")){
            lblErrorHT.setText("Họ tên không được bỏ trống. ");
            return false;
        }
        lblErrorHT.setText("");
        return true;
    }
    
    public boolean checkDC(){
        String name = txtDiaChi.getText();
        if(name.equals("")){
            lblErrorDC.setText("Địa chỉ không được bỏ trống. ");
            return false;
        }
        lblErrorDC.setText("");
        return true;
    }
    public boolean checkDate(){
        try{
            int day = Integer.parseInt(txtNgay.getText());
            int month = Integer.parseInt(txtThang.getText());
            int year = Integer.parseInt(txtNam.getText());
            LocalDate currentDate = LocalDate.now();
            LocalDate ageLimitDate = currentDate.minusYears(13); //lấy ngày hiện tại trừ 13 năm
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

            // Số ngày trong các tháng
            int[] daysInMonth = {31, 28 + (isLeapYear ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Kiểm tra tháng
            if (month < 1 || month > 12) {
                lblErrorNS.setText("Tháng không hợp lệ. ");
                return false;
            }
               
            // Kiểm tra ngày
            if (day < 1 || day > daysInMonth[month - 1]) {
                lblErrorNS.setText("Ngày không hợp lệ. ");
                return false;
            }
                
            // Kiểm tra năm
            if(year < 1900 || year > currentDate.getYear()){
                lblErrorNS.setText("Năm nhập không hợp lệ. ");
                return false;
            }
            
            LocalDate userDate = LocalDate.of(year, month, day); //Tạo đối tượng lưu ngày nhập
            if (userDate.isAfter(ageLimitDate)) {
                lblErrorNS.setText("Người dùng chưa đủ 13 tuổi để đăng ký.");
                return false;
            }
            
            lblErrorNS.setText("");
            return true;
        }catch(Exception e){
            lblErrorNS.setText("Ngày sinh bị bỏ trống hoặc điền sai định dạng. ");
            return false;
        }
    }
    
    public boolean checkEmail(){
        String email = txtEmail.getText();
        if(email.equals("")){
            lblErrorEmail.setText("Email đang bị bỏ trống. ");
            return false;
        }
            
        if (!email.contains("@")){
            lblErrorEmail.setText("Chưa đúng định dạng email. ");
            return false;
        }
        
        lblErrorEmail.setText("");
        return true;
    }
    
    public boolean checkSdt(){
        String sdt = txtSoDT.getText();
        
        if(sdt.equals("")){
            lblErrorSDT.setText("Số điện thoại không được bỏ trống. ");
            return false;
        }
        
        if(sdt.charAt(0) != '0' || sdt.length() != 10 || !sdt.matches("\\d+")){
            lblErrorSDT.setText("Số điện thoại không hợp lệ. ");
            return false;
        }
        
        lblErrorSDT.setText("");
        return true;
    }
    
    public boolean checkGender(){
        if(!radNam.isSelected() && !radNu.isSelected()){
            lblErrorGT.setText("Bạn chưa chọn giới tính. ");
            return false;
        }
        lblErrorGT.setText("");
        return true;
    }
    
    public boolean checkPWData() throws ClassNotFoundException, SQLException{
        String pw = txtPw.getText();
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.checkUserByUsernamePassword(currentUser.getUsername(), pw);
        if(result)
            lblErrorMK.setText("");
        else
            lblErrorMK.setText("Mật khẩu không đúng");
        return result;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtThang = new javax.swing.JTextField();
        txtNam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblErrorTK = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblErrorMK = new javax.swing.JLabel();
        lblErrorNLMK = new javax.swing.JLabel();
        lblErrorHT = new javax.swing.JLabel();
        lblErrorNS = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenTaiKhoan = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtNgay = new javax.swing.JTextField();
        txtPw = new javax.swing.JPasswordField();
        txtNewPw = new javax.swing.JPasswordField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblErrorDC = new javax.swing.JLabel();
        btnLuuTT = new javax.swing.JButton();
        lblErrorEmail = new javax.swing.JLabel();
        lblErrorSDT = new javax.swing.JLabel();
        lblErrorGT = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        btnDoiMatKhau = new javax.swing.JButton();
        btnSuaTT = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cài đặt tài khoản");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Có thể xem, sửa, xoá");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tên tài khoản: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mật khẩu cũ: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Họ tên: ");

        lblErrorTK.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorTK.setText("jLabel12");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ngày sinh (dd/mm/yyyy): ");

        lblErrorMK.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorMK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorMK.setText("jLabel13");

        lblErrorNLMK.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorNLMK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorNLMK.setText("jLabel14");

        lblErrorHT.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorHT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorHT.setText("jLabel15");

        lblErrorNS.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorNS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorNS.setText("jLabel16");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Mật khẩu mới: ");

        txtTenTaiKhoan.setEnabled(false);

        radNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radNam.setText("Nam");

        radNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radNu.setText("Nữ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Địa chỉ: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Email: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Số điện thoại: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Giới tính: ");

        lblErrorDC.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorDC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorDC.setText("jLabel17");

        btnLuuTT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLuuTT.setText("Lưu");
        btnLuuTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTTActionPerformed(evt);
            }
        });

        lblErrorEmail.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorEmail.setText("jLabel18");

        lblErrorSDT.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorSDT.setText("jLabel19");

        lblErrorGT.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorGT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErrorGT.setText("jLabel20");

        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnSuaTT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSuaTT.setText("Sửa thông tin");
        btnSuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblErrorNS)
                                            .addComponent(lblErrorHT)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblErrorNLMK)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtNewPw, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPw, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblErrorMK)
                                        .addComponent(lblErrorTK))
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblErrorSDT)
                                    .addComponent(lblErrorGT)
                                    .addComponent(lblErrorEmail)
                                    .addComponent(lblErrorDC))
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radNam)
                                        .addGap(26, 26, 26)
                                        .addComponent(radNu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 31, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDoiMatKhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaTT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuuTT)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorMK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNewPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorNLMK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorHT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorDC, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel11))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radNam)
                                .addComponent(radNu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorGT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorNS, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuTT)
                    .addComponent(btnDoiMatKhau)
                    .addComponent(btnSuaTT))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTTActionPerformed
        if(txtPw.isEnabled()){
            try {
                boolean error = checkPWData() && checkPw();
                if(error){
                    try {
                        String username = currentUser.getUsername();
                        String pw = txtNewPw.getText();
                        UserDAO userDAO = new UserDAO();
                        userDAO.updatePassword(username, pw);
                        JOptionPane.showMessageDialog(this, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                        //String username, String fullname, LocalDate birth, boolean gender, String email, String phone, String city
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PnlCaiDatTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(PnlCaiDatTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlCaiDatTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PnlCaiDatTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(txtHoTen.isEnabled()){
            boolean error = checkHT() && checkDate() && checkDC() && checkEmail() && checkSdt() && checkGender();
            if(error){
                try {
                    String username = currentUser.getUsername();
                    String ht = txtHoTen.getText();
                    // Lấy ngày, tháng, năm từ LocalDate
                    int day = Integer.parseInt(txtNgay.getText());
                    int month = Integer.parseInt(txtThang.getText());
                    int year = Integer.parseInt(txtNam.getText());
                    java.time.LocalDate localDate = java.time.LocalDate.of(year, month, day);
                    
                    String dc = txtDiaChi.getText();
                    String email = txtEmail.getText();
                    String sdt = txtSoDT.getText();
                    boolean gt = false;
                    if(radNam.isSelected())
                        gt = true;
                    UserDAO userDAO = new UserDAO();
                    //String username, String fullname, LocalDate birth, boolean gender, String email, String phone, String city
                    userDAO.updateUserByUsernameSetting(username, ht, localDate, gt, email, sdt, dc);
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PnlCaiDatTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PnlCaiDatTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnLuuTTActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        txtPw.setEnabled(true);
        txtNewPw.setEnabled(true);
        txtHoTen.setEnabled(false);
        txtNgay.setEnabled(false);
        txtThang.setEnabled(false);
        txtNam.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSoDT.setEnabled(false);
        radNam.setEnabled(false);
        radNu.setEnabled(false);
        txtPw.repaint();
        txtNewPw.repaint();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnSuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTTActionPerformed
        txtPw.setEnabled(false);
        txtNewPw.setEnabled(false);
        txtHoTen.setEnabled(true);
        txtNgay.setEnabled(true);
        txtThang.setEnabled(true);
        txtNam.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSoDT.setEnabled(true);
        radNam.setEnabled(true);
        radNu.setEnabled(true);
        txtHoTen.repaint();
        txtNgay.repaint();
        txtThang.repaint();
        txtNam.repaint();
        txtDiaChi.repaint();
        txtEmail.repaint();
        txtSoDT.repaint();
        radNam.repaint();
        radNu.repaint();
    }//GEN-LAST:event_btnSuaTTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnLuuTT;
    private javax.swing.JButton btnSuaTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblErrorDC;
    private javax.swing.JLabel lblErrorEmail;
    private javax.swing.JLabel lblErrorGT;
    private javax.swing.JLabel lblErrorHT;
    private javax.swing.JLabel lblErrorMK;
    private javax.swing.JLabel lblErrorNLMK;
    private javax.swing.JLabel lblErrorNS;
    private javax.swing.JLabel lblErrorSDT;
    private javax.swing.JLabel lblErrorTK;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNam;
    private javax.swing.JPasswordField txtNewPw;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JPasswordField txtPw;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JTextField txtThang;
    // End of variables declaration//GEN-END:variables
}
