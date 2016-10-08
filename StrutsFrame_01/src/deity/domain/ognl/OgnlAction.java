package deity.domain.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OgnlAction extends ActionSupport {
	private String username;
	private User user;
	/*
	 * ¼¯ºÏ
	 */
	private Set<User> userSet = new HashSet<User>();
	private List<User> userList = new ArrayList<User>();
	private Map<String,User> userMap = new HashMap<String,User>();
	public OgnlAction() {
		Card card = new Card(12,"frank123");
		user = new User();
		user.setCard(card);
		for (int i = 1; i < 4; i++) {
			User user1 = new User();
			user1.setName("Frank"+i);
			user1.setAge(21);
			userSet.add(user1);
			
			User user2 = new User();
			user2.setName("Jack"+i);
			user2.setAge(21);
			userList.add(user2);
			
			User user3 = new User();
			user3.setName("Rose"+i);
			user3.setAge(21);
			userMap.put(""+i, user3);
		}
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Map<String, User> getUserMap() {
		return userMap;
	}
	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}
}
