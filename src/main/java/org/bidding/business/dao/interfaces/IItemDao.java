package org.bidding.business.dao.interfaces;

import java.util.List;

import org.bidding.business.dao.common.IOperations;
import org.bidding.business.models.Item;
import org.bidding.web.forms.ItemForm;

public interface IItemDao extends IOperations<Item> {
    
	// TODO Add method description later
	
	List<Item> findItemsByOwner(Integer ownerId);
	Item createItem(ItemForm form);
	Item updateItem(Integer id, ItemForm form);
}
