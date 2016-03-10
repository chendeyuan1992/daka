package daka.com.example.chen.daka.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.util.ShareUtil;


/**
 * Created by chen on 2016/3/5.
 */
public class BasePager {
    public Activity mActivity;
    public FrameLayout flContent;// 内容
    public View mRootView;// 布局对象

    public BasePager(Activity activity) {
        mActivity = activity;//这是basepager在DetailsActivity得到的对象
        initViews();
        initData();

    }



    /**
     * 初始化布局
     */
    public void initViews() {
        mRootView = View.inflate(mActivity, R.layout.base_pager,null);

        flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);


    }

    /**
     * 初始化数据
     */
    public void initData(){
        ShareUtil.putString("city", "北京市");
        ShareUtil.putString("province","");

    }

}
