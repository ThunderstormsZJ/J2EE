package deity.domain.actionGuide;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MainAction extends ActionSupport {
	public String guide() throws Exception{
		return SUCCESS;
	}
	public String nameSpace() throws Exception{
		return SUCCESS;
	}
	public String path() throws Exception{
		return SUCCESS;
	}
	public String method() throws Exception{
		return SUCCESS;
	}
	public String param() throws Exception{
		return SUCCESS;
	}
	public String i18n() throws Exception{
		return SUCCESS;
	}
	public String validation() throws Exception{
		return SUCCESS;
	}
	public String accesswebelements() throws Exception{
		return SUCCESS;
	}
	public String result() throws Exception{
		return SUCCESS;
	}
	public String ognl() throws Exception{
		return SUCCESS;
	}
	public String tags() throws Exception{
		this.addFieldError("errors", "Is error!");
		return SUCCESS;
	}
}
