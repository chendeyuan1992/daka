package daka.com.example.chen.daka.imple;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;

import daka.com.example.chen.daka.CityActivity;
import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.base.BasePager;
import daka.com.example.chen.daka.bean.HomeHot;
import daka.com.example.chen.daka.util.Contants;
import daka.com.example.chen.daka.util.JsonUtil;
import daka.com.example.chen.daka.util.OkHttpUtil;
import daka.com.example.chen.daka.util.ShareUtil;
import daka.com.example.chen.daka.util.SlidingTabLayout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by chen on 2016/3/5.
 */
public class HomePager extends BasePager {
    private static Handler handler = new Handler();

    private static final String TAG = "print";

    public View homeview;
    private TextView tv_homne;

    private ViewPager pager;

    public static String[] CONTENT = new String[] { "热门", "本地", "拼车", "同城"};

    private ArrayList<TabDetailPager> datas;//数据源





    private SlidingTabLayout sliding_tabs;
    public static HomeHot homeHot;
    //    private TabPageIndicator indicator;

    /**
     * 数据下载得接口
     */
   /* private String[] urls = {Contants.URL.HOME_PAGER
            ,String.format(Contants.URL.HOME_PLACE, CONTENT[1])
            ,String.format(Contants.URL.HOME_SHARE_CAR, CONTENT[2])
            ,String.format(Contants.URL.HOME_SAME_CITY, CONTENT[3])};*/


    public HomePager(Activity activity) {
        super(activity);

    }


    @Override
    public void initData() {
        homeview = View.inflate(mActivity, R.layout.home_pager, null);
        flContent.addView(homeview);
        pager = (ViewPager) homeview.findViewById(R.id.pager);//得到首页信息

        sliding_tabs = (SlidingTabLayout) homeview.findViewById(R.id.sliding_tabs);

        datas = new ArrayList();
        for(int i = 0; i < CONTENT.length; i++) {
            TabDetailPager tabDetailPager = new TabDetailPager(mActivity);
            datas.add(tabDetailPager);

        }






       /* if (fm !=null){
            myPagerAdapter = new MyPagerAdapter(fm, datas);
            pager.setAdapter(myPagerAdapter);
        }*/




        String city = ShareUtil.getString("city");
//        Log.d(TAG, "initData:-------------> " + city);
        String province = ShareUtil.getString("province");
        if (!TextUtils.isEmpty(city)){
            tv_homne = (TextView) homeview.findViewById(R.id.tv_home);
            tv_homne.setText(city);
        }
        RelativeLayout rt = (RelativeLayout) homeview.findViewById(R.id.rl_home_search);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, CityActivity.class);
                mActivity.startActivityForResult(intent, 20);
                mActivity.finish();
            }
        });

//
        //加载数据

        //初始化自定义控件

        pager.setAdapter(new HomePagerAdapter(datas));
        //设置滚动条颜色#ffe602
        sliding_tabs.setSelectedIndicatorColors(Color.argb(255, 0xff, 0xe6, 0x02));

        sliding_tabs.setCustomTabView(R.layout.tab_view, R.id.tabText);

        sliding_tabs.setViewPager(pager);


    }


    /**
     * 获得数据
     * @return
     */


    /**
     * if (listener !=null){
     listener.getHomeHot(homeHot);
     }

     * @return
     */


    public View getView(){
        return homeview;
    }


    public OnListener listener;


    public void setListener(OnListener listener) {
//        Log.d(TAG, "setOnItemClickListener: ---->3");
        this.listener = listener;
    }
    public interface OnListener{

        void getHomeHot(HomeHot homeHot);

    }




}
