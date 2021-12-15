/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.hotelmanager.ui;
import com.hotelmanager.dao.RoomDAO;
import com.hotelmanager.dao.ServiceDAO;
import com.hotelmanager.dao.StatisticalDAO;
import com.hotelmanager.dao.UserDAO;
import com.hotelmanager.entity.Room;
import com.hotelmanager.entity.Service;
import com.hotelmanager.entity.User;
import com.hotelmanager.funtion.callTable;
import com.hotelmanager.utils.Auth;
import com.hotelmanager.utils.MsgBox;
import java.awt.Color;
import java.util.List;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author longd
 */
public class mainJFrame extends javax.swing.JFrame {
    int row = 0;
    int row2 = 0;
    int row3 = 0;
    UserDAO nvDAO = new UserDAO();
    public User u1 = null;
    ServiceDAO serviceDAO = new ServiceDAO();
    public Service service = null;
    StatisticalDAO statisticalDAO = new StatisticalDAO();
    
    RoomDAO roomDAO = new RoomDAO();
    public Room room1 = null;
    /**
     * Creates new form mainJFrame
     */
    public mainJFrame() {
        initComponents();
        init();
    }

    void init(){
        setLocationRelativeTo(null);
        callTable.callEmployee(tblEmployee, this);
        callTable.callRoom(tblListRoom, this);
        callTable.callService(tblService, this);
        openLogin();
        checkLogin();
        doanhThu();
        doanhThuP();
        doanhThuS();
    }
    
    void openLogin(){
        new loginJDialog(this, true).setVisible(true);          
    }
    
    void checkLogin(){
        if (Auth.isLogin()) {
            User user = Auth.user;
            lblAccountName.setText(user.toString());
        }else{
            lblAccountName.setText("Vui long dang nhap!");
        }
    }
    
    
    
    void resetStatus(){
        lblStatus1.setText("<<");
        lblStatus2.setText("<<");
        lblStatus3.setText("<<");
        lblStatus4.setText("<<");
        lblRoomMng.setForeground(Color.white);
        lblStatisticalMng.setForeground(Color.white);
        lblWarehouseMng.setForeground(Color.white);
        lblEmployeeMng.setForeground(Color.white);
    }
    
    void resetDisplay(){
        ifRoomMng.setVisible(false);
        ifWareHouseMng.setVisible(false);
        ifStaticticalMng.setVisible(false);
        ifEmployeeMng.setVisible(false);
    }
    void delete(){
        String manv = (String) tblEmployee.getValueAt(tblEmployee.getSelectedRow(), 0);
        try {
            nvDAO.delete(manv);
            callTable.callEmployee(tblEmployee, this);
            MsgBox.alert(this, "Xóa thành công!"+manv);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi!");
        }
    }
    
    void deleteR(){
        int roomNumber = (Integer) tblListRoom.getValueAt(tblListRoom.getSelectedRow(), 0);
        try {
            roomDAO.delete(roomNumber);
            callTable.callRoom(tblListRoom, this);
            MsgBox.alert(this, "Xóa thành công!"+roomNumber);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi!");
        }
    }
    
    void deleteS(){
        String maDV = (String) tblService.getValueAt(tblService.getSelectedRow(), 0);
        try {
            serviceDAO.delete(maDV);
            MsgBox.alert(this, "Xóa thành công!");
            callTable.callService(tblService, this);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi!");
        }
    }
    
    void doanhThu(){
        DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
        model.setRowCount(0);
        List<Object[]> list = statisticalDAO.getDoanhThu();
        String[] array = new String[3];
        for (Object[] row : list) {
            model.addRow(row);
        }
        lblValueRoom.setText(tbl1.getValueAt(0, 0).toString());
        lblValueService.setText(tbl1.getValueAt(0, 1).toString());
        lblMoney.setText(tbl1.getValueAt(0, 2).toString());
    }
    
    void doanhThuP(){
        DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
        model.setRowCount(0);
        List<Object[]> list = statisticalDAO.getDoanhThuP();
        String[] array = new String[3];
        for (Object[] row : list) {
            model.addRow(row);
        }
        lblRoom1.setText(tbl2.getValueAt(0, 0).toString());
        lblRoom2.setText(tbl2.getValueAt(0, 1).toString());
        lblRoom3.setText(tbl2.getValueAt(0, 2).toString());
    }
    
