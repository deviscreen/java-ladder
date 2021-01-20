package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    private LadderResult ladderResult;
    @BeforeEach
    void setup(){
        this.ladderResult = new LadderResult();
    }

    @Test
    void inputResultsTest(){
        String inputResults = "꽝,5000,3000,꽝";
        ladderResult.setResults(inputResults);

        List<String> results =  ladderResult.loadResults();

        assertThat(results).hasSize(4);

    }

}