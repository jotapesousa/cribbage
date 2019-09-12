package swtest101.cribbage.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { ParseToCardExceptionalTest.class, ParseToCardTest.class, ParseToListOfCardsTest.class
		, ParseToListOfStringsExceptionalTest.class, ParseToListOfStringsTest.class, ScoringServicePairTest.class
		, ScoringServiceStraightTest.class, ScoringServiceFlushTest.class, ScoringServiceNobTest.class
		, ScoringServiceFifteenTest.class})
public class AllTests {

}
