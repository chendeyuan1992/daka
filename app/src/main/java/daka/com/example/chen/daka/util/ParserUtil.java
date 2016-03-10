package daka.com.example.chen.daka.util;

import android.app.Activity;


import com.longevitysoft.android.xml.plist.PListXMLHandler;
import com.longevitysoft.android.xml.plist.PListXMLParser;
import com.longevitysoft.android.xml.plist.domain.Array;
import com.longevitysoft.android.xml.plist.domain.Dict;
import com.longevitysoft.android.xml.plist.domain.PList;
import com.longevitysoft.android.xml.plist.domain.PListObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import daka.com.example.chen.daka.R;
import daka.com.example.chen.daka.bean.CityProvince;

/**
 * Created by chen on 2016/3/6.
 *
 *
 * <array>
    <dict>
        <key>province</key>
        <string>北京市</string>
        <key>city</key>
        <array>
        <string>东城区</string>
        <string>西城区</string>
        <string>崇文区</string>
        <string>宣武区</string>
        <string>朝阳区</string>
        <string>丰台区</string>
        <string>石景山区</string>
        <string>海淀区</string>
        <string>门头沟区</string>
        <string>房山区</string>
        <string>通州区</string>
        <string>顺义区</string>
        <string>昌平区</string>
         <string>大兴区</string>
        <string>怀柔区</string>
        <string>平谷区</string>
        <string>密云县</string>
        <string>延庆县</string>
        </array>
    </dict>
    <dict>
        <key>province</key>
        <string>天津市</string>
        <key>city</key>
        <array>
        <string>和平区</string>
        <string>河东区</string>
        <string>河西区</string>
        <string>南开区</string>
        <string>河北区</string>
        <string>红桥区</string>
        <string>塘沽区</string>
        <string>汉沽区</string>
        <string>大港区</string>
        <string>东丽区</string>
        <string>西青区</string>
        <string>津南区</string>
        <string>北辰区</string>
        <string>武清区</string>
        <string>宝坻区</string>
        <string>宁河县</string>
        <string>静海县</string>
        <string>蓟县</string>
        </array>
    </dict>
 </array>
 */
public class ParserUtil {


    private  final String TAG = "print";





    public  ArrayList<CityProvince> parser(final Activity activity){
        ArrayList<CityProvince> arrayList = new ArrayList<>();
                PListXMLParser parser = new PListXMLParser();                // 基于SAX的实现
                PListXMLHandler handler = new PListXMLHandler();
                parser.setHandler(handler);
                try {
                    parser.parse(activity.getResources().openRawResource(R.raw.location));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                PList actualPList = ((PListXMLHandler) parser.getHandler()).getPlist();//初始化
                Array array = (Array) actualPList.getRootElement();//得到array节点array集合
                for (int i= 0 ;i <array.size();i++){
                    Dict dict = (Dict) array.get(i);//第i个dict节点
                    Map<String,PListObject> provinceCities = dict.getConfigMap();//通过i个节点得到一个map的集合
//                    Log.d(TAG, "parser: "+provinceCities.keySet().size());
                    //获得map集合的键值对集合
                    for (int j = 0; j < provinceCities.keySet().size()-1;j++){
                        CityProvince cityProvince = new CityProvince();
                        if (j%2 == 0){
                            Array cityName = (Array) provinceCities.get("city");
//                            System.out.println(cityName + "------------");
                            //判断这个集合是否为空
                            if (cityName !=null){
                                for (int k = 0; k < cityName.size(); k++){
                                    com.longevitysoft.android.xml.plist.domain.String city = (com.longevitysoft.android.xml.plist.domain.String) cityName.get(k);
//
                                    cityProvince.setArrayList(city.getValue());//添加数据到集合中
//                                    System.out.println("city的值" + city.getValue());
                                }
//                                System.out.println("**************************");

                            }

                        }
                        if ((j+1)%2==1){
                            com.longevitysoft.android.xml.plist.domain.String p = (com.longevitysoft.android.xml.plist.domain.String) provinceCities.get("province");
                            System.out.println(p.getValue());
                            cityProvince.setProvince(p.getValue());
                        }

//                        System.out.println(cityProvince.toString());
                        arrayList.add(cityProvince);
//                        System.out.println("***********************");


                    }
                   /* for (int c=0;i<arrayList.size()-1;c++){
                        System.out.println("******"+arrayList.get(c));
                    }*/

                }








        return arrayList;

    }






}
