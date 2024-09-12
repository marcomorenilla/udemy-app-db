package frame;

import db_student.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<Student> students;
    private String [] columnNames = {"Name", "Surname", "Age", "e-mail"};

    public TableModel() {
        this.students = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        String value;
        switch (columnIndex) {
            case 0:
                value = student.getName();
                break;
            case 1:
                value = student.getSurname();
                break;
            case 2:
                value = String.valueOf(student.getAge());
                break;
            case 3:
                value = student.getEmail();
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
