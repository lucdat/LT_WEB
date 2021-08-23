package shoesstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesstore.dao.UserDao;
import shoesstore.entities.Paging;
import shoesstore.entities.User;

@Service
public class UserServiceImpl implements UserService<User, Integer> {

	@Autowired
	private UserDao<User, Integer> userDao;
	@Override
	public List<User> findAll(Paging paging) {
		// TODO Auto-generated method stub
		return userDao.findAll(paging);
	}

	@Override
	public User findById(Class<User> e, Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(e, id);
	}

	@Override
	public List<User> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return userDao.findByProperty(property, value);
	}

	@Override
	public int insert(User instance) {
		// TODO Auto-generated method stub
		return userDao.insert(instance);
	}

	@Override
	public void update(User instance) {
		// TODO Auto-generated method stub
		userDao.update(instance);
	}

}
