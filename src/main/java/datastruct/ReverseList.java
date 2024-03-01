package datastruct;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseList {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);

        ListNode newHeader1 = reverseListStack2(node1);
        System.out.println(newHeader1);





    }



    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode nextTemp = curr.next;

            curr.next = prev;
            prev = curr;

            curr = nextTemp;

        }

        return prev;

    }

    /**
     * 递归的方式
     * @param head
     * @return
     */
    public static ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseListRecursion(head.next);
        //两个节点之间反转
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static ListNode reverseListStack(ListNode head){
        Deque<ListNode> stack = new LinkedList();
        while (head!= null){
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty())
            return null;
        ListNode newHead = stack.pop();
        ListNode temp = newHead;

        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
    }


    public static ListNode reverseListStack2(ListNode head){
        Deque<ListNode> stack = new LinkedList();
        while (head!= null){
            ListNode node = new ListNode(head.val);
            stack.push(node);
            head = head.next;
        }

        if (stack.isEmpty())
            return null;
        ListNode newHead = stack.pop();
        ListNode temp = newHead;

        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
//        temp.next = null;
        return newHead;
    }




}
