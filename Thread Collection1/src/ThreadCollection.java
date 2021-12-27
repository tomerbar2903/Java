public class ThreadCollection extends Thread {
    private static final int MAX_LENGTH_OF_MESSAGE = 20;
    private static final int MIN_LENGTH_OF_MESSAGE = 3;
    private Scheduler scheduler;
    private boolean run;

    public ThreadCollection()
    {
        this.scheduler = new Scheduler();
        this.run = true;
    }

    public ThreadCollection(int amountOfThreads)
    {
        this.scheduler = new Scheduler();
        for (int i = 0 ; i < amountOfThreads ; i++)
        {
            this.scheduler.addSubtask();
        }
        this.run = true;
    }

    public void setRun(boolean run) { this.run = run; }

    public void stopThreadCollection() { this.run = false; }

    public synchronized void run()
    {
        this.scheduler.startAll();
        int id = (int)((Math.random() * this.scheduler.schedulerSize()) + 1);
        int length = (int)((Math.random() * ThreadCollection.MAX_LENGTH_OF_MESSAGE) + ThreadCollection.MIN_LENGTH_OF_MESSAGE);
        String message;
        while (this.run)
        {
            message = Utilities.generator(length);
            message = Utilities.addID(message, id);
            this.scheduler.assign(message);
            id = (int)((Math.random() * this.scheduler.schedulerSize()) + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            length = (int)((Math.random() * ThreadCollection.MAX_LENGTH_OF_MESSAGE) + ThreadCollection.MIN_LENGTH_OF_MESSAGE);
        }
        this.scheduler.stopAll();
    }
}
