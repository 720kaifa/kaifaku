package cairh.community.api.point.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {
	
	/**
	 * 数据按页码，每页数量取数据
	 * @author dell
	 * @param resultList
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public static Map<String, Object> getCurrentResult(List<Map<String, Object>> resultList, int currentPage, int pageSize){
		int totalPage = 0;
		int totalCount = 0;
		Map<String, Object> resMap = new HashMap<String, Object>();
		if(resultList != null) {
			totalCount = resultList.size();
			// 分页
			totalPage = resultList.size() % pageSize == 0 ? resultList.size() / pageSize : resultList.size() / pageSize + 1;
			if (currentPage > totalPage) {
				currentPage = totalPage;
			}
			if (currentPage < 1) {
				currentPage = 1;
			}
			int start = (currentPage - 1) * pageSize;
			int end = currentPage * pageSize;
			if (end > resultList.size()) {
				end = resultList.size();
			}
			resultList = resultList.subList(start, end);
			Paginator paginator = new Paginator(currentPage, pageSize, totalCount);
			resMap.put("currentPage", currentPage);
			resMap.put("totalPage", totalPage);
			resMap.put("totalCount", totalCount);
			resMap.put("list", resultList);
			resMap.put("paginator", paginator);
		}
		return resMap;
	}
	

}
