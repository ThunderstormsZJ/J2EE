package deity.domain.register.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import deity.domain.register.dto.UserDto;
import deity.domain.register.model.User;
import deity.domain.register.service.UserManager;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserAction extends ActionSupport implements ModelDriven<UserDto>{
	private UserManager userManager;
	private UserDto userDto = new UserDto();
	private List<User> users;
	private User user;
	
	@Override
	public String execute() throws Exception {
		User user = new User(userDto);
		return userManager.add(user);
	}
	public String listAll() throws Exception{
		users = userManager.listALl();
		return "list";
	}
	public String detail() throws Exception{
		user = userManager.detail(userDto.getId());
		return "detail";
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public UserDto getModel() {
		return this.userDto;
	}
}
