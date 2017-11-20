
public class ArrayQueue<E> implements Queue<E>{

    private int maxSize;
    private int front;
    private int rear;

    private E[] array;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.array = (E[]) new Object[maxSize];
    }

    public ArrayQueue(){
        this.maxSize = 100;
        this.front = 0;
        this.rear = 0;
        this.array = (E[]) new Object[this.maxSize];
    }

    public void enqueue(E e){
        if(this.size() == maxSize){
//            throw new NullPointerException();
            System.out.println("QUEUE FULL ERROR");
        }
        else{
            this.array[this.rear] = e;
            this.rear = (this.rear + 1) % this.maxSize;
        }

    }

    public E dequeue(){
        if(this.isEmpty()){
            throw new EmptyQueueException("Empty Queue Exception");     }
        else{
            E e = this.array[front];
            this.front = (this.front + 1) % this.maxSize;
            return e;
        }

    }

    public E front(){
        if(this.isEmpty()){
            throw new EmptyQueueException("Empty Queue Exception");   }
        else{
            return this.array[front];
        }
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public int size(){
        return ((this.maxSize + this.rear) - this.front) % this.maxSize;
    }

    @Override
    public String toString(){
        String out = "" + this.size() + "\t";
        for(int i = this.front; i != this.rear; i = (i + 1) % this.maxSize){
            out += this.array[i] + " ";
        }
//        for (int i = 0; i < this.size(); i++) {
//            out += this.array[(i + front) % this.maxSize] + " ";
//
//        }
//        System.out.println("Size = " + this.size());

        return out;
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        System.out.println(q.toString());
//        System.out.println(q.size());

        q.enqueue("a");
        System.out.println(q.toString());
//        System.out.println(q.size());

        q.enqueue("b");
        System.out.println(q.toString());
//        System.out.println(q.size());

//        q.dequeue();

        q.enqueue("c");
        System.out.println(q.toString());
//        System.out.println(q.size());


        q.enqueue("d");
        System.out.println(q.toString());
//        System.out.println(q.size());


        q.enqueue("e");
        System.out.println(q.toString());
//        System.out.println(q.size());
//        for(Object a : q.array){
//            System.out.println((String) a);
//        }


        q.enqueue("f");
        System.out.println(q.toString());
//        System.out.println(q.size());


        q.enqueue("g");
        System.out.println(q.toString());
//        System.out.println(q.size());

    }


}
