package com.example.instagram_clone;

public class DataHandler {
  int imageView;
  String nameOfUser;

  public DataHandler(int imageView, String nameOfUser){
      this.imageView=imageView;
      this.nameOfUser=nameOfUser;
  }

    public int getImageView() {
        return imageView;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }
}


