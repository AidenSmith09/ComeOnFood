package entity;

/**
 * Ordertbl entity. @author MyEclipse Persistence Tools
 */

public class Ordertbl implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orderTime;
	private Integer userId;
	private Integer tableId;
	private Integer personNum;
	private Integer isPay;
	private String remark;

	// Constructors

	/** default constructor */
	public Ordertbl() {
	}

	/** full constructor */
	public Ordertbl(String orderTime, Integer userId, Integer tableId,
			Integer personNum, Integer isPay, String remark) {
		this.orderTime = orderTime;
		this.userId = userId;
		this.tableId = tableId;
		this.personNum = personNum;
		this.isPay = isPay;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

	public Integer getIsPay() {
		return this.isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}