package com.westlife.refresh.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.westlife.refresh.R;
import com.westlife.refresh.utils.DataUtils;

/**
 * Created by chenzhi on 2018/6/20 0020.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;

    public RecyclerAdapter(Context context) {
        this.mContext=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text.setText(DataUtils.getList().get(position));
    }

    @Override
    public int getItemCount() {
        return DataUtils.getList().size();
    }

    /**
     * 优化适配器
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.item_text);
            image = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
