import sun.awt.image.ImageWatched;

public class LinkedDeque<E> implements Deque<E>{

    public class Node{
        private Node next;
        private Node previous;
        private E e;

        public Node(E e){
            this.next = null;
            this.previous = null;
            this.e = e;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedDeque(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        Node newNode = new Node(e);
        if(this.isEmpty()){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            newNode.previous = this.last;
            newNode.previous.next = newNode;
            this.last = newNode;

        }
        this.size++;

    }

    public void addFirst(E e){
        Node newNode = new Node(e);
        if(this.isEmpty()){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            newNode.next = this.first;
            newNode.next.previous = newNode;
            this.first = newNode;
        }
        this.size++;

    }

    public int size(){
        return this.size;
    }

    public E removeFirst(){
        if(this.isEmpty()){
            throw new EmptyDequeException("ERROR");
        }
        else{
            E toReturn = this.first.e;
            if(this.size != 1) {
                this.first.next.previous = null;
            }
            this.first = this.first.next;
            this.size--;
            return toReturn;
        }
    }

    public E removeLast(){
        if(this.isEmpty()){
            throw new EmptyDequeException("ERROR");
        }
        else{
            E toReturn = this.last.e;
            if(this.size != 1) {
                this.last.previous.next = null;
            }
            this.last = this.last.previous;
            this.size--;
            return toReturn;
        }
    }

    public E getFirst(){
        if(this.isEmpty()){
            throw new EmptyDequeException("ERROR");
        }
        else{
            return this.first.e;
        }

    }

    public E getLast(){
        if(this.isEmpty()){
            throw new EmptyDequeException("ERROR");
        }
        else{
            return this.last.e;
        }
    }

    @Override
    public String toString(){
        String output = "" + this.size + "\t";
        Node startingNode = this.first;
        while(startingNode != null){
            output += startingNode.e.toString() + " ";
            startingNode = startingNode.next;
        }
        return output;
    }

    public static void main(String[] args) {
        LinkedDeque linkedDeque = new LinkedDeque();
        linkedDeque.addFirst("A");
        linkedDeque.addLast("B");
        linkedDeque.addFirst("C");
        System.out.println(linkedDeque.removeFirst());
        System.out.println(linkedDeque.removeLast());
        System.out.println(linkedDeque.toString());

    }
}
