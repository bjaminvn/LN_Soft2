/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.entity;

import java.util.Date;

/**
 *
 * @author longd
 */
public class BillRoom {
    private String maHDP;
    private int soPhong;
    private Date ngayDen;
    private Date ngayDi;
    private float tongtien;
    private String maKH;
    private String maNV;

    public BillRoom() {
    }

    public BillRoom(String maHDP, int soPhong, Date ngayDen, Date ngayDi, float tongtien, String maKH, String maNV) {
        this.maHDP = maHDP;
        this.soPhong = soPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.tongtien = tongtien;
        this.maKH = maKH;
        this.maNV = maNV;
    }

    public String getMaHDP() {
        return maHDP;
    }

    public void setMaHDP(String maHDP) {
        this.maHDP = maHDP;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
    
}
