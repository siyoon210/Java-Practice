package com.fastcampus3.businesscard.friendmanager;

import java.util.ArrayList;
import java.util.List;

public class FriendManager {
    private List<Friend> friendList;

    public FriendManager() {
        this.friendList = new ArrayList<>();
    }

    //친구 추가
    public void addFriend(Friend friend) {
        friendList.add(friend);
    }

    //이름에 해당하는 친구 정보를 반환
    public Friend getFriend(String name) {
        for (Friend friend : friendList) {
            if (friend.getName().equals(name)) {
                return friend;
            }
        }
        return null;
    }

    //전화번호에 해당하는 친구를 삭제
    public void deleteFriend(String phone) {
//        for (Friend friend : friendList) {
//            if (friend.getPhone().equals(phone)) {
//                friendList.remove(friend);
////                return;
//            }
//        }

        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).getPhone().equals(phone)) {
                friendList.remove(i);
            }
        }
    }

    //친구의 수를 반환
    public int getSize() {
        return friendList.size();
    }

    //모든 친구 목록을 출력하기 (테스트용)
    public void printFriendList() {
        friendList.forEach(System.out::println);
    }
}
