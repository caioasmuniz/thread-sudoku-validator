public class Main {
  public static void main(String[] args) throws InterruptedException {
    ThreadValidator[][] workers = new ThreadValidator[3][9];

    for (int operation = 0; operation < 3; operation++)
      for (int index = 0; index < 9; index++)
        workers[operation][index] = new ThreadValidator(operation, index);

    for (int operation = 0; operation < 3; operation++)
      for (int index = 0; index < 9; index++)
        workers[operation][index].start();
  }
}
