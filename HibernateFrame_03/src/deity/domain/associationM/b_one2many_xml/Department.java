package deity.domain.associationM.b_one2many_xml;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer id;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>();
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
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
}
