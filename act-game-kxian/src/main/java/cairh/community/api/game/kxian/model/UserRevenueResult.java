package cairh.community.api.game.kxian.model;

import java.util.List;

/**
 * Created by luyj on 2016/9/22.
 */
public class UserRevenueResult extends BaseResult{
    private List<UserRevenue> data;
    private UserRevenue userRevenue;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

	public List<UserRevenue> getData() {
		return data;
	}

	public void setData(List<UserRevenue> data) {
		this.data = data;
	}

	
	public UserRevenue getUserRevenue() {
		return userRevenue;
	}

	
	public void setUserRevenue(UserRevenue userRevenue) {
		this.userRevenue = userRevenue;
	}

}
