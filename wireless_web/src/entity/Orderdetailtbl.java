package entity;

public class Orderdetailtbl implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderId;
	private Integer menuId;
	private Integer num;
	private String remark;

	// Constructors

	/** default constructor */
	public Orderdetailtbl() {
	}

	/** minimal constructor */
	public Orderdetailtbl(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Orderdetailtbl(Integer id, Integer orderId, Integer menuId,
			Integer num, String remark) {
		this.id = id;
		this.orderId = orderId;
		this.menuId = menuId;
		this.num = num;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}