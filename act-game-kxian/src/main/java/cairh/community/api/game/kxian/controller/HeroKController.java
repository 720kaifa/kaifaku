package cairh.community.api.game.kxian.controller;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Tuple;
import cairh.community.api.game.kxian.bean.KLine;
import cairh.community.api.game.kxian.bean.KLineResult;
import cairh.community.api.game.kxian.common.ErrorCode;
import cairh.community.api.game.kxian.constants.GameConstants;
import cairh.community.api.game.kxian.dao.GameUserDao;
import cairh.community.api.game.kxian.dao.MaHistoryRankingDao;
import cairh.community.api.game.kxian.dao.MaTodayRankingDao;
import cairh.community.api.game.kxian.dao.MaUserinfoDao;
import cairh.community.api.game.kxian.dao.RevenueLogDao;
import cairh.community.api.game.kxian.dao.StockPoolDao;
import cairh.community.api.game.kxian.dao.UserRevenueDao;
import cairh.community.api.game.kxian.model.BaseResult;
import cairh.community.api.game.kxian.model.GameUser;
import cairh.community.api.game.kxian.model.MaHistoryRanking;
import cairh.community.api.game.kxian.model.MaTodayRanking;
import cairh.community.api.game.kxian.model.MaUserinfo;
import cairh.community.api.game.kxian.model.RevenueLog;
import cairh.community.api.game.kxian.model.RevenueLogResult;
import cairh.community.api.game.kxian.model.StockPool;
import cairh.community.api.game.kxian.model.UserRevenue;
import cairh.community.api.game.kxian.model.UserRevenueResult;
import cairh.community.api.game.kxian.service.IBaseService;
import cairh.community.api.game.kxian.service.IKLineService;
import cairh.community.api.game.kxian.util.DateUtil;
import cairh.community.api.game.kxian.util.Page;
import cairh.community.api.game.kxian.util.PwdUtil;
import cairh.community.api.game.kxian.util.RedisClientUtil;
import cairh.community.api.game.kxian.util.StringUtil;


@Controller
public class HeroKController{

	private Logger logger = Logger.getLogger(HeroKController.class);
	
	@Autowired
	private StockPoolDao stockPoolDao;
	@Autowired
	private RevenueLogDao revenueLogDao;
	@Autowired
	private UserRevenueDao userRevenueDao;
	@Autowired
	private IKLineService iKLineService;
	@Autowired
	private GameUserDao gameUserDao;
	@Autowired
	private MaTodayRankingDao maTodayRankingDao;
	@Autowired
	private MaHistoryRankingDao maHistoryRankingDao;
	@Autowired
	private IBaseService iBaseService;
	@Autowired
	private  MaUserinfoDao maUserinfoDao;
	/**
	 * 获取随机股票行情
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM2110")
	public Object quotationList(String mobileNo) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(mobileNo)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		mobileNo = PwdUtil.MobileEncode(mobileNo);
        
//		UserBase userBase = userBaseDao.getById(Long.parseLong(userId));
//		if(userBase==null){
//			baseResult.setError_no("-1");
//			baseResult.setError_info("用户不存在");
//			return baseResult;
//		}
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		int count = stockPoolDao.getCount();
		//生成随机数 1-count
		SecureRandom ra = new SecureRandom();
		int random = ra.nextInt(count) + 1;
		//获取随机股票代码
		StockPool stork = stockPoolDao.getByRow(random);
		
		logger.info("随机股票代码："+stork.getStockCode());
		
/*		random = ra.nextInt(50) + 1;
*/		//随机获取60天股票行情
		KLineResult k = iKLineService.requestKLineList(stork.getStockCode(),6,0,80);
		List<KLine> list = k.getData();
		
