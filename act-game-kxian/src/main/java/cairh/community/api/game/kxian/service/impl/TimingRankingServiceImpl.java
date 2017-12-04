package cairh.community.api.game.kxian.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cairh.community.api.game.kxian.dao.MaHistoryRankingDao;
import cairh.community.api.game.kxian.dao.MaTodayRankingDao;
import cairh.community.api.game.kxian.dao.MaUserinfoDao;
import cairh.community.api.game.kxian.dao.UserRevenueDao;
import cairh.community.api.game.kxian.model.MaHistoryRanking;
import cairh.community.api.game.kxian.model.MaTodayRanking;
import cairh.community.api.game.kxian.model.MaUserinfo;
import cairh.community.api.game.kxian.model.UserRevenue;
import cairh.community.api.game.kxian.service.IBaseService;
import cairh.community.api.game.kxian.service.ITimingRankingService;
import cairh.community.api.game.kxian.util.DateUtil;
import cairh.community.api.game.kxian.util.RedisClientUtil;

import com.ibm.icu.util.Calendar;



/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyx<br>
 * 开发时间: 2016年8月9日<br>
 */
@Service
public class TimingRankingServiceImpl extends ITimingRankingService {

	@Autowired
	private UserRevenueDao userRevenueDao;
//    @Autowired
//  	private UserBaseDao userBaseDao;
	@Autowired
	private MaTodayRankingDao maTodayRankingDao;
	@Autowired
	private MaHistoryRankingDao maHistoryRankingDao;
	@Autowired
	private MaUserinfoDao maUserinfoDao;
	@Autowired
	private IBaseService iBaseService;
	
	private static Logger logger = LoggerFactory.getLogger(TimingRankingServiceImpl.class);

	@Override
	public void updateList() {
		List<UserRevenue> userRevenues =  userRevenueDao.getList();
		if(userRevenues.size()!=0){
			Integer ranking = 1;
			for (UserRevenue userRevenue : userRevenues) {
				//UserBase userBase = userBaseDao.getById(userRevenue.getUserId());
				userRevenue.setRanking(ranking);
				//个人信息
				MaUserinfo maUserinfo = maUserinfoDao.getById(userRevenue.getUserId());
				if(maUserinfo!=null){
					userRevenue.setNikeName(maUserinfo.getNickName());
				}else{
					userRevenue.setNikeName("游戏用户"+userRevenue.getUserId());
				}
				ranking++;
				userRevenueDao.update(userRevenue);
			}
			
	//		userRevenueDao.updateList(userRevenues);
		}
		
	}

	@Override
	public void rankPoint() {
		Calendar cal=Calendar.getInstance();
		//System.out.println(Calendar.DATE);//5
		cal.add(Calendar.DATE,-1);
		Date date=cal.getTime();
		int intTime = DateUtil.getStringDate(date, DateUtil.DATE_FORMAT_NO_DELIMITER);
		
		List<MaTodayRanking> list = maTodayRankingDao.todayAll(intTime);
		if(list.size()!=0){
			Integer ranking = 0;
			BigDecimal rate = null;
			MaHistoryRanking ma = new MaHistoryRanking();
			for (MaTodayRanking maTodayRanking : list) {
				if(maTodayRanking.getRate()!=rate){
					ranking++;
				}
				ma.setDatetime(intTime);
				ma.setRank(ranking);
				ma.setRate(maTodayRanking.getRate());
				ma.setUserId(maTodayRanking.getUserId());
/*				if(ranking<=10){
					ma.setPrizePoint(50);
					//积分处理操作
					Map<String, Object> map = iBaseService.pointProc
							(maUserinfoDao.getById(maTodayRanking.getUserId()).getMobile()
							, "1", "1");
					if(("0").equals(map.get("error_no").toString())){
						maHistoryRankingDao.save(ma);
						maTodayRankingDao.deleteById(maTodayRanking.getUserId());
					}
					logger.info(map.toString());
				}else{
					ma.setPrizePoint(0);*/
					maHistoryRankingDao.save(ma);
					maTodayRankingDao.deleteById(maTodayRanking.getUserId());
/*				}*/
				rate = maTodayRanking.getRate();
			}
		}

	}

	@Override
	public void deleteTodayRank() {
		Calendar calendar = Calendar.getInstance();//当前时间
    	calendar.add(Calendar.DATE, -1);//前1分钟
    	
		int intTime = DateUtil.getStringDate(calendar.getTime(), DateUtil.DATE_FORMAT_NO_DELIMITER);
		
		RedisClientUtil.del("today_rank"+intTime);
	}

	
}
