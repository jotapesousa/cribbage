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
public class ScoringServiceFifteenTest {

	@Parameters(name = "{0}_Should_Return_{1} - {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JHAS0D9SKH", 0, "!= 15 points"},
			{"AH2H3H2S0C", 6, "3x = 15 points"},
			{"JCAC8C9S0C", 0, "!= 15 points"},
			{"AC2C0C5C7C", 4, "2x = 15 points"},
			{"0HJSQDKS0H", 0, "!= 15 points"},
			{"0H2S7D4S5H", 2, "1x = 15 points"},
			{"2D3H5CJSQD", 8, "4x = 15 points"},
			{"5D5S0CJHKH", 12, "6x = 15 points"},
			{"5D5S5H5C0S", 16, "8x = 15 points"},
			{"AH2S3D4S5H", 2, "1x = 15 points"},
		});
	}
	
	@Parameter(0)
	public String handOfStrings;
	
	@Parameter(1)
	public Integer expectedScore;
	
	@Parameter(2)
	public String textTest;

	
	@Test
	public void testCalculateFifteenScore() {
		
		// Configuraçao
		List<Card> cards = ParseStringService.parseToListOfCards(handOfStrings);
		
		// Acao
		Integer score = ScoringService.calculateFifteenScore(cards); 
	
				
		// Verificacao
		assertEquals(expectedScore, score);
	}

}
