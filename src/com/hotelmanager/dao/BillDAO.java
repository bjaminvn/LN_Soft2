/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.Bill;
import com.hotelmanager.entity.BillService;
import com.hotelmanager.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longd
 */
public class BillDAO extends LNSoftDAO<Bill, String>{
    final String INSERT_SQL = "INSERT INTO HoaDon(MaHDP,TongTien,MaNV,MaKH,TinhTrang)"
            + " VALUES(?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HoaDon SET MaHDP=?,MaHDDV=?,TongTien=?,MaNV=?,MaKH=?, TinhTrang=? "
            + "WHERE MaHD=?";
    final String DELETE_SQL = "DELETE FROM HoaDon WHERE MaHD=?";
    final String SELECT_ALL = "SELECT * FROM HoaDon";
    final String SELECT_BY_ID = "SELECT * FROM HoaDon WHERE MaHD=?";
    final String SELECT_BY_MAKH = "SELECT * FROM HoaDon WHERE MaKH=?";

    @Override
    public void insert(Bill entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaHDP(),  entity.getTongTien(), entity.getMaNV()
                            , entity.getMaKH(), entity.isTinhTrang());
    }

    @Override
    public void update(Bill entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getMaHDP(), entity.getMaHDDV(), entity.getTongTien(), entity.getMaNV()
                            , entity.getMaKH(), entity.isTinhTrang(), entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Bill> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public Bill selectByID(String id) {
        List<Bill> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Bill> selectBySql(String sql, Object... args) {
        List<Bill> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Bill entity = new Bill();
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setMaHDDV(rs.getString("MaHDDV"));
                entity.setMaHDP(rs.getString("MaHDP"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTongTien(rs.getFloat("TongTien"));
                entity.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public Bill selectByMaKH(String makh) {
        List<Bill> list = selectBySql(SELECT_BY_MAKH, makh);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
}
