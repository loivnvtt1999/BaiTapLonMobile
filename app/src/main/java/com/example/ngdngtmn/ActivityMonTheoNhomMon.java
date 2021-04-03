package com.example.ngdngtmn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityMonTheoNhomMon extends AppCompatActivity {

    TextView tvThongTinLoaiMon;
    Button btnGioHang;
    ListView lvMon;
    ArrayList<Mon> lstMon;
    CustomListView customListView;
    ArrayList<Mon> lstMonOrder;
    ArrayList<Mon> lstGioHang;
    String tenKhach;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999&&resultCode==RESULT_OK){
            Bundle bundle=data.getBundleExtra("mondadat");
            Mon mondadat=(Mon)bundle.getSerializable("mondadatbundle");
            lstGioHang.add(mondadat);
            btnGioHang.setText("Giỏ hàng: "+lstGioHang.size());
            //Toast.makeText(this, String.valueOf(""+lstGioHang.size()), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_theo_nhom_mon);
        tvThongTinLoaiMon=(TextView)findViewById(R.id.tvNganhHang);
        btnGioHang=(Button)findViewById(R.id.btnGioHang);
        lvMon=(ListView)findViewById(R.id.listMonTheoNhomMon);
        Intent intent=getIntent();
        final Bundle bundle=intent.getBundleExtra("LoaiMonPick");
        tenKhach=intent.getExtras().getString("tenkhachhang");
        LoaiMon loaiMon=(LoaiMon) bundle.getSerializable("LoaiMon");
        lstMon=new ArrayList<Mon>();
        lstGioHang= new ArrayList<Mon>();
        lstMonOrder= new ArrayList<Mon>();
        lstMon=loaiMon.lstMon;
        customListView= new CustomListView(this,R.layout.activity_mon_theo_nhom_mon,lstMon);
        lvMon.setAdapter(customListView);
        tvThongTinLoaiMon.setText("Loại món ăn: "+loaiMon.tenLoai);
        lvMon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Mon mon=lstMon.get(i);
                Intent intent1= new Intent(ActivityMonTheoNhomMon.this,ChiTietMon.class);
                Bundle bundle1= new Bundle();
                bundle1.putSerializable("MonDatBundle",mon);
                intent1.putExtra("MonDat",bundle1);
                startActivityForResult(intent1,999);
            }
        });
        btnGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lstGioHang.size()>0){
                Intent intent1= new Intent(ActivityMonTheoNhomMon.this,Activity_GioHang.class);
                Bundle bundle1=new Bundle();
                bundle1.putSerializable("giohangbundle",lstGioHang);
                intent1.putExtra("tenkhachhang1",tenKhach);
                intent1.putExtra("giohang",bundle1);
                startActivity(intent1);
                }
                else{
                    Toast.makeText(ActivityMonTheoNhomMon.this, "Giỏ hàng chưa có", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}