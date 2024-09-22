package frame;



import db_student.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {

    private JTable table;
    private TableModel tableModel;

    public TablePanel() {
        initializeVariables();
        initializeLayout();
        setHeaderAlignement();
        setTableAlignement();
    }

    private void setTableAlignement() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void setHeaderAlignement() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.getTableHeader().setDefaultRenderer(centerRenderer);
    }

    public void update(){
        tableModel.reloadTable();
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void initializeVariables() {
        tableModel = new TableModel();
        table = new JTable(tableModel);
    }

    public void setTableModel (List<Student>students){
        tableModel.setStudents(students);
    }
}
