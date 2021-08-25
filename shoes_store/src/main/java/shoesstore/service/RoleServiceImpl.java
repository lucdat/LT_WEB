package shoesstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesstore.dao.RoleDao;
import shoesstore.entities.Paging;
import shoesstore.entities.Role;

@Service
public class RoleServiceImpl implements RoleService<Role, Integer> {
	@Autowired
	private RoleDao<Role, Integer> roleDao;

	@Override
	public List<Role> findAll(Paging paging) {
		return roleDao.findAll(paging);
	}

	@Override
	public Role findById(Class<Role> e, Integer id) {
		return roleDao.findById(e, id);
	}

	@Override
	public List<Role> findByProperty(String property, Object value) {
		return roleDao.findByProperty(property, value);
	}

	@Override
	public int insert(Role instance) {
		return roleDao.insert(instance);
	}

	@Override
	public void update(Role instance) {
		roleDao.update(instance);
	}

	@Override
	public void delete(Role instance) {
		roleDao.delete(instance);
	}

}
