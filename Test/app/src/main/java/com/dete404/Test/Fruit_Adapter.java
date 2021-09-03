package com.dete404.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Fruit_Adapter extends ArrayAdapter<Fruit> {
    private int resourceID;
    public Fruit_Adapter(Context context, int textViewResourceID, List<Fruit>object){

        super(context,textViewResourceID,object);
        resourceID=textViewResourceID;
    }
    public View getView(int position, View coverView, ViewGroup parent){

        Fruit fruit=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID, parent, false);

        ImageView fruitImage=(ImageView)view.findViewById(R.id.fruit_img);
        TextView fruitName=(TextView)view.findViewById(R.id.fruit_name);

        fruitImage.setImageResource(fruit.getImg_id());
        fruitName.setText(fruit.getName());
        return view;
    }
}
