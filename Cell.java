package spreadsheet;

/**
 * Represents a cell in a spreadsheet.
 */
public class Cell {
    private Object value;
    private Color color;
    private Type type;

    /**
     * Constructs a new cell with default values.
     * The default color is WHITE, and the default type is STRING.
     */
    public Cell() {
        color = Color.WHITE;
        type = Type.STRING;
        value = null;
    }

    /**
     * Sets the value of the cell.
     *
     * @param value the new value of the cell
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Retrieves the value of the cell.
     *
     * @return the value of the cell
     */
    public Object getValue() {
        return value;
    }


    /**
     * Retrieves the type of the cell.
     *
     * @return the type of the cell
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the color of the cell.
     *
     * @param color the new color of the cell
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Retrieves the color of the cell.
     *
     * @return the color of the cell
     */
    public Color getColor() {
        return color;
    }

    /**
     * Resets the cell to its default state.
     * The value is set to null, the type is set to STRING, and the color is set to WHITE.
     */
    public void reset() {
        value = null;
        type = Type.STRING;
        color = Color.WHITE;
    }
}
