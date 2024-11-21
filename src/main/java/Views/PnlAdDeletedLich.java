/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.MovieDAO;
import Controller.RoomDAO;
import Controller.ScheduleDAO;
import Models.Movie;
import Models.Room;
import Models.Schedule;
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
public class PnlAdDeletedLich extends javax.swing.JPanel {

    /**
     * Creates new form PnlAdDeletedLich
     */
    public PnlAdDeletedLich() {
        initComponents();
        lblErrorMLich.setText("");
        lblErrorMPhong.setText("");
        lblErrorMPhim.setText("");
        lblErrorNgay.setText("");
        lblErrorBD.setText("");
        lblErrorKT.setText("");


//        tbPhim.setRowSelectionAllowed(false);
//        tbPhong.setRowSelectionAllowed(false);
        try {
            showData();
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedLich.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedLich.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showData() throws SQLException, ClassNotFoundException {
        DefaultTableModel modelLich = (DefaultTableModel) tbLich.getModel();
        modelLich.setRowCount(0);
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        List<Schedule> schedules = scheduleDAO.getAllSchedule();
         for (Schedule schedule : schedules) {
            if(!schedule.isDeleted())
                continue;
            modelLich.addRow(new Object[]{
            schedule.getScheduleId(),
            schedule.getMovieId(),
            schedule.getRoomId(),
            schedule.getScheduleDate(),
            schedule.getScheduleStart(),
            schedule.getScheduleEnd(),
        });
         }
        
        DefaultTableModel modelPhim = (DefaultTableModel) tbPhim.getModel();
        modelPhim.setRowCount(0);
        MovieDAO moviesDAO = new MovieDAO();
        List<Movie> movies = moviesDAO.getAllMovies();
        for (Movie movie : movies) {
            if(movie.getIsDeleted())
                continue;
            Object row[] = new Object[9];
            row[0] = movie.getMovieId();
            row[1] = movie.getMovieName();
            row[2] = movie.getMovieLength();
            // Thêm dòng vào bảng
            modelPhim.addRow(row);
        }
        
        DefaultTableModel modelPhong = (DefaultTableModel) tbPhong.getModel();
        modelPhong.setRowCount(0);
        RoomDAO roomDAO = new RoomDAO();
        List<Room> rooms = roomDAO.getAllRoom();
        for (Room room : rooms) {
            if(room.isDeleted())
                continue;
            Object row[] = new Object[3];
            row[0] = room.getRoomId();
            row[1] = room.getRoomName();
//            row[2] = room.getRoomType();
            
            // Thêm dòng vào bảng
            modelPhong.addRow(row);
        }
        
    }
    public void resetData() {
        txtMaLich.setText("");
        txtMaPhim.setText("");
        txtMaPhong.setText("");
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
        lblErrorNgay = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnXoaAll = new javax.swing.JButton();
        lblErrorMPhong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblErrorMPhim = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblErrorBD = new javax.swing.JLabel();
        lblErrorKT = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaLich = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGioBatDau = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhim = new javax.swing.JTable();
        txtMaPhim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        txtThang = new javax.swing.JTextField();
        txtPhutBatDau = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLich = new javax.swing.JTable();
        txtGioKetThuc = new javax.swing.JTextField();
        txtPhutKetThuc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblErrorMLich = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        txtNgay = new javax.swing.JTextField();
        txtTim = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnRestore = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý thùng rác lịch chiếu");

        lblErrorNgay.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNgay.setText("jLabel12");

        jLabel8.setText("Mã phim:");

        btnXoaAll.setText("Xoá tất cả");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        lblErrorMPhong.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMPhong.setText("jLabel15");

        jLabel5.setText("Mã lịch:");

        lblErrorMPhim.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMPhim.setText("jLabel16");

        jLabel2.setText("Kết thúc:");

        jLabel9.setText("Mã phòng:");

        lblErrorBD.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorBD.setText("jLabel14");

        lblErrorKT.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorKT.setText("jLabel17");

        jLabel11.setText("Bắt đầu:");

        txtMaLich.setText("Không được xóa");
        txtMaLich.setEnabled(false);

        jLabel6.setText("Ngày: ");

        txtGioBatDau.setEnabled(false);

        tbPhim.setBackground(new java.awt.Color(153, 153, 153));
        tbPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Phim", "Tên Phim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbPhim);

        txtMaPhim.setText("Không được xóa");
        txtMaPhim.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Có thể xem, xoá");

        txtMaPhong.setText("Không được xóa");
        txtMaPhong.setEnabled(false);
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        tbPhong.setBackground(new java.awt.Color(153, 153, 153));
        tbPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Phòng", "Tên Phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbPhong);

        txtThang.setEnabled(false);

        txtPhutBatDau.setEnabled(false);

        tbLich.setBackground(new java.awt.Color(153, 153, 153));
        tbLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã lịch", "Mã phim", "Mã phòng", "Ngày", "Bắt đầu", "Kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLichMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbLich);

