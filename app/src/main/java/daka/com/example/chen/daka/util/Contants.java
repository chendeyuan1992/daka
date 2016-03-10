package daka.com.example.chen.daka.util;

/**
 * Created by chen on 2016/3/9.
 */
public interface Contants {
    interface URL{
        /**
         * 首页
         */
        String HOME = "http://www.duckr.cn/api/v41/plan/homepage/?";

        /**
         * 首页热门
         */
        String HOME_HOT=HOME+"TourThemeId=31000&LocName=%s";

        /**
         * 首页本地
         */
        String HOME_PLACE = HOME+"TourThemeId=31001&LocName=%s";

        /**
         * 首页拼车
         */
        String HOME_CAR =HOME+ "TourThemeId=31002&LocName=%s";

        /**
         * 首页同城
         */
        String HOME_CITY = HOME+"TourThemeId=30000&LocName=%s";



    }
}
