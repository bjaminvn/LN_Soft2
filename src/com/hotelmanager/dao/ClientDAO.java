/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.Client;
import com.hotelmanager.entity.User;
import com.hotelmanager.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longd
 */
public class ClientDAO extends LNSoftDAO<Client, String>{
    final String INSERT_SQL = "INSERT INTO KhachHang(MaKH,TenKH,NgaySinh,GioiTinh,SoDT,SoCMT)"
            + " VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhachHang SET TenKH=?,NgaySinh=?,GioiTinh=?,SoDT=?,"
            + " SoCMT=? WHERE MaKH=?";
    final String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH=?";
    final String SELECT_ALL = "SELECT * FROM KhachHang";
    final String SELECT_BY_ID = "SELECT * FROM KhachHang WHERE MaKH=?";

    @Override
    public void insert(Client entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaKH(), entity.getTenKH(), entity.getNgaySinh(),
                            entity.getGioiTinh(),entity.getSoDT(), entity.getCmt());
    }

    @Override
    public void update(Client entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenKH(), entity.getNgaySinh(),
                            entity.getGioiTinh(),entity.getSoDT(), entity.getCmt(), entity.getMaKH());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Client> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public Client selectByID(String id) {
        List<Client> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Client> selectBySql(String sql, Object... args) {
        List<Client> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Client entity = new Client();
                entity.setMaKH(rs.getString("MaKH"));
                entity.setTenKH(rs.getString("TenKH"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSoDT(rs.getString("SoDT"));
                entity.setCmt(rs.getString("SoCMT"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
