package com.demoapplication.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demoapplication.R;
import com.demoapplication.YogaDetatailActivity;
import com.demoapplication.model.YogaDetailModel;
import com.demoapplication.utility.Application;
import com.demoapplication.utility.FontType;
import com.demoapplication.utility.Utils;
import com.whygraphics.gifview.gif.GIFView;

import java.util.List;

/**
 * Created by Administrator on 8/30/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> implements View.OnClickListener {

    private List<YogaDetailModel> list;
    private Activity mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        ImageView thumb_img;

        public MyViewHolder(View view) {
            super(view);
            Typeface roboto_light_typeface= Utils.getCustomFont(Application.mContext, FontType.ROBOTO_LIGHT);
            Typeface roboto_regular= Utils.getCustomFont(Application.mContext, FontType.ROBOTO_REGULAR);
            Typeface roboto_medium_typeface= Utils.getCustomFont(Application.mContext, FontType.ROBOTO_MEDIUM);

            title = (TextView) view.findViewById(R.id.list_title);
            thumb_img= (ImageView) view.findViewById(R.id.img_view_thumb);

            title.setTypeface(roboto_regular);
        }
    }
    public ListAdapter(List<YogaDetailModel> list,Activity mContext) {
        this.list = list;
        this.mContext=mContext;
    }
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyViewHolder holder, final int position) {
        YogaDetailModel model = list.get(position);
        holder.title.setText(model.getYogaTitle());
    //        holder.thumb_img.setImageResource();

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(mContext, YogaDetatailActivity.class);
        intent.putExtra("model",list.get((Integer) view.getTag()));
        mContext.startActivity(intent);
    }
}

