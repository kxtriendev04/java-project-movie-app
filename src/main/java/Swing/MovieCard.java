package Swing;

import Models.Movie;
import Models.User;
import Views.NewFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;

public class MovieCard extends javax.swing.JPanel {
    private Movie movie;
    private User curentUser;
    public MovieCard() {
        initComponents();
//        selected = false;
        setOpaque(false);
//        setLayout(null);
        setPreferredSize(new Dimension(163, 237));
//        this.setResizable(false);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setMovie(Movie m, User user) {
        curentUser = user;
        if(user == null){
            System.out.println("Không tìm thấy user ở MovieCard");
        }
        
        
        this.movie = m;
        lblName.setText(movie.getMovieName());
        lblcens.setText(String.valueOf(movie.getMovieCens()));
        lblLength.setText(String.valueOf(movie.getMovieLength()));
        String imageUrl = movie.getMoviePoster();
//        
//        
//        // Tạo ImageIcon từ URL
        ImageIcon imageIcon = createImageFromURL(imageUrl);
        // Điều chỉnh kích thước ảnh sao cho vừa với JLabel
        if (imageIcon != null) {
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(151, 109, Image.SCALE_SMOOTH);
            lblPhoto.setIcon(new ImageIcon(scaledImage));
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
    private static ImageIcon createImageFromResources(String imagePath) {
        try {
            // Sử dụng ClassLoader để lấy URL của file trong thư mục resources
            URL resource = MovieCard.class.getClassLoader().getResource(imagePath);
            if (resource != null) {
                return new ImageIcon(resource);
            } else {
                System.err.println("Không tìm thấy file ảnh: " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        // Tùy chỉnh nền và viền
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền bo góc
        g2.setColor(new Color(204, 204, 204, 204)); // Màu nền với độ trong suốt
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Vẽ viền khi được chọn
//        if (selected) {
//            g2.setColor(new Color(94, 156, 255)); // Màu viền khi được chọn
//            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
//        }

        g2.dispose();
        // Gọi phương thức gốc để vẽ các thành phần con
        super.paintComponent(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblcens = new javax.swing.JLabel();
        lblLength = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setText("MovieName");

        lblcens.setText("moviecens");

        lblLength.setText("length");

        btnBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBook.setText("Đặt vé!");
        btnBook.setBorder(null);
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookMouseClicked(evt);
            }
        });
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblcens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(lblLength))
                    .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcens)
                    .addComponent(lblLength))
                .addGap(18, 18, 18)
                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

     private void openNewForm() {
        NewFrame newForm = new NewFrame(movie, curentUser);  // Tạo đối tượng của form mới
        newForm.setVisible(true);  // Hiển thị form mới
    }
     
    private void btnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseClicked
        // TODO add your handling code here:
        openNewForm();
    }//GEN-LAST:event_btnBookMouseClicked

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblcens;
    // End of variables declaration//GEN-END:variables
}
