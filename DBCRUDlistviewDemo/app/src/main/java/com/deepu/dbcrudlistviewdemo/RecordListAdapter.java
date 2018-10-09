package com.deepu.dbcrudlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Model> recordList;

    public RecordListAdapter(Context context, int layout, ArrayList<Model> recordList) {
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }


    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView txtname,txtemail,txtpassword;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View row=view;
        ViewHolder holder=new ViewHolder();

        if(row==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(layout,null);
            holder.txtname=row.findViewById(R.id.txtname);
            holder.txtemail=row.findViewById(R.id.txtemail);
            holder.txtpassword=row.findViewById(R.id.txtpwd);

            row.setTag(holder);
        }
        else{
            holder =(ViewHolder) row.getTag();
        }

        Model model=recordList.get(position);

        holder.txtname.setText(model.getUsername());
        holder.txtemail.setText(model.getEmail());
        holder.txtpassword.setText(model.getPassword());

         return row;
    }
}
