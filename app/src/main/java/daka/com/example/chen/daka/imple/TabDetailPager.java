package daka.com.example.chen.daka.imple;

import android.app.Activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;


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
//    public TextView tvText;
    public View view;
    public HomeHot homeHot;
    public int position;
    public TabDetailPager(Activity activity, int i) {
        this.mActivity = activity;
        this.position = i;
        initViews();
    }

    /**
     * 数据下载得接口
     */
    private String[] urls = {Contants.URL.HOME_HOT
            ,Contants.URL.HOME_PLACE
            ,Contants.URL.HOME_CAR
            ,Contants.URL.HOME_CITY};


    public void initViews() {

        /*tvText = new TextView(mActivity);//模拟数据展示
        tvText.setText("信息" + urls[position]);
        tvText.setGravity(Gravity.CENTER);*/
        view = View.inflate(mActivity,R.layout.tab_detail_pager,null);
        tab_detail_pager = (RecyclerView) view.findViewById(R.id.rlv_tab_detail_pager);



    }


    /*public void initData() {
//        tab_detail_pager.setLayoutManager(new LinearLayoutManager(mActivity));


//        tab_detail_pager.setAdapter(new AdapterRecyclerView(homeHot.Data.HomeViewList));
//        Log.d(TAG, "initData: ");
    }*/

    public void initData(){
        String city = ShareUtil.getString("city");
        String province = ShareUtil.getString("province");
//        Log.d(TAG, "initData: city---->" + city +"=====" + "province" +province);
        String url = "";
     /*   if (TextUtils.isEmpty(province)) {
            //如果province为空的话那么就加载city,例如香港  澳门就没有，那么就直接设置为city
            url = String.format(urls[position],city);
        }else if(!TextUtils.isEmpty(province)){
            //如果province不为空但是这个字符串包含市这个字符串,也设置为city
            if (province.contains("市")){
                url = String.format(urls[position],city);
            }


        }else{
            //其他情况直接设置为province*/
            url = String.format(urls[position], province);

        loadData(url);//加载数据
        int i= 0;
        int y =+i;
        Log.d(TAG, "loadData: "+y);

//        getData(String.format(Contants.URL.HOME_HOT,province));//下载数据


//        Log.d(TAG, "initData: " + url);




    }

    public void loadData(String url){
        OkHttpUtil.downJSON(url, new OkHttpUtil.OnDownDataListener() {
            @Override
            public void onResponse(String url, String json) {
//                Log.d(TAG, "onResponse: " +json);
//                int flag = ShareUtil.getInt("pager");
//                if (flag ==1){
                getJson(json);
//                    ShareUtil.putInt("pager",0);
//                }


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
//        Log.d(TAG, "getJson: " + homeHot);
        tab_detail_pager.setAdapter(new AdapterRecyclerView(homeHot.Data.HomeViewList,mActivity));

//        tab_detail_pager.setAdapter(new AdapterRecyclerView(homeHot.Data.HomeViewList));
//        EventBus.getDefault().post(homeHot);
//        Log.d(TAG, "getJson: " + homeHot);
    }

 /*   @Subscribe
    public void onEvent(HomeHot homeHot){
        Log.d(TAG, "initData: " + homeHot);//evenbus发送数据

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
