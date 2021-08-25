package shoesstore.dao;

import java.util.List;

import shoesstore.entities.Paging;

public interface BaseDao<E,ID> {
	List<E> findAll(Paging paging);
	E findById(Class<E> e,ID id);
	List<E> findByProperty(String property,Object value);
	int insert(E instance);
	void update(E instance);
	void delete(E instance);
}
