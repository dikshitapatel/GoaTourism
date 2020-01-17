package com.example.admin.goatourism;

/**
 * Created by Admin on 15-Jan-20.
 */

public class HackSmileModelClass {
      private int image;
        private String title;
        public HackSmileModelClass(int image, String title) {
            this.image = image;
            this.title = title;
        }
        public int getImage() {
            return image;
        }
        public String getTitle() {
            return title;
        }
    }
