package deity.domain.associationM.b_one2many_annotation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	private Integer id;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>();
	//一对多的单项关联
	/*
	@OneToMany
	@JoinColumn(name="dept_id")
	 */
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
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
	public Department setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public String toString() {
		return "[id="+id+",name="+name+"]";
	}
	
}
