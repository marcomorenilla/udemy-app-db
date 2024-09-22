package frame;

import db_student.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<Student> students;
    private String [] columnNames;

    public TableModel() {
        this.students = new ArrayList<>();
        this.columnNames = new String[]{"Name", "Surname", "Age", "e-mail"};
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
    public String getColumnName(int index) {
        return columnNames[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        Object value;
        switch (columnIndex) {
            case 0:
                value = student.getName();
                break;
            case 1:
                value = student.getSurname();
                break;
            case 2:
                value = student.getAge();
                break;
            case 3:
                value = student.getEmail();
                break;
            default:
                value = "Not found value";
                break;
        }
        return value;
    }

    public void reloadTable(){
        fireTableDataChanged();
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }
}
