package cairh.community.api.point.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cairh.community.api.point.common.ErrorCode;
import cairh.community.api.point.constants.StatusConstants;
import cairh.community.api.point.dao.AccessoryInfoDao;
import cairh.community.api.point.dao.ChannelPointDao;
import cairh.community.api.point.dao.UserBindingInfoDao;
import cairh.community.api.point.dao.UserLevelDao;
import cairh.community.api.point.dao.UserPointDao;
import cairh.community.api.point.dao.UserPointLogDao;
import cairh.community.api.point.model.AccessoryInfo;
import cairh.community.api.point.model.AccessoryInfoResult;
import cairh.community.api.point.model.BaseResult;
import cairh.community.api.point.model.ChannelPoint;
import cairh.community.api.point.model.PointLogResult;
import cairh.community.api.point.model.PointLogResult.PointLog;
import cairh.community.api.point.model.PointModifyResult;
import cairh.community.api.point.model.PointResult;
import cairh.community.api.point.model.UserBindingInfo;
import cairh.community.api.point.model.UserPoint;
import cairh.community.api.point.model.UserPointLog;
import cairh.community.api.point.service.IAjPointService;
import cairh.community.api.point.util.DateUtil;
import cairh.community.api.point.util.Page;

/**
 * Created by 王振
 */
@Service
public class AjPointServiceImpl implements IAjPointService{
   
	@Autowired
	private UserPointDao userPointDao;
	@Autowired
	private UserPointLogDao userPointLogDao;
	@Autowired
	private UserBindingInfoDao userBindingInfoDao;
	@Autowired
	private ChannelPointDao channelPointDao;
	@Autowired
	private UserLevelDao userLevelDao;
	@Autowired
	private AccessoryInfoDao accessoryInfoDao;
	
	public PointResult getPoint(String accountValue,String accountType){
		PointResult result = new PointResult();
		try {
			UserBindingInfo userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
			//绑定用户
			if(userBindingInfo==null){
				UserBindingInfo bindingInfo = new UserBindingInfo();
				bindingInfo.setBindDate(new Date());
				bindingInfo.setAccountContent(accountValue);
				bindingInfo.setAccountType(accountType);
				userBindingInfoDao.save(bindingInfo);
			}
			userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
					
				UserPoint params = new UserPoint();
				params.setUserId(userBindingInfo.getUserId());
				UserPoint point = userPointDao.getByUserId((userBindingInfo.getUserId()));
				if (point == null) {
					point = new UserPoint();
					point.setUserId(userBindingInfo.getUserId());
					point.setTotalPoints(0L);
					point.setAvailablePoints(0L);
					point.setFrozenPoints(0L);
					point.setUsedPoints(0L);
					point.setStatus(StatusConstants.POINT_STATUS_ENABLE);
					point.setCreateTime(new Date());
					userPointDao.save(point);
				}
				if (point.getStatus() == StatusConstants.POINT_STATUS_DISABLE) {
					result.setError_no("-300002");
					result.setError_info("用户积分失效");
					return result;
				}
				result.setError_no(ErrorCode.OK);
				result.setTotalPoints(point.getTotalPoints());
				result.setAvailablePoints(point.getAvailablePoints());
				//星级
				result.setStarLevel(userLevelDao.getStart(point.getAvailablePoints()+point.getUsedPoints()).getStarLevel());
				result.setFrozenPoints(point.getFrozenPoints());
				result.setUsedPoints(point.getUsedPoints());
				return result;
		} catch (Exception e) {
			result.setError_no("-3");
			result.setError_info("查询积分异常");
			return result;
		}
	}


