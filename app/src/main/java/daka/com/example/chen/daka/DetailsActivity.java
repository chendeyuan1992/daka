package daka.com.example.chen.daka;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.Toast;



import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import daka.com.example.chen.daka.base.BasePager;
import daka.com.example.chen.daka.imple.ChatPager;
import daka.com.example.chen.daka.imple.HomePager;
import daka.com.example.chen.daka.imple.MePager;
import daka.com.example.chen.daka.imple.TourpicPager;
import daka.com.example.chen.daka.util.ShareUtil;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "print";
    private Activity activity;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    @Bind(R.id.rg_group)
    public RadioGroup rgGroup;

    @Bind(R.id.vp_view_pager)
    public ViewPager mViewPager;


    private ArrayList<BasePager> mPagerList;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    private HomePager homePager;
    private BasePager basePager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题
        setContentView(R.layout.content);
        ButterKnife.bind(this);

        initData();


    }


    private void initData() {

        basePager = new BasePager(getActivity());
        homePager = new HomePager(getActivity());

        homePager.fm = getSupportFragmentManager();//获得FragmentManager
//        Log.d(TAG, "initData: " + getSupportFragmentManager() + homePager.fm);


        /*View view = homePager.getView();
        RelativeLayout rl_home_search = (RelativeLayout) view.findViewById(R.id.rl_home_search);
        Log.d(TAG, "initData: -->" +view);

        //跳转到城市选着页
        rl_home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(DetailsActivity.this,CityActivity.class));
            }
        });*/


        //首页的四个按钮的监听事件
        rgGroup.check(R.id.btn_home);

        mPagerList = new ArrayList<>();
        mPagerList.add(homePager);
        mPagerList.add(new TourpicPager(getActivity()));
        mPagerList.add(new ChatPager(getActivity()));
        mPagerList.add(new MePager(getActivity()));
        mViewPager.setAdapter(new ContentAdapter());

        // 监听RadioGroup的选择事件
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_home:
                        // mViewPager.setCurrentItem(0);// 设置当前页面
                        mViewPager.setCurrentItem(0, false);// 去掉切换页面的动画
                        break;
                    case R.id.btn_tourpic:
                        mViewPager.setCurrentItem(1, false);// 设置当前页面
                        break;
                    case R.id.btn_chat:
                        mViewPager.setCurrentItem(2, false);// 设置当前页面
                        break;
                    case R.id.btn_me:
                        mViewPager.setCurrentItem(3, false);// 设置当前页面
                        break;

                }
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                mPagerList.get(arg0).initData();// 获取当前被选中的页面, 初始化该页面数据
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        mPagerList.get(0).initData();// 初始化首页数据




    }






    class ContentAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return mPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagerList.get(position);
            container.addView(pager.mRootView);
            // pager.initData();// 初始化数据.... 不要放在此处初始化数据, 否则会预加载下一个页面
            return pager.mRootView;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && ShareUtil.getInt("flag") == 2) {

            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 1000);
        } else {
            ShareUtil.putInt("flag", 3);
            finish();
            System.exit(0);
        }
    }

    public Activity getActivity(){
        return this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String name = data.getStringExtra("city");
        Log.d(TAG, "onActivityResult: " + name);

    }
    /**
     * 创建一个方法来获得getFragmentManager()
     */
    public FragmentManager manager(){
        return getSupportFragmentManager();
    }
}
