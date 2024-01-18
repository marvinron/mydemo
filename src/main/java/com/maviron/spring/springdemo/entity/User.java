package com.maviron.spring.springdemo.entity;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年01月10日 09:22:00
 */
//@Configuration
public class User implements Serializable {
    private static final long serialVersionUID = 1015995795755954005L;
    private static final Logger log = LoggerFactory.getLogger(User.class);
    private String id;

    @NotNull(message = "姓名不能为空")
    @Size(min = 1, max = 20, message = "姓名长度必须在1-20之间")
    //@Value("${name}")
    private String name;

    @Min(value = 10, message = "年龄必须大于10")
    @Max(value = 150, message = "年龄必须小于150")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    private Long sequence;
    private UserVo userVo;
    private Double salery;


    public Double getSalery() {
        return salery;
    }

    public void setSalery(Double salery) {
        this.salery = salery;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sequence=" + sequence +
                '}';
    }

    public static void main(String[] args) {
        try {


            //String json = "{\n" +
            //        "  \"id\": \"\",\n" +
            //        "  \"name\": \"\",\n" +
            //        "  \"age\": 0,\n" +
            //        "  \"email\": \"\",\n" +
            //        "  \"sequence\": \"80\",\n" +
            //        "}";
            //User user = JSONObject.parseObject(json, User.class);
            //System.out.println(user);
            //MailAccount account = new MailAccount();
            //account.setHost("smtp.163.com");
            //account.setPort(25);
            ////account.setAuth(true);
            //account.setFrom("houlei801@163.com");
            //account.setUser("houlei801@163.com");
            //account.setPass("PFUOFODCGSVXRMQL");
            //account.setSslEnable(true);
            //MailUtil.send(account, "houlei801@163.com", "大数据发送的信息", "value", false);
            List<User> list = new ArrayList<>();
            User user = new User();
            user.setName("adasdas");
            user.setEmail("asdsa@163");
            user.setAge(18);
            User user1 = new User();
            user1.setName("adasdas12321");
            user1.setEmail("asdsa@16312321");
            user1.setAge(19);
            User user2 = new User();
            user2.setName("adasdas12321");
            user2.setEmail("asdsa@16312321");
            user2.setAge(19);
            list.add(user);
            list.add(user1);
            list.add(user2);
            String string = JSONObject.toJSONString(list);
            System.out.println(string);
            //URI uri = new URI("http://www.baidu.com");
            URI uri = new URI("pddopen://pinduoduo?h5Url=mtr_portals.html%3F_p_acc%3D100001%26_p_source%3D0%26_pdd_tc%3Dffffff%26_p_cate1_id%3D6536%26mat2_type%3D6%26_p_ads_id%3D-1%26_p_jump_id%3D1270%26delay_bid%3D0%26_p_vids%3D20928%2C19744%2C20450%2C18051%2C20451%2C20772%2C20901%2C20997%2C20645%2C20870%2C20614%2C400001%2C19976%2C20842%2C15630%2C20494%2C20590%2C20758%2C20925%2C20094%2C20927%2C21023%2C11839%26resfm%3D0%26_p_it_type%3D%26bid_adjust_tag%3D2%26_p_ads_sub_channel%3Dmrk_union_hxly%26sn%3D210310xbpy%26_p_ads_channel%3Dmrk_union%26_p_ads_csite%3Du_aff_splsh%26lego_ssr_api%3D%252Fapi%252Fmobile_tarot_lego%252Fget_config%252Fdp%26lpck%3D69cd3af7567d690a_1705478022448%26lego_minversion%3D5.23.0%26_p_ads_type%3Dlaxin%26_pdd_fs%3D1%26_p_ads_set%3D10004610%26ad_ltv%3D26.399981506347658%26_p_launch_id%3D3d3c560a8687a765920100007fa4b409ede08df7_0%26_p_super_channel%3Dmrk_union_hxly%26_p_bucket_dsp%3D26%26goods_id%3D269552136773%26lego_type%3Dv8%26_pdd_sbs%3D1%26_p_launch_type%3Ddsp%26_p_mat_pkg_id%3D5711671%26_p_creative_id%3D101496527346%26_p_pdd_bid_id%3D3d3c560a8687a765920100007fa4b409ede08df7_0%26_pdd_fs_h5%3D1%26_p_display_id%3D549%26st8%3D0%26y20%3D400001%26_oc_ads_channel%3Dmrk_union%26st11%3D0%26_p_mt_id%3D101496527346%26_p_soid%3D3d3c560a8687a765920100007fa4b409ede08df7%26_p_plgsn%3D73a72af2e5dfa6e7198af50aac7df845%26exp2_did%3D7a7a0e30cac21f4a42f1355df01df62d%26_pdd_nc%3DF52B4A%26_p_vers%3DA25-L121-V219-F151-S16&direct_back=true");
            //String schemeSpecificPart = uri.getSchemeSpecificPart();
            //String host = uri.getHost();
            //System.out.println(host);
            String scheme = uri.getScheme();
            System.out.println(scheme);
        } catch (Exception e) {
            log.error("user参数异常！", e.getMessage(),e);

        }


    }
}
