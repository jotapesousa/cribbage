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

@RunWith(Parameterized.class)
public class ParseToListOfStringsTest {
	
	@Parameters(name = "{0}_ShouldReturn_[{1}-{2}-{3}-{4}-{5}]")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"JH5C4SQDAH", "JH", "5C", "4S", "QD", "AH"},
			{"AS0C9DKHAC", "AS", "0C", "9D", "KH", "AC"},
			{"JDAS3C2H0S", "JD", "AS", "3C", "2H", "0S"}
		});
	}
	
	
	@Parameter(0)
	public static String handOfCards;
	
	@Parameter(1)
	public static String expectedStartStringPair;
	
	@Parameter(2)
	public static String expectedSecondStringPair;
	
	@Parameter(3)
	public static String expectedThirdStringPair;
	
	@Parameter(4)
	public static String expectedFourthStringPair;
	
	@Parameter(5)
	public static String expectedFifthStringPair;
	
	
	@Test
	public void ParseToListOfStringsTest01() {
		// configuracao		
		
		//acao
		List<String> cards = ParseStringService.parseToListOfStringCards(handOfCards);
		
		//verificacao
		assertEquals(10, handOfCards.length());
		assertEquals(5, cards.size());
		assertEquals(expectedStartStringPair, cards.get(0));
		assertEquals(expectedSecondStringPair, cards.get(1));
		assertEquals(expectedThirdStringPair, cards.get(2));
		assertEquals(expectedFourthStringPair, cards.get(3));
		assertEquals(expectedFifthStringPair, cards.get(4));
	}
}
