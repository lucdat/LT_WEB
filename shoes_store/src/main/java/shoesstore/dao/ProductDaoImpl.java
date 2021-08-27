package shoesstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shoesstore.entities.Product;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ProductDaoImpl<E> extends BaseDaoImpl<Product, Integer> implements ProductDao<Product, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> findAll() {
		StringBuilder query = new StringBuilder("");
		StringBuilder countQuery = new StringBuilder("");
		query.append("from ").append(getGenericName());
		countQuery.append("select count(*) from ").append(getGenericName());
		Query<Product> result = sessionFactory.getCurrentSession().createQuery(query.toString());
		return result.list();
	}
	
}
