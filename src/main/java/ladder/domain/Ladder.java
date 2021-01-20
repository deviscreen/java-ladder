package ladder.domain;

import ladder.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private List<Name> names;

    private LadderResult ladderResult;
    private List<Line> lines;


    public void setParticipateNames(String names) {
        String[] strings = StringUtil.splitNames(names);
        this.names =Arrays.asList(strings).stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Line> generateLadderLine(int ladderHeight) {
        int countOfName = this.names.size();
        List<Line> generatedLine = IntStream.iterate(0, i -> i++)
                .mapToObj((element) -> new Line(countOfName))
                .limit(ladderHeight).collect(Collectors.toList());
        this.lines = generatedLine;
        return generatedLine;
    }

    public List<Line> resultLadder(){
        return new ArrayList<>(this.lines);
    }

    public List<Name> participateNames() {
        return Collections.unmodifiableList(this.names);
    }
    public void setLadderResult(String ladderResults) {
        LadderResult ladderResult = new LadderResult();
        ladderResult.setResults(ladderResults);
        this.ladderResult = ladderResult;
    }

    public LadderResult getLadderResults(){
        return this.ladderResult;
    }
}
