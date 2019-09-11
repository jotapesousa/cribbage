package swtest101.cribbage.service;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.exception.InputParseException;
//import swtest101.cribbage.exception.NullArgumentException;

import static swtest101.cribbage.service.ParseStringService.*;

@RunWith(Parameterized.class)
public class ParseToListOfStringsExceptionalTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"", InputParseException.class, INVALID_CARDS_SIZE_ERROR_MSG},
			{"ASJH", InputParseException.class, INVALID_CARDS_SIZE_ERROR_MSG},
			{"ASJHKD0S9HAS", InputParseException.class, INVALID_CARDS_SIZE_ERROR_MSG},
//			{null, NullArgumentException.class, NULL_ARGUMENT_PARSE_ERROR_MSG}
		}); 
	}	
	@Parameter(0)
	public static String handOfStrings;
	@Parameter(1)
	public Class<? extends Throwable> expectedException;
	@Parameter(2)
	public static String errorMessage;
	
	@Rule
	public ExpectedException e = ExpectedException.none();

	@Test
	public void testParseInvalidStringSize() {
		// Configuração
		e.expect(expectedException);
		e.expectMessage(errorMessage);
		
		// Ação
		ParseStringService.parseToListOfStringCards(handOfStrings);
		
		// Verificação
	}

}
