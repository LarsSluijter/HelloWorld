import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import constant.Region;
import dto.Champion.Champion;
import dto.Champion.ChampionList;
import dto.Stats.RankedStats;
import dto.Summoner.Summoner;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;


public class InfoPanel extends JPanel {

	static JTextArea textArea = new JTextArea();
	static String summonerName = "";
	static long level = 0;
	
	public InfoPanel(){
		textArea.setBackground(this.getBackground());
		this.add(textArea);
		textArea.setText("Test");
	}
	
	public static void changeTextArea(){
		RiotApi api = new RiotApi("839b7472-2b5c-4d3a-a0d7-cf2caf53530f");
		
		Map<String, Summoner> summoners;
		try {
			summonerName = summonerName.replaceAll(" ", "");
			summoners = api.getSummonerByName(Region.EUW, summonerName);
			Summoner summoner = summoners.get(summonerName.toLowerCase());
			summonerName = summoner.getName();
			level = summoner.getSummonerLevel();
			
			//RankedStats rankedStats = api.getRankedStats(summoner.getId());
			
			textArea.setText(
					"Summoner: " + '\n' + summonerName + '\n' + '\n' +
					"Level:" + '\n' + level
					);
			return;
		} catch (Exception e) {
			textArea.setText("");
			e.printStackTrace();
		}
		
        //int id = 5908;
        //String[] ids = new String[]{"5908"};
        //String[] teamIds = new String[]{"TEAM-1c3a53f0-fbd4-11e3-9c89-782bcb4d1861"};
        //Season season = Season.SEASON_4;
        //LeagueType leagueType = LeagueType.T5;
        //int summonerSpellId = 1;

		
        /*Map<String, Summoner> a = api.getSummonerByName(names, region);
        int id = (int) a.get(summoner.toLowerCase()).getId();
        RecentGames b = api.getGame(id, region);         
        level = a.get(summoner.toLowerCase()).getSummonerLevel();
        ArrayList<Games> games = new ArrayList<Games>();
        games = b.getGames();
        System.out.println(games.get(0).getChampionId());*/
                  
        //textArea.setFont(arg0);          
		
	}
	
}
