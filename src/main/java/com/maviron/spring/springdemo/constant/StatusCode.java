package com.maviron.spring.springdemo.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回码
 */
public class StatusCode {
    //公共消息状态 系统用户（角色 权限 资源）部分 (1000 - 9999)
    public static final int OK = 2000;//成功
    public static final int ERROR = 2001;//失败
    public static final int LOGIN_USERNAME_PASSPORD_ERROR = 2002;//用户名或密码错误
    public static final int ACCESS_ERROR = 2003;//权限不足
    public static final int REMOTE_ERROR = 2004;//远程调用失败
    public static final int REP_ERROR = 2005;//重复操作

    public static final int ACCOUNT_NO_NOT_EXISTS = 2006;//账户账户不存在
    public static final int ACCOUNT_NO_TYPE_ERROR = 2007;//账户账户类型错误
    public static final int NOT_AUDIT_QUALIFICATION_CANNOT_UPLOAD_AGAIN = 2008;
    public static final int BUSINESS_LICENSE_URL_EMPTY = 2009;
    public static final int ACCOUNT_NO_CANNOT_EMPTY = 2010;
    public static final int ACCOUNT_NAME_CANNOT_EMPTY = 2011;
    public static final int COMPANY_NAME_CANNOT_EMPTY = 2012;
    public static final int COMPANY_NAME_ALREADY_EXISTS = 2013;
    public static final int QUALIFICATION_INFO_EMPTY = 2014;
    public static final int DICTIONARY_CODE_REPEAT = 2015;
    public static final int ROLE_NAME_CANNOT_EMPTY = 2016;
    public static final int OUTER_ACCOUNT_AUTH_ABOVE = 2017;
    public static final int REGISTER_PLATFORM_ERROR = 2018;
    public static final int CONTACT_PERSON_EMPTY = 2019;
    public static final int ADDRESS_EMPTY = 2020;
    public static final int EMAIL_EMPTY = 2021;
    public static final int BANK_NAME_EMPTY = 2022;
    public static final int BANK_ACCOUNT_NAME_EMPTY = 2023;
    public static final int BANK_ACCOUNT_NO_EMPTY = 2024;
    public static final int COMPANY_NAME_ACCOUNT_NO_NOT_MAPPING = 2025;
    public static final int DISTRIBUTION_USER_LIST_EMPTY = 2026;
    public static final int CUSTOMER_RESOURCE_EMPTY = 2027;
    public static final int QUALIFICATION_AUDIT_TYPE_ERROR = 2028;
    public static final int ACCOUNT_STATUS_ERROR = 2029;
    public static final int CONTACT_PERSON_PHONE_EMPTY = 2030;
    public static final int APPLY_PLATFORM_ID_ERROR = 2031;
    public static final int DUPLICATERELU_NAME = 2032;//屏蔽规则已经存在
    public static final int Register_SUCCESS = 2033;//注册成功
    public static final int Register_FAILURE = 2034;//注册失败
    public static final int ACCOUNT_NAME_ALREADY_EXISTS = 2035;//账户名称重复
    public static final int ACCOUNT_CODE_ALREADY_EXISTS = 2036;//账户名称重复

    public static final int HTTP_200 = 200;
    public static final int SYSTEM_ERROR = 500;

    public static final String OK_MSG = "请求成功";
    public static final String ERROR_MSG = "请求失败";
    public static final String LOGIN_USERNAME_PASSPORD_ERROR_MSG = "用户名或密码错误";
    public static final String ACCESS_ERROR_MSG = "权限不足";
    public static final String REMOTE_ERROR_MSG = "远程调用失败";
    public static final String REP_ERROR_MSG = "重复操作";
    public static final String LOGIN_TIMEOUT_MSG = "未登录或者登陆超时";
    public static final String ACCOUNT_NO_NOT_EXISTS_MSG = "账户不存在";
    public static final String ACCOUNT_NO_TYPE_ERROR_MSG = "账户类型错误";
    public static final String PAGE_SIZE = "pageSize";
    public static final String PAGE_NO = "pageNo";

    public static final String NOT_AUDIT_QUALIFICATION_CANNOT_UPLOAD_AGAIN_MSG = "资质处于非待审核状态和审核拒绝状态的用户不能再次发起资质上传";
    public static final String BUSINESS_LICENSE_URL_EMPTY_MSG = "营业执照不能为空";
    public static final String ACCOUNT_NO_CANNOT_EMPTY_MSG = "账号不能为空";
    public static final String ACCOUNT_NAME_CANNOT_EMPTY_MSG = "账号名称不能为空";
    public static final String COMPANY_NAME_CANNOT_EMPTY_MSG = "组织名称不能为空";
    public static final String COMPANY_NAME_ALREADY_EXISTS_MSG = "组织名称已经存在";
    public static final String QUALIFICATION_INFO_EMPTY_MSG = "必须上传资质";
    public static final String ROLE_NAME_CANNOT_EMPTY_MSG = "角色不能为空";
    public static final String DICTIONARY_CODE_REPEAT_MSG = "字典编码重复";
    public static final String OUTER_ACCOUNT_AUTH_ABOVE_MSG = "给外部账号分配的角色对应的权限过大";
    public static final String REGISTER_PLATFORM_ERROR_MSG = "外部账号注册时所选平台错误";
    public static final String CONTACT_PERSON_EMPTY_MSG = "联系人不能为空";
    public static final String ADDRESS_EMPTY_MSG = "地址不能为空";
    public static final String EMAIL_EMPTY_MSG = "邮箱不能为空";
    public static final String BANK_NAME_EMPTY_MSG = "开户行名称不能为空";
    public static final String BANK_ACCOUNT_NAME_EMPTY_MSG = "银行账户名称不能为空";
    public static final String BANK_ACCOUNT_NO_EMPTY_MSG = "银行账号不能为空";
    public static final String COMPANY_NAME_ACCOUNT_NO_NOT_MAPPING_MSG = "公司名称与目标账号ID不一致";
    public static final String DISTRIBUTION_USER_LIST_EMPTY_MSG = "待分配资源的用户列表为空";
    public static final String CUSTOMER_RESOURCE_EMPTY_MSG = "客户资源不能为空";
    public static final String QUALIFICATION_AUDIT_TYPE_ERROR_MSG = "资质审核类型错误";
    public static final String ACCOUNT_STATUS_ERROR_MSG = "账号状态错误";
    public static final String CONTACT_PERSON_PHONE_EMPTY_MSG = "联系人手机不能为空";
    public static final String APPLY_PLATFORM_ID_ERROR_MSG = "申请的平台ID错误";
    public static final String ACCOUNT_NAME_ALREADY_EXISTS_MSG = "账号名称已经存在";
    public static final String ACCOUNT_CODE_ALREADY_EXISTS_MSG = "账号已经存在";



    public static final String SYSTEM_ERROR_MSG = "系统开了一个小差,请稍后再试!";

    //SSP部分业务错误码（10000-19999）
    public static final int SSP_MEDIA_NAME_EMPTY = 10000;
    public static final int SSP_ACCESS_TYPE_ERROR = 10001;
    public static final int SSP_ACCESS_TYPE_VERSION_ERROR = 10002;
    public static final int SSP_ACCESS_TYPE_ID_EMPTY = 10003;
    public static final int SSP_ACCESS_TYPE_DOC_URL_EMPTY = 10004;
    public static final int SSP_ACCESS_TYPE_DATA_EMPTY = 10005;
    public static final int SSP_MEDIA_NAME_CANNOT_SAME = 10006;
    public static final int SSP_MEDIA_ID_EMPTY = 10007;
    public static final int SSP_MEDIA_STATUS_ERROR = 10008;
    public static final int SSP_MEDIA_ID_DATA_EMPTY = 10009;
    public static final int SSP_MEDIA_STATUS_CLOSE_ERROR = 10010;
    public static final int SSP_MEDIA_STATUS_OPEN_ERROR = 10011;
    public static final int SSP_MEDIA_STATUS_CLOSE_SUCC = 10012;
    public static final int SSP_MEDIA_STATUS_OPEN_SUCC = 10013;
    public static final int SSP_MEDIA_APP_ID_ERROR = 10014;
    public static final int SSP_MEDIA_APP_AUDIT_STATUS_ERROR = 10016;
    public static final int SSP_MEDIA_APP_ID_DATA_EMPTY = 10017;
    public static final int SSP_MEDIA_APP_AUDIT_FAIL = 10018;
    public static final int SSP_MEDIA_APP_AUDIT_SUCC = 10019;
    public static final int SSP_MEDIA_APP_STATUS_ERROR = 10020;
    public static final int SSP_MEDIA_APP_AUDIT_NOT_PASS_CANNOT_OPEN = 10021;

