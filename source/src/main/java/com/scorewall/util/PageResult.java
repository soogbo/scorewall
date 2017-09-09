package com.scorewall.util;
/**
 * 定义返回页面通用结果
 * @author shi
 * @version 1.0
 * @date 2017年5月9日
 */
public class PageResult {
	//状态码
	private Integer status;
	//返回页面数据
	private Object data;
	
	//空参构造
	public PageResult() {
		super();
	}
	//状态码status构造
	public PageResult(Integer status) {
		super();
		this.status = status;
	}
	//全参构造
	public PageResult(Integer status, Object data) {
		this(status);
		this.data = data;
	}
	
	//提供静态成功状态的方法
	public static PageResult ok(){
		return new PageResult(200);
	}
	//提供静态成功状态的含参方法
	public static PageResult ok(Object data){
		return new PageResult(200,data);
	}
	//提供静态失败状态的方法
	public static PageResult error(){
		return new PageResult(500);
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
