package com.example.ngdngtmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtKhachHang, edtMaBan;
    Button btnGoiMon,btnXoa;
    ImageView imglogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtKhachHang=(EditText)findViewById(R.id.edtTenKhachHang);
        edtMaBan=(EditText)findViewById(R.id.edtMaSoBan);
        btnGoiMon=(Button)findViewById(R.id.btnGoiMon);
        imglogo=(ImageView)findViewById(R.id.imgBanner);
        imglogo.setImageResource(R.drawable.logo);
        btnXoa=(Button)findViewById(R.id.btnXoa);
        btnGoiMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtKhachHang.getText().toString().length()>0&&edtMaBan.getText().toString().length()>0) {
                    Intent intent = new Intent(MainActivity.this, ActivityNhomMon.class);
                    intent.putExtra("KhachHang", edtKhachHang.getText().toString());
                    intent.putExtra("MaBan", edtMaBan.getText().toString());
                    startActivityForResult(intent, 999);
                }
                else{
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=getSharedPreferences("donhang1",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this, "Đã xóa toàn bộ đơn hàng", Toast.LENGTH_SHORT).show();
            }
        });
    }
}