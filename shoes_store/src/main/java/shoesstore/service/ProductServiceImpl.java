package shoesstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesstore.dao.ProductDao;
import shoesstore.entities.Paging;
import shoesstore.entities.Product;

@Service
public class ProductServiceImpl implements ProductService<Product, Integer> {

	@Autowired
	private ProductDao<Product, Integer> productDao;
	
	@Override
	public List<Product> findAll(Paging paging) {
		return productDao.findAll(paging);
	}

	@Override
	public Product findById(Class<Product> e, Integer id) {
		return productDao.findById(e, id);
	}

	@Override
	public List<Product> findByProperty(String property, Object value) {
		return productDao.findByProperty(property, value);
	}

	@Override
	public int insert(Product instance) {
		return productDao.insert(instance);
	}

	@Override
	public void update(Product instance) {
		productDao.update(instance);
	}

	@Override
	public void delete(Product instance) {
		productDao.delete(instance);
	}

}
