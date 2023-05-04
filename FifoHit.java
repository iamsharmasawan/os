import java.util.*;

public class FifoHit {

    private int capacity;
    private Queue<Integer> queue;
    private Set<Integer> cache;
    private int hits;
    private int misses;

    public FifoHit(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.cache = new HashSet<>();
        this.hits = 0;
        this.misses = 0;
    }

    public void refer(int page) {
        if (cache.contains(page)) {
            hits++;
        } else {
            misses++;
            if (queue.size() == capacity) {
                int removedPage = queue.remove();
                cache.remove(removedPage);
            }
            queue.add(page);
            cache.add(page);
        }
    }

    public double getHitRatio() {
        if (hits + misses == 0) {
            return 0.0;
        }
        return (double) hits / (double) (hits + misses);
    }

    public double getMissRatio() {
        if (hits + misses == 0) {
            return 0.0;
        }
        return (double) misses / (double) (hits + misses);
    }

    public static void main(String[] args) {
        int[] pages = {1, 2, 3, 4, 5, 1, 2, 3, 6, 7, 8, 7, 8, 9, 3, 9};
        int capacity = 3;
        FifoHit cache = new FifoHit(capacity);
        for (int page : pages) {
            cache.refer(page);
        }
        System.out.println("Hit ratio: " + cache.getHitRatio());
        System.out.println("Miss ratio: " + cache.getMissRatio());
    }
}
