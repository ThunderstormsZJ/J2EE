package deity.domain.access;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login4Action extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	public Login4Action() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = session.getServletContext();
	}
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("frank", "12345");
		session.setAttribute("jack", "12345");
		application.setAttribute("rose", "12345");
		return SUCCESS;
	}
	
}
