import java.util.Timer;
import java.util.TimerTask;

/**
 * @author XUAN
 * @date 2021/3/13 - 11:12
 * @references
 * @purpose
 * @errors
 */
public class FindThread {
    public static void main(String[] args) {
        String timerName = "timer1";
        Timer timer = new Timer(timerName);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(12);
            }
        };


        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                for(int i = 0; i <= 2000000; i++) {
                    //判断是否被中断
                    if(Thread.currentThread().isInterrupted()){
                        //处理中断逻辑
                        break;
                    }
                    System.out.println(i);
                }
            }
        }, 1);// 设定指定的时间time,此处为2000毫秒

        Thread thread = findThreadByName(timerName);
//        System.out.println(thread.getName());
        thread.interrupt();
////        thread.stop();
    }


    public static Thread findThreadByName(String target){
        Thread thread = new Thread();
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;

        /* 遍历线程组树，获取根线程组 */
        while ( group != null )
        {
            topGroup    = group;
            group        = group.getParent();
        }
        /* 激活的线程数加倍 */
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];

        /* 获取根线程组的所有线程 */
        int actualSize = topGroup.enumerate( slackList );
        /* copy into a list that is the exact size */
        Thread[] list = new Thread[actualSize];
        System.arraycopy( slackList, 0, list, 0, actualSize );


        //
        for (Thread t:list){
            if (t.getName().equals(target)){
                return t;
            }
        }
        return null;
    }


}
