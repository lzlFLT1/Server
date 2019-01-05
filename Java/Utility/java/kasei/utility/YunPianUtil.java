package com.rongyue.efix.utility;

import com.google.gson.Gson;
import com.rongyue.efix.config.YunPianConfig;

import java.util.HashMap;
import java.util.Map;

public class YunPianUtil {

    /**
     * todo 发送单条短信
     * */
    public static Map<String, Object> sendSingleSMS(String receiveTel, String content){
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", YunPianConfig.API_KEY);
        params.put("mobile", receiveTel);
        params.put("text", content);
        String s = HttpClientUtil.postForm("https://sms.yunpian.com/v2/sms/single_send.json", params);
        return new Gson().fromJson(s, Map.class);
    }
}
