package org.fpt.orm.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.fpt.orm.models.Item;
import org.fpt.orm.services.common.GenericService;
import org.fpt.orm.services.interfaces.IItemService;
import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.dao.interfaces.IItemDao;
import org.fpt.web.forms.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item> implements IItemService {

    @Autowired
    private IItemDao dao;

    public ItemService() {
        super();
    }

    @Override
    protected IOperations<Item> getDao() {
        return dao;
    }

    @Override
	public List<Item> getAllItems() {
    	List<Item> items = new ArrayList<Item>();
		items = getDao().findAll();
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(items.isEmpty()) {
			return null;
		} else {
			return items;
		}
	}

	@Override
	public List<Item> getAllItemsByOwner(Integer ownerId) {
		List<Item> items = new ArrayList<Item>();
		items = dao.findItemsByOwner(ownerId);

		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(items.size() == 0) {
			// TODO Return something better instead of null
			return null;
		} else {
			return items;
		}
	}

	@Override
	public Item getItemById(Integer id) {
		Item item = getDao().findOne(id);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		return item;
	}

	@Override
	public Item createItem(ItemForm form) {
		Item item = dao.createItem(form);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(item == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return item;
		}
	}

	@Override
	public Item updateItem(Integer id, ItemForm form) {
		Item item = dao.updateItem(id, form);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(item == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return item;
		}
	}

	@Override
	public Item deleteItemById(Integer id) {
		Item item = getDao().findOne(id);
		getDao().deleteById(id);
		return item;
	}
    
}
