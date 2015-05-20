package org.fpt.orm.dao.classes;

import java.util.ArrayList;
import java.util.List;

import org.fpt.orm.dao.common.GenericDao;
import org.fpt.orm.dao.interfaces.IBidDao;
import org.fpt.orm.models.Bid;
import org.fpt.orm.models.Item;
import org.fpt.orm.models.User;
import org.fpt.web.forms.BidForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BidDao extends GenericDao<Bid> implements IBidDao {

	@Autowired
    private SessionFactory sessionFactory;
	
    public BidDao() {
        super();
        setClazz(Bid.class);
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Bid> findAllBidsByOwner(Integer ownerId) {
		List<Bid> bids = new ArrayList<Bid>();
		bids = sessionFactory.getCurrentSession()
				.createQuery("from Bid where bidOwnerId=?")
				.setParameter(0, ownerId)
				.list();
		
		if(bids.size() > 0) {
			return bids;
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bid> findAllBidsByItem(Integer itemId) {
		List<Bid> bids = new ArrayList<Bid>();
		bids = sessionFactory.getCurrentSession()
				.createQuery("from Bid where bidItemId=?")
				.setParameter(0, itemId)
				.list();
		
		if(bids.size() > 0) {
			return bids;
		} else {
			return null;
		}
	}
	
	@Override
	public Bid createBid(BidForm form) {
		Session session = sessionFactory.getCurrentSession();
		Bid bid = new Bid();
		
		bid.setBidItemId(form.getItemId());
		bid.setBidOwnerId(form.getOwnerId());
		bid.setBidOfferPrice(form.getOfferPrice());
		bid.setBidOfferDate(form.getOfferDate());
		bid.setBidder((User) session.get(User.class, form.getOwnerId()));
		bid.setProduct((Item) session.get(Item.class, form.getItemId()));
		
		session.saveOrUpdate(bid);
		
		return bid;
	}

	@Override
	public Bid updateBid(Integer id, BidForm form) {
		Session session = sessionFactory.getCurrentSession();
		Bid bid = (Bid) session.get(Bid.class, id);
		
		bid.setBidItemId(form.getItemId());
		bid.setBidOwnerId(form.getOwnerId());
		bid.setBidOfferPrice(form.getOfferPrice());
		bid.setBidOfferDate(form.getOfferDate());
		bid.setBidder((User) session.get(User.class, form.getOwnerId()));
		bid.setProduct((Item) session.get(Item.class, form.getItemId()));
		
		session.merge(bid);
		
		return bid;
	}

}