package Test.MandatoryDMOJ;

import java.util.*;

public class DegreesOfSeparation {
    private Map<Integer, Set<Integer>> friendships;

    public DegreesOfSeparation() {
        friendships = new HashMap<>();
    }

    // Method to initialize friendships from the provided adjacency list
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

    // Method to make two people friends
    public void makeFriends(int x, int y) {
        addPersonIfNotExists(x);
        addPersonIfNotExists(y);

        friendships.get(x).add(y);
        friendships.get(y).add(x);
    }

    // Method to delete the friendship between two people
    public void deleteFriendship(int x, int y) {
        if (friendships.containsKey(x) && friendships.containsKey(y)) {
            friendships.get(x).remove(y);
            friendships.get(y).remove(x);
        }
    }

    // Method to output the number of friends a person has
    public int numberOfFriends(int x) {
        return friendships.containsKey(x) ? friendships.get(x).size() : 0;
    }

    // Method to output the number of "friends of friends" a person has
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


    // Method to output the degree of separation between two people
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

    // Method to add a person if not exists
    private void addPersonIfNotExists(int person) {
        if (!friendships.containsKey(person)) {
            friendships.put(person, new HashSet<>());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DegreesOfSeparation graph = new DegreesOfSeparation();

        // Your provided adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(1, Arrays.asList(6));
        adjacencyList.put(2, Arrays.asList(6));
        adjacencyList.put(3, Arrays.asList(4, 5, 6, 15));
        adjacencyList.put(4, Arrays.asList(3, 5, 6));
        adjacencyList.put(5, Arrays.asList(3, 4, 6));
        adjacencyList.put(6, Arrays.asList(1, 2, 3, 4, 5, 7));
        adjacencyList.put(7, Arrays.asList(6, 8));
        adjacencyList.put(8, Arrays.asList(7, 9));
        adjacencyList.put(9, Arrays.asList(8, 10, 12));
        adjacencyList.put(10, Arrays.asList(9, 11));
        adjacencyList.put(11, Arrays.asList(10, 12));
        adjacencyList.put(12, Arrays.asList(9, 11, 13));
        adjacencyList.put(13, Arrays.asList(12, 14, 15));
        adjacencyList.put(14, Arrays.asList(13));
        adjacencyList.put(15, Arrays.asList(3, 13));
        adjacencyList.put(16, Arrays.asList(17, 18));
        adjacencyList.put(17, Arrays.asList(16, 18));
        adjacencyList.put(18, Arrays.asList(16, 17));

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