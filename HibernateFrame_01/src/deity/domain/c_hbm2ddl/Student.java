package deity.domain.c_hbm2ddl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//table指定不同的表名
@Entity
@Table(name="_student")
public class Student {
	private Integer id;
	private String name;
	private Integer grade;
	private String address;
	//注解标注在get方法上面
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
