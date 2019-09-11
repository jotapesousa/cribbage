package swtest101.cribbage.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import swtest101.cribbage.entity.Card;

public class ScoringService {
	
	static Integer calculatePairScore(List<Card> cards) {
		
		Integer score = 0;
		
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		
		for (Card card : cards) {
			if (!counter.containsKey(card.getRank())) {
				counter.put(card.getRank(), 0);
			}
			counter.put(card.getRank(), counter.get(card.getRank())+1);
			
			if (counter.get(card.getRank()) == 2) {
				score += 2;
			}
			if (counter.get(card.getRank()) == 4) {
				score += 2;
			}
		}
		
		return score;
	}
	
	static Integer calculateStraightScore(List<Card> cards) {
		
		Integer score = 0;
		Integer point = 1;
		
		cards.sort((o1, o2) -> o1.getRank().compareTo(o2.getRank()));
		
		for (int i=1; i < cards.size(); i++) {
			Integer actual = cards.get(i).getRank();
			Integer previous = cards.get(i-1).getRank();
			
			if (actual.equals(previous + 1)) {
				point += 1;
			} else {
				if (point >= 3) {
					score = point;
					point = 1;
				} else {
					score = 0;
					point = 1;
				}
			}
				
		}
		
		return score;
	}
	
	static Integer calculateFlushScore(List<Card> cards) {		
		
		return null;
	}
	
	static Integer calculateNobScore(List<Card> cards) {		
		
		return null;
	}
	
	static Integer calculateFifteenScore(List<Card> cards) {		
		
		return null;
	}

	public static Integer calculateScore(String handOfCards) {
		
		return null;
	}
}
