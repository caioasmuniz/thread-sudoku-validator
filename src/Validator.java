public class Validator {
  private static final int[][] sudoku = {
      { 2, 3, 7, 8, 4, 1, 5, 6, 9 },
      { 1, 8, 6, 7, 9, 5, 2, 4, 3 },
      { 5, 9, 4, 3, 2, 6, 7, 1, 8 },
      { 3, 1, 5, 6, 7, 4, 8, 9, 2 },
      { 4, 6, 9, 5, 8, 2, 1, 3, 7 },
      { 7, 2, 8, 1, 3, 9, 4, 5, 6 },
      { 6, 6, 2, 9, 1, 8, 3, 7, 5 },
      { 8, 5, 3, 4, 6, 7, 9, 2, 1 },
      { 9, 7, 1, 2, 5, 3, 6, 8, 4 },
  };
  private static boolean valid = true;

  // checks if each element is "sudoku-valid" (numbers from 1-9 non repeatable)
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

  // Disposition of the subgrids:
  // 0 1 2
  // 3 4 5
  // 6 7 8
  // Coordinates from each subgrid's first element (top left)
  // sub 0-[0][0] sub 1-[3][0] sub 2-[6][0]
  // sub 3-[0][3] sub 4-[3][3] sub 5-[6][3]
  // sub 6-[0][6] sub 7-[3][6] sub 8-[6][6]

  public static void checkSubgrid(int subgridNumber) {
    int[] subgrid = new int[9];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        subgrid[row * 3 + col] = sudoku[(subgridNumber % 3) * 3 + row][(subgridNumber / 3) * 3 + col];
      }
    }
    valid = validateArray(subgrid);
  }

  // validate a Row/Column/Subgrid from the sudoku using the
  // checkRow/Column/Subgrid methods
  // operation = 0 checkRow
  // operation = 1 checkColumn
  // operation = 2 checkSubgrid
  public synchronized static void validate(int operation, int index) {
    switch (operation) {
      case 0:
        checkRow(index);
        break;
      case 1:
        checkColumn(index);
        break;
      case 2:
        checkSubgrid(index);
        break;
    }
  }

  public static boolean isValid() {
    return valid;
  }
}