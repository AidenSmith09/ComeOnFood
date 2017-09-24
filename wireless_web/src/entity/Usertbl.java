package entity;

/**
 * Usertbl entity. @author MyEclipse Persistence Tools
 */

public class Usertbl implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String account;
	private String gender;
	private Integer permission;
	private String remark;

	// Constructors

	/** default constructor */
	public Usertbl() {
	}

	/** full constructor */
	public Usertbl(String name, String password, String account, String gender,
			Integer permission, String remark) {
		this.name = name;
		this.password = password;
		this.account = account;
		this.gender = gender;
		this.permission = permission;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPermission() {
		return this.permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}