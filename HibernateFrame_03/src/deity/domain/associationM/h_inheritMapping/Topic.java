package deity.domain.associationM.h_inheritMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="h_topic")
public class Topic extends Article{
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
