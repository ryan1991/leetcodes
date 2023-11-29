package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * hash + 双向链表
 *
 *
 * @author songjunbao
 * @date 2023-11-28
 */
public class LRUCache {

    class DLinkedNode{

        int key;
        int value;

        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode(){}
        DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }


    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //伪节点
        this.head = new DLinkedNode();;
        this.tail = new DLinkedNode();;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }

        //如果key存在，移动到头部节点
        moveToHead(node);
        return node.value;
    }



    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size ++;
            if (size > capacity){
                //超出容量 删除双向链表中尾节点
                DLinkedNode tailNode = removeTail();
                //删除hash表中对应项
                cache.remove(tailNode.key);
                size --;
            }
        }else {
            // 如果 key 存在，修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }


    }


    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail(){
        DLinkedNode tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }


}
