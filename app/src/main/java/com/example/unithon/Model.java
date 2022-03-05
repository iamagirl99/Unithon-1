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
        }

        public String getImage() {
            return image;
        }
        String image;
    }

    public static class User {
        public User() {
            this.mbti = MBTI.ESTJ;
            this.id = "None";
        }
        MBTI mbti;
        String id;
    }

    enum MBTI {
        ENFP, ENFJ, ENTP, ENTJ, ESFP, ESFJ, ESTP, ESTJ,
        INFP, INFJ, INTP, INTJ, ISFP, ISFJ, ISTP, 햣 ISTJ
    }
}
