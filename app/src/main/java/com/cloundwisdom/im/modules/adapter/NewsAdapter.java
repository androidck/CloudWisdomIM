package com.cloundwisdom.im.modules.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloundwisdom.im.R;
import com.cloundwisdom.im.modules.entry.NewsEntry;
import com.hjq.base.view.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseRecyclerViewAdapter<NewsAdapter.ViewHolder> {

    private List<NewsEntry> mDatas;
    private Context mContext;

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
        viewHolder.tvTitile.setText(mDatas.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }


    class ViewHolder extends BaseRecyclerViewAdapter.ViewHolder{

        TextView tvTitile;
        public ViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            tvTitile= (TextView) findViewById(R.id.item_title);
        }
    }
}
