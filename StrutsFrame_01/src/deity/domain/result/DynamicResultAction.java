package deity.domain.result;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DynamicResultAction extends ActionSupport {
	private Integer type;
	private String dynamicUrl;
	@Override
	public String execute() throws Exception {
		if(type==1){
			dynamicUrl = "view_resulttype/success.jsp";
		}else{
			dynamicUrl = "view_resulttype/fail.jsp";
		}
		return SUCCESS;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDynamicUrl() {
		return dynamicUrl;
	}
	public void setDynamicUrl(String dynamicUrl) {
		this.dynamicUrl = dynamicUrl;
	}
}
