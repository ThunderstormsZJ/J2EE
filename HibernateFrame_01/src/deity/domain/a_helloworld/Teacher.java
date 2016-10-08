package deity.domain.a_helloworld;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	private Integer id;
	private String name;
	private Integer age;
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
