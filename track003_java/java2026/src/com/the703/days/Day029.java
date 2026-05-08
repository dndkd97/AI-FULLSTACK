package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Player{
	private String name;
	private int score;
	public Player() { super();  }
	public Player(String name, int score) { super(); this.name = name; this.score = score; }
	@Override public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	@Override public int hashCode() { return Objects.hash(name, score); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getScore() { return score; } public void setScore(int score) { this.score = score; }
	
}

public class Day029 {
	public static void main(String[] args) {
		
		System.out.println("List");
		List<Player> players = new ArrayList<>();
		players.add(new Player("Mario", 1200));
		players.add(new Player("Luigi", 1500));
		players.add(new Player("Peach", 1800));
		players.add(new Player("Bowser", 900));
		players.add(new Player("Bowser", 900));
		
//		players.sort(new Comparator<Player>() { //익명클래스-오름차순
// @Override public int compare(Player o1, Player o2) {  return Integer.compare(o1.getScore(), o2.getScore()); }   }); 
		
//		players.sort((o1,o2)->Integer.compare(o2.getScore(),o1.getScore() ));//람다식-내림차순
		
		players.sort(Comparator.comparingInt(Player::getScore)); //참조
		
		//Q3. List-중복허용
		int cnt =0;
		for(int i=0; i<players.size(); i++) {
			System.out.println(++cnt+ "\t"+players.get(i).getName()+"\t"+players.get(i).getScore());
		}
		
		System.out.println("Set");
		Set<Player> setPlayers = new HashSet<>();
		setPlayers.add(new Player("Mario", 1200));
		setPlayers.add(new Player("Luigi", 1500));
		setPlayers.add(new Player("Peach", 1800));
		setPlayers.add(new Player("Bowser", 900));
		setPlayers.add(new Player("Bowser", 900));
		cnt=0;
		Iterator<Player> iter = setPlayers.iterator(); //줄세우기
		while(iter.hasNext()) { // 처리대상의 유무
			Player p = iter.next(); //하나씩 꺼내오기
			System.out.println(++cnt+ "\t"+p.getName()+"\t"+p.getScore());
		}
		
		System.out.println("Map");
		Map<String,Player> mapPlayers = new LinkedHashMap<>();
		mapPlayers.put("mario", new Player("Mario", 1200));
		mapPlayers.put("luigi", new Player("Luigi", 1500));
		mapPlayers.put("peach", new Player("Peach", 1800));
		mapPlayers.put("bowser", new Player("Bowser", 900));
		
		for(Entry<String, Player> p : mapPlayers.entrySet()) {
			System.out.println(p.getKey()+"\t"+p.getValue().getName()+"\t"+p.getValue().getScore());}
		
	}
}
