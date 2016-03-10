package daka.com.example.chen.daka.bean;

import java.util.ArrayList;

/**
 * Created by chen on 2016/3/7.
 */
public class CityProvince {
    private String province;
    private ArrayList<String> arrayList;

    public CityProvince() {
        arrayList = new ArrayList<>();
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "CityProvince{" +
                "province='" + province + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }

    public void setArrayList(String value) {
        arrayList.add(value);
    }

    public ArrayList<String> getArrayList() {

        return arrayList;
    }

    public String getProvince() {

        return province;
    }
}
