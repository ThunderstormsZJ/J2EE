package deity.domain.b_dao;

import java.util.List;

public class Page<T> {
	private Long count;
	private List<T> list;
	public Page(Long count, List<T> list) {
		this.count = count;
		this.list = list;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