    public static final int SSP_SHIELD_RULES_NAME_EMPTY = 10022;
    public static final int SSP_SHIELD_RULES_KEYWORDS_EMPTY = 10023;
    public static final int SSP_SHIELD_RULES_PACKAGES_EMPTY = 10024;
    public static final int SSP_SHIELD_RULES_TRADEING_EMPTY = 10025;
    public static final int SSP_SHIELD_RULES_CUSTOMER_EMPTY = 10026;
    public static final int SSP_SHIELD_RULES_ID_EMPTY = 10027;
    public static final int SSP_SHIELD_RULES_NOT_EXISTS = 10028;
    public static final int SSP_POS_TYPE_ID_ERROR = 10029;
    public static final int SSP_POS_TYPE_STYLE_ID_ERROR = 10030;
    public static final int SSP_NOT_AUDIT_MEDIA_APP_CANNOT_CREATE_POSITION = 10031;
    public static final int SSP_MEDIA_POS_ID_ERROR = 10032;
    public static final int SSP_MEDIA_POS_STATUS_ERROR = 10033;
    public static final int SSP_MEDIA_STATUS_NOT_OPEN = 10034;
    public static final int SSP_MEDIA_APP_STATUS_NOT_OPEN = 10035;
    public static final int SSP_MEDIA_APP_NOT_AUDIT_NOT_ALLOWED_MODIFY = 10036;
    public static final int SSP_AD_TYPE_NOT_MODIFY = 10037;
    public static final int SSP_PLATFORM_NOT_MODIFY = 10038;
    public static final int SSP_MEDIA_NOT_MODIFY = 10039;
    public static final int SSP_ACCESS_TYPE_NOT_MODIFY = 10040;
    public static final int SSP_MEDIA_APP_NAME_INVALID = 10041;
    public static final int SSP_TOTAL_USER_COUNT_INVALID = 10042;
    public static final int SSP_DAY_ACTIVE_USER_COUNT_INVALID = 10043;
    public static final int SSP_PLATFORM_INVALID = 10044;
    public static final int SSP_ACCESS_TYPE_INVALID = 10045;
    public static final int SSP_APP_DOWNLOAD_URL_INVALID = 10046;
    public static final int SSP_PACKAGE_NAME_INVALID = 10047;
    public static final int SSP_APPLICATION_TYPE_INVALID = 10048;
    public static final int SSP_WEBSITE_DOMAIN_INVALID = 10049;
    public static final int SSP_OFFICAL_WEBSITE_INVALID = 10050;
    public static final int SSP_DATA_REPORT_QUERY_TYPE_ERROR = 10051;
    public static final int SSP_SHIELD_RULES_KEYWORDS_PACKAGES_TRADE_CUSTOMER_ALL_EMPTY = 10052;
    public static final int SSP_SEARCH_TYPE_ERROR = 10053;
    public static final int SSP_HOME_DATA_SEARCH_DIMENSION_ERROR = 10054;

    public static final String SSP_MEDIA_NAME_EMPTY_MSG = "媒体不能为空";
    public static final String SSP_ACCESS_TYPE_ERROR_MSG = "对接方式类型有误";
    public static final String SSP_ACCESS_TYPE_VERSION_ERROR_MSG = "对接方式版本号不能为空";
    public static final String SSP_ACCESS_TYPE_ID_EMPTY_MSG = "对接方式ID不能为空";
    public static final String SSP_ACCESS_TYPE_DOC_URL_EMPTY_MSG = "对接方式文档地址不能为空";
    public static final String SSP_ACCESS_TYPE_DATA_EMPTY_MSG = "该对接方式对应的数据为空";
    public static final String SSP_MEDIA_NAME_CANNOT_SAME_MSG = "相同账号下媒体名称不能重复";
    public static final String SSP_MEDIA_ID_EMPTY_MSG = "媒体ID不能为空";
    public static final String SSP_MEDIA_STATUS_ERROR_MSG = "媒体状态值有误";
    public static final String SSP_MEDIA_ID_DATA_EMPTY_MSG = "该媒体ID对应的媒体数据为空";
    public static final String SSP_MEDIA_STATUS_CLOSE_ERROR_MSG = "媒体状态关闭失败";
    public static final String SSP_MEDIA_STATUS_OPEN_ERROR_MSG = "媒体状态开启失败";
    public static final String SSP_MEDIA_STATUS_CLOSE_SUCC_MSG = "媒体状态关闭成功";
    public static final String SSP_MEDIA_STATUS_OPEN_SUCC_MSG = "媒体状态开启成功";
    public static final String SSP_MEDIA_APP_ID_ERROR_MSG = "媒体应用ID有null值";
    public static final String SSP_MEDIA_APP_AUDIT_STATUS_ERROR_MSG = "媒体应用审核状态值不合法";
    public static final String SSP_MEDIA_APP_ID_DATA_EMPTY_MSG = "该媒体应用ID对应的媒体应用数据为空";
    public static final String SSP_MEDIA_APP_AUDIT_FAIL_MSG = "媒体应用审核失败";
    public static final String SSP_MEDIA_APP_AUDIT_SUCC_MSG = "媒体应用审核成功";
    public static final String SSP_MEDIA_APP_STATUS_ERROR_MSG = "媒体应用状态值不合法";
    public static final String SSP_MEDIA_APP_AUDIT_NOT_PASS_CANNOT_OPEN_MSG = "非审核通过的媒体应用不能开启状态";
    public static final String SSP_SHIELD_RULES_NAME_EMPTY_MSG = "屏蔽规则名称不能为空";
    public static final String SSP_SHIELD_RULES_KEYWORDS_EMPTY_MSG = "屏蔽关键词不能为空";
    public static final String SSP_SHIELD_RULES_PACKAGES_EMPTY_MSG = "屏蔽包名不能为空";
    public static final String SSP_SHIELD_RULES_TRADEING_EMPTY_MSG = "屏蔽行业不能为空";
    public static final String SSP_SHIELD_RULES_CUSTOMER_EMPTY_MSG = "屏蔽广告主不能为空";
    public static final String SSP_SHIELD_RULES_ID_EMPTY_MSG = "要修改的屏蔽规则ID不能为空";
    public static final String SSP_SHIELD_RULES_NOT_EXISTS_MSG = "该屏蔽规则不存在";
    public static final String SSP_POS_TYPE_ID_ERROR_MSG = "待修改的广告类型ID有误";
    public static final String SSP_POS_TYPE_STYLE_ID_ERROR_MSG = "待修改的广告样式ID有误";
    public static final String SSP_NOT_AUDIT_MEDIA_APP_CANNOT_CREATE_POSITION_MSG = "只有审核通过并且应用状态是开启的媒体应用可以新增广告位";
    public static final String SSP_MEDIA_POS_ID_ERROR_MSG = "广告位ID不合法";
    public static final String SSP_MEDIA_POS_STATUS_ERROR_MSG = "广告位状态值不合法";
    public static final String SSP_MEDIA_STATUS_NOT_OPEN_MSG = "媒体状态未开启";
    public static final String SSP_MEDIA_APP_STATUS_NOT_OPEN_MSG = "媒体应用状态未开启";
    public static final String SSP_MEDIA_APP_NOT_AUDIT_NOT_ALLOWED_MODIFY_MSG = "未审核的媒体应用不允许修改操作";
    public static final String SSP_AD_TYPE_NOT_MODIFY_MSG = "审核通过状态其类别不能修改";
    public static final String SSP_PLATFORM_NOT_MODIFY_MSG = "审核通过状态平台不能修改";
    public static final String SSP_MEDIA_NOT_MODIFY_MSG = "审核通过状态媒体不能修改";
    public static final String SSP_ACCESS_TYPE_NOT_MODIFY_MSG = "审核通过状态接入方式不能修改";
    public static final String SSP_MEDIA_APP_NAME_INVALID_MSG = "应用名称不合法";
    public static final String SSP_TOTAL_USER_COUNT_INVALID_MSG = "总用户数不合法";
    public static final String SSP_DAY_ACTIVE_USER_COUNT_INVALID_MSG = "日活用户数不合法";
    public static final String SSP_PLATFORM_INVALID_MSG = "平台不合法";
    public static final String SSP_ACCESS_TYPE_INVALID_MSG = "接入方式不合法";
    public static final String SSP_APP_DOWNLOAD_URL_INVALID_MSG = "应用下载地址不能为空";
    public static final String SSP_PACKAGE_NAME_INVALID_MSG = "程序包名不能为空";
    public static final String SSP_APPLICATION_TYPE_INVALID_MSG = "应用类型不合法";
    public static final String SSP_WEBSITE_DOMAIN_INVALID_MSG = "应用网站域名不能为空";
    public static final String SSP_OFFICAL_WEBSITE_INVALID_MSG = "应用官网地址不能为空";
    public static final String SSP_DATA_REPORT_QUERY_TYPE_ERROR_MSG = "SSP数据报表查询类别错误";
    public static final String SSP_SHIELD_RULES_KEYWORDS_PACKAGES_TRADE_CUSTOMER_ALL_EMPTY_MSG = "屏蔽规则所填项不能全部同时为空";
    public static final String SSP_SEARCH_TYPE_ERROR_MSG = "搜索类别错误";
    public static final String SSP_HOME_DATA_SEARCH_DIMENSION_ERROR_MSG = "SSP首页数据曲线图搜索维度传值错误";
    public static final String PlatName = "platName";
    public static final String CustomerIds = "customerIds";
    public static final String ResourceType = "resourceType";
    public static final String AccountName = "accountName";

