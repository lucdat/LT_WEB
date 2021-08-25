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
		return userDao.findAll(paging);
	}

	@Override
	public User findById(Class<User> e, Integer id) {
		return userDao.findById(e, id);
	}

	@Override
	public List<User> findByProperty(String property, Object value) {
		return userDao.findByProperty(property, value);
	}

	@Override
	public int insert(User instance) {
		return userDao.insert(instance);
	}

	@Override
	public void update(User instance) {
		// TODO Auto-generated method stub
		userDao.update(instance);
	}

	@Override
	public void delete(User instance) {
		userDao.delete(instance);
	}

}
