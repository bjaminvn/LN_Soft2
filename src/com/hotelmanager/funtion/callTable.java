/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.funtion;

import com.hotelmanager.dao.ClientDAO;
import com.hotelmanager.dao.RoomDAO;
import com.hotelmanager.dao.ServiceDAO;
import com.hotelmanager.dao.UserDAO;
import com.hotelmanager.entity.Client;
import com.hotelmanager.entity.Room;
import com.hotelmanager.entity.Service;
import com.hotelmanager.entity.User;
import com.hotelmanager.ui.mainJFrame;
import com.hotelmanager.utils.MsgBox;
import java.awt.Font;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author longd
 */
public class callTable {
    
    public static void callEmployee(JTable table,JFrame jFrame){
        UserDAO userDAO = new UserDAO();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            List<User> list = userDAO.selectAll();
            for (User user : list) {
                Object[] rows = {
                    user.getMaNV(),
                    user.getHoTen(),
                    user.getNgaySinh(),
                    user.getSoDT(),
                    user.getDiaChi(),
                    user.isVaiTro()? "Lễ tân" : "Quản lí"
                };
                model.addRow(rows);
            }
        } catch (Exception e) {
            MsgBox.alert(jFrame, "Lỗi truy vấn dữ liệu nhân viên!");
        }
    }
    
    public static void callRoom(JTable table, JFrame jFrame){
        RoomDAO roomDAO = new RoomDAO();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            List<Room> list = roomDAO.selectAll();
            for (Room room : list) {
                Object[] rows = {
                    room.getSoPhong(),
                    room.getLoaiPhong(),
                    room.getGia(),
                    room.getTinhTrang(),
                    room.getAnh()
                };
                model.addRow(rows);
            }
        } catch (Exception e) {
            MsgBox.alert(jFrame, "Lỗi truy vấn dữ liệu nhân viên!");
        }
    }
    
    public static void callService(JTable table, JFrame jFrame){
        ServiceDAO serviceDAO = new ServiceDAO();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            List<Service> list = serviceDAO.selectAll();
            for (Service service : list) {
                Object[] rows = {
                    service.getMaDV(),
                    service.getTenDV(),
                    service.getGiaDV(),
                    service.getNhaCC(),
                    service.getAnh(),
                    service.getMaNV()
                };
                model.addRow(rows);
            }
        } catch (Exception e) {
            MsgBox.alert(jFrame, "Lỗi truy vấn dữ liệu nhân viên!");
        }
    }
    
//    public static void callClient(JTable table,  jDialog){
//        ClientDAO clientDAO = new ClientDAO();
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0);
//        
//        try {
//            List<Client> list = clientDAO.selectAll();
//            for (Client client : list) {
//                Object[] rows = {
//                    client.getMaKH(),
//                    client.getTenKH(),
//                    client.getGioiTinh(),
//                    client.getNgaySinh(),
//                    client.getSoDT(),
//                    client.getCmt()
//                };
//                model.addRow(rows);
//            }
//        } catch (Exception e) {
//            MsgBox.alert(jDialog, "Lỗi truy vấn dữ liệu nhân viên!");
//        }
//    }
    
}
