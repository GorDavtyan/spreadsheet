package spreadsheet;

/**
 * Represents a spreadsheet with cells organized in rows and columns.
 */
public class Spreadsheet {
    private Cell[][] cells;
    private int rows;
    private int columns;

    /**
     * Constructs a new spreadsheet with the specified number of rows and columns.
     *
     * @param rows    the number of rows in the spreadsheet
     * @param columns the number of columns in the spreadsheet
     */
    public Spreadsheet(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
        generateCells();


    }

    /**
     * Generates and initializes the cells in the spreadsheet.
     */
    public void generateCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    /**
     * Adds a new column at the specified position in the spreadsheet.
     *
     * @param position the position at which to add the column
     * @throws IllegalArgumentException if the position is invalid
     */
    public void addColumn(int position) {
        if (position < 0 || position > columns) {
            throw new IllegalArgumentException("Invalid column position");
        }

        ++columns;
        Cell tmpCells[][] = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j < position) {
                    tmpCells[i][j] = cells[i][j];
                } else if (j > position) {
                    tmpCells[i][j] = cells[i][j - 1];
                } else {
                    tmpCells[i][j] = new Cell();
                }
            }
        }
        cells = tmpCells;
    }

    /**
     * Adds a new row at the specified position in the spreadsheet.
     *
     * @param position the position at which to add the row
     * @throws IllegalArgumentException if the position is invalid
     */
    public void addRow(int position) {
        if (position < 0 || position > rows) {
            throw new IllegalArgumentException("Invalid row position");
        }
        ++rows;
        Cell[][] tmpCells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i < position) {
                    tmpCells[i][j] = cells[i][j];
                } else if (i > position) {
                    tmpCells[i][j] = cells[i - 1][j];
                } else {
                    tmpCells[i][j] = new Cell();
                }
            }
        }
        cells = tmpCells;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(cells[i][j].getValue());
            }
        }
    }

    /**
     * Sets the value of the cell at the specified row and column.
     *
     * @param row    the row of the cell
     * @param column the column of the cell
     * @param value  the value to set
     * @throws IllegalArgumentException if the row or column is invalid
     */

    public void setValueAt(int row, int column, Object value) {
        checkCell(row, column);
        cells[row][column].setValue(value);
    }

    /**
     * Retrieves the value of the cell at the specified row and column.
     *
     * @param row    the row of the cell
     * @param column the column of the cell
     * @return the value of the cell
     * @throws IllegalArgumentException if the row or column is invalid
     */
    public Object getValueAt(int row, int column) {
        checkCell(row, column);
        return cells[row][column].getValue();
    }

    /**
     * Sets the color of the cell at the specified row and column.
     *
     * @param row    the row of the cell
     * @param column the column of the cell
     * @param color  the color to set
     * @throws IllegalArgumentException if the row or column is invalid
     */
    public void setColorAt(int row, int column, Color color) {
        checkCell(row, column);
        cells[row][column].setColor(color);
    }

    /**
     * Retrieves the color of the cell at the specified row and column.
     *
     * @param row    the row of the cell
     * @param column the column of the cell
     * @return the color of the cell
     * @throws IllegalArgumentException if the row or column is invalid
     */
    public Color getColorAt(int row, int column) {
        checkCell(row, column);
        return cells[row][column].getColor();
    }

    /**
     * Resets the entire spreadsheet, setting all cells to their default state.
     */
    public void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j].reset();
            }
        }
    }

    /**
     * Resets the cell at the specified row and column to its default state.
     *
     * @param row    the row of the cell
     * @param column the column of the cell
     * @throws IllegalArgumentException if the row or column is invalid
     */
    public void resetCellAt(int row, int column) {
        checkCell(row, column);
        cells[row][column].reset();
    }

    /**
     * Calculates the sum of the values in the specified column.
     *
     * @param column the column to calculate the sum for
     * @return the sum of the values in the column
     * @throws IllegalArgumentException if the column is invalid
     */
    public int getColumnSum(int column) {
        if (column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid column position");
        }
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            Object value = cells[i][column].getValue();
            if (value instanceof Number) {
                sum += ((Number) (value)).intValue();
            }
        }
        return sum;
    }

    /**
     * Calculates the sum of the values in the specified row.
     *
     * @param row the row to calculate the sum for
     * @return the sum of the values in the row
     * @throws IllegalArgumentException if the row is invalid
     */
    public int getRowSum(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row position");
        }
        int sum = 0;
        for (int j = 0; j < columns; j++) {
            Object value = cells[row][j].getValue();
            if (value instanceof Number) {
                sum += ((Number) value).intValue();
            }
        }
        return sum;
    }

    /**
     * Calculates the sum of the values in the specified rectangular area.
     *
     * @param startRow    the starting row of the area
     * @param startColumn the starting column of the area
     * @param endRow      the ending row of the area
     * @param endColumn   the ending column of the area
     * @return the sum of the values in the area
     * @throws IllegalArgumentException if the area is invalid
     */
    public int getAreaSum(int startRow, int startColumn, int endRow, int endColumn) {
        checkArea(startRow, startColumn, endRow, endColumn);
        int sum = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                Object value = cells[i][j].getValue();
                if (value instanceof Number) {
                    sum += ((Number) value).intValue();
                }
            }
        }
        return sum;
    }

    /**
     * Calculates the average of the values in the specified column.
     *
     * @param column the column to calculate the average for
     * @return the average of the values in the column
     * @throws IllegalArgumentException if the column is invalid
     */
    public int getColumnAverage(int column) {
        if (column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid column position");
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            Object value = cells[i][column].getValue();
            if (value instanceof Number) {
                ++count;
                res += ((Number) value).intValue();
            }
        }
        if (count == 0) {
            return 0;
        }
        return res / count;
    }

    /**
     * Calculates the average of the values in the specified row.
     *
     * @param row the row to calculate the average for
     * @return the average of the values in the row
     * @throws IllegalArgumentException if the row is invalid
     */

    public int getRowAverage(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row position");
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < columns; i++) {
            Object value = cells[row][i].getValue();
            if (value instanceof Number) {
                res += ((Number) value).intValue();
                ++count;
            }
        }
        if (count == 0) {
            return 0;
        }
        return res / count;
    }

    /**
     * Calculates the average of the values in the specified rectangular area.
     *
     * @param startRow    the starting row of the area
     * @param startColumn the starting column of the area
     * @param endRow      the ending row of the area
     * @param endColumn   the ending column of the area
     * @return the average of the values in the area
     * @throws IllegalArgumentException if the area is invalid
     */
    public int getAreaAverage(int startRow, int startColumn, int endRow, int endColumn) {
        checkArea(startRow, startColumn, endRow, endColumn);
        int sum = 0;
        int count = 0;
        for (int row = startRow; row < rows; row++) {
            for (int col = startColumn; col < columns; col++) {
                Object value = cells[row][col].getValue();
                if (value instanceof Number) {
                    sum += ((Number) value).intValue();
                    ++count;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    /**
     * Checks if the specified cell is valid.
     *
     * @param row    the row of the cell
     * @param column the column of the cell
     * @throws IllegalArgumentException if the row or column is invalid
     */
    public void checkCell(int row, int column) {
        if (row < 0 || column < 0 || row >= rows || column >= columns) {
            throw new IllegalArgumentException("Invalid cell position");
        }
    }

    /**
     * Checks if the specified area is valid.
     *
     * @param startRow    the starting row of the area
     * @param startColumn the starting column of the area
     * @param endRow      the ending row of the area
     * @param endColumn   the ending column of the area
     * @throws IllegalArgumentException if the area is invalid
     */
    public void checkArea(int startRow, int startColumn, int endRow, int endColumn) {
        if (startRow < 0 || startRow >= rows || startColumn < 0 || startColumn >= columns || endRow < 0
                || endRow >= rows || endColumn < 0 || endColumn >= columns) {
            throw new IllegalArgumentException("Invalid cell position");
        }
    }
}
