package deity.domain.associationM.e_tree;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Org {
	private Integer id;
	private String name;
	private Set<Org> children = new HashSet<Org>();
	private Org parent;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Org> getChildren() {
		return children;
	}
	@ManyToOne()
	@JoinColumn(name="parent_id")
	public Org getParent() {
		return parent;
	}
	public void setChildren(Set<Org> children) {
		this.children = children;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Org parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "["+name+"]";
	}
	
}
