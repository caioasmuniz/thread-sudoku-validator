public class Validator {
  private static final int [][] sudoku = {
    {2, 3, 7, 8, 4, 1, 5, 6, 9},
    {1, 8, 6, 7, 9, 5, 2, 4, 3},
    {5, 9, 4, 3, 2, 6, 7, 1, 8},
    {3, 1, 5, 6, 7, 4, 8, 9, 2},
    {4, 6, 9, 5, 8, 2, 1, 3, 7},
    {7, 2, 8, 1, 3, 9, 4, 5, 6},
    {6, 6, 2, 9, 1, 8, 3, 7, 5},
    {8, 5, 3, 4, 6, 7, 9, 2, 1},
    {9, 7, 1, 2, 5, 3, 6, 8, 4},
  };
  private static boolean valid = true;
  
  //checks if each element is "sudoku-valid" (numbers from 1-9 non repeatable)
  private static boolean validateArray(int array[]) {
    boolean found = false;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (array[j] == i) {
          if (found)
            return false;
          else
            found = true;
        }
        if (!found)
          return false;
        found = false;
      }
    }
    return true;
  }

  public static void checkRow(int rowNumber) {
    int[] row = new int[9];
    for (int i = 0; i < 9; i++)
      row[i] = sudoku[rowNumber][i];
    valid = validateArray(row);
  }

  public static void checkColumn(int columnNumber) {
    int[] column = new int[9];
    for (int i = 0; i < 9; i++)
      column[i] = sudoku[i][columnNumber];
    valid = validateArray(column);
  }

  
  public static void checkSubgrid(int subgridNumber) {
    int[] subgrid = new int[9];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        subgrid[row * 3 + col] = sudoku[(subgridNumber % 3) * 3 + row][(subgridNumber / 3) * 3 + col];
      }
    }
    valid = validateArray(subgrid);
  }

  public static boolean isValid(){
    return valid;
  }
}