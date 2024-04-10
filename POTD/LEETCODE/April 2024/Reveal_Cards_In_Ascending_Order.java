// You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
// You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
// You will do the following steps repeatedly until all cards are revealed:
// Take the top card of the deck, reveal it, and take it out of the deck.
// If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
// If there are still unrevealed cards, go back to step 1. Otherwise, stop.
// Return an ordering of the deck that would reveal the cards in increasing order.
// Note that the first entry in the answer is considered to be the top of the deck.

// Date: 10 April 2024

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Arrays.sort(deck);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(deck[n - 1]);

        for (int i = n - 2; i >= 0; --i) {
            dq.addFirst(dq.getLast());
            dq.pollLast();
            dq.addFirst(deck[i]);
        }

        for (int i = 0; i < n; ++i)
            deck[i] = dq.pollFirst();

        return deck;
    }
}



