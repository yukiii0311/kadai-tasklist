package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;





@Entity
@NamedQueries({  //一覧表示するデータを取得するためのJPQL
    @NamedQuery(
            name = "getAllTasks",
            query = "SELECT m FROM Tasks AS m ORDER BY m.id DESC"
            )
})
@Table(name = "tasks")
public class Tasks {


    //プロパティ、フィールド（データベースと紐付け）
    //メッセージid
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //メッセージのタイトル
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    //メッセージの内容
    @Column(name = "content", length = 255, nullable = false)
    private String content;

    //作成日時
    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    //更新日時
    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;


    //getter

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    //setter

    public void setId(Integer Id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setCreated_at(Timestamp created_at){
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at){
        this.updated_at = updated_at;
    }


    }

