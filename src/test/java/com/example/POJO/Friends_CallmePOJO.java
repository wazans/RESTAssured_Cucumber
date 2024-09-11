package com.example.POJO;
/*
A POJO (Plain Old Java Object) class is a simple Java class that does not extend or implement
any special classes or interfaces and is used to represent data.
It typically contains private fields, public getter and setter method
 */

public class Friends_CallmePOJO {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    Friends_CallmePOJO()
    {
        //Default constructor
    }


    /*
    The parameterized constructor Friends(String id, String firstname, String lastname, int age, String email)
    allows the creation of an object with initial values for all fields.
     */
    public Friends_CallmePOJO(int id, String firstname, String lastname, int age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void settId(int id) {this.id= id;}


   public String getFirstname()
   {
       return firstname;
   }

   public  void setFirstname(String firstname)
   {
       this.firstname=firstname;
   }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
