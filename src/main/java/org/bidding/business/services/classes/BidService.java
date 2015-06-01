package org.bidding.business.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.bidding.aspect.annotations.PerfLog;
import org.bidding.business.dao.common.IOperations;
import org.bidding.business.dao.interfaces.IBidDao;
import org.bidding.business.models.Bid;
import org.bidding.business.services.common.GenericService;
import org.bidding.business.services.interfaces.IBidService;
import org.bidding.web.forms.BidForm;
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
	@PerfLog
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
	@PerfLog
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
	@PerfLog
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
	@PerfLog
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
	@PerfLog
	public Bid deleteBidById(Integer id) {
		Bid bid = getDao().findOne(id);
		getDao().deleteById(id);
		return bid;
	}

}
