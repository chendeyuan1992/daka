package daka.com.example.chen.daka.imple;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.io.IOException;
import java.util.ArrayList;

import daka.com.example.chen.daka.CityActivity;
import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.base.BasePager;
import daka.com.example.chen.daka.bean.HomeHot;
import daka.com.example.chen.daka.util.JsonUtil;
import daka.com.example.chen.daka.util.ShareUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by chen on 2016/3/5.
 */
public class HomePager extends BasePager {
    private static Handler handler = new Handler();
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static final String TAG = "print";

    public View homeview;
    private TextView tv_homne;

    private ViewPager pager;

    public static String[] CONTENT = new String[] { "热门", "本地", "拼车", "同城"};

    private ArrayList<TabDetailPager> datas;//数据源




    public FragmentManager fm;
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

//        indicator = (TabPageIndicator)homeview.findViewById(R.id.indicator);

        datas = new ArrayList();
        for(int i = 0; i < CONTENT.length; i++) {
            TabDetailPager tabDetailPager = new TabDetailPager(mActivity);
            datas.add(tabDetailPager);

        }


        //加载数据

        //初始化自定义控件

        pager.setAdapter(new HomePagerAdapter(datas));

//        indicator.setViewPager(pager);


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

//        getData(String.format(Contants.URL.HOME_HOT,province));//下载数据

    }





    public View getView(){
        return homeview;
    }


    /**
     * 获取json数据
     */
    public void getData(final String url){

        new Thread() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                try{
                    Response execute = okHttpClient.newCall(request).execute();
                    final String str = execute.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String json = str;
                            getJson(json);
                        }
                    });
//                    Log.d(TAG, "run: 同步get请求结果：" + str);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }


    /**
     * 解析json文件
     * @param str
     */
    public static void getJson(String str){
        HomeHot homeHot = JsonUtil.getNewsByJSON(str);
        Log.d(TAG, "getJson: " + homeHot.toString());
    }





}
