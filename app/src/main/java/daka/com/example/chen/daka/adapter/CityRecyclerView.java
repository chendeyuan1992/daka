package daka.com.example.chen.daka.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;



import java.util.ArrayList;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.bean.CityProvince;


/**
 * Created by chen on 2016/3/7.
 */
public class CityRecyclerView extends RecyclerView.Adapter<CityRecyclerView.MyViewHolder> implements View.OnClickListener {
    private static final String TAG = "print";
    private ArrayList<CityProvince> data;
    private Context context;
    public String city;
    private View view;

    public CityRecyclerView(ArrayList<CityProvince> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public CityRecyclerView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(
                context).inflate(R.layout.recyclerview_layout, parent,
                false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CityRecyclerView.MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getProvince());
//        Log.d(TAG, "onBindViewHolder: ----->1");
        holder.itemView.setTag(position);
        view.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if (listener !=null){
            listener.onItemClick((Integer) v.getTag());


        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageButton iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_city);
            iv = (ImageButton) itemView.findViewById(R.id.icon_next);
        }
    }
    public OnClickItemListener listener;


    public void setOnItemClickListener(OnClickItemListener listener) {
//        Log.d(TAG, "setOnItemClickListener: ---->3");
        this.listener = listener;
    }
    public interface OnClickItemListener{

        void onItemClick(int position);

    }
}
