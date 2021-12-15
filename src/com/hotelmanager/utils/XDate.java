/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author longd
 */
public class XDate {
    static SimpleDateFormat format = new SimpleDateFormat();
    public static Date toDate(String date, String pattent){
        try {
            format.applyPattern(pattent);
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static String toString(Date date, String pattent){
        format.applyPattern(pattent);
        return format.format(date);
    }
    public static Date addDate(Date date, long days){
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }

    public static Object toString(LocalDate ngayTao, String ddMMyyyy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static Date now() {
        return new Date();
    }
    public static java.sql.Date convertDate(String date, String pattern) {
        Date dateJava = XDate.toDate(date, pattern);
        java.sql.Date sqlDate = new java.sql.Date(dateJava.getTime());
        return sqlDate;
    }    
}
