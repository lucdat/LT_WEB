package shopshoes.dao;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopshoes.entities.Paging;

@Repository
@Transactional(rollbackOn = Exception.class)
public class BaseDaoImpl<E,ID> implements BaseDao<E, ID> {
	
	private final static Logger log = Logger.getLogger(BaseDaoImpl.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<E> findAll(Paging paging) {
		log.info("find all method called");
		
		StringBuilder query = new StringBuilder("");
		StringBuilder countQuery = new StringBuilder("");
		
		query.append("from ").append(getGenericName()).append(" as model where model.activeFlag=1");
		countQuery.append("select count(*) from ").append(getGenericName()).append(" as model where model.activeFlag=1");
		log.info("Query: "+query.toString());
		log.info("Count query: "+countQuery.toString());
		Query<E> result = sessionFactory.getCurrentSession().createQuery(query.toString());
		Query<E> count = sessionFactory.getCurrentSession().createQuery(countQuery.toString());
		if(paging!=null) {
			result.setFirstResult(paging.getOffset());
			result.setMaxResults(paging.getRecordPerPage());
			long totalRecords = (long)count.uniqueResult();
			paging.setTotalRows(totalRecords);
		}
		return result.list();
	}

	@Override
	public E findById(Class<E> e, ID id) {
		log.info("find by id : "+id.toString());
		return sessionFactory.getCurrentSession().get(e, (Serializable)id) ;
	}

	@Override
	public List<E> findByProperty(String property, Object value, Paging paging) {
		log.info("find by property "+property+" "+value.toString());
		StringBuilder query = new StringBuilder("");
		StringBuilder countQuery = new StringBuilder("");
	
		query.append("from ").append(getGenericName())
			 .append(" as model where model.activeFlag=1 and model.").append(property).append(" like:value");
		countQuery.append("select count(*) form ").append(getGenericName())
		     .append(" as model where model.activeFlag=1 and model.").append(property).append(" like:value");
		Query<E> result = sessionFactory.getCurrentSession()
										.createQuery(query.toString()).setParameter("value", "%"+value+"%");
		Query<E> count = sessionFactory.getCurrentSession()
										.createQuery(countQuery.toString()).setParameter("value", "%"+value+"%");
		log.info(query);
		if(paging!=null) {
			result.setFirstResult(paging.getOffset());
			result.setMaxResults(paging.getRecordPerPage());
			long totalRecords = (long)count.uniqueResult();
			paging.setTotalRows(totalRecords);
		}
		return result.list();
	}

	@Override
	public int insert(E instance) {
		log.info(" insert instance");
		Integer id = (Integer) sessionFactory.getCurrentSession().save(instance);
		return id;
	}

	@Override
	public void update(E instance) {
		log.info("update");
		sessionFactory.getCurrentSession().merge(instance);
	}

	public String getGenericName() {
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\,");
		Matcher m = pattern.matcher(s);
		String generic="null";
		if(m.find()) {
			generic = m.group(1);
		}
		return generic;
	}
	
}
