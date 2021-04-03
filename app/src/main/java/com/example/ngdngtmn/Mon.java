package com.example.ngdngtmn;

import java.io.Serializable;

public class Mon implements Serializable
{
    String maMon, tenMon, moTa, size;
    double donGia;
    int hinhanh,soLuongOrder;

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoLuongOrder() {
        return soLuongOrder;
    }

    public void setSoLuongOrder(int soLuongOrder) {
        this.soLuongOrder = soLuongOrder;
    }

    public Mon(String maMon, String tenMon, String moTa, double donGia, int hinhanh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.moTa = moTa;
        this.donGia = donGia;
        this.hinhanh = hinhanh;
        this.size="";
        this.soLuongOrder=0;
    }
}