    public static final String ANDROID = "ANDROID";
    public static final String IOS = "IOS";
    public static final String SYS_MANAGER_ROLENAME = "系统管理员";


    //ADX部分业务错误码（20000-29999）
    public static final int ADX_REQUEST_PARAM_LACK = 20000;
    public static final int ADX_REQUEST_UNKNOW_TYPE = 20001;
    public static final int ADX_REQUEST_DSP_INFO_ERROR = 20002;
    public static final int ADX_REQUEST_IS_NULL = 20003;
    public static final int ADX_REQUEST_LACK_ID = 20004;
    //adxRequest，dsp响应成功
    public static final int ADX_RESPONSE_DSP_SUCCESS = 20005;
    //adxRequest，dsp响应失败
    public static final int ADX_RESPONSE_DSP_FAIL = 20006;
    //adxRequest，网盟响应成功
    public static final int ADX_RESPONSE_NETUNION_SUCCESS = 20007;
    //adxRequest，网盟响应失败
    public static final int ADX_RESPONSE_NETUNION_FAIL = 20008;
    public static final int ADX_POSITION_NAME_REPEAT = 20009;
    public static final int ADX_REQUEST_EMPTY_BID = 20010;
    public static final int ADX_DSP_AND_TOKEN_NOT_MATCH_CODE = 20011;
    public static final int ADX_DSP_OR_TOKEN_IS_NULL_CODE = 20012;
    public static final int ADX_DSP_CELUE_EXIST_CODE = 20013;
    public static final int ADX_PD_NO_DELETE = 20014;
    public static final int ADX_RTB_NO_DELETE = 20015;


    public static final String ADX_REQUEST_PARAM_LACK_MSG = "ADX请求中ssp广告位(stagid)缺失";
    public static final String ADX_REQUESTBODY_LACK_MSG = "requestBody为空";
    public static final String ADX_REQUEST_UNKNOW_TYPE_MSG = "ADX未知请求类型";
    public static final String ADX_REQUEST_DSP_INFO_ERROR_MSG = "请求参数或者DSP设置有误";
    public static final String ADX_REQUEST_IS_NULL_MSG = "ADXRequest的请求参数为空";
    public static final String ADX_REQUEST_LACK_ID_MSG = "ADXRequest的请求Id缺失";
    public static final String ADX_REQUEST_LACK_SIT_APP_MSG = "ADXRequest的APP和SIT至少有一个";
    public static final String ADX_REQUEST_LACK_DEVICE_MSG = "ADXRequest的请求设备参数为空";
    public static final String ADX_REQUEST_LACK_IMP_MSG = "ADXRequest的请求参数Imp为空";
    public static final String ADX_REQUEST_LACK_IMP_ID_MSG = "ADXRequest的请求参数Imp.id为空";
    public static final String ADX_REQUEST_LACK_EXE_MSG = "ADXRequest的请求参数requestExe为空";
    public static final String ADX_REQUEST_LACK_REQTP_MSG = "ADXRequest的请求参数流量类型为空";
    public static final String ADX_REQUEST_LACK_IMPEXT_MSG = "ADXRequest的请求参数ImpExt为空";
    public static final String ADX_REQUEST_LACK_IMPBVN_MSG = "ADXRequest的请求参数ImpVideoNATIVE至少有一个";
    public static final String ADX_REQUEST_LACK_IMPEXT_STAGID_MSG = "ADXRequest的请求参数ImpExt的stagid为空";
    public static final String ADX_REQUEST_LACK_IMPEXT_SPOSTYPE_MSG = "ADXRequest的请求参数ImpExt的spostype为空";
    public static final String ADX_REQUEST_LACK_BANNER_EXT_MSG = "ADXRequest的请求参数BANNER的ext为空";
    public static final String ADX_REQUEST_LACK_BANNER_EXT_TEMPID_MSG = "ADXRequest的请求参数BANNER的ext的TEMPID为空";
    public static final String ADX_REQUEST_LACK_VIDEO_EXT_TEMPID_MSG = "ADXRequest的请求参数VIDEO的ext的TEMPID为空";
    public static final String ADX_REQUEST_LACK_NATIVE_TEMPID_MSG = "ADXRequest的请求参数NATIVE的TEMPID为空";
    public static final String ADX_REQUEST_LACK_DEVICE_EXT_MSG = "ADXRequest的请求参数DEVICE的EXT为空";
    public static final String ADX_REQUEST_LACK_AREA_MSG = "ADXRequest的请求参数DEVICE的地域编码为空";
    public static final String ADX_REQUEST_VALIDATE_SUCCESS = "ADXRequest的请求参数正确";
    public static final String ADX_RESPONSE_DSP_SUCCESS_MSG = "DSP响应成功";
    public static final String ADX_RESPONSE_DSP_FAIL_MSG = "DSP响应失败";
    public static final String ADX_RESPONSE_NETUNION_SUCCESS_MSG = "网盟响应成功";
    public static final String ADX_RESPONSE_NETUNION_FAIL_MSG = "网盟响应失败";
    public static final String ADX_POSITION_NAME_REPEAT_MAS = "广告位名称不能重复";
    public static final String ADX_REQUEST_EMPTY_BID_MSG = "无BidRequest";
    public static final String ADX_DSP_AND_TOKEN_NOT_MATCH = "dsp与token不匹配";
    public static final String ADX_DSP_OR_TOKEN_IS_NULL = "dsp或者token不能为空";
    public static final String ADX_RESPONSE_SUCCESS = "成功";
    public static final String ADX_RESPONSE_SSPPOSMISTAKE = "SSP广告位不能为空";
    public static final String ADX_RESPONSE_DELEWRONG = "所选id处于开始状态或者有策略无法删除";
    public static final String ADX_DSP_CELUE_EXIST = "dsp策略已经存在";
    public static final String ADX_PD_NO_DELETE_MSG = "pd订单处于开始状态，不能删除";
    public static final String ADX_RTB_NO_DELETE_MSG = "RTB策略，不能删除";


