package daka.com.example.chen.daka.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import daka.com.example.chen.daka.bean.HomeHot;

/**
 * Created by chen on 2016/3/10.
 */
public class VHolder extends RecyclerView.ViewHolder {
    /**
     * 该Map用于缓存布局中的控件
     */
    Map<Integer, View> cacheMap = new HashMap();
    View layoutView;

    public VHolder(View itemView) {
        super(itemView);
        this.layoutView = itemView;
    }
    /**
     * 通过控件ID 找到该控件
     * @param id
     * @return
     */
    public View getView(int id){
        if(cacheMap.containsKey(id)){
            return cacheMap.get(id);
        } else {
            View view = layoutView.findViewById(id);
            cacheMap.put(id, view);
            return view;
        }
    }
    /**
     * 绑定TextView
     * @param id
     * @param text
     * @return
     */
    public VHolder bindTextView(int id, String text){
        TextView tv = (TextView) getView(id);
        tv.setText(text);
        return this;
    }
    /**
     * 绑定CacheImageView
     * @param id
     * @param uri
     * @return
     */
    public VHolder bindSimpleDraweeView(int id, Uri uri){
        SimpleDraweeView civ = (SimpleDraweeView) getView(id);
        civ.setImageURI(uri);
        return this;
    }

    /* onBindViewHolder 绑定数据*/
    public void render(VHolder vh,HomeHot.DataEntity.HomeViewListEntity HomeViewList,Activity mActivity){

    }

}
