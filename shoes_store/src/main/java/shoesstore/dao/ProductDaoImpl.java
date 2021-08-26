package shoesstore.dao;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import shoesstore.entities.Product;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ProductDaoImpl<E> extends BaseDaoImpl<Product, Integer> implements ProductDao<Product, Integer> {
	
}
