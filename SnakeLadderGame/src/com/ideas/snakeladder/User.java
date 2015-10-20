package com.ideas.snakeladder;
public class User
{

        int id;
        int currentPosition = 0;

        public int getCurrentPosition(){
            return currentPosition;
        }

        public void setCurrentPosition(int currentPosition){
           this.currentPosition = currentPosition;
        }

        public User(int uId){
           id = uId;
        }
}