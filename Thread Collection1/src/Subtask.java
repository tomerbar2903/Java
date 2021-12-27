import java.util.PriorityQueue;

public class Subtask extends Thread{
    private PriorityQueue<String> commands;
    private static int counter = 0;
    private int id;

    public Subtask()
    {
        this.id = ++Subtask.counter;
        this.commands = new PriorityQueue<String>();
    }

    public synchronized void addTask(String command)
    {
        String realCommand = Utilities.removeID(command);
        this.commands.add(realCommand);
        notify();
    }

    public String getTask()
    {
        return this.commands.poll();
    }

    @Override
    public long getId() {
        return id;
    }

    public synchronized void run()
    {
        // waits for queue to fill up
        if (this.commands.isEmpty())
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String command = this.getTask();

        // while stop running isn't a command
        while (!command.equals("stop running"))
        {
            System.out.println("--- Thread " + this.id + ":\n\t\t\t\t>>> " + command + "\n\n");
            try {
                this.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.commands.isEmpty())
            {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            command = this.getTask();
        }
    }
}
