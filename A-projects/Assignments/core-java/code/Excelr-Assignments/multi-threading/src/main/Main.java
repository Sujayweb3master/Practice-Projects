package main;

import threading.MainThread;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        // a thread is being used to detect any deadlock in the background
        {
            Thread thread = new Thread(() ->
            {
                // thread local variable
                boolean flag = true;
                while (flag)
                {
                    flag = detectDeadLock();
                }
            });
            thread.setDaemon(true);
            System.out.println(thread.isDaemon());
            thread.start();
        }

        int value = Runtime.getRuntime().availableProcessors();

        System.out.println(value);


        System.out.println("Welcome to Operations involving Multi-Threads Console:");
        System.out.println();
        System.out.println("Please enter your choice from the list : ");
        System.out.println("1. Create and start multiple threads");
        System.out.println("2. Synchronized threads to avoid race conditions and ensure data consistency");
        System.out.println("3. Using wait() and notify() to implement thread communication");
        System.out.println("4. Use sleep() to pause threads for a specified duration");
        System.out.println("5. Demonstrate thread interruption");
        System.out.println("6. Use thread pools to manage a group of threads efficiently");
        System.out.println("7. Implement thread synchronization using locks and conditions");
        System.out.println("8. Demonstrate deadlock.");
        System.out.println("9. Deadlock Prevention.");
        System.out.println("10. Use Executors and Callable to perform parallel computation and get results.");
        System.out.println("11. Implement producer-consumer problem using thread synchronization.");
        System.out.println("12. Thread termination.");

        choice = sc.nextInt();
        sc.nextLine();

        switch (choice)
        {
            case 1:
                System.out.println("Multiple threads running:");
                MainThread.runThreads();
                break;

            case 2:
                System.out.println("Synchronized threading:");
                MainThread.sharedMemoryThreads();
                break;

            case 3:
                System.out.println("Working:");
                MainThread.threadCommunication();
                break;

            case 4:                                                         //04-03-2024
                long timeValue = 0;
                try
                {
                    timeValue = sc.nextInt();
                    sc.nextLine();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("Sleep operation working: ");
                MainThread.sleepThread(timeValue);
                break;

            case 5:
                System.out.println("Demonstration of interruption: ");
                MainThread.threadInterruption();
                break;

            case 6:
                System.out.println("Thread Pool implementation: ");
                MainThread.threadPool();
                break;

            case 7:
                System.out.println("Implementation of thread Synchronization: ");
                MainThread.synchronizedThreads();
                break;

            case 8:
                System.out.println("Deadlock Example:");
                MainThread.deadLockExample();
                break;

            case 9:
                System.out.println("Deadlock Prevention:");
                MainThread.deadlockPrevention();
                break;

            case 10:
                System.out.println("Parallel Computation:");
                MainThread.parallelComputation();
                break;

            case 11:
                System.out.println("Implementation: ");
                MainThread.threadCommunication();
                break;

            case 12:
                System.out.println("Terminating a thread gracefully:");
                MainThread.threadTerminationExample();
                break;

            default:
                System.out.println("You entered an invalid choice!!!");
                System.out.println("Please enter one of the available options");
        }

        //To indicate that main thread has finished execution
//        System.out.println("Main thread is finished");

    }






    public static boolean detectDeadLock()
    {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadBean.findDeadlockedThreads();
        boolean deadlock = threadIds != null && threadIds.length > 0;
        if (deadlock)
        {
            System.out.println("Deadlocks found: " + true);
            System.out.println(Arrays.toString(threadIds));
            return false;
        }
        return true;
    }
}