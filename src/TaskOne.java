public class TaskOne {

    private String status = "A";


    public static void main(String[] args) {
        TaskOne task = new TaskOne();
        new Thread(new TestThread(task, "A")).start();
        new Thread(new TestThread(task, "B")).start();
        new Thread(new TestThread(task, "C")).start();
    }

    private static class TestThread implements Runnable {

        final TaskOne task;
        String string;

        public TestThread(TaskOne task, String string) {
            this.task = task;
            this.string = string;
        }

        @Override
        public void run() {
            synchronized (task) {
                for (int i = 0; i < 5; i++) {
                    while (!task.status.equals(string)) {
                        try {
                            task.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(string);
                    switch (string) {
                        case "A":
                            task.status = "B";
                            break;
                        case "B":
                            task.status = "C";
                            break;
                        case "C":
                            task.status = "A";
                            break;
                    }
                    task.notifyAll();
                }
            }
        }
    }
}
