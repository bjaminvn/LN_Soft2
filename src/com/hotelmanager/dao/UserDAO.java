/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.User;
import com.hotelmanager.utils.database;
import com.hotelmanager.utils.jdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longd
 */
public class UserDAO extends LNSoftDAO<User, String>{
    final String INSERT_SQL = "INSERT INTO NhanVien(MaNV,HoTen,NgaySinh,GioiTinh,DiaChi,SDT,ChucVu,MatKhau)"
            + " VALUES(?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhanVien SET HoTen=?,NgaySinh=?,GioiTinh=?,DiaChi=?,"
            + " SDT=?,ChucVu=?,MatKhau=? WHERE MaNV=?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL = "SELECT * FROM NhanVien";
    final String SELECT_BY_ID = "SELECT * FROM NhanVien WHERE MaNV=?";
    
    
    @Override
    public void insert(User entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaNV(), entity.getHoTen(),entity.getNgaySinh(),entity.getGioiTinh()
                            ,entity.getDiaChi(),entity.getSoDT(),entity.getChucVu(),entity.getMatKhau());
    }

    @Override
    public void update(User entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getHoTen(),entity.getNgaySinh(),entity.getGioiTinh()
                            ,entity.getDiaChi(),entity.getSoDT(),entity.getChucVu(),entity.getMatKhau(),entity.getMaNV());
    }

    public void delete(User id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<User> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public User selectByID(String id) {
        List<User> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);  
    }

    @Override
    public List<User> selectBySql(String sql, Object... args) {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                User entity = new User();
                entity.setHoTen(rs.getString("HoTen"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setChucVu(rs.getBoolean("ChucVu"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSoDT(rs.getString("SDT"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public User checkLogin(String manv, String matKhau) throws Exception{
        String sql = "select manv, matkhau, chucvu from nhanvien"
                + " where manv=? and MatKhau=?";
        try ( 
            Connection con = database.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);                
            ){
            pstm.setString(1, manv);
            pstm.setString(2, matKhau);
            try(ResultSet rs = pstm.executeQuery()){
                if (rs.next()) {
                    User nv = new User();
                    nv.setMaNV(rs.getString("manv"));
                    nv.setMatKhau(rs.getString("matkhau"));
                    nv.setChucVu(rs.getBoolean(6));
                    return nv;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
