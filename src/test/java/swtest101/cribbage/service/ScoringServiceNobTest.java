package swtest101.cribbage.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.entity.Card;

@RunWith(Parameterized.class)
public class ScoringServiceNobTest {

	@Parameters(name = "{0}_Should_Return_{1} - {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JHAS0D9SKH", 0, "None"},
			{"AHASKD9SJH", 1, "J of Hearts"},
			{"JHASAC9SAH", 0, "None"},
			{"AHASKDASAH", 0, "None"},
			{"0D0SJD0SAH", 1, "J of Diamonds"},
			{"JC0SJDAS0H", 0, "None"},
			{"KSAS0DJS0H", 1, "J of Spades"},
		});
	}
	
	@Parameter(0)
	public static String handOfStrings;
	
	@Parameter(1)
	public static Integer expectedScore;
	
	@Parameter(2)
	public static String textTest;
	
	@Test
	public void testCalculatePairScore() {
		
		// configuracao
		final List<Card> cards = ParseStringService.parseToListOfCards(handOfStrings);
		
		// acao
		final Integer scorePair = ScoringService.calculateNobScore(cards); 
		
		// verificacao
		assertEquals(expectedScore, scorePair);

	}

}
