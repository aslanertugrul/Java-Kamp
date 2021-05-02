package Interfaces;

import Fields.Games;
import Fields.Campaigns;

public interface GameServices {

	abstract void add(Games game);
	abstract void delete(Games game);
	abstract void applyCampaign(Games game, Campaigns campaign);
	
}
