package deity.domain.f_id_composite;

public class Student {
	private Com_FK com_FK;
	private Integer age;
	private String subject;
	public Com_FK getCom_FK() {
		return com_FK;
	}
	public void setCom_FK(Com_FK com_FK) {
		this.com_FK = com_FK;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
