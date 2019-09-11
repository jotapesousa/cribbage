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
public class ScoringServicePairScoreTest {

	@Parameters(name = "{0}_Should_Return_{1} - {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JHAS0D9SKH", 0, "No one Pair repeated"},
			{"AHASKD9SKH", 4, "Two pair repeated once"},
			{"JHASAC9SAH", 2, "One pair repeat three times"},
			{"AHASKDASAH", 4, "One pair repated four times"},
			{"0H0S0D0S0H", 4, "One pair repeated five times"},
			{"0H0SKDAS0H", 2, "One pair repeated four times"},
			{"AHAS0D0S0H", 4, "Two pair repeated once"},
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
		final Integer scorePair = ScoringService.calculatePairScore(cards); 
//				ScoringService.calculateScore(handOfCards);
		
		// verificacao
		assertEquals(expectedScore, scorePair);

//
//		assertThat(score, is(equalTo(29)));
	}

}
