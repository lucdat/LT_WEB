package shoesstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesstore.dao.OrderDao;
import shoesstore.entities.Orders;
import shoesstore.entities.Paging;

@Service
public class OrderServiceImpl implements OrderService<Orders, Integer>{ 
    @Autowired
	private OrderDao<Orders, Integer> orderDao;
    
	@Override
	public List<Orders> findAll(Paging paging) {
		return orderDao.findAll(paging);
	}

	@Override
	public Orders findById(Class<Orders> e, Integer id) {
		return orderDao.findById(e, id);
	}

	@Override
	public List<Orders> findByProperty(String property, Object value) {
		return orderDao.findByProperty(property, value);
	}

	@Override
	public int insert(Orders instance) {
		return orderDao.insert(instance);
	}

	@Override
	public void update(Orders instance) {
		orderDao.update(instance);
	}

	@Override
	public void delete(Orders instance) {
		orderDao.delete(instance);
	}

}
