package lists;

import java.util.ArrayList;
public class ListManager
{
    private ArrayList<Object> alist;

    public ListManager()
    {
        alist = new ArrayList<>();
    }

    public void addOperation(Object value)
    {
        alist.add(value);
    }

    public boolean removeOperation(Object value)
    {
        return alist.remove(value);

    }

    public void displayOperation()
    {
        System.out.println(alist.toString());
    }

    public boolean exists(Object value)
    {
        return alist.contains(value);
    }

    public boolean empty()
    {
        return alist.isEmpty();
    }

}
