package com.maviron.spring.springdemo.arithmetic;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public static List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList();
        List<String> temp=new ArrayList();
        backTracking(s,0,ans,temp);
        return ans;
    }

    public static void backTracking(String s,int begin,List<String> ans,List<String> temp){
        if(temp.size()==4){
            //有效的ip段，加入结果集
            if(begin==s.length()){
                ans.add(String.join(".",temp));
            }
            return;
        }
        //每次取3位以下的字符作为一段ip。这里也是减枝的情况。
        for(int i=begin;i<begin+3&&i<s.length();++i){
            String sub=s.substring(begin,i+1);
            //不是有效的ip段，减枝
            if(!isRange(sub)){
                continue;
            }
            temp.add(sub);
            backTracking(s,i+1,ans,temp);
            //回溯
            temp.remove(temp.size()-1);
        }
    }
    
    public static boolean isRange(String sub){
        if(sub.length()!=1&&sub.charAt(0)=='0'){
            return false;
        }
        return Integer.parseInt(sub)<=255?true:false;
    }

    public static void main(String[] args) {
        restoreIpAddresses("11234567");
    }
}