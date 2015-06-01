package org.bidding.business.dao.classes;

import java.util.ArrayList;
import java.util.List;

import org.bidding.business.dao.common.GenericDao;
import org.bidding.business.dao.interfaces.IItemDao;
import org.bidding.business.models.Item;
import org.bidding.business.models.User;
import org.bidding.web.forms.ItemForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao extends GenericDao<Item> implements IItemDao {

	@Autowired
    private SessionFactory sessionFactory;
	
    public ItemDao() {
        super();
        setClazz(Item.class);
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> findItemsByOwner(Integer ownerId) {
		List<Item> items = new ArrayList<Item>();
		items = sessionFactory.getCurrentSession()
				.createQuery("from Item where itemOwnerId=?")
				.setParameter(0, ownerId)
				.list();
		
		if(items.size() > 0) {
			return items;
		} else {
			return null;
		}
	}

	@Override
	public Item createItem(ItemForm form) {
		Session session = sessionFactory.getCurrentSession();
		Item item = new Item();
		item.reformItem(form.getName(),form.getDesc(),form.getOwner(),form.getDateAdded(),form.getDateExpiry(),form.getPrice());
		item.setOwner((User) session.get(User.class, form.getOwner()));
		session.saveOrUpdate(item);
		return item;
	}

	@Override
	public Item updateItem(Integer id, ItemForm form) {
		Session session = sessionFactory.getCurrentSession();
		Item item = (Item) session.get(Item.class, id);
		item.reformItem(form.getName(),form.getDesc(),form.getOwner(),form.getDateAdded(),form.getDateExpiry(),form.getPrice());
		item.setOwner((User) session.get(User.class, form.getOwner()));
		session.merge(item);
		return item;
	}

}