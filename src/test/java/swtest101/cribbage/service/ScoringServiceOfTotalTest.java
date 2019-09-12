package swtest101.cribbage.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ScoringServiceOfTotalTest {
	
	@Parameters(name = "[{0}]_Should_Return_{1} - {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JHASKC9D0H", 3, "1 Straight"},
			{"AHASKC5DJH", 7, "1 pair, 1 nob, 2 fifteen"},
			{"AH2S3D4S5H", 5, "1 Straight, 1 fifteen"},
		});
	}
	
	@Parameter(0)
	public String handOfStrings;
	
	@Parameter(1)
	public Integer expectedTotalScore;
	
	@Parameter(2)
	public String textTest;

	@Test
	public void ScoringServiceTotalTest() {
		// config
		
		// acao
		Integer totalScore = ScoringService.calculateScore(handOfStrings);
		
		// verif
		assertEquals(expectedTotalScore, totalScore);
	}

}
