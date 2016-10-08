package deity.domain.associationM.b_one2many_annotation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	private Integer id;
	private String name;
	private Department department;
	//多对一的单项关联
	/*
	@ManyToOne
	@JoinColumn(name="dept_Id")
	*/
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Employee setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public String toString() {
		return "[id="+id+",name="+name+",department="+department+"]";
	}
	
	
}
