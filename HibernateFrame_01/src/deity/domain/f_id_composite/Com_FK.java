package deity.domain.f_id_composite;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Com_FK implements Serializable{
	private Integer id;
	private String name;
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
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Com_FK){
			Com_FK com_FK = (Com_FK) obj;
			if(com_FK.getId()==this.id && this.getName().equals(com_FK.getName())){
				return true;
			}
		}
		return false;
	}
	
}