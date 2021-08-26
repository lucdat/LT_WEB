package shoesstore.dao;

import java.util.List;

import shoesstore.entities.Product;

public interface ProductDao<E,ID> extends BaseDao<E, ID> {
	public List<Product> findAll();
}
