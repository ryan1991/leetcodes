package adt;

/**
 *
 * 并查集(QuickFind 合并的时间复杂度O(n))
 * @author songjunbao
 * @date 2023-10-11
 */
public class UF1 implements UF{

    private int[] id;

    public UF1(int size){
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnect(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 查找p元素对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out bound");

        return id[p];
    }

    @Override
    public void unionElement(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
    }
}
