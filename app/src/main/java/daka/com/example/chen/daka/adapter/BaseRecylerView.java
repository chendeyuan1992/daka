package daka.com.example.chen.daka.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2016/3/9.
 */
public abstract class BaseRecylerView<T>extends RecyclerView.Adapter{
    private Context context;
    protected List<T> datas;
    private int[] resid;//getItemViewType方法的返回值，即为resid数组的下标
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
    public void setDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public BaseRecylerView(Context context, int... resid){
        this.context = context;
        this.resid = resid;
        datas = new ArrayList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate()
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        T t = datas.get(position);
        Class cl = t.getClass();
        try {
            Field field = cl.getDeclaredField("type");
            field.setAccessible(true);//开始私有属性的使用权限
            return field.getInt(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return resid.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        Map<Integer ,View> cacheMap = new HashMap<>();
        View layoutView;
        public MyViewHolder(View itemView) {
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
        public RecyclerView.ViewHolder bindTextView(int id, String text){
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
        public RecyclerView.ViewHolder bindCacheImageView(int id,Uri uri){
            SimpleDraweeView sdv = (SimpleDraweeView) getView(id);
            sdv.setImageURI(uri);
            return this;
        }
    }
}
