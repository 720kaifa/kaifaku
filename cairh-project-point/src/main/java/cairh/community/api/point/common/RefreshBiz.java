package cairh.community.api.point.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public enum RefreshBiz {
	
	BIZ_SYS_CONFIG("SYS_CONFIG", 60),
	BIZ_SMS("SMS", 15*60),
	BIZ_ORG("ORG", 24*60*60),
	BIZ_DIC("DIC", 24*60*60),
	BIZ_MENU("MENU", 24*60*60);
	
    private String bizCode;
    private int refreshTerm;

    
    public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public int getRefreshTerm() {
		return refreshTerm;
	}

	public void setRefreshTerm(int refreshTerm) {
		this.refreshTerm = refreshTerm;
	}

	private RefreshBiz(String bizCode, int refreshTerm) {
		this.bizCode = bizCode;
		this.refreshTerm = refreshTerm;
	}

	public static Map<String, Integer> getMap() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (RefreshBiz item : RefreshBiz.values()) {
            map.put(item.getBizCode(), item.getRefreshTerm());
        }
        return map;
    }

	public static List<RefreshBiz> getList() {
        List<RefreshBiz> stateList = new ArrayList<RefreshBiz>();
        for (RefreshBiz item : RefreshBiz.values()) {
            stateList.add(item);
        }
        return stateList;
    }
	
}
