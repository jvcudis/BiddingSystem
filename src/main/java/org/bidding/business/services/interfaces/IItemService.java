package org.bidding.business.services.interfaces;

import java.util.List;

import org.bidding.business.dao.common.IOperations;
import org.bidding.business.models.Item;
import org.bidding.web.forms.ItemForm;

public interface IItemService extends IOperations<Item> {
    
	// TODO Add method description later
	
	List<Item> getAllItems();
	List<Item> getAllItemsByOwner(Integer ownerId);
	Item getItemById(Integer id);
	Item createItem(ItemForm form);
	Item updateItem(Integer id, ItemForm form);
	Item deleteItemById(Integer id);

}
