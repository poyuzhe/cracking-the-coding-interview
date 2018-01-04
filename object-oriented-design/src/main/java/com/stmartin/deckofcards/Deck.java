package com.stmartin.deckofcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Deck {
    protected static final Card[] template = new Card[52];
    static {
        CardColor[] colors = new CardColor[]{CardColor.HEART, CardColor.SPADE, CardColor.CLUB, CardColor.DIAMOND};
        CardRank[] ranks = new CardRank[]{CardRank.ACE, CardRank.TWO, CardRank.THREE, CardRank.FOUR, CardRank.FIVE,
                CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT, CardRank.NINE, CardRank.TEN, CardRank.JACK,
                CardRank.QUEEN, CardRank.KING};
        int index = 0;
        for (CardColor color : colors) {
            for (CardRank rank : ranks) {
                template[index] = new Card(color, rank);
                index++;
            }
        }
    }
    private List<Card> currentDeck;

    public Deck() {
        reShuffle(template);
    }

    public Card dealFromTop() {
        if (isDeckEmpty()) {
            return null;
        }
        return currentDeck.remove(currentDeck.size() - 1);
    }

    public void reShuffle(Card[] template) {
        currentDeck = generateRandomDeckFromTemplate(template);
    }

    public Card dealRandomly() {
        if (isDeckEmpty()) {
            return null;
        }
        int randomIndex = new Random().nextInt(currentDeck.size());
        return currentDeck.remove(randomIndex);
    }

    public List<Card> generateRandomDeckFromTemplate(Card[] template) {
        if (template == null || template.length == 0) {
            return null;
        }
        List<Card> result = new ArrayList<>(template.length);
        Random random = new Random();
        List<Card> candidates = Arrays.asList(template);
        int index = 0;
        while (index < template.length) {
            int randomNum = random.nextInt(candidates.size());
            Card nextCard = candidates.remove(randomNum);
            result.add(nextCard);
            index++;
        }
        return result;
    }

    private boolean isDeckEmpty() {
        return currentDeck == null || currentDeck.size() == 0;
    }
}
