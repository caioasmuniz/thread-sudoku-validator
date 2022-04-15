public class Main {
  public static void main(String[] args) throws InterruptedException {
    ThreadValidator[][] workers = new ThreadValidator[3][9];

    System.out.println(
        "O programa indicara todas as linhas/colunas/subgrids invalidos no sudoku. Caso o sistema não aponte nenhuma, o sudoku eh valido.");

    for (int operation = 0; operation < 3; operation++)
      for (int index = 0; index < 9; index++)
        workers[operation][index] = new ThreadValidator(operation, index);

    for (int operation = 0; operation < 3; operation++)
      for (int index = 0; index < 9; index++)
        workers[operation][index].start();
  }
}
