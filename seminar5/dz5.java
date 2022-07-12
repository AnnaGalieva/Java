package Java.seminar5;

public class dz5 {
    public static void main(String[] args) {
    
      int i = 0;
      int z = 0;
      int k = 0;
      int j = 0;
      int Ni = 0;
      int Nk = 256;
      int n = 10;

        // Лабиринтная матрица
        int lab[][] = {
                { 254, 254, 254, 254, 254, 254, 254, 254, 254, 254 },
                { 253, 254, 254, 254, 254, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 254, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 255, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 254, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 254, 0, 254, 254, 254, 254 },
                { 254, 254, 254, 255, 254, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 255, 255, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 254, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 254, 254, 254, 254, 254, 254 },
                { 254, 254, 254, 254, 254, 254, 254, 254, 254, 254 } };

        // инициализация пути матрицы
        int kurs[][] = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                kurs[i][j] = 122;
            }
        }

        // Три цикла прохождения матрицы лабиринта
        label: for (int l = 0; l < Nk; l++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {

                    // Условия распространения волны
                    if (lab[i][j] == Ni && i > 0 && i < n && j > 0 && j < n - 1) {

                        if (lab[i][j + 1] == 254) {
                            lab[i][j + 1] = Ni + 1;
                        }
                        if (lab[i][j + 1] == 253) {
                            z = i;
                            k = j + 1;
                            break label;
                        }

                        if (lab[i + 1][j] == 254) {
                            lab[i + 1][j] = Ni + 1;
                        }
                        if (lab[i + 1][j] == 253) {
                            z = i + 1;
                            k = j;
                            break label;

                        }

                        if (lab[i][j - 1] == 254) {
                            lab[i][j - 1] = Ni + 1;
                        }
                        if (lab[i][j - 1] == 253) {
                            z = i;
                            k = j - 1;
                            break label;

                        }

                        if (lab[i - 1][j] == 254) {
                            lab[i - 1][j] = Ni + 1;
                        }
                        if (lab[i - 1][j] == 253) {
                            z = i - 1;
                            k = j;
                            break label;

                        }

                    }

                }
            }
            // Коэффициент распространения волны
            Ni++;
        }
        // Волновой выход
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", lab[i][j]);
            }
            System.out.println();
        }
        lab[z][k] = Ni + 1;
        Ni++;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (lab[z][k] >= lab[z + 1][k]) {
                    kurs[z][k] = Ni;
                    z = z + 1;
                    Ni--;
                }

                if (lab[z][k] >= lab[z - 1][k]) {
                    kurs[z][k] = Ni;
                    z = z - 1;
                    Ni--;
                }

                if (lab[z][k] >= lab[z][k + 1]) {
                    kurs[z][k] = Ni;
                    k = k + 1;
                    Ni--;
                }

                if (lab[z][k] >= lab[z][k - 1]) {
                    kurs[z][k] = Ni;
                    k = k - 1;
                    Ni--;
                }
                kurs[z][k] = Ni;
            }
        }
        // Вывод кратчайшего пути
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", kurs[i][j]);
            }
            System.out.println();
        }
    }
}

/*
 * import java.util.LinkedList;
 * import java.util.Queue;
 * class node{
 * int x, y, distance;
 * 
 * node(int x, int y, int dist)
 * {
 * this.x = x;
 * this.y = y;
 * this.distance = dist;
 * }
 * }
 * 
 * public class dz5
 * {
 * // это должна быть длина строки и столбца введенной матрицы
 * static int M = 5;
 * static int N = 5;
 * 
 * static boolean isValid(int mat[][], boolean visited[][], int row, int col)
 * {
 * return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) &&
 * (mat[row][col] == 1) && (!visited[row][col]);
 * }
 * 
 * private static void bfs(int matrix[][], int i, int j, int x, int y)
 * {
 * int row[] =
 * { -1, 0, 0, 1 };
 * int col[] =
 * { 0, -1, 1, 0 };
 * 
 * boolean[][] visited = new boolean[M][N];
 * Queue<node> q = new LinkedList<node>();
 * visited[i][j] = true;
 * q.add(new node(i, j, 0));
 * int minimum_distance = Integer.MAX_VALUE;
 * while (!q.isEmpty())
 * {
 * node node = q.poll();
 * i = node.x;
 * j = node.y;
 * int dist = node.distance;
 * if (i == x && j == y)
 * {
 * minimum_distance = dist;
 * break;
 * }
 * 
 * for (int k = 0; k < 4; k++)
 * {
 * if (isValid(matrix, visited, i + row[k], j + col[k]))
 * {
 * visited[i + row[k]][j + col[k]] = true;
 * node n = new node(i + row[k], j + col[k], dist + 1);
 * q.add(n);
 * }
 * }
 * }
 * 
 * if (minimum_distance == Integer.MAX_VALUE)
 * {
 * System.out.print("Пункт назначения не может быть достигнут");
 * }
 * else
 * {
 * System.out.print("Кратчайший путь имеет длину " + minimum_distance);
 * }
 * }
 * 
 * public static void main(String[] args)
 * {
 * int[][] matrix =
 * {
 * { 1, 0, 1, 1, 1 },
 * { 1, 0, 1, 0, 1 },
 * { 1, 1, 1, 0, 1 },
 * { 0, 0, 0, 0, 1 },
 * { 1, 1, 1, 0, 1 },
 * { 1, 1, 0, 0, 0 } };
 * bfs(matrix, 0, 0, 3, 4);
 * }
 * }
 */
