package swtest101.cribbage.service;

import java.util.List;

import swtest101.cribbage.entity.Card;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String handOfStrings = "JHASKD9S5D";
		List<Card> cards = ParseStringService.parseToListOfCards(handOfStrings);
		
		cards.sort((o1, o2) -> o1.getRank().compareTo(o2.getRank()));
		
		for (Card card : cards) {
			System.out.println(card.getRank() + " " + card.getSuit() + "\n");
		}

	}

}
