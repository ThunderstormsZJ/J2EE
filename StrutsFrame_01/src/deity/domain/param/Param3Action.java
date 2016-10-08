package deity.domain.param;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import deity.domain.domain.User;

@SuppressWarnings("serial")
public class Param3Action extends ActionSupport implements ModelDriven<User>{
	private User user = new User(); 
	@Override
	public String execute() throws Exception {
		System.out.println("[name="+user.getName()+",age="+user.getAge()+"]");
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
}