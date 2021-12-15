/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.dao;

import com.hotelmanager.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longd
 */
public class StatisticalDAO {
    private List<Object[]> getListOfArray(String sql,String[] cols, Object... args){
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getDoanhThu(){
        String sql = "{CALL sp_DoanhThu}";
        String[] cols = {"SHDP","SHDDV","DoanhThu"};
        return getListOfArray(sql, cols);
    }
    
    public List<Object[]> getDoanhThuP(){
        String sql = "{CALL sp_DoanhThuP}";
        String[] cols = {"SHDP","DoanhThu","TB"};
        return getListOfArray(sql, cols);
    }
    
    public List<Object[]> getDoanhThuS(){
        String sql = "{CALL sp_DoanhThuS}";
        String[] cols = {"SoHDDV","DoanhThu","TB"};
        return getListOfArray(sql, cols);
    }
}
