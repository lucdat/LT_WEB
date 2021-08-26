package shoesstore.dao;

import java.util.List;

import shoesstore.entities.Category;

public interface CategoryDao<E,ID> extends BaseDao<E, ID> {

	public List<Category> findAll();
}
