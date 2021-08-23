package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.User;

@Repository
@Transactional(rollbackOn = Exception.class)
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao<User, Integer>{
	

}
