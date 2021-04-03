package com.example.ngdngtmn;

import java.io.Serializable;
import java.util.ArrayList;

public class DonHang implements Serializable {
    String maDonHang, tenKhachHang;
    ArrayList<Mon> lstMonDaDat;
    public DonHang() {
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public ArrayList<Mon> getLstMonDaDat() {
        return lstMonDaDat;
    }

    public void setLstMonDaDat(ArrayList<Mon> lstMonDaDat) {
        this.lstMonDaDat = lstMonDaDat;
    }
    public double thanhtien(){
        double thanhtien=0;
        for(int i=0;i<lstMonDaDat.size();i++){
            thanhtien+=lstMonDaDat.get(i).donGia*(1.0)*lstMonDaDat.get(i).soLuongOrder;
        }
        return thanhtien;
    }
}
