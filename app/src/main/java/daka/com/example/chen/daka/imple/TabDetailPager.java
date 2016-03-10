package daka.com.example.chen.daka.imple;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.adapter.AdapterRecyclerView;
import daka.com.example.chen.daka.bean.HomeHot;
import daka.com.example.chen.daka.util.Contants;
import daka.com.example.chen.daka.util.OkHttpUtil;
import daka.com.example.chen.daka.util.ShareUtil;

/**
 * Created by chen on 2016/3/9.
 */
public class TabDetailPager {
    private RecyclerView tab_detail_pager;

    private static final String TAG = "print";
    private Activity mActivity;
    public TextView tvText;
    public View view;
    public HomeHot homeHot;
    public TabDetailPager(Activity activity) {
        this.mActivity = activity;
//        EventBus.getDefault().register(this);
        initViews();
    }


    public void initViews() {

        tvText = new TextView(mActivity);//模拟数据展示
        tvText.setText("信息");
        tvText.setGravity(Gravity.CENTER);
        view = View.inflate(mActivity,R.layout.tab_detail_pager,null);
        tab_detail_pager = (RecyclerView) view.findViewById(R.id.rlv_tab_detail_pager);



    }


    /*public void initData() {
//        tab_detail_pager.setLayoutManager(new LinearLayoutManager(mActivity));


//        tab_detail_pager.setAdapter(new AdapterRecyclerView(homeHot.Data.HomeViewList));
//        Log.d(TAG, "initData: ");
    }*/

    public void initData(){
        String province = ShareUtil.getString("province");
//        getData(String.format(Contants.URL.HOME_HOT,province));//下载数据
        OkHttpUtil.downJSON(String.format(Contants.URL.HOME_HOT, province), new OkHttpUtil.OnDownDataListener() {
            @Override
            public void onResponse(String url, String json) {
//                Log.d(TAG, "onResponse: " +json);
                getJson(json);


            }

            @Override
            public void onFailure(String url, String error) {

            }
        });


    }
    public  void getJson(String json){
        Gson gson = new Gson();
        homeHot = gson.fromJson(json,HomeHot.class);
        tab_detail_pager.setLayoutManager(new LinearLayoutManager(mActivity));
        Log.d(TAG, "getJson: " + homeHot);
        tab_detail_pager.setAdapter(new AdapterRecyclerView(homeHot.Data.HomeViewList));

//        tab_detail_pager.setAdapter(new AdapterRecyclerView(homeHot.Data.HomeViewList));
//        EventBus.getDefault().post(homeHot);
//        Log.d(TAG, "getJson: " + homeHot);
    }

 /*   @Subscribe
    public void onEvent(HomeHot homeHot){
        Log.d(TAG, "initData: " + homeHot);

    }*/

   /* public void initTest(){
        HomePager homePager = new HomePager(mActivity);
        homePager.setListener(new HomePager.OnListener() {
            @Override
            public void getHomeHot(HomeHot homeHot) {
                Log.d(TAG, "getHomeHot: " +homeHot);
            }
        });
    }*/
}
