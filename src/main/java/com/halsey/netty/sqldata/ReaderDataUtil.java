package com.halsey.netty.sqldata;

import com.google.common.collect.Maps;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by zhangyaohai on 2017/9/21.
 */
public class ReaderDataUtil {
    // id 0 price 1 status 2 create_time 3 update_time 4 app_id, 5 user_id, 6 sn, 7 pay_type, 8 product_sn 9
    //  product_name 10 sign_type 11  inform_status 12 in_return_url 13 in_notify_url 14 out_return_url 15
    //  prepay_id 16 nonce_str 17 spend 18 port_code 19  time 20 command_id 21 time_status 22 time_str 23 remark 24
    public static void main(String[] args) throws Exception {
        // 2002 支付宝  3001 微信
        // id  wx_spend  ali_spend  port_number day week  month

        // delete from t_pay_count where day between 20170901 and 20170918

        String path = "D:\\\\git\\\\halsey\\\\src\\\\main\\\\java\\\\com\\\\halsey\\\\netty\\\\sqldata\\\\qqq1.txt";
        Map<String, Map<String, String>> mm = buildResult(path);
        System.out.println("size========================"+mm.size());
        final  FileWriter fw = new FileWriter("D:\\\\git\\\\halsey\\\\src\\\\main\\\\java\\\\com\\\\halsey\\\\netty\\\\sqldata\\\\result.sql");
        mm.forEach((k, v)->{
            StringBuffer sb = new StringBuffer("insert into t_pay_count(week,month,port_number,day,wx_spend,ali_spend) values(");
            v.forEach((s, s2) -> {
                sb.append(s2).append(",");
            });
           String sd = sb.substring(0, sb.length()-1);
            try {
                fw.write(sd+");\r\n");
                fw.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        fw.close();
    }


    public static Map<String, Map<String, String>> buildResult(String p) throws IOException {
        final  Map<String, Map<String, String>> map = Maps.newHashMap();
        Files.lines(Paths.get(p), StandardCharsets.UTF_8).forEach(
                s -> {
                    String[] arr = s.split("\t");
                    String status = arr[2];
                    String pay_type = arr[8];
                    String spend = arr[18];
                    String port_code = arr[19];
                    String update_time = arr[4];

                    String day = LocalDit.getDayOfYears(update_time);
                    String week = LocalDit.getWeekOfYears(update_time);
                    String month = LocalDit.getMonthOfYears(update_time);

                    if(status.equals("1")){
                        String key = port_code+day+week+month;
                        if(map.containsKey(key)){
                            Map<String, String> tempmap = map.get(key);
                            if(pay_type.equals("2002")){ //支付宝
                                BigDecimal spendAli = new BigDecimal(tempmap.get("ali_spend")).add(new BigDecimal(spend));
                                tempmap.put("ali_spend", String.valueOf(spendAli));
                            }else{
                                BigDecimal spendWx = new BigDecimal(tempmap.get("wx_spend")).add(new BigDecimal(spend));
                                tempmap.put("wx_spend", String.valueOf(spendWx));
                            }
                        }else {
                            Map<String, String> map1 = Maps.newHashMap();
                            map1.put("port_number", port_code);
                            map1.put("day",  LocalDit.getDayOfYears(update_time));
                            map1.put("week", LocalDit.getWeekOfYears(update_time));
                            map1.put("month", LocalDit.getMonthOfYears(update_time));

                            if(pay_type.equals("2002")){ //支付宝
                                map1.put("ali_spend", spend);
                                map1.put("wx_spend", "0");
                            }else{
                                map1.put("wx_spend", spend);
                                map1.put("ali_spend", "0");
                            }
                            map.put(key, map1);
                        }
                    }
                }
        );
        return  map;
    }
}
