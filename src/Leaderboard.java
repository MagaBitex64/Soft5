import java.util.*;

public class Leaderboard {
    private Hashtable<Integer, Integer> scores = new Hashtable<>();
    private Hashtable<Integer, String> names = new Hashtable<>();

    public void addPoints(Student student, int points) {
        int id = student.id;
        scores.put(id, scores.getOrDefault(id, 0) + points);
        names.put(id, student.name);
    }

    public void showLeaderboard() {
        if (scores.isEmpty()) {
            System.out.println("No students for leaderboard yet");
            return;
        }

        System.out.println("\nLeaderboard");
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(scores.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : list) {
            int id = entry.getKey();
            int points = entry.getValue();
            System.out.println(rank++ + ". " + names.get(id) + " (ID: " + id + ") - " + points + " pts");
        }
    }
}
