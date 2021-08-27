package shoesstore.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shoesstore.entities.Invoice;


@Repository
@Transactional(rollbackOn = Exception.class)
public class InvoiceDaoImpl extends BaseDaoImpl<Invoice, Integer> implements InvoiceDao<Invoice, Integer> {
	@Autowired
	private SessionFactory sessionFactory;
	public List<Invoice> statistical(String a , String b){
		StringBuilder query = new StringBuilder("");
		query.append("from Invoice where Date between '"+a + "'and '"+ b +"'" );
		Query<Invoice> result = sessionFactory.getCurrentSession().createQuery(query.toString());
		return result.list();
	}
}
