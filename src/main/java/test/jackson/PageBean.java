package test.jackson;

import java.util.List;

public class PageBean<T> {

	private Integer total;
	private Integer pageNum;

	private Integer pageSize;

	private List<T> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public PageBean() {
	}



	@Override
	public String toString() {
		return "PageBean{" +
				"total=" + total +
				", pageNumber=" + pageNum +
				", pageSize=" + pageSize +
				", rows=" + rows +
				'}';
	}
}
