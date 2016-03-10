package daka.com.example.chen.daka.imple;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import daka.com.example.chen.daka.util.ShareUtil;

/**
 * Created by chen on 2016/3/10.
 */
public class HomePagerAdapter extends PagerAdapter {
    private ArrayList<TabDetailPager> data;

    public HomePagerAdapter(ArrayList<TabDetailPager> datas) {
        this.data = datas;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return HomePager.CONTENT[position];
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TabDetailPager pager = data.get(position);
//        container.removeAllViews();
        container.addView(pager.view);
//        ShareUtil.putInt("pager", 1);
        pager.initData();

        return pager.view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