		if(list.size()!=0){
			//保存游戏开始相关数据
			RedisClientUtil.set(userId+"START_TIME", list.get(39).getCommonTime().toString());
			RedisClientUtil.set(userId+"STORK_CODE", stork.getStockCode());
			RedisClientUtil.set(userId+"STORK_NAME", stork.getStockName());
			RedisClientUtil.set(userId+"START_PRICE", String.valueOf(new BigDecimal(list.get(39).getGoodsPriceLast()).divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP)));
			RedisClientUtil.del(userId+"BUY_STORK");
			RedisClientUtil.del(userId+"REVENUE_RATE");
			RedisClientUtil.del(userId+"REVENUE_RATE1");
			k.setError_no("0");
			return k;
		}else{
			baseResult.setError_no("-1");
			baseResult.setError_info("获取行情失败");
			return baseResult;
		}
		
	}

	/**
	 * K线英雄 买入操作
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM2111")
	public Object buyStork(String mobileNo,String buyPrice) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(mobileNo) || StringUtils.isBlank(buyPrice)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
        mobileNo = PwdUtil.MobileEncode(mobileNo);

//		UserBase userBase = userBaseDao.getById(Long.parseLong(userId));
//		if(userBase==null){
//			baseResult.setError_no("-1");
//			baseResult.setError_info("用户不存在");
//			return baseResult;
//		}
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		//保存买入价格
		RedisClientUtil.set(userId+"BUY_STORK", buyPrice);
		baseResult.setError_no(ErrorCode.OK);
		baseResult.setError_info("买入成功");
		return baseResult;
	}

	/**
	 * K线英雄 持仓或者卖出操作
	 * type:  0持股 1卖出
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM2112")
	public Object positionOrSelling(String mobileNo,String sellPrice,String type) throws Exception {
		BaseResult baseResult = new BaseResult();
//		UserBase userBase = userBaseDao.getById(Long.parseLong(userId));
//		if(userBase==null){
//			baseResult.setError_no("-1");
//			baseResult.setError_info("用户不存在");
//			return baseResult;
//		}
		
		if(StringUtils.isBlank(mobileNo)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
        mobileNo = PwdUtil.MobileEncode(mobileNo);
        
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		if(StringUtil.isBlank(RedisClientUtil.get(userId+"BUY_STORK"))){
			baseResult.setError_no("-1");
			baseResult.setError_info("请先进行买入操作");
			return baseResult;
		}
		RevenueLogResult re = new RevenueLogResult();
		
		
		//计算区间收益率
		if(StringUtil.isBlank(sellPrice)){
			sellPrice= "0";
		}
		BigDecimal sell =new BigDecimal(sellPrice);
		BigDecimal buy =new BigDecimal(RedisClientUtil.get(userId+"BUY_STORK"));
		BigDecimal revenueRate = ((sell.subtract(buy)).divide(buy,4,BigDecimal.ROUND_HALF_UP));
		BigDecimal chicang = revenueRate;
/*		//保存持仓收益率
		RedisClientUtil.set(userId+"REVENUE_RATE2", chicang.setScale(4,BigDecimal.ROUND_HALF_UP).toString());*/
		//卖出操作
		if(type.equals("1")){
			revenueRate = new BigDecimal(RedisClientUtil.get(userId+"REVENUE_RATE1"));
			re.setRevenueRatePer(StringUtil.percent(revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP)));
			re.setRevenueRateNow(StringUtil.percent(0));
			//保存区间收益率
			RedisClientUtil.set(userId+"REVENUE_RATE", revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP).toString());
			
			RedisClientUtil.del(userId+"BUY_STORK");
			/*RedisClientUtil.del(userId+"REVENUE_RATE2");*/
			re.setError_no("0");
			return re;
		}
		if(StringUtil.isNotBlank(RedisClientUtil.get(userId+"REVENUE_RATE"))){
			BigDecimal revenueRate2 = new BigDecimal(RedisClientUtil.get(userId+"REVENUE_RATE"));
			revenueRate = (((revenueRate.add(new BigDecimal(1))).multiply
					(revenueRate2.add(new BigDecimal(1)))).subtract(new BigDecimal(1)));
		}
		
		//保存临时收益率
		RedisClientUtil.set(userId+"REVENUE_RATE1", revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP).toString());

		re.setRevenueRatePer(StringUtil.percent(revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP)));
		re.setRevenueRateNow(StringUtil.percent(chicang.setScale(4,BigDecimal.ROUND_HALF_UP)));
		re.setError_no("0");
		return re;
	}
	
	/**
	 * K线英雄 游戏结束操作
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM2113")
	public Object gameOver(String mobileNo,String endTime,String endPrice) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(mobileNo)||StringUtils.isBlank(endTime)
				||StringUtils.isBlank(endPrice)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
        mobileNo = PwdUtil.MobileEncode(mobileNo);

//		UserBase userBase = userBaseDao.getById(Long.parseLong(userId));
//		if(userBase==null){
//			baseResult.setError_no("-1");
//			baseResult.setError_info("用户不存在");
//			return baseResult;
//		}
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		String startTime = RedisClientUtil.get(userId+"START_TIME");
		String storkCode = RedisClientUtil.get(userId+"STORK_CODE");
		String storkName = RedisClientUtil.get(userId+"STORK_NAME");
		String startPrice = RedisClientUtil.get(userId+"START_PRICE");
		
		BigDecimal revenueRate;
		try {
			if(StringUtil.isBlank(RedisClientUtil.get(userId+"REVENUE_RATE"))){
				/*//计算区间收益率
				BigDecimal sell =new BigDecimal(sellPrice);
				BigDecimal buy =new BigDecimal(RedisClientUtil.get(userId+"BUY_STORK"));
				revenueRate = ((sell.subtract(buy)).divide(buy,4,BigDecimal.ROUND_HALF_UP));
				if(StringUtil.isNotBlank(RedisClientUtil.get(userId+"REVENUE_RATE"))){
					BigDecimal revenueRate2 = new BigDecimal(RedisClientUtil.get(userId+"REVENUE_RATE"));
					revenueRate = ((revenueRate.add(new BigDecimal("1"))).multiply
							(revenueRate2.add(new BigDecimal("1")))).subtract(new BigDecimal("1"));
				}*/
				//没有卖出过
				if(StringUtil.isBlank(RedisClientUtil.get(userId+"REVENUE_RATE1"))){
				revenueRate = new BigDecimal("0");
				}else{
				revenueRate = new BigDecimal(RedisClientUtil.get(userId+"REVENUE_RATE1"));
				}
			}else{
				revenueRate = new BigDecimal(RedisClientUtil.get(userId+"REVENUE_RATE"));
			}
		} catch (Exception e) {
			baseResult.setError_no("-1");
			baseResult.setError_info("操作异常");
			return baseResult;
		}
		//涨跌率
		BigDecimal navRatio = (new BigDecimal(endPrice).subtract(new BigDecimal(startPrice))).divide(new BigDecimal(startPrice),4,BigDecimal.ROUND_HALF_UP);
		
		//加到log表
		RevenueLog revenueLog = new RevenueLog();
		revenueLog.setNavRatio(navRatio);
		revenueLog.setRevenueRate(revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP));
		logger.info(startTime+"------------------"+endTime);
		revenueLog.setStartTime(DateUtil.parse(startTime,DateUtil.DATE_FORMAT_NO_DELIMITER));
		revenueLog.setEndTime(DateUtil.parse(endTime,DateUtil.DATE_FORMAT_NO_DELIMITER));
		revenueLog.setStockCode(storkCode);
		revenueLog.setStockName(storkName);
		revenueLog.setUserId(userId);
		revenueLog.setCreateTime(new Date());
		revenueLogDao.saveOrUpdate(revenueLog);
		
		//击败多少的股民
		double count1 = (double)revenueLogDao.getCountByCode(storkCode);
		double count2 = (double)revenueLogDao.getCountLessRe(storkCode, revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP));
		
		//用户总收益表
		UserRevenue userRevenue = userRevenueDao.getById(userId);
		if(null==userRevenue){
			UserRevenue newUserRevenue = new UserRevenue();
			newUserRevenue.setUserId(userId);
		//	newUserRevenue.setRanking(1);
			newUserRevenue.setNikeName(map.get("name").toString());//涉及用户信息数据暂时写死,以后要改 
			newUserRevenue.setTotalRevenueRate(revenueRate.setScale(4,BigDecimal.ROUND_HALF_UP));
			userRevenueDao.save(newUserRevenue);
		}else{
			userRevenue.setTotalRevenueRate(((userRevenue.getTotalRevenueRate()).add(new BigDecimal("1")).multiply(revenueRate.add(new BigDecimal("1")))).subtract(new BigDecimal("1")));
			userRevenueDao.update(userRevenue);
		}
		
		//今日排行榜
		MaTodayRanking ma = maTodayRankingDao.getById(userId);
		Date date = new Date();
		int intTime = DateUtil.getStringDate(date, DateUtil.DATE_FORMAT_NO_DELIMITER);
		if(ma==null){
			ma = new MaTodayRanking();
			ma.setDatetime(intTime);
			ma.setRate(revenueLog.getRevenueRate());
			ma.setUserId(userId);
			maTodayRankingDao.save(ma);
			//数据库和缓存都存 之后可能除去数据库操作
			RedisClientUtil.zaddList("today_rank"+intTime, revenueLog.getRevenueRate().doubleValue(), userId.toString());
		}else{
			ma.setDatetime(intTime);
			ma.setRate(((ma.getRate()).add(new BigDecimal("1")).multiply(revenueRate.add(new BigDecimal("1")))).subtract(new BigDecimal("1")));
			ma.setUserId(userId);
			maTodayRankingDao.update(ma);
			//数据库和缓存都存 之后可能除去数据库操作
			RedisClientUtil.zaddList("today_rank"+intTime, ma.getRate().doubleValue(), userId.toString());
		}
		
		//游戏玩过几次
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date cur = new  Date();
		GameUser gameUser = new GameUser();
		gameUser.setAccountId(userId);
		gameUser.setGameId(GameConstants.GAME_KHERO);
		List<GameUser> gameUsers = gameUserDao.getByProperties(gameUser);
		if(gameUsers.size()>0){
			Date lastPlayTime = gameUsers.get(0).getLastPlayTime()==null?DateUtil.parse("19700101", "yyyyMMdd"):gameUsers.get(0).getLastPlayTime();
			if(!formatter.format(cur).equals(formatter.format(lastPlayTime))){
				//今天没有玩过（定时器暂时没有写 ）
				gameUsers.get(0).setTodayCount(0l);
			}
			gameUsers.get(0).setCount(gameUsers.get(0).getCount()+1L);
			gameUsers.get(0).setLastPlayTime(new Date());
			gameUsers.get(0).setTodayCount((gameUsers.get(0).getTodayCount()==null?0L:gameUsers.get(0).getTodayCount())+1L);
			gameUserDao.update(gameUsers.get(0));
		}else{
			gameUser.setCount(1L);
			gameUser.setLastPlayTime(new Date());
			gameUserDao.save(gameUser);	
		}
		
		RevenueLogResult re = new RevenueLogResult();
		re.setRevenueLog(revenueLog);
		re.setNavRatioPer(StringUtil.percent(revenueLog.getNavRatio()));
		re.setRevenueRatePer(StringUtil.percent(revenueLog.getRevenueRate()));
		re.setProportion(StringUtil.percent(count2/count1));
		re.setError_no("0");
		return re;
	}
	
	
	/**
	 * K线英雄 总排行榜
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM2114")
	public Object rankingList(String mobileNo,@RequestParam(defaultValue = "10")int count) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(mobileNo)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}

        mobileNo = PwdUtil.MobileEncode(mobileNo);
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		List<UserRevenue> list = userRevenueDao.rankingList(count);
		int rank = 1;
		for (UserRevenue userRevenue : list) {
			userRevenue.setTotalRevenueRatePer(StringUtil.percent(userRevenue.getTotalRevenueRate()));
			userRevenue.setRanking(rank);
			rank++;
		}
		UserRevenue my = userRevenueDao.getRank(userId);
		
		UserRevenueResult urr = new UserRevenueResult();
		urr.setUserRevenue(my);
		urr.setData(list);
		urr.setError_no("0");
		return urr;
	}
	
	/**
	 * K线英雄 游戏记录列表
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("CRH-CM2115")
	public Object getLogList(String mobileNo,@RequestParam(defaultValue = "1")Integer pageNo,
			@RequestParam(defaultValue = "10")Integer pageSize) throws Exception {
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(mobileNo)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		int start = (pageNo - 1) * pageSize;
		int end = pageNo * pageSize + 1;
		
		mobileNo = PwdUtil.MobileEncode(mobileNo);
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		params.put("userId",userId);
		
		int count = revenueLogDao.countByExample(params);
		Page page = new Page(pageSize, pageNo, count);
		params.put("startRow",start);
		params.put("endRow",end);
		
		List<RevenueLog> list = revenueLogDao.getLogList(params);
		GameUser game = gameUserDao.getByAcc(userId,GameConstants.GAME_KHERO);

		for (RevenueLog revenueLog : list) {
			revenueLog.setNavRatioPer(StringUtil.percent(revenueLog.getNavRatio()));
			revenueLog.setRevenueRatePer(StringUtil.percent(revenueLog.getRevenueRate()));
		}
		
		RevenueLogResult revenueLogResult = new RevenueLogResult();

		revenueLogResult.setData(list);
		revenueLogResult.setPage(page);
		revenueLogResult.setError_no("0");
		revenueLogResult.setCount(game.getCount().intValue());
		//账户头像昵称手机号
		
		
		return revenueLogResult;
	}
	
	/**
	 * 是否第一次进游戏
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "CRH-CM2224")
	public Object ifFirstPlay(String mobileNo,Long gameId) throws Exception{
		
		BaseResult baseResult = new BaseResult();
		if(StringUtils.isBlank(mobileNo)){
			baseResult.setError_no("-1");
			baseResult.setError_info("参数不能为空");
			return baseResult;
		}

		mobileNo = PwdUtil.MobileEncode(mobileNo);
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
	
		Map<String, Object> resMap = new HashMap<String, Object>();
		GameUser gameUser = new GameUser();
		gameUser.setAccountId(userId);
		gameUser.setGameId(gameId);
		List<GameUser> gameUsers = gameUserDao.getByProperties(gameUser);
		
		MaUserinfo userInfo = new MaUserinfo();
		if(maUserinfoDao.getById(Long.parseLong(map.get("id").toString().trim()))==null){
			userInfo.setImage(map.get("iconId").toString());
			userInfo.setMobile(map.get("mobileNo").toString());
			userInfo.setNickName(map.get("name").toString());
			userInfo.setUserId(Long.parseLong(map.get("id").toString().trim()));
			maUserinfoDao.save(userInfo);
		}else{
			userInfo.setImage(map.get("iconId").toString());
			userInfo.setMobile(map.get("mobileNo").toString());
			userInfo.setNickName(map.get("name").toString());
			userInfo.setUserId(Long.parseLong(map.get("id").toString().trim()));
			maUserinfoDao.update(userInfo);
		}
		
		
		//进过此游戏
		if(gameUsers.size()==0){
			//第一次进游戏
			resMap.put("ifFirstPlay", 0);
			gameUser.setCount(0L);
			gameUserDao.save(gameUser);	
		}else{
			//不是第一次进游戏
			resMap.put("ifFirstPlay", 1);
		}
		
		//进行账户头像昵称手机号同步
		
		
		resMap.put("error_no", "0");
		return resMap;
	}
	
	/**
	 * 今日排行
	 * @author admin
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "CRH-CM5000")
	public Object todayRanking(String mobileNo) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		if(mobileNo==null){
			resMap.put("error_no", "0");
			resMap.put("error_info", "参数不能为空");
		}
		
		mobileNo = PwdUtil.MobileEncode(mobileNo);

		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		Date date = new Date();
		int intTime = DateUtil.getStringDate(date, DateUtil.DATE_FORMAT_NO_DELIMITER);
		
		Set<Tuple> list = RedisClientUtil.zRevrange("today_rank"+intTime, 0, -1);
		//List<MaTodayRanking> list = maTodayRankingDao.todayRanking(intTime);
		
		//只取前10名显示
		List<MaTodayRanking> list2 = new ArrayList<MaTodayRanking>();
		
		int rank=0;
		int myRank=0;
		BigDecimal rate = null;
		
		for (Tuple tuple : list) {
			/*String[] strings = tuple.split(",");*/
			MaTodayRanking maTodayRanking = new MaTodayRanking();
			
			if(!new BigDecimal(tuple.getScore()).equals(rate)){
				rank++;
			}
			rate = new BigDecimal(tuple.getScore());
			
			maTodayRanking.setRank(rank);
			maTodayRanking.setRatePer(StringUtil.percent(new BigDecimal(tuple.getScore())));
			maTodayRanking.setRate(new BigDecimal(tuple.getScore()));
			maTodayRanking.setNickName(maUserinfoDao.getById(Long.parseLong(tuple.getElement())).getNickName());
			if(Long.parseLong(tuple.getElement())==(userId)){
				myRank=rank;
			}
			
			if(rank<=10){
				list2.add(maTodayRanking);
			}
			
		}
		
