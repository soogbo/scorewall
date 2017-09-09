package com.scorewall.util;

import java.util.List;

/**
 * 保存分页查询信息：总条数total，查询页数据list
 * @param <T>
 */
public class DataGridResult<T> {
	
	private Long total;
	private List<T> rows;
	
	public DataGridResult(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
	
	
}
