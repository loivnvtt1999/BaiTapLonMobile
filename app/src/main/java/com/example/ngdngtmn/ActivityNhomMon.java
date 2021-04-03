package com.example.ngdngtmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityNhomMon extends AppCompatActivity {

    GridView gridNhomMon;
    TextView tvThongTin;
    CustomGridView adapterGridView;
    ArrayList<LoaiMon> lstLoaiMon;
    String tenKhach, maBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhom_mon);
        gridNhomMon=(GridView)findViewById(R.id.gridNhomMon);
        tvThongTin=(TextView)findViewById(R.id.tvXinChao);
        lstLoaiMon=new ArrayList<LoaiMon>();
        //Mon an vat
        ArrayList<Mon> lstMonAnVat= new ArrayList<Mon>();
        Mon banhtrangcuon= new Mon("MONAV001","Bánh tráng cuốn","Bánh tráng cuốn xoài, bò khô, trứng cút",
                20000,R.drawable.anvat_banhtrangcuon);
        Mon banhtrangtron= new Mon("MONAV002","Bánh tráng trộn","Bánh tráng trộn xoài, bò khô, trứng cút",
                20000,R.drawable.anvat_banhtrangtron);
        Mon cavienchien= new Mon("MONAV003","Cá viên chiên","cá viên chiên kèm dưa leo",
                15000,R.drawable.anvat_cavienchien);
        //Mon caviencom= new Mon("MONAV004","Cá viên cốm","cá viên chiên cốm kèm dưa leo",
                //18000,R.drawable.anvat_caviencom);
        //Mon chagio= new Mon("MONAV005","Chả giò","Chả giò chiên tôm, thịt, khoai môn",
                //15000,R.drawable.anvat_chagio);
        //Mon chatom= new Mon("MONAV006","Chả tôm","Chả tôm thịt kèm rau chấm",
                //18000,R.drawable.anvat_chatomthit);
        //Mon comchay= new Mon("MONAV007","Cơm cháy chà bông","Cơm cháy chà bông mỡ hành",
                //15000,R.drawable.anvat_comchay);
        lstMonAnVat.add(banhtrangcuon);
        lstMonAnVat.add(banhtrangtron);
        lstMonAnVat.add(cavienchien);
        //lstMonAnVat.add(caviencom);
        //lstMonAnVat.add(chagio);
        //lstMonAnVat.add(chatom);
        //lstMonAnVat.add(comchay);
        //Mon Banh mi
        ArrayList<Mon> lstBanhMi= new ArrayList<Mon>();
        Mon banhmibosua= new Mon("MONBM001","Bánh mì bơ sữa","bánh mì phủ bơ sữa thơm ngon",
                15000,R.drawable.banhmi_bosua);
        Mon banhmichabong= new Mon("MONBM002","Bánh mì chà bông","bánh mì kẹp chà bông thịt heo",
                15000,R.drawable.banhmi_chabong);
        Mon banhmichalua= new Mon("MONBM003","Bánh mì chả lụa","bánh mì chả lụa thịt heo",
                15000,R.drawable.banhmi_chalua);
        //Mon banhmiopla= new Mon("MONBM004","Bánh mì ốp la","bánh mì trứng chiên ốp la",
                //15000,R.drawable.banhmi_opla);
        //Mon banhmithitnguoi= new Mon("MONBM005","Bánh mì thịt nguội","bánh mì thịt nguội, pa tê",
                //15000,R.drawable.banhmi_thitnguoi);
        //Mon banhmixiumai= new Mon("MONBM006","Bánh mì xíu mại","bánh mì xíu mại (bao gồm 2 viên)",
                //17000,R.drawable.banhmi_xiumai);
        lstBanhMi.add(banhmibosua);
        lstBanhMi.add(banhmichabong);
        lstBanhMi.add(banhmichalua);
        //lstBanhMi.add(banhmiopla);
        //lstBanhMi.add(banhmithitnguoi);
        //lstBanhMi.add(banhmixiumai);
        //Mon Banh ngot
        ArrayList<Mon> lstBanhNgot= new ArrayList<Mon>();
        Mon banhsu= new Mon("MONBN001","Bánh su kem","Bánh su kem trứng, sữa tươi",20000,R.drawable.banhngot_banhsu);
        Mon banhtiramisu= new Mon("MONBN002","Bánh Tiramisu","Bánh Tiramisu Nhật Bản thơm ngon",22000,R.drawable.banhngot_tiramisu);
        Mon banhngothanquoc= new Mon("MONBN003","Bánh ngọt Hàn Quốc","Bánh ngọt hàn quốc kem dâu",25000,R.drawable.banhngot_koreacake);
        lstBanhNgot.add(banhsu);
        lstBanhNgot.add(banhtiramisu);
        lstBanhNgot.add(banhngothanquoc);
        //Mon Cafe
        ArrayList<Mon> lstCafe= new ArrayList<Mon>();
        //Mon cafesuanong= new Mon("MONCF001","Cà phê sữa nóng","Cà phê sữa pha nóng",20000,R.drawable.cafe_cafesuanong);
        Mon cafetrung= new Mon("MONCF002","Cà phê trứng","Cà phê trứng gà",40000,R.drawable.cafe_cafetrung);
        //Mon cafecapuchino= new Mon("MONCF003","Cà phê capuchino","Cà phê capuchino Ý",30000,R.drawable.cafe_capuchino);
        Mon cafedenda= new Mon("MONCF004","Cà phê đen đá","Cà phê đen thêm đá",18000,R.drawable.cafe_denda);
        //Mon cafedennong= new Mon("MONCF005","Cà phê đen nóng","Cà phê đen pha nóng",18000,R.drawable.cafe_dennong);
        Mon cafesuada= new Mon("MONCF006","Cà phê sữa đá","Cà phê sữa thêm đá",20000,R.drawable.cafe_suada);
        //lstCafe.add(cafesuanong);
        lstCafe.add(cafetrung);
        //lstCafe.add(cafecapuchino);
        lstCafe.add(cafedenda);
        //lstCafe.add(cafedennong);
        lstCafe.add(cafesuada);
        //Mon Chocolate
        ArrayList<Mon> lstChocolate= new ArrayList<Mon>();
        Mon chocalatedaxay= new Mon("MONSCL001","Socola đá xay","Sô cô la đá xay sữa tươi",28000,R.drawable.chocolate_daxay);
        Mon chocalatekemtuyet= new Mon("MONSCL002","Socola kem tuyết","Sô cô đá xay kèm kem tuyết vanila",32000,R.drawable.chocolate_kemtuyet);
        Mon chocalatenong= new Mon("MONSCL003","Socola nóng","Sô cô đá pha nóng",25000,R.drawable.chocolate_nong);
        lstChocolate.add(chocalatedaxay);
        lstChocolate.add(chocalatekemtuyet);
        lstChocolate.add(chocalatenong);
        //Mon Com
        ArrayList<Mon> lstCom= new ArrayList<Mon>();
        Mon comchienduongchau=new Mon("MONCOM001","Cơm chiên dương châu","Cơm chiên dương châu trứng, xúc xích, hải sản",25000,R.drawable.com_comchienduongchau);
        Mon comcuon=new Mon("MONCOM002","Cơm cuộn","Cơm cuộn rong biển",20000,R.drawable.com_comcuong);
        //Mon comga=new Mon("MONCOM003","Cơm gà","Cơm gà nướng",28000,R.drawable.com_comga);
        Mon comtam=new Mon("MONCOM004","Cơm tấm","Cơm tấm sườn nướng",30000,R.drawable.com_comtam);
        lstCom.add(comchienduongchau);
        lstCom.add(comcuon);
        //lstCom.add(comga);
        lstCom.add(comtam);
        //Mon Nuoc ep
        ArrayList<Mon> lstNuocEp= new ArrayList<Mon>();
        Mon nuocepcachua= new Mon("MONNE001","Nước ép cà chua","Nước ép cà chua tươi ngon",25000,R.drawable.nuocep_cachua);
        Mon nuocepcam= new Mon("MONNE002","Nước ép cam","Nước ép cam tươi ngon",30000,R.drawable.nuocep_cam);
        Mon nuocepcantay= new Mon("MONNE003","Nước ép cần tây","Nước ép cần tây tươi ngon",28000,R.drawable.nuocep_cantay);
        Mon nuocepcarot= new Mon("MONNE004","Nước ép cà rốt","Nước ép cần tây tươi ngon",35000,R.drawable.nuocep_carot);
        //Mon nuocepdua= new Mon("MONNE005","Nước ép dứa","Nước ép khóm tươi ngon",30000,R.drawable.nuocep_dua);
        //Mon nuocepoi= new Mon("MONNE006","Nước ép dứa","Nước ép khóm tươi ngon",30000,R.drawable.nuocep_nuocepoi);
        lstNuocEp.add(nuocepcachua);
        lstNuocEp.add(nuocepcam);
        lstNuocEp.add(nuocepcantay);
        lstNuocEp.add(nuocepcarot);
        //lstNuocEp.add(nuocepdua);
        //lstNuocEp.add(nuocepoi);
        //Mon Nuoc ngot
        ArrayList<Mon> lstNuocNgot= new ArrayList<Mon>();
        Mon nuocngotpepsi= new Mon("MONNN001","Pepsi","Pepsi lon 330ml",20000,R.drawable.nuocngot_pepsi);
        Mon nuocngotcoca= new Mon("MONNN002","Coca-cola","Coca-cola lon 330ml",20000,R.drawable.nuocngot_coca);
        Mon nuocngot7up=new Mon("MONNN003","7-Up","7-Up lon 330ml",20000,R.drawable.nuocngot_7up);
        lstNuocNgot.add(nuocngotpepsi);
        lstNuocNgot.add(nuocngotcoca);
        lstNuocNgot.add(nuocngot7up);
        //Mon Sinh to
        ArrayList<Mon> lstSinhTo= new ArrayList<Mon>();
        Mon sinhtobo= new Mon("MONST001","Sinh tố bơ","Sinh tố bơ sữa",35000,R.drawable.sinhto_bo);
        Mon sinhtochuoi= new Mon("MONST002","Sinh tố chuối","Sinh tố chuối sữa",35000,R.drawable.sinhto_chuoi);
        Mon sinhtodua= new Mon("MONST003","Sinh tố dứa","Sinh tố dứa sữa",35000,R.drawable.sinhto_dua);
        Mon sinhtomangcau= new Mon("MONST004","Sinh tố mãng cầu","Sinh tố mãng cầu sữa",35000,R.drawable.sinhto_mangcau);
        //Mon sinhtoxoai= new Mon("MONST005","Sinh tố xoài","Sinh tố xoài sữa",35000,R.drawable.sinhto_xoai);
        lstSinhTo.add(sinhtobo);
        lstSinhTo.add(sinhtochuoi);
        lstSinhTo.add(sinhtodua);
        lstSinhTo.add(sinhtomangcau);
        //lstSinhTo.add(sinhtoxoai);
        //Mon Tra
        ArrayList<Mon> lstTra= new ArrayList<Mon>();
        Mon trabacha= new Mon("MONTRA001","Trà bạc hà","Trà xanh bạc hà thái nguyên",20000,R.drawable.tra_bacha);
        Mon tragung= new Mon("MONTRA002","Trà gừng","Trà gừng pha nóng",20000,R.drawable.tra_gung);
        Mon tralipton= new Mon("MONTRA003","Trà lipton","Trà túi lipton nhãn vàng",20000,R.drawable.tra_lipton);
        //Mon trahoacuc= new Mon("MONTRA004","Trà hoa cúc","Trà hoa cúc pha nóng",20000,R.drawable.tra_hoacuc);
        lstTra.add(trabacha);
        lstTra.add(tragung);
        lstTra.add(tralipton);
        //lstTra.add(trahoacuc);
        //Mon Tra sua
        ArrayList<Mon> lstTraSua= new ArrayList<Mon>();
        Mon trasuaduongden= new Mon("MONTS001","Sữa tươi đường đen","Sữa tươi trân châu đường đen",28000,R.drawable.trasua_duongden);
        Mon trasuamatcha= new Mon("MONTS002","Trà sữa matcha","Trà sữa matcha trân châu",22000,R.drawable.trasua_matcha);
        Mon trasuasamdua= new Mon("MONTS003","Trà sữa sâm dứa","Trà sữa sâm dứa trân châu",25000,R.drawable.trasua_samdua);
        Mon trasuathaixanh= new Mon("MONTS004","Trà sữa thái xanh","Trà sữa thái xanh trân châu",20000,R.drawable.trasua_thaixanh);
        //Mon trasuachantrau= new Mon("MONTS005","Trà sữa trân châu","Trà sữa trân châu thường",18000,R.drawable.trasua_tranchau);
        lstTraSua.add(trasuaduongden);
        lstTraSua.add(trasuamatcha);
        lstTraSua.add(trasuasamdua);
        lstTraSua.add(trasuathaixanh);
        //lstTraSua.add(trasuachantrau);
        LoaiMon AnVat= new LoaiMon("001","Ăn vặt",R.drawable.anvat,new ArrayList<Mon>());
        AnVat.setLstMon(lstMonAnVat);
        LoaiMon BanhMi= new LoaiMon("002","Bánh mì",R.drawable.banhmi,new ArrayList<Mon>());
        BanhMi.setLstMon(lstBanhMi);
        LoaiMon BanhNgot= new LoaiMon("003","Bánh ngọt",R.drawable.banhngot,new ArrayList<Mon>());
        BanhNgot.setLstMon(lstBanhNgot);
        LoaiMon Cafe= new LoaiMon("004","Cà phê",R.drawable.cafe,new ArrayList<Mon>());
        Cafe.setLstMon(lstCafe);
        LoaiMon Chocolate= new LoaiMon("005","Chocolate",R.drawable.chocolate,new ArrayList<Mon>());
        Chocolate.setLstMon(lstChocolate);
        LoaiMon Com= new LoaiMon("006","Cơm",R.drawable.com,new ArrayList<Mon>());
        Com.setLstMon(lstCom);
        LoaiMon NuocEp= new LoaiMon("007","Nước ép",R.drawable.nuocep,new ArrayList<Mon>());
        NuocEp.setLstMon(lstNuocEp);
        LoaiMon NuocNgot= new LoaiMon("008","Nước ngọt",R.drawable.nuocngot,new ArrayList<Mon>());
        NuocNgot.setLstMon(lstNuocNgot);
        LoaiMon SinhTo= new LoaiMon("009","Sinh tố",R.drawable.sinhto,new ArrayList<Mon>());
        SinhTo.setLstMon(lstSinhTo);
        LoaiMon Tra= new LoaiMon("010","Trà",R.drawable.tra,new ArrayList<Mon>());
        Tra.setLstMon(lstTra);
        LoaiMon TraSua= new LoaiMon("011","Trà sữa",R.drawable.trasua,new ArrayList<Mon>());
        TraSua.setLstMon(lstTraSua);
        lstLoaiMon.add(AnVat);
        lstLoaiMon.add(BanhMi);
        lstLoaiMon.add(BanhNgot);
        lstLoaiMon.add(Cafe);
        lstLoaiMon.add(Chocolate);
        lstLoaiMon.add(Com);
        lstLoaiMon.add(NuocEp);
        lstLoaiMon.add(NuocNgot);
        lstLoaiMon.add(SinhTo);
        lstLoaiMon.add(Tra);
        lstLoaiMon.add(TraSua);
        adapterGridView= new CustomGridView(this,R.layout.custom_gridview,lstLoaiMon);
        gridNhomMon.setAdapter(adapterGridView);
        Intent intent=getIntent();
        tenKhach=intent.getExtras().getString("KhachHang");
        maBan=intent.getExtras().getString("MaBan");
        tvThongTin.setText("KÍNH CHÀO: "+tenKhach+"\t MÃ BÀN: "+maBan);
        gridNhomMon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LoaiMon loaiMon= lstLoaiMon.get(i);
                Intent intent1= new Intent(ActivityNhomMon.this,ActivityMonTheoNhomMon.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("LoaiMon",loaiMon);
                intent1.putExtra("tenkhachhang",tenKhach);
                intent1.putExtra("LoaiMonPick",bundle);
                startActivity(intent1);
            }
        });
    }
}