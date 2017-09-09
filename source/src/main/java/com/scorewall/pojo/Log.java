package com.scorewall.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户操作记录entity
 */
@Table(name="u_log")
public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	// userId
	private Integer userId;
	
    // 用户操作
    private String operate;

    // 扩展字段
    private String operate2;

    // 创建时间
    private Date createAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getOperate2() {
		return operate2;
	}

	public void setOperate2(String operate2) {
		this.operate2 = operate2;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", userId=" + userId + ", operate=" + operate + ", operate2=" + operate2 + ", createAt=" + createAt + "]";
	}

}
