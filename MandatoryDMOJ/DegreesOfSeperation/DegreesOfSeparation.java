package Test.MandatoryDMOJ.DegreesOfSeperation;

import java.util.*;

/**
 * The DegreesOfSeparation class is a program that simulates a social network graph where people can be friends with each other.
 * @author Cameron Greatrex & Julian Chen
 * @version 1.0
 */

public class DegreesOfSeparation {
    // Map to store each person and their direct connections aka friends
    static Map<Integer, Set<Integer>> friendships = new HashMap<>();

    /**
     * Initializes the friendships map with the provided DMOJ data.
     * @param friendships A map declared but not yet initialized with a key representing a person and a value
     *                    representing a set of their friends.
     * @revision 1
     */
    public static void initializeFriendships(Map<Integer, Set<Integer>> friendships) {
        // Iterate over the set to establish direct friendships
        for (HashMap.Entry<Integer, Set<Integer>> entry : friendships.entrySet()) {
            // Get the person and their friends
            int person = entry.getKey();
            Set<Integer> friendsSet = entry.getValue();

            // Ensure both the current person and their friends are added to the friendships map
            addPersonIfNotExists(person);
            for (int friend : friendsSet) {
                addPersonIfNotExists(friend);
                // Establish mutual friendships between the person and each friend
                friendships.get(person).add(friend);
                friendships.get(friend).add(person);
            }
        }
    }

    /**
     * Establishes a new friendship between two people.
     * @param x The first person to be friends with the second person.
     * @param y The second person to be friends with the first person.
     * @revision 1
     */
    public static void makeFriends(int x, int y) {
        // Adds both people to the friendships map if they do not already exist
        addPersonIfNotExists(x);
        addPersonIfNotExists(y);
        // Adds each person as a friend to the other if the two friends are not the same person
        if(!(x == y)) {
            friendships.get(x).add(y);
            friendships.get(y).add(x);
        }
    }

    /**
     * Removes the friendship connection between two people.
     * @param x The first person to have their friendship removed with the second person.
     * @param y The second person to have their friendship removed with the first person.
     * @revision 1
     */
    public static void deleteFriendship(int x, int y) {
        // Checks if both people exist in the friendships map before attempting removal
        if (friendships.containsKey(x) && friendships.containsKey(y) && friendships.get(x).contains(y) && friendships.get(y).contains(x)){
            // Removes each person as a friend from the other because they are no longer friends and hate each other
            friendships.get(x).remove(y);
            friendships.get(y).remove(x);
        }
    }

    /**
     * Returns the number of direct friends a person has.
     * @param x The person to check the number of friends for.
     * @return The number of direct friends the person has.
     * @revision 1
     */
    public static int numberOfFriends(int x) {
        // Checks if the person exists in the map, returning the size of their friends set
        return friendships.containsKey(x) ? friendships.get(x).size() : 0;
    }

    /**
     * Adds a person to the friendships map if they do not already exist.
     * @param person The person to add to the friendships map.
     * @revision 1
     */
    private static void addPersonIfNotExists(int person) {
        // Add the person as a key if they do not exist in the map
        friendships.putIfAbsent(person, new HashSet<>());
    }

    /**
     * IMPORTANT: The following methods have been revised to improve the efficiency and readability of the code.
     * REVISION 2 STARTS HERE
     */

    /**
     * Returns the number of friends of friends a person has excluding direct friends.
     * @param x The person to check the number of friends of friends for.
     * @return The number of friends of friends the person has.
     * @revision 2
     */
    public static int numberOfFriendsOfFriends(int x) {
        // Parse the direct friends of the person
        Set<Integer> friends = friendships.get(x);
        // Create a set to store the friends of friends
        Set<Integer> friendsOfFriends = new HashSet<>();

        // Aggregate all friends of direct friends
        for (int friend : friends) {
            //create a set of friends of friends by having friend as the key and the value as the set of friends of friend
            Set<Integer> friendsOfFriend = friendships.get(friend);
            // add all the friends of friend found to the set of friends of friends
            friendsOfFriends.addAll(friendsOfFriend);
        }

        // Exclude the original person and their direct friends from the count
        friendsOfFriends.removeAll(friends);
        friendsOfFriends.remove(x);

        // Return the amount of friends of friends
        return friendsOfFriends.size();
    }

