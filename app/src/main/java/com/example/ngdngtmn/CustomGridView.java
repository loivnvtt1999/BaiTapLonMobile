package com.example.ngdngtmn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomGridView extends ArrayAdapter<LoaiMon>
{
    Context context;
    int resource;
    ArrayList<LoaiMon> lstLoaiMon;
    public CustomGridView(@NonNull Context context, int resource, @NonNull ArrayList<LoaiMon> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.lstLoaiMon=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.custom_gridview,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.imageLoaiMon=(ImageView) convertView.findViewById(R.id.imgLoaiMon);
            viewHolder.tvLoaiMon=(TextView) convertView.findViewById(R.id.tvTenLoaiMon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        LoaiMon loaiMon=lstLoaiMon.get(position);
        viewHolder.tvLoaiMon.setText(loaiMon.maLoai.toString()+"\t-\t"+loaiMon.tenLoai.toString());
        viewHolder.imageLoaiMon.setImageResource(loaiMon.hinhanh);
        return convertView;
    }
    public class ViewHolder{
        ImageView imageLoaiMon;
        TextView tvLoaiMon;
    }
}