	public PointModifyResult doPoint(String code, String accountValue,
			String accountType) {
		UserBindingInfo userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		//绑定用户
		if(userBindingInfo==null){
			UserBindingInfo bindingInfo = new UserBindingInfo();
			bindingInfo.setBindDate(new Date());
			bindingInfo.setAccountContent(accountValue);
			bindingInfo.setAccountType(accountType);
			userBindingInfoDao.save(bindingInfo);
		}
		
		userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		
		PointModifyResult result = new PointModifyResult();
		try {
			
			if (StringUtils.isBlank(code)) {
				result.setError_no("-300101");
				result.setError_info("积分定义代码不能为空");
				return result;
			}

			Map<String, Object> parm = new HashMap<String, Object>();
			parm.put("channelCode", code);
			ChannelPoint pointDefine = channelPointDao.getBy(parm);
			if(pointDefine==null){
				result.setError_no("-300101");
				result.setError_info("积分定义不存在");
				return result;
			}
			if (pointDefine==null || pointDefine.getStatus().equals("2")) {
				result.setError_no("-300102");
				result.setError_info("积分定义已失效");
				return result;
			}
			//modify by stevinzhu@cairenhui.com 20161019 start
			// points ==0 可以自由加减积分数
			Long occurPoints = pointDefine.getPoints();
			
			return this.userPointsModify2(userBindingInfo.getUserId(), code, occurPoints, pointDefine.getName(),"4");
			
		} catch (Exception e) {
			result.setError_no("-3");
			result.setError_info("修改积分异常");
			return result;
		}
	}

	
	private PointModifyResult userPointsModify2(long userId, String code,
			Long occurPoints, String remark,String changeType) {
		PointModifyResult result = new PointModifyResult();
	    try {
	    	UserPoint uPoint = userPointDao.getByUserId(userId);
			if(uPoint==null){
				//新增用户积分
				uPoint = new UserPoint();
				uPoint.setUserId(userId);
				uPoint.setTotalPoints(0L);
				uPoint.setAvailablePoints(0L);
				uPoint.setFrozenPoints(0L);
				uPoint.setUsedPoints(0L);
				uPoint.setCreateTime(new Date());
				uPoint.setUpdateTime(new Date());
				uPoint.setStatus(StatusConstants.POINT_STATUS_ENABLE);
				userPointDao.save(uPoint);
			}
			
			if (uPoint.getStatus() == StatusConstants.POINT_STATUS_DISABLE) {
				result.setError_no("-300104");
				result.setError_info("用户积分已失效");
				return result;
			}
			
			Long usedPoints = 0L;
			if(occurPoints<0){
				usedPoints = Math.abs(occurPoints);
			}else{
				usedPoints = 0l;
			}
			
		    //add  by  stevinzhu@cairenhui.com  20161019  start 
		    //add  增加积分不足判断
		    long  avaiblePotins = uPoint.getAvailablePoints()==null ?0:uPoint.getAvailablePoints();
		    if(avaiblePotins + occurPoints <0 ){
		    	result.setError_no("-300105");
				result.setError_info("积分余额不足");
				return result;
		    }
		    //end
		    
			//更新积分
		    long afterPoints = 0;
			if (occurPoints != 0) {
				
				uPoint.setTotalPoints(uPoint.getTotalPoints() + occurPoints);
				uPoint.setAvailablePoints(uPoint.getAvailablePoints() + occurPoints);
				uPoint.setUsedPoints(uPoint.getUsedPoints() + usedPoints);
				uPoint.setUpdateTime(new Date());
				userPointDao.update(uPoint);
				//记录日志
				afterPoints = uPoint.getAvailablePoints();
				UserPointLog userPointLog = new UserPointLog();
				userPointLog.setUserId(userId);
				userPointLog.setCreateTime(new Date());
				userPointLog.setOccurPoints(occurPoints);
				userPointLog.setAfterPoints(afterPoints);
				userPointLog.setPointDefineCode(code);
				userPointLog.setChangeType(changeType);
				userPointLog.setRemark(remark);
				userPointLogDao.save(userPointLog);
				
			}
			result.setError_no(ErrorCode.OK);
			result.setOccurPoints(occurPoints);
			result.setTotalPoints(afterPoints);
			return result;
		} catch (Exception e) {
			result.setError_no("-3");
			result.setError_info("修改积分异常");
			return result;
		}
		
	}


