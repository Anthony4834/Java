public class Project {
    String name;
    String desc;

    public Project() {
        this("Empty name", "Empty description");
    }
    public Project(String name) {
        this(name, "Empty description");
    }
    public Project(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String elevPitch() {
        return String.format("%s: %s", this.name, this.desc);
    }
}