    public static final String FLOW_AREA_NO_MATCH = " 地域ID不匹配";
    public static final String FLOW_DATE_NO_MATCH = " 日期不匹配";
    public static final String FLOW_TIME_NO_MATCH = " 时间不匹配";
    public static final String FLOW_CONNECTION_NO_MATCH = " 连接类型不匹配";
    public static final String FLOW_APP_VERSION_NO_MATCH = " 应用版本不匹配";
    public static final String FLOW_SDK_VERSION_NO_MATCH = " SDK版本不匹配";
    public static final String FLOW_OS_VERSION_NO_MATCH = " 操作系统版本不匹配";
    public static final String FLOW_OS_NO_MATCH = "操作系统不匹配";
    public static final String FLOW_MODEL_NO_MATCH = "品牌不匹配";
    public static final String FLOW_REGISTER_TIME_NO_MATCH = "注册时间不匹配";
    public static final String FLOW_CHANNEL_NO_MATCH = "渠道不匹配";
    public static final String FLOW_CHILDCHANNEL_NO_MATCH = "子渠道不匹配";
    public static final String FLOW_IDFA_NO_MATCH = "IDFA的状态不匹配";
    public static final String FLOW_DATE_FORMAT_MATCH = "date 参数格式不正确";
    public static final String FLOW_TIME_FORMAT_MATCH = "time 参数格式不正确";
    public static final String FLOW_REGISTER_TIME_EMPTY = "注册时间为空";




    //是该网盟填充，1是 0否
    public static final int ADX_IN_FLAG_YES = 1;
    public static final int ADX_IN_FLAG_NO = 0;
    //1：先审，2：后审，3：免审
    public static final int ADX_REVIEWED_METHOD_PRE = 1;
    public static final int ADX_REVIEWED_METHOD_AFT = 2;
    public static final int ADX_REVIEWED_METHOD_AVOID = 3;
    //状态0，待审核，1审核通过，2、审核未通过
    public static final int ADX_REVIEWED_STATUS_WAIT = 0;
    public static final int ADX_REVIEWED_STATUS_PASS = 1;
    public static final int ADX_REVIEWED_STATUS_FAIL = 2;
    //网盟 0=串行，1=并行，默认0
    public static final int ADX_NETUNION_PARALLEL = 1;
    public static final int ADX_NETUNION_SERIAL = 0;
    //广告位接入类型,2=API，1=SDK
    public static final int ADX_NETUNION_API = 2;
    public static final int ADX_NETUNION_SDK = 1;
    //默认优先级 9 最低
    public static final int ADX_PRIORITY_DEFAULT = 9;
    //竞价后次高价加价
    public static final String ADX_RTB_RATIO = "0.01";
    //ADX填充模式
    public static final int ADX_RESTYPE_PDB = 2;
    public static final int ADX_RESTYPE_ADXPD = 3;
    public static final int ADX_RESTYPE_ADXRTB = 4;
    public static final int ADX_RESTYPE_NETUNION = 5;
    // 状态 0 未删除, 1 已删除
    public static final int NOT_DELETE = 0;
    public static final int DELETEED = 1;
    public static final int SINGLE_PACKAGE = 0;
    public static final int MULTY_PACKAGE = 1;
    //状态 0,未启用,1.启动
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    //缺省字符
    public static final String ADX_DEFAULT = "default";
    //超时错误字符Read timed out
    public static final String ADX_READ_TIMED_OUT = "timed out";
    //超时错误字符Read timed out
    public static final String ADX_READ_TIMED_OUT2 = "time out";
    public static final String ADX_FAILED_TO_RESPOND = "failed to respond";
    //网盟总的超时时间
    public static final long ADX_NETUNION_MAX_TIMED_OUT = 200;
    //网盟总的超时时间
    public static final long ADX_WAIT_TIMED_OUT = 20;
    //发送bid超时时间最大值
    public static final long ADX_MAX_TIMED_OUT = StatusCode.MAX_TIMED_OUT + ADX_WAIT_TIMED_OUT;
    //发送bid超时时间最大值
    public static final long ADX_MAX_TIMED_OUT_208 = StatusCode.MAX_TIMED_OUT_208 + ADX_WAIT_TIMED_OUT;
    //发送bid超时时间最大值
    public static final long ADX_MAX_TIMED_OUT_100 = StatusCode.MAX_TIMED_OUT_100 + ADX_WAIT_TIMED_OUT;
    //发送bid超时时间最大值
    public static final long ADX_MAX_TIMED_OUT_50 = StatusCode.MAX_TIMED_OUT_50 + ADX_WAIT_TIMED_OUT;
    //发送bid超时时间最大值
    public static final int MAX_TIMED_OUT_50 = 50;
    //发送bid超时时间最大值
    public static final int MAX_TIMED_OUT_100 = 100;
    //发送bid超时时间最大值
    public static final int MAX_TIMED_OUT = 500;
    //发送bid超时时间最大值
    public static final int MAX_TIMED_OUT_208 = 1000;
    //埋点分隔符
    public static final String ADX_LOG_POINT_SPLIT = "_";
    //素材分隔符
    public static final String ADX_MATERIAL_POINT_SPLIT = ",";
    //ADX解析DSP的BidResponse-解析成功有出价但必要节点缺失
    public static final int ADX_BID_PARSE_SUCCESS_MISS_NODE = 1;
    //ADX解析DSP的BidResponse-解析成功无出价
    public static final int ADX_BID_PARSE_SUCCESS_MISS_PRICE = 2;
    //Winner及价格决策,无效出价
    public static final int ADX_WINNER_INVALID_PRICE = 4;
    //Winner及价格决策,素材审核失败
    public static final int ADX_WINNER_MATERIAL_REVIEW_FAIL = 5;
    //Winner及价格决策,素材必要字段缺失
    public static final int ADX_WINNER_MATERIAL_MISS_NODE = 6;
    //Winner及价格决策，素材屏蔽
    public static final int ADX_WINNER_MATERIAL_BLACK = 7;
    //联盟打底策略过滤过程，未筛选到网盟打底-未找到映射关系
    public static final int ADX_NETUNION_FILTER_FAIL_NOREL = 1;
    //联盟打底策略过滤过程，未筛选到网盟打底-找到映射关系，但网盟开关关闭
    public static final int ADX_NETUNION_FILTER_FAIL_NET_STATUS_CLOSE = 2;
    //价格加密eKey
    public static final String ADX_PRICE_EKEY = "e7c43d1f0b2169f87f65582d8c46453d";
    //价格加密iKey
    public static final String ADX_PRICE_IKEY = "0eff60659338efa2b25b8668ce18c3fb";
    //价格加密iKey
    public static final String ADX_PRICE_SECURITY_TYPE = "HmacSHA1";
    //ADX宏替换
    public static final String ADX_MACROS_AUCTION_ID = "${AUCTION_ID}";
    public static final String ADX_MACROS_AUCTION_BID_ID = "${AUCTION_BID_ID}";
    public static final String ADX_MACROS_AUCTION_IMP_ID = "${AUCTION_IMP_ID}";
    public static final String ADX_MACROS_AUCTION_SEAT_ID = "${AUCTION_SEAT_ID}";
    public static final String ADX_MACROS_AUCTION_PRICE = "${AUCTION_PRICE}";
    //adx网盟宏替换
    public static final String ADX_NET_MACROS = "&dspid=__SDKID__&tposid=__NTAGID__";
    //曝光检测上报时间
    public static final int ADX_PA_TIME = 1;
    //adx ca
    public static final String ADX_PA_STATUS = "&stage=8&status=1&ecode=0";
    //adx ca
    public static final String ADX_NOPA_STATUS = "&stage=8&status=2&ecode=0";
    //adx nurl
    public static final String ADX_NURL_STATUS = "&stage=8&status=3&ecode=0";
    //adx pa
    public static final String ADX_CA_STATUS = "&stage=9&status=1&ecode=0";
    //adx pa
    public static final String ADX_LDPCA_STATUS = "&stage=9&status=2&ecode=0";
    //adx dp
    public static final String ADX_DP_STATUS = "&stage=9&status=3&ecode=0";
    //ADX默认控量值
    public static final String ADX_CPM_VALUE_DEFAULT = "9999999";
    //adx pa
    public static final String ADX_LDP_STATUS = "&stage=9&status=26&ecode=0";


