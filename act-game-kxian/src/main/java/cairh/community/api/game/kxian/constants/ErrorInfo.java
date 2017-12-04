package cairh.community.api.game.kxian.constants;

import java.util.HashMap;
import java.util.Map;
/**
 * 功能说明: 社区错误信息<br>
 * <pre>
 *     社区错误编号号段为：<br>
 * </pre>
 * 系统版本: v1.0<br>
 * 开发人员: @author dell<br>
 * 开发时间: 2016年11月10日<br>
 */
public enum ErrorInfo {

	LOGIN_BRANCH_NOTFOUND("170000","登录失败，客户关联网点信息获取异常！"),

	SYSTEM_ERR("9999","系统异常，请稍后再试！");

	private String error_no;
	private String error_info;

	ErrorInfo(String error_no, String error_info) {
		this.error_no = error_no;
		this.error_info = error_info;
	}

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
}