    /**
     * Determines the shortest degree of separation between two people.
     * @param x The first person to find the degree of separation from the second person.
     * @param y The second person to find the degree of separation from the first person.
     * @return The shortest degree of separation between the two people.
     * @revision 2
     */
    public static String degreeOfSeparation(int x, int y) {
        // Check if we're looking for a connection to the same person
        if (x == y) {
            return "0"; // No distance needed, because they are the same person
        }

        // Make sure both people are in our network
        if (!friendships.containsKey(x) || !friendships.containsKey(y)) {
            return "Not connected"; // One or both people are not in the network
        }

        // Setup for finding the connection
        Set<Integer> visited = new HashSet<>(); // HashSet to track who we've already looked at
        Queue<Integer> queue = new LinkedList<>(); // Queue to keep ordered track of whom to look at next
        Map<Integer, Integer> distances = new HashMap<>(); // HashMap Keep track of the person and the distance to the other friend

        // Start with x (the first person) then compare them to the other friend by looping through the network
        queue.offer(x); // Remove the first person from the queue
        visited.add(x); // Say we've looked at the first person
        distances.put(x, 0); // State that the same person is 0 steps from themselves

        // Look through the network until we find the second person or run out of connections while tracking the distance of each friend in the network
        while (!queue.isEmpty()) {
            // Remove and get the next person from the queue to explore their friends.
            int current = queue.poll();
            // Retrieve the current distance from x to this person. This distance represents the number of steps taken from x to reach the current person in the BFS traversal.
            int distance = distances.get(current);

            // Iterate through all friends (direct connections) of the current person.
            for (int friend : friendships.get(current)) {
                // Proceed only if this friend hasn't been visited already to avoid cycles and redundant checks.
                if (!visited.contains(friend)) {
                    // If the current friend is the target person y, a shortest path is found.
                    if (friend == y) {
                        // Return the number of steps from x to y, which is the current distance plus one (since y is a direct friend of the current person).
                        return String.valueOf(distance + 1);
                    }
                    // If this friend is not y, add them to the queue for further exploration of their friends in subsequent iterations.
                    queue.offer(friend);
                    // Mark this friend as visited to prevent revisiting.
                    visited.add(friend);
                    // Record the number of steps taken to reach this friend from x. It's the current distance plus one because we've moved one step further in the network.
                    distances.put(friend, distance + 1);
                }
            }
        }

        // If we've looked at x and y and didn't find a way to get to each other, then they're not connected
        return "Not connected";
    }

    /**
     * The main method to interact with the DegreesOfSeparation class through console commands.
     * @param args The command-line arguments passed to the program.
     * @revision 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add the initial DMOJ data to the friendships map
        friendships.put(1, new HashSet<>(Arrays.asList(6)));
        friendships.put(2, new HashSet<>(Arrays.asList(6)));
        friendships.put(3, new HashSet<>(Arrays.asList(4, 5, 6, 15)));
        friendships.put(4, new HashSet<>(Arrays.asList(3, 5, 6)));
        friendships.put(5, new HashSet<>(Arrays.asList(3, 4, 6)));
        friendships.put(6, new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        friendships.put(7, new HashSet<>(Arrays.asList(6, 8)));
        friendships.put(8, new HashSet<>(Arrays.asList(7, 9)));
        friendships.put(9, new HashSet<>(Arrays.asList(8, 10, 12)));
        friendships.put(10, new HashSet<>(Arrays.asList(9, 11)));
        friendships.put(11, new HashSet<>(Arrays.asList(10, 12)));
        friendships.put(12, new HashSet<>(Arrays.asList(9, 11, 13)));
        friendships.put(13, new HashSet<>(Arrays.asList(12, 14, 15)));
        friendships.put(14, new HashSet<>(Arrays.asList(13)));
        friendships.put(15, new HashSet<>(Arrays.asList(3, 13)));
        friendships.put(16, new HashSet<>(Arrays.asList(17, 18)));
        friendships.put(17, new HashSet<>(Arrays.asList(16, 18)));
        friendships.put(18, new HashSet<>(Arrays.asList(16, 17)));

        // Initialize the data from the provided DMOJ data into the friendships map
        initializeFriendships(friendships);

        // Run the program based off user commands until "q" is inputted
        String command;
        do {
            command = scanner.next();
            // Process various commands to manipulate and query the social network graph
            switch (command) {
                case "i": // Insert a new friendship
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    makeFriends(x, y);
                    break;
                case "d": // Delete an existing friendship
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    deleteFriendship(a, b);
                    break;
                case "n": // Number of direct friends
                    int c = scanner.nextInt();
                    System.out.println(numberOfFriends(c));
                    break;
                case "f": // Number of friends of friends
                    int d = scanner.nextInt();
                    System.out.println(numberOfFriendsOfFriends(d));
                    break;
                case "s": // Degree of separation between two people
                    int e = scanner.nextInt();
                    int f = scanner.nextInt();
                    System.out.println(degreeOfSeparation(e, f));
                    break;
            }
        } while (!command.equals("q"));
        scanner.close();
    }
}
