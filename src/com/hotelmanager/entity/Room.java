/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.entity;

/**
 *
 * @author longd
 */
public class Room {
    private int soPhong;
    private String loaiPhong;
    private float gia;
    private String tinhTrang;
    private String anh;

    @Override
    public String toString() {
        return String.valueOf(this.soPhong); 
    }
    
    public Room() {
    }

    public Room(int soPhong, String loaiPhong, float gia, String tinhTrang, String anh) {
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.anh = anh;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
