package cairh.community.api.game.kxian.bean;

import java.util.List;

import cairh.community.api.game.kxian.model.BaseResult;

/**
 * Created by luyj on 2016/9/22.
 */
public class KLineCountResult extends BaseResult{
    private List<KLineCount> data;
	private String error_no;
	private String error_info;
	
	public String getError_no() {
		return error_no;
	}

	public void setError_no(String error_no) {
		this.error_no = error_no;
	}

	public String getError_info() {
		return error_info;
	}

	public void setError_info(String error_info) {
		this.error_info = error_info;
	}


	public List<KLineCount> getData() {
		return data;
	}

	public void setData(List<KLineCount> data) {
		this.data = data;
	}


	private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
