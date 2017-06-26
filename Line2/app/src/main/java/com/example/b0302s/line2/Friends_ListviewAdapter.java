package com.example.b0302s.line2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.*;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bo3o2S on 2017-06-26.
 */

public class Friends_ListviewAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private ArrayList<item_friends_list> data;
    private int layout;

    public Friends_ListviewAdapter(Context context, int layout, ArrayList<item_friends_list> data)
    {
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent)
    {
        if(converView == null)
        {
            converView = inflater.inflate(layout, parent, false);
        }
        item_friends_list listviewitem = data.get(position);
        ImageView icon = (ImageView) converView.findViewById(R.id.item_image);
        icon.setImageResource(listviewitem.getIcon());
        TextView name = (TextView) converView.findViewById(R.id.item_text);
        name.setText(listviewitem.getName());

        return converView;
    }
}
