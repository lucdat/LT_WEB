package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.Orders;

@Repository
@Transactional(rollbackOn = Exception.class)
public class OrderDaoImpl extends BaseDaoImpl<Orders, Integer> implements OrderDao<Orders, Integer> {

}
