package entity;

import java.util.Objects;

public class Grade {

    private int id;
    private Student student;
    private Term term;
    private Discipline discipline;
    private int grade;

    public Grade() {
    }

    public Grade(int id, Student student, Term term, Discipline discipline, int grade) {
        this.id = id;
        this.student = student;
        this.term = term;
        this.discipline = discipline;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return id == grade1.id && grade == grade1.grade && Objects.equals(student, grade1.student) && Objects.equals(term, grade1.term) && Objects.equals(discipline, grade1.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, term, discipline, grade);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + student +
                ", term=" + term +
                ", discipline=" + discipline +
                ", grade=" + grade +
                '}';
    }
}
