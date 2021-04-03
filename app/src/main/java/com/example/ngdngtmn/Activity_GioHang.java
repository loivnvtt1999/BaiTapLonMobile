package com.example.ngdngtmn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Activity_GioHang extends AppCompatActivity {

    Button btnXoa, btnThanhToan, btnTiepTuc;
    ListView lviThanhToan;
    ArrayList<Mon> lstgiohangDoiThanhToan;
    ArrayList<String> lstHienThi;
    ArrayAdapter<String> adapter;
    int tomau = -1;
    String tenKhach;
    String maphatsinh;
    ArrayList<DonHang> lstDonHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__gio_hang);
        btnThanhToan=(Button)findViewById(R.id.btnThanhToan);
        btnTiepTuc=(Button)findViewById(R.id.btnTiepTuc);
        btnXoa=(Button)findViewById(R.id.btnXoaMon);
        lviThanhToan=(ListView)findViewById(R.id.lvMonGioHang);
        lstgiohangDoiThanhToan=new ArrayList<>();
        lstDonHang= new ArrayList<DonHang>();
        SharedPreferences preferences=getSharedPreferences("donhang1",MODE_PRIVATE);
        Gson gson= new Gson();
        String json=preferences.getString("donhangjson",null);
        if(json!=null){
            Type type= new TypeToken<ArrayList<DonHang>>(){}.getType();
            lstDonHang=gson.fromJson(json,type);
        }
        Intent intent=getIntent();
        Bundle bundle= intent.getBundleExtra("giohang");
        lstgiohangDoiThanhToan=(ArrayList<Mon>) bundle.getSerializable("giohangbundle");
        lstHienThi=new ArrayList<String>();
        Intent intent1=getIntent();
        tenKhach=intent1.getStringExtra("tenkhachhang1");
        for(int i=0;i<lstgiohangDoiThanhToan.size();i++){
            String str="";
            str="Tên món: "+lstgiohangDoiThanhToan.get(i).tenMon+"\nSize: "+lstgiohangDoiThanhToan.get(i).size+"\nSố lượng: "+
                    lstgiohangDoiThanhToan.get(i).soLuongOrder+"\nĐơn giá: "+lstgiohangDoiThanhToan.get(i).donGia;
            lstHienThi.add(str);
        }
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lstHienThi);
        lviThanhToan.setAdapter(adapter);
        lviThanhToan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getChildAt(i).setBackgroundColor(Color.CYAN);
                if (tomau != -1 && tomau != i){
                    adapterView.getChildAt(tomau).setBackgroundColor(Color.WHITE);
                }
                tomau = i;
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tomau==-1){
                    Toast.makeText(Activity_GioHang.this, "Vui lòng chọn món cần xóa", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(Activity_GioHang.this);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Bạn có muốn xóa món này không");
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //dialogInterface.dismiss();
                            lstgiohangDoiThanhToan.remove(tomau);
                            lstHienThi=new ArrayList<String>();
                            for(int j=0;j<lstgiohangDoiThanhToan.size();j++){
                                String str="";
                                str="Tên món: "+lstgiohangDoiThanhToan.get(j).tenMon+"\nSize: "+lstgiohangDoiThanhToan.get(j).size+"\nSố lượng: "+
                                       lstgiohangDoiThanhToan.get(j).soLuongOrder+"\nĐơn giá: "+lstgiohangDoiThanhToan.get(j).donGia;
                               lstHienThi.add(str);
                           }
                            adapter= new ArrayAdapter<String>(Activity_GioHang.this, android.R.layout.simple_list_item_1,lstHienThi);
                            lviThanhToan.setAdapter(adapter);
                            Toast.makeText(Activity_GioHang.this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                            lstHienThi=new ArrayList<String>();
                            tomau=-1;
                        }
                    });
                    builder.show();
                }
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lstgiohangDoiThanhToan.size()>0){
                    int stt=lstDonHang.size();
                    maphatsinh="DH"+stt;
                    DonHang dh= new DonHang();
                    dh.setLstMonDaDat(lstgiohangDoiThanhToan);
                    dh.setMaDonHang(maphatsinh);
                    dh.setTenKhachHang(tenKhach);
                    lstDonHang.add(dh);
                    SharedPreferences preferences= getApplicationContext().getSharedPreferences("donhang1",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    Gson gson= new Gson();
                    String json=gson.toJson(lstDonHang);
                    editor.putString("donhangjson",json);
                    editor.commit();
                    Toast.makeText(Activity_GioHang.this, "Đã lưu đơn hàng", Toast.LENGTH_SHORT).show();
                    Intent intent1= new Intent(Activity_GioHang.this,ActivityThanhToan.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(Activity_GioHang.this, "Giỏ hàng hiện chưa có món", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}