        txtGioKetThuc.setEnabled(false);

        txtPhutKetThuc.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm: ");

        lblErrorMLich.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMLich.setText("jLabel15");

        txtNam.setEnabled(false);

        txtNgay.setEnabled(false);

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa vĩnh viễn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTim.setText("Tìm");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel5)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(76, 76, 76)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMaLich, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblErrorMPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErrorMPhim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorMLich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNam))
                            .addComponent(lblErrorKT)
                            .addComponent(lblErrorBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblErrorNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGioBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPhutBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGioKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPhutKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addGap(28, 28, 28)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lblErrorMLich)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtGioKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtPhutKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblErrorNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtGioBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhutBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblErrorBD))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMaLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorMPhim)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel9)
                                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblErrorMPhong)
                                    .addComponent(lblErrorKT))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
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

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMaLich.setText("");
        txtGioBatDau.setText("");
        txtMaPhong.setText("");
        txtMaPhim.setText("");
        txtNgay.setText("");
        txtThang.setText("");
        txtNam.setText("");
        txtPhutBatDau.setText("");
        txtGioKetThuc.setText("");
        txtPhutKetThuc.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoá vĩnh viễn?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Hành động khi người dùng chọn Yes
            int id = Integer.parseInt(txtMaLich.getText());
            ScheduleDAO scheduleDAO = new ScheduleDAO();
            try {
                if(scheduleDAO.deleteScheduleForever(id)){
                    resetData();
                    showData();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PnlAdDeletedLich.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PnlAdDeletedLich.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (response == JOptionPane.NO_OPTION) {
            // Hành động khi người dùng chọn No\
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtMaLich.getText());
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        try {
            if(scheduleDAO.scheduleRestore(id)){
                resetData();
                showData();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlAdDeletedLich.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PnlAdDeletedLich.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void tbLichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLichMouseClicked
        // TODO add your handling code here:
        int row = this.tbLich.getSelectedRow();
        if (row == -1) {
            return; // Không làm gì nếu không có dòng nào được chọn
        }

        int scheduleId = Integer.parseInt(this.tbLich.getModel().getValueAt(row, 0).toString());
        String movieId = String.valueOf(this.tbLich.getModel().getValueAt(row, 1));
        String roomId = String.valueOf(this.tbLich.getModel().getValueAt(row, 2));

        // Deselect all rows in tbPhim
        tbPhim.clearSelection();
        DefaultTableModel Moviemodel = (DefaultTableModel) tbPhim.getModel(); // table là JTable của bạn
        for (int rowPhim = 0; rowPhim < Moviemodel.getRowCount(); rowPhim++) {
            String movieIdValue = String.valueOf(Moviemodel.getValueAt(rowPhim, 0)); // Lấy giá trị movie_id dưới dạng String
            if (movieIdValue.equals(movieId)) { // So sánh String với String
                tbPhim.addRowSelectionInterval(rowPhim, rowPhim); // Chọn hàng có movie_id trùng khớp
            }
        }

        // Deselect all rows in tbPhong
        tbPhong.clearSelection();
        DefaultTableModel RoomModel = (DefaultTableModel) tbPhong.getModel(); // table là JTable của bạn
        for (int Roomrow = 0; Roomrow < RoomModel.getRowCount(); Roomrow++) {
            String roomIdValue = String.valueOf(RoomModel.getValueAt(Roomrow, 0)); // Lấy giá trị room_id dưới dạng String
            if (roomIdValue.equals(roomId)) { // So sánh String với String
                tbPhong.addRowSelectionInterval(Roomrow, Roomrow); // Chọn hàng có room_id trùng khớp
            }
        }

        // Cập nhật các trường text
        txtMaLich.setText(String.valueOf(scheduleId));
        txtMaPhim.setText(movieId);
        txtMaPhong.setText(roomId);
    }//GEN-LAST:event_tbLichMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblErrorBD;
    private javax.swing.JLabel lblErrorKT;
    private javax.swing.JLabel lblErrorMLich;
    private javax.swing.JLabel lblErrorMPhim;
    private javax.swing.JLabel lblErrorMPhong;
    private javax.swing.JLabel lblErrorNgay;
    private javax.swing.JTable tbLich;
    private javax.swing.JTable tbPhim;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtGioBatDau;
    private javax.swing.JTextField txtGioKetThuc;
    private javax.swing.JTextField txtMaLich;
    private javax.swing.JTextField txtMaPhim;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtPhutBatDau;
    private javax.swing.JTextField txtPhutKetThuc;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
