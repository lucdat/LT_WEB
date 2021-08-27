package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.OrderDetails;

@Repository
@Transactional(rollbackOn = Exception.class)
public class OrderDetailImpl extends BaseDaoImpl<OrderDetails, Integer> implements OrderDetailDao<OrderDetails, Integer> {

}
