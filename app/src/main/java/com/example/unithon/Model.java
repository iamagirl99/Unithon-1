package com.example.unithon;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
    public static class Diary {
        public static final int SIZE = 3;

        public Diary() {
            this.name = "테스트 다이어리";
            this.pages = new ArrayList<>();
            this.bookmarks = new ArrayList<>();
            Arrays.fill(coverType, false);
            Arrays.fill(templateType, false);
        }

        String name;
        ArrayList<String> hashtag;
        ArrayList<Page> pages;
        ArrayList<Integer> bookmarks;
        String password;
        boolean[] coverType = new boolean[SIZE + 1];
        Drawable offeredCover;
        Uri uploadCover;
        boolean[] templateType = new boolean[SIZE + 1];
        Drawable offeredTemplate;
        Uri uploadTemplate;

        public static int getSIZE() {
            return SIZE;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<String> getHashtag() {
            return hashtag;
        }

        public void setHashtag(ArrayList<String> hashtag) {
            this.hashtag = hashtag;
        }

        public void setPages(ArrayList<Page> pages) {
            this.pages = pages;
        }

        public void setBookmarks(ArrayList<Integer> bookmarks) {
            this.bookmarks = bookmarks;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean[] getCoverType() {
            return coverType;
        }

        public void setCoverType(boolean[] coverType) {
            this.coverType = coverType;
        }

        public Drawable getOfferedCover() {
            return offeredCover;
        }

        public void setOfferedCover(Drawable offeredCover) {
            this.offeredCover = offeredCover;
        }

        public Uri getUploadCover() {
            return uploadCover;
        }

        public void setUploadCover(Uri uploadCover) {
            this.uploadCover = uploadCover;
        }

        public boolean[] getTemplateType() {
            return templateType;
        }

        public void setTemplateType(boolean[] templateType) {
            this.templateType = templateType;
        }

        public Drawable getOfferedTemplate() {
            return offeredTemplate;
        }

        public void setOfferedTemplate(Drawable offeredTemplate) {
            this.offeredTemplate = offeredTemplate;
        }

        public Uri getUploadTemplate() {
            return uploadTemplate;
        }

        public void setUploadTemplate(Uri uploadTemplate) {
            this.uploadTemplate = uploadTemplate;
        }

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
