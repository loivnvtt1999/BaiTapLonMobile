package com.example.ngdngtmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityChiTietDonHang extends AppCompatActivity {
    ListView lviChiTiet;
    Button btnDong;
    ArrayList<Mon> lstMon;
    ArrayList<String> lstHienThi;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_don_hang);
        lviChiTiet=(ListView)findViewById(R.id.lviChiTiet);
        btnDong=(Button)findViewById(R.id.btnDong);
        lstMon= new ArrayList<Mon>();
        Intent intent1=getIntent();
        Bundle bundle=intent1.getBundleExtra("donhangchitiet");
        DonHang dh=(DonHang) bundle.getSerializable("donhangchitietbundle");
        lstMon=dh.lstMonDaDat;
        lstHienThi= new ArrayList<String>();
        for(int i=0;i<lstMon.size();i++){
            String str="";
            str="Tên món: "+lstMon.get(i).tenMon+"\nSize: "+lstMon.get(i).size+"\nSố lượng: "+
                    lstMon.get(i).soLuongOrder+"\nĐơn giá: "+lstMon.get(i).donGia;
            lstHienThi.add(str);
        }
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lstHienThi);
        lviChiTiet.setAdapter(adapter);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}