package deity.domain.c_hbm2ddl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//tableָ����ͬ�ı���
@Entity
@Table(name="_student")
public class Student {
	private Integer id;
	private String name;
	private Integer grade;
	private String address;
	//ע���ע��get��������
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
