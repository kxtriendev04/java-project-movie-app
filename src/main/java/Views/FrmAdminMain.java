/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author nguye
 */
public class FrmAdminMain extends javax.swing.JFrame {
    private User user;
    /**
     * Creates new form FrmAdminMain
     */
    public Color color;
    
    public FrmAdminMain(User curentUser) {
        user = curentUser;
        initComponents();
        color = btnColor1.getBackground();
        this.setResizable(false);
        String[] words = curentUser.getFullname().split(" ");
        lblAdmin.setText(lblAdmin.getText() + words[words.length - 1]);
        
        lblPhimRac.setVisible(false);
        lblUserRac.setVisible(false);
        lblLichRac.setVisible(false);
        lblPhongRac.setVisible(false);
        updateLabelState(lblUser);
        pnlMain.setLayout(new BorderLayout()); 
        try {
            setForm(new PnlUsAcc());
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public FrmAdminMain() {
        initComponents();
        color = btnColor1.getBackground();
        this.setResizable(false);
        lblPhimRac.setVisible(false);
        lblUserRac.setVisible(false);
        lblLichRac.setVisible(false);
        lblPhongRac.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPhim = new javax.swing.JLabel();
        lblLich = new javax.swing.JLabel();
        lblPhong = new javax.swing.JLabel();
        btnColor2 = new javax.swing.JButton();
        btnColor3 = new javax.swing.JButton();
        btnColor4 = new javax.swing.JButton();
        btnColor5 = new javax.swing.JButton();
        btnColor1 = new javax.swing.JButton();
        lblRac = new javax.swing.JLabel();
        lblUserRac = new javax.swing.JLabel();
        lblPhimRac = new javax.swing.JLabel();
        lblLichRac = new javax.swing.JLabel();
        lblPhongRac = new javax.swing.JLabel();
        lblCDTK = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setMaximumSize(new java.awt.Dimension(717, 515));
        pnlMain.setMinimumSize(new java.awt.Dimension(621, 476));
        pnlMain.setOpaque(false);
        pnlMain.setPreferredSize(new java.awt.Dimension(717, 515));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText(" Quản lý người dùng");
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });

        lblPhim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhim.setForeground(new java.awt.Color(255, 255, 255));
        lblPhim.setText(" Quản lý phim");
        lblPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhimMouseClicked(evt);
            }
        });

        lblLich.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLich.setForeground(new java.awt.Color(255, 255, 255));
        lblLich.setText(" Quản lý lịch chiếu");
        lblLich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLichMouseClicked(evt);
            }
        });

        lblPhong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblPhong.setText(" Quản lý phòng chiếu");
        lblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhongMouseClicked(evt);
            }
        });

        btnColor2.setBackground(new java.awt.Color(102, 0, 102));
        btnColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor2ActionPerformed(evt);
            }
        });

        btnColor3.setBackground(new java.awt.Color(153, 0, 0));
        btnColor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor3ActionPerformed(evt);
            }
        });

        btnColor4.setBackground(new java.awt.Color(102, 102, 0));
        btnColor4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor4ActionPerformed(evt);
            }
        });

        btnColor5.setBackground(new java.awt.Color(0, 102, 51));
        btnColor5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor5ActionPerformed(evt);
            }
        });

        btnColor1.setBackground(new java.awt.Color(0, 102, 102));
        btnColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColor1ActionPerformed(evt);
            }
        });

        lblRac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRac.setForeground(new java.awt.Color(255, 255, 255));
        lblRac.setText(" Thùng rác");
        lblRac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRacMouseClicked(evt);
            }
        });

        lblUserRac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUserRac.setForeground(new java.awt.Color(255, 255, 255));
        lblUserRac.setText("   Người dùng");
        lblUserRac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserRacMouseClicked(evt);
            }
        });

        lblPhimRac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhimRac.setForeground(new java.awt.Color(255, 255, 255));
        lblPhimRac.setText("   Phim");
        lblPhimRac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhimRacMouseClicked(evt);
            }
        });

        lblLichRac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLichRac.setForeground(new java.awt.Color(255, 255, 255));
        lblLichRac.setText("   Lịch chiếu");
        lblLichRac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLichRacMouseClicked(evt);
            }
        });

        lblPhongRac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhongRac.setForeground(new java.awt.Color(255, 255, 255));
        lblPhongRac.setText("   Phòng chiếu");
        lblPhongRac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhongRacMouseClicked(evt);
            }
        });

        lblCDTK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCDTK.setForeground(new java.awt.Color(255, 255, 255));
        lblCDTK.setText(" Cài đặt tài khoản");
        lblCDTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCDTKMouseClicked(evt);
            }
        });

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setText(" Quản lý hoá đơn");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
        });

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Xin chào: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLich, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(lblRac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserRac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhimRac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLichRac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhongRac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnColor2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnColor3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnColor4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnColor5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCDTK))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblAdmin)
                .addGap(37, 37, 37)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserRac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhimRac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLichRac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhongRac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCDTK)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColor2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColor3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColor4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColor5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateLabelState(JLabel selectedLabel) {
        // Đặt các nhãn khác thành không hiển thị nền
        lblPhim.setOpaque(false);
        lblLich.setOpaque(false);
        lblPhong.setOpaque(false);
        lblUser.setOpaque(false);
        lblRac.setOpaque(false);
        lblPhimRac.setOpaque(false);
        lblUserRac.setOpaque(false);
        lblLichRac.setOpaque(false);
        lblPhongRac.setOpaque(false);
        lblHoaDon.setOpaque(false);
        lblCDTK.setOpaque(false);
        
        // Đặt nhãn đã chọn thành hiển thị nền
        selectedLabel.setOpaque(true);
        selectedLabel.setBackground(color);

        //Đóng menu con nếu chọn sang lbl khác

        // Cập nhật lại giao diện
        lblPhim.repaint();
        lblLich.repaint();
        lblPhong.repaint();
        lblUser.repaint();
        lblRac.repaint();
        lblPhimRac.repaint();
        lblUserRac.repaint();
        lblLichRac.repaint();
        lblPhongRac.repaint();
        lblHoaDon.repaint();
        lblCDTK.repaint();
    }
    
    public void closeChildMenu(){
        if(lblPhimRac.isVisible()){
            lblPhimRac.setVisible(false);
            lblUserRac.setVisible(false);
            lblLichRac.setVisible(false);
            lblPhongRac.setVisible(false);
        }else{
            lblPhimRac.setVisible(true);
            lblUserRac.setVisible(true);
            lblLichRac.setVisible(true);
            lblPhongRac.setVisible(true);
        }
    }
    
    public void rePaint(){
        lblPhim.setBackground(color);
        lblLich.setBackground(color);
        lblPhong.setBackground(color);
        lblUser.setBackground(color);
        lblRac.setBackground(color);
        lblPhimRac.setBackground(color);
        lblUserRac.setBackground(color);
        lblLichRac.setBackground(color);
        lblPhongRac.setBackground(color);
        lblCDTK.setBackground(color);
        lblPhim.repaint();
        lblLich.repaint();
        lblPhong.repaint();
        lblUser.repaint();
        lblRac.repaint();
        lblPhimRac.repaint();
        lblUserRac.repaint();
        lblLichRac.repaint();
        lblPhongRac.repaint();
        lblCDTK.repaint();
    }
    private void btnColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor1ActionPerformed
        color = btnColor1.getBackground();
        rePaint();
    }//GEN-LAST:event_btnColor1ActionPerformed

    private void btnColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor2ActionPerformed
        color = btnColor2.getBackground();
        rePaint();
    }//GEN-LAST:event_btnColor2ActionPerformed

    private void btnColor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor3ActionPerformed
        color = btnColor3.getBackground();
        rePaint();
    }//GEN-LAST:event_btnColor3ActionPerformed

    private void btnColor4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor4ActionPerformed
        color = btnColor4.getBackground();
        rePaint();
    }//GEN-LAST:event_btnColor4ActionPerformed

    private void btnColor5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColor5ActionPerformed
        color = btnColor5.getBackground();
        rePaint();
    }//GEN-LAST:event_btnColor5ActionPerformed

    private void setForm(JComponent c){
        pnlMain.removeAll(); //Xoá toàn bộ các thành phần
        pnlMain.add(c); //Thêm form
        pnlMain.repaint(); //Cập nhật lại giao diện
        pnlMain.revalidate(); //Cập nhật lại bố cục
    }
    
    private void lblPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhimMouseClicked
        updateLabelState(lblPhim);
        pnlMain.setLayout(new BorderLayout());
        try {
            setForm(new PnlAdPhim());
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPhimMouseClicked

    private void lblLichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLichMouseClicked
        updateLabelState(lblLich);
        pnlMain.setLayout(new BorderLayout());
        try {
            setForm(new PnlAdLich());
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblLichMouseClicked

    private void lblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhongMouseClicked
        updateLabelState(lblPhong);
        pnlMain.setLayout(new BorderLayout());
        try {
            setForm(new PnlAdPhong());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPhongMouseClicked
    
    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        try {
            updateLabelState(lblUser);
            pnlMain.setLayout(new BorderLayout()); 
            setForm(new PnlUsAcc());
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmAdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblUserMouseClicked

    private void lblRacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRacMouseClicked
        closeChildMenu();
        updateLabelState(lblRac);
    }//GEN-LAST:event_lblRacMouseClicked

    private void lblUserRacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserRacMouseClicked
        pnlMain.setLayout(new BorderLayout());
        updateLabelState(lblUserRac);
        setForm(new PnlAdDeletedUs());
    }//GEN-LAST:event_lblUserRacMouseClicked

    private void lblPhimRacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhimRacMouseClicked
        updateLabelState(lblPhimRac);
        pnlMain.setLayout(new BorderLayout());
        setForm(new PnlAdDeletedPhim()); 
    }//GEN-LAST:event_lblPhimRacMouseClicked

    private void lblLichRacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLichRacMouseClicked
        updateLabelState(lblLichRac);
        pnlMain.setLayout(new BorderLayout());
        setForm(new PnlAdDeletedLich()); 
    }//GEN-LAST:event_lblLichRacMouseClicked

    private void lblPhongRacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhongRacMouseClicked
        updateLabelState(lblPhongRac);
        pnlMain.setLayout(new BorderLayout());
        setForm(new PnlAdDeletedPhong()); 
    }//GEN-LAST:event_lblPhongRacMouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        updateLabelState(lblHoaDon);
        pnlMain.setLayout(new BorderLayout());
        setForm(new PnlAdHoaDon()); 
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblCDTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCDTKMouseClicked
        updateLabelState(lblCDTK);
        pnlMain.setLayout(new BorderLayout());
        setForm(new PnlCaiDatTaiKhoan(user));
    }//GEN-LAST:event_lblCDTKMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdminMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColor1;
    private javax.swing.JButton btnColor2;
    private javax.swing.JButton btnColor3;
    private javax.swing.JButton btnColor4;
    private javax.swing.JButton btnColor5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblCDTK;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblLich;
    private javax.swing.JLabel lblLichRac;
    private javax.swing.JLabel lblPhim;
    private javax.swing.JLabel lblPhimRac;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblPhongRac;
    private javax.swing.JLabel lblRac;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserRac;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
