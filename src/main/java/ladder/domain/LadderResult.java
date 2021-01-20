package ladder.domain;

import ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;

public class LadderResult {

    private List<String> results;


    public void setResults(String results) {
        this.results = StringUtil.splitResults(results);
    }

    public List<String> loadResults() {
        return Collections.unmodifiableList(this.results);
    }
}
