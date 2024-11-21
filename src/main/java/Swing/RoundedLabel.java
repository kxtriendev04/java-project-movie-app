/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class RoundedLabel extends JLabel {
    
    public RoundedLabel(String text) {
        super(text);
    }
    public RoundedLabel(String text, int width, int height) {
        super(text);
        setPreferredSize(new Dimension(width, height)); // Thiết lập kích thước cho JLabel
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Kiểm tra kiểu đồ họa (Graphics2D) để sử dụng tính năng vẽ đồ họa nâng cao
        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;

            // Làm mượt các góc
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Lấy kích thước của JLabel
            int width = getWidth();
            int height = getHeight();

            // Tạo hình chữ nhật bo góc
            g2d.setColor(getBackground()); // Màu nền của JLabel
            g2d.fillRoundRect(0, 0, width, height, 20, 20); // (x, y, width, height, arcWidth, arcHeight)

            // Vẽ văn bản lên JLabel
            super.paintComponent(g);
        }
    } 
}
