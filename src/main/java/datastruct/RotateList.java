package datastruct;

/**
 * 61. 旋转链表
 *
 *
 * @author songjunbao
 * @date 2023-11-30
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode listNode = rotateRight(head, 4);
        System.out.println(listNode.getLength());

    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null){
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null){
            iter = iter.next;
            n ++ ;
        }
        //k 为 n 的倍数时，新链表将与原链表相同
//        if (k % n == 0){
//            return head;
//        }

        int add = n - k % n;
        if (add == n){
            return head;
        }
        //尾首链接
        iter.next = head;
        //找到新的链表的尾节点
        while (add-- > 0){
            iter = iter.next;
        }

        ListNode res = iter.next;
        iter.next = null;
        return res;
    }
}
