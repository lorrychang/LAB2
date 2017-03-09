package pkgPokerBLL;

import static org.junit.Assert.*;
import org.junit.Test;
import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;


public class TestHands {

	@Test
	public void TestFullHouse() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
		
		
	}


@Test
public void TestRoyalFlush() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
	h.AddCardToHand(new Card(eRank.KING,eSuit.SPADES));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.SPADES));
	h.AddCardToHand(new Card(eRank.JACK,eSuit.SPADES));
	h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a Royal Flush
	assertEquals(eHandStrength.RoyalFlush.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	Royal Flush has 5 kickers.
	assertEquals(eRank.ACE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.KING.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.QUEEN.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TEN.getiRankNbr(),h.getHandScore().getKickers().size());
		
}

@Test
public void TestStraightFlush() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.ACE,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.KING,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.TEN,eSuit.HEARTS));		
	h.EvaluateHand();
	
	//	Hand better be a Straight Flush
	assertEquals(eHandStrength.StraightFlush.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	Full House has no kickers.
	assertEquals(eRank.ACE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.KING.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.QUEEN.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TEN.getiRankNbr(),h.getHandScore().getKickers().size());
	
	
}

@Test
public void TestFourOfAKind() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.ACE,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
	h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.HEARTS));		
	h.EvaluateHand();
	
	//	Hand better be a Four Of A Kind
	assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	HI hand better be 'Ace'
	assertEquals(eRank.ACE.getiRankNbr(),
			h.getHandScore().getHiHand().getiRankNbr());
	
	//	LO hand better be 'Two'
	assertEquals(eRank.TWO.getiRankNbr(),
			h.getHandScore().getLoHand().getiRankNbr());
	
	
}

@Test
public void TestFlush() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));		
	h.EvaluateHand();
	
	//	Hand better be a Flush
	assertEquals(eHandStrength.Flush.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());

	
	//	Full House has no kickers.
	assertEquals(eRank.THREE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.FIVE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.EIGHT.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.NINE.getiRankNbr(),h.getHandScore().getKickers().size());
	
	
}

@Test
public void TestStraight() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a Straight
	assertEquals(eHandStrength.Straight.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	Full House has no kickers.
	assertEquals(eRank.SIX.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.FIVE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.THREE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TWO.getiRankNbr(),h.getHandScore().getKickers().size());
	
	
}

@Test
public void TestThreeOfAKind() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.FIVE,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a Three Of A Kind
	assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	HI hand better be 'Queen'
	assertEquals(eRank.QUEEN.getiRankNbr(),
			h.getHandScore().getHiHand().getiRankNbr());
	
	//	Full House has no kickers.
	assertEquals(eRank.FIVE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TWO.getiRankNbr(),h.getHandScore().getKickers().size());
	
}

@Test
public void TestTwoPair() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a Two Pair
	assertEquals(eHandStrength.TwoPair.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	HI hand better be 'Queen'
	assertEquals(eRank.QUEEN.getiRankNbr(),
			h.getHandScore().getHiHand().getiRankNbr());
	
	//	LO hand better be 'Two'
	assertEquals(eRank.TWO.getiRankNbr(),
			h.getHandScore().getLoHand().getiRankNbr());
	
	//	Full House has no kickers.
	assertEquals(eRank.SEVEN.getiRankNbr(),h.getHandScore().getKickers().size());
	
	
}

@Test
public void TestPair() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a Pair
	assertEquals(eHandStrength.Pair.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	HI hand better be 'Queen'
	assertEquals(eRank.SEVEN.getiRankNbr(),
			h.getHandScore().getHiHand().getiRankNbr());
	
	
	//	Full House has no kickers.
	assertEquals(eRank.QUEEN.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.THREE.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TWO.getiRankNbr(),h.getHandScore().getKickers().size());
	
	
}

@Test
public void TestHighCard() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.QUEEN,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.EIGHT,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a High Card
	assertEquals(eHandStrength.HighCard.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	Full House has no kickers.
	assertEquals(eRank.QUEEN.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TEN.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.EIGHT.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.SEVEN.getiRankNbr(),h.getHandScore().getKickers().size());
	assertEquals(eRank.TWO.getiRankNbr(),h.getHandScore().getKickers().size());
	
}

@Test
public void TestAesAndEights() {
	
	Hand h = new Hand();
	h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
	h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.EIGHT,eSuit.HEARTS));
	h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
	h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
	h.EvaluateHand();
	
	//	Hand better be a Aces And Eights
	assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
			h.getHandScore().getHandStrength().getHandStrength());
	
	//	HI hand better be 'Queen'
	assertEquals(eRank.ACE.getiRankNbr(),
			h.getHandScore().getHiHand().getiRankNbr());
	
	//	LO hand better be 'Two'
	assertEquals(eRank.EIGHT.getiRankNbr(),
			h.getHandScore().getLoHand().getiRankNbr());
	
	//	Full House has no kickers.
	assertEquals(eRank.TWO.getiRankNbr(),h.getHandScore().getKickers().size());
	
	
}
}
