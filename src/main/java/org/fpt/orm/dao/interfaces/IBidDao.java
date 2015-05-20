package org.fpt.orm.dao.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.Bid;
import org.fpt.web.forms.BidForm;

public interface IBidDao extends IOperations<Bid> {
    
	// TODO Add method description later
	
	List<Bid> findAllBidsByOwner(Integer ownerId);
	List<Bid> findAllBidsByItem(Integer itemId);
	Bid createBid(BidForm form);
	Bid updateBid(Integer id, BidForm form);
}
