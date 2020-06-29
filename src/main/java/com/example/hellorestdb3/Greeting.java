package com.example.hellorestdb3;

import javax.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting implements Comparable<Greeting> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String content;

    public Greeting(String content){
        this.content = content;
    }

    public Greeting() {
        this.id = 0;
        this.content = "";
    }

    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId() {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(Greeting o) {
        return (int) (this.id - o.getId());
    }


}
