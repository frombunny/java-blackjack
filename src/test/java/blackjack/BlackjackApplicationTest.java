package blackjack;

import blackjack.card.Cards;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BlackjackApplicationTest {
    @Test
    void 카드의_합을_계산한다(){
        Cards cards = new Cards(List.of("2", "3", "5"));

        int sum = cards.getSum();

        assertThat(sum).isEqualTo(10);
    }

    @Test
    void 페이스카드는_10점으로_계산한다() {
        Cards cards = new Cards(List.of("K", "Q", "J"));

        int sum = cards.getSum();

        assertThat(sum).isEqualTo(30);
    }

    @Test
    void 잘못된_카드값이면_예외가_발생한다() {
        Cards cards = new Cards(List.of("10", "A", "3"));

        assertThatThrownBy(cards::getSum)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
