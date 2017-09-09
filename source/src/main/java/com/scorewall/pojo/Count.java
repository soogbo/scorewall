package com.scorewall.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 统计entity
 */
@Table(name="u_count")
public class Count implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	// num_user_new
	private Integer numUserNew;
	
    // num_user_ufather
    private Integer numUserUfather;

    // num_task
    private Integer numTask;

    // 当天收入
    private Double money;

    // num_user_new_task
    private Integer numUserNewTask;
    
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

	public Integer getNumUserNew() {
		return numUserNew;
	}

	public void setNumUserNew(Integer numUserNew) {
		this.numUserNew = numUserNew;
	}

	public Integer getNumUserUfather() {
		return numUserUfather;
	}

	public void setNumUserUfather(Integer numUserUfather) {
		this.numUserUfather = numUserUfather;
	}

	public Integer getNumTask() {
		return numTask;
	}

	public void setNumTask(Integer numTask) {
		this.numTask = numTask;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getNumUserNewTask() {
		return numUserNewTask;
	}

	public void setNumUserNewTask(Integer numUserNewTask) {
		this.numUserNewTask = numUserNewTask;
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
		return "Count [id=" + id + ", numUserNew=" + numUserNew + ", numUserUfather=" + numUserUfather + ", numTask=" + numTask + ", money=" + money
				+ ", numUserNewTask=" + numUserNewTask + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

}
