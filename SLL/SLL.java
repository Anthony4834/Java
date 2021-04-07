public class SLL {
    public Node head;
    public Node tail;

    public SLL() {
        this.head = null;
        this.tail = null;
    }
    public Boolean isEmpty() {
        return this.head == null;
    }
    public void addNodeToFront(Node node) {
        node.next = this.head;
        this.head = node;
        if(this.tail == null) {
            this.tail = node;
        }
    }
    public void addNodeToBack(Node node) {
        if(this.tail != null) {
            this.tail.next = node;
        }
        this.tail = node;
        if(this.head == null) {
            this.head = node;
        }
    }
    public void addToFront(Object data) {
        Node node = new Node(data);
        addNodeToFront(node);
    }
    public void addToBack(Object data) {
        Node node = new Node(data);
        addNodeToBack(node);
    }
    public Node removeFromFront() {
        Node toRemove = this.head;
        if(!this.isEmpty()) {
            this.head = toRemove.next;
            toRemove.next = null;
        }
        return toRemove;
    }
    public Node removeFromBack() {
        Node toRemove = this.tail;
        Node runner = this.head;

        while(runner.next != this.tail) {
            runner = runner.next;
        }
        this.tail = runner;
        this.tail.next = null;
        
        return toRemove;
    }
    public Node removeFromNth(int idx) {
        int count = 1;
        Node runner = this.head;

        while(runner != null) {
            if(count == idx - 1) {
                break;
            }
            count += 1;
            runner = runner.next;
        }
        Node toRemove = runner.next;
        runner.next = runner.next.next;
        toRemove.next = null;

        return toRemove;
    }
    public void printAll() {
        Node runner = this.head;
        while(runner != null) {
            System.out.println(runner.data);
            runner = runner.next;
        }
    }
    public Node findValue(Object value) {
        Node runner = this.head;
        while(runner != null) {
            if(runner.data == value) {
                return runner;
            }
            runner = runner.next;
        }
        return null;
    }
}