package Interfaces;

import Fields.Games;
import Fields.Users;

public interface MarketServices {

	void buyWithCard(Users user, Games game, int cardID);
}
