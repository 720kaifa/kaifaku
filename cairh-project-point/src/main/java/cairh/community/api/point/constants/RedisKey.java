package cairh.community.api.point.constants;
/***********************************************************************************
 *1-->2013-05-28 create by stevinzhu@cairenhui.com redis  key 定义  BugNo:-- 
 *2-->
 ***********************************************************************************/
public class RedisKey {
   
   /** REDIS key 手机验证码前缀   如果一个用户手机为 13000000000 则他的key值为 HTSEC_MSCODE_13000000000 验证码需要设置过期时间  5分钟 */ 
   public static final  String VALIDATE_CODE_PREFIX =  "HTSEC_MSCODE_"; 
   
   /** REDIS key 用户填写基本信息  如果一个用户的ID 为  100000 则其key 为 HTSEC_BASEINFO_100000    需要设置过期时间3天   */ 
   public static final  String USER_INFO_PREFIX= "HTSEC_BASEINFO_";
  
   /** REDIS key 有营业部的城市列表  */ 
   public static final  String OUTLETS_CITYS = "HTSEC_BASEINFO_OUTLETS_CITYS";
   
   /** REDIS key 身份验证  此步骤耗时时间  */ 
   public static final  String OPEN_TIME_VERIFY = "HTSEC_OPEN_TIME_VERIFY";
   /** REDIS key 开户申请  此步骤耗时时间  */ 
   public static final  String OPEN_TIME_APPLY = "HTSEC_OPEN_TIME_APPLY";
   
}