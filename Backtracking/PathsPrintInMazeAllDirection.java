import java.util.*;

class Main {

    static boolean[][] grid = {{true,true,true},{true,true,true},{true,true,true}};

    static int[][] way = {{0,0,0},{0,0,0},{0,0,0}};

    public static void main(String[] args) {
        uniquePaths("", 0, 0, 0);
    }

    static List<String> uniquePaths(String path, int m, int n, int count) {
        if (m == 2 && n == 2) {
            way[m][n] = ++count;
            for (int i = 0; i < way.length; i++) {
                System.out.println(Arrays.toString(way[i]));
            }
            System.out.println(path);
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> result = new ArrayList<>();

        if (!grid[m][n]) {
            return result;
        }

        // change
        grid[m][n] = false;
        way[m][n] = ++count;

        if (m < grid.length-1) {
            result.addAll(uniquePaths(path + 'D', m+1, n, count));
        }

        if (n < grid[0].length-1) {
            result.addAll(uniquePaths(path + 'R', m, n+1, count));
        }

        if (m > 0) {
            result.addAll(uniquePaths(path + 'U', m-1, n, count));
        }

        if (n > 0) {
            result.addAll(uniquePaths(path + 'L', m, n-1, count));
        }

        // undo
        grid[m][n] = true;
        way[m][n] = 0;

        return result;
    }
}

// [DDRR, DRDR, DRRD, RDDR, RDRD, RRDD]