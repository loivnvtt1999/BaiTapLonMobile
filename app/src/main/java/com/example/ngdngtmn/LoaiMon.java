package com.example.ngdngtmn;

import java.io.Serializable;
import java.util.ArrayList;

public class LoaiMon implements Serializable {
    String maLoai, tenLoai;
    int hinhanh;
    ArrayList<Mon> lstMon;

    public LoaiMon(){
        lstMon= new ArrayList<Mon>();
    }
    public LoaiMon(String maLoai, String tenLoai, int hinhanh, ArrayList<Mon> lstMon)
    {
        //lstMon= new ArrayList<Mon>();
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.hinhanh = hinhanh;
        this.lstMon = lstMon;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public ArrayList<Mon> getLstMon() {
        return lstMon;
    }

    public void setLstMon(ArrayList<Mon> lstMon) {
        this.lstMon = lstMon;
    }
}
