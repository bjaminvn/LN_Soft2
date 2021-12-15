/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.entity.Service;
import com.hotelmanager.utils.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author longd
 */
public class ServiceDAO extends LNSoftDAO<Service, String>{
    final String INSERT_SQL = "INSERT INTO DichVu(MaDV,TenDV,GiaDV,NhaCC,Anh,MaNV)"
            + " VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE DichVu SET TenDV=?,GiaDV=?,NhaCC=?,Anh=?, MaNV=? WHERE MADV=? ";
    final String DELETE_SQL = "DELETE FROM DichVu WHERE MADV=?";
    final String SELECT_ALL = "SELECT * FROM DichVu";
    final String SELECT_BY_ID = "SELECT * FROM DichVu WHERE MADV=?";
    final String SELECT_BY_NAME = "SELECT * FROM DichVu WHERE TenDV=?";

    @Override
    public void insert(Service entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaDV(),entity.getTenDV(),entity.getGiaDV()
                            ,entity.getNhaCC(),entity.getAnh(), entity.getMaNV());
    }

    @Override
    public void update(Service entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenDV(),entity.getGiaDV()
                            ,entity.getNhaCC(),entity.getAnh(), entity.getMaNV(),entity.getMaDV());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Service> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public Service selectByID(String id) {
        List<Service> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Service> selectBySql(String sql, Object... args) {
        List<Service> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Service entity = new Service();
                entity.setMaDV(rs.getString("MaDV"));
                entity.setTenDV(rs.getString("TenDV"));
                entity.setGiaDV(rs.getFloat("GiaDV"));
                entity.setNhaCC(rs.getString("NhaCC"));
                entity.setAnh(rs.getString("Anh"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
    public Service selectByName(String namePro) {
        List<Service> list = selectBySql(SELECT_BY_NAME, namePro);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
