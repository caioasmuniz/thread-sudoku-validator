public class ThreadRow extends Thread{
    @Override
    public void run() {
        SudokuValidador.validateRow();
    }
}
