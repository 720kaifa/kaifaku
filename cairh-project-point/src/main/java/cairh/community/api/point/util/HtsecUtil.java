package cairh.community.api.point.util;

import java.util.Map;

import cairh.community.api.point.constants.Fields;

import org.apache.commons.lang.StringUtils;

/**
 * 开户相关util方法
 * @author Administrator
 *
 */
public class HtsecUtil {
	/**
	 * 获取业务类型
	 * @param type
	 * @return
	 */
	public static String getBusinessType(int type){
		String res = "未知";
		if(type == Fields.BUSINESS_TYPE_REGISTER){
			res = "注册";
		}else if(type == Fields.BUSINESS_TYPE_LOGIN){
			res = "登录";
		}else if(type == Fields.BUSINESS_TYPE_IMPROVE){
			res = "待整改";
		}else if(type == Fields.BUSINESS_TYPE_CA_SUCCESS){
			res = "CA证书颁发成功";
		}else if(type == Fields.BUSINESS_TYPE_CA_FAIL){
			res = "CA证书颁发失败";
		}else if(type == Fields.BUSINESS_TYPE_OPEN_SUCCESS){
			res = "开户成功";
		}else if(type == Fields.BUSINESS_TYPE_OPEN_FAIL){
			res = "开户失败";
		}else if(type == Fields.BUSINESS_TYPE_PASSWORD){
			res = "三方绑定（输入密码）";
		}else if(type == Fields.BUSINESS_TYPE_QGM){
			res = "抢购码";
		}else if(type == Fields.BUSINESS_TYPE_ZYYC){
			res = "异常账户提醒";
		}else if(type == 100){
			res = "身份证信息更新";
		}else if(type == 101){
			res = "密码重置";
		}else if(type == 102){
			res = "修改手机号码";
		}else if (type ==103) {
			res = "基金账户开通";
		}else if(type == 104){
			res = "上海 深圳账户开立";
		}else if(type == 105){
			res = "行权融资开通";
		}
		return res;
	}
	
	/**
	 * 获取详细地址
	 * @param province
	 * @param city
	 * @param area
	 * @param addr
	 * @return
	 */
	public static String getDetailAddress(String province, String city, String area, String addr){
		String res = "";
		
		if(StringUtils.isNotEmpty(province)){
			if(province.equalsIgnoreCase("北京")
					|| province.equalsIgnoreCase("天津")
					|| province.equalsIgnoreCase("上海")
					|| province.equalsIgnoreCase("重庆")){
				res += (province + "市");
			}else{
				res += (province + "省");
			}
		}
		if(StringUtils.isNotEmpty(city)){
			res += (city + "市");
		}
		if(StringUtils.isNotEmpty(area)){
			res += (area);
		}
		if(StringUtils.isNotEmpty(addr)){
			res += addr;
		}
		
		return res;
	}
	
	/**
	 * 获取账户名称
	 * @param investType
	 * @param accountType
	 * @return
	 */
	public static String getAccountName(String investType, String accountType){
		String res = "";
		
		
		
		return res;
	}
	
	public static String getOpenAccountStatus(long status){
		String res = "未知";
		
		if(status == Fields.ACCOUNT_REGISTER){
			res = "注册成功";
		}else if(status == Fields.ACCOUNT_VALIDATED){
			res = "实名验证成功";
		}else if(status == Fields.ACCOUNT_APPLY){
			res = "开户申请中";
		}else if(status == Fields.ACCOUNT_CHECKS){
			res = "审核中";
		}else if(status == Fields.ACCOUNT_IMPROVE){
			res = "用户整改";
		}else if(status == Fields.ACCOUNT_REVIEW){
			res = "复核中";
		}else if(status == Fields.ACCOUNT_REVIEW_SUCCESS){
			res = "复核通过";
		}else if(status == Fields.ACCOUNT_REVIEW_FAIL){
			res = "复核未通过";
		}else if(status == Fields.ACCOUNT_AT_CUNTER){
			res = "柜台预开户";
		}else if(status == Fields.ACCOUNT_PRE_SUCCESS){
			res = "柜台预开户成功";
		}else if(status == Fields.ACCOUNT_PRE_FAIL){
			res = "柜台预开户失败";
		}else if(status == Fields.ACCOUNT_CALLBACK){
			res = "回访中";
		}else if(status == Fields.ACCOUNT_SUCCESS){
			res = "开户成功";
		}else if(status == Fields.ACCOUNT_FAIL){
			res = "开户失败";
		}else if(status == Fields.CA_DELIVERY_REJECT){
			res = "证书发放审批未通过通过";
		}
		
		return res;
	}
	
