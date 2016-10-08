package deity.domain.access;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "unchecked", "serial" })
public class Login2Action extends ActionSupport {
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	public Login2Action() {
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}
	
	@Override
	public String execute() throws Exception {
		request.put("frank", "12345");
		session.put("jack", "12345");
		application.put("rose", "12345");
		return SUCCESS;
	}
	
}
