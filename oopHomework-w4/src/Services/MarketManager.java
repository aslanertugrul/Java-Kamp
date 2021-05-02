package Services;


import Interfaces.*;
import Utils.cardValidation;
import Fields.*;


public class MarketManager implements MarketServices {


	@Override
	public void buyWithCard(Users user, Games game, int cardID) {
		
		boolean check = cardValidation.validateBank(user, cardID);
		
		if (check=true) {
			user.setGameLibrary(game.getGameName());
		}
		
	}

}
