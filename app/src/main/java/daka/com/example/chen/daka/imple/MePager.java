package daka.com.example.chen.daka.imple;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import daka.com.example.chen.daka.base.BasePager;


/**
 * Created by chen on 2016/3/5.
 */
public class MePager extends BasePager {
    public MePager(Activity activity) {
        super(activity);
    }



    @Override
    public void initData() {
        TextView text = new TextView(mActivity);
        text.setText("我");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        flContent.addView(text);
    }
}
