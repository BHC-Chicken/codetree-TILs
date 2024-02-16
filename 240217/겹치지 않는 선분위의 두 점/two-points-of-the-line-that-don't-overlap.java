//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int people = Integer.parseInt(st.nextToken());
//        int handshake = Integer.parseInt(st.nextToken());
//        int first = Integer.parseInt(st.nextToken());
//        int handshakeCount = Integer.parseInt(st.nextToken());
//
//        Time[] times = new Time[handshakeCount];
//        People[] humans = new People[people + 1];
//
//        for (int i = 0; i < handshakeCount; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int time = Integer.parseInt(st.nextToken());
//            int xPeople = Integer.parseInt(st.nextToken());
//            int yPeople = Integer.parseInt(st.nextToken());
//
//            times[i] = new Time(time, xPeople, yPeople);
//        }
//
//        for (int i = 1; i <= people; i++) {
//            if (i == first) {
//                humans[i] = new People(i, handshake, true);
//            } else {
//                humans[i] = new People(i, 0, false);
//            }
//        }
//
//        Arrays.sort(times);
//
//        for (int i = 0; i < handshakeCount; i++) {
//            if (humans[times[i].yPeople].virus && humans[times[i].xPeople].virus) {
//                humans[times[i].xPeople].handshakeCount--;
//                humans[times[i].yPeople].handshakeCount--;
//            } else if (humans[times[i].xPeople].virus && humans[times[i].xPeople].handshakeCount > 0) {
//                humans[times[i].yPeople].virus = true;
//                humans[times[i].yPeople].handshakeCount = handshake;
//                humans[times[i].xPeople].handshakeCount--;
//            } else if (humans[times[i].yPeople].virus && humans[times[i].yPeople].handshakeCount > 0) {
//                humans[times[i].xPeople].virus = true;
//                humans[times[i].xPeople].handshakeCount = handshake;
//                humans[times[i].yPeople].handshakeCount--;
//            }
//        }
//
//        for (int i = 1; i <= people; i++) {
//            if (humans[i].virus) {
//                sb.append(1);
//            } else {
//                sb.append(0);
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
//}
//
//class Time implements Comparable<Time> {
//
//    int time;
//    int xPeople;
//    int yPeople;
//
//    public Time(int time, int xPeople, int yPeople) {
//        this.time = time;
//        this.xPeople = xPeople;
//        this.yPeople = yPeople;
//    }
//
//    @Override
//    public int compareTo(Time o) {
//        return this.time - o.time;
//    }
//}
//
//class People {
//    int index;
//    int handshakeCount;
//    boolean virus;
//
//    public People(int index, int handshakeCount, boolean virus) {
//        this.index = index;
//        this.handshakeCount = handshakeCount;
//        this.virus = virus;
//    }
//}

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Main {
//    static int max;
//    static int min;
//
//    public static void main(String[] args) throws IOException {
//        List<Integer> row = new ArrayList<>();
//        List<Integer> col = new ArrayList<>();
//
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//
//        for (int i = 0; i < sizes.length; i++) {
//            row.add(sizes[i][0]);
//            col.add(sizes[i][1]);
//        }
//
//        Collections.sort(row);
//        Collections.sort(col);
//
//        int rowMax = row.get(row.size() - 1);
//        int colMax = col.get(col.size() - 1);
//
//        if (rowMax > colMax) {
//            int rowMin = 0;
//
//            int index = getMax(row, colMax);
//            getMin(col, index, rowMin);
//        } else {
//            int colMin = 0;
//
//            int index = getMax(col, rowMax);
//            getMin(row, index, colMin);
//        }
//
//        System.out.println(max + " " + min);
//    }
//
//    static int getMax(List<Integer> list, int a) {
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (a > list.get(i)) {
//                return i;
//            }
//            max = list.get(i);
//        }
//        return 0;
//    }
//
//    static void getMin(List<Integer> list, int index, int a) {
//        for (int i = index; i < list.size(); i++) {
//            if (a > list.get(i)) {
//                break;
//            }
//            min = list.get(i);
//        }
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Main {
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        int u = Integer.parseInt(st.nextToken());
//        int n = Integer.parseInt(st.nextToken());
//
//        List<Auction> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            String name = st.nextToken();
//            int price = Integer.parseInt(st.nextToken());
//
//            map.put(price, map.getOrDefault(price, 0) + 1);
//
//            if (price > u) {
//                continue;
//            }
//            list.add(new Auction(name, price));
//        }
//
//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
//        entryList.sort(Map.Entry.comparingByKey());
//        entryList.sort(Map.Entry.comparingByValue());
//
//        Collections.sort(list);
//
//        int result = entryList.get(0).getKey();
//
//        for (Auction auction : list) {
//            if (result == auction.price) {
//                sb.append(auction.name).append(" ").append(auction.price);
//                break;
//            }
//        }
//
//        System.out.println(sb);
//    }
//}
//
//class Auction implements Comparable<Auction> {
//    String name;
//    int price;
//
//    public Auction(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }
//
//
//    @Override
//    public int compareTo(Auction o) {
//        return price - o.price;
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static void printBinaries(int n) {
//        List<String> results = new ArrayList<>();
//        generateBinaries(n, "", results);
//
//        for (String binary : results) {
//            if (binary.chars().filter(ch -> ch == '0').count() >= 2 &&
//                    binary.chars().filter(ch -> ch == '1').count() >= 2) {
//                System.out.println(binary);
//            }
//        }
//    }
//
//    static void generateBinaries(int n, String prefix, List<String> results) {
//        if (n == 0) {
//            results.add(prefix);
//        } else {
//            generateBinaries(n - 1, prefix + "0", results);
//            generateBinaries(n - 1, prefix + "1", results);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        printBinaries(Integer.parseInt(br.readLine()));
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int[] dx = {1, 0, -1, 0};
//    static int[] dy = {0, -1, 0, 1};
//    static char[][] arr;
//    static int n;
//    static int x;
//    static int y;
//    static int now;
//
//    static void startSide(int start) {
//        if (start < n) {
//            now = 0;
//            x = 0;
//            y = start;
//        } else if (start < n * 2) {
//            now = 1;
//            x = start - n;
//            y = n - 1;
//
//        } else if (start < n * 3) {
//            now = 2;
//            x = n - 1;
//            y = Math.abs((start % n) - (n - 1));
//        } else {
//            now = 3;
//            x = Math.abs((start % n) - (n - 1));
//            y = 0;
//        }
//    }
//
//    static boolean range(int x, int y) {
//        return x >= n || y >= n || x < 0 || y < 0;
//    }
//
//    static void slashMove(int prev) {
//        if (prev == 0) {
//            now = 1;
//        } else if (prev == 3) {
//            now = 2;
//        } else if (prev == 1) {
//            now = 0;
//        } else {
//            now = 3;
//        }
//
//        x += dx[now];
//        y += dy[now];
//    }
//
//    static void backSlashMove(int prev) {
//        if (prev == 0) {
//            now = 3;
//        } else if (prev == 1) {
//            now = 2;
//        } else if (prev == 3) {
//            now = 0;
//        } else {
//            now = 1;
//        }
//
//        x += dx[now];
//        y += dy[now];
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        arr = new char[n][n];
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            String s = br.readLine();
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = s.charAt(j);
//            }
//        }
//
//        int start = Integer.parseInt(br.readLine()) - 1;
//
//        startSide(start);
//        boolean loop = true;
//
//        while (loop) {
//            char dir = arr[x][y];
//
//            if (dir == '/') {
//                slashMove(now);
//            } else {
//                backSlashMove(now);
//            }
//
//            x += dx[now];
//            y += dy[now];
//            System.out.println(dir);
//            count++;
//            loop = !range(x, y);
//        }
//
//        System.out.println(count);
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int n;
//    static int[][] arr;
//    static boolean[][] visited;
//    static int maxBlock;
//    static int maxBombBlock;
//    static int bombTemp;
//
//    static boolean inRange(int x, int y) {
//        return x >= 0 && x < n && y >= 0 && y < n;
//    }
//
//    static boolean canGo(int x, int y, int currentNum) {
//        if (!inRange(x, y)) {
//            return false;
//        }
//
//        return !visited[x][y] && arr[x][y] == currentNum;
//    }
//
//    static void DFS(int startX, int startY, int currentNum) {
//        int[] dx = {1, 0, -1, 0};
//        int[] dy = {0, 1, 0, -1};
//
//
//        for (int i = 0; i < 4; i++) {
//            int newX = startX + dx[i];
//            int newY = startY + dy[i];
//
//            if (canGo(newX, newY, currentNum)) {
//                visited[newX][newY] = true;
//                DFS(newX, newY, currentNum);
//                bombTemp++;
//            }
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        arr = new int[n][n];
//        visited = new boolean[n][n];
//        StringTokenizer st;
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                bombTemp = 1;
//                int currentNum = arr[i][j];
//                if (!visited[i][j]) {
//                    if (!canGo(i, j, currentNum)) {
//                        continue;
//                    }
//                }
//                visited[i][j] = true;
//                DFS(i, j, currentNum);
//                if (bombTemp >= 4) {
//                    maxBombBlock++;
//                }
//                maxBlock = Math.max(bombTemp, maxBlock);
//            }
//        }
//
//        System.out.println(maxBombBlock + " " + maxBlock);
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static final int INT_MAX = Integer.MAX_VALUE;
//    public static final int MAX_N = 11;
//
//    public static int n, m;
//
//    static ArrayList<Pair> lines = new ArrayList<>();
//    static ArrayList<Pair> selectedLines = new ArrayList<>();
//
//    public static int ans = INT_MAX;
//
//    public static boolean possible() {
//
//        int[] num1 = new int[MAX_N];
//        int[] num2 = new int[MAX_N];
//        for(int i = 0; i < n; i++)
//            num1[i] = num2[i] = i;
//
//        swap(num1, lines);
//        swap(num2, selectedLines);
//
//        for(int i = 0; i < n; i++)
//            if(num1[i] != num2[i])
//                return false;
//
//        return true;
//    }
//
//    private static void swap(int[] num1, ArrayList<Pair> lines) {
//        for (Pair line : lines) {
//            int idx = line.y;
//            int tmp = num1[idx];
//
//            num1[idx] = num1[idx + 1];
//            num1[idx + 1] = tmp;
//        }
//    }
//
//    public static void findMinLines(int cnt) {
//        if(cnt == m) {
//            if(possible())
//                ans = Math.min(ans, selectedLines.size());
//            return;
//        }
//
//        selectedLines.add(lines.get(cnt));
//        findMinLines(cnt + 1);
//        selectedLines.remove(selectedLines.size() - 1);
//
//        findMinLines(cnt + 1);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        for(int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            lines.add(new Pair(b, a - 1));
//        }
//
//        Collections.sort(lines);
//
//        findMinLines(0);
//
//        System.out.print(ans);
//    }
//}
//
//class Pair implements Comparable<Pair> {
//    int x, y;
//    public Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//    @Override
//    public int compareTo(Pair b) {
//        if(x != b.x) return x - b.x;
//        return y - b.y;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static Line[] lines;

    static boolean isPossible(long mid) {
        int count = 0;
        long last = -1000000000000000000L;

        for (Line line : lines) {
            long x1 = line.a;
            long x2 = line.b;

            while (last + mid <= x2) {
                count++;
                last = Math.max(x1, last + mid);

                if (count >= n) {
                    break;
                }
            }
        }

        return count >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lines = new Line[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Arrays.sort(lines);

        long left = 1;
        long right = 1000000000000000000L;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid)) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }

        System.out.println(result);
    }
}

class Line implements Comparable<Line> {
    long a, b;

    public Line(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Line other) {
        if (a > other.a) {
            return 1;
        }
        if (a < other.a) {
            return -1;
        }

        if (b > other.b) {
            return 1;
        }
        return -1;
    }
}