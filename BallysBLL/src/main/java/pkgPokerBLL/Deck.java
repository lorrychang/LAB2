package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck()
	{
		
		//	This method will do a for/each, returning each rank in the enum.
		for (eRank Rank : eRank.values()) {
			for ( eSuit Suit : eSuit.values()){
				Card card = new Card(Rank, Suit);
				DeckCards.add(card);
			}
		}
		//Shuffles Deck
		Collections.shuffle(DeckCards);
				
	}
	
	public Card DrawCard()
	{
		//Removes and draws the card in the first place of the array (top of deck)
		return DeckCards.remove(0);	
	}
}