	public PointLogResult userPointsLogQuery(String accountValue, String accountType,
			Date beginDate, Date endDate, Integer pageNo, Integer pageSize) {
		UserBindingInfo userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		//绑定用户
		if(userBindingInfo==null){
			UserBindingInfo bindingInfo = new UserBindingInfo();
			bindingInfo.setBindDate(new Date());
			bindingInfo.setAccountContent(accountValue);
			bindingInfo.setAccountType(accountType);
			userBindingInfoDao.save(bindingInfo);
		}
		
		userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		
		Long userId = userBindingInfo.getUserId();
		
		PointLogResult result = new PointLogResult();
		if (pageNo == null || pageNo <= 0) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = 999999;
		}
		try {
/*			UserPointLogExample example = new UserPointLogExample();
			UserPointLogExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			if (beginDate != null) {
				criteria.andCreateTimeGreaterThanOrEqualTo(beginDate);
			}
			if (endDate != null) {
				criteria.andCreateTimeLessThanOrEqualTo(endDate);
			}
			if(flag !=null && flag>0){
				criteria.andOccurPointsGreaterThan(0L);
			}
			if(flag !=null && flag<0){
				criteria.andOccurPointsLessThan(0L);
			}*/
			/*			example.setOrderByClause(" CREATE_TIME DESC ");
			example.setStartRow(start);
			example.setEndRow(end);*/
			Map<String, Object> params = new HashMap<String, Object>();
			int start = (pageNo - 1) * pageSize;
			int end = pageNo * pageSize + 1;
			params.put("userId",userId);
			if (beginDate != null) {
			params.put("beginDate",beginDate);
			}
			if (endDate != null) {
			params.put("endDate",endDate);
			}
			int count = this.countByExample(params);
			Page page = new Page(pageSize, pageNo, count);
			params.put("startRow",start);
			params.put("endRow",end);

			List<UserPointLog> userPointLogList = this.selectByExample(params);
			List<PointLog> dataList = new ArrayList<PointLog>();
			for (UserPointLog pLog : userPointLogList) {
				PointLog pl = new PointLog();
				pl.setOccurPoints(pLog.getOccurPoints());
				pl.setAfterPoints(pLog.getAfterPoints());
				pl.setPointDefineCode(pLog.getPointDefineCode());
				pl.setRemark(pLog.getRemark());
				pl.setCreateTime(DateUtil.format(pLog.getCreateTime(), DateUtil.DATE_TIME_FORMAT));
				dataList.add(pl);
			}
			
			UserPoint uPoint = userPointDao.getByUserId(userId);
			if(uPoint!=null){
				result.setAvailablePoints(uPoint.getAvailablePoints());
			}else{
				result.setAvailablePoints(0);
			}
			
			//是否是资金账号登录
			if(accountType.equals("1")){
				//0:是资金账号  1:不是
				result.setIfAccount("0");
			}else{
				result.setIfAccount("1");
				//是否绑定资金账号
				UserBindingInfo userBinding = userBindingInfoDao.ifBinDing(userId);
				if(userBinding==null){
					result.setFunAccountId(null);
				}else{
					result.setFunAccountId(userBinding.getAccountContent());
				}
			}
			
			result.setData(dataList);
			result.setPage(page);
			result.setError_no(ErrorCode.OK);
			return result;
		} catch (Exception e) {
			result.setError_no("-3");
			result.setError_info("查询积分日志异常");
			return result;
		}
	}
	
	
	public int countByExample(Map<String, Object> params){
		return userPointLogDao.countByExample(params);
	}
	
	public List<UserPointLog> selectByExample(Map<String, Object> params){
		return userPointLogDao.selectByExample(params);
	}


	@Override
	public BaseResult binding(String accountValue, String accountType,
			String accountValue2, String accountType2) {
		BaseResult baseResult = new BaseResult();
		try {
		UserBindingInfo userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		//绑定用户
		if(userBindingInfo==null){
			UserBindingInfo bindingInfo = new UserBindingInfo();
			bindingInfo.setBindDate(new Date());
			bindingInfo.setAccountContent(accountValue);
			bindingInfo.setAccountType(accountType);
			userBindingInfoDao.save(bindingInfo);
		}
		userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		
		UserBindingInfo userBindingInfo2 = userBindingInfoDao.getBy(accountValue2,accountType2);
		//绑定用户
		if(userBindingInfo2==null){
			UserBindingInfo bindingInfo2 = new UserBindingInfo();
			bindingInfo2.setBindDate(new Date());
			bindingInfo2.setAccountContent(accountValue2);
			bindingInfo2.setAccountType(accountType2);
			userBindingInfo2 = userBindingInfoDao.save(bindingInfo2);
		}
		userBindingInfo2 = userBindingInfoDao.getBy(accountValue2,accountType2);
		
		//判断资金账号有没有相关其他类型的已经绑定
		if(accountType.equals("1")){
			baseResult.setFunAccountId(accountValue);
			if(userBindingInfoDao.getCountByUserId(userBindingInfo.getUserId())>1){
				baseResult.setError_no("-2");
				baseResult.setError_info("此资金账号已经被绑定");
				return baseResult;
			};
		}else if(accountType2.equals("1")){
			baseResult.setFunAccountId(accountValue2);
			if(userBindingInfoDao.getCountByUserId(userBindingInfo2.getUserId())>1){
				baseResult.setError_no("-2");
				baseResult.setError_info("此资金账号已经被绑定");
				return baseResult;
			};
		}
		
		UserPoint userPoint = userPointDao.getByUserId(userBindingInfo.getUserId());
		UserPoint userPoint2 = userPointDao.getByUserId(userBindingInfo2.getUserId());
		
		if(userPoint==null&&userPoint2==null){
			//新增用户积分
			userPoint = new UserPoint();
			userPoint.setUserId(userBindingInfo.getUserId());
			userPoint.setTotalPoints(0L);
			userPoint.setAvailablePoints(0L);
			userPoint.setFrozenPoints(0L);
			userPoint.setUsedPoints(0L);
			userPoint.setCreateTime(new Date());
			userPoint.setUpdateTime(new Date());
			userPoint.setStatus(StatusConstants.POINT_STATUS_ENABLE);
			userPointDao.save(userPoint);
			userBindingInfo2.setUserId(userBindingInfo.getUserId());
			userBindingInfoDao.update(userBindingInfo2);
		}else if(userPoint!=null&&userPoint2==null){
			userBindingInfo2.setUserId(userBindingInfo.getUserId());
			userBindingInfoDao.update(userBindingInfo2);
		}else if(userPoint==null&&userPoint2!=null){
			userBindingInfo.setUserId(userBindingInfo2.getUserId());
			userBindingInfoDao.update(userBindingInfo);
		}else{
			userPoint.setAvailablePoints(userPoint.getAvailablePoints()+userPoint2.getAvailablePoints());
			userPoint.setFrozenPoints(userPoint.getFrozenPoints()+userPoint2.getFrozenPoints());
			userPoint.setTotalPoints(userPoint.getTotalPoints()+userPoint2.getTotalPoints());
			userPoint.setUsedPoints(userPoint.getUsedPoints()+userPoint2.getUsedPoints());
			userPointDao.update(userPoint);
			userPointDao.deleteById(userPoint2.getId());
			//userBindingInfo2.setUserId(userBindingInfo.getUserId());
			//userBindingInfoDao.update(userBindingInfo2);
			userBindingInfoDao.modifyUserId(userPoint2.getUserId(),userPoint.getUserId());
			//同步积分记录
			userPointLogDao.modifyUserId(userPoint2.getUserId(),userPoint.getUserId());
		}
			baseResult.setError_no(ErrorCode.OK);
			baseResult.setError_info("绑定成功");
			return baseResult;
		} catch (Exception e) {
			baseResult.setError_no("-3");
			baseResult.setError_info("信息绑定异常");
			return baseResult;
		}
	}


	@Override
	public PointModifyResult userPointsModify(Long change,
			String accountValue, String accountType, String remark) {
		UserBindingInfo userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		//绑定用户
		if(userBindingInfo==null){
			UserBindingInfo bindingInfo = new UserBindingInfo();
			bindingInfo.setBindDate(new Date());
			bindingInfo.setAccountContent(accountValue);
			bindingInfo.setAccountType(accountType);
			userBindingInfoDao.save(bindingInfo);
		}
		
		userBindingInfo = userBindingInfoDao.getBy(accountValue,accountType);
		
		return this.userPointsModify2(userBindingInfo.getUserId(), null, change, remark,"4");

	}


	@Override
	public AccessoryInfoResult accessAdd(String accessCode, String accesName) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer aesKey = new StringBuffer();     
	    StringBuffer md5Key = new StringBuffer();     
	    for (int i = 0; i < 16; i++) {     
	        int number = random.nextInt(base.length());     
	        aesKey.append(base.charAt(number));     
	    }     
		
	    for (int i = 0; i < 32; i++) {     
	        int number = random.nextInt(base.length());     
	        md5Key.append(base.charAt(number));     
	    }  
	    
	    AccessoryInfo accessoryInfo = new AccessoryInfo();
	    accessoryInfo.setAccesName(accesName);
	    accessoryInfo.setAccessCode(accessCode);
	    accessoryInfo.setAesKey(aesKey.toString());
	    accessoryInfo.setMd5Key(md5Key.toString());
	    accessoryInfo.setCreatTime(new Date());
	    accessoryInfo.setUpdateTime(new Date());
	    accessoryInfo.setStatus("0");
	    accessoryInfoDao.save(accessoryInfo);
	    
	    AccessoryInfoResult accessoryInfore = new AccessoryInfoResult();
	    accessoryInfore.setAccesName(accesName);
	    accessoryInfore.setAccessCode(accessCode);
	    accessoryInfore.setAesKey(aesKey.toString());
	    accessoryInfore.setMd5Key(md5Key.toString());
	    accessoryInfore.setError_info("");
	    accessoryInfore.setError_no(ErrorCode.OK);
	    
		return accessoryInfore;
	}


	@Override
	public BaseResult accessModify(String accessCode, String status) {
		BaseResult baseResult = new BaseResult();
		if(!status.equals("0")&&!status.equals("1")){
			baseResult.setError_no("-1");
			baseResult.setError_info("status参数错误");
			return baseResult;
		}
		accessoryInfoDao.updateByCode(accessCode,status);
		baseResult.setError_no(ErrorCode.OK);
		baseResult.setError_info("");
		return baseResult;
	}
	
}
