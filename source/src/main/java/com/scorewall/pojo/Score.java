package com.scorewall.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 积分entity
 */
@Table(name="u_score")
public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	// user_id
	private Integer userId;
	
    // task_score
    private Integer taskScore;

    // task_channel
    private String taskChannel;

    // task_des
    private String taskDes;

    // task_pack_name
    private String taskPackName;
    
    // money
    private Double money;
    
    // only_flag
    private String onlyFlag;
    
    // 创建时间
    private Date createAt;

    // 更新时间
    private Date updateAt;

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

	public Integer getTaskScore() {
		return taskScore;
	}

	public void setTaskScore(Integer taskScore) {
		this.taskScore = taskScore;
	}

	public String getTaskChannel() {
		return taskChannel;
	}

	public void setTaskChannel(String taskChannel) {
		this.taskChannel = taskChannel;
	}

	public String getTaskDes() {
		return taskDes;
	}

	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}

	public String getTaskPackName() {
		return taskPackName;
	}

	public void setTaskPackName(String taskPackName) {
		this.taskPackName = taskPackName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getOnlyFlag() {
		return onlyFlag;
	}

	public void setOnlyFlag(String onlyFlag) {
		this.onlyFlag = onlyFlag;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", userId=" + userId + ", taskScore=" + taskScore + ", taskChannel=" + taskChannel + ", taskDes=" + taskDes
				+ ", taskPackName=" + taskPackName + ", money=" + money + ", onlyFlag=" + onlyFlag + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

}
