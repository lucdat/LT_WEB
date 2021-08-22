package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.Category;

@Repository
@Transactional(rollbackOn = Exception.class)
public class CategoryDaoImpl extends BaseDaoImpl<Category, Integer> implements CategoryDao<Category, Integer> {

}
