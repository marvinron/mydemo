package com.maviron.spring.springdemo.dpvalidater;

import java.net.URI;

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

        URI uri = new URI("pddopen://pinduoduo?h5Url=mtr_portals.html%3F_p_acc%3D100001%26_p_source%3D0%26_pdd_tc%3Dffffff%26_p_cate1_id%3D6536%26mat2_type%3D6%26_p_ads_id%3D-1%26_p_jump_id%3D1270%26delay_bid%3D0%26_p_vids%3D20928%2C19744%2C20450%2C18051%2C20451%2C20772%2C20901%2C20997%2C20645%2C20870%2C20614%2C400001%2C19976%2C20842%2C15630%2C20494%2C20590%2C20758%2C20925%2C20094%2C20927%2C21023%2C11839%26resfm%3D0%26_p_it_type%3D%26bid_adjust_tag%3D2%26_p_ads_sub_channel%3Dmrk_union_hxly%26sn%3D210310xbpy%26_p_ads_channel%3Dmrk_union%26_p_ads_csite%3Du_aff_splsh%26lego_ssr_api%3D%252Fapi%252Fmobile_tarot_lego%252Fget_config%252Fdp%26lpck%3D69cd3af7567d690a_1705478022448%26lego_minversion%3D5.23.0%26_p_ads_type%3Dlaxin%26_pdd_fs%3D1%26_p_ads_set%3D10004610%26ad_ltv%3D26.399981506347658%26_p_launch_id%3D3d3c560a8687a765920100007fa4b409ede08df7_0%26_p_super_channel%3Dmrk_union_hxly%26_p_bucket_dsp%3D26%26goods_id%3D269552136773%26lego_type%3Dv8%26_pdd_sbs%3D1%26_p_launch_type%3Ddsp%26_p_mat_pkg_id%3D5711671%26_p_creative_id%3D101496527346%26_p_pdd_bid_id%3D3d3c560a8687a765920100007fa4b409ede08df7_0%26_pdd_fs_h5%3D1%26_p_display_id%3D549%26st8%3D0%26y20%3D400001%26_oc_ads_channel%3Dmrk_union%26st11%3D0%26_p_mt_id%3D101496527346%26_p_soid%3D3d3c560a8687a765920100007fa4b409ede08df7%26_p_plgsn%3D73a72af2e5dfa6e7198af50aac7df845%26exp2_did%3D7a7a0e30cac21f4a42f1355df01df62d%26_pdd_nc%3DF52B4A%26_p_vers%3DA25-L121-V219-F151-S16&direct_back=true");
        //String schemeSpecificPart = uri.getSchemeSpecificPart();
        //String host = uri.getHost();
        //System.out.println(host);
        String scheme = uri.getScheme();
        System.out.println(scheme);
    }
}