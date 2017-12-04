package cairh.community.api.game.kxian.bean;


import cairh.community.api.game.kxian.util.FastJsonUtil;
import cairh.community.api.game.kxian.util.MapUtil;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 功能说明: 中台服务结果集<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author kongdy<br>
 * 开发时间: 2015年7月17日<br>
 */
public class SisapResult implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(SisapResult.class);

	public static final String SUCCESS = "0";
	private String error_no;
	private String error_info;
	private Map<String, Object> resultMap;// 用于非结果集返回
	private List<Map<String, Object>> resultList;// 用于结果集返回

	public SisapResult() {
		resultMap = new HashMap<String, Object>();
		resultList = new ArrayList<Map<String, Object>>();
	}

	public SisapResult(String error_no, String error_info) {
		this.error_no = error_no;
		this.error_info = error_info;
		resultMap = new HashMap<String, Object>();
		resultList = new ArrayList<Map<String, Object>>();
	}

	public SisapResult(String error_no, String error_info, Map<String, Object> resultMap, List<Map<String, Object>> resultList) {
		this.error_no = error_no;
		this.error_info = error_info;
		this.resultMap = resultMap != null ? resultMap : new HashMap<String, Object>();
		this.resultList = resultList != null ? resultList : new ArrayList<Map<String, Object>>();
	}

	/**
	 * 解析json格式的结果串为对象
	 * @param jsonStr
	 */
	public SisapResult(String jsonStr) {
		JSONObject json = JSONObject.parseObject(jsonStr);
		this.setError_no(json.getString("error_no"));
		this.setError_info(json.getString("error_info"));
		resultList = new ArrayList<Map<String, Object>>();
		if (json.containsKey("resultList") && StringUtils.isNoneBlank(json.getString("resultList"))) {
			this.setResultList(FastJsonUtil.parseObject(json.getString("resultList"), resultList.getClass()));
		}
		resultMap = new HashMap<String, Object>();
		if (json.containsKey("resultMap") && StringUtils.isNoneBlank(json.getString("resultMap"))) {
			this.setResultMap(FastJsonUtil.parseObject(json.getString("resultMap"), resultMap.getClass()));
		}
		String[] headers = new String[] {"error_no", "error_info", "resultList", "resultMap"};
		for (Entry<String, Object> entry : json.entrySet()) {
			if (!ArrayUtils.contains(headers, entry.getKey())) {
				resultMap.put(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
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

	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}

	public boolean isSuccess() {
		return StringUtils.equals(error_no, "0");
	}

	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * 以指定对象形式获取单条数据，结果集返回时优先取结果集数据，非结果集返回时取平行数据
	 * @param clazz
	 * @return
	 */
	public <T> T getData(Class<T> clazz) {
		Map<String, Object> dataMap = null;
		if (resultList != null && resultList.size() > 0) {
			dataMap = resultList.get(0);
		} else if (resultMap != null && !resultMap.isEmpty()) {
			dataMap = resultMap;
		}
		if (dataMap != null && !dataMap.isEmpty()) {
			try {
				return MapUtil.mapToBean(dataMap, clazz);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	/**
	 * 以指定对象形式获取结果集数据，适用于结果集返回
	 * @param clazz
	 * @return
	 */
	public <T> List<T> getResultList(Class<T> clazz) {
		if (isSuccess()) {
			List<T> resultList = new ArrayList<T>();
			if (getResultList() != null && getResultList().size() > 0) {
				for (Map<String, Object> map : getResultList()) {
					try {
						resultList.add(MapUtil.mapToBean(map, clazz));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return resultList;
		} else {
			return null;
		}
	}
}
