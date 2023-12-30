import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Transfer {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(List.of(20, 30, 50, 70, 20, 40, 80));

        int numWorkers = 3;
        int maxWeightPerTrip = 150;

        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numWorkers);

        List<Loader> loaders = new ArrayList<>();
        for (int i = 0; i < numWorkers; i++) {
            loaders.add(new Loader(startSignal, doneSignal, weights, maxWeightPerTrip, i + 1));
        }

        loaders.forEach(Loader::start);
        startSignal.countDown();

        try {
            doneSignal.await();
            System.out.println("Работа выполнена.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Loader extends Thread {
    private CountDownLatch startSignal;
    private CountDownLatch doneSignal;
    private List<Integer> weights;
    private int maxWeightPerTrip;
    private int workerNum;

    public Loader(CountDownLatch startSignal, CountDownLatch doneSignal, List<Integer> weights, int maxWeightPerTrip, int workerNum) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.weights = weights;
        this.maxWeightPerTrip = maxWeightPerTrip;
        this.workerNum = workerNum;
    }

    @Override
    public void run() {
        try {
            startSignal.await();

            int totalWeight = 0;
            while (!weights.isEmpty()) {
                int nextWeight = weights.get(0);

                if (totalWeight + nextWeight <= maxWeightPerTrip) {
                    totalWeight += nextWeight;
                    weights.remove(0);

                    System.out.println("Рейс " + workerNum + ": товар весом " + nextWeight + " кг. Всего: " + totalWeight + " кг.");
                } else {
                    break;
                }
            }

            System.out.println("Рейс " + workerNum + ": успешно донесен товар.");
            doneSignal.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}