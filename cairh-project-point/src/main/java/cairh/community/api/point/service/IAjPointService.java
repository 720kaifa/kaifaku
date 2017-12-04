package cairh.community.api.point.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cairh.community.api.point.model.AccessoryInfo;
import cairh.community.api.point.model.AccessoryInfoResult;
import cairh.community.api.point.model.BaseResult;
import cairh.community.api.point.model.PointLogResult;
import cairh.community.api.point.model.PointModifyResult;
import cairh.community.api.point.model.PointResult;


/**
 * Created by duanxq on 2016/11/16.
 */
@Service
public interface IAjPointService {

	PointResult getPoint(String accountValue,String accountType);

	PointModifyResult doPoint(String channelCode, String accountValue, String accountType);

	PointLogResult userPointsLogQuery(String accountValue, String accountType,  Date begin, Date end,
			Integer pageNum, Integer pageSize);

	BaseResult binding(String accountValue, String accountType,
			String accountValue2, String accountType2);

	PointModifyResult userPointsModify(Long change, String accountValue,
			String accountType, String remark);

	AccessoryInfoResult accessAdd(String accessCode, String accesName);

	BaseResult accessModify(String accessCode, String status);



}
