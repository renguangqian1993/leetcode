package jdk;

import java.util.Objects;

public class ReverseListTest {

    public static void main(String[] args) {
//        reverseNode();
//        reverseLinkedNode();
    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private static void reverseLinkedNode() {
        LinkedNode head = null;
        LinkedNode tail = null;
        for (int index = 1; index <= 10; index++) {
            LinkedNode currNode = new LinkedNode(null, null, index);
            if (Objects.isNull(head)) {
                head = tail = currNode;
            } else {
                tail.setNext(currNode);
                currNode.setPre(tail);
                tail = currNode;
            }
        }
        System.out.println("原始顺序：");
        printList(head);

        LinkedNode headNew = head;
        LinkedNode remainNode = headNew.getNext();
        headNew.setPre(null);
        headNew.setNext(null);
        while (!Objects.isNull(remainNode)) {
            LinkedNode tmp = remainNode.getNext();
            remainNode.setNext(headNew);
            remainNode.setPre(null);

            headNew = remainNode;
            remainNode = tmp;
        }


        System.out.println("逆转顺序：");
        printList(headNew);
    }

    private static void reverseNode() {
        Node head = null;
        Node tail = null;
        for (int index = 1; index <= 10; index++) {
            if (Objects.isNull(head)) {
                head = tail = new Node(null, index);
            } else {
                tail.setNext(new Node(null, index));
                tail = tail.next;
            }
        }
        System.out.println("原始顺序：");
        printList(head);

        Node headNew = head;
        Node nextNode = headNew.getNext();
        headNew.setNext(null);
        while (!Objects.isNull(nextNode)) {
            Node tmp = nextNode.getNext();

            nextNode.setNext(headNew);
            headNew = nextNode;
            nextNode = tmp;
        }

        System.out.println("逆转顺序：");
        printList(headNew);
    }


    private static void printList(Node node) {
        System.out.println("================");
        while (node != null) {
            System.out.println(node);
            node = node.getNext();
        }
        System.out.println("++++++++++++++++");
    }

    private static class Node {
        private Node next;
        private int val;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node() {
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ",next=" + (Objects.isNull(next) ? " " : next.getVal()) +
                    '}';
        }
    }

    private static class LinkedNode extends Node {
        private LinkedNode pre;
        private LinkedNode next;
        private int val;

        public LinkedNode getPre() {
            return pre;
        }

        public void setPre(LinkedNode pre) {
            this.pre = pre;
        }

        public LinkedNode getNext() {
            return next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public LinkedNode() {
        }

        public LinkedNode(LinkedNode pre, LinkedNode next, int val) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }

        @Override
        public String toString() {
            return "LinkedNode{" +
                    "pre=" + (Objects.isNull(pre) ? " " : pre.getVal()) +
                    ",val=" + val +
                    ",next=" + (Objects.isNull(next) ? " " : next.getVal()) +
                    '}';
        }
    }
}

