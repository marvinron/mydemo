package com.maviron.spring.springdemo.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String[] PRESET_FIELDS = {"user_id","app_version","ip","country","city","province","lib","lib_version","manufacturer","model","os","os_version","screen_height","screen_width","wifi","browser","browser_version","carrier","network_type","utm_matching_type","latest_referrer","latest_referrer_host","latest_utm_source","latest_utm_medium","latest_utm_term","latest_utm_content","latest_utm_campaign","latest_search_keyword","latest_traffic_source_type","is_first_day","device_id_list","event_name","event_date","create_time","event_day","event_week","event_month"};
    public static final String[] FORM_KEY = {"请输入","表单"};
    public static final String[] ANDROID_INFO = {"oaid","imei","androidid"};
    public static final String PRD_DORIS_USER_NAME = "admin";
    public static final String SIT_DORIS_USER_NAME = "root";
    public static final String LX_LH = "拉活&拉新";
    public static final String LH = "拉活";
    public static final String LX = "拉新";
    public static final String FORM = "表单";
    public static final String ADX = "ADX";
    public static final String OAID = "oaid";
    public static final String IMEI = "imei";
    public static final String ANDROIDID = "androidid";
    public static final String IDFA = "idfa";
    public static final String BRAND = "brand";
    public static final String IP = "ip";
    public static final String MODEL = "model";
    public static final String OSV = "osv";
    public static final String UA = "ua";
    public static final String XMOB = "XMOB";
    public static final String XMOBSYSID = "01";
    public static final String FLOW = "FLOW";
    public static final String DEFAULT_TOPIC = "defaultTopic";
    public static final String DMP_TOPIC_SIT = "dmp_topic_sit";
    public static final String DMP_TOPIC_TEST = "dmp_topic";
    public static final String SIT_BOOTSTRAP_SERVERS = "10.0.1.30:9092";
    public static final String TEST_SIT_BOOTSTRAP_SERVERS = "10.0.1.45:9092";
    public static final String PRD_BOOTSTRAP_SERVERS = "10.16.0.29:9092";
    public static final String SIT_MYSQL_IP = "10.0.1.28";
    public static final String PRD_MYSQL_IP = "10.16.0.48";
    public static final String SIT_DORIS_FE_IP = "10.0.18.17:8030";
    public static final String TMP_DORIS_FE_IP = "10.16.5.221:8030";
    public static final String PRD_DORIS_FE_IP = "10.16.1.84:8030";
//    public static final String SIT_TOPIC = "infinity_sit";
    public static final String SIT_TOPIC = "infinity_sit2";
    public static final String ADX_SIT_TOPIC = "adx_sit";
    public static final String HC = "hc_prd";
    public static final String TMP_DATA_TOPIC = "tmp_data_sit";
    public static final String FLOW_PAMION_SIT_TOPIC = "flow_pamion_sit";
    public static final String XMOB_SIT_TOPIC = "xmob_sit";
    public static final String XMOB_PRD_TOPIC = "xmob_prd";
    public static final String FLOW_PRD_TOPIC = "lemon_flow_prd";
    public static final String DMP_SIT_TOPIC = "dmp_topic_sit";
    public static final String DMP_TOPIC_PRD = "dmp_topic";
    public static final String PRD_TOPIC = "lemon_expolog_to_bigdata";
    public static final String DATA_RETURN_PRD_TOPIC = "topic-datareturn";
    public static final String SIT_GROUPID_NODSP = "sit_groupid_nodsp";
    public static final String SIT_GROUPID_WITHDSP = "sit_groupid_withdsp";
    public static final String PRD_GROUPID_NODSP = "prd_groupid_nodsp_8";
    public static final String PRD_GROUPID_WITHDSP = "prd_groupid_withdsp_9";
    public static final String DORIS_TABLE_EVENTS = "infinity.events";
    public static final String DORIS_TABLE_ENTITIES = "infinity.entities";
    public static final String DORIS_TABLE_DSP_BUDGET = "infinity.dsp_budget";
    public static final String PARSE_H5URL_UNSUCCESSFUL = "infinity.parse_h5url_unsuccessful";
    public static final String SIT_USER_NAME = "admin";
    public static final String SIT_MYSQL_DB = "alliance_sit_db";
    public static final String PRD_MYSQL_DB = "alliance_db";
    public static final String PRD_INFINITY_MYSQL_DB = "dmp";
    public static final String[] SIT_MYSQL_MabClicRate = {"alliance_sit_db.adx_pd_info"};
    public static final String[] SIT_MYSQL_DmpSample = {"alliance_sit_db.dmp_sample"};
    public static final String[] SIT_MYSQL_TABLE_PROCESS = {"alliance_sit_db.table_process"};
    public static final String[] SIT_MYSQL_TABLE_PROCESS_3E = {"alliance_sit_db.table_process_3e_pamion","alliance_sit_db.ssp_media", "alliance_sit_db.ssp_media_app", "alliance_sit_db.ssp_media_position"};
    public static final String[] PRD_MYSQL_TABLE_PROCESS_3E_PAMION = {"dmp.table_process_3e_pamion","alliance_db.ssp_media", "alliance_db.ssp_media_app", "alliance_db.ssp_media_position"};
