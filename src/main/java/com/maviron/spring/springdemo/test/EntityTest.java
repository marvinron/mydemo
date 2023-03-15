package com.maviron.spring.springdemo.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EntityTest.java
 * @Description 测试用的实体类
 * @createTime 2022年10月11日 15:21:00
 */
public class EntityTest implements Serializable {
    private static final long serialVersionUID = 5267145989015295486L;
    /**
     * 日期
     */
    private String dt;
    /**
     * 留存天数
     */
    private String retentionDay;
    /**
     * 留存数量
     */
    private String retentionCount;
    /**
     * 新用户数
     */
    private String newUserCount;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getRetentionDay() {
        return retentionDay;
    }

    public void setRetentionDay(String retentionDay) {
        this.retentionDay = retentionDay;
    }

    public String getRetentionCount() {
        return retentionCount;
    }

    public void setRetentionCount(String retentionCount) {
        this.retentionCount = retentionCount;
    }

    public String getNewUserCount() {
        return newUserCount;
    }

    public void setNewUserCount(String newUserCount) {
        this.newUserCount = newUserCount;
    }
    public int getRetentionIntValue(){
        return Integer.valueOf(retentionCount);
    }

    @Override
    public String toString() {
        return "EntityTest{" +
                "dt='" + dt + '\'' +
                ", retentionDay='" + retentionDay + '\'' +
                ", retentionCount='" + retentionCount + '\'' +
                ", newUserCount='" + newUserCount + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //List<EntityTest> list = new ArrayList<>();
        //EntityTest entityTest1 = new EntityTest();
        //entityTest1.setDt("1");
        //entityTest1.setNewUserCount("200");
        //entityTest1.setRetentionCount("300");
        //EntityTest entityTest2 = new EntityTest();
        //entityTest2.setDt("1");
        //entityTest2.setNewUserCount("200");
        //entityTest2.setRetentionCount("300");
        //EntityTest entityTest3 = new EntityTest();
        //entityTest3.setDt("1");
        //entityTest3.setNewUserCount("200");
        //entityTest3.setRetentionCount("300");
        //list.add(entityTest1);
        //list.add(entityTest2);
        //list.add(entityTest3);
        //System.out.println(JSON.toJSONString(list));
        //DateTime truncate = DateUtil.truncate(new Date(), DateField.HOUR);
        //System.out.println(truncate);
        //Object s = DateUtil.offsetHour(new Date(), -1).hour(true);
        //DateTime yyyyMMddHH = DateUtil.parse("2022120712", "yyyyMMddHH");
        //String s1 = yyyyMMddHH.toDateStr();
        //System.out.println(s1);
        //System.out.println(s);
        //String dateTime = DateUtil.format(DateUtil.offsetHour(new Date(), -1),"yyyyMMddHH");
        //
        //System.out.println(dateTime);
        //
        //List<Integer> integers = CollectionUtil.newArrayList(1,2,3,4);
        //System.out.println(integers);
        //Collections.shuffle(integers);
        //System.out.println(integers);
        //List<Integer> list1 = CollectionUtil.removeAny(integers, 2);
        //System.out.println(list1);
        String str = "edcf7d820597b20a65d05f3c0cc7f75e;png;splash;gdt;1677922103000,edcf7d820597b20a65d05f3c0cc7f75e;png;splash;gdt;1677922103000,d13161233e1599631417fc2fb198c484;png;splash;gdt;1677922103000,d13161233e1599631417fc2fb198c484;png;splash;gdt;1677922103000,1ab9e3feb0c9aa2d0e8409ced73a0296;png;splash;gdt;1677922103000,1ab9e3feb0c9aa2d0e8409ced73a0296;png;splash;gdt;1677922103000,a5f1cee6894d979e043ccf0114a54964;png;splash;gdt;1677922106000,a5f1cee6894d979e043ccf0114a54964;png;splash;gdt;1677922106000,8fddf8b3e2c63405a932f110f788658a;png;splash;gdt;1677922279000,8fddf8b3e2c63405a932f110f788658a;png;splash;gdt;1677922279000,65df444aff28956011c9f8e1589a0c06;png;splash;gdt;1677922600000,38a7af7c4254fb989f9378257237a3a0;png;splash;gdt;1677923114000,38a7af7c4254fb989f9378257237a3a0;png;splash;gdt;1677923114000,5d6a2832f51a3554746893c8f24d86b1;png;splash;gdt;1677923340000,5d6a2832f51a3554746893c8f24d86b1;png;splash;gdt;1677923340000,7291dbaa607c0e90c3f5ce798071cee0;png;splash;gdt;1677923518000,7291dbaa607c0e90c3f5ce798071cee0;png;splash;gdt;1677923518000,7ae7362714f557387a9766a8ab28a993;png;splash;gdt;1677923588000,7ae7362714f557387a9766a8ab28a993;png;splash;gdt;1677923588000,5661a7b995a3d8995eb771313fcc002c;png;splash;gdt;1677929504000,5661a7b995a3d8995eb771313fcc002c;png;splash;gdt;1677929504000,ada8cc014eb5d829521635e1d8f4bd2c;png;splash;gdt;1677929877000,ada8cc014eb5d829521635e1d8f4bd2c;png;splash;gdt;1677929877000,null,28d03335c6a9630f68587dd47b1046c9;png;splash;gdt;1677930167000,a21da0ca48da060545fadb3ea27cd764;png;splash;gdt;1677930474000,8ecbca2b34bf5738ec84544f4ad38bed;png;splash;gdt;1677930474000,8ecbca2b34bf5738ec84544f4ad38bed;png;splash;gdt;1677930474000,8fddf8b3e2c63405a932f110f788658a;png;splash;gdt;1677931287000,af1b9f659ebe557861be1c5a45194c71;png;splash;gdt;1677931545000,c2ed2ac7acf7ba2b352c01fbec68f231;png;splash;gdt;1677931545000,d13161233e1599631417fc2fb198c484;png;splash;gdt;1677931608000,8fddf8b3e2c63405a932f110f788658a;png;splash;gdt;1677931994000,d87dc2fc12ebe6397feb16c46f5ca3be;png;splash;gdt;1677932344000,63cb10730e33097b07e6ef65682dd5b1;png;splash;gdt;1677933076000,a871a3696732cdffa9e8c6699979e7de;png;splash;gdt;1678008060000,8fddf8b3e2c63405a932f110f788658a;png;splash;gdt;1678008091000,4807d3ab670c012a73fceac2b7e8fc53;png;splash;gdt;1678008104000,4807d3ab670c012a73fceac2b7e8fc53;png;splash;gdt;1678008104000,dd3208b2087a0cdd83ade08160193d8d;png;splash;gdt;1678008706000,dbf14131025a483da24f60f9593a191f;png;splash;gdt;1678008706000,71c5a2d256dfae0272c5fa2b7d7d3127;png;splash;gdt;1678008722000,71c5a2d256dfae0272c5fa2b7d7d3127;png;splash;gdt;1678008722000,19c753e57ffe8bc9a1811ed404930c54;png;splash;gdt;1678010677000,dbf14131025a483da24f60f9593a191f;png;splash;gdt;1678010677000,dbf14131025a483da24f60f9593a191f;png;splash;gdt;1678010677000,4265305fb2569cfa5bd4692f2a2123da;png;splash;gdt;1678010804000,4265305fb2569cfa5bd4692f2a2123da;png;splash;gdt;1678010804000,b02622018eefdcac84146d364775dd4a;png;splash;gdt;1678010805000,b02622018eefdcac84146d364775dd4a;png;splash;gdt;1678010805000,064e1946437711fbef97866eee7050c8;png;splash;gdt;1678010857000,064e1946437711fbef97866eee7050c8;png;splash;gdt;1678010857000,16e452685f489425c2a8debd92ac5e26;png;splash;gdt;1678010857000,16e452685f489425c2a8debd92ac5e26;png;splash;gdt;1678010857000,34af423fd2b004586b8c0a40c31432df;png;splash;gdt;1678011224000,34af423fd2b004586b8c0a40c31432df;png;splash;gdt;1678011224000,a0d413780c9531a121c2757fa6b8c78a;png;splash;gdt;1678011224000,a0d413780c9531a121c2757fa6b8c78a;png;splash;gdt;1678011224000,86f9bcf775a63f1851e80da8f93855ea;png;splash;gdt;1678096719000,138b0fa9aa06a19efc18273321d42d7b;png;splash;gdt;1678098961000,f6b312996148c1c902a45ab1249c3f37;png;splash;gdt;1678099266000,f6b312996148c1c902a45ab1249c3f37;png;splash;gdt;1678099266000,c332dad567d6a987973d9af30029f061;png;splash;gdt;1678099623000,c332dad567d6a987973d9af30029f061;png;splash;gdt;1678099623000,ff424dce592deac5d2e139acea3b883d;png;splash;gdt;1678099623000,ff424dce592deac5d2e139acea3b883d;png;splash;gdt;1678099623000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678099680000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678099680000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678100025000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678100025000,d13161233e1599631417fc2fb198c484;png;splash;gdt;1678101763000,d13161233e1599631417fc2fb198c484;png;splash;gdt;1678101763000,9414389b6b7d58a0216e37cf9de3da03;png;splash;gdt;1678102007000,9414389b6b7d58a0216e37cf9de3da03;png;splash;gdt;1678102007000,bd9ddfac143ae4cb31c609bb25f7dfd4;png;splash;gdt;1678102250000,2f787dd4680ac1a04d82f4c2a1f55344;png;splash;gdt;1678103144000,2f787dd4680ac1a04d82f4c2a1f55344;png;splash;gdt;1678103144000,75ac67d43dd33acca23fcefb74359ab5;png;splash;gdt;1678103810000,75ac67d43dd33acca23fcefb74359ab5;png;splash;gdt;1678103810000,f71b7ed4c71241f78ce059642e8bedb2;png;splash;gdt;1678104233000,f71b7ed4c71241f78ce059642e8bedb2;png;splash;gdt;1678104233000,3accc38b87af362d351f8efefc5fd803;png;splash;gdt;1678104414000,3accc38b87af362d351f8efefc5fd803;png;splash;gdt;1678104414000,d68050c4528eb46dc8ee8d981c514405;png;splash;gdt;1678104416000,28d03335c6a9630f68587dd47b1046c9;png;splash;gdt;1678104725000,28d03335c6a9630f68587dd47b1046c9;png;splash;gdt;1678104725000,feca3b37b568c3403244c3b0c8d24815;png;splash;gdt;1678105092000,feca3b37b568c3403244c3b0c8d24815;png;splash;gdt;1678105092000,f27b5c9b5b7e9a87318c564b38ceb98b;png;splash;gdt;1678105139000,f27b5c9b5b7e9a87318c564b38ceb98b;png;splash;gdt;1678105139000,1481bb20a5a051c3f1bc76397649c27f;png;splash;gdt;1678105324000,1481bb20a5a051c3f1bc76397649c27f;png;splash;gdt;1678105324000,5ce6e2bf517781a4bdd786b512a67902;png;splash;gdt;1678181288000,5ce6e2bf517781a4bdd786b512a67902;png;splash;gdt;1678181288000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678182416000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678182416000,ee22dd0cbb10ffd783925b41f6eb080f;png;splash;gdt;1678185126000,622427da5d28f6dfbb7954362a083674;png;splash;gdt;1678185414000,622427da5d28f6dfbb7954362a083674;png;splash;gdt;1678185414000,857eefe212d41221319afef0e3a21a6e;png;splash;gdt;1678185417000,857eefe212d41221319afef0e3a21a6e;png;splash;gdt;1678185417000,1ff60a98750cc606f30e2b43804389ac;png;splash;gdt;1678187164000,1ff60a98750cc606f30e2b43804389ac;png;splash;gdt;1678187164000,a4f84daa55a8419874d3f81e06a5dd3e;png;splash;gdt;1678187170000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678188776000,ca7dd2e29feba2bb6956818a2a8bee9f;png;splash;gdt;1678188776000,144022edbcf3a982891883e6ecf2e9f0;png;splash;gdt;1678190185000,144022edbcf3a982891883e6ecf2e9f0;png;splash;gdt;1678190185000,e1228b238f5f531dce65f9403e045bea;png;splash;gdt;1678191225000,e1228b238f5f531dce65f9403e045bea;png;splash;gdt;1678191225000,22167e9cf76821edf5b601e29b79cd27;png;splash;gdt;1678271760000,22167e9cf76821edf5b601e29b79cd27;png;splash;gdt;1678271760000,eba6c0774cee2d15092cb8ec44950af6;png;splash;gdt;1678271766000,eba6c0774cee2d15092cb8ec44950af6;png;splash;gdt;1678271766000,1ffd4e905608a22ed3c6cdb0cedebf56;png;splash;gdt;1678271792000,82c5e7c2cca89970ef9262a34ffa526e;png;splash;gdt;1678271819000,82c5e7c2cca89970ef9262a34ffa526e;png;splash;gdt;1678271819000,f0b5280a866637bbe5510364e612cc0d;png;splash;gdt;1678271819000,f0b5280a866637bbe5510364e612cc0d;png;splash;gdt;1678271819000,144022edbcf3a982891883e6ecf2e9f0;png;splash;gdt;1678271855000,144022edbcf3a982891883e6ecf2e9f0;png;splash;gdt;1678271855000,8c0670ff1097627f41d31ffa09dde6c6;png;splash;gdt;1678272227000,ff46c3b8506f1c50714514501938b8c0;png;splash;gdt;1678272242000,656fb1ca64d6a34e2155064d282d76c3;png;splash;gdt;1678272389000,023480eb6d47e6eded0aeea6d170d936;png;splash;gdt;1678273672000,023480eb6d47e6eded0aeea6d170d936;png;splash;gdt;1678273672000,857eefe212d41221319afef0e3a21a6e;png;splash;gdt;1678274991000,857eefe212d41221319afef0e3a21a6e;png;splash;gdt;1678274991000,7fa13be78e0ef25ca19990384e6a7087;png;splash;gdt;1678274107000,7fa13be78e0ef25ca19990384e6a7087;png;splash;gdt;1678274107000,703d4f034c4e503049819bc375717bdb;png;splash;gdt;1678274998000,8898f2130ff88066f79d4b4ccf5f5a33;png;splash;gdt;1678274998000,8898f2130ff88066f79d4b4ccf5f5a33;png;splash;gdt;1678274998000,f70a82f0dfc5bb92cf1626a25c68ab08;png;splash;gdt;1678275043000,f70a82f0dfc5bb92cf1626a25c68ab08;png;splash;gdt;1678275043000,462e84d5130afb2bdf1341f294001c5e;png;splash;gdt;1678275043000,462e84d5130afb2bdf1341f294001c5e;png;splash;gdt;1678275043000,a6edf497e2948034d98670bd4f4d88b8;png;splash;gdt;1678275043000,a6edf497e2948034d98670bd4f4d88b8;png;splash;gdt;1678275043000,07784346bbe92fa464f4a28d686cdb33;png;splash;gdt;1678351703000,07784346bbe92fa464f4a28d686cdb33;png;splash;gdt;1678351703000,d18c12308de35f27135494b024877ac5;png;splash;gdt;1678351710000,d18c12308de35f27135494b024877ac5;png;splash;gdt;1678351710000,6e1fca36dc61eefa9b7c5c3af8532f5e;png;splash;gdt;1678272405000,857eefe212d41221319afef0e3a21a6e;png;splash;gdt;1678272723000,857eefe212d41221319afef0e3a21a6e;png;splash;gdt;1678272723000,19abff54bd4a8e45329f502ebf3f5d60;png;splash;gdt;1678273217000,19abff54bd4a8e45329f502ebf3f5d60;png;splash;gdt;1678273217000,7cb0af5e798b8e7e3ee17a639acc4fea;png;splash;gdt;1678273218000,7cb0af5e798b8e7e3ee17a639acc4fea;png;splash;gdt;1678273218000,f8f86311e48117139a0fdf82920d4637;png;splash;gdt;1678273262000,756c3d5e16e1cd738a250842eee2c96e;png;splash;gdt;1678273674000,756c3d5e16e1cd738a250842eee2c96e;png;splash;gdt;1678273674000,1e91e4ae3b21e41e0f039f9dca29bf61;png;splash;gdt;1678273674000,c0906dec918705cedbe1a6df70a88e76;png;splash;gdt;1678274107000,c0906dec918705cedbe1a6df70a88e76;png;splash;gdt;1678274107000,d4ea3cbaac43fd038ac58a50217684f8;png;splash;gdt;1678275043000,d4ea3cbaac43fd038ac58a50217684f8;png;splash;gdt;1678275043000,9ad2925d2c179762ae28b52e386e949e;png;splash;gdt;1678275043000,9ad2925d2c179762ae28b52e386e949e;png;splash;gdt;1678275043000,d88557b522e17a8cc0fa12c87525b911;png;splash;ks;1678010699000,d88557b522e17a8cc0fa12c87525b911;png;splash;ks;1678010699000,e8fd6fbe2c1ea673d84959f752f24412;png;splash;ks;1678010693000,e8fd6fbe2c1ea673d84959f752f24412;png;splash;ks;1678010693000,8a93cb37ef74debaeddb3075000c520f;png;splash;ks;1678010693000,8a93cb37ef74debaeddb3075000c520f;png;splash;ks;1678010693000,58165ff83082ac8573bafaeaf17149f6;png;splash;ks;1678010696000,58165ff83082ac8573bafaeaf17149f6;png;splash;ks;1678010696000,bd7c0682cfbfb39cd2c0e7fcbcc529b1;png;splash;ks;1678010699000,796e414ba73e84fed541afe16964bed6;png;splash;ks;1678100889000,46cc4b056a84cd7b516623173cac09a5;png;splash;ks;1678010699000,46cc4b056a84cd7b516623173cac09a5;png;splash;ks;1678010699000,9f0318caabf569ab0556f5ce23908cc1;png;splash;ks;1678010701000,9f0318caabf569ab0556f5ce23908cc1;png;splash;ks;1678010701000,aedf93e9faa3353586caaf451b895745;png;splash;ks;1678010701000,964e62d0acfe94e307ae043c9674f19d;png;splash;ks;1678010711000,4b272626df075b117f1bd0ce9d8b07e5;png;splash;ks;1678010742000,8a93cb37ef74debaeddb3075000c520f;png;splash;ks;1678010742000,a963d7365655b040e4e1fbe05ec77aea;png;splash;ks;1678010745000,a963d7365655b040e4e1fbe05ec77aea;png;splash;ks;1678010745000,83f967de2c66feab2e67b22fa9733679;png;splash;ks;1678011170000,83f967de2c66feab2e67b22fa9733679;png;splash;ks;1678011170000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011189000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011189000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011189000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011189000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011193000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011194000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011195000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011195000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011197000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011197000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011201000,769ff8c1bfe84906056fab3eed634104;png;splash;ks;1678011201000,769ff8c1bfe84906056fab3eed634104;png;splash;ks;1678011201000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011209000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011209000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011210000,5d11537f5d0dee4e4c935d123c900a0c;png;splash;ks;1678011210000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678011213000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678011213000,f7c59e1e2f467470c210719b64b4f11b;png;splash;ks;1678012744000,f7c59e1e2f467470c210719b64b4f11b;png;splash;ks;1678012744000,f7c59e1e2f467470c210719b64b4f11b;png;splash;ks;1678012747000,f7c59e1e2f467470c210719b64b4f11b;png;splash;ks;1678012747000,f7c59e1e2f467470c210719b64b4f11b;png;splash;ks;1678012748000,f7c59e1e2f467470c210719b64b4f11b;png;splash;ks;1678012748000,d285130cb551eb85fb57cc7f19c784d1;png;splash;ks;1678012884000,d285130cb551eb85fb57cc7f19c784d1;png;splash;ks;1678012884000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678012892000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678012892000,b00904896c62fbb66203fb682bc07c8c;png;splash;ks;1678012893000,b00904896c62fbb66203fb682bc07c8c;png;splash;ks;1678012894000,b00904896c62fbb66203fb682bc07c8c;png;splash;ks;1678012894000,b00904896c62fbb66203fb682bc07c8c;png;splash;ks;1678012898000,b00904896c62fbb66203fb682bc07c8c;png;splash;ks;1678012901000,b00904896c62fbb66203fb682bc07c8c;png;splash;ks;1678012902000,6e9a6994a84ff0cc6fb5b8b83e8a9fa1;png;splash;ks;1678013282000,9f0318caabf569ab0556f5ce23908cc1;png;splash;ks;1678013282000,9f0318caabf569ab0556f5ce23908cc1;png;splash;ks;1678013282000,9bbaa5abc76752f93dc0b0213d5e7323;png;splash;ks;1678013282000,9bbaa5abc76752f93dc0b0213d5e7323;png;splash;ks;1678013282000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678013410000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678013420000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678013420000,f46500a9496d32625c23ee119b6cd74c;png;splash;ks;1678013420000,null,980645af7ce5fe61ddafcb411b87c598;png;splash;ks;1678096720000,75a3ea935e6fd18a0123673affec19b5;png;splash;ks;1678096723000,e234dde5fc667ed21d94003dd9bd6139;png;splash;ks;1678097829000,58165ff83082ac8573bafaeaf17149f6;png;splash;ks;1678097829000,a839c741061fc3a5983f7c7090c618c1;png;splash;ks;1678097853000,a839c741061fc3a5983f7c7090c618c1;png;splash;ks;1678097862000,a839c741061fc3a5983f7c7090c618c1;png;splash;ks;1678097864000,d3533ecbc7ddcceceda2bbe643f35c40;png;splash;ks;1678097871000,d3533ecbc7ddcceceda2bbe643f35c40;png;splash;ks;1678097875000,d3533ecbc7ddcceceda2bbe643f35c40;png;splash;ks;1678097876000,1dce169947105a1d26eefb93db832533;png;splash;ks;1678100046000,1dce169947105a1d26eefb93db832533;png;splash;ks;1678100047000,796e414ba73e84fed541afe16964bed6;png;splash;ks;1678100884000,796e414ba73e84fed541afe16964bed6;png;splash;ks;1678100884000,796e414ba73e84fed541afe16964bed6;png;splash;ks;1678100885000,";
        List<String> strings = Stream.of(str.split(",")).collect(Collectors.toList());
        System.out.println(strings.size());
        for (String md5Str : strings) {
            String[] strList = md5Str.split(";");
            System.out.println(strList[0]+"===="+strList[1]+"==="+strList[2]+"===="+strList[3]+"===="+strList[4]);

        }

    }
}
