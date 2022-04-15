public class ThreadValidator extends Thread {
  private int operation;
  private int index;

  public ThreadValidator(int operation, int index) {
    this.operation = operation;
    this.index = index;
  }

  @Override
  public void run() {
    Validator.validate(operation, index);
    if (!Validator.isValid())
      switch (operation) {
        case 0:
          System.out.println("Invalido na linha " + (index + 1));
          break;
        case 1:
          System.out.println("Invalido na coluna " + (index + 1));
          break;
        case 2:
          System.out.println("Invalido no subgrid " + (index + 1));
          break;
      }
  }
}