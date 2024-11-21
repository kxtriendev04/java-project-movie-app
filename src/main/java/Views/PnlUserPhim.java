package Views;

import Controller.MovieDAO;
import Models.Movie;
import Models.User;
import Swing.MovieCard;
import Swing.ScrollBar;
import com.raven.swing.WrapLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PnlUserPhim extends javax.swing.JPanel {

    private User currentUser = new User();
    public PnlUserPhim(User user) {
        currentUser = user;
        initComponents();
        jScrollPane.setVerticalScrollBar(new ScrollBar());
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
        try {
            showData(user);
        } catch (SQLException ex) {
            Logger.getLogger(PnlUserPhim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlUserPhim.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void showData(User user) throws SQLException, ClassNotFoundException{
        MovieDAO moviesDAO = new MovieDAO();
        List<Movie> movies = moviesDAO.getAllMovies();
        int num = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j< 5; j++ ){
                if (num >= movies.size()) {
                return; // Nếu hết phần tử, thoát khỏi phương thức
                }
                MovieCard mc = new MovieCard();
                mc.setMovie(movies.get(num), user);
                ++num;
                pnlMain.add(mc);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        pnlSapChieu = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Danh sách phim");

        jScrollPane.setBorder(null);
        jScrollPane.setOpaque(false);

        pnlMain.setOpaque(false);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(pnlMain);

        javax.swing.GroupLayout pnlSapChieuLayout = new javax.swing.GroupLayout(pnlSapChieu);
        pnlSapChieu.setLayout(pnlSapChieuLayout);
        pnlSapChieuLayout.setHorizontalGroup(
            pnlSapChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSapChieuLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlSapChieuLayout.setVerticalGroup(
            pnlSapChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSapChieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSapChieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSapChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSapChieu;
    // End of variables declaration//GEN-END:variables
}
