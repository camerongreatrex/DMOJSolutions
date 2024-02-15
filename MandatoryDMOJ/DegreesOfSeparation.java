package Test.MandatoryDMOJ;

import java.util.*;

public class DegreesOfSeparation {
    // Map to store each person and their direct connections aka friends
    private Map<Integer, Set<Integer>> friendships;

    // Constructor initializes the friendships map
    public DegreesOfSeparation() {
        friendships = new HashMap<>();
    }

    // Initializes friendships map using an adjacency list representing social connections
    public void initializeFriendships(Map<Integer, List<Integer>> adjacencyList) {
        // Iterate over the adjacency list to establish direct friendships
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int person = entry.getKey();
            List<Integer> friendsList = entry.getValue();

            // Ensure both the current person and their friends are added to the friendships map
            addPersonIfNotExists(person);
            for (int friend : friendsList) {
                addPersonIfNotExists(friend);
                // Establish mutual friendships between the person and each friend
                friendships.get(person).add(friend);
                friendships.get(friend).add(person);
            }
        }
    }

    // Establishes a new friendship between two people
    public void makeFriends(int x, int y) {
        addPersonIfNotExists(x);
        addPersonIfNotExists(y);
        // Adds each person as a friend to the other
        friendships.get(x).add(y);
        friendships.get(y).add(x);
    }

    // Removes the friendship connection between two people
    public void deleteFriendship(int x, int y) {
        // Checks if both people exist in the friendships map before attempting removal
        if (friendships.containsKey(x) && friendships.containsKey(y)) {
            friendships.get(x).remove(y);
            friendships.get(y).remove(x);
        }
    }

    // Returns the number of direct friends a person has
    public int numberOfFriends(int x) {
        // Checks if the person exists in the map, returning the size of their friends set
        return friendships.containsKey(x) ? friendships.get(x).size() : 0;
    }

    // Calculates the number of distinct "friends of friends" a person has, excluding direct friends
    public int numberOfFriendsOfFriends(int x) {
        Set<Integer> friends = friendships.getOrDefault(x, new HashSet<>());
        Set<Integer> friendsOfFriends = new HashSet<>();

        // Aggregate all friends of direct friends
        for (int friend : friends) {
            Set<Integer> friendsOfFriend = friendships.getOrDefault(friend, new HashSet<>());
            friendsOfFriends.addAll(friendsOfFriend);
        }

        // Exclude the original person and their direct friends from the count
        friendsOfFriends.removeAll(friends);
        friendsOfFriends.remove(x);

        return friendsOfFriends.size();
    }

    // Determines the shortest degree of separation between two people
    public String degreeOfSeparation(int x, int y) {
        if (x == y) return "0"; // Immediate return if both are the same person
        // Checks for the existence of both people in the network
        if (!friendships.containsKey(x) || !friendships.containsKey(y)) return "Not connected";

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distances = new HashMap<>();

        // Initialize the search with the starting person
        queue.offer(x);
        visited.add(x);
        distances.put(x, 0);

        // Breadth-first search to find the shortest path to the target person
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int distance = distances.get(current);

            for (int friend : friendships.get(current)) {
                if (!visited.contains(friend)) {
                    // Found the target person; return the current distance plus one
                    if (friend == y) return String.valueOf(distance + 1);
                    queue.offer(friend);
                    visited.add(friend);
                    distances.put(friend, distance + 1);
                }
            }
        }

        return "Not connected"; // No path found between x and y
    }

    // Helper method to add a person to the friendships map if they do not already exist
    private void addPersonIfNotExists(int person) {
        friendships.putIfAbsent(person, new HashSet<>());
    }

    // Main method to interact with the DegreesOfSeparation class through console commands
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DegreesOfSeparation graph = new DegreesOfSeparation();

        // Sample adjacency list initialization that is straight from DMOJ but not ideally usable
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Sample data from DMOJ
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

        // Add the data from the provided DMOJ data into the friendships map
        graph.initializeFriendships(adjacencyList);

        // Run the program based off user commands until "q" is inputted
        while (true) {
            String command = scanner.next();
            if (command.equals("q")) {
                break; // Break out of the loop
            }

            // Process various commands to manipulate and query the social network graph
            switch (command) {
                case "i": // Insert a new friendship
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    graph.makeFriends(x, y);
                    break;
                case "d": // Delete an existing friendship
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    graph.deleteFriendship(a, b);
                    break;
                case "n": // Number of direct friends
                    int c = scanner.nextInt();
                    System.out.println(graph.numberOfFriends(c));
                    break;
                case "f": // Number of friends of friends
                    int d = scanner.nextInt();
                    System.out.println(graph.numberOfFriendsOfFriends(d));
                    break;
                case "s": // Degree of separation between two people
                    int e = scanner.nextInt();
                    int f = scanner.nextInt();
                    System.out.println(graph.degreeOfSeparation(e, f));
                    break;
                default: // Invalid command
                    System.out.println("Invalid command");
            }
        }

        scanner.close();
    }
}
