package datastruct;


import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 */
public class CycleList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);

        ListNode n0 = new ListNode(0);

        ListNode nf4 = new ListNode(-4);

        head.next = n2;
        n2.next=n0;
        n0.next = nf4;
        nf4.next=n2;


        System.out.println(hasCycleFastLowPointer(head));


    }


    /**
     * 哈希表
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;

    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycleFastLowPointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}

