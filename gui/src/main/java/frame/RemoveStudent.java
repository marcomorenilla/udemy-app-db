package frame;


import constants.NumberConstant;
import constants.StringConstant;
import db_student.Student;
import dbservice.RemoveStudentImpl;
import gui_interfaces.Callback;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class RemoveStudent extends JDialog implements ActionListener {

    private JButton removeStudentButton;
    private JButton cancelButton;
    private JComboBox<Student> studentComboBox;
    private JLabel studentLabel;
    private RemoveStudentImpl remover;
    private Callback callback;


    public RemoveStudent(Frame frame) {
        super(frame, StringConstant.REMOVE_STUDENT_TITLE, false);
        initializeVariables();
        constructLayout();
        loadStudents();
        setSize(NumberConstant.REMOVE_STUDENT_WIDTH, NumberConstant.REMOVE_STUDENT_HEIGHT);
        setLocationRelativeTo(frame);
    }

    private void initializeVariables() {
        studentLabel= new JLabel(StringConstant.REMOVE_STUDENT_TITLE);
        studentComboBox = new JComboBox();
        remover = new RemoveStudentImpl();
        removeStudentButton = new JButton(StringConstant.REMOVE_STUDENT_TITLE);
        cancelButton = new JButton(StringConstant.CANCEL);
        removeStudentButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    private void constructLayout() {
        JPanel studentInfoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstant.REMOVE_STUDENT_TITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
        studentInfoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(studentLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(studentComboBox, gc);

        // buttons panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(removeStudentButton);
        buttonsPanel.add(cancelButton);

        Dimension btnSize = removeStudentButton.getPreferredSize();
        cancelButton.setPreferredSize(btnSize);

        // add sub-panels to dialog
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeStudentButton) {
            System.out.println("Removing student");
            Student student = (Student) studentComboBox.getSelectedItem();
            remover.removeStudent(student);
            callback.tableUpdated();
            loadStudents();
        } else {
            setVisible(false);
        }

    }
    private void loadStudents() {
        studentComboBox.removeAllItems();

        List<Student>studentList=remover.getStudents();

        for(Student student:studentList) {
            studentComboBox.addItem(student);
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
