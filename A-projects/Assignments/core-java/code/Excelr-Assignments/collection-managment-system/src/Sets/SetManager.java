package Sets;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;

public class SetManager
{
    private HashSet<Object> hset;

    public SetManager()
    {
        hset = new HashSet<>();
    }

    public boolean addElement(Object obj)
    {
        return hset.add(obj);
    }

    public boolean removeElement(Object obj)
    {
        return hset.remove(obj);
    }

    public void displaySet()
    {
        System.out.println(hset.toString());
    }

    public boolean empty()
    {
        return hset.isEmpty();
    }
}
