package deity.domain.param;

import com.opensymphony.xwork2.ActionSupport;

import deity.domain.domain.User;

@SuppressWarnings("serial")
public class Param2Action extends ActionSupport {
	private User user; 
	@Override
	public String execute() throws Exception {
		if(user.getName().equals("ÌìµÀ")){
			String str = "[name="+user.getName()+",age="+user.getAge()+"]";
			this.addActionMessage(str);
		}else{
			this.addFieldError("name", "Name Is Error!");
		}
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}