package com.example.lab11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText grade;
    private Button add;
    private Button retrieve;
    private TextView display;
    private StudentListDBAdapter studentListDBAdapter;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListDBAdapter = StudentListDBAdapter.getStudentListDBAdapterInstance(this);
        name = (EditText) findViewById(R.id.name);
        grade = (EditText) findViewById(R.id.grade);
        add = (Button) findViewById(R.id.add);
        retrieve = (Button) findViewById(R.id.retrieve);
        display = (TextView) findViewById(R.id.display);

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveStudents();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
    }

    private void retrieveStudents(){
        students = studentListDBAdapter.getAllStudents();
        //display.setText("sdfsjf");
        display.setText(getStudentstoString());
    }

    private void addStudent(){
        studentListDBAdapter.insert(name.getText().toString(),grade.getText().toString());
    }

    private String getStudentstoString(){
        if (students != null && students.size() > 0){
            StringBuilder stringBuilder = new StringBuilder("");
            for (Student student : students){
                stringBuilder.append(student.getName() + ", " + student.getGrade() + "\n");
            }
            return stringBuilder.toString();
        }else{
            return "No Results";
        }
    }
}