/*		for (MaTodayRanking maTodayRanking : list) {
			maTodayRanking.setRank(rank);
			maTodayRanking.setRatePer(StringUtil.percent(maTodayRanking.getRate()));
			maTodayRanking.setNickName(maUserinfoDao.getById(maTodayRanking.getUserId()).getNickName());
			if(maTodayRanking.getUserId().equals(userId)){
				myRank=rank;
			}
			if(rank<=10){
				list2.add(maTodayRanking);
			}
			rank++;
		}*/
		MaTodayRanking my = maTodayRankingDao.getRank(userId,intTime);
		
		if(my!=null){
			my.setRank(myRank);
			my.setRatePer(StringUtil.percent(my.getRate()));
			my.setRate(my.getRate());
		}else{
			my = new MaTodayRanking();
			my.setRatePer("0%");
			my.setRank(myRank);
			my.setRate(new BigDecimal(0));
		}
		my.setNickName(maUserinfoDao.getById(userId).getNickName());

		resMap.put("error_no", "0");
		resMap.put("data", list2);
		resMap.put("my", my);
		return resMap;
	}
	
	/**
	 * 历史排行
	 * @author admin
	 * @param userId
	 * @param intTime
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "CRH-CM5001")
	public Object historyRanking(String mobileNo,Integer intTime) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		if(mobileNo==null){
			resMap.put("error_no", "0");
			resMap.put("error_info", "参数不能为空");
		}
		
		mobileNo = PwdUtil.MobileEncode(mobileNo);
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		List<MaHistoryRanking> list = maHistoryRankingDao.historyRanking(intTime);
		for (MaHistoryRanking maHistoryRanking : list) {
			maHistoryRanking.setNickName(maUserinfoDao.getById(maHistoryRanking.getUserId()).getNickName());
			maHistoryRanking.setRatePer(StringUtil.percent(maHistoryRanking.getRate()));
			maHistoryRanking.setRate(maHistoryRanking.getRate());
		}
		MaHistoryRanking my = maHistoryRankingDao.getRank(userId,intTime);
		if(my!=null){
			my.setNickName(maUserinfoDao.getById(userId).getNickName());
			my.setRatePer(StringUtil.percent(my.getRate()));
			my.setRate(my.getRate());
		}else{
			my = new MaHistoryRanking();
			my.setNickName(maUserinfoDao.getById(userId).getNickName());
			my.setRatePer("0%");
			my.setRank(0);
			my.setRate(new BigDecimal(0));
		}
		
		
		resMap.put("error_no", "0");
		resMap.put("data", list);
		resMap.put("my", my);
		return resMap;
	}
	
	/**
	 * 游戏个人信息
	 * @author admin
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "CRH-CM5002")
	public Object myGameInfo(String mobileNo) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		if(StringUtil.isBlank(mobileNo)){
			resMap.put("error_no", "0");
			resMap.put("error_info", "参数不能为空");
		}
		
		mobileNo = PwdUtil.MobileEncode(mobileNo);
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		UserRevenue revenue = userRevenueDao.getById(userId);
		if(revenue==null){
			revenue = new UserRevenue();
			revenue.setTotalRevenueRate(new BigDecimal(0));
		}
		
		int toalPoint = maHistoryRankingDao.getToalPoint(userId);
		
		Date date = new Date();
		int intTime = DateUtil.getStringDate(date, DateUtil.DATE_FORMAT_NO_DELIMITER);
/*		List<MaTodayRanking> list = maTodayRankingDao.todayRanking(intTime);
		int rank=1;
		int myRank=0;
		for (MaTodayRanking maTodayRanking : list) {
			maTodayRanking.setRank(rank);
			if(maTodayRanking.getUserId().equals(userId)){
				myRank=rank;
			}
			rank++;
		}*/
		
		Set<Tuple> list = RedisClientUtil.zRevrange("today_rank"+intTime, 0, -1);
		//List<MaTodayRanking> list = maTodayRankingDao.todayRanking(intTime);
		
		int rank=0;
		int myRank=0;
		BigDecimal rate = null;
		
		for (Tuple tuple : list) {
			
			if(!new BigDecimal(tuple.getScore()).equals(rate)){
				rank++;
			}
			rate = new BigDecimal(tuple.getScore());
			
			if(Long.parseLong(tuple.getElement())==(userId)){
				myRank=rank;
			}
			
		}
		
		
		MaTodayRanking my = maTodayRankingDao.getRank(userId,intTime);
		
		if(my!=null){
			my.setRank(myRank);
			my.setRatePer(StringUtil.percent(my.getRate()));
		}else{
			my = new MaTodayRanking();
			my.setRatePer("0%");
			my.setRank(myRank);
		}
		
		resMap.put("totalRevenueRate", StringUtil.percent(revenue.getTotalRevenueRate()));
		resMap.put("ranking", revenue.getRanking());
		resMap.put("toalPoint", toalPoint);
		resMap.put("myRank", my);
		resMap.put("userInfo", map);
		return resMap;
	}
	
	
	/**
	 * 我的游戏积分记录(每天游戏排行得到的积分)
	 * @author admin
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "CRH-CM5003")
	public Object myGamePointLog(String mobileNo,Integer pageNum, Integer pageSize) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		if(mobileNo==null){
			resMap.put("error_no", "0");
			resMap.put("error_info", "参数不能为空");
		}
		
		mobileNo = PwdUtil.MobileEncode(mobileNo);
		
		//个人信息
		Map<String, Object> map = iBaseService.queryUserInfo(mobileNo);
		Long userId = Long.parseLong(map.get("id").toString().trim());
		
		if (pageNum == null || pageNum <= 0) {
			pageNum = 1;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}
		int start = (pageNum - 1) * pageSize;
		int end = pageNum * pageSize + 1;
		
		int count  = maHistoryRankingDao.myGamePointCount(userId);
		Page page = new Page(pageSize, pageNum, count);
		
		List<MaHistoryRanking> list = maHistoryRankingDao.myGamePointLog(userId,start,end);
		
		resMap.put("error_no", "0");
		resMap.put("data", list);
		resMap.put("page", page);
		return resMap;
	}
	
	
}
