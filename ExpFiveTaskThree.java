class Worker {
    String name;
    double salaryRate;

    Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    double computePay(int hours) {
        return 0;
    }
}

class DailyWorker extends Worker {
    DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    double computePay(int hours) {
        return (hours / 8) * salaryRate;
    }
}

class SalariedWorker extends Worker {
    SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    double computePay(int hours) {
        return 40 * salaryRate;
    }
}

public class ExpFiveTaskThree {
    public static void main(String[] args) {
        Worker dailyWorker = new DailyWorker("Ritika", 100);
        Worker salariedWorker = new SalariedWorker("Malvika", 99);

        System.out.println(dailyWorker.name + "'s weekly pay: " + dailyWorker.computePay(48));
        System.out.println(salariedWorker.name + "'s weekly pay: " + salariedWorker.computePay(60));
    }
}