package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackjackApplication {
    private static final int FACE_CARD_SCORE = 10;
    private static final Set<String> faceCards = Set.of("K", "Q", "J");

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("점수를 합산할 카드를 공백을 두고 입력하세요 >> ");
        String input = bufferedReader.readLine();

        String[] cards = input.split(" ");

        List<Integer> scores = new ArrayList<>();

        for (String card : cards) {
            int score = getScoreFromCard(card);
            scores.add(score);
        }

        int totalScore = scores.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("점수는 " + totalScore + "점 입니다.");
    }

    private static int getScoreFromCard(String card){
        if(faceCards.contains(card)){
            return FACE_CARD_SCORE;
        }

        try {
            return Integer.parseInt(card);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }
}
