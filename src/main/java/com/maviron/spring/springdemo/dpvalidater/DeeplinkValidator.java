package com.maviron.spring.springdemo.dpvalidater;

import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.core.util.URLUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.util.DecodeUtils;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;

public class DeeplinkValidator {
    public static boolean validateDeeplink(String deeplink) {
        //String deeplinkRegex = "^(?!http|https).*";
        String deeplinkRegex = "^(?!http|https)\\w+://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/\\S*)?$";
        return deeplink.matches(deeplinkRegex);
    }

    public static void main(String[] args) throws Exception{
        String deeplink = "tptaobao://example.com/page1";
        if (validateDeeplink(deeplink)) {
            System.out.println("Deeplink is valid");
        } else {
            System.out.println("Deeplink is invalid");
        }
        String str = "hap%3A%2F%2Fapp%2Fcom.application.modou%2Fpages%2FHome%3Fcontent_id%3D96457195%26adgroup_id%3D45117118%26campaign_id%3D31537749%26callback%3D45081278%252620240731071314203717434%25261445775530375796736%2526com.application.modou%26referrer%3Dhuaweiads_20240731071314203717434%26channel%3Dhuaweiads%26ip%3D223.104.218.50%26oaid%3Dfe879dd4-bdd8-4571-8a4b-1372c8afd798%26tracking_enabled%3D1%26corp_id%3D1445775530375796736%26campaign_name%3D%E8%B4%A7%E4%B8%8D%E5%AF%B9%E7%89%88-%E7%A8%B3%E5%AE%9A%E6%8B%BF%E9%87%8F-%E9%B8%BF%E8%92%99%E7%94%9F%E6%80%81%E5%BA%94%E7%94%A8-%E6%B2%B3%E7%A5%9E%E7%9A%84%E6%96%B0%E5%A8%98-%E5%A4%9A%E5%9B%BE-240711-%E9%80%9A%E6%8A%95-%E8%87%AA%E5%AE%9A%E4%B9%89%E7%BD%91%E9%A1%B5ocpc-AI%E7%B1%BB-copy2024-07-12+17%3A20%3A43-copy2024-07-18+14%3A31%3A05%26adgroup_name%3D%E8%B4%A7%E4%B8%8D%E5%AF%B9%E7%89%88-%E7%A8%B3%E5%AE%9A%E6%8B%BF%E9%87%8F-%E9%B8%BF%E8%92%99%E7%94%9F%E6%80%81%E5%BA%94%E7%94%A8-%E6%B2%B3%E7%A5%9E%E7%9A%84%E6%96%B0%E5%A8%98-%E5%A4%9A%E5%9B%BE-240711-%E9%80%9A%E6%8A%95-%E8%87%AA%E5%AE%9A%E4%B9%89%E7%BD%91%E9%A1%B5ocpc-AI%E7%B1%BB-copy2024-07-12+17%3A20%3A43-copy2024-07-18+14%3A31%3A05%26content_name%3D%E9%B8%BF%E8%92%99%E7%94%9F%E6%80%81%E5%BA%94%E7%94%A8-1%26emui_version%3D%26transunique_id%3D20240731071314203717411_t9kn4y47fy_1%26os_version%3D12.0.0%26device_id%3D%26id_type%3D%26publisher_type%3D2%26log_id%3D20240731071314203717434%26channel%3Dmod_hw_dq_zd%26QUICKST_CHANNEL%3Dmod_hw_dq_zd%26id%3D856%26platform%3Dhuawei%26position%3D4683%2F";
        // String decode = URLDecoder.decode(str, "UTF-8");
        String decode = cn.hutool.core.net.URLDecoder.decode(str, Charset.forName("UTF-8"));
        String s = StringUtils.substringBefore(decode, ":");
        System.out.println(s);
        // URI uri = new URI("pddopen://pinduoduo?h5Url=mtr_portals.html%3F_p_acc%3D100001%26_p_source%3D0%26_pdd_tc%3Dffffff%26_p_cate1_id%3D6536%26mat2_type%3D6%26_p_ads_id%3D-1%26_p_jump_id%3D1270%26delay_bid%3D0%26_p_vids%3D20928%2C19744%2C20450%2C18051%2C20451%2C20772%2C20901%2C20997%2C20645%2C20870%2C20614%2C400001%2C19976%2C20842%2C15630%2C20494%2C20590%2C20758%2C20925%2C20094%2C20927%2C21023%2C11839%26resfm%3D0%26_p_it_type%3D%26bid_adjust_tag%3D2%26_p_ads_sub_channel%3Dmrk_union_hxly%26sn%3D210310xbpy%26_p_ads_channel%3Dmrk_union%26_p_ads_csite%3Du_aff_splsh%26lego_ssr_api%3D%252Fapi%252Fmobile_tarot_lego%252Fget_config%252Fdp%26lpck%3D69cd3af7567d690a_1705478022448%26lego_minversion%3D5.23.0%26_p_ads_type%3Dlaxin%26_pdd_fs%3D1%26_p_ads_set%3D10004610%26ad_ltv%3D26.399981506347658%26_p_launch_id%3D3d3c560a8687a765920100007fa4b409ede08df7_0%26_p_super_channel%3Dmrk_union_hxly%26_p_bucket_dsp%3D26%26goods_id%3D269552136773%26lego_type%3Dv8%26_pdd_sbs%3D1%26_p_launch_type%3Ddsp%26_p_mat_pkg_id%3D5711671%26_p_creative_id%3D101496527346%26_p_pdd_bid_id%3D3d3c560a8687a765920100007fa4b409ede08df7_0%26_pdd_fs_h5%3D1%26_p_display_id%3D549%26st8%3D0%26y20%3D400001%26_oc_ads_channel%3Dmrk_union%26st11%3D0%26_p_mt_id%3D101496527346%26_p_soid%3D3d3c560a8687a765920100007fa4b409ede08df7%26_p_plgsn%3D73a72af2e5dfa6e7198af50aac7df845%26exp2_did%3D7a7a0e30cac21f4a42f1355df01df62d%26_pdd_nc%3DF52B4A%26_p_vers%3DA25-L121-V219-F151-S16&direct_back=true");
        URI uri = new URI("hap%3A%2F%2Fapp%2Fcom.ss.boutique%2Fpages%2Fspa%3Futm_campaign%3D98042494%26utm_source%3D45222595%26utm_term%3D31301218%26callback%3D45069155%252620240731005643242897864%25261360003824676253056%2526com.ss.boutique%26referrer%3Dhuaweiads_20240731005643242897864%26channel%3Dhuaweiads%26ip%3D112.9.220.29%26oaidmd5%3D8f7d730a-723d-4df6-b271-60e8b2858f33%26channel_id%3Dcszwhaphw%26link_id%3Dcszwhaphw-lb-h01%26mediumType%3Dhw%26pageExt2%3DshakeRedPage%26os%3D%2F");
        //String schemeSpecificPart = uri.getSchemeSpecificPart();
        //String host = uri.getHost();
        //System.out.println(host);
        String scheme = uri.getScheme();
        System.out.println(scheme);
    }
}