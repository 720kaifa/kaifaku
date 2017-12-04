package cairh.community.api.point.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cairh.community.api.point.dao.AccessoryInfoDao;
import cairh.community.api.point.model.AccessoryInfo;
import cairh.community.api.point.model.BaseResult;
import cairh.community.api.point.model.PointLogResult;
import cairh.community.api.point.service.IAjPointService;
import cairh.community.api.point.util.AesUtil;
import cairh.community.api.point.util.Md5Encrypt;

@Controller
public class AjPointPController { 

	@Autowired
	private IAjPointService iAjPointService;
	@Autowired
	private AccessoryInfoDao accessoryInfoDao;
	
	
	/**
	 * 查询用户积分
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM3000")
	public Object getPoint(String accountValue,String accountType,String accessCode,String token) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)
				||StringUtils.isBlank(accessCode)||StringUtils.isBlank(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		//判断接入方代码
		AccessoryInfo accessoryInfo = accessoryInfoDao.getByAccessCode(accessCode);
		if(accessoryInfo==null){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方代码不正确");
			return baseResult;
		}
		String aes = accessoryInfo.getAesKey();
		String md5 = accessoryInfo.getMd5Key();
		
		accountValue = AesUtil.Decrypt(accountValue, aes);
		accountType = AesUtil.Decrypt(accountType, aes);
		
		String md5string = Md5Encrypt.MD5Encode(md5+"|"+accountValue+"|"+accountType+"|"+accessCode);
		if(!md5string.equals(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数认证不通过");
			return baseResult;
		}
		return iAjPointService.getPoint(accountValue,accountType);
	}

	/**
	 * 积分获取、消耗（使用积分业务代码）
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM3001")
	public Object doPoint(String accountValue,String accountType
			,String channelCode,String accessCode,String token) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)
				||StringUtils.isBlank(accessCode)||StringUtils.isBlank(channelCode)||StringUtils.isBlank(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		//判断接入方代码
		AccessoryInfo accessoryInfo = accessoryInfoDao.getByAccessCode(accessCode);
		if(accessoryInfo==null){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方代码不正确");
			return baseResult;
		}
		String aes = accessoryInfo.getAesKey();
		String md5 = accessoryInfo.getMd5Key();
		
		accountValue = AesUtil.Decrypt(accountValue, aes);
		accountType = AesUtil.Decrypt(accountType, aes);
		channelCode = AesUtil.Decrypt(channelCode, aes);
		
		String md5string = Md5Encrypt.MD5Encode(md5+"|"+accountValue+"|"+accountType+"|"+channelCode
				+"|"+accessCode);
		if(!md5string.equals(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数认证不通过");
			return baseResult;
		}
		return iAjPointService.doPoint(channelCode,accountValue,accountType);
	}
	
	/**
	 * 积分获取、消耗（不限制积分业务）
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM3002")
	public Object doPointNoCode(String accountValue,String accountType,String change,
			String remark,String accessCode,String token) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)||StringUtils.isBlank(remark)
				||StringUtils.isBlank(accessCode)||StringUtils.isBlank(change)||StringUtils.isBlank(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		remark = new String(new String(remark.getBytes("ISO-8859-1"), "UTF-8")); 
		
		//判断接入方代码
		AccessoryInfo accessoryInfo = accessoryInfoDao.getByAccessCode(accessCode);
		if(accessoryInfo==null){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方代码不正确");
			return baseResult;
		}
		String aes = accessoryInfo.getAesKey();
		String md5 = accessoryInfo.getMd5Key();
		
		accountValue = AesUtil.Decrypt(accountValue, aes);
		accountType = AesUtil.Decrypt(accountType, aes);
		remark = AesUtil.Decrypt(remark, aes);
		Long changePoint = Long.parseLong(AesUtil.Decrypt(change.toString(), aes));
		
		
		String md5string = Md5Encrypt.MD5Encode(md5+"|"+accountValue+"|"+accountType+"|"+changePoint
				+"|"+remark+"|"+accessCode);
		if(!md5string.equals(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数认证不通过");
			return baseResult;
		}
		return iAjPointService.userPointsModify(changePoint,accountValue,accountType,remark);
	}
	
	/**
	 * 积分流水查询
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM3003")
	public Object userPointsLogQuery(String accountValue,String accountType,
			String beginDate,String endDate,String accessCode,String pageNum,
			String pageSize,String token) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)
				||StringUtils.isBlank(accessCode)||StringUtils.isBlank(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		//方法参数
		String beginDate1;
		String endDate1;
		Integer pageNum1;
		Integer pageSize1;
		
		//判断接入方代码
		AccessoryInfo accessoryInfo = accessoryInfoDao.getByAccessCode(accessCode);
		if(accessoryInfo==null){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方代码不正确");
			return baseResult;
		}
		String aes = accessoryInfo.getAesKey();
		String md5 = accessoryInfo.getMd5Key();
		
		accountValue = AesUtil.Decrypt(accountValue, aes);
		accountType = AesUtil.Decrypt(accountType, aes);
		//accessCode = AesUtil.Decrypt(accessCode, aes);
		if(!StringUtils.isBlank(beginDate)){
			beginDate = "|"+AesUtil.Decrypt(beginDate, aes);
			beginDate1 = AesUtil.Decrypt(beginDate, aes);
		}else{
			beginDate = "";
			beginDate1 = null;
		}
		if(!StringUtils.isBlank(endDate)){
			endDate = "|"+AesUtil.Decrypt(endDate, aes);
			endDate1 = AesUtil.Decrypt(endDate, aes);
		}else{
			endDate = "";
			endDate1 = null;
		}
		if(!StringUtils.isBlank(pageSize)){
			pageSize = "|"+AesUtil.Decrypt(pageSize, aes);
			pageSize1 = Integer.parseInt(pageSize);
		}else{
			pageSize = "";
			pageSize1 = null;
		}
		if(!StringUtils.isBlank(pageNum)){
			pageNum = "|"+AesUtil.Decrypt(pageNum, aes);
			pageNum1 = Integer.parseInt(AesUtil.Decrypt(pageNum, aes));
		}else{
			pageNum = "";
			pageNum1 = 1;
		}
		
		String md5string = Md5Encrypt.MD5Encode(md5+"|"+accountValue+"|"+accountType+beginDate
				+endDate+"|"+accessCode+pageNum+pageSize);
		if(!md5string.equals(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数认证不通过");
			return baseResult;
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date begin = null;
		Date end = null;
		if(!StringUtils.isBlank(beginDate)){
			begin = sdf.parse(beginDate1);  
		}
		if(!StringUtils.isBlank(endDate)){
			end = sdf.parse(endDate1);
		}
		
		PointLogResult PointLogResult =   iAjPointService.userPointsLogQuery(accountValue,accountType, begin, end, pageNum1, pageSize1);
		return PointLogResult;
		
	}
	
	/**
	 * 用户信息绑定
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM3004")
	public Object binDingAccOrPhone(String accountValue,String accountType,
			String accountValue2,String accountType2,String accessCode,String token) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)
				||StringUtils.isBlank(accountValue2)||StringUtils.isBlank(accountType2)
				||StringUtils.isBlank(accessCode)||StringUtils.isBlank(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		//判断接入方代码
		AccessoryInfo accessoryInfo = accessoryInfoDao.getByAccessCode(accessCode);
		if(accessoryInfo==null){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方代码不正确");
			return baseResult;
		}
		String aes = accessoryInfo.getAesKey();
		String md5 = accessoryInfo.getMd5Key();
		
		accountValue = AesUtil.Decrypt(accountValue, aes);
		accountType = AesUtil.Decrypt(accountType, aes);
		accountValue2 = AesUtil.Decrypt(accountValue2, aes);
		accountType2 = AesUtil.Decrypt(accountType2, aes);
		
		String md5string = Md5Encrypt.MD5Encode(md5+"|"+accountValue+"|"+accountType+"|"+accountValue2
				+"|"+accountType2+"|"+accessCode);
		if(!md5string.equals(token)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数认证不通过");
			return baseResult;
		}
		
		return iAjPointService.binding(accountValue,accountType,accountValue2,accountType2);
	}
	
	
	/**
	 * 查询用户积分(内部页面调用)
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3000")
	public Object getPointLoca(String accountValue,String accountType) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		return iAjPointService.getPoint(accountValue,accountType);
	}

	/**
	 * 积分获取、消耗（使用积分业务代码）(内部页面调用)
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3001")
	public Object doPointLoca(String accountValue,String accountType,String channelCode) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)||StringUtils.isBlank(channelCode)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		return iAjPointService.doPoint(channelCode,accountValue,accountType);
	}
	
	/**
	 * 积分获取、消耗（不限制积分业务）(内部页面调用)
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3002")
	public Object doPointNoCodeLoca(String accountValue,String accountType,Long change,
			String remark) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)||StringUtils.isBlank(remark)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		remark = new String(new String(remark.getBytes("ISO-8859-1"), "UTF-8")); 
		
		return iAjPointService.userPointsModify(change,accountValue,accountType,remark);
	}
	
	/**
	 * 积分流水查询(内部页面调用)
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3003")
	public Object userPointsLogQueryLoca(String accountValue,String accountType,
			String beginDate,String endDate,@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date begin = null;
		Date end = null;
		if(beginDate!=null){
			begin = sdf.parse(beginDate);  
		}
		if(endDate!=null){
			end = sdf.parse(endDate);
		}
		
		PointLogResult PointLogResult =   iAjPointService.userPointsLogQuery(accountValue,accountType, begin, end, pageNum, pageSize);
		return PointLogResult;
		
	}
	
	/**
	 * 用户信息绑定(内部页面调用)
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3004")
	public Object binDingAccOrPhoneLoca(String accountValue,String accountType,
			String accountValue2,String accountType2) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accountValue)||StringUtils.isBlank(accountType)
				||StringUtils.isBlank(accountValue2)||StringUtils.isBlank(accountType2)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		return iAjPointService.binding(accountValue,accountType,accountValue2,accountType2);
	}
	
	/**
	 * 接入方信息新增
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3005")
	public Object accessAdd(String accessCode,String accesName) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accessCode)||StringUtils.isBlank(accesName)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		accesName = new String(new String(accesName.getBytes("ISO-8859-1"), "UTF-8")); 
		
		AccessoryInfo accessoryInfo = new AccessoryInfo();
		accessoryInfo.setAccesName(accesName);
		accessoryInfo.setAccessCode(accessCode);
	    List<AccessoryInfo> accessoryInfos = accessoryInfoDao.getByProperties(accessoryInfo);
	    if(accessoryInfos.size()>0){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方不存在");
			return baseResult;
		}
	    
		return iAjPointService.accessAdd(accessCode,accesName);
	}
	
	/**
	 * 接入方信息修改
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CM3006")
	public Object accessModify(String accessCode,String status) throws Exception{
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(accessCode)||StringUtils.isBlank(status)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		AccessoryInfo accessoryInfo = accessoryInfoDao.getByAccessCode(accessCode);
		if(accessoryInfo==null){
			baseResult.setError_no("-1");
			baseResult.setError_info("接入方已存在");
			return baseResult;
		}
		
		return iAjPointService.accessModify(accessCode,status);
	}
}

