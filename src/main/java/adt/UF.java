package adt;

/**
 *
 * 并查集
 * @author songjunbao
 * @date 2023-10-11
 */
public interface UF {

    int getSize();

    boolean isConnect(int p, int q);

    void unionElement(int p, int q);

}