    //ADS部分业务错误码（30000-39999）
    public static final int ADS_ACTIVITY_ADVERTISER_ID_IS_NULL = 300001;
    public static final int ADS_ACTIVITY_BRAND_ID_IS_NULL = 300002;
    public static final int ADS_ACTIVITY_PRODUCT_ID_IS_NULL = 300003;
    public static final int ADS_ACTIVITY_NAME_IS_NULL = 300004;
    public static final int ADS_ACTIVITY_NAME_IS_REPEAT = 300005;
    public static final int ADS_ACTIVITY_BUDGET_IS_NULL = 300006;
    public static final int ADS_ACTIVITY_BUDGET_GREATER_THAN_ZERO = 300007;
    public static final int ADS_ACTIVITY_START_DATE_IS_NULL = 300008;
    public static final int ADS_ACTIVITY_END_DATE_IS_NULL = 300009;
    public static final int ADS_ACTIVITY_SALE_TYPE_IS_NULL = 300010;
    public static final int ADS_ACTIVITY_CODE_IS_NULL = 300011;
    public static final int ADS_ACTIVITY_CODE_IS_REPEAT = 300012;

    public static final int ADS_GROUP_MEDIA_ID_IS_NULL = 310000;
    public static final int ADS_GROUP_PLATFORM_ID_IS_NULL = 310001;
    public static final int ADS_GROUP_AD_TYPE_ID_IS_NULL = 310002;
    public static final int ADS_GROUP_AD_POSITION_ID_IS_NULL = 310003;
    public static final int ADS_GROUP_AD_STYLES_ID_IS_NULL = 310004;
    public static final int ADS_GROUP_NAME_IS_NULL = 310005;
    public static final int ADS_GROUP_NAME_IS_REPEAT = 310006;
    public static final int ADS_GROUP_SETTLE_MODE_CODE_IS_NULL = 310007;
    public static final int ADS_GROUP_THROW_TYPE_CODE_IS_NULL = 310008;
    public static final int ADS_GROUP_THROW_MODE_CODE_IS_NULL = 310009;
    public static final int ADS_GROUP_DSP_ID_IS_NULL = 310010;

    public static final int ADS_ORDER_CITY_ID_IS_NULL = 320000;
    public static final int ADS_ORDER_NAME_IS_REPEAT = 320001;
    public static final int ADS_ORDER_DATE_IS_VALID = 320002;

    public static final int ADS_PRIMARY_KEY_IS_NULL = 31000;

    public static final int ADS_MATERIAL_ADVERTISER_ID_IS_NULL = 36000;
    public static final int ADS_MATERIAL_ADVERTISER_NAME_IS_NULL = 36001;
    public static final int ADS_MATERIAL_SPECS_ID_IS_NULL = 36002;
    public static final int ADS_MATERIAL_SPECS_NAME_IS_NULL = 36003;
    public static final int ADS_MATERIAL_PLATE_FORM_NAME_IS_NULL = 36004;
    public static final int ADS_MATERIAL_AD_TYPE_NAME_IS_NULL = 36005;
    public static final int ADS_MATERIAL_AD_STYLE_IS_NULL = 36006;
    public static final int ADS_MATERIAL_AD_SIZE_IS_NULL = 36007;
    public static final int ADS_MATERIAL_AD_FORMAT_IS_NULL = 36008;
    public static final int ADS_MATERIAL_URL_IS_NULL = 36009;
    public static final int ADS_MATERIAL_NAME_REPEAT = 36010;
    public static final int ADS_MATERIAL_DEFINITION_IS_NULL_OR_ILLEGAL = 36011;
    public static final int ADS_MATERIAL_FORMAT_IS_NOT_MATCH_FILE = 36012;
    public static final int ADS_MATERIAL_SIZE_IS_NOT_MATCH_FILE = 36013;

    public static final int ADS_UPLOAD_FAILURE = 36013;
    public static final int ADS_UPLOAD_DISTRIBUTION_FAILURE = 36014;

    public static final int ADS_BIND_ACTIVITY = 36115;
    public static final int ADS_DELETE_SUBORDINATE = 36116;
    public static final int ADS_BIND_ORDER = 36117;
    public static final int ADS_BIND_BLACKLIST = 36118;

    public static final int ADS_REPEAT_KEY = 36119;
    public static final int ADS_REPEAT_ID = 36120;

    public static final String ADS_ACTIVITY_ADVERTISER_ID_IS_NULL_MSG = "广告主为空";
    public static final String ADS_ACTIVITY_BRAND_ID_IS_NULL_MSG = "品牌为空";
    public static final String ADS_ACTIVITY_PRODUCT_ID_IS_NULL_MSG = "产品为空";
    public static final String ADS_ACTIVITY_NAME_IS_NULL_MSG = "活动名称为空";
    public static final String ADS_ACTIVITY_NAME_IS_REPEAT_MSG = "活动名称重复";
    public static final String ADS_ACTIVITY_BUDGET_IS_NULL_MSG = "总预算为空";
    public static final String ADS_ACTIVITY_BUDGET_GREATER_THAN_ZERO_MSG = "总预算应为大于零";
    public static final String ADS_ACTIVITY_START_DATE_IS_NULL_MSG = "投放开始时间为空";
    public static final String ADS_ACTIVITY_END_DATE_IS_NULL_MSG = "投放结束时间为空";
    public static final String ADS_ACTIVITY_SALE_TYPE_IS_NULL_MSG = "售卖类型为空";
    public static final String ADS_ACTIVITY_CODE_IS_NULL_MSG = "活动Code为空";
    public static final String ADS_ACTIVITY_CODE_IS_REPEAT_MSG = "活动Code重复";

    public static final String ADS_GROUP_MEDIA_ID_IS_NULL_MSG = "媒体为空";
    public static final String ADS_GROUP_PLATFORM_ID_IS_NULL_MSG = "平台为空";
    public static final String ADS_GROUP_AD_TYPE_ID_IS_NULL_MSG = "广告类型为空";
    public static final String ADS_GROUP_AD_POSITION_ID_IS_NULL_MSG = "广告位为空";
    public static final String ADS_GROUP_AD_STYLES_ID_IS_NULL_MSG = "广告样式为空";
    public static final String ADS_GROUP_NAME_IS_NULL_MSG = "广告组名称为空";
    public static final String ADS_GROUP_NAME_IS_REPEAT_MSG = "广告组名称重复";
    public static final String ADS_GROUP_SETTLE_MODE_CODE_IS_NULL_MSG = "结算方式为空";
    public static final String ADS_GROUP_THROW_TYPE_CODE_IS_NULL_MSG = "投放类型为空";
    public static final String ADS_GROUP_THROW_MODE_CODE_IS_NULL_MSG = "投放方式为空";
    public static final String ADS_GROUP_DSP_ID_IS_NULL_MSG = "dsp为空";

    public static final String ADS_ORDER_CITY_ID_IS_NULL_MSG = "城市为空";
    public static final String ADS_ORDER_NAME_IS_REPEAT_MSG = "订单名称重复";
    public static final String ADS_ORDER_DATE_IS_VALID_MSG = "开始时间和结束时间超过所在上层的时间";

    public static final String ADS_PRIMARY_KEY_IS_NULL_MSG = "缺少主键ID";

    public static final String ADS_MATERIAL_ADVERTISER_ID_IS_NULL_MSG = "素材广告主id为空";
    public static final String ADS_MATERIAL_ADVERTISER_NAME_IS_NULL_MSG = "素材广告主名称为空";
    public static final String ADS_MATERIAL_SPECS_ID_IS_NULL_MSG = "素材规格id为空";
    public static final String ADS_MATERIAL_SPECS_NAME_IS_NULL_MSG = "素材规格名称为空";
    public static final String ADS_MATERIAL_PLATE_FORM_NAME_IS_NULL_MSG = "素材平台名称为空";
    public static final String ADS_MATERIAL_AD_TYPE_NAME_IS_NULL_MSG = "素材广告类型为空";
    public static final String ADS_MATERIAL_AD_STYLE_IS_NULL_MSG = "素材广告样式为空";
    public static final String ADS_MATERIAL_AD_SIZE_IS_NULL_MSG = "素材广告尺寸为空";
    public static final String ADS_MATERIAL_AD_FORMAT_IS_NULL_MSG = "素材广告格式为空";
    public static final String ADS_MATERIAL_URL_IS_NULL_MSG = "素材文件路径为空";
    public static final String ADS_MATERIAL_NAME_REPEAT_MSG = "素材名称重复";
    public static final String ADS_MATERIAL_DEFINITION_IS_NULL_OR_ILLEGAL_MSG = "素材格式是视频格式时所选清晰度为空或为非法值";
    public static final String ADS_MATERIAL_FORMAT_IS_NOT_MATCH_FILE_MSG = "素材格式与上传文件格式不匹配";
    public static final String ADS_MATERIAL_SIZE_IS_NOT_MATCH_FILE_MSG = "素材尺寸与上传文件尺寸不匹配";

