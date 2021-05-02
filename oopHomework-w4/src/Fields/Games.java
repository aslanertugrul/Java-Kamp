package Fields;

public class Games {

	int gameID;
	String gameName;
	String gameType;
	int gamePrice;
	
	public Games () {
		
	};
	
	public Games(int gameID, String gameName, String gameType, int gamePrice) {
		super();
		this.gameID = gameID;
		this.gameName = gameName;
		this.gameType = gameType;
		this.gamePrice = gamePrice;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(int gamePrice) {
		this.gamePrice = gamePrice;
	}
	
	
	
}
