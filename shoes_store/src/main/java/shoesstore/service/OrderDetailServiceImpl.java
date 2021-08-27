package shoesstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesstore.dao.OrderDetailDao;
import shoesstore.entities.OrderDetails;
import shoesstore.entities.Paging;

@Service
public class OrderDetailServiceImpl implements OrderDetailService<OrderDetails, Integer> {
	@Autowired
	private OrderDetailDao<OrderDetails, Integer> detailDao;

	@Override
	public List<OrderDetails> findAll(Paging paging) {
		return detailDao.findAll(paging);
	}

	@Override
	public OrderDetails findById(Class<OrderDetails> e, Integer id) {
		return detailDao.findById(e, id);
	}

	@Override
	public List<OrderDetails> findByProperty(String property, Object value) {
		return detailDao.findByProperty(property, value);
	}

	@Override
	public int insert(OrderDetails instance) {
		return detailDao.insert(instance);
	}

	@Override
	public void update(OrderDetails instance) {
		detailDao.update(instance);
	}

	@Override
	public void delete(OrderDetails instance) {
		detailDao.delete(instance);
	}

}
