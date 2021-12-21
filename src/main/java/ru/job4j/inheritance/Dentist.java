package ru.job4j.inheritance;

public class Dentist extends  Doctor {
        private String recommendations;

        public Dentist(String name, String surname, String education, String birthday, String specialization, String recommendations) {
            super(name, surname, education, birthday, specialization);
            this.recommendations = recommendations;
        }

        public Damage list() {
            return null;
        }
    }

