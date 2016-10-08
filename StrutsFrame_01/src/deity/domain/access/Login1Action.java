package deity.domain.access;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login1Action extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;

	@Override
	public String execute() throws Exception {
		request.put("frank", "12345");
		session.put("jack", "12345");
		application.put("rose", "12345");
		return SUCCESS;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
