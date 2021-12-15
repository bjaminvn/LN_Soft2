/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.entity;

/**
 *
 * @author longd
 */
public class BillService {
    private String MaHDDV;
    private String MaDV;
    private float TongTien;
    private String GhiChu;
    private String MaKH;
    private String MaNV;

    public BillService() {
    }

    public BillService(String MaHDDV, String MaDV, float TongTien, String GhiChu, String MaKH, String MaNV) {
        this.MaHDDV = MaHDDV;
        this.MaDV = MaDV;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }

    public String getMaHDDV() {
        return MaHDDV;
    }

    public void setMaHDDV(String MaHDDV) {
        this.MaHDDV = MaHDDV;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    
}
