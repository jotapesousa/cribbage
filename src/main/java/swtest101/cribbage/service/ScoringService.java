package swtest101.cribbage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;

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
		
		Integer actual;
		Integer previous;
		for (int i=1; i < cards.size(); i++) {
			actual = cards.get(i).getRank();
			previous = cards.get(i-1).getRank();
			
			if (actual.equals(previous + 1)) {
				point += 1;
				System.out.println(point);
			} else {
				if (point >= 3) {
					score = point;
					point = 1;
				} else {
					point = 1;
				}
			}
				
		}
		
		return score;
	}
	
	static Integer calculateFlushScore(List<Card> cards) {
		
		Integer score = 0;
		Map<Suit, Integer> counter = new HashMap<Suit, Integer>();
		
		for (Card card : cards) {
			if (!counter.containsKey(card.getSuit())) {
				counter.put(card.getSuit(), 0);
			}
			counter.put(card.getSuit(), counter.get(card.getSuit())+1);
			
			if (counter.get(card.getSuit()) >= 4) {
				score = counter.get(card.getSuit());
			}
		}
		
		return score;
	}
	
	static Integer calculateNobScore(List<Card> cards) {		
	
		Card startCard = cards.get(0);
		
		for (int i=1; i < cards.size(); i++) {
			if (cards.get(i).getRank() == 11 && cards.get(i).getSuit().equals(startCard.getSuit())) {
				return 1;
			}
		}		
		return 0;
	}
	
	static Integer calculateFifteenScore(List<Card> cards) {
		
		Integer score = 0;
		Integer points;
		
		cards.sort((o1, o2) -> o2.getRank().compareTo(o1.getRank()));
		
		for (int i=0; i < cards.size(); i++) {
			
			points = 0;
			Integer cardRank = cards.get(i).getRank();
			
			if (cardRank == 13 || cardRank == 12 || cardRank == 11) {
				points += 10;
			} else {
				points += cardRank;
			}
			
			int j = i+1;
			while (j < cards.size()) {
				if ((points + cards.get(j).getRank()) < 15 )
					points += cards.get(j).getRank();
				else if (points + cards.get(j).getRank() == 15)
					score += 2;
				j++;
			}
		}
		return score;
	}

	public static Integer calculateScore(String handOfCards) {
		
		Integer totalScore = 0;
		
		List<Card> cards = ParseStringService.parseToListOfCards(handOfCards);
		
		totalScore += calculatePairScore(cards);
		totalScore += calculateStraightScore(cards);
		totalScore += calculateFlushScore(cards);
		totalScore += calculateNobScore(cards);
		totalScore += calculateFifteenScore(cards);
		
		return totalScore;
	}
}
