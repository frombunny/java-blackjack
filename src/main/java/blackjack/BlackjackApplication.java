package blackjack;

import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BlackjackApplication {
    private static final int FACE_CARD_SCORE = 10;
    private static final Set<String> faceCards = Set.of("K", "Q", "J");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        String[] cards = inputView.getCards();
        List<Integer> scores = new ArrayList<>();

        for (String card : cards) {
            int score = getScoreFromCard(card);
            scores.add(score);
        }

        int totalScore = scores.stream()
                .mapToInt(Integer::intValue)
                .sum();

        outputView.printTotalScore(totalScore);
    }

    private static int getScoreFromCard(String card) {
        if (faceCards.contains(card)) {
            return FACE_CARD_SCORE;
        }

        try {
            return Integer.parseInt(card);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }
}
