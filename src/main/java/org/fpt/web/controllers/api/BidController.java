package org.fpt.web.controllers.api;

import java.util.List;

import org.fpt.orm.models.Bid;
import org.fpt.orm.services.interfaces.IBidService;
import org.fpt.web.forms.BidForm;
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
public class BidController {
	
	@Autowired
	private IBidService bidService;

	@RequestMapping(method = RequestMethod.GET, value = "/bids")
	public List<Bid> getAllBids() {
		return bidService.getAllBids();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bids/owner/{ownerId}")
	public List<Bid> getAllBidsByOwner(@PathVariable final Integer ownerId) {
		return bidService.getAllBidsByOwner(ownerId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bids/item/{itemId}")
	public List<Bid> getAllBidsByItem(@PathVariable final Integer itemId) {
		return bidService.getAllBidsByItem(itemId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bids/{id}")
	public Bid getBidById(@PathVariable final Integer id) {
		return bidService.getBidById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/bids")
	@ResponseStatus(HttpStatus.CREATED)
    public Bid createBid(@RequestBody final BidForm resource) {
		// TODO Pre-checking conditions, resource must be valid
		return bidService.createBid(resource);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/bids/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Bid updateBid(@PathVariable final Integer id, @RequestBody final BidForm resource) {
		// TODO Pre-checking conditions, resource must be valid
		return bidService.updateBid(id, resource);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/bids/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Bid deleteBidById(@PathVariable final Integer id) {
		return bidService.deleteBidById(id);
    }
}