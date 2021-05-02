import Fields.*;
import Services.*;


public class Main {

	public static void main(String[] args) {

		Users user1=new Users();
		user1.setUserName("Ertugrul");
		user1.setUserSurname("Aslan");
		user1.setuserID(1);
		user1.setUserBirthDate(1994);
		user1.setUserIdentity("12345678901");
		user1.setNickName("ErtAsL");
		UserManager userManager1 = new UserManager();
		userManager1.register(user1);
		userManager1.update(user1, "ErtLeo");
		
		Users user2=new Users();
		user2.setUserName("Beyza");
		user2.setUserSurname("Kurcalý");
		user2.setuserID(2);
		user2.setUserBirthDate(1999);
		user2.setUserIdentity("12525678901");
		user2.setNickName("BeyzKurc");
		UserManager userManager2 = new UserManager();
		userManager2.register(user2);
		
		Games game1 = new Games();
		game1.setGameID(1);
		game1.setGameName("Battlefield 5");
		game1.setGamePrice(200);
		game1.setGameType("Multiplayer FPS");
		GameManager gameManager1 = new GameManager();
		gameManager1.add(game1);
		
		Games game2 = new Games();
		game2.setGameID(2);
		game2.setGameName("MotoGP 2021");
		game2.setGamePrice(120);
		game2.setGameType("Race");
		GameManager gameManager2 = new GameManager();
		gameManager2.add(game2);
		
		Campaigns campaign1 = new Campaigns();
		campaign1.setCampaignDetail("Yaz kampanyasý");
		campaign1.setCampaignID(1);
		campaign1.setCampaignSaleRate(20);
		CampaignManager campaignManager1 = new CampaignManager();
		campaignManager1.create(campaign1);
		
		System.out.println("\n Kampanya uygulanýyor...");
		gameManager1.applyCampaign(game1, campaign1);
		gameManager2.applyCampaign(game2, campaign1);
		
		System.out.println("\n Kampanya sonrasý fiyatlar : ");
		System.out.println(""
				+ game1.getGameName() + ": " + game1.getGamePrice() + "\n" 
				+ game2.getGameName() + ": " + game2.getGamePrice() + "\n" );
		
		MarketManager marketManager1 = new MarketManager();
		marketManager1.buyWithCard(user1, game1, 123215512); // User1, game1'i satýn aldý.
		System.out.println(user1.getNickName() + ", " + user1.getGameLibrary() + " satýn aldý.");
		marketManager1.buyWithCard(user2, game2, 122344); // User2, game2', satýn aldý.
		System.out.println(user2.getNickName() + ", " + user2.getGameLibrary() + " satýn aldý.");
	}

}
