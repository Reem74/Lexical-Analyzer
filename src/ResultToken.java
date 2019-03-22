public class ResultToken implements Comparable<ResultToken> {

    Integer begin , end ;
    String label , match;
    public ResultToken(Integer begin , Integer end ,String label,String match) {
        this.begin = begin;
        this.end = end;
        this.label = label;
        this.match = match;
    }

    @Override
    public int compareTo(ResultToken other) {
        if(this.begin == other.begin)
            return other.end.compareTo(this.end);
        return this.begin.compareTo(other.begin);
    }
}
