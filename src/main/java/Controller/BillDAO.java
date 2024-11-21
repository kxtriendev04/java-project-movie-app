/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author LENOVO
 */
public class BillDAO {

    public BillDAO(String filePath, String cinemaName, String movieTitle, String timeBooking,String room, String schedule, String address ,String customerName,int bookingId,  List<String[]> servicePrice) {
        // Tạo hóa đơn
        createInvoice(filePath, cinemaName, movieTitle, timeBooking ,room, schedule,address, customerName,bookingId, servicePrice);
        
    }
    
    
    
    public void createInvoice(String filePath, String cinemaName, String movieTitle, String timeBooking,String room, String schedule, String address ,String customerName,int bookingId,  List<String[]> servicePrice) {
        try {
            // Đường dẫn đến file font hỗ trợ tiếng Việt (Times New Roman)
//            String fontPath = "C:\\Users\\LENOVO\\Downloads\\Compressed\\font-times-new-roman_2\\font-times-new-roman\\times.ttf"; // Hoặc thay bằng đường dẫn tới font khác
            String fontPath = "/font/times.ttf";

            // Tạo document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Tải font hỗ trợ tiếng Việt
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(baseFont, 26, Font.BOLD);
            Font boldFont = new Font(baseFont, 22, Font.BOLD);
            Font normalFont = new Font(baseFont, 22);
            Font tableFont = new Font(baseFont, 20);

            // Tiêu đề hóa đơn
            Paragraph title = new Paragraph("HÓA ĐƠN XEM PHIM DDL CINEMA", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Thông tin rạp và khách hàng
//            document.add(new Paragraph("Rạp: " + cinemaName, titleFont));

            document.add(new Paragraph("Địa chỉ: " + address, normalFont));
            document.add(new Paragraph("Số điện thoại: 0966736760", normalFont));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Tên khách hàng: " + customerName, boldFont));
            document.add(new Paragraph("Phim: " + movieTitle, normalFont));
            document.add(new Paragraph("Mã giao dịch: " + bookingId, normalFont));
            document.add(new Paragraph("Lịch chiếu: " + schedule, normalFont));
            document.add(new Paragraph("Phòng chiếu: " + room, normalFont));
            document.add(new Paragraph("Thời gian đặt: " + timeBooking, normalFont));
            document.add(new Paragraph("\n")); // Dòng trống

            // Bảng tóm tắt
            PdfPTable table = new PdfPTable(2); // 2 cột
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            // Thêm dữ liệu vào bảng
            // Tạo header với màu nền
            Font headerFont = new Font(baseFont, 22, Font.BOLD); // Font tiêu đề
            PdfPCell header1 = new PdfPCell(new Phrase("Mục", headerFont));
            header1.setBackgroundColor(BaseColor.LIGHT_GRAY); // Đặt màu nền
            header1.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa
            header1.setPadding(8); // Khoảng cách nội dung trong ô

            PdfPCell header2 = new PdfPCell(new Phrase("Giá", headerFont));
            header2.setBackgroundColor(BaseColor.LIGHT_GRAY); // Đặt màu nền
            header2.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa
            header2.setPadding(8);

            // Thêm các ô header vào bảng
            table.addCell(header1);
            table.addCell(header2);
            
            
//            table.addCell(new PdfPCell(new Phrase("Tổng tiền", normalFont)));
//            table.addCell(new PdfPCell(new Phrase(String.format("%.2f VND", totalAmount), normalFont)));
            float totalAmount = 0;
            // Tạo DecimalFormat để định dạng số với dấu phẩy
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            for(String[] i : servicePrice){
                table.addCell(new PdfPCell(new Phrase(i[0], tableFont)));
                String formattedPrice = decimalFormat.format(Float.parseFloat(i[1]));
                
                table.addCell(new PdfPCell(new Phrase(formattedPrice, tableFont)));
//                table.addCell(new PdfPCell(new Phrase(i[1], tableFont)));

                float price = Float.parseFloat(i[1]);
                totalAmount += price;
            }
            table.addCell(new PdfPCell(new Phrase("Tổng tiền", tableFont)));
//            table.addCell(new PdfPCell(new Phrase(String.format("%.0f VND", decimalFormat.format(totalAmount)), tableFont)));
            table.addCell(new PdfPCell(new Phrase(decimalFormat.format(totalAmount), tableFont)));
            document.add(table);

            // Ghi chú cuối hóa đơn
            Paragraph footer = new Paragraph("Xin chân thành cảm ơn quý khách", normalFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(20);
            document.add(footer);

            // Đóng tài liệu
            document.close();

            System.out.println("Hóa đơn đã được tạo tại: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
