package org.fpt.orm.services.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.Bid;
import org.fpt.web.forms.BidForm;

public interface IBidService extends IOperations<Bid> {
    
	// TODO Add method description later
	
	List<Bid> getAllBids();
	List<Bid> getAllBidsByOwner(Integer ownerId);
	List<Bid> getAllBidsByItem(Integer itemId);
	Bid getBidById(Integer id);
	Bid createBid(BidForm form);
	Bid updateBid(Integer id, BidForm form);
	Bid deleteBidById(Integer id);
	
}
