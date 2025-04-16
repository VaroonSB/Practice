import java.util.*;

class Main {

    static int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

    public static void main(String[] args) {
        System.out.println(uniquePaths("", obstacleGrid.length - 1, obstacleGrid[0].length - 1));
    }

    static List<String> uniquePaths(String path, int m, int n) {
        if (m == 0 && n == 0) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> result = new ArrayList<>();

        if (obstacleGrid[m][n] == 1) {
            return result;
        } else {
            if (m > 0) {
                result.addAll(uniquePaths(path + 'D', m-1, n));
            }

            if (n > 0) {
                result.addAll(uniquePaths(path + 'R', m, n-1));
            }
        }

        return result;
    }
}