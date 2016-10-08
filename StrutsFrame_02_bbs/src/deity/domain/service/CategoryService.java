package deity.domain.service;

import java.util.List;
import deity.domain.dao.CategoryDao;
import deity.domain.domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();
	public List<Category> findAll(){
		return categoryDao.findAll();
	}
}
