/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.MovieDAO;
import Models.Movie;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class PnlAdDeletedPhim extends javax.swing.JPanel {

    /**
     * Creates new form PnlAdDeletedPhim
     */
    public PnlAdDeletedPhim() {
        initComponents();
        lblErrorTP.setText("");
        lblErrorTG.setText("");
        lblErrorGH.setText("");
        lblErrorTL.setText("");
        lblErrorNKC.setText("");
        lblErrorPoster.setText("");
        lblErrorMT.setText("");
        try {
            showData();
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showData() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) tbPhim.getModel();
        model.setRowCount(0); // Xóa các dòng cũ trong bảng

        MovieDAO moviesDAO = new MovieDAO();
        List<Movie> movies = moviesDAO.getAllMovies();

        for (Movie movie : movies) {
            if(!movie.getIsDeleted())
                continue;
            Object row[] = new Object[9];
            row[0] = movie.getMovieId();
            row[1] = movie.getMovieName();
            row[2] = movie.getMovieDescription();
            row[3] = movie.getMovieTrailer();
            row[4] = movie.getMovieCens();
            row[5] = movie.getMovieGenres();
            row[6] = movie.getMovieRelease();
            row[7] = movie.getMovieLength();
            row[8] = movie.getMoviePoster();
            // Thêm dòng vào bảng
            model.addRow(row);
        }
    }
    public void resetData(){
        txtId.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblErrorNKC = new javax.swing.JLabel();
        btnXoaAll = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        lblErrorMT = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblErrorTG = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPoster = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblErrorGH = new javax.swing.JLabel();
        lblErrorTL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblErrorPoster = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtThoiLuong = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtThang = new javax.swing.JTextField();
        txtGioiHan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhim = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        txtNgay = new javax.swing.JTextField();
        txtTim = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        lblErrorTP = new javax.swing.JLabel();
        btnXoaVinhVien = new javax.swing.JButton();
        btnRestore = new javax.swing.JButton();

        btnTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTim.setText("Tìm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý thùng rác phim");

        lblErrorNKC.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNKC.setText("jLabel12");

        btnXoaAll.setText("Xoá tất cả");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên phim:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        txtMoTa.setEnabled(false);
        jScrollPane1.setViewportView(txtMoTa);

        lblErrorMT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMT.setText("jLabel13");

        jLabel6.setText("Ngày khởi chiếu: ");

        lblErrorTG.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorTG.setText("jLabel14");

        jLabel2.setText("Poster:");

        txtPoster.setEnabled(false);

        jLabel7.setText("Mô tả:");

        jLabel8.setText("Thể loại:");

        lblErrorGH.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorGH.setText("jLabel15");

        lblErrorTL.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorTL.setText("jLabel16");

        jLabel9.setText("Giới hạn:");

        lblErrorPoster.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorPoster.setText("jLabel17");

        jLabel10.setText("Thời lượng:");

        txtId.setText("Kh được xóa");
        txtId.setEnabled(false);

        txtThoiLuong.setEnabled(false);

        txtTheLoai.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Có thể xem, xoá");

        txtThang.setEnabled(false);

        txtGioiHan.setEnabled(false);
        txtGioiHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioiHanActionPerformed(evt);
            }
        });

        tbPhim.setBackground(new java.awt.Color(153, 153, 153));
        tbPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Phim ID", "Tên ", "Mô tả", "Trailer", "Giới hạn", "Thể loại", "Ngày khởi chiếu", "Thời lượng (phút)", "Poster"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhimMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPhim);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm: ");

        txtNam.setEnabled(false);

        txtNgay.setEnabled(false);

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblErrorTP.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorTP.setText("jLabel2");

        btnXoaVinhVien.setText("Xóa vĩnh viễn");
        btnXoaVinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVinhVienActionPerformed(evt);
            }
        });

        btnRestore.setText("Khôi phục");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorNKC, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorMT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblErrorTP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNam, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrorGH, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblErrorPoster)
                                .addComponent(txtTheLoai)
                                .addComponent(txtGioiHan)
                                .addComponent(txtThoiLuong)
                                .addComponent(lblErrorTL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblErrorTG, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(txtPoster)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaVinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(lblErrorTL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtGioiHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lblErrorTP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblErrorGH)
                    .addComponent(lblErrorNKC))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel10)
                            .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorTG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtPoster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lblErrorPoster))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorMT)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaVinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Hành động khi người dùng chọn Yes

        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No
            return;
        }
    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void txtGioiHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioiHanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioiHanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtId.setText("");
        txtThoiLuong.setText("");
        txtGioiHan.setText("");
        txtTheLoai.setText("");
        txtNgay.setText("");
        txtThang.setText("");
        txtNam.setText("");
        txtPoster.setText("");
        txtMoTa.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaVinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVinhVienActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá vĩnh viễn?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Hành động khi người dùng chọn Yes
            int id = Integer.parseInt(txtId.getText());
            MovieDAO moviesDAO = new MovieDAO();
            try {
                if(moviesDAO.deleteMovieForever(id)){
                    resetData();
                    try {
                        showData();
                    } catch (SQLException ex) {
                        Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No
        }
    }//GEN-LAST:event_btnXoaVinhVienActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtId.getText());
        MovieDAO moviesDAO = new MovieDAO();
        if(moviesDAO.movieRestore(id)){
            resetData();
            try {
                showData();
            } catch (SQLException ex) {
                Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlAdDeletedPhim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void tbPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhimMouseClicked
        // TODO add your handling code here:
        int row =this.tbPhim.getSelectedRow();
        int id = Integer.parseInt(this.tbPhim.getModel().getValueAt(row, 0).toString());
        txtId.setText(String.valueOf(id));
    }//GEN-LAST:event_tbPhimMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JButton btnXoaVinhVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorGH;
    private javax.swing.JLabel lblErrorMT;
    private javax.swing.JLabel lblErrorNKC;
    private javax.swing.JLabel lblErrorPoster;
    private javax.swing.JLabel lblErrorTG;
    private javax.swing.JLabel lblErrorTL;
    private javax.swing.JLabel lblErrorTP;
    private javax.swing.JTable tbPhim;
    private javax.swing.JTextField txtGioiHan;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtPoster;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtThoiLuong;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
