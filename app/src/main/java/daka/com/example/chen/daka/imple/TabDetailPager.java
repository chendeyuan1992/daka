package daka.com.example.chen.daka.imple;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by chen on 2016/3/9.
 */
public class TabDetailPager {


    private static final String TAG = "print";
    private Activity mActivity;
    public TextView tvText;
    public TabDetailPager(Activity activity) {
        this.mActivity = activity;

        initViews();
    }


    public void initViews() {
        tvText = new TextView(mActivity);
        tvText.setText("页签详情页");
        tvText.setTextColor(Color.RED);
        tvText.setTextSize(25);
        tvText.setGravity(Gravity.CENTER);


    }


    public void initData() {

        Log.d(TAG, "initData: ");
    }
}
