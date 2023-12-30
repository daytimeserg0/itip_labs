import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMaxFinder {

    public static void main(String args[]) {
        int[][] matrix = {
                {2, 34, 1},
                {543, 58, 2},
                {43, 765, 20},
        };

        List<Integer> oneDMatrix = new ArrayList<>();
        for (int[] row : matrix) {
            for (int j : row) {
                oneDMatrix.add(j);
            }
        }

        int numThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int chunkSize = oneDMatrix.size() / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? oneDMatrix.size() : (i + 1) * chunkSize;

            List<Integer> subList = oneDMatrix.subList(startIndex, endIndex);

            executorService.execute(new MatrixHandlerTask(subList));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int maxElement = Integer.MIN_VALUE;
        for (MatrixHandlerTask task : MatrixHandlerTask.getTasks()){
            int taskMaxElement = task.getMaxi();
            if (taskMaxElement > maxElement) {
                maxElement = taskMaxElement;
            }
        }

        System.out.println("Max element: " + maxElement);
    }
}

class MatrixHandlerTask implements Runnable {
    private static List<MatrixHandlerTask> tasks = new ArrayList<>();

    private List<Integer> array;
    private int maxi;

    public MatrixHandlerTask(List<Integer> array) {
        this.array = array;
        addTask(this);
    }


    public void run() {
        maxi = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            int current = array.get(i);
            if (current > maxi) {
                maxi = current;
            }
        }
    }

    public int getMaxi() {
        return maxi;
    }

    private static synchronized void addTask(MatrixHandlerTask task) {
        tasks.add(task);
    }

    public static synchronized List<MatrixHandlerTask> getTasks() {
        return tasks;
    }
}