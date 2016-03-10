package daka.com.example.chen.daka.util;



import com.google.gson.Gson;

import daka.com.example.chen.daka.bean.HomeHot;

/**
 * Created by chen on 2016/3/8.
 */
public class JsonUtil {
    /**
     * 解析首页新闻列表
     * @param json
     * @return
     */
    public static HomeHot getNewsByJSON(String json){
        return new Gson().fromJson(json, HomeHot.class);
    }
}
