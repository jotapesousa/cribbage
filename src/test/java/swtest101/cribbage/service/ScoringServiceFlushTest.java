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
public class ScoringServiceFlushTest {

	@Parameters(name = "{0}_Should_Return_{1} - {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JHAS0D9SKH", 0, "No Flush"},
			{"AH2H3H9SKH", 4, "One flush at first four cards"},
			{"JCAC8C9S0C", 4, "One flush at last four cards"},
			{"AC2C0C5C7C", 5, "One flush on five car"},
			{"0HJSQDKS0H", 0, "No flush"},
			{"AH2S3D4S5H", 0, "No flush"}
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
	public void testCalculateFlushScore() {
		
		// Configuraçao
		List<Card> cards = ParseStringService.parseToListOfCards(handOfStrings);
		
		// Acao
		Integer score = ScoringService.calculateFlushScore(cards); 
//				ScoringService.calculateScore(handOfCards);
	
				
		// Verificacao
		assertEquals(expectedScore, score);
	}

}