    public static final String ADS_BIND_ACTIVITY_MSG = "已绑定广告活动";
    public static final String ADS_DELETE_SUBORDINATE_MSG = "确认删除下属数据";
    public static final String ADS_BIND_ORDER_MSG = "已绑定广告订单";
    public static final String ADS_BIND_BLACKLIST_MSG = "已绑定黑名单";
    public static final String ADS_UPLOAD_FAILURE_MSG = "文件上传失败";
    public static final String ADS_UPLOAD_DISTRIBUTION_FAILURE_MSG = "渠道文件异常";

    public static final String ADS_REPEAT_KEY_MSG = "输入key重复";
    public static final String ADS_REPEAT_ID_MSG = "输入id重复";

    public static final Map<Integer, String> msgMap = new HashMap<Integer, String>();
    public static final Map<Integer, String> commonMsgMap = new HashMap<Integer, String>();
    public static final Map<Integer, String> sspMsgMap = new HashMap<Integer, String>();
    public static final Map<Integer, String> adxMsgMap = new HashMap<Integer, String>();
    public static final Map<Integer, String> adsMsgMap = new HashMap<Integer, String>();
    public static final Map<Integer, String> engineMsgMap = new HashMap<Integer, String>();

    //engine部分业务错误码（50000-59999）
    public static final int ENGINE_DES3_DECRYT_ERROR = 50000;
    public static final int ENGINE_POS_ID_EMPTY = 50005;
    public static final int ENGINE_DEVICE_ID_EMPTY = 50006;
    public static final int ENGINE_POS_INVALID = 50010;
    public static final int ENGINE_APP_ID_EMPTY = 50020;
    public static final int ENGINE_POS_APP_MISMATCHING = 50030;
    public static final int ENGINE_CREQUEST_ID_EMPTY = 50040;
    public static final int ENGINE_API_APP_SITE_PARAM_ERROR = 50045;
    public static final int ENGINE_PLATFORM_ID_MISMATCHING = 50050;
    public static final int ENGINE_MAX_DURATION_INVALID = 50060;
    public static final int ENGINE_LOADTYPE_MISMATCHING = 50070;


    public static final int ENGINE_SERVER_ERROR = 50080;
    public static final int ENGINE_CTX_PARAM_ERROR = 50090;
    public static final int ENGINE_BUILD_MATERIAL_ERROR = 50110;
    public static final int ENGINE_REQUEST_ADX_ERROR = 50120;
    public static final int ENGINE_BUILD_ADXREQUEST_ERROR = 50130;
    public static final int ENGINE_BUILD_ADX_MATERIAL_ERROR = 50140;

    public static final int ENGINE_BLACK_RULE = 50150;

    public static final String ENGINE_DES3_DECRYT_ERROR_MSG = "3DES decrypt error";
    public static final String ENGINE_POS_ID_EMPTY_MSG = "广告位ID为空";
    public static final String ENGINE_DEVICE_ID_EMPTY_MSG = "设备ID imei，oaid，androidID，idfa均为空";
    public static final String ENGINE_POS_INVALID_MSG = "无效的广告位";
    public static final String ENGINE_APP_ID_EMPTY_MSG = "应用ID为空";
    public static final String ENGINE_POS_APP_MISMATCHING_MSG = "广告位ID与应用ID不匹配";
    public static final String ENGINE_CREQUEST_ID_EMPTY_MSG = "请求ID为空";
    public static final String ENGINE_API_APP_SITE_PARAM_ERROR_MSG = "app和site参数有误";
    public static final String ENGINE_PLATFORM_ID_MISMATCHING_MSG = "平台参数错误";
    public static final String ENGINE_MAX_DURATION_INVALID_MSG = "广告时长参数有误";
    public static final String ENGINE_LOADTYPE_MISMATCHING_MSG = "渲染方式与配置不匹配";
    public static final String ENGINE_SERVER_ERROR_MSG = "引擎服务异常";
    public static final String ENGINE_CTX_PARAM_ERROR_MSG = "引擎CTX解析有误";
    public static final String ENGINE_BUILD_MATERIAL_MSG = "引擎组装素材有误";
    public static final String ENGINE_BUILD_ADXREQUEST_MSG = "组装adxrequest失败";
    public static final String ENGINE_REQUEST_ADX_MSG = "请求adx失败";
    public static final String ENGINE_BUILD_ADX_MATERIAL_MSG = "解析adx失败";


