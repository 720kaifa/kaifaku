package cairh.community.api.point.util;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wanghh<br>
 * 开发时间: 2015年12月23日<br>
 */
public class Page {

	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int DEFAULT_PAGE_NO = 1;
	public static final int MAX_PAGE_SIZE = 200;

	private int pageSize;		// 分页大小
	private int pageNo;		    // 当前页数
	private int totalItems;		// 总记录数
	private int totalPages;     // 总页数

	public Page() {
	}

	public Page(int pageSize, int pageNo, int totalItems) {
		if (pageSize <= 0 || pageSize > MAX_PAGE_SIZE) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		if (pageNo <= 0) {
			pageNo = DEFAULT_PAGE_NO;
		}

		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalItems = totalItems;

		if (totalItems > 0 && pageSize > 0) {
			int count = totalItems / pageSize;
			if (totalItems % pageSize > 0) {
				count++;
			}
			totalPages = count;
		} else {
			totalPages = 0;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
