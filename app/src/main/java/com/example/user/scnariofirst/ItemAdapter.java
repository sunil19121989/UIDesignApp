package com.example.user.scnariofirst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 16-02-2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Context con;
    ArrayList<String> ItemList;
    int layoutId;
    TextView txt_place4;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.txt_item);
        }
    }

    public ItemAdapter(Context con, ArrayList<String> ItemList, int layoutId, TextView txt_place4) {
        this.con = con;
        this.ItemList = ItemList;
        this.layoutId = layoutId;
        this.txt_place4 = txt_place4;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.mTextView.setText(ItemList.get(i));
        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_place4.setText(ItemList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }
}
