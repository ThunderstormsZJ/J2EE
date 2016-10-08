package deity.domain.f_id_composite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Teacher_FK.class)//(3)
public class Teacher {
	//private Teacher_FK fk;
	private Integer id;
	private String name;
	private Integer age;
	//@Id//(1)
	//@EmbeddedId//(2)
	/*public Teacher_FK getFk() {
		return fk;
	}
	public void setFk(Teacher_FK fk) {
		this.fk = fk;
	}*/
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}//(3)
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
