package hpy.pixstreet.models;

/**
 * Created by benjamindebotte on 11/01/2017.
 */

public class Score {
    private String name;
    private Integer score;
    private Node node;


    public Score(String name, Integer score, Node node) {
        super();
        this.name = name;
        this.score = score;
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
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
}
