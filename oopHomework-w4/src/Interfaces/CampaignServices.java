package Interfaces;

import Fields.Campaigns;


public interface CampaignServices {

	abstract void create(Campaigns campaign);
	abstract void delete(Campaigns campaign);
	abstract void update(Campaigns campaign, int newSaleRate);
	
}
