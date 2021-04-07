public class Run {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        list.addToFront(4);
        list.addToFront(5);
        list.addToBack(0);
        list.printAll();
        System.out.println("Removed " + list.removeFromBack().data);
        list.printAll();
        System.out.println("Removed " + list.removeFromFront().data);
        list.printAll();
        System.out.println("Found value at: " + list.findValue(2).data);
        System.out.println("Removed " + list.removeFromNth(2).data);
        list.printAll();
    }
}