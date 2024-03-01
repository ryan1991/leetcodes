package datastruct;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 */
public class MergeKOrderedList {


    public static void main(String[] args) {

        ListNode[] list  = new ListNode[3];

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);


        list[0] = head1;

        list[1] = head2;

        list[2] = head3;


        ListNode dummy =  mergeKLists2(list);
        System.out.println(dummy);
    }


    /**
     * 暴力法
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        if (len == 0)
            return null;

        if (len == 1)
            return lists[0];


        List<Integer> nodes = new ArrayList<>();


        for (ListNode node : lists){
            while (node != null) {
                nodes.add(node.val);
                node = node.next;
            }

        }
        //获取值再排序再重新创建链表
        nodes.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        ListNode head = new ListNode(0);
        ListNode other = head;

        for (Integer val : nodes){
            other.next = new ListNode(val);
            other = other.next;

        }

        return head.next;

    }



    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }

        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            if (node.next != null){
                pq.add(node.next);
            }
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }

}
