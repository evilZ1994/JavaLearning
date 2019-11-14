package Thread.demo01.practice;

import java.util.ArrayList;
import java.util.List;

class UserSendThread implements Runnable {
    private List<UserEntity> userList;

    public UserSendThread(List<UserEntity> userList) {
        this.userList = userList;
    }

    @Override
    public void run() {
        for (UserEntity user : userList) {
            System.out.println(Thread.currentThread().getName() + " " + user);
        }
    }
}

public class BatchSMS {
    public static void main(String[] args) {
        // 1. 初始化数据
        List<UserEntity> initUsers = initUser();
        // 2. 定义每个线程分批发送大小
        int userCount = 2;
        // 3. 计算每个线程需要分配跑的数据
        List<List<UserEntity>> splitList = ListUtil.splitList(initUsers, userCount);
        // 4. 分批发送数据
        for (int i=0; i<splitList.size(); i++) {
            List<UserEntity> userList = splitList.get(i);
            Thread thread = new Thread(new UserSendThread(userList), "线程" + i);
            thread.start();
        }
    }

    private static List<UserEntity> initUser() {
        List<UserEntity> users = new ArrayList<>();
        for (int i=0; i<10; i++) {
            users.add(new UserEntity(i, "UserName " + i));
        }
        return users;
    }
}
