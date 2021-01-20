package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    private Ladder ladder;


    @Test
    void ladderParticipateNames() {
        String names = "morr,dani";
        ladder = new Ladder();
        ladder.setParticipateNames(names);
        String[] split = names.split(",");

        List<Name> participateNames = ladder.participateNames();

        assertThat(participateNames).hasSize(split.length);

    }

    @Test
    void generateLadderLine() {
        String names = "morr,dani,dell";
        int ladderHeight = 4;
        ladder = new Ladder();
        ladder.setParticipateNames(names);
        List<Line> lines = ladder.generateLadderLine(4);

        assertThat(lines).hasSize(ladderHeight);
    }

    @Test
    void setLadderResult() {
        String inputResults = "꽝,5000,3000,꽝";
        int expectResultSize = inputResults.split(",").length;
        ladder = new Ladder();
        ladder.setLadderResult(inputResults);

        LadderResult ladderResults = ladder.getLadderResults();

        assertThat(ladderResults.loadResults()).hasSize(expectResultSize);

    }

    @Test
    void getLadderResults() {
        String inputResults = "꽝,5000,3000,꽝";
        String [] expectResultArr = inputResults.split(",");

        ladder = new Ladder();
        ladder.setLadderResult(inputResults);

        LadderResult ladderResults = ladder.getLadderResults();
        List<String> results = ladderResults.loadResults();

        assertAll( 
                ()->assertThat(results.get(0)).isEqualTo(expectResultArr[0]),
                ()->assertThat(results.get(1)).isEqualTo(expectResultArr[1]),
                ()->assertThat(results.get(2)).isEqualTo(expectResultArr[2]),
                ()->assertThat(results.get(3)).isEqualTo(expectResultArr[3])
        );
    }
}