package com.example.ngdngtmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ActivityThanhToan extends AppCompatActivity {

    Button btnTimKiem, btnHoanTat;
    ListView lviXemLai;
    ArrayList<String> lstHienThi;
    ArrayAdapter<String> adapter;
    ArrayList<DonHang> lstDonHang;
    EditText edtTimKiem;
    ArrayList<DonHang> lstDonHangTimKiem;
    int vitriclick=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        btnTimKiem=(Button)findViewById(R.id.btnTimKiem);
        btnHoanTat=(Button)findViewById(R.id.btnDatLai);
        lviXemLai=(ListView)findViewById(R.id.lvTimKiem);
        lstDonHang= new ArrayList<DonHang>();
        lstHienThi= new ArrayList<String>();
        lstDonHangTimKiem=new ArrayList<DonHang>();
        edtTimKiem=(EditText)findViewById(R.id.edtTimKiem);
        SharedPreferences preferences=getSharedPreferences("donhang1",MODE_PRIVATE);
        Gson gson= new Gson();
        String json=preferences.getString("donhangjson",null);
        if(json!=null){
            Type type= new TypeToken<ArrayList<DonHang>>(){}.getType();
            lstDonHang=gson.fromJson(json,type);
        }
        adapter= new ArrayAdapter<String>(ActivityThanhToan.this,android.R.layout.simple_list_item_1,lstHienThi);
        lviXemLai.setAdapter(adapter);
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lstDonHang.size()>0){
                    lstHienThi= new ArrayList<String>();
                    lstDonHangTimKiem= new ArrayList<DonHang>();
                    for(int i=0;i<lstDonHang.size();i++){
                       if(lstDonHang.get(i).tenKhachHang.equalsIgnoreCase(edtTimKiem.getText().toString().trim())){
                           String str="";
                           str="Mã đơn hàng:"+lstDonHang.get(i).maDonHang+"\nTên khách hàng: "+lstDonHang.get(i).tenKhachHang+
                                   "\nSố lượng món: "+lstDonHang.get(i).lstMonDaDat.size()+"\nTổng thành tiền: "+lstDonHang.get(i).thanhtien();
                           lstHienThi.add(str);
                           lstDonHangTimKiem.add(lstDonHang.get(i));
                       }
                    }
                    if(lstHienThi.size()>0){
                        adapter= new ArrayAdapter<String>(ActivityThanhToan.this,android.R.layout.simple_list_item_1,lstHienThi);
                        lviXemLai.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(ActivityThanhToan.this, "Không tìm thấy đơn hàng", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(ActivityThanhToan.this, "Chưa có đơn hàng", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHoanTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(ActivityThanhToan.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        lviXemLai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitriclick=i;
                DonHang dh= new DonHang();
                dh=lstDonHangTimKiem.get(vitriclick);
                vitriclick=-1;
                Intent intent1= new Intent(ActivityThanhToan.this,ActivityChiTietDonHang.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("donhangchitietbundle",dh);
                intent1.putExtra("donhangchitiet",bundle);
                startActivity(intent1);
            }
        });
    }
}