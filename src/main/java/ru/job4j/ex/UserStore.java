package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] user, String login) throws UserNotFoundException {
        User rsl = null;
        for (User f : user) {
            if (f.getUsername().equals(login)) {
                rsl = f;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("The user not found");
        }
        return rsl;
    }

        public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
           throw new UserInvalidException("The user is not valid");
        }
        return true;
        }

        public static void main(String[] args) {
           try {
               User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
             if (validate(user)) {
                 System.out.println("This user has an access");
             }
        } catch (UserInvalidException ei) {
                ei.printStackTrace();
           } catch (UserNotFoundException en) {
                en.printStackTrace();
           } catch (Exception e) {
                e.printStackTrace();
           }
    }
}
