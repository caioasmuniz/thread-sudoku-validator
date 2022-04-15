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
    if (Validator.isValid())
      System.out.print("O sudoku eh valido ");
    else
      System.out.print("O sudoku NAO eh valido ");
    switch (operation) {
      case 0:
        System.out.print("na linha ");
        break;
      case 1:
        System.out.print("na coluna ");
        break;
      case 3:
        System.out.print("no subgrid ");
        break;
    }
    System.out.print(index + 1);
  }
}