public class Run {
    public static void main(String[] args) {
        Project emptyProject = new Project();
        Project emptyDescProject = new Project("Project 1");
        Project fullProject = new Project("Project 2", "Project 2 description");

        System.out.println(emptyProject.elevPitch());
        System.out.println(emptyDescProject.elevPitch());
        System.out.println(fullProject.elevPitch());
        emptyProject.setName("Project 0");
        emptyProject.setDesc("Project 0 description");
        System.out.println(emptyProject.elevPitch());
    }
}