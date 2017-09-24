package entity;

/**
 * Menutbl entity. @author MyEclipse Persistence Tools
 */

public class Menutbl implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer price;
	private Integer typeId;
	private String name;
	private String pic;
	private String remark;

	// Constructors

	/** default constructor */
	public Menutbl() {
	}

	/** full constructor */
	public Menutbl(Integer price, Integer typeId, String name, String pic,
			String remark) {
		this.price = price;
		this.typeId = typeId;
		this.name = name;
		this.pic = pic;
		this.remark = remark;
	}
	
	/** full constructor */
	public Menutbl(String name,Integer price,  String pic,
			String remark) {
		this.price = price;
		this.name = name;
		this.pic = pic;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}