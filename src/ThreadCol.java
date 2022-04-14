public class ThreadCol extends Thread{
    @Override
    public void run() {
        SudokuValidador.validateColumn();
    }
}
