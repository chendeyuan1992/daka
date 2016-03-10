package daka.com.example.chen.daka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import daka.com.example.chen.daka.adapter.ProvinceRecyclerView;
import daka.com.example.chen.daka.util.ShareUtil;

/**
 * Created by chen on 2016/3/7.
 */
public class ProvinceActivity extends AppCompatActivity {
    private static final String TAG = "print";


    @Bind(R.id.rlv_view)
    public RecyclerView rlvView;
    private ProvinceRecyclerView provinceRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prvince_activity);
        ButterKnife.bind(this);
//        rlvView = (RecyclerView) findViewById(R.id.rlv_view);


        Intent intent=getIntent();//getIntent将该项目中包含的原始intent检索出来，将检索出来的intent赋值给一个Intent类型的变量intent
        Bundle bundle=intent.getExtras();//.getExtras()得到intent所附带的额外数据
        ArrayList<String> arrayList = (ArrayList<String>) bundle.get("province");


        Log.d(TAG, "onCreate: " +arrayList);

        provinceRecyclerView = new ProvinceRecyclerView(arrayList,this);

        rlvView.setLayoutManager(new LinearLayoutManager(this));//创建RecyclerView对象
        rlvView.setAdapter(provinceRecyclerView);//设置城市内容的RecyclerView

        provinceRecyclerView.setOnItemClickListener(new ProvinceRecyclerView.OnClickItemListener() {
            @Override
            public void onItemClick(String datas) {
                Intent intent = new Intent();
                intent.setClass(ProvinceActivity.this, DetailsActivity.class);
                ShareUtil.putString("province", datas);
                startActivity(intent);
                finish();
            }
        });
    }
}