//    public static final String[] SIT_MYSQL_TABLE_PROCESS_3E = {"alliance_sit_db.table_process_3e","alliance_sit_db.ssp_media", "alliance_sit_db.ssp_media_app", "alliance_sit_db.ssp_media_position", "alliance_sit_db.sys_user_account"};
    public static final String[] PRD_MYSQL_TABLE_PROCESS_3E = {"dmp.table_process_3e"};
    public static final String[] SIT_MYSQL_DIM = {"alliance_sit_db.ssp_media_app","alliance_sit_db.dmp_sample_tag","alliance_sit_db.adx_dsp_info","alliance_sit_db.ssp_media"};
    public static final String[] PRD_MYSQL_DMPSAMPLE = {"alliance_db.dmp_sample"};
    public static final String[] SIT_MYSQL_TABLELIST_WITPDRTB = {"alliance_sit_db.adx_pd_info", "alliance_sit_db.adx_rtb_info"};
    public static final String[] PRD_MYSQL_TABLELIST_WITPDRTB = {"alliance_db.adx_pd_info", "alliance_db.adx_rtb_info"};
    public static final String[] PD_MYSQL_TABLELIST_WITPD = {"alliance_db.adx_pd_info"};
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "Gameley668";
    public static final String SIT_DORIS_TABLE_NODSP = "realtime_db.adx_realtime_nodsp";
    public static final String SIT_DORIS_TABLE_DMPSAMPLE = "dmo.dmp_sample";
    public static final String PRD_DORIS_TABLE_DMPSAMPLE = "dmo.dmp_sample";
    public static final String SIT_DORIS_TABLE_WITHDSP = "realtime_db.adx_realtime_withdsp";
    public static final String PRD_DORIS_TABLE = "channel_db.returndata";
    public static final String PRD_DORIS_TABLE_NODSP_LATE = "realtime_db.adx_realtime_nodsp_late";
    public static final String PRD_DORIS_TABLE_WITHDSP_LATE = "realtime_db.adx_realtime_withdsp_late";
    public static final String PRD_DORIS_TABLE_WITHDSP = "realtime_db.adx_realtime_withdsp";
    //ALARM
    public static final String DEV_MYSQL_IP = "bj-cdb-3sukricm.sql.tencentcdb.com";
    public static final int DEV_MYSQL_PORT = 60421;
    public static final String DEV_MYSQL_DB = "alliance_sit_db";
    public static final String DEV_ALARM_MYSQL_TABLE_LIST = "alliance_sit_db.adx_configuration_info";
    public static final String DEV_DORIS_URL = "jdbc:mysql://49.232.140.119:9030/realtime_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";
    public static final String DEV_MYSQL_URL = "jdbc:mysql://bj-cdb-3sukricm.sql.tencentcdb.com:60421/alliance_sit_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";
    public static final String DEV_DORIS_USER_NAME = "root";

    public static final int SIT_MYSQL_PORT = 3306;
    public static final String SIT_ALARM_MYSQL_TABLE_LIST = "alliance_sit_db.adx_configuration_info";
    public static final String SIT_DORIS_URL = "jdbc:mysql://10.0.1.36:9030/realtime_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";
    public static final String SIT_MYSQL_URL = "jdbc:mysql://10.0.1.28:3306/alliance_sit_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";

    public static final int PRD_MYSQL_PORT = 3306;
    public static final String PRD_ALARM_MYSQL_TABLE_LIST = "alliance_db.adx_configuration_info";
    public static final String PRD_DORIS_URL = "jdbc:mysql://10.16.1.84:9030/realtime_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";
    public static final String PRD_PUBLIC_DORIS_URL = "jdbc:mysql://82.156.162.199:63001/realtime_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";
    public static final String PRD_MYSQL_URL = "jdbc:mysql://10.16.0.48:3306/alliance_db?useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai";

    public static final String PEGASUS_ONEID_TABLENAME = "id_mapping";
