package com.example.unithon;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.ArrayList;

public class Model {
    public static class Diary {

        public Diary() {
            this.name = "테스트 다이어리";
            this.pages = new ArrayList<>();
            this.bookmarks = new ArrayList<>();
            this.owner_id = "None";
            this.members = new ArrayList<>();
            this.hashtag = new ArrayList<>();
            this.password = "";
            turnId = "Me";
        }

        public Diary(String name, boolean isofferedCover, Drawable offeredCover, Uri uploadCover,
                     ArrayList<String> hashtag, String password, boolean isofferedTemplate,
                     Drawable offeredTemplate, Uri uploadTemplate) {
            this.name = name;
            this.isofferedCover = isofferedCover;
            this.offeredCover = offeredCover;
            this.uploadCover = uploadCover;
            this.hashtag = hashtag;
            this.password = password;
            this.isofferedTemplate = isofferedTemplate;
            this.offeredTemplate = offeredTemplate;
            this.uploadTemplate = uploadTemplate;
        }

        public String getTurnId() {
            return turnId;
        }

        String name;
        ArrayList<String> hashtag;
        ArrayList<Page> pages;
        ArrayList<Integer> bookmarks;
        String password;
        boolean isofferedCover;
        Drawable offeredCover;
        Uri uploadCover;
        boolean isofferedTemplate;
        Drawable offeredTemplate;
        Uri uploadTemplate;
        String turnId;

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

        public Diary getDiary() {
            return diary;
        }

        public ArrayList<PageInfo> getBookmarks() {
            return bookmarks;
        }
    }

    public static class User {
        public User() {
            this.mbti = MBTI.ESTJ;
            this.id = "Me";
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

        public ArrayList<CustomDiary> getDiaries() {
            return diaries;
        }

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
