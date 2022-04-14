public class ThreadValidator extends Thread {
  private int operation;

  public ThreadValidator(int operation) {
    this.operation = operation;
  }
  
    @Override
    public void run() {
        Validator.validate(operation);
    }
}
