package org.fpt.orm.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.fpt.orm.models.Bid;
import org.fpt.orm.services.common.GenericService;
import org.fpt.orm.services.interfaces.IBidService;
import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.dao.interfaces.IBidDao;
import org.fpt.web.forms.BidForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService extends GenericService<Bid> implements IBidService {

    @Autowired
    private IBidDao dao;

    public BidService() {
        super();
    }

    @Override
    protected IOperations<Bid> getDao() {
        return dao;
    }

	@Override
	public List<Bid> getAllBids() {
		List<Bid> bids = new ArrayList<Bid>();
		bids = getDao().findAll();
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(bids.isEmpty()) {
			return null;
		} else {
			return bids;
		}
	}

	@Override
	public List<Bid> getAllBidsByOwner(Integer ownerId) {
		List<Bid> bids = new ArrayList<Bid>();
		bids = dao.findAllBidsByOwner(ownerId);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(bids.isEmpty()) {
			return null;
		} else {
			return bids;
		}
	}

	@Override
	public List<Bid> getAllBidsByItem(Integer itemId) {
		List<Bid> bids = new ArrayList<Bid>();
		bids = dao.findAllBidsByItem(itemId);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(bids.isEmpty()) {
			return null;
		} else {
			return bids;
		}
	}

	@Override
	public Bid getBidById(Integer id) {
		Bid bid = getDao().findOne(id);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		return bid;
	}

	@Override
	public Bid createBid(BidForm form) {
		Bid bid = dao.createBid(form);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(bid == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return bid;
		}
	}

	@Override
	public Bid updateBid(Integer id, BidForm form) {
		Bid bid = dao.updateBid(id,form);
		
		// TODO Change to check if returned object is null, 
		// Since null object means that there was no object found on the db
		if(bid == null) {
			// TODO Return something better instead of null
			return null;
		} else {
			return bid;
		}
	}
	
	@Override
	public Bid deleteBidById(Integer id) {
		Bid bid = getDao().findOne(id);
		getDao().deleteById(id);
		return bid;
	}

}
