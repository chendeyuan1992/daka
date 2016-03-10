package daka.com.example.chen.daka.imple;

import android.app.Activity;
import android.view.View;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.base.BasePager;


/**
 * Created by chen on 2016/3/5.
 */
public class ChatPager extends BasePager {

    public ChatPager(Activity activity) {

        super(activity);
    }
    @Override
    public void initData() {
        View view = View.inflate(mActivity, R.layout.chat_pager,null);

        flContent.addView(view);
    }

}
