package shoesstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shoesstore.entities.Category;
import shoesstore.entities.Product;

@Repository
@Transactional(rollbackOn = Exception.class)
public class CategoryDaoImpl extends BaseDaoImpl<Category, Integer> implements CategoryDao<Category, Integer> {


	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Category> findAll() {
		StringBuilder query = new StringBuilder("");
		StringBuilder countQuery = new StringBuilder("");
		query.append("from ").append(getGenericName()).append(" as model where model.activeFlag=1");
		countQuery.append("select count(*) from ").append(getGenericName()).append(" as model where model.activeFlag=1");
		Query<Category> result = sessionFactory.getCurrentSession().createQuery(query.toString());
		return result.list();
	}
}
