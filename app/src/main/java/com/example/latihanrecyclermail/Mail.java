package com.example.latihanrecyclermail;

public class Mail {
    private String name;

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    private String profName;
    private String subject;
    private String content;

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    private String jam;
    private int pic;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Mail(String name, String subject, String profName , String content, String jam, int pic){
        this.name = name;
        this.jam = jam;
        this.profName = profName;
        this.subject = subject;
        this.content = content;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }


}
