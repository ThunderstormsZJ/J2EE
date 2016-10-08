package deity.domain.associationM.c_many2many_xml;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	private Integer id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();
	//单向多对多
	/*@ManyToMany
	@JoinTable(name="t_s",
	joinColumns={@JoinColumn(name="student_id")},
	inverseJoinColumns={@JoinColumn(name="teacher_id")})*/
	@ManyToMany(mappedBy="students")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
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
	public void setName(String name) {
		this.name = name;
	}
}
