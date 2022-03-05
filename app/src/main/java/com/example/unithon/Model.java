package com.example.unithon;

import java.util.ArrayList;

public class Model {
    public static class Diary {
        public Diary() {
            this.name = "테스트 다이어리";
            this.pages = new ArrayList<>();
            this.bookmarks = new ArrayList<>();
        }
        String name;
        ArrayList<Page> pages;
        ArrayList<Integer> bookmarks;

        public String getName() {
            return name;
        }

        public ArrayList<Page> getPages() {
            return pages;
        }

        public ArrayList<Integer> getBookmarks() {
            return bookmarks;
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
            this.image = "diary";
        }
        String image;

    }
}
