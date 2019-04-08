package com.cloundwisdom.im.modules.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloundwisdom.im.R;
import com.cloundwisdom.im.modules.entry.NewsEntry;
import com.hjq.base.view.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseRecyclerViewAdapter<NewsAdapter.ViewHolder> {

    private List<NewsEntry> mDatas;
    private Context mContext;
    private OnItemClickListener onItemClickListener;

    public NewsAdapter(Context context,List<NewsEntry> list) {
        super(context);
        this.mContext=context;
        this.mDatas=list;
        if (this.mDatas==null){
            this.mDatas=new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(viewGroup, R.layout.item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title=mDatas.get(i).getTitle().replace("&quot;","");
        viewHolder.tvTitile.setText(title);
        viewHolder.tv_desc.setText("来源："+mDatas.get(i).getDescription());
        String [] time=mDatas.get(i).getCtime().split(" ");
        viewHolder.tvCtime.setText(time[0]);
        Glide.with(mContext).load(mDatas.get(i).getPicUrl()).into(viewHolder.itemImg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnClick(mDatas.get(i).getUrl());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }


    class ViewHolder extends BaseRecyclerViewAdapter.ViewHolder{

        TextView tvTitile,tv_desc,tvCtime;
        ImageView itemImg;
        public ViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            tvTitile= (TextView) findViewById(R.id.item_title);
            tvCtime= (TextView) findViewById(R.id.item_ctime);
            tv_desc= (TextView) findViewById(R.id.item_desc);
            itemImg= (ImageView) findViewById(R.id.item_img);
        }
    }

    public interface OnItemClickListener{
        void OnClick(String url);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
