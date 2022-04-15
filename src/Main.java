public class Main {
    public static void main(String[] args) throws InterruptedException {
      ThreadValidator[] workers = new ThreadValidator[27];
      
      for (int operation = 0; operation < 3; operation++) 
        for (int index = 0; index < 9; index++) 
          workers[operation*3 + index] = new ThreadValidator(operation, index);
          
      for (int i = 0; i < workers.length; i++)
        workers[i].start();
    }
}
