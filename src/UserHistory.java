public class UserHistory implements DataBase {
    private User[] users = new User[3];
    private int counter = 0;
    private String name;

    @Override
    public void addObject(Object obj) {
        User user = (User) obj;
        if (isExist(user)) {
            System.out.println("User is exist");
            return;
        } else {
            if (counter < users.length)
                users[counter++] = user;
            else
                System.out.println("Data base is full");
        }
    }

    @Override
    public void printObject() {
        //undefined method
    }

    public boolean isExist(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getLogin().equals(user.getLogin()))
                    return true;
        }
        return false;
    }

    public boolean checkData(User user) {
        for (User us : users) {
            if (us != null)
                if (us.equals(user)) {
                    name = us.getUsername();
                    return true;
                }
        }
        return false;
    }

    public String getName() {
        return name;
    }

}
