package cairh.community.api.game.kxian.service;

import org.springframework.stereotype.Service;


/**
 * 功能说明: 名次清算<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wz<br>
 */
@Service
public abstract class ITimingRankingService  {


	public abstract void updateList();

	public abstract void rankPoint();

	public abstract void deleteTodayRank();


	
}
