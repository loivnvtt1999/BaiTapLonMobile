package com.example.ngdngtmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomListView extends ArrayAdapter<Mon> {
    Context context;
    int resource;
    ArrayList<Mon> lstMon;
    public CustomListView(@NonNull Context context, int resource, @NonNull ArrayList<Mon> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.lstMon=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.custom_listview,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.imgAnhMon=(ImageView)convertView.findViewById(R.id.imgAnhMon);
            viewHolder.tvMaMon=(TextView)convertView.findViewById(R.id.tvMaMon);
            viewHolder.tvTenMon=(TextView)convertView.findViewById(R.id.tvTenMon);
            viewHolder.tvDonGia=(TextView)convertView.findViewById(R.id.tvDonGia);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        Mon mon=lstMon.get(position);
        viewHolder.imgAnhMon.setImageResource(mon.hinhanh);
        viewHolder.tvMaMon.setText(mon.maMon);
        viewHolder.tvTenMon.setText(mon.tenMon);
        viewHolder.tvDonGia.setText(String.valueOf(mon.donGia));
        return convertView;
    }
    public class ViewHolder{
        TextView tvMaMon, tvTenMon,tvDonGia;
        ImageView imgAnhMon;
    }
}
