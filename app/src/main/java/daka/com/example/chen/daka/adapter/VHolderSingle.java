package daka.com.example.chen.daka.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;

import daka.com.example.chen.daka.BannerActivity;
import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.bean.HomeHot;
import daka.com.example.chen.daka.util.Contants;

public class VHolderSingle extends VHolder implements View.OnClickListener {


    private static final String TAG = "print";
    private SimpleDraweeView simpleDraweeView;
    public Activity mActivity;
    private  int flag;
    public VHolderSingle(View root){
        super(root);
       /* simpleDraweeView = (SimpleDraweeView) root.findViewById(R.id.iv_sdv);*/


    }


    @Override
    public void render(VHolder vh,HomeHot.DataEntity.HomeViewListEntity HomeViewList,Activity mActivity) {
        super.render(vh,HomeViewList, mActivity);
        this.mActivity = mActivity;


//            Log.d(TAG, "render:--->single " +position);

            simpleDraweeView.setOnClickListener(this);
            String str = HomeViewList.Banner.CoverThumbUrl;
//            Log.d(TAG, "render: " + str);
            if (!TextUtils.isEmpty(str)){
                Uri uri = Uri.parse(str);//得到单布局文件的uri进行设置图片

                simpleDraweeView.setImageURI(uri);
            }





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_sdv:
                Intent intent = new Intent(mActivity, BannerActivity.class);
                intent.putExtra("plans", Contants.URL.PLANS);
                mActivity.startActivity(intent);

                break;
        }



    }
}
