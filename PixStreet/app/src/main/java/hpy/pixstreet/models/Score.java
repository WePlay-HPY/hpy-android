package hpy.pixstreet.models;

/**
 * Created by benjamindebotte on 11/01/2017.
 */

public class Score implements Comparable<Score> {
    private String name;
    private Integer score;
    private String node; //MongoDB Node _id


    public Score(String name, Integer score, String node__id) {
        super();
        this.name = name;
        this.score = score;
        this.node = node__id;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Score another) {
        return Integer.compare(this.score, another.score);
    }
}
