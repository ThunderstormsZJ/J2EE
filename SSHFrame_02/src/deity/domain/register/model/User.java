package deity.domain.register.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import deity.domain.register.dto.UserDto;

@Entity
public class User {
	private Integer id;
	private String username;
	private String password;
	
	public User(UserDto userDto){
		this.username = userDto.getUsername();
		this.password = userDto.getPassword();
	}
	public User() {}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
