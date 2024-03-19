package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainThread
{
    private static volatile boolean isRunning = true;
    public static void runThreads()
    {
        Thread1 t1 = new Thread1(0);
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.start();
        t2.start();
        t3.start();
    }

    public static void sharedMemoryThreads()
    {
        RunningEngine r = new RunningEngine();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }

    public static void threadCommunication()
    {

        SharedResource obj = new SharedResource();
        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);

    }

    public static void sleepThread(long timeValue)
    {
        Thread1 t1 = new Thread1(timeValue);                                       //04-03-2024
        t1.start();

    }

    public static void threadInterruption()
    {
        Thread2 t2 = new Thread2();
        t2.start();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "Interrupting sleep of " + t2.getName());

        t2.interrupt();
    }

    public static void threadTerminationExample()
    {
        Thread myThread = new Thread(() -> {
            while (isRunning) {
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread is terminating...");
        });

        myThread.start();

        // Simulating some condition to stop the thread
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Signaling the thread to stop
        isRunning = false;

    }

    public static void threadPool()
    {
        ExecutorService service =  Executors.newFixedThreadPool(3);

        for(int i = 0 ; i < 10 ; i++)
        {
            service.execute(new Task());

        }

//        int coreCount = Runtime.getRuntime().availableProcessors();
//        System.out.println(coreCount);
        service.shutdown();
    }

    public static void synchronizedThreads()
    {
        ThreadSynchronization ts = new ThreadSynchronization();

        Thread t1 = new Thread( () -> {
            try
            {
                ts.waitForCondition();

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
           try
           {
               Thread.sleep(3000);
               System.out.println(Thread.currentThread().getName()+" : Signaled condition");
               ts.signalCondition();

           }
           catch(InterruptedException e)
           {
               e.printStackTrace();
           }
        });

        t1.start();
        t2.start();
    }

    public static void deadLockExample()                                                            // 05-03-2024
    {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Thread t1 = new Thread(() -> {

           synchronized (obj1)
           {
                System.out.println("Holding lock1.......");
                try { Thread.sleep(1000);} catch(InterruptedException e) { e.printStackTrace();}
                System.out.println("Trying to acquire lock2......");
                synchronized (obj2)
                {
                    System.out.println("Holding lock1 and lock2");
                }
           }
        });

        Thread t2 = new Thread(() -> {

            synchronized (obj2)
            {
                System.out.println("Holding lock2.......");
                try { Thread.sleep(1000);} catch(InterruptedException e) { e.printStackTrace();}
                System.out.println("Trying to acquire lock1......");
                synchronized (obj1)
                {
                    System.out.println("Holding lock1 and lock2");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void deadlockPrevention()                                                            // 05-03-2024
    {
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println("** We can prevent deadlock by implementing serial or sequential resource allocation (avoiding nested locks and ensuring locks are acquired in fixed order. ");

        Thread t1 = new Thread(() -> {

            synchronized (obj1)
            {
                System.out.println("Holding lock1.......");
                try { Thread.sleep(1000);} catch(InterruptedException e) { e.printStackTrace();}
                System.out.println("Trying to acquire lock2......");
                synchronized (obj2)
                {
                    System.out.println("Holding lock1 and lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (obj1)
            {
                System.out.println("Thread 2: ");
                System.out.println("Holding lock1.......");
                try { Thread.sleep(1000);} catch(InterruptedException e) { e.printStackTrace();}
                System.out.println("Trying to acquire lock2......");
                synchronized (obj2)
                {
                    System.out.println("Holding lock1 and lock2");
                }
            }
        });
        System.out.println("Thread 1: ");
        t1.start();
        t2.start();
    }

    public static void parallelComputation()
    {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future> allFutures = new ArrayList<>();

        for(int i = 0; i < 10; i++)
        {
            Future<Integer> future = service.submit(new ReturnableTask());
            // Implementing callable interface using lambda expression
/*            Future<Integer> future1 = service.submit(() -> {
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    System.err.println("Thread got interrupted : " + e.getMessage());
                }
                // this task will return random between 0 and 100
                return new Random().nextInt(100);
            });*/
            allFutures.add(future);
        }

        // here we can perform parallel tasks
        for (int i = 0; i < 15; i++)
        {
            System.out.println("Main thread is running tasks in parallel............");
        }


        for(int i = 0; i < 10; i++)
        {
            Integer result = 0;
            try
            {
                Future<Integer> future = allFutures.get(i);
                result = future.get();
                System.out.println("Result of future #" + i + "= " + result);
            } catch (InterruptedException | ExecutionException e)
            {
                System.err.println(" Result unobtainable : " + e.getMessage());
            }
        }

        // To kill the thread pool
        service.shutdown();
    }

}



