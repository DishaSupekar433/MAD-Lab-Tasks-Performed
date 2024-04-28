package com.example.pr_12_1_Firebase_Example;

public class StudentDetails {
    String prn , name , email;
    public StudentDetails() {

        }

    public StudentDetails(String new_prn,String new_name,String new_email)
        {
            this.prn = new_prn;
            this.name = new_name;
            this.email = new_email;
        }

        public String getPrn() {
            return prn;
        }

        public void setPrn(String prn) {
            this.prn = prn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
}
