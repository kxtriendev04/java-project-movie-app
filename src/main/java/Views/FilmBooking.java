/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.MovieScheduleRoomDAO;
import Models.Movie;
import Models.MovieScheduleRoom;
import Models.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class FilmBooking extends javax.swing.JPanel {

    private JLabel[][] labels = new JLabel[5][5];
    /**
     * Creates new form FilmBooking
     * @param movie
     */
//    private Movie movie;
//
//    public void setMovie(Movie m) {
//        this.movie = m;
//        lblName.setText(lblName.getText() + movie.getMovieName());
//        lblGenres.setText(lblGenres.getText() + movie.getMovieGenres());
//        lblDesc.setText(lblDesc.getText() + movie.getMovieDescription());
//        lblCens.setText(lblCens.getText() + movie.getMovieCens());
//        lblLength.setText(lblLength.getText() + movie.getMovieLength());
//        lblRealease.setText(String.valueOf(movie.getMovieRelease()));
//    }
    private Movie currentMovie;
    private User curtentUser;
    public FilmBooking(Movie movie, User user) {
        currentMovie = movie;
        initComponents();
        if(movie != null){
            lblName.setText(lblName.getText() + movie.getMovieName());
            lblGenres.setText(lblGenres.getText() + movie.getMovieGenres());
            lblDesc.setText(lblDesc.getText() + movie.getMovieDescription());
            lblCens.setText(lblCens.getText() + movie.getMovieCens());
            lblLength.setText(lblLength.getText() + movie.getMovieLength() + " phút");
            lblRealease.setText(lblRealease.getText() + String.valueOf(movie.getMovieRelease()));
            String imageUrl = movie.getMoviePoster();
            // Tạo ImageIcon từ URL
            ImageIcon imageIcon = createImageFromURL(imageUrl);
            // Điều chỉnh kích thước ảnh sao cho vừa với JLabel
            if (imageIcon != null) {
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(165, 239, Image.SCALE_SMOOTH);
                lblPhoto.setIcon(new ImageIcon(scaledImage));
            }
            // Get Data
            try {
                showData(user);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FilmBooking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void showData(User user) throws ClassNotFoundException{
        curtentUser = user;
        DefaultTableModel modelLich = (DefaultTableModel) tbThonTin.getModel();
        modelLich.setRowCount(0);
        MovieScheduleRoomDAO movieScheduleSeatDAO = new MovieScheduleRoomDAO();
//        if(currentMovie == null)
//            System.out.println("CurrentMovie iss null");
//        else
//            System.out.println(String.valueOf(currentMovie.getMovieId()));
        List<MovieScheduleRoom> movieScheduleSeats = movieScheduleSeatDAO.getAllMovieScheduleRoomByMovieId(currentMovie.getMovieId());
        for(MovieScheduleRoom mss : movieScheduleSeats){
            System.out.println(mss.getMovieName());
            modelLich.addRow(new Object[]{
                mss.getRoomName(),
                mss.getScheduleDate(),
                mss.getScheduleStart(),
                mss.getScheduleId(),
            });
        }
    }
    
    private static ImageIcon createImageFromURL(String imageUrl) {
        try {
            // Chuyển URL thành ImageIcon
            URL url = new URL(imageUrl);
            return new ImageIcon(url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPhoto = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblGenres = new javax.swing.JLabel();
        lblLength = new javax.swing.JLabel();
        lblRealease = new javax.swing.JLabel();
        lblCens = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        lblDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThonTin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setAutoscrolls(true);

        lblPhoto.setText("jLabel1");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblName.setText("Tên phim: ");
        lblName.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblGenres.setText("Thể loại: ");

        lblLength.setText("Độ dài: ");

        lblRealease.setText("Ngày phát hành: ");

        lblCens.setText("Độ tuổi tối thiểu: ");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        lblDesc.setText("Description: ");
        lblDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tbThonTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên phòng", "Ngày chiếu", "Giờ chiếu", "Mã lịch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbThonTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThonTinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbThonTin);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Vui lòng chọn lịch chiếu!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLength)
                                .addGap(107, 107, 107)
                                .addComponent(lblCens))
                            .addComponent(lblRealease)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGenres)
                            .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGenres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLength)
                            .addComponent(lblCens))
                        .addGap(18, 18, 18)
                        .addComponent(lblRealease))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbThonTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThonTinMouseClicked
        int row =this.tbThonTin.getSelectedRow();
        String idString = this.tbThonTin.getModel().getValueAt(row,3).toString();
        int scheduleId = Integer.parseInt(idString);
        pnlMain.setLayout(new BorderLayout()); // Layout theo vùng
        pnlMain.add(new PnlChoNgoi(scheduleId, curtentUser), BorderLayout.CENTER);

        pnlMain.revalidate();
        pnlMain.repaint();

    }//GEN-LAST:event_tbThonTinMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCens;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblGenres;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblRealease;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTable tbThonTin;
    // End of variables declaration//GEN-END:variables
}