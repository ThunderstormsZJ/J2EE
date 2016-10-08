package com.deity.oa.conf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.deity.oa.model.Forum;
import com.deity.oa.model.Topic;
import com.deity.oa.model.User;
import com.deity.oa.service.ForumService;
import com.deity.oa.service.TopicService;
import com.deity.oa.service.UserService;
import com.deity.oa.until.QueryHqlUtil;

public class ConfigureTest {

	@Test
	public void insertTestDate() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) ac.getBean("userServiceImpl");
		TopicService topicService = (TopicService) ac
				.getBean("topicServiceImpl");
		ForumService forumService = (ForumService) ac
				.getBean("forumServiceImpl");
		Forum forum = forumService.findById(new Long("102"));
		User user = userService.findById(new Long("2"));
		for (int i = 0; i < 150; i++) {
			Topic topic = new Topic();
			if (i % 10 == 0) {
				topic.setType(Topic.TYPE_BEST);
			}
			topic.setTitle(user.getName() + i);
			topic.setPostTime(new Date());
			topic.setAuthor(user);
			topic.setForum(forum);
			topicService.add(topic);
		}
		System.out.println("导入成功");
	}

	@Test
	public void strTest() {
		String hql = "select count(*) from Topic t where t.forum=? and t.topic=? order by t.type desc";
		hql = hql.substring(0, hql.indexOf("?") + 1);
		System.out.println(hql);
	}

	@Test
	public void classTest() {
		Class<Topic> clazz = Topic.class;
		System.out.println("name:" + clazz.getName());
		System.out.println("simpleName" + clazz.getSimpleName());
	}

	@Test
	public void queryHqlTest() {
		boolean sortWay = true;
		int topicType = 1;
		int sortType = 0;
		String quertHql = new QueryHqlUtil<Topic>(Topic.class)//
				.addCondition("t.forum=?", "forum")//
				.addCondition(topicType == 1, "t.type=?", Topic.TYPE_BEST)//
				.addOrder(sortType == 0,"(case t.type when 2 then 2 else 0 end)", true)//
				.addOrder(sortType == 0,"t.postTime", sortWay)//
				.addOrder(sortType == 1, "t.lastUpdateTime", sortWay)//
				.addOrder(sortType == 2, "t.postTime", sortWay)//
				.addOrder(sortType == 3, "t.replyCount", sortWay).getQueryHql();
		System.out.println(quertHql);
	}
	
	@Test
	public void listTest(){
		List<String> strs = new ArrayList<String>();
		strs.add("123");
		strs.add("23");
		strs.add("3");
		System.out.println(strs.get(0));
	}
}
