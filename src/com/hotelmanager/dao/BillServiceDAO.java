/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.BillService;
import com.hotelmanager.utils.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author longd
 */
public class BillServiceDAO extends LNSoftDAO<BillService, String>{
    final String INSERT_SQL = "INSERT INTO HoaDonDV(MaHDDV,MaDV,TongTien,GhiChu,MaKH,MaNV)"
            + " VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HoaDonDV SET MaDV=?,TongTien=?,GhiChu=?,MaKH=?,MaNV=? "
            + "WHERE MaHDDV=?";
    final String DELETE_SQL = "DELETE FROM HoaDonDV WHERE MaHDDV=?";
    final String SELECT_ALL = "SELECT * FROM HoaDonDV";
    final String SELECT_BY_ID = "SELECT * FROM HoaDonDV WHERE MaHDDV=?";

    @Override
    public void insert(BillService entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaHDDV(), entity.getMaDV(), entity.getTongTien()
                            ,entity.getGhiChu(), entity.getMaKH(), entity.getMaNV());
    }

    @Override
    public void update(BillService entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillService> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public BillService selectByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillService> selectBySql(String sql, Object... args) {
        List<BillService> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                BillService entity = new BillService();
                entity.setMaHDDV(rs.getString("MaHDDV"));
                entity.setMaDV(rs.getString("MaDV"));
                entity.setTongTien(rs.getFloat("TongTien"));
                entity.setGhiChu(rs.getString("GhiChu"));
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
