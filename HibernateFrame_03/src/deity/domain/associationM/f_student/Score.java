package deity.domain.associationM.f_student;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	private Integer id;
	private String garde;
	private Student student;
	private Course course;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
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
	@JoinColumn(name="sgarde")
	public String getGarde() {
		return garde;
	}

	public void setGarde(String garde) {
		this.garde = garde;
	}
}
