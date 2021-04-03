package com.example.ngdngtmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChiTietMon extends AppCompatActivity {

    TextView tvTenMon, tvMoTa, tvDonGia, tvTamTinh;
    Button btnDatMon,btnHuy, btnDongY;
    ImageView imgAnhMonDat;
    Spinner spinSize;
    EditText edtSoLuong;
    ArrayList<String> lstSize;
    double giatheosize;
    Mon mondat;
    ArrayAdapter<String>adapterSpinner;
    //int vitrispinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon);
        tvTenMon=(TextView)findViewById(R.id.tvNoiDungTenMon);
        tvMoTa=(TextView)findViewById(R.id.tvNoiDungMoTa);
        tvDonGia=(TextView)findViewById(R.id.tvNoiDungDonGia);
        tvTamTinh=(TextView)findViewById(R.id.tvNoiDungTamTinh);
        btnDatMon=(Button)findViewById(R.id.btnDatMon);
        btnDongY=(Button)findViewById(R.id.btnSubmit);
        btnHuy=(Button)findViewById(R.id.btnReset);
        btnDatMon.setEnabled(false);
        imgAnhMonDat=(ImageView)findViewById(R.id.imgAnhMonDat);
        spinSize=(Spinner)findViewById(R.id.spinSize);
        edtSoLuong=(EditText)findViewById(R.id.edtSoLuong);
        lstSize=new ArrayList<String>();
        lstSize.add("Nhỏ");
        lstSize.add("Vừa");
        lstSize.add("Lớn");
        adapterSpinner=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,lstSize);
        spinSize.setAdapter(adapterSpinner);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras().getBundle("MonDat");
        mondat= (Mon)bundle.getSerializable("MonDatBundle");
        giatheosize=mondat.donGia;
        tvTenMon.setText(mondat.tenMon);
        tvMoTa.setText(mondat.moTa);
        tvDonGia.setText(String.valueOf(""+mondat.donGia)+"\t\t\t 1 phần");
        imgAnhMonDat.setImageResource(mondat.hinhanh);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSoLuong.getText().length()>0 && Integer.parseInt(edtSoLuong.getText().toString())>0){
                double thanhtien=giatheosize*Integer.parseInt(edtSoLuong.getText().toString());
                tvTamTinh.setText(String.valueOf(thanhtien));
                edtSoLuong.setEnabled(false);
                spinSize.setEnabled(false);
                btnDatMon.setEnabled(true);
                btnDongY.setEnabled(false);
                }
                else{
                    Toast.makeText(ChiTietMon.this, "Vui lòng nhập đúng số lượng", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSoLuong.setEnabled(true);
                spinSize.setEnabled(true);
                btnDatMon.setEnabled(false);
                btnDongY.setEnabled(true);
                edtSoLuong.setText("1");
                tvDonGia.setText(String.valueOf(""+mondat.donGia)+"\t\t\t 1 phần");
                spinSize.setSelection(0);
                tvTamTinh.setText("");
            }
        });
        spinSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String size=lstSize.get(i);
                //vitrispinner=adapterView.getSelectedItemPosition();
                if(size.equals("Nhỏ")){
                    giatheosize=mondat.donGia;
                    tvDonGia.setText(String.valueOf(""+giatheosize)+"\t\t\t 1 phần");
                    //Kiem tra loi
                }
                else if(size.equals("Vừa")){
                    giatheosize=mondat.donGia+mondat.donGia*0.2;
                    tvDonGia.setText(String.valueOf(""+giatheosize)+"\t\t\t 1 phần");
                    //Kiem tra loi
                }
                else{
                    giatheosize=mondat.donGia+mondat.donGia*0.5;
                    tvDonGia.setText(String.valueOf(""+giatheosize)+"\t\t\t 1 phần");
                    //Kiem tra loi
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        btnDatMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mondat.setDonGia(giatheosize);
                mondat.setSoLuongOrder(Integer.parseInt(edtSoLuong.getText().toString()));
                //vitrispinner=spinSize.getSelectedItemPosition();
                int vitri=spinSize.getSelectedItemPosition();
                mondat.setSize(lstSize.get(vitri).toString().trim());
                //mondat.setSoLuongOrder(Integer.parseInt(edtSoLuong.getText().toString()));
                Intent intent1=new Intent();
                Bundle bundle1= new Bundle();
                bundle1.putSerializable("mondadatbundle",mondat);
                intent1.putExtra("mondadat",bundle1);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }
}