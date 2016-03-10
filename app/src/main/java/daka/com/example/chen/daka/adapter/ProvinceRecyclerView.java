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


/**
 * Created by chen on 2016/3/7.
 */
public class ProvinceRecyclerView extends RecyclerView.Adapter<ProvinceRecyclerView.MyViewHolder> implements View.OnClickListener {
    private ArrayList<String> data;
    private Context context;
    private View view;

    public ProvinceRecyclerView(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ProvinceRecyclerView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(
                context).inflate(R.layout.recyclerview_layout, parent,
                false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProvinceRecyclerView.MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position));

        holder.itemView.setTag(data.get(position));
        view.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if (listener !=null){

            listener.onItemClick((String)v.getTag());


        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageButton iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_city);

        }
    }
    public OnClickItemListener listener;


    public void setOnItemClickListener(OnClickItemListener listener) {
        this.listener = listener;
    }
    public interface OnClickItemListener{
        void onItemClick(String datas);
    }
}
