package com.maviron.spring.springdemo.demo;

import com.maviron.spring.springdemo.dto.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestService.java
 * @Description TODO
 * @createTime 2021年11月22日 15:53:00
 */
public class TestService extends BaseService {
    public Object getResponse(Object req) {
        return service(req);
    }

    @Override
    protected void validateRequest(Object o) {
        System.out.println("来自testservice的验证");
    }

    public static void main(String[] args) {
        //JSONObject jsonObject = new JSONObject();
        //jsonObject.put("5","12");
        //jsonObject.put("6","13");
        //jsonObject.put("7","11");
        //jsonObject.put("8","10");
        //List<Integer> collect = jsonObject.keySet().stream().map(Integer::valueOf).filter(value -> value > 6).collect(Collectors.toList());
        //int sum = jsonObject.entrySet().stream().filter(entry -> Integer.valueOf(entry.getKey()) > 6).mapToInt(entry -> Integer.parseInt((String) entry.getValue())).sum();
        //JSONObject jsonObject1 = JSONObject.parseObject("");
        //System.out.println(jsonObject1.getString("dabai"));
        //System.out.println(sum);
        //System.out.println(collect);
        //String str = "AB,BC,EF,C";
        //String sorce = "ABCDEFC";
        //String[] split = StringUtils.split(str, ",");
        //Arrays.stream(split).forEach(s->{
        //    if(sorce.indexOf(s) != -1){
        //        System.out.println("存在 "+sorce.indexOf(s));
        //    }else{
        //        System.out.println("不存在");
        //    }
        //});
        //String replace = UUID.randomUUID().toString().replace("-", "");
        //System.out.println(replace);
        //String ua = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 momoWebView/9.9.4 ios/5768(iPhone15,3;iOS 16.6;zh_CN;S1;netType/0/;appId/momo;statusBar/54 iPhoneWithNotch isSameLayer)";
        //UserAgent parse = UserAgentUtil.parse(ua);
        //String name = parse.getEngine().getName();
        //System.out.println(name);
        //String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 momoWebView/9.9.4 ios/5768(iPhone15,3;iOS 16.6;zh_CN;S1;netType/0/;appId/momo;statusBar/54 iPhoneWithNotch isSameLayer)";

        // 查找应用程序标识符的起始位置
        //   int startIndex = userAgent.indexOf("(");
        //   if (startIndex != -1) {
        //       startIndex++; // 跳过左括号
        //       int endIndex = userAgent.indexOf(")", startIndex);
        //       if (endIndex != -1) {
        //           String appInfo = userAgent.substring(startIndex, endIndex);
        //           // 进一步处理应用程序信息
        //           String[] appInfoArray = appInfo.split(";");
        //           for (String info : appInfoArray) {
        //               System.out.println(info.trim());
        //           }
        //       }
        //   }
        //   String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 momoWebView/9.9.4 ios/5768(iPhone15,3;iOS 16.6;zh_CN;S1;netType/0/;appId/momo;statusBar/54 iPhoneWithNotch isSameLayer)";
        //
        //   // 定义正则表达式
        //   Pattern pattern = Pattern.compile("appId/([^\\s;]+)");
        //
        //   // 匹配正则表达式
        //   Matcher matcher = pattern.matcher(userAgent);
        //
        //   // 查找匹配项
        //   if (matcher.find()) {
        //       String appId = matcher.group(1);
        //       System.out.println("App ID: " + appId);
        //   } else {
        //       System.out.println("未找到应用程序标识符");
        //   }

        Map<String, User> map = new HashMap<>();
        map.put("A", new User(1, "", 18, 10,"123"));
        map.put("B", new User(2, "xiaoming,xiaogang", 19,10,"123"));
        Map<String, Map<String, String>> collect = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
            String names = entry.getValue().getName();
            Map<String, String> userMap = new HashMap<>();
            if(StringUtils.isEmpty(names)){
                return userMap;
            }
            Arrays.stream(StringUtils.split(names, ",")).forEach(str -> {
                userMap.put(str, null);
            });
            return userMap;
        }));
        System.out.println(collect);


    }
}
