package blackjack;

import blackjack.card.Cards;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class BlackjackApplication {
    private static final int FACE_CARD_SCORE = 10;
    private static final Set<String> faceCards = Set.of("K", "Q", "J");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        String[] cardsInput = inputView.getCards();
        Cards cards = new Cards(Arrays.stream(cardsInput).toList());

        int totalScore = cards.getSum();

        outputView.printTotalScore(totalScore);
    }
}
