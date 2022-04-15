public class ThreadValidator extends Thread {
  private int operation;
  private int index;

  public ThreadValidator(int operation,int index) {
    this.operation = operation;
    this.index = index;
  }
  
    @Override
    public void run() {
		Validator.validate(operation, index);
    }
}