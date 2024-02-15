package Test.MandatoryDMOJ;

import java.util.*;

/**
 * This class represents a social network where people are friendships are represented by a map.
 */
public class DegreesOfSeparation {
    // A map where the key is a person and the value is a set of that person's friends.
    private Map<Integer, Set<Integer>> friendships;

    /**
     * Constructor for the DegreesOfSeparation class.
     * Initializes the friendships map.
     */
    public DegreesOfSeparation() {
        friendships = new HashMap<>();
    }

    /**
     * Initializes friendships from the provided adjacency list.
     * @param adjacencyList A map where the key is a person and the value is a list of that person's friends.
     */
    public void initializeFriendships(Map<Integer, List<Integer>> adjacencyList) {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int person = entry.getKey();
            List<Integer> friendsList = entry.getValue();

            addPersonIfNotExists(person);

            for (int friend : friendsList) {
                addPersonIfNotExists(friend);
                friendships.get(person).add(friend);
                friendships.get(friend).add(person);
            }
        }
    }

    /**
     * Makes two people friends by adding each other to their respective friends sets.
     * @param x The first person.
     * @param y The second person.
     */
    public void makeFriends(int x, int y) {
        addPersonIfNotExists(x);
        addPersonIfNotExists(y);

        friendships.get(x).add(y);
        friendships.get(y).add(x);
    }

    /**
     * Deletes the friendship between two people by removing each other from their respective friends sets.
     * @param x The first person.
     * @param y The second person.
     */
    public void deleteFriendship(int x, int y) {
        if (friendships.containsKey(x) && friendships.containsKey(y)) {
            friendships.get(x).remove(y);
            friendships.get(y).remove(x);
        }
    }

    /**
     * Returns the number of friends a person has.
     * @param x The person.
     * @return The number of friends the person has.
     */
    public int numberOfFriends(int x) {
        return friendships.containsKey(x) ? friendships.get(x).size() : 0;
    }

    /**
     * Returns the number of "friends of friends" a person has.
     * @param x The person.
     * @return The number of "friends of friends" the person has.
     */
    public int numberOfFriendsOfFriends(int x) {
        Set<Integer> friends = friendships.getOrDefault(x, new HashSet<>());
        Set<Integer> friendsOfFriends = new HashSet<>();

        for (int friend : friends) {
            Set<Integer> friendsOfFriend = friendships.getOrDefault(friend, new HashSet<>());
            friendsOfFriends.addAll(friendsOfFriend);
        }

        // Remove the person itself and its direct friends
        friendsOfFriends.removeAll(friends);
        friendsOfFriends.remove(x);

        return friendsOfFriends.size();
    }

    /**
     * Returns the degree of separation between two people.
     * @param x The first person.
     * @param y The second person.
     * @return The degree of separation between the two people.
     */
    public String degreeOfSeparation(int x, int y) {
        if (x == y) return "0";
        if (!friendships.containsKey(x) || !friendships.containsKey(y)) return "Not connected";

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distances = new HashMap<>();

        queue.offer(x);
        visited.add(x);
        distances.put(x, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int distance = distances.get(current);

            for (int friend : friendships.get(current)) {
                if (!visited.contains(friend)) {
                    if (friend == y) return String.valueOf(distance + 1);
                    queue.offer(friend);
                    visited.add(friend);
                    distances.put(friend, distance + 1);
                }
            }
        }

        return "Not connected";
    }

    /**
     * Adds a person to the friendships map if they do not already exist.
     * @param person The person to add.
     */
    private void addPersonIfNotExists(int person) {
        if (!friendships.containsKey(person)) {
            friendships.put(person, new HashSet<>());
        }
    }

    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DegreesOfSeparation graph = new DegreesOfSeparation();

        // Your provided adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        // Initialize adjacency list here...

        graph.initializeFriendships(adjacencyList);

        while (true) {
            String command = scanner.next();
            if (command.equals("q")) {
                break;
            }

            switch (command) {
                case "i":
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    graph.makeFriends(x, y);
                    break;
                case "d":
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    graph.deleteFriendship(a, b);
                    break;
                case "n":
                    int c = scanner.nextInt();
                    System.out.println(graph.numberOfFriends(c));
                    break;
                case "f":
                    int d = scanner.nextInt();
                    System.out.println(graph.numberOfFriendsOfFriends(d));
                    break;
                case "s":
                    int e = scanner.nextInt();
                    int f = scanner.nextInt();
                    System.out.println(graph.degreeOfSeparation(e, f));
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }

        scanner.close();
    }
}