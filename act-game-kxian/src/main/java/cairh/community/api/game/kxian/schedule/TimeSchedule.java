package cairh.community.api.game.kxian.schedule;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.service.ITimingRankingService;

@Component
public class TimeSchedule {
	private static final Logger logger = Logger.getLogger(TimeSchedule.class);

	@Autowired
	private ITimingRankingService iTimingRankingService;
	
	public void delay(){
		logger.info("名次清算开始");
		iTimingRankingService.updateList();
	}

	
	public void rankPoint(){
		logger.info("K线排行奖励积分清算开始");
		iTimingRankingService.rankPoint();
	}
	
	public void deleteTodayRank(){
		logger.info("K线今日排行删除开始");
		iTimingRankingService.deleteTodayRank();
	}
	
}
