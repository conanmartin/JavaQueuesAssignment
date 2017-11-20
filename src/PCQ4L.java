public class PCQ4L {
    public static void main(String[] args) {
//        insertFirst(‘Ireland’), removeLast(),insertLast(‘England’), removeFirst(),
//                insertLast(‘Wales’), insertFirst(‘Scotland’), insertLast(‘France’),
//                removeFirst(), removeLast(), insertLast(‘Germany’)

        LinkedDeque linkedDeque = new LinkedDeque();
        linkedDeque.addFirst("Ireland");
        System.out.println("Removed: " + linkedDeque.removeLast());
        linkedDeque.addLast("England");
        System.out.println("Removed: " + linkedDeque.removeFirst());
        linkedDeque.addLast("Wales");
        linkedDeque.addFirst("Scotland");
        linkedDeque.addLast("France");
        System.out.println("Removed: " + linkedDeque.removeFirst());
        System.out.println("Removed: " + linkedDeque.removeLast());
        linkedDeque.addLast("Germany");
        System.out.println("Remaining:\n" + linkedDeque.toString());
    }
}
