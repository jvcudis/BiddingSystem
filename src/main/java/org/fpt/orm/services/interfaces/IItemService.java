package org.fpt.orm.services.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.Item;
import org.fpt.web.forms.ItemForm;

public interface IItemService extends IOperations<Item> {
    
	// TODO Add method description later
	
	List<Item> getAllItems();
	List<Item> getAllItemsByOwner(Integer ownerId);
	Item getItemById(Integer id);
	Item createItem(ItemForm form);
	Item updateItem(Integer id, ItemForm form);
	Item deleteItemById(Integer id);

}
