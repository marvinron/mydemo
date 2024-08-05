package com.maviron.spring.springdemo.dpvalidater;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class DeepLinkExtractor {  

    private static final String LINK_REGEX = "(?<=\\s|^)([a-zA-Z]+%3A%2F%2F[^\\s]+?)(?=\\s|$)";  

    public static void main(String[] args) {  
        String inputText = "hap%3A%2F%2Fapp%2Fcom.application.modou%2Fpages%2FHome%3Fcontent_id%3D96457195... tpopen%3A%2F%2Fapp%2Fcom.application.modou%2Fpages%2FHome%3Fcontent_id%3D96457195...";
        
        // 提取 deeplink  
        String extractedLink = extractDeepLink(inputText);  

        if (extractedLink != null) {  
            System.out.println("提取的 deeplink (编码): " + extractedLink);  
            String decodedLink = decodeLink(extractedLink);  
            System.out.println("解码后的 deeplink: " + decodedLink);  
        } else {  
            System.out.println("没有找到 deeplink。");  
        }  
    }  

    private static String extractDeepLink(String text) {  
        Pattern pattern = Pattern.compile(LINK_REGEX);  
        Matcher matcher = pattern.matcher(text);  
        return matcher.find() ? matcher.group(1) : null;  
    }  

    private static String decodeLink(String encodedLink) {  
        try {  
            return URLDecoder.decode(encodedLink, "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}