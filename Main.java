package spreadsheet;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Spreadsheet sp = new Spreadsheet(3, 4);
        sp.setValueAt(0,0, 1);
        sp.setValueAt(0,1, 10);
        sp.setValueAt(0,2, 12);
        sp.setValueAt(1,0, 2);
        sp.setValueAt(1,1, "Hello");
        sp.setValueAt(1,2, "barev");
        sp.setValueAt(2, 1, new Date().toString());

        sp.setColorAt(0,2, Color.BLACK);

        Object value1 = sp.getValueAt(0,2 );
        Object value2 = sp.getValueAt(1,1);
        Object value3 = sp.getValueAt(2,1);

        System.out.println("value 1: " + value1);
        System.out.println("value 2: " + value2);
        System.out.println("value 3: " + value3);

        System.out.println(sp.getColorAt(0,2));

        System.out.println(sp.getColumnSum(1));

        System.out.println(sp.getRowSum(0));

        System.out.println(sp.getColumnAverage(1));

        System.out.println(sp.getRowAverage(0));

        sp.addColumn(2);
        sp.addRow(1);

    }

}
