package com.maviron.spring.springdemo.dpvalidater;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class DeepLinkHeaderExtractor {  

    public static void main(String[] args) {  
        String inputUrl = "hap%3A%2F%2Fapp%2Fcom.application.modou%2Fpages%2FHome%3Fcontent_id%3D96457195%26adgroup_id%3D45117118%26campaign_id%3D31537749%26callback%3D45081278%252620240731071314203717434%25261445775530375796736%2526com.application.modou%26referrer%3Dhuaweiads_20240731071314203717434%26channel%3Dhuaweiads%26ip%3D223.104.218.50%26oaid%3Dfe879dd4-bdd8-4571-8a4b-1372c8afd798%26tracking_enabled%3D1%26corp_id%3D1445775530375796736%26campaign_name%3D%E8%B4%A7%E4%B8%8D%E5%AF%B9%E7%89%88-%E7%A8%B3%E5%AE%9A%E6%8B%BF%E9%87%8F-%E9%B8%BF%E8%92%99%E7%94%9F%E6%80%81%E5%BA%94%E7%94%A8-%E6%B2%B3%E7%A5%9E%E7%9A%84%E6%96%B0%E5%A8%98-%E5%A4%9A%E5%9B%BE-240711-%E9%80%9A%E6%8A%95-%E8%87%AA%E5%AE%9A%E4%B9%89%E7%BD%91%E9%A1%B5ocpc-AI%E7%B1%BB-copy2024-07-12+17%3A20%3A43-copy2024-07-18+14%3A31%3A05%26adgroup_name%3D%E8%B4%A7%E4%B8%8D%E5%AF%B9%E7%89%88-%E7%A8%B3%E5%AE%9A%E6%8B%BF%E9%87%8F-%E9%B8%BF%E8%92%99%E7%94%9F%E6%80%81%E5%BA%94%E7%94%A8-%E6%B2%B3%E7%A5%9E%E7%9A%84%E6%96%B0%E5%A8%98-%E5%A4%9A%E5%9B%BE-240711-%E9%80%9A%E6%8A%95-%E8%87%AA%E5%AE%9A%E4%B9%89%E7%BD%91%E9%A1%B5ocpc-AI%E7%B1%BB-copy2024-07-12+17%3A20%3A43-copy2024-07-18+14%3A31%3A05%26content_name%3D%E9%B8%BF%E8%92%99%E7%94%9F%E6%80%81%E5%BA%94%E7%94%A8-1%26emui_version%3D%26transunique_id%3D20240731071314203717411_t9kn4y47fy_1%26os_version%3D12.0.0%26device_id%3D%26id_type%3D%26publisher_type%3D2%26log_id%3D20240731071314203717434%26channel%3Dmod_hw_dq_zd%26QUICKST_CHANNEL%3Dmod_hw_dq_zd%26id%3D856%26platform%3Dhuawei%26position%3D4683%2F";

        // 提取 dp 头  
        String dp = extractDpHeader(inputUrl);  
        if (dp != null) {  
            System.out.println("提取的 dp 头: " + dp);  
        } else {  
            System.out.println("未找到 dp 头。");  
        }  
    }  

    private static String extractDpHeader(String url) {  
        // 解码 URL  
        String decodedUrl;  
        try {  
            decodedUrl = URLDecoder.decode(url, "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  

        // 正则表达式匹配 dp 参数  
        Pattern pattern = Pattern.compile("dp=([^&]*)");  
        Matcher matcher = pattern.matcher(decodedUrl);  
        return matcher.find() ? matcher.group(1) : null;  
    }  
}