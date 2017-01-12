package hpy.pixstreet.models;

import java.util.List;

public class Node {

    private String _id;
    private String type;
    private Long id;
    private List<Tag> tags;
    private List<Double> loc = null;
    private List<Score> scores = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Node() {
    }

    /**
     *
     * @param tags
     * @param id
     * @param scores
     * @param _id
     * @param loc
     * @param type
     */
    public Node(String _id, String type, Long id, List<Tag> tags, List<Double> loc, List<Score> scores) {
        super();
        this._id = _id;
        this.type = type;
        this.id = id;
        this.tags = tags;
        this.loc = loc;
        this.scores = scores;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public List<Double> getLoc() {
        return loc;
    }

    public void setLoc(List<Double> loc) {
        this.loc = loc;
    }


    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

}