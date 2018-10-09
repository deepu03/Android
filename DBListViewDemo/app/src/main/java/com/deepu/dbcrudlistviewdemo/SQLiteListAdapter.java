package com.deepu.dbcrudlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class SQLiteListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> userid;
    ArrayList<String> uname;
    ArrayList<String> useremail;
    ArrayList<String> userpassword;

    public SQLiteListAdapter(Context context1, ArrayList<String> id, ArrayList<String> username, ArrayList<String> email, ArrayList<String> password){
        this.userid=id;
        this.uname=username;
        this.useremail=email;
        this.userpassword=password;
        this.context=context1;

    }
    @Override
    public int getCount() {
        return userid.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if(convertView==null){
            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listviewdatalayout,null);

            holder=new Holder();
            holder.textid=convertView.findViewById(R.id.textViewID);
            holder.textname=convertView.findViewById(R.id.textViewUSERNAME);
            holder.textemail=convertView.findViewById(R.id.textViewEMAIL);
            holder.textpwd=convertView.findViewById(R.id.textViewPASSWORD);

            convertView.setTag(holder);
        }

        else{
            holder=(Holder) convertView.getTag();

        }

        holder.textid.setText(userid.get(position));
        holder.textname.setText(uname.get(position));
        holder.textemail.setText(useremail.get(position));
        holder.textpwd.setText(userpassword.get(position));

        return convertView;
    }
    public class Holder {
        TextView textid;
        TextView textname;
        TextView textemail;
        TextView textpwd;
    }
}
