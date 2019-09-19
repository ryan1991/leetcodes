package datastruct;

/**
 * 合并2个有序链表
 */
public class MergeTwoOrderedList {


    public static void main(String[] args) {






    }


    /**
     *
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1,  ListNode l2){

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;


        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);

            return l1;
        }else {

            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }



    }










}
