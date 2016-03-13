package daka.com.example.chen.daka.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longevitysoft.android.xml.plist.domain.*;

import java.lang.Integer;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.bean.HomeHot;
import daka.com.example.chen.daka.bean.HomeSingle;

/**
 * Created by chen on 2016/3/9.
 */
public class AdapterRecyclerView extends RecyclerView.Adapter{
    private static final String TAG = "print";
    private ArrayList<HomeHot.DataEntity.HomeViewListEntity> datas;

    private Activity mActivity;
    private ArrayList<View> list;
    private HashMap<Integer,View> map;
    public AdapterRecyclerView(ArrayList<HomeHot.DataEntity.HomeViewListEntity> datas,Activity mActivity) {
        this.mActivity = mActivity;
        this.datas = datas;
        this.list = new ArrayList<>();
        this.map = new HashMap<>();

    }

    /*根据item的样式，创建不同的item样式*/
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root;
        VHolder vholder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType==3) {

            root = inflater.inflate(R.layout.item_morenews, parent, false);
            vholder = new VHolderMore(root);

        }else if (viewType == 5){

                root = inflater.inflate(R.layout.item_singlenews, parent, false);
                vholder = new VHolderSingle(root);

        }


        return vholder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        VHolder vh = (VHolder)viewHolder;

        /*vh.getItemId();
        vh.getLayoutPosition();
        vh.getAdapterPosition();*/

        /*Log.d(TAG, "onBindViewHolder: " + "vh.getAdapterPosition()"  + vh.getAdapterPosition());
        if (!map.containsKey(vh.getLayoutPosition())){
            map.put(vh.getLayoutPosition(), vh.itemView);
            list.add(vh.itemView);
//            Log.d(TAG, "onBindViewHolder: position" +position);
        }*/

        vh.render(vh,datas.get(position),mActivity);
    }

    /*设置Item的样式*/
    @Override
    public int getItemViewType(int position) {
//        Log.d(TAG, "getItemViewType: " + position);
        return datas.get(position).Type;
    }
    /*设置Item的数据*/
    @Override
    public int getItemCount() {

        return datas.size();
    }
}
