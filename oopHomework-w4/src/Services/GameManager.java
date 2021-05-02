package Services;

import Fields.Campaigns;
import Fields.Games;
import Interfaces.GameServices;

public class GameManager implements GameServices {

	@Override
	public void add(Games game) {
		System.out.println("Oyun eklendi \n"
				+ "Oyun adý : " + game.getGameID() + "- " + game.getGameName() + " --- " + "Fiyatý : " + game.getGamePrice());
		
	}

	@Override
	public void delete(Games game) {
		System.out.println("Oyun Silindi");
		game.setGameID(0);
		game.setGameName(null);
		game.setGamePrice(0);
		game.setGameType(null);
	}

	@Override
	public void applyCampaign(Games game, Campaigns campaign) {
		int newPrice = game.getGamePrice()*(100-campaign.getCampaignSaleRate())/100;
		game.setGamePrice(newPrice);	
	}


}
