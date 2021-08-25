package shoesstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesstore.dao.ActionDao;
import shoesstore.entities.Action;
import shoesstore.entities.Paging;

@Service
public class ActionServiceImpl  implements ActionService<Action, Integer>{
	@Autowired
	private ActionDao<Action, Integer> actionDao;

	@Override
	public List<Action> findAll(Paging paging) {
		// TODO Auto-generated method stub
		return actionDao.findAll(paging);
	}

	@Override
	public Action findById(Class<Action> e, Integer id) {
		// TODO Auto-generated method stub
		return actionDao.findById(e, id);
	}

	@Override
	public List<Action> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Action instance) {
		// TODO Auto-generated method stub
		return actionDao.insert(instance);
	}

	@Override
	public void update(Action instance) {
		// TODO Auto-generated method stub
		actionDao.update(instance);
	}

	@Override
	public void delete(Action instance) {
		actionDao.delete(instance);
	}

}
