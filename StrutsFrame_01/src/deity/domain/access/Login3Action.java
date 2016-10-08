package deity.domain.access;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login3Action extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	@Override
	public String execute() throws Exception {
		request.setAttribute("frank", "12345");
		session.setAttribute("jack", "12345");
		application.setAttribute("rose", "12345");
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
		this.application = session.getServletContext();
	}
	
}
