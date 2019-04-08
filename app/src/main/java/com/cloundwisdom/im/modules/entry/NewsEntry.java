package com.cloundwisdom.im.modules.entry;

public class NewsEntry {


    /**
     * ctime : 2019-04-03 00:00
     * title : 岛内呼吁蔡当局别再“反中” 台媒：两岸和平才是台湾保命符
     * description : 军事图集
     * picUrl : https://img1.utuku.china.com/300x0/mili/20190403/f9b602ca-02cf-465d-9339-a9a4d6235c3b.jpg
     * url :
     */

    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;
    /**
     * id : 1110
     * quest : 为什么黑人喜欢吃白色巧克力？
     * result : 害怕咬到自己的手
     */

    private String id;
    private String quest;
    private String result;


    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "NewsEntry{" +
                "ctime='" + ctime + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", quest='" + quest + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
