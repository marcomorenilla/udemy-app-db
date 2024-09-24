package frame;

import constants.NumberConstant;
import constants.StringConstant;
import db_student.Student;
import dbservice.AddStudentImpl;
import gui_interfaces.Callback;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddStudent extends JDialog implements ActionListener {
    private JLabel name;
    private JLabel surname;
    private JLabel age;
    private JLabel email;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;
    private JTextField emailField;
    private JButton saveButton;
    private JButton cancelButton;
    private AddStudentImpl addStudentImpl;
    private Callback callback;

    public AddStudent(JFrame frame) {
        super(frame, StringConstant.ADD_STUDENT_TITLE,false);
        initializeVariables();
        createLayout();
        setSize(NumberConstant.ADD_STUDENT_WIDTH,NumberConstant.ADD_STUDENT_HEIGHT);
        setLocationRelativeTo(frame);
    }

    private void initializeVariables() {
        addStudentImpl = new AddStudentImpl();
        name = new JLabel(StringConstant.NAME);
        surname = new JLabel(StringConstant.SURNAME);
        age = new JLabel(StringConstant.AGE);
        email = new JLabel(StringConstant.EMAIL);
        nameField = new JTextField(20);
        surnameField = new JTextField(20);
        ageField = new JTextField(20);
        emailField = new JTextField(10);
        saveButton = new JButton(StringConstant.SAVE);
        cancelButton = new JButton(StringConstant.CANCEL);
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    private void createLayout() {
        JPanel studentInfoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstant.ADD_STUDENT_TITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
        studentInfoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        // first row
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(name, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(nameField, gc);

        // next row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(surname, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(surnameField, gc);

        // next row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(age, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(ageField, gc);

        // next row

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(email, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(emailField, gc);

        // buttons panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);

        Dimension btnSize = cancelButton.getPreferredSize();
        saveButton.setPreferredSize(btnSize);

        // add sub-panels to dialog
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==saveButton){
            System.out.println("adding");
            String name = nameField.getText();
            String surname = surnameField.getText();
            Integer age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();

            Student student = new Student(name,surname,age,email);
            addStudentImpl.addStudent(student);
            callback.tableUpdated();
            setVisible(false);

        } else {
            setVisible(false);
        }
    }

    public void setCallback(Callback callback) {
        this.callback=callback;
    }

}
