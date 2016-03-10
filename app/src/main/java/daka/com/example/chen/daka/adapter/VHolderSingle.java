package daka.com.example.chen.daka.adapter;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.bean.HomeHot;

public class VHolderSingle extends VHolder{


    private static final String TAG = "print";
    private SimpleDraweeView simpleDraweeView;

    public VHolderSingle(View root){
        super(root);
        simpleDraweeView = (SimpleDraweeView) root.findViewById(R.id.iv_pic);

    }


    @Override
    public void render(HomeHot.DataEntity.HomeViewListEntity HomeViewList) {
        super.render(HomeViewList);
        String str = HomeViewList.Banner.CoverThumbUrl;
//        Log.d(TAG, "render: " + str);
        if (!TextUtils.isEmpty(str)){
            Uri uri = Uri.parse(str);

            simpleDraweeView.setImageURI(uri);
        }

    }
}
