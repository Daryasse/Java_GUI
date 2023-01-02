import java.util.Random;
import java.lang.Thread;

public class potoki {

  public static void main(String[] args) {
NewThread [] thread  = new NewThread[5];
char letter = 'a';
for (int i = 0; i< thread.length; i++){
     thread[i] = new NewThread(letter);
     letter++;
    }
for (int i = 0; i< thread.length; i++){
  thread[i].start();
 }
thread[0].pause();
    //0'st is paused
    for (int i = 0; i<10; i++){
      //waiting 5 seconds
      Sleep(5000);
      // resume i'th thread
      // pause (i+1)'th thread
     int currentValue = i%thread.length;
     int nextValue = (i+1)%thread.length;
      System.out.println();
      System.out.print("Resuming "+ thread[currentValue].letter+", suspending "+thread[nextValue].letter+": ");
     thread [currentValue].unpause();
     thread [nextValue].pause();
    }
    for (int i = 0; i<thread.length; i++){
      thread[i].shutDown();
    }
  }

  public static void Sleep(int millis){
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}



class NewThread extends Thread {

  public char letter;
  private volatile boolean running = true;
  private volatile boolean paused = false;
  private Object pauseLock = new Object();

  public NewThread(char letter) {
    this.letter = letter;
  }

  public void shutDown(){
    running = false;
  }
  public void pause(){
    paused = true;
  }
  public void unpause(){
    synchronized (pauseLock){
      paused = false;
      pauseLock.notify();
    }
  }
  @Override
  public void run() {
    Random random = new Random();
    while (running){
      synchronized (pauseLock) {
        if (paused) {
          try {
            pauseLock.wait();
          } catch (InterruptedException ex) {
            break;
          }
        }
      }
      System.out.print(letter);
      int millis = random.nextInt((1001-100)+100);
      potoki.Sleep(millis);
    }
    System.out.println();
    System.out.print("Thread " + letter + " exits");
  }
}
