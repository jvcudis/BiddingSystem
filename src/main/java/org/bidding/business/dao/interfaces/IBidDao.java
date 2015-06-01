package org.bidding.business.dao.interfaces;

import java.util.List;

import org.bidding.business.dao.common.IOperations;
import org.bidding.business.models.Bid;
import org.bidding.web.forms.BidForm;

public interface IBidDao extends IOperations<Bid> {
    
	// TODO Add method description later
	
	List<Bid> findAllBidsByOwner(Integer ownerId);
	List<Bid> findAllBidsByItem(Integer itemId);
	Bid createBid(BidForm form);
	Bid updateBid(Integer id, BidForm form);
}
