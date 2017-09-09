package com.scorewall.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户entity
 */
@Table(name="u_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	// 邀请人id
	private Integer parentId;
	
    // 用户名
    private String username;

    // 密码
    private String password;

    // 手机号
    private Integer telephone;

    // imei
    private String imei;

    // user_mac
    private String userMac;

    // total总积分
    private Integer scoreTotal;
    
    // 可用积分
    private Integer scoreUse;
    
    // 是否可用:1-可用 0-注销
    private Integer status;
    
    // score_flag
    private Integer scoreFlag;
    
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUseMac() {
		return userMac;
	}

	public void setUseMac(String useMac) {
		this.userMac = useMac;
	}

	public Integer getScoreTotal() {
		return scoreTotal;
	}

	public void setScoreTotal(Integer scoreTotal) {
		this.scoreTotal = scoreTotal;
	}

	public Integer getScoreUse() {
		return scoreUse;
	}

	public void setScoreUse(Integer scoreUse) {
		this.scoreUse = scoreUse;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getScoreFlag() {
		return scoreFlag;
	}

	public void setScoreFlag(Integer scoreFlag) {
		this.scoreFlag = scoreFlag;
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
		return "User [id=" + id + ", parentId=" + parentId + ", username=" + username + ", password=" + password + ", telephone=" + telephone + ", imei=" + imei
				+ ", userMac=" + userMac + ", scoreTotal=" + scoreTotal + ", scoreUse=" + scoreUse + ", status=" + status + ", scoreFlag=" + scoreFlag
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

}
