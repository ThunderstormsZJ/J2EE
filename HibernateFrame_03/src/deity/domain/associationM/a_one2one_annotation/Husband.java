package deity.domain.associationM.a_one2one_annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Husband {
	private Integer id;
	private String name;
	private Wife wife;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@OneToOne
	@JoinColumn(name="wife_FK")
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
