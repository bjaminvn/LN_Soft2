/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.BillRoom;
import com.hotelmanager.utils.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author longd
 */
public class BillRoomDAO extends LNSoftDAO<BillRoom, String>{
    final String INSERT_SQL = "INSERT INTO HoaDonPhong(MaHDP,SoPhong,NgayDen,NgayDi,TongTien,MaKH,MaNV)"
            + " VALUES(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HoaDonPhong SET LoaiPhong=?,GiaPhong=?,Anh=? "
            + "WHERE MaHDP=?";
    final String DELETE_SQL = "DELETE FROM HoaDonPhong WHERE MaHDP=?";
    final String SELECT_ALL = "SELECT * FROM HoaDonPhong";
    final String SELECT_BY_ID = "SELECT * FROM Phong WHERE MaHDP=?";

    @Override
    public void insert(BillRoom entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaHDP(), entity.getSoPhong(), entity.getNgayDen()
                            , entity.getNgayDi(), entity.getTongtien(), entity.getMaKH(), entity.getMaNV());
    }

    @Override
    public void update(BillRoom entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillRoom> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public BillRoom selectByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillRoom> selectBySql(String sql, Object... args) {
        List<BillRoom> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                BillRoom entity = new BillRoom();
                entity.setMaHDP(rs.getString("MaHDP"));
                entity.setSoPhong(rs.getInt("SoPhong"));
                entity.setNgayDen(rs.getDate("NgayDen"));
                entity.setNgayDi(rs.getDate("NgayDi"));
                entity.setTongtien(rs.getFloat("TongTien"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
