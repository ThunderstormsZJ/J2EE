package deity.domain.control;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import deity.domain.domain.Category;
import deity.domain.service.CategoryService;

@SuppressWarnings("serial")
public class CategoryAction extends ActionSupport{
	private List<Category> categorys;
	private CategoryService categoryService = new CategoryService();
	public String execute() throws Exception {
		categorys = categoryService.findAll();
		return SUCCESS;
	}
	
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
