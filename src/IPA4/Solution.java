package IPA4;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for(int i=0; i<4; i++)
        {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            players[i] = new Player(a, b, c, d);
        }
        String input_skill = sc.nextLine();
        String input_level = sc.nextLine();
        int ans1 = findPointsForGivenSkill(players, input_skill);
        if(ans1 != 0) {
            System.out.println(ans1);
        } else {
            System.out.println("The given Skill is not available");
        }
        Player ans2 = getPlayerBasedOnLevel(players, input_skill, input_level);
        if(ans2 != null) {
            System.out.println(ans2.getPlayerId());
        } else {
            System.out.println("No player is available with specified level, skill \n" +
                    "and eligibility points");
        }
    }
    public static int findPointsForGivenSkill(Player[] players, String skill) {
        int result = 0;
        for(Player player : players) {
            if(player.getSkill().equalsIgnoreCase(skill)) {
                result += player.getPoints();
            }
        }
        return result;
    }
    public static Player getPlayerBasedOnLevel(Player[] players, String skill, String level) {
        for (Player player : players) {
            if (player.getSkill().equalsIgnoreCase(skill) && player.getLevel().equalsIgnoreCase(level) && player.getPoints() >= 20) {
                return player;
            }
        }
        return null;
    }
}


class Player {
    private int playerId;
    private String skill, level;
    private int points;

    public Player(int playerId, String skill, String level, int points) {
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}