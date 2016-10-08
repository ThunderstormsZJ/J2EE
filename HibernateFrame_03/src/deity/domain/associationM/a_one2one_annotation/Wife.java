package deity.domain.associationM.a_one2one_annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wife {
	private Integer id;
	private String name;
	
	/*
	 * ˫�����������
	 * 	����mappedby���ԣ���ֹ�����ظ��������
	 */
	/*private Husband husband;
	@OneToOne(mappedBy="wife")
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}*/
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
