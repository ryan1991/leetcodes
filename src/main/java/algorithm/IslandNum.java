package algorithm;

/**
 *200. 岛屿数量
 *
 * dfs
 *
 * @author songjunbao
 * @date 2023-12-06
 */
public class IslandNum {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };


        System.out.println(numIslands(grid));


    }




    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length  == 0){
            return 0;
        }
        int nx = grid.length;
        int ny = grid[0].length;
        int islands = 0;
        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                if (grid[i][j] == '1'){
                    ++islands;
                    dfs(grid, i, j);
                }

            }
        }
        return islands;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int nx = grid.length;
        int ny = grid[0].length;

        if (i <0 || j <0 ||i >=nx ||j>=ny || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        //左 右 上 下
        dfs(grid, i -1, j);
        dfs(grid, i +1, j);
        dfs(grid, i, j -1);
        dfs(grid, i, j +1);
    }


}
