package ru.job4j.inheritance;

public class Surgeon extends Doctor {
        private String schedule;

        public Surgeon(String name, String surname, String education, String birthday, String specialization, String schedule) {
            super(name, surname, education, birthday, specialization);
            this.schedule = schedule;
        }

        public Operations list() {

            return null;
        }
}