	/**
	 * 视频验证状态
	 * @param sta
	 * @return
	 */
	public static String getVerifyStatus(long status, long type) {
		String res = "";
		
		if(type == Fields.VERIFY_TYPE_BANK){
			res += "银行实名验证";
		}else if(type == Fields.VERIFY_TYPE_VIDEO){
			res += "视频实名验证";
		}else{
			res += "未知来源";
		}
		
		if(status == Fields.VIDEO_VERIFY_STATUS_NOT_VERIFY){
			res += "未验证";
		}else if(status == Fields.VIDEO_VERIFY_STATUS_FAIL){
			res += "未通过";
		}else if(status == Fields.VIDEO_VERIFY_STATUS_SUCC){
			res += "通过";
		}else{
			res += "未知结果";
		}
		
		return res;
	}
	
	/**
	 * @param status
	 * @return
	 */
	public static String getBankVeirfyStatus(String status){
		long statusl = 1l;
		if(StringUtil.isNotEmpty(status)) {
			
			if("8".equals(status)) statusl = 8l;
			else if("9".equals(status))  statusl = 9l;
			
		}
		return getVerifyStatus(statusl,Fields.VERIFY_TYPE_BANK);
	}
	
	
	public static String getTypesString(long dicType, String typesValues, Map<String,String> map){
		if(typesValues == null || typesValues.trim().length() == 0) return "";
		String[] s = typesValues.split(Fields.COMMA_SPLIT);
		if(s == null || s.length==0) return "";
		String key;
		String result = "";
		for(String temp : s){
			key = dicType + Fields.DIC_SPLIT + temp;
			result += "、" + (null == map.get(key) ? "" : map.get(key));
		}
		if(result.length()>0) result = result.substring(1);
		return result;
	}
	
	public static String getTypesString(long dicType, String typesValues, Map<String,String> map, String split){
		if(typesValues == null || typesValues.trim().length() == 0){
			return "";
		}
		String[] s = typesValues.split(Fields.COMMA_SPLIT);
		if(s == null || s.length==0){
			return "";
		}
		String key = "";
		String result = "";
		for(String temp : s){
			key = dicType + Fields.DIC_SPLIT + temp;
			result += (null == map.get(key) ? "" : map.get(key)) + split;
		}
		
		return result;
	}
	
	/**
	 * 映射股票账户状态
	 * 0 正常 1 休眠 2 不合规 3 挂失 4 冻结 5 清理 6 注销
	 * @param status
	 * @return
	 */
	public static String getStockAccountStatus(String status){
		String res = "未知";
		
		if(status.equals("0")){
			res = "正常";
		}else if(status.equals("1")){
			res = "休眠";
		}else if(status.equals("2")){
			res = " 不合规";
		}else if(status.equals("3")){
			res = "挂失";
		}else if(status.equals("4")){
			res = "冻结";
		}else if(status.equals("5")){
			res = "清理";
		}else if(status.equals("6")){
			res = "注销";
		}
		
		return res;
	}
	
	/**
	 * 获取证件类型
	 * @param certType
	 * @return
	 */
	public static String getCertType(String certType){
		String res = "其它";
		
		if(certType.equalsIgnoreCase("0")){
			res = "身份证";
		}else if(certType.equalsIgnoreCase("1")){
			res = "法人执照";
		}else if(certType.equalsIgnoreCase("7")){
			res = "其它证件";
		}else if(certType.equalsIgnoreCase("9")){
			res = "护照";
		}else if(certType.equalsIgnoreCase("10")){
			res = "社会保障号";
		}else if(certType.equalsIgnoreCase("11")){
			res = "军人证";
		}else if(certType.equalsIgnoreCase("12")){
			res = "登记证书";
		}else if(certType.equalsIgnoreCase("13")){
			res = "批文";
		}else if(certType.equalsIgnoreCase("14")){
			res = "通行证";
		}else{
			res = "其它";
		}
		
		return res;
	}
	
	/**
	 * 获取用户填写的信息
	 * @param userMajorInfo
	 * @param string
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getKeyValue(Map<String, Object> map, String key) {
		if(null == map || map.size() == 0 || StringUtils.isEmpty(key)){
			return "";
		}
		if(null != map.get(key)){
			Map<String, Object> m = (Map<String, Object>)map.get(key);
			if(null != m && null != m.get("fieldValue")){
				String res = (String)m.get("fieldValue");
				
				return res;
			}
		}
		return "";
	}
	
	/**
	 * 获取用户填写的信息
	 * @param userMajorInfo
	 * @param string
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getFactorStr(Map<String, Object> map, String key) {
		if(null == map || map.size() == 0 || StringUtils.isEmpty(key)){
			return "";
		}
		if(null != map.get(key)){
			Map<String, Object> m = (Map<String, Object>)map.get(key);
			if(null != m && null != m.get("factorStr")){
				String res = (String)m.get("factorStr");
				
				return res;
			}
		}
		return "";
	}
}
