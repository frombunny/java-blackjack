package blackjack.card;

import java.util.List;
import java.util.Set;

public class Cards {
    private static final int FACE_CARD_SCORE = 10;
    private static final Set<String> FACE_CARDS = Set.of("K", "Q", "J");

    private final List<String> cards;

    public Cards(List<String> cards) {
        this.cards = cards;
    }

    public int getSum() {
        return cards.stream()
                .mapToInt(this::convertScore)
                .sum();
    }

    private int convertScore(String card) {
        if (FACE_CARDS.contains(card)) {
            return FACE_CARD_SCORE;
        }

        try {
            return Integer.parseInt(card);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }
}
