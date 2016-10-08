package com.deity.oa.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.deity.oa.model.Topic;
import com.deity.oa.service.TopicService;

public class TopicServiceImplTest {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TopicService topicServiceImpl = (TopicService) ac.getBean("topicServiceImpl");
		Topic topic = new Topic();
		topic.setId(null);
		topic.setTitle("test");
		topicServiceImpl.add(topic);
	}
}
