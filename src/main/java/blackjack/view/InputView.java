package blackjack.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCards() {
        System.out.print("점수를 합산할 카드를 공백을 두고 입력하세요 >> ");
        String input = scanner.nextLine();

        return input.split(" ");
    }
}
