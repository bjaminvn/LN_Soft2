/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.Room;
import com.hotelmanager.entity.User;
import com.hotelmanager.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longd
 */
public class RoomDAO extends LNSoftDAO<Room, String>{
    final String INSERT_SQL = "INSERT INTO Phong(SoPhong,LoaiPhong,GiaPhong,TinhTrang,Anh)"
            + " VALUES(?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Phong SET LoaiPhong=?,GiaPhong=?,TinhTrang=?,Anh=? "
            + "WHERE SoPhong=?";
    final String DELETE_SQL = "DELETE FROM Phong WHERE SoPhong=?";
    final String SELECT_ALL = "SELECT * FROM Phong";
    final String SELECT_BY_ID = "SELECT * FROM Phong WHERE SoPhong=?";
    final String SELECT_FLOOR = "SELECT * FROM Phong WHERE SoPhong between ? and ?";

    @Override
    public void insert(Room entity) {
        jdbcHelper.update(INSERT_SQL, entity.getSoPhong(),entity.getLoaiPhong(),entity.getGia(),
                            entity.getTinhTrang(),entity.getAnh());
    }

    @Override
    public void update(Room entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getLoaiPhong(),entity.getGia(),entity.getTinhTrang(),
                            entity.getAnh(),entity.getSoPhong());
    }

    
    public void delete(Integer id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Room> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    
    public Room selectByID(Integer id) {
        List<Room> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Room> selectBySql(String sql, Object... args) {
        List<Room> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Room entity = new Room();
                entity.setSoPhong(rs.getInt("SoPhong"));
                entity.setLoaiPhong(rs.getString("LoaiPhong"));
                entity.setGia(rs.getFloat("GiaPhong"));
                entity.setTinhTrang(rs.getString("TinhTrang"));
                entity.setAnh(rs.getString("Anh"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Room selectByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Room> selectFloor(int min,int max) {
        return selectBySql(SELECT_FLOOR, min, max);
    }
}
