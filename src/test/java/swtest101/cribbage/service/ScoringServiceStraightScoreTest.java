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

@RunWith(Parameterized.class)
public class ScoringServiceStraightScoreTest {

	@Parameters(name = "{0}_Should_Return_{1} - {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JHAS0D9SKH", 0, "None Straight"},
			{"AH2S3D9SKH", 3, "One Straight of three cards"},
			{"JHAS8C9S0H", 3, "One Straight of four cards"},
			{"AH2S4D5S7H", 0, "None Straight"},
			{"0HJSQDKS0H", 3, "One Straight of three cards"},
			{"AH2S3D4S5H", 5, "One Straight of five cards"},
			{"AHAS0D0S0H", 0, "None Straight"}
		});
	}
	
	@Parameter(0)
	public String handOfStrings;
	
	@Parameter(1)
	public Integer expectedScore;
	
	@Parameter(2)
	public String textTest;

	
//	@Parameter(2)
//	public static String textTest;
	
	@Test
	public void testCalculateStraightScore() {
		
		// configuracao
		List<Card> cards = ParseStringService.parseToListOfCards(handOfStrings);
		
		// acao
		Integer score = ScoringService.calculateStraightScore(cards); 
//				ScoringService.calculateScore(handOfCards);
	
				
		// verificacao
		assertEquals(expectedScore, score);
		// joao paulo
	}

}
