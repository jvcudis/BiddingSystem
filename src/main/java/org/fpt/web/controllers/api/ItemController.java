package org.fpt.web.controllers.api;

import java.util.List;

import org.fpt.orm.models.Item;
import org.fpt.orm.services.interfaces.IItemService;
import org.fpt.web.forms.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	private IItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/items/{id}")
	public Item getItemById(@PathVariable final Integer id) {
		return itemService.getItemById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/items/owner/{ownerId}")
	public List<Item> getAllItemsByOwner(@PathVariable final Integer ownerId) {
		return itemService.getAllItemsByOwner(ownerId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/items")
	@ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody final ItemForm resource) {
		// TODO Pre-checking conditions, resource must be valid
		return itemService.createItem(resource);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Item updateItem(@PathVariable final Integer id, @RequestBody final ItemForm resource) {
		// TODO Pre-checking conditions, resource must be valid
		return itemService.updateItem(id, resource);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Item deleteItemById(@PathVariable final Integer id) {
		return itemService.deleteItemById(id);
    }
	
}