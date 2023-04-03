package com.company;

public class Post extends BaseModel {
String post_name;
int wage;
public Post(){
}
public Post(long id_post, String post_name, int wage){
    super(id_post);
    this.post_name = post_name;
    this.wage = wage;
}
public String getPost_name(){
    return post_name;
}

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }
}
