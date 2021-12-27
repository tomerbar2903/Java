import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Subtask> subtasks;

    public Scheduler()
    {
        this.subtasks = new ArrayList<Subtask>();
    }

    public void addSubtask()
    {
        Subtask s = new Subtask();
        this.subtasks.add(s);
    }

    public int schedulerSize()
    {
        return this.subtasks.size();
    }

    public void assign(String message)
    {
        int id = Utilities.getIDfromMessage(message);
        String realMessage = Utilities.removeID(message);
        this.subtasks.get(id).addTask(realMessage);
    }

    public void startAll()
    {
        for (int i = 0 ; i < this.subtasks.size() ; i++)
        {
            this.subtasks.get(i).start();
        }
    }

    public void stopAll()
    {
        Utilities.broadcastStop(this.subtasks);
    }
}
