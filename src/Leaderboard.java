import java.util.*;

public class Leaderboard {
    private Map<String, Integer> board = new HashMap<>();

    public void addPoints(String sname, int points) {
        board.put(sname, board.getOrDefault(sname, 0) + points);
    }

    public void show() {
        System.out.println("\nLeaderboard");
        if (board.isEmpty()) {
            System.out.println("No students with points");
            return;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(board.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int rank = 1;
        for (Map.Entry<String, Integer> entry : board.entrySet()) {
            System.out.println(rank + ". " + entry.getKey() + " - " + entry.getValue());
            rank++;

        }
    }
}