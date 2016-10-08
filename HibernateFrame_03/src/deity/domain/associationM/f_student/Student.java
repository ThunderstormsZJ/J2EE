package deity.domain.associationM.f_student;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	private Integer id;
	private String name;
	private Set<Course> course = new HashSet<Course>();
	@ManyToMany
	@JoinTable(name="score",
	joinColumns={@JoinColumn(name="student_id")}
	,inverseJoinColumns={@JoinColumn(name="course_id")})
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
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
