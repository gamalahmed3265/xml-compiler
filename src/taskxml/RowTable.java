/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskxml;

/**
 *
 * @author gamal
 */
class RowOfTable {

        Student student;
        String rowName;
  
        public RowOfTable() {
        }
        public void setStudent(Student student, String rowName) {
            this.student = student;
            this.rowName = rowName;
        }
        public Student getStudent() {
            return student;
        }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public String getRowName() {
        return rowName;
    }

    @Override
    public String toString() {
        return "RowOfTable{" + "student=" + student + ", rowName=" + rowName + '}';
    }

    }
