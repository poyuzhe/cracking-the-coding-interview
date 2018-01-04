package com.stmartin.deckofcards;

public class Card {
    private CardColor color;
    private CardRank rank;

    public Card(CardColor color, CardRank rank) {
        this.color = color;
        this.rank = rank;
    }

    public CardColor getColor() {
        return color;
    }

    public CardRank getRank() {
        return rank;
    }
}
