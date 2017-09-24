package entity;

/**
 * Tabletbl entity. @author MyEclipse Persistence Tools
 */

public class Tabletbl implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer num;
	private Integer flag;

	// Constructors

	/** default constructor */
	public Tabletbl() {
	}

	/** full constructor */
	public Tabletbl(Integer num, Integer flag) {
		this.num = num;
		this.flag = flag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}