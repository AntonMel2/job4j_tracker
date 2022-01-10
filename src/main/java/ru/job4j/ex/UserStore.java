package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] user, String login) throws UserNotFoundException {
        User rsl = null;
        for (User f : user) {
            if (f.equals(login)) {
                rsl = f;
                break;
            }
        }
        return rsl;
    }

        public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() || user.getUsername().length() >= 3) {
           return true;
        }
        return false;
        }

        public static void main(String[] args) {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            try {
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

