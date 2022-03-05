package com.example.unithon;

import java.util.ArrayList;

public class Model {
    public static class Diary {
        public Diary() {
            this.name = "테스트 다이어리";
            this.pages = new ArrayList<>();
            this.bookmarks = new ArrayList<>();
            this.tags = "#졸려";
            this.owner_id = "None";
            this.members = new ArrayList<>();
        }
        String name, tags;
        ArrayList<Page> pages;
        ArrayList<Integer> bookmarks;
        String owner_id;
        ArrayList<User> members;

        public String getName() {
            return name;
        }

        public ArrayList<Page> getPages() {
            return pages;
        }

        public ArrayList<Integer> getBookmarks() {
            return bookmarks;
        }

        public String getTags() {
            return tags;
        }

        public ArrayList<User> getMembers() {
            return members;
        }

        public String getOwner_id(){
            return owner_id;
        }
    }
  
    public static class Comment {
        private String writer, date, content;

        public Comment() {}

        public Comment(String writer, String date, String content) {
            this.writer = writer;
            this.date = date;
            this.content = content;
        }

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
      
    public static class Page {
        public Page() {
            this.image = "cover_test";
            this.comments = new ArrayList<>();
        }

        public String getImage() {
            return image;
        }
        String image;
        ArrayList<Comment> comments;
    }

    public static class CustomDiary {
        Diary diary;
        ArrayList<PageInfo> bookmarks;

        public CustomDiary() {
            diary = new Diary();
            bookmarks = new ArrayList<>();
        }
    }

    public static class User {
        public User() {
            this.mbti = MBTI.ESTJ;
            this.id = "None";
            this.pages = new ArrayList<>();
            this.diaries = new ArrayList<>();
        }
        MBTI mbti;
        String id;
        ArrayList<PageInfo> pages;
        ArrayList<CustomDiary> diaries;

        public String getMbti(){
            return mbti.name();
        }

        public String getId(){
            return id;
        }

        public ArrayList<PageInfo> getPages() { return pages;}

        public void setBookmarks(ArrayList<PageInfo> my_diary){
            this.pages = my_diary;
        }
    }

    enum MBTI {
        ENFP, ENFJ, ENTP, ENTJ, ESFP, ESFJ, ESTP, ESTJ,
        INFP, INFJ, INTP, INTJ, ISFP, ISFJ, ISTP, ISTJ
    }

    public class PageInfo{
        int diary_num;
        int page_num;
        public PageInfo(int diary_num, int page_num){
            this.diary_num = diary_num;
            this.page_num = page_num;
        }
    }


}
