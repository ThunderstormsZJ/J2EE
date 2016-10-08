package deity.domain.associationM.a_one2one_xml;

public class Husband {
	private Integer id;
	private String name;
	private Wife wife;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Wife getWife() {
		return wife;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
