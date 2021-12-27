import java.util.ArrayList;

public class Utilities {

    public static String removeID(String command)
    {
        return command.substring(1);
    }

    public static String generator(int length)
    {
        String st = "";
        for ( int i = 0 ; i < length ; i++ )
        {
            st += (char)((Math.random() * 26) + 'a');
        }
        return st;
    }

    public static String addID(String command, long id)
    {
        String s = (char)(id + '0') + command;
        return s;
    }

    public static void broadcastStop(ArrayList<Subtask> threads)
    {
        String message = "stop running";
        String individual = "stop running";
        int i;
        for ( i = 0 ; i < threads.size() ; i++ )
        {
            individual = addID(individual, i);
            threads.get(i).addTask(individual);
            individual = message;
        }
    }

    public static int getIDfromMessage(String message)
    {
        return (int)(message.charAt(0) - '1');
    }

}
