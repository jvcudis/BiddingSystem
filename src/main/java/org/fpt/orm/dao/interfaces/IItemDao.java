package org.fpt.orm.dao.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.Item;
import org.fpt.web.forms.ItemForm;

public interface IItemDao extends IOperations<Item> {
    
	// TODO Add method description later
	
	List<Item> findItemsByOwner(Integer ownerId);
	Item createItem(ItemForm form);
	Item updateItem(Integer id, ItemForm form);
}
