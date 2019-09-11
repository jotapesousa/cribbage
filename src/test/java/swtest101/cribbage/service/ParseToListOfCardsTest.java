package swtest101.cribbage.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;

import static swtest101.cribbage.entity.Suit.*;

@RunWith(Parameterized.class)
public class ParseToListOfCardsTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JH5C4SQDAH", 11, HEARTS, 5, CLUBS, 4, SPADES, 12, DIAMONDS, 1, HEARTS},
			{"AS0C9DKHAC", 1, SPADES, 10, CLUBS, 9, DIAMONDS, 13, HEARTS, 1, CLUBS},
			{"JDAS3C2H0S", 11, DIAMONDS, 1, SPADES, 3, CLUBS, 2, HEARTS, 10, SPADES}
		});
	}
	
	@Parameter(0)
	public static String hand;
	
	@Parameter(1)
	public static Integer rank01;
	
	@Parameter(2)
	public static Suit suit01;

	@Parameter(3)
	public static Integer rank02;
	
	@Parameter(4)
	public static Suit suit02;
	
	@Parameter(5)
	public static Integer rank03;
	
	@Parameter(6)
	public static Suit suit03;
	
	@Parameter(7)
	public static Integer rank04;
	
	@Parameter(8)
	public static Suit suit04;
	
	@Parameter(9)
	public static Integer rank05;
	
	@Parameter(10)
	public static Suit suit05;
	
	@Test
	public void ParseValueOfStartCardTest() {
				
		List<Card> handOfCards = ParseStringService.parseToListOfCards(hand);
		
		assertEquals(5, handOfCards.size());
		assertEquals(rank01, handOfCards.get(0).getRank());
		assertEquals(suit01, handOfCards.get(0).getSuit());
		assertEquals(rank02, handOfCards.get(1).getRank());
		assertEquals(suit02, handOfCards.get(1).getSuit());
		assertEquals(rank03, handOfCards.get(2).getRank());
		assertEquals(suit03, handOfCards.get(2).getSuit());
		assertEquals(rank04, handOfCards.get(3).getRank());
		assertEquals(suit04, handOfCards.get(3).getSuit());
		assertEquals(rank05, handOfCards.get(4).getRank());
		assertEquals(suit05, handOfCards.get(4).getSuit());
	}

}
