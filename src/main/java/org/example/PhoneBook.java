package org.example;
import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем контакты в телефонную книгу
        addContact(phoneBook, "Иванов", "1234567891");
        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Петров", "9876543210");
        addContact(phoneBook, "Сидоров", "1112223333");
        addContact(phoneBook, "Иванов", "1234500000");
        addContact(phoneBook, "Иванов", "1234567000");
        addContact(phoneBook, "Иванов", "9999999999");
        addContact(phoneBook, "Сидоров", "5555555555");

        // Сортируем контакты по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(sortedContacts, (a, b) -> b.getValue().size() - a.getValue().size());

        // Выводим отсортированные контакты
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Добавление контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }
}
