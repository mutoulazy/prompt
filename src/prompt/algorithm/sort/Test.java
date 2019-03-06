package prompt.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mutoulazy on 2018/1/15.
 */
public class Test {
    public static void main(String[] args) {

//        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
//
//        init(data);
//
//        System.out.println("排序前:");
//        System.out.println(data);
//        sort(data);
////        String testStr = data.get(0).get("PRECOUNTOUT");
////        String[] str = testStr.split("-");
////        for (String s:str
////             ) {
////            System.out.println(s);
////        }
//        System.out.println("排序后:");
//        System.out.println(data);


        String partiton = "DDM_PERF_PART_";
        Date dt = new Date();
        Calendar   calendar   =   new   GregorianCalendar();
        calendar.setTime(dt);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        dt = calendar.getTime();
        partiton += sdf.format(dt);
        System.out.println(partiton);
    }

    private static void sort(List<Map<String, String>> data) {

        Collections.sort(data, new Comparator<Map>() {

            public int compare(Map o1, Map o2) {


                String str1 = (String) o1.get("PRECOUNTOUT");
                String[] strList1 = str1.split("-");
                String str2 = (String) o2.get("PRECOUNTOUT");
                String[] strList2 = str2.split("-");
                //System.out.println(strList1[2] + " " + strList2[2]);
                if (strList1[2].compareTo(strList2[2]) == 0){
                    return strList1[3].compareTo(strList2[3]);
                }else {
                    return  strList1[2].compareTo(strList2[2]);
                }
                // 降序
                // return b.compareTo(a);
            }
        });
    }

    private static void init(List<Map<String, String>> data) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("COUNTTICKET", "1");
        map.put("PRECOUNTOUT", "1-1-2-1");
        data.add(map);

        map = new HashMap<String, String>();
        map.put("COUNTTICKET", "6");
        map.put("PRECOUNTOUT", "1-1-1-1");
        data.add(map);

        map = new HashMap<String, String>();
        map.put("COUNTTICKET", "8");
        map.put("PRECOUNTOUT", "1-1-2-4");
        data.add(map);

        map = new HashMap<String, String>();
        map.put("COUNTTICKET", "2");
        map.put("PRECOUNTOUT", "1-1-2-3");
        data.add(map);

        map = new HashMap<String, String>();
        map.put("COUNTTICKET", "2");
        map.put("PRECOUNTOUT", "1-1-3-3");
        data.add(map);
    }
}
