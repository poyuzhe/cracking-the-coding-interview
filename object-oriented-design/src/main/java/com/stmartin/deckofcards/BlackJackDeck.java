package com.stmartin.deckofcards;

import java.util.List;

public class BlackJackDeck extends Deck {

    public BlackJackDeck() {
        reShuffle(Deck.template);
    }

    public int calculateHandSum(List<Card> hand) {
        if (hand == null || hand.size() == 0) {
            return 0;
        }
        return hand.stream().map(card -> card.getRank().getNumber()).reduce((a, b) -> a + b).orElse(0);
    }
}
