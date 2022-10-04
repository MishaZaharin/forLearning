public class StringsLinkedListPartTwo {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }
        Node node = new Node();
        node.value = value;
        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        if (first.next == null) return null;
        boolean outOfIndex = false;
        Node cNode = first;
        for (int i = 0; i <= index; i++) {
            if (cNode.next == null && i < index) {
                outOfIndex = true;
                break;
            }
            cNode = cNode.next;
        }
        return (outOfIndex) ? null : cNode.value;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }

    public static void main(String[] args) {
        StringsLinkedListPartTwo stringsLinkedList = new StringsLinkedListPartTwo();
        stringsLinkedList.add("1");
        stringsLinkedList.add("2");
        stringsLinkedList.add("3");
        stringsLinkedList.add("4");
        stringsLinkedList.add("5");
        stringsLinkedList.add("6");
        stringsLinkedList.add("7");
        stringsLinkedList.add("8");
        stringsLinkedList.add("9");
        System.out.println(stringsLinkedList.get(4)); // 5
    }
}