package Services;

import Fields.Campaigns;
import Fields.Games;
import Interfaces.CampaignServices;

public class CampaignManager implements CampaignServices {

	@Override
	public void create(Campaigns campaign) {
		System.out.println("Kampanya eklendi \n"
				+ "�ndirim oran� : %" + campaign.getCampaignSaleRate() + "\n"
						+ "Kampanya ad� : " + campaign.getCampaignDetail());
	}

	@Override
	public void delete(Campaigns campaign) {
		System.out.println("Kampanya silindi");
		campaign.setCampaignDetail(null);
		campaign.setCampaignID(0);
		campaign.setCampaignSaleRate(0);
		
	}

	@Override
	public void update(Campaigns campaign, int newSaleRate) {
		campaign.setCampaignSaleRate(newSaleRate);
	}


}
