package com.github.mvpbasearchitecture.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mvpbasearchitecture.R;
import com.github.mvpbasearchitecture.data.models.local.Item;
import com.github.mvpbasearchitecture.utils.GeneralUtils;

import java.util.List;

/**
 * Adapter that used to display {@link Item} in a recycler view
 *
 * Created by gk
 */
public class MainItemListAdapter extends RecyclerView.Adapter<MainItemListAdapter.MyViewHolder> {

    private Context mContext;
    private List<Item> mItems;

    public MainItemListAdapter(Context mContext, List<Item> items) {
        this.mContext = mContext;
        this.mItems = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = mItems.get(position);
        if (item != null) {
            holder.id.setText(item.getItemId());
            holder.name.setText(item.getItemName());
            GeneralUtils.loadImageFromLink(mContext, holder.image, item.getItemImageLink());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * View Holder for recycler view.
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView id, name;

        MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            id = itemView.findViewById(R.id.item_id);
            name = itemView.findViewById(R.id.item_name);
        }
    }

}