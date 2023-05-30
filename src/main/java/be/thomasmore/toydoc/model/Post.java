package be.thomasmore.toydoc.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String intro;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @Transient
    private boolean likedByCurrentAppUser;

    @Column(nullable = false)
    private Integer likeCount = 0;

    private String beforeUrl;
    private String afterUrl;

    private String specialty;


    public Post(){

    }

    public Post( String title, String beforeUrl, String afterUrl, String intro, String body, String specialty, Date date){
        this.title = title;
        this.intro = intro;
        this.body = body;
        this.date = date;
        this.beforeUrl = beforeUrl;
        this.afterUrl = afterUrl;
        this.specialty = specialty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBeforeUrl() {
        return beforeUrl;
    }
    public void setBeforeUrl(String beforeUrl) {
        this.beforeUrl = beforeUrl;
    }

    public String getAfterUrl() {
        return afterUrl;
    }
    public void setAfterUrl(String afterUrl) {
        this.afterUrl = afterUrl;
    }


    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {this.specialty = specialty;}

    public Integer getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isLikedByCurrentAppUser() {
        return likedByCurrentAppUser;
    }
    public void setLikedByCurrentAppUser(boolean likedByCurrentAppUser) {
        this.likedByCurrentAppUser = likedByCurrentAppUser;
    }


    public AppUser getAppUser() {
        return appUser;
    }
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
