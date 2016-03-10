package daka.com.example.chen.daka;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

import daka.com.example.chen.daka.adapter.CityRecyclerView;
import daka.com.example.chen.daka.bean.CityProvince;
import daka.com.example.chen.daka.util.ParserUtil;
import daka.com.example.chen.daka.util.ShareUtil;


/**
 * Created by chen on 2016/3/7.
 */
public class CityActivity extends AppCompatActivity{

    private static final String TAG = "print";
    private RecyclerView recyclerView;
    private static  ArrayList<CityProvince> arrayList= null;
    private CityRecyclerView cityRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceStatete) {
        super.onCreate(savedInstanceStatete);
        setContentView(R.layout.city_activity);
        recyclerView = (RecyclerView) findViewById(R.id.rlv_view);

        getArrayList(this);





    }
    public void getArrayList(final Activity activity){

        ParserUtil parserUtil = new ParserUtil();
        arrayList = parserUtil.parser(activity);
        cityRecyclerView = new CityRecyclerView(arrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cityRecyclerView);
        cityRecyclerView.setOnItemClickListener(new CityRecyclerView.OnClickItemListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> array = arrayList.get(position).getArrayList();


                if (array.size() == 0){
                    Intent intent = new Intent();
//                    Log.d(TAG, "onItemClick:1 " + array.size());
                    intent.setClass(CityActivity.this, DetailsActivity.class);
                    intent.putExtra("city", arrayList.get(position).getProvince());
                    ShareUtil.putString("city", arrayList.get(position).getProvince());
                    startActivity(intent);
                    finish();
                }else if(array.size()>0){
                    Intent intent = new Intent();
//                    Log.d(TAG, "onItemClick:2--- " + array.size());
                    intent.setClass(CityActivity.this, ProvinceActivity.class);
                    intent.putExtra("province", arrayList.get(position).getArrayList());
                    ShareUtil.putString("city", arrayList.get(position).getProvince());
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}
