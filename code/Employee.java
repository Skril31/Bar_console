package com.company;

public class Employee extends BaseModel {
String fio;
String sex;
int age;
Post id_post;

public Employee(){
}
public Employee(long id_emp,String fio,String sex, int age , Post id_post){
    super(id_emp);
    this.fio=fio;
    this.sex=sex;
    this.age=age;
    this.id_post = id_post;

}
public String getFio(){
    return fio;
}
public void setFio(String fio){
    this.fio = fio;
}
public String getSex(){
    return sex;
}
public void setSex(String sex){
    this.sex = sex;
}
public int getAge(){
    return age;
}
public void setAge(int age){
    this.age = age;
}
public Post getId_post(){
    return id_post;
}
public void setId_post(Post id_post){
    this.id_post = id_post;
}
}