    void doanhThuS(){
        DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
        model.setRowCount(0);
        List<Object[]> list = statisticalDAO.getDoanhThuS();
        String[] array = new String[3];
        for (Object[] row : list) {
            model.addRow(row);
        }
        lblService1.setText(tbl3.getValueAt(0, 0).toString());
        lblService2.setText(tbl3.getValueAt(0, 1).toString());
        lblService3.setText(tbl3.getValueAt(0, 2).toString());
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnuiShow = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        bg = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlRoomMng = new javax.swing.JPanel();
        lblRoomMng = new javax.swing.JLabel();
        lblIconRoom = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        pnlWarehouseMng = new javax.swing.JPanel();
        lblWarehouseMng = new javax.swing.JLabel();
        lblIconWarehouse = new javax.swing.JLabel();
        lblStatus2 = new javax.swing.JLabel();
        pnlStatisticalMng = new javax.swing.JPanel();
        lblStatisticalMng = new javax.swing.JLabel();
        lblIconStatistical = new javax.swing.JLabel();
        lblStatus3 = new javax.swing.JLabel();
        pnlEmployeeMng = new javax.swing.JPanel();
        lblEmployeeMng = new javax.swing.JLabel();
        lblIconStatistical2 = new javax.swing.JLabel();
        lblStatus4 = new javax.swing.JLabel();
        pnlPay = new javax.swing.JPanel();
        lblEmployeeMng1 = new javax.swing.JLabel();
        pnlLogOut = new javax.swing.JPanel();
        lblEmployeeMng2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        lblAccountName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        ifRoomMng = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListRoom = new javax.swing.JTable();
        btnBill = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();
        pnlHeadRoom = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        ifWareHouseMng = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        pnlHeadRoom1 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        cbxKhoaHoc = new javax.swing.JComboBox<>();
        txtFindS = new javax.swing.JTextField();
        btnFindS = new javax.swing.JButton();
        btnDeleteS = new javax.swing.JButton();
        btnLoads = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        btnBill1 = new javax.swing.JButton();
        btnBooking1 = new javax.swing.JButton();
        ifStaticticalMng = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlTongDT = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblValueRoom = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblValueService = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        pnlDTPhong = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblRoom1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblRoom2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblRoom3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        pnlDTsp = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblService1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblService2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblService3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        ifEmployeeMng = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        pnlHeadRoom2 = new javax.swing.JPanel();
        txtFind1 = new javax.swing.JTextField();
        lblTitle2 = new javax.swing.JLabel();
        btnAddEmp = new javax.swing.JButton();
        btnDeleteEmp = new javax.swing.JButton();
        btnFind1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        mnuiShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_view_28px.png"))); // NOI18N
        mnuiShow.setText("Xem");
        mnuiShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiShowActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuiShow);

        jPopupMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupMenu2MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(69, 138, 184));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRoomMng.setBackground(new java.awt.Color(69, 138, 184));
        pnlRoomMng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlRoomMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoomMngMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRoomMngMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRoomMngMouseExited(evt);
            }
        });
        pnlRoomMng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRoomMng.setBackground(new java.awt.Color(255, 255, 255));
        lblRoomMng.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRoomMng.setForeground(new java.awt.Color(255, 255, 255));
        lblRoomMng.setText("Quản lý phòng");
        pnlRoomMng.add(lblRoomMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 50));

        lblIconRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_room_30px.png"))); // NOI18N
        pnlRoomMng.add(lblIconRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        lblStatus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus1.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus1.setText("<<");
        pnlRoomMng.add(lblStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, 50));

        pnlMenu.add(pnlRoomMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 123, 250, -1));

        pnlWarehouseMng.setBackground(new java.awt.Color(69, 138, 184));
        pnlWarehouseMng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlWarehouseMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlWarehouseMngMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlWarehouseMngMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlWarehouseMngMouseExited(evt);
            }
        });
        pnlWarehouseMng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWarehouseMng.setBackground(new java.awt.Color(255, 255, 255));
        lblWarehouseMng.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblWarehouseMng.setForeground(new java.awt.Color(255, 255, 255));
        lblWarehouseMng.setText("Quản lý kho");
        pnlWarehouseMng.add(lblWarehouseMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 50));

        lblIconWarehouse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconWarehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_warehouse_30px.png"))); // NOI18N
        pnlWarehouseMng.add(lblIconWarehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        lblStatus2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus2.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus2.setText("<<");
        pnlWarehouseMng.add(lblStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, 50));

        pnlMenu.add(pnlWarehouseMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 172, 250, 50));

        pnlStatisticalMng.setBackground(new java.awt.Color(69, 138, 184));
        pnlStatisticalMng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlStatisticalMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlStatisticalMngMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlStatisticalMngMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlStatisticalMngMouseExited(evt);
            }
        });
        pnlStatisticalMng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStatisticalMng.setBackground(new java.awt.Color(255, 255, 255));
        lblStatisticalMng.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatisticalMng.setForeground(new java.awt.Color(255, 255, 255));
        lblStatisticalMng.setText("Quản lý thu chi");
        pnlStatisticalMng.add(lblStatisticalMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 50));

        lblIconStatistical.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconStatistical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_statistics_30px.png"))); // NOI18N
        pnlStatisticalMng.add(lblIconStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        lblStatus3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus3.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus3.setText("<<");
        pnlStatisticalMng.add(lblStatus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, 50));

        pnlMenu.add(pnlStatisticalMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 221, 250, 50));

        pnlEmployeeMng.setBackground(new java.awt.Color(69, 138, 184));
        pnlEmployeeMng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlEmployeeMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEmployeeMngMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEmployeeMngMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEmployeeMngMouseExited(evt);
            }
        });
        pnlEmployeeMng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmployeeMng.setBackground(new java.awt.Color(255, 255, 255));
        lblEmployeeMng.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeMng.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeMng.setText("Quản lý nhân viên");
        pnlEmployeeMng.add(lblEmployeeMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 50));

        lblIconStatistical2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconStatistical2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_statistics_30px.png"))); // NOI18N
        pnlEmployeeMng.add(lblIconStatistical2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        lblStatus4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus4.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus4.setText("<<");
        pnlEmployeeMng.add(lblStatus4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, 50));

        pnlMenu.add(pnlEmployeeMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 50));

        pnlPay.setBackground(new java.awt.Color(69, 138, 184));
        pnlPay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPayMouseExited(evt);
            }
        });

        lblEmployeeMng1.setBackground(new java.awt.Color(255, 255, 255));
        lblEmployeeMng1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeMng1.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeMng1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeMng1.setText("Thanh toán");

        javax.swing.GroupLayout pnlPayLayout = new javax.swing.GroupLayout(pnlPay);
        pnlPay.setLayout(pnlPayLayout);
        pnlPayLayout.setHorizontalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPayLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblEmployeeMng1)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlPayLayout.setVerticalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployeeMng1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnlMenu.add(pnlPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 410, 200, 45));

        pnlLogOut.setBackground(new java.awt.Color(69, 138, 184));
        pnlLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlLogOutMouseExited(evt);
            }
        });

        lblEmployeeMng2.setBackground(new java.awt.Color(255, 255, 255));
        lblEmployeeMng2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeMng2.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeMng2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeMng2.setText("Đăng xuất");

        javax.swing.GroupLayout pnlLogOutLayout = new javax.swing.GroupLayout(pnlLogOut);
        pnlLogOut.setLayout(pnlLogOutLayout);
        pnlLogOutLayout.setHorizontalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogOutLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblEmployeeMng2)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        pnlLogOutLayout.setVerticalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployeeMng2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnlMenu.add(pnlLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 470, 200, 45));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_microsoft_edge_35px.png"))); // NOI18N
        jLabel1.setText("LN Soft");
        pnlMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bg.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        pnlHead.setBackground(new java.awt.Color(69, 138, 184));
        pnlHead.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlHead.setForeground(new java.awt.Color(0, 153, 255));

        lblAccountName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAccountName.setForeground(new java.awt.Color(255, 255, 255));
        lblAccountName.setText("Account Name");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_test_account_30px.png"))); // NOI18N

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap(660, Short.MAX_VALUE)
                .addComponent(lblAccountName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bg.add(pnlHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 0, 802, -1));

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ifRoomMng.setVisible(true);
        ifRoomMng.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblListRoom.setAutoCreateRowSorter(true);
        tblListRoom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblListRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số Phòng", "Loại phòng", "Giá", "Tình Trạng", "Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblListRoom.setGridColor(new java.awt.Color(255, 255, 255));
        tblListRoom.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblListRoom.setRowHeight(25);
        tblListRoom.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tblListRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListRoomMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblListRoomMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblListRoom);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 770, 320));

        btnBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_bill_28px.png"))); // NOI18N
        btnBill.setText("Hóa đơn phòng");
        jPanel1.add(btnBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, -1, 30));

        btnBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_booking_28px.png"))); // NOI18N
        btnBooking.setText("Đặt phòng");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });
        jPanel1.add(btnBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 429, 140, 30));

        pnlHeadRoom.setBackground(new java.awt.Color(255, 255, 255));

        txtFind.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtFind.setPreferredSize(new java.awt.Dimension(7, 25));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setText("Quản Lý Phòng");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_remove_28px.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(61, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_refresh_28px.png"))); // NOI18N
        btnRefresh.setText("Reset");
        btnRefresh.setPreferredSize(new java.awt.Dimension(61, 30));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_find_user_male_28px.png"))); // NOI18N
        btnFind.setText("Tìm kiếm");
        btnFind.setPreferredSize(new java.awt.Dimension(61, 30));

        javax.swing.GroupLayout pnlHeadRoomLayout = new javax.swing.GroupLayout(pnlHeadRoom);
        pnlHeadRoom.setLayout(pnlHeadRoomLayout);
        pnlHeadRoomLayout.setHorizontalGroup(
            pnlHeadRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadRoomLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addGroup(pnlHeadRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlHeadRoomLayout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeadRoomLayout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlHeadRoomLayout.setVerticalGroup(
            pnlHeadRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadRoomLayout.createSequentialGroup()
                .addGroup(pnlHeadRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeadRoomLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadRoomLayout.createSequentialGroup()
                        .addGroup(pnlHeadRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlHeadRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlHeadRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 770, 90));

        ifRoomMng.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 470));

        jDesktopPane1.add(ifRoomMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 900, 500));

        ifWareHouseMng.setVisible(false);
        ifWareHouseMng.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlHeadRoom1.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeadRoom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle1.setText("Sản phẩm trong kho");
        pnlHeadRoom1.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cbxKhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxKhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        cbxKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả sản phẩm..", "Item 2", "Item 3", "Item 4" }));
        cbxKhoaHoc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlHeadRoom1.add(cbxKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 203, -1));

        txtFindS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFindS.setForeground(new java.awt.Color(102, 102, 102));
        txtFindS.setText("Từ khóa");
        txtFindS.setPreferredSize(new java.awt.Dimension(58, 27));
        pnlHeadRoom1.add(txtFindS, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 190, 28));

        btnFindS.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnFindS.setForeground(new java.awt.Color(102, 102, 102));
        btnFindS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_search_28px.png"))); // NOI18N
        btnFindS.setText("Tìm kiếm");
        pnlHeadRoom1.add(btnFindS, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 120, 30));

        btnDeleteS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_remove_28px.png"))); // NOI18N
        btnDeleteS.setText("Xóa");
        btnDeleteS.setPreferredSize(new java.awt.Dimension(61, 30));
        btnDeleteS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSActionPerformed(evt);
            }
        });
        pnlHeadRoom1.add(btnDeleteS, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 95, -1));

        btnLoads.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_reset_20px.png"))); // NOI18N
        btnLoads.setText("Load");
        btnLoads.setPreferredSize(new java.awt.Dimension(61, 30));
        btnLoads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadsActionPerformed(evt);
            }
        });
        pnlHeadRoom1.add(btnLoads, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 40, 95, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblService.setAutoCreateRowSorter(true);
        tblService.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DV", "Tên DV", "Giá DV", "Nhà CC", "Ảnh", "Người nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblService.setGridColor(new java.awt.Color(255, 255, 255));
        tblService.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblService.setRowHeight(25);
        tblService.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tblService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblServiceMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblService);

        btnBill1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_order_history_28px.png"))); // NOI18N
        btnBill1.setText("Danh sách hóa đơn DV");
        btnBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBill1ActionPerformed(evt);
            }
        });

        btnBooking1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBooking1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_export_28px.png"))); // NOI18N
        btnBooking1.setText("Xuất sản phẩm");
        btnBooking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooking1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHeadRoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBill1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBooking1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHeadRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        ifWareHouseMng.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        jDesktopPane1.add(ifWareHouseMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 900, 500));

        ifStaticticalMng.setVisible(false);
        ifStaticticalMng.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pnlTongDT.setBackground(new java.awt.Color(255, 255, 255));
        pnlTongDT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Tổng doanh thu");
        pnlTongDT.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_reset_20px.png"))); // NOI18N
        jButton2.setText("Tải lại");
        pnlTongDT.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 11, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_room_30px_1.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setText("Số phòng đã đặt");

        lblValueRoom.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblValueRoom.setText("Values");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValueRoom)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValueRoom)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnlTongDT.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 200, 240));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_food_30px.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setText("Số Dvu đã  bán");

        lblValueService.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblValueService.setText("Values");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValueService)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValueService)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnlTongDT.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 90, 200, 240));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_money_30px.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setText("Tổng tiền");

        lblMoney.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMoney.setText("Values");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoney)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMoney)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnlTongDT.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 200, 240));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "1", "2", "3"
            }
        ));
        jScrollPane3.setViewportView(tbl1);

        pnlTongDT.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 0, 10));

        jTabbedPane1.addTab("Tổng doanh thu", pnlTongDT);

        pnlDTPhong.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Doanh thu tiền phòng");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_reset_20px.png"))); // NOI18N
        jButton3.setText("Tải lại");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_room_30px_1.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setText("Số phòng đã đặt");

        lblRoom1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRoom1.setText("Values");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRoom1)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRoom1)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_money_30px.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setText("Doanh thu phòng");

        lblRoom2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRoom2.setText("Values");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoom2)
                            .addComponent(jLabel23))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRoom2)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_money_30px.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setText("Doanh thu TB");

        lblRoom3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRoom3.setText("Values");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoom3)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRoom3)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "1", "2", "3"
            }
        ));
        jScrollPane4.setViewportView(tbl2);

        javax.swing.GroupLayout pnlDTPhongLayout = new javax.swing.GroupLayout(pnlDTPhong);
        pnlDTPhong.setLayout(pnlDTPhongLayout);
        pnlDTPhongLayout.setHorizontalGroup(
            pnlDTPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDTPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 484, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(pnlDTPhongLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlDTPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDTPhongLayout.createSequentialGroup()
                    .addGap(0, 45, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 45, Short.MAX_VALUE)))
        );
        pnlDTPhongLayout.setVerticalGroup(
            pnlDTPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDTPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDTPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pnlDTPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDTPhongLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnlDTPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Doanh thu tiền phòng", pnlDTPhong);

        pnlDTsp.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Doanh thu sản phẩm");

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_reset_20px.png"))); // NOI18N
        jButton4.setText("Tải lại");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Tổng số bản ghi: ??");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_room_30px_1.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel28.setText("Số phòng đã đặt");

        lblService1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblService1.setText("Values");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblService1)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblService1)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_money_30px.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel30.setText("Doanh thu phòng");

        lblService2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblService2.setText("Values");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblService2)
                            .addComponent(jLabel29))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblService2)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_money_30px.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel32.setText("Doanh thu TB");

        lblService3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblService3.setText("Values");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addComponent(lblService3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblService3)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "1", "2", "3"
            }
        ));
        jScrollPane7.setViewportView(tbl3);

        javax.swing.GroupLayout pnlDTspLayout = new javax.swing.GroupLayout(pnlDTsp);
        pnlDTsp.setLayout(pnlDTspLayout);
        pnlDTspLayout.setHorizontalGroup(
            pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDTspLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDTspLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDTspLayout.createSequentialGroup()
                        .addGroup(pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDTspLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDTspLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton4)))
                .addContainerGap())
            .addGroup(pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDTspLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        pnlDTspLayout.setVerticalGroup(
            pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDTspLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap())
            .addGroup(pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDTspLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addGroup(pnlDTspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Doanh thu sản phẩm", pnlDTsp);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        ifStaticticalMng.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        jDesktopPane1.add(ifStaticticalMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 900, 500));

        ifEmployeeMng.setVisible(false);
        ifEmployeeMng.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblEmployee.setAutoCreateRowSorter(true);
        tblEmployee.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ Tên", "Ngày Sinh", "Số DT", "Địa Chỉ", "Chức Vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEmployee.setGridColor(new java.awt.Color(255, 255, 255));
        tblEmployee.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblEmployee.setRowHeight(25);
        tblEmployee.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEmployeeMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblEmployee);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 770, 350));

        pnlHeadRoom2.setBackground(new java.awt.Color(255, 255, 255));

        txtFind1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtFind1.setPreferredSize(new java.awt.Dimension(7, 25));

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle2.setText("Quản Lý Nhân Viên");

        btnAddEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_add_28px.png"))); // NOI18N
        btnAddEmp.setText("Thêm");
        btnAddEmp.setPreferredSize(new java.awt.Dimension(61, 30));
        btnAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpActionPerformed(evt);
            }
        });

        btnDeleteEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_remove_28px.png"))); // NOI18N
        btnDeleteEmp.setText("Xóa");
        btnDeleteEmp.setPreferredSize(new java.awt.Dimension(61, 30));
        btnDeleteEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteEmpMouseClicked(evt);
            }
        });
        btnDeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEmpActionPerformed(evt);
            }
        });

        btnFind1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/icons8_find_user_male_28px.png"))); // NOI18N
        btnFind1.setText("Tìm kiếm");
        btnFind1.setPreferredSize(new java.awt.Dimension(61, 30));

        javax.swing.GroupLayout pnlHeadRoom2Layout = new javax.swing.GroupLayout(pnlHeadRoom2);
        pnlHeadRoom2.setLayout(pnlHeadRoom2Layout);
        pnlHeadRoom2Layout.setHorizontalGroup(
            pnlHeadRoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadRoom2Layout.createSequentialGroup()
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addGroup(pnlHeadRoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlHeadRoom2Layout.createSequentialGroup()
                        .addComponent(txtFind1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeadRoom2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnDeleteEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlHeadRoom2Layout.setVerticalGroup(
            pnlHeadRoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadRoom2Layout.createSequentialGroup()
                .addGroup(pnlHeadRoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeadRoom2Layout.createSequentialGroup()
                        .addComponent(lblTitle2)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadRoom2Layout.createSequentialGroup()
                        .addGroup(pnlHeadRoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlHeadRoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFind1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(pnlHeadRoom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 770, 90));

        ifEmployeeMng.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 470));

        jDesktopPane1.add(ifEmployeeMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 900, 500));

        bg.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 56, 800, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Copyright © 2020");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 524, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("5.0.1");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 530, -1, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Copyright © 2020");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 524, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(69, 138, 184));
        jLabel10.setText("LNSOFT HOTEL");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 529, 120, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Phiên bản");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlRoomMngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoomMngMouseClicked
        resetStatus();
        lblStatus1.setText(">>");