    static {
        commonMsgMap.put(OK, OK_MSG);
        commonMsgMap.put(ERROR, ERROR_MSG);
        commonMsgMap.put(LOGIN_USERNAME_PASSPORD_ERROR, LOGIN_USERNAME_PASSPORD_ERROR_MSG);
        commonMsgMap.put(ACCESS_ERROR, ACCESS_ERROR_MSG);
        commonMsgMap.put(REMOTE_ERROR, REMOTE_ERROR_MSG);
        commonMsgMap.put(REP_ERROR, REP_ERROR_MSG);
        commonMsgMap.put(ACCOUNT_NO_TYPE_ERROR, ACCOUNT_NO_TYPE_ERROR_MSG);
        commonMsgMap.put(NOT_AUDIT_QUALIFICATION_CANNOT_UPLOAD_AGAIN, NOT_AUDIT_QUALIFICATION_CANNOT_UPLOAD_AGAIN_MSG);
        commonMsgMap.put(BUSINESS_LICENSE_URL_EMPTY, BUSINESS_LICENSE_URL_EMPTY_MSG);
        commonMsgMap.put(ACCOUNT_NO_CANNOT_EMPTY, ACCOUNT_NO_CANNOT_EMPTY_MSG);
        commonMsgMap.put(ACCOUNT_NAME_CANNOT_EMPTY, ACCOUNT_NAME_CANNOT_EMPTY_MSG);
        commonMsgMap.put(COMPANY_NAME_CANNOT_EMPTY, COMPANY_NAME_CANNOT_EMPTY_MSG);
        commonMsgMap.put(COMPANY_NAME_ALREADY_EXISTS, COMPANY_NAME_ALREADY_EXISTS_MSG);
        commonMsgMap.put(QUALIFICATION_INFO_EMPTY, QUALIFICATION_INFO_EMPTY_MSG);
        commonMsgMap.put(ROLE_NAME_CANNOT_EMPTY, ROLE_NAME_CANNOT_EMPTY_MSG);
        commonMsgMap.put(OUTER_ACCOUNT_AUTH_ABOVE, OUTER_ACCOUNT_AUTH_ABOVE_MSG);
        commonMsgMap.put(DICTIONARY_CODE_REPEAT, DICTIONARY_CODE_REPEAT_MSG);
        commonMsgMap.put(ACCOUNT_NO_NOT_EXISTS, ACCOUNT_NO_NOT_EXISTS_MSG);
        commonMsgMap.put(REGISTER_PLATFORM_ERROR, REGISTER_PLATFORM_ERROR_MSG);
        commonMsgMap.put(ADDRESS_EMPTY, ADDRESS_EMPTY_MSG);
        commonMsgMap.put(EMAIL_EMPTY, EMAIL_EMPTY_MSG);
        commonMsgMap.put(BANK_NAME_EMPTY, BANK_NAME_EMPTY_MSG);
        commonMsgMap.put(BANK_ACCOUNT_NAME_EMPTY, BANK_ACCOUNT_NAME_EMPTY_MSG);
        commonMsgMap.put(BANK_ACCOUNT_NO_EMPTY, BANK_ACCOUNT_NO_EMPTY_MSG);
        commonMsgMap.put(COMPANY_NAME_ACCOUNT_NO_NOT_MAPPING, COMPANY_NAME_ACCOUNT_NO_NOT_MAPPING_MSG);
        commonMsgMap.put(DISTRIBUTION_USER_LIST_EMPTY, DISTRIBUTION_USER_LIST_EMPTY_MSG);
        commonMsgMap.put(CUSTOMER_RESOURCE_EMPTY, CUSTOMER_RESOURCE_EMPTY_MSG);
        commonMsgMap.put(QUALIFICATION_AUDIT_TYPE_ERROR, QUALIFICATION_AUDIT_TYPE_ERROR_MSG);
        commonMsgMap.put(CONTACT_PERSON_EMPTY, CONTACT_PERSON_EMPTY_MSG);
        commonMsgMap.put(SYSTEM_ERROR, SYSTEM_ERROR_MSG);
        commonMsgMap.put(ACCOUNT_NAME_ALREADY_EXISTS, ACCOUNT_NAME_ALREADY_EXISTS_MSG);
        commonMsgMap.put(ACCOUNT_CODE_ALREADY_EXISTS, ACCOUNT_CODE_ALREADY_EXISTS_MSG);


        //SSP部分
        sspMsgMap.put(SSP_MEDIA_NAME_EMPTY, SSP_MEDIA_NAME_EMPTY_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_ERROR, SSP_ACCESS_TYPE_ERROR_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_VERSION_ERROR, SSP_ACCESS_TYPE_VERSION_ERROR_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_ID_EMPTY, SSP_ACCESS_TYPE_ID_EMPTY_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_DOC_URL_EMPTY, SSP_ACCESS_TYPE_DOC_URL_EMPTY_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_DATA_EMPTY, SSP_ACCESS_TYPE_DATA_EMPTY_MSG);
        sspMsgMap.put(SSP_MEDIA_NAME_CANNOT_SAME, SSP_MEDIA_NAME_CANNOT_SAME_MSG);
        sspMsgMap.put(SSP_MEDIA_ID_EMPTY, SSP_MEDIA_ID_EMPTY_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_ERROR, SSP_MEDIA_STATUS_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_ID_DATA_EMPTY, SSP_MEDIA_ID_DATA_EMPTY_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_CLOSE_ERROR, SSP_MEDIA_STATUS_CLOSE_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_OPEN_ERROR, SSP_MEDIA_STATUS_OPEN_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_CLOSE_SUCC, SSP_MEDIA_STATUS_CLOSE_SUCC_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_OPEN_SUCC, SSP_MEDIA_STATUS_OPEN_SUCC_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_ID_ERROR, SSP_MEDIA_APP_ID_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_AUDIT_STATUS_ERROR, SSP_MEDIA_APP_AUDIT_STATUS_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_ID_DATA_EMPTY, SSP_MEDIA_APP_ID_DATA_EMPTY_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_AUDIT_FAIL, SSP_MEDIA_APP_AUDIT_FAIL_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_AUDIT_SUCC, SSP_MEDIA_APP_AUDIT_SUCC_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_STATUS_ERROR, SSP_MEDIA_APP_STATUS_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_AUDIT_NOT_PASS_CANNOT_OPEN, SSP_MEDIA_APP_AUDIT_NOT_PASS_CANNOT_OPEN_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_NAME_EMPTY, SSP_SHIELD_RULES_NAME_EMPTY_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_KEYWORDS_EMPTY, SSP_SHIELD_RULES_KEYWORDS_EMPTY_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_PACKAGES_EMPTY, SSP_SHIELD_RULES_PACKAGES_EMPTY_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_TRADEING_EMPTY, SSP_SHIELD_RULES_TRADEING_EMPTY_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_CUSTOMER_EMPTY, SSP_SHIELD_RULES_CUSTOMER_EMPTY_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_ID_EMPTY, SSP_SHIELD_RULES_ID_EMPTY_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_NOT_EXISTS, SSP_SHIELD_RULES_NOT_EXISTS_MSG);
        sspMsgMap.put(SSP_POS_TYPE_ID_ERROR, SSP_POS_TYPE_ID_ERROR_MSG);
        sspMsgMap.put(SSP_POS_TYPE_STYLE_ID_ERROR, SSP_POS_TYPE_STYLE_ID_ERROR_MSG);
        sspMsgMap.put(SSP_NOT_AUDIT_MEDIA_APP_CANNOT_CREATE_POSITION, SSP_NOT_AUDIT_MEDIA_APP_CANNOT_CREATE_POSITION_MSG);
        sspMsgMap.put(SSP_MEDIA_POS_ID_ERROR, SSP_MEDIA_POS_ID_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_POS_STATUS_ERROR, SSP_MEDIA_POS_STATUS_ERROR_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_NOT_OPEN, SSP_MEDIA_STATUS_NOT_OPEN_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_STATUS_NOT_OPEN, SSP_MEDIA_APP_STATUS_NOT_OPEN_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_NOT_AUDIT_NOT_ALLOWED_MODIFY, SSP_MEDIA_APP_NOT_AUDIT_NOT_ALLOWED_MODIFY_MSG);
        sspMsgMap.put(SSP_AD_TYPE_NOT_MODIFY, SSP_AD_TYPE_NOT_MODIFY_MSG);
        sspMsgMap.put(SSP_PLATFORM_NOT_MODIFY, SSP_PLATFORM_NOT_MODIFY_MSG);
        sspMsgMap.put(SSP_MEDIA_NOT_MODIFY, SSP_MEDIA_NOT_MODIFY_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_NOT_MODIFY, SSP_ACCESS_TYPE_NOT_MODIFY_MSG);
        sspMsgMap.put(SSP_MEDIA_APP_NAME_INVALID, SSP_MEDIA_APP_NAME_INVALID_MSG);
        sspMsgMap.put(SSP_TOTAL_USER_COUNT_INVALID, SSP_TOTAL_USER_COUNT_INVALID_MSG);
        sspMsgMap.put(SSP_DAY_ACTIVE_USER_COUNT_INVALID, SSP_DAY_ACTIVE_USER_COUNT_INVALID_MSG);
        sspMsgMap.put(SSP_PLATFORM_INVALID, SSP_PLATFORM_INVALID_MSG);
        sspMsgMap.put(SSP_ACCESS_TYPE_INVALID, SSP_ACCESS_TYPE_INVALID_MSG);
        sspMsgMap.put(SSP_APP_DOWNLOAD_URL_INVALID, SSP_APP_DOWNLOAD_URL_INVALID_MSG);
        sspMsgMap.put(SSP_PACKAGE_NAME_INVALID, SSP_PACKAGE_NAME_INVALID_MSG);
        sspMsgMap.put(SSP_APPLICATION_TYPE_INVALID, SSP_APPLICATION_TYPE_INVALID_MSG);
        sspMsgMap.put(SSP_WEBSITE_DOMAIN_INVALID, SSP_WEBSITE_DOMAIN_INVALID_MSG);
        sspMsgMap.put(SSP_OFFICAL_WEBSITE_INVALID, SSP_OFFICAL_WEBSITE_INVALID_MSG);
        sspMsgMap.put(SSP_DATA_REPORT_QUERY_TYPE_ERROR, SSP_DATA_REPORT_QUERY_TYPE_ERROR_MSG);
        sspMsgMap.put(SSP_SHIELD_RULES_KEYWORDS_PACKAGES_TRADE_CUSTOMER_ALL_EMPTY, SSP_SHIELD_RULES_KEYWORDS_PACKAGES_TRADE_CUSTOMER_ALL_EMPTY_MSG);
        sspMsgMap.put(SSP_MEDIA_STATUS_NOT_OPEN, SSP_MEDIA_STATUS_NOT_OPEN_MSG);


        //ADX部分
        adxMsgMap.put(ADX_REQUEST_PARAM_LACK, ADX_REQUEST_PARAM_LACK_MSG);
        adxMsgMap.put(ADX_POSITION_NAME_REPEAT, ADX_POSITION_NAME_REPEAT_MAS);
        adxMsgMap.put(ADX_DSP_AND_TOKEN_NOT_MATCH_CODE, ADX_DSP_AND_TOKEN_NOT_MATCH);
        adxMsgMap.put(ADX_DSP_OR_TOKEN_IS_NULL_CODE, ADX_DSP_OR_TOKEN_IS_NULL);


        //ADS部分
        adsMsgMap.put(ADS_ACTIVITY_ADVERTISER_ID_IS_NULL, ADS_ACTIVITY_ADVERTISER_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_BRAND_ID_IS_NULL, ADS_ACTIVITY_BRAND_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_PRODUCT_ID_IS_NULL, ADS_ACTIVITY_PRODUCT_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_NAME_IS_NULL, ADS_ACTIVITY_NAME_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_NAME_IS_REPEAT, ADS_ACTIVITY_NAME_IS_REPEAT_MSG);
        adsMsgMap.put(ADS_ACTIVITY_BUDGET_IS_NULL, ADS_ACTIVITY_BUDGET_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_BUDGET_GREATER_THAN_ZERO, ADS_ACTIVITY_BUDGET_GREATER_THAN_ZERO_MSG);
        adsMsgMap.put(ADS_ACTIVITY_START_DATE_IS_NULL, ADS_ACTIVITY_START_DATE_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_END_DATE_IS_NULL, ADS_ACTIVITY_END_DATE_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_SALE_TYPE_IS_NULL, ADS_ACTIVITY_SALE_TYPE_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_CODE_IS_NULL, ADS_ACTIVITY_CODE_IS_NULL_MSG);
        adsMsgMap.put(ADS_ACTIVITY_CODE_IS_REPEAT, ADS_ACTIVITY_CODE_IS_REPEAT_MSG);

        adsMsgMap.put(ADS_GROUP_MEDIA_ID_IS_NULL, ADS_GROUP_MEDIA_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_PLATFORM_ID_IS_NULL, ADS_GROUP_PLATFORM_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_AD_TYPE_ID_IS_NULL, ADS_GROUP_AD_TYPE_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_AD_POSITION_ID_IS_NULL, ADS_GROUP_AD_POSITION_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_AD_STYLES_ID_IS_NULL, ADS_GROUP_AD_STYLES_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_NAME_IS_NULL, ADS_GROUP_NAME_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_NAME_IS_REPEAT, ADS_GROUP_NAME_IS_REPEAT_MSG);
        adsMsgMap.put(ADS_GROUP_SETTLE_MODE_CODE_IS_NULL, ADS_GROUP_SETTLE_MODE_CODE_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_THROW_TYPE_CODE_IS_NULL, ADS_GROUP_THROW_TYPE_CODE_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_THROW_MODE_CODE_IS_NULL, ADS_GROUP_THROW_MODE_CODE_IS_NULL_MSG);
        adsMsgMap.put(ADS_GROUP_DSP_ID_IS_NULL, ADS_GROUP_DSP_ID_IS_NULL_MSG);

        adsMsgMap.put(ADS_ORDER_CITY_ID_IS_NULL, ADS_ORDER_CITY_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_ORDER_NAME_IS_REPEAT, ADS_ORDER_NAME_IS_REPEAT_MSG);
        adsMsgMap.put(ADS_ORDER_DATE_IS_VALID, ADS_ORDER_DATE_IS_VALID_MSG);

        adsMsgMap.put(ADS_PRIMARY_KEY_IS_NULL, ADS_PRIMARY_KEY_IS_NULL_MSG);

        adsMsgMap.put(ADS_MATERIAL_ADVERTISER_ID_IS_NULL, ADS_MATERIAL_ADVERTISER_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_ADVERTISER_NAME_IS_NULL, ADS_MATERIAL_ADVERTISER_NAME_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_SPECS_ID_IS_NULL, ADS_MATERIAL_SPECS_ID_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_SPECS_NAME_IS_NULL, ADS_MATERIAL_SPECS_NAME_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_PLATE_FORM_NAME_IS_NULL, ADS_MATERIAL_PLATE_FORM_NAME_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_AD_TYPE_NAME_IS_NULL, ADS_MATERIAL_AD_TYPE_NAME_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_AD_STYLE_IS_NULL, ADS_MATERIAL_AD_STYLE_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_AD_SIZE_IS_NULL, ADS_MATERIAL_AD_SIZE_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_AD_FORMAT_IS_NULL, ADS_MATERIAL_AD_FORMAT_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_URL_IS_NULL, ADS_MATERIAL_URL_IS_NULL_MSG);
        adsMsgMap.put(ADS_MATERIAL_NAME_REPEAT, ADS_MATERIAL_NAME_REPEAT_MSG);
        adsMsgMap.put(ADS_MATERIAL_DEFINITION_IS_NULL_OR_ILLEGAL, ADS_MATERIAL_DEFINITION_IS_NULL_OR_ILLEGAL_MSG);
        adsMsgMap.put(ADS_MATERIAL_FORMAT_IS_NOT_MATCH_FILE, ADS_MATERIAL_FORMAT_IS_NOT_MATCH_FILE_MSG);
        adsMsgMap.put(ADS_MATERIAL_SIZE_IS_NOT_MATCH_FILE, ADS_MATERIAL_SIZE_IS_NOT_MATCH_FILE_MSG);

        engineMsgMap.put(ENGINE_DES3_DECRYT_ERROR, ENGINE_DES3_DECRYT_ERROR_MSG);
        engineMsgMap.put(ENGINE_API_APP_SITE_PARAM_ERROR, ENGINE_API_APP_SITE_PARAM_ERROR_MSG);
        engineMsgMap.put(ENGINE_APP_ID_EMPTY, ENGINE_APP_ID_EMPTY_MSG);
        engineMsgMap.put(ENGINE_POS_ID_EMPTY, ENGINE_POS_ID_EMPTY_MSG);
        engineMsgMap.put(ENGINE_DEVICE_ID_EMPTY, ENGINE_DEVICE_ID_EMPTY_MSG);
        engineMsgMap.put(ENGINE_CREQUEST_ID_EMPTY, ENGINE_CREQUEST_ID_EMPTY_MSG);
        engineMsgMap.put(ENGINE_POS_INVALID, ENGINE_POS_INVALID_MSG);
        engineMsgMap.put(ENGINE_POS_APP_MISMATCHING, ENGINE_POS_APP_MISMATCHING_MSG);
        engineMsgMap.put(ENGINE_PLATFORM_ID_MISMATCHING, ENGINE_PLATFORM_ID_MISMATCHING_MSG);
        engineMsgMap.put(ENGINE_MAX_DURATION_INVALID, ENGINE_MAX_DURATION_INVALID_MSG);
        engineMsgMap.put(ENGINE_LOADTYPE_MISMATCHING, ENGINE_LOADTYPE_MISMATCHING_MSG);


        engineMsgMap.put(ENGINE_SERVER_ERROR, ENGINE_SERVER_ERROR_MSG);
        engineMsgMap.put(ENGINE_CTX_PARAM_ERROR, ENGINE_CTX_PARAM_ERROR_MSG);
        engineMsgMap.put(ENGINE_BUILD_MATERIAL_ERROR, ENGINE_BUILD_MATERIAL_MSG);
        engineMsgMap.put(ENGINE_REQUEST_ADX_ERROR, ENGINE_REQUEST_ADX_MSG);
        engineMsgMap.put(ENGINE_BUILD_ADXREQUEST_ERROR, ENGINE_BUILD_ADXREQUEST_MSG);
        engineMsgMap.put(ENGINE_BUILD_ADX_MATERIAL_ERROR, ENGINE_BUILD_ADX_MATERIAL_MSG);

        msgMap.putAll(commonMsgMap);
        msgMap.putAll(sspMsgMap);
        msgMap.putAll(adxMsgMap);
        msgMap.putAll(adsMsgMap);
        msgMap.putAll(engineMsgMap);
    }

    public static void main(String[] args) {
        System.out.println(StatusCode.OK + StatusCode.msgMap.get(StatusCode.OK));
    }
}
