package daka.com.example.chen.daka.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.bean.HomeHot;
import daka.com.example.chen.daka.util.Contants;
import daka.com.example.chen.daka.MemberListActivity;

/**
 * Created by yuhuibin on 15/8/26.
 */
public class VHolderMore extends VHolder implements View.OnClickListener {
    public Activity mActivity;
    private static final String TAG = "print";
    private SimpleDraweeView sdv_avatarthumburl;
    public SimpleDraweeView sdv_firstphotothumbur;
    public SimpleDraweeView sdv_secondphotothumbur;
    public VHolderMore(View root) {
        super(root);
        sdv_avatarthumburl = (SimpleDraweeView) root.findViewById(R.id.sdv_avatarthumburl);
        sdv_avatarthumburl.setOnClickListener(this);

        sdv_firstphotothumbur = (SimpleDraweeView) root.findViewById(R.id.sdv_firstphotothumbur);
        sdv_secondphotothumbur = (SimpleDraweeView) root.findViewById(R.id.sdv_secondphotothumbur);

    }

    @Override
    public void render(HomeHot.DataEntity.HomeViewListEntity HomeViewList,Activity mActivity) {
        super.render(HomeViewList,mActivity);
        this.mActivity = mActivity;

        //设置人头的图片
        String sdv_avatarthumburl_uri = HomeViewList.PartnerPlan.MemberList.get(0).AvatarThumbUrl;
//        Log.d(TAG, "render: " + sdv_avatarthumburl_uri);
        if (!TextUtils.isEmpty(sdv_avatarthumburl_uri)){
            Uri uri_sdv_avatarthumburl = Uri.parse(sdv_avatarthumburl_uri);
            sdv_avatarthumburl.setImageURI(uri_sdv_avatarthumburl);
        }

        //设置图片展示
        String sdv_firstphotothumbur_uri = HomeViewList.PartnerPlan.FirstPhotoThumbUrl;

        if (!TextUtils.isEmpty(sdv_firstphotothumbur_uri)){
//            Log.d(TAG, "render:---->sdv_firstphotothumbur_uri " + sdv_firstphotothumbur_uri);
            Uri uri_sdv_firstphotothumbur = Uri.parse(sdv_firstphotothumbur_uri);
            sdv_firstphotothumbur.setImageURI(uri_sdv_firstphotothumbur);

        }
        String sdv_secondphotothumbur_uri = HomeViewList.PartnerPlan.SecondPhotoThumbUrl;
        if (!TextUtils.isEmpty(sdv_secondphotothumbur_uri)){
            Log.d(TAG, "render: --->sdv_secondphotothumbur_uri" +sdv_secondphotothumbur_uri);
            Uri uri_sdv_secondphotothumbur = Uri.parse(sdv_secondphotothumbur_uri);
            sdv_secondphotothumbur.setImageURI(uri_sdv_secondphotothumbur);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sdv_avatarthumburl:
                Intent intent = new Intent(mActivity, MemberListActivity.class);
                intent.putExtra("personal", Contants.URL.PERSONAL);
                mActivity.startActivity(intent);
                break;


        }
    }
}