//    public static final String PEGASUS_DSP_BUDGET = "test2";
    public static final String PEGASUS_DSP_BUDGET = "dsp_budget";
    public static final String ENUM_DSP_BUDGET = "infinity.enum_dsp_budget";
    public static final String ENUM_DSP_BUDGET_MAP = "infinity.enum_dsp_budget_map";
    public static final String ENUM_DOMAIN_BUDGET = "infinity.enum_domain_budget";
    public static final String SAMPLE_CONTROL_QUANTITY = "infinity.sample_control_quantity";
    public static final String ENUM_ADX_DSP_INFO = "infinity.enum_adx_dsp_info";

    public final int OPERATION_TIMEOUT = 6000;
    public final int ASYNC_WORKERS = 1;
    public final boolean ENABLE_PERF_COUNTER = true;
    public final String PERF_COUNTER_TAGS = "";
    public final int PUSH_COUNTER_INTERVAL_SECS = 10;
    public final int META_QUERY_TIMEOUT = 5000;

    private static Logger log = LoggerFactory.getLogger(Config.class);

    private static Properties dbProps = null;

    private Config() {
    }

    public static synchronized void loads() {
        InputStream inputStream = Config.class.getResourceAsStream("/sit/config.properties");
        dbProps = new Properties();
        try {
            dbProps.load(inputStream);
        } catch (Exception e) {
            System.err.println("\u6D93\u5D88\u5158\u7487\u8BF2\u5F47\u705E\u70B4\uFFFD\u0444\u6783\u6D60\uFFFD. \u7487\u98CE\u2018\u6DC7\u6F1Config.properties\u9366\u2013LASSPATH\u93B8\u56E7\u757E\u9428\u52EE\u77FE\u5BF0\u52EA\u8151");
            log.error(e.getMessage(), e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public static String getString(String key) {
        String str = "";
        if (key != null && !"".equals(key))
            try {
                str = dbProps.getProperty(key);
            } catch (Exception e) {
                System.err.println("\u6D93\u5D88\u5158\u7487\u8BF2\u5F47\u705E\u70B4\uFFFD\u0444\u6783\u6D60\uFFFD. \u7487\u98CE\u2018\u6DC7\u6F1Config.properties\u9366\u2013LASSPATH\u93B8\u56E7\u757E\u9428\u52EE\u77FE\u5BF0\u52EA\u8151");
                log.error(e.getMessage(), e);
            }
        return str;
    }

    static {
        loads();
    }


}