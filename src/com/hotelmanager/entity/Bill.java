/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.entity;

/**
 *
 * @author longd
 */
public class Bill {
    private int MaHD;
    private String MaHDP;
    private String MaHDDV;
    private float TongTien;
    private String MaNV;
    private String MaKH;
    private boolean TinhTrang;

    public Bill() {
    }

    public Bill(int MaHD, String MaHDP, String MaHDDV, float TongTien, String MaNV, String MaKH, boolean TinhTrang) {
        this.MaHD = MaHD;
        this.MaHDP = MaHDP;
        this.MaHDDV = MaHDDV;
        this.TongTien = TongTien;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.TinhTrang = TinhTrang;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaHDP() {
        return MaHDP;
    }

    public void setMaHDP(String MaHDP) {
        this.MaHDP = MaHDP;
    }

    public String getMaHDDV() {
        return MaHDDV;
    }

    public void setMaHDDV(String MaHDDV) {
        this.MaHDDV = MaHDDV;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    
}

