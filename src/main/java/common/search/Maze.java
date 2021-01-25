package common.search;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 * @author lihailong
 * @since 2021/1/23 0023
 */
public class Maze {

    private final int rows, columns;
    private final MazeLocation start, goal;

    private Cell[][] grid;

    public Maze(int rows, int columns, MazeLocation start, MazeLocation goal, double sparseness) {
        this.rows = rows;
        this.columns = columns;
        this.start = start;
        this.goal = goal;
        grid = new Cell[rows][columns];
        for (Cell[] row : grid) {
            Arrays.fill(row, Cell.EMPTY);
        }

        randomlyFill(sparseness);

        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    private void randomlyFill(double sparseness) {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                if (Math.random() < sparseness) {
                    grid[row][column] = Cell.BLOCKED;
                }
            }
        }
    }

    public Maze() {
        this(10, 10, new MazeLocation(0, 0), new MazeLocation(9, 9), 0.2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                sb.append(cell.toString());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public boolean goalTest(MazeLocation ml) {
        return goal.equals(ml);
    }

    public List<MazeLocation> successors(MazeLocation ml) {
        List<MazeLocation> locations = new ArrayList<>();
        if (ml.row + 1 < rows && grid[ml.row + 1][ml.column] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row + 1, ml.column));
        }

        if (ml.row - 1 >= 0 && grid[ml.row - 1][ml.column] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row - 1, ml.column));
        }

        if (ml.column + 1 < columns && grid[ml.row][ml.column + 1] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row, ml.column + 1));
        }

        if (ml.column - 1 >= 0 && grid[ml.row][ml.column - 1] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row, ml.column - 1));
        }

        return locations;
    }

    public double manhattanDistance(MazeLocation ml) {
        int xdist = Math.abs(ml.column - goal.column);
        int ydist = Math.abs(ml.row - goal.row);
        return (xdist + ydist);
    }

    public static <T> Node<T> dfs(
            T initial, Predicate<T> goalTest, Function<T, List<T>> successors) {
        // frontier is where we have yet to go.
        Stack<Node<T>> frontier = new Stack<>();
        frontier.push(new Node<>(initial, null));
        // explored is where we have been
        Set<T> explored = new HashSet<>();
        explored.add(initial);

        // keep going where there is more to explore.
        while (!frontier.isEmpty()) {
            Node<T> currentNode = frontier.pop();
            T currentState = currentNode.state;
            if (goalTest.test(currentState)) {
                return currentNode;
            }

            for (T child : successors.apply(currentState)) {
                if (explored.contains(child)) {
                    continue;
                }
                explored.add(child);
                frontier.push(new Node<>(child, currentNode));
            }
        }

        return null;
    }

    public static <T> Node<T> bfs(
            T initial, Predicate<T> goalTest, Function<T, List<T>> successors) {
        Queue<Node<T>> frontier = new LinkedList<>();

        frontier.offer(new Node<>(initial, null));

        Set<T> explored = new HashSet<>();
        explored.add(initial);

        while (!frontier.isEmpty()) {
            Node<T> currentNode = frontier.poll();
            T currentState = currentNode.state;
            if (goalTest.test(currentState)) {
                return currentNode;
            }
            for (T child : successors.apply(currentState)) {
                if (explored.contains(child)) {
                    continue;
                }
                explored.add(child);
                frontier.offer(new Node<>(child, currentNode));
            }
        }

        return null;
    }

    public static <T> Node<T> astar(
            T initial,
            Predicate<T> goalTest,
            Function<T, List<T>> successors,
            ToDoubleFunction<T> heuristic) {

        PriorityQueue<Node<T>> frontier = new PriorityQueue<>();
        frontier.offer(new Node<>(initial, null, 0.0, heuristic.applyAsDouble(initial)));

        Map<T, Double> explored = new HashMap<>();
        explored.put(initial, 0.0);
        // keep going while there is more explore
        while (!frontier.isEmpty()) {
            Node<T> currentNode = frontier.poll();
            T currentState = currentNode.state;
            if (goalTest.test(currentState)) {
                return currentNode;
            }

            for (T child : successors.apply(currentState)) {
                double newCost = currentNode.cost + 1;
                if (!explored.containsKey(child) || explored.get(child) > newCost) {
                    explored.put(child, newCost);
                    frontier.offer(
                            new Node<>(
                                    child, currentNode, newCost, heuristic.applyAsDouble(child)));
                }
            }
        }

        return null;
    }

    public static <T> List<T> nodeToPath(Node<T> node) {
        List<T> path = new ArrayList<>();
        path.add(node.state);

        // work backwards from end to start
        while (node.parent != null) {
            node = node.parent;
            path.add(0, node.state);
        }

        return path;
    }

    public void mark(List<MazeLocation> path) {
        for (MazeLocation ml : path) {
            grid[ml.row][ml.column] = Cell.PATH;
        }

        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public void clear(List<MazeLocation> path) {
        for (MazeLocation ml : path) {
            grid[ml.row][ml.column] = Cell.EMPTY;
        }

        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public enum Cell {
        EMPTY(" "),
        BLOCKED("X"),
        START("S"),
        GOAL("G"),
        PATH("*");

        private final String code;

        Cell(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    public static class MazeLocation {
        public final int row;
        public final int column;

        public MazeLocation(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MazeLocation that = (MazeLocation) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    public static class Node<T> implements Comparable<Node<T>> {

        final T state;
        Node<T> parent;
        double cost;
        double heuristic;

        Node(T state, Node<T> parent) {
            this.state = state;
            this.parent = parent;
        }

        Node(T state, Node<T> parent, double cost, double heuristic) {
            this.state = state;
            this.parent = parent;
            this.cost = cost;
            this.heuristic = heuristic;
        }

        @Override
        public int compareTo(Node<T> other) {
            Double mine = cost + heuristic;
            Double theirs = other.cost + other.heuristic;
            return mine.compareTo(theirs);
        }
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        System.out.println(maze.toString());

        Node<MazeLocation> solution1 = Maze.dfs(maze.start, maze::goalTest, maze::successors);
        if (solution1 == null) {
            System.out.println("No solution found using depth-first search");
        } else {
            List<MazeLocation> path1 = Maze.nodeToPath(solution1);
            maze.mark(path1);
            System.out.println(maze);
            maze.clear(path1);
        }

        Node<MazeLocation> solution2 = Maze.bfs(maze.start, maze::goalTest, maze::successors);
        if (solution2 == null) {
            System.out.println("No solution found using bread-first search");
        } else {
            List<MazeLocation> path2 = Maze.nodeToPath(solution2);
            maze.mark(path2);
            System.out.println(maze);
            maze.clear(path2);
        }

        Node<MazeLocation> solution3 =
                Maze.astar(maze.start, maze::goalTest, maze::successors, maze::manhattanDistance);

        if (solution3 == null) {
            System.out.println("No solution found using A*!");
        } else {
            List<MazeLocation> path3 = Maze.nodeToPath(solution3);
            maze.mark(path3);
            System.out.println(maze);
            maze.clear(path3);
        }
    }
}
