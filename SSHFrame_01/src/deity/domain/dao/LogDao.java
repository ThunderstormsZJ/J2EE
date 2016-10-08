package deity.domain.dao;

import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import deity.domain.domain.Log;
import deity.domain.idao.ILogDao;

@Component
public class LogDao implements ILogDao {
	private HibernateTemplate hibernateTemplate;
	
	public void add(Log log) {
		hibernateTemplate.save(log);
	}

	public void delete(Log log) {}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
