package datastruct;

public class ListNode {
    int val;

    ListNode next;

    ListNode(int val){
        this.val = val;

    }


    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder builder = new StringBuilder();
        String symbol = "->";

        while (cur != null){
            builder.append(cur.val).append(symbol);
            cur = cur.next;
        }
        builder.delete(builder.length() - symbol.length(), builder.length());
        return builder.toString();
    }


    /**
     * 获取链表长度
     * 只有链表表头才有效果
     * @return
     */
    public int getLength(){
        int n = 1;
        ListNode iter = this;
        while (iter.next != null){
            iter = iter.next;
            n ++ ;
        }
        return n;
    }

}