//        lblRoomMng.setForeground(Color.decode("#97caff"));
        resetDisplay();
        ifRoomMng.setVisible(true);
    }//GEN-LAST:event_pnlRoomMngMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void pnlWarehouseMngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWarehouseMngMouseClicked
        resetStatus();
        lblStatus2.setText(">>");
//        lblWarehouseMng.setForeground(Color.decode("#97caff"));
        resetDisplay();
        ifWareHouseMng.setVisible(true);
    }//GEN-LAST:event_pnlWarehouseMngMouseClicked

    private void pnlStatisticalMngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatisticalMngMouseClicked
        resetStatus();
        lblStatus3.setText(">>");
//        lblStatisticalMng.setForeground(Color.decode("#97caff"));
        resetDisplay();
        ifStaticticalMng.setVisible(true);
    }//GEN-LAST:event_pnlStatisticalMngMouseClicked

    private void pnlRoomMngMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoomMngMouseEntered
        pnlRoomMng.setBackground(Color.decode("#5d93b7"));
    }//GEN-LAST:event_pnlRoomMngMouseEntered

    private void pnlRoomMngMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoomMngMouseExited
        pnlRoomMng.setBackground(Color.decode("#458AB8"));
    }//GEN-LAST:event_pnlRoomMngMouseExited

    private void pnlWarehouseMngMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWarehouseMngMouseEntered
        pnlWarehouseMng.setBackground(Color.decode("#5d93b7"));
    }//GEN-LAST:event_pnlWarehouseMngMouseEntered

    private void pnlWarehouseMngMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWarehouseMngMouseExited
        pnlWarehouseMng.setBackground(Color.decode("#458AB8"));
    }//GEN-LAST:event_pnlWarehouseMngMouseExited

    private void pnlStatisticalMngMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatisticalMngMouseEntered
        pnlStatisticalMng.setBackground(Color.decode("#5d93b7"));
    }//GEN-LAST:event_pnlStatisticalMngMouseEntered

    private void pnlStatisticalMngMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatisticalMngMouseExited
        pnlStatisticalMng.setBackground(Color.decode("#458AB8"));
    }//GEN-LAST:event_pnlStatisticalMngMouseExited

    private void pnlEmployeeMngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEmployeeMngMouseClicked
        if (Auth.isManager()) {
            resetStatus();
            lblStatus4.setText(">>");
//        lblRoomMng.setForeground(Color.decode("#97caff"));
            resetDisplay();
            ifEmployeeMng.setVisible(true);
        }else{
            MsgBox.alert(this, "Bạn không có quyền truy cập chức năng này!");
        }
        
    }//GEN-LAST:event_pnlEmployeeMngMouseClicked

    private void pnlEmployeeMngMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEmployeeMngMouseEntered
        pnlEmployeeMng.setBackground(Color.decode("#5d93b7"));
    }//GEN-LAST:event_pnlEmployeeMngMouseEntered

    private void pnlEmployeeMngMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEmployeeMngMouseExited
        pnlEmployeeMng.setBackground(Color.decode("#458AB8"));
    }//GEN-LAST:event_pnlEmployeeMngMouseExited

    private void btnAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpActionPerformed
        
        new signUpJdialog(new java.awt.Frame(), true).setVisible(true);
    }//GEN-LAST:event_btnAddEmpActionPerformed

    private void btnDeleteEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteEmpMouseClicked
        
    }//GEN-LAST:event_btnDeleteEmpMouseClicked

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        
        
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void mnuiShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiShowActionPerformed
        String manv = (String) tblEmployee.getValueAt(this.row, 0);
        u1 = nvDAO.selectByID(manv);
        employeeInfoJDialog form = new employeeInfoJDialog(new java.awt.Frame(), true, u1);
        form.setVisible(true);
        
    }//GEN-LAST:event_mnuiShowActionPerformed

    private void tblEmployeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMousePressed
        if (evt.getClickCount()==2) {
            jPopupMenu1.show(tblEmployee, evt.getX(), evt.getY());
            this.row = tblEmployee.rowAtPoint(evt.getPoint());
        }
    }//GEN-LAST:event_tblEmployeeMousePressed

    private void btnDeleteEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmpActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteEmpActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        callTable.callRoom(tblListRoom, this);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblListRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListRoomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListRoomMouseClicked

    private void tblListRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListRoomMousePressed
        if (evt.getClickCount()==2) {
            this.row2 = tblListRoom.rowAtPoint(evt.getPoint());
            int maPhong = (Integer) tblListRoom.getValueAt(this.row2, 0);
            room1 = roomDAO.selectByID(maPhong);
            roomJDialog formRoom = new roomJDialog(new java.awt.Frame(), true, room1);
            formRoom.setVisible(true);
        }
    }//GEN-LAST:event_tblListRoomMousePressed

    private void jPopupMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu2MouseClicked
        String maPhong = (String) tblEmployee.getValueAt(this.row2, 0);
        room1 = roomDAO.selectByID(maPhong);
        roomJDialog formRoom = new roomJDialog(new java.awt.Frame(), true, room1);
        formRoom.setVisible(true);
    }//GEN-LAST:event_jPopupMenu2MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        bookingJDialog dialog = new bookingJDialog(new java.awt.Frame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnBookingActionPerformed

    private void tblServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiceMousePressed
        if (evt.getClickCount()==2) {
            this.row3 = tblService.rowAtPoint(evt.getPoint());
            String maDV = (String) tblService.getValueAt(this.row3, 0);
            service = serviceDAO.selectByID(String.valueOf(maDV));
            addProductJDialog dialog = new addProductJDialog(new java.awt.Frame(), true, service);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_tblServiceMousePressed

    private void btnDeleteSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSActionPerformed
        deleteS();
    }//GEN-LAST:event_btnDeleteSActionPerformed

    private void btnLoadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadsActionPerformed
        callTable.callService(tblService, this);
    }//GEN-LAST:event_btnLoadsActionPerformed

    private void btnBooking1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooking1ActionPerformed
        productJDialog dialog = new productJDialog(new java.awt.Frame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnBooking1ActionPerformed

    private void btnBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBill1ActionPerformed
        listBillService dialog = new listBillService(new java.awt.Frame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnBill1ActionPerformed

    private void pnlPayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPayMouseEntered
        pnlPay.setBackground(Color.decode("#5d93b7"));
    }//GEN-LAST:event_pnlPayMouseEntered

    private void pnlPayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPayMouseExited
        pnlPay.setBackground(Color.decode("#458AB8"));
    }//GEN-LAST:event_pnlPayMouseExited

    private void pnlPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPayMouseClicked
        pay dialog = new pay(new java.awt.Frame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_pnlPayMouseClicked

    private void pnlLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogOutMouseClicked
        loginJDialog dialog = new loginJDialog(new java.awt.Frame(), true);
        Auth.user=null;
        this.dispose();
        dialog.setVisible(true);
    }//GEN-LAST:event_pnlLogOutMouseClicked

    private void pnlLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogOutMouseEntered
        pnlLogOut.setBackground(Color.decode("#5d93b7"));
    }//GEN-LAST:event_pnlLogOutMouseEntered

    private void pnlLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogOutMouseExited
        pnlLogOut.setBackground(Color.decode("#458AB8"));
    }//GEN-LAST:event_pnlLogOutMouseExited

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAddEmp;
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnBill1;
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnBooking1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteEmp;
    private javax.swing.JButton btnDeleteS;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFind1;
    private javax.swing.JButton btnFindS;
    private javax.swing.JButton btnLoads;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbxKhoaHoc;
    private javax.swing.JInternalFrame ifEmployeeMng;
    private javax.swing.JInternalFrame ifRoomMng;
    private javax.swing.JInternalFrame ifStaticticalMng;
    private javax.swing.JInternalFrame ifWareHouseMng;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccountName;
    private javax.swing.JLabel lblEmployeeMng;
    private javax.swing.JLabel lblEmployeeMng1;
    private javax.swing.JLabel lblEmployeeMng2;
    private javax.swing.JLabel lblIconRoom;
    private javax.swing.JLabel lblIconStatistical;
    private javax.swing.JLabel lblIconStatistical2;
    private javax.swing.JLabel lblIconWarehouse;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblRoom1;
    private javax.swing.JLabel lblRoom2;
    private javax.swing.JLabel lblRoom3;
    private javax.swing.JLabel lblRoomMng;
    private javax.swing.JLabel lblService1;
    private javax.swing.JLabel lblService2;
    private javax.swing.JLabel lblService3;
    private javax.swing.JLabel lblStatisticalMng;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JLabel lblStatus3;
    private javax.swing.JLabel lblStatus4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblValueRoom;
    private javax.swing.JLabel lblValueService;
    private javax.swing.JLabel lblWarehouseMng;
    private javax.swing.JMenuItem mnuiShow;
    private javax.swing.JPanel pnlDTPhong;
    private javax.swing.JPanel pnlDTsp;
    private javax.swing.JPanel pnlEmployeeMng;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlHeadRoom;
    private javax.swing.JPanel pnlHeadRoom1;
    private javax.swing.JPanel pnlHeadRoom2;
    private javax.swing.JPanel pnlLogOut;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPay;
    private javax.swing.JPanel pnlRoomMng;
    private javax.swing.JPanel pnlStatisticalMng;
    private javax.swing.JPanel pnlTongDT;
    private javax.swing.JPanel pnlWarehouseMng;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTable tbl3;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblListRoom;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFind1;
    private javax.swing.JTextField txtFindS;
    // End of variables declaration//GEN-END:variables
}
