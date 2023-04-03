package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //добавление сотрудника

    public static void main(String[] args) throws Exception {
        int command=10;
        while (command != 0) {
            System.out.println("\n");

                Scanner scanner = new Scanner(System.in);
                BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("1.Добавить данные в таблицу");
                System.out.println("2.Удалить данные в таблице");
                System.out.println("3.Редактировать данные в таблице");
                System.out.println("4.Получить данные из таблицы по id");
                System.out.println("5.Получить все данные из таблицы");
                System.out.println("6.Показать, сколько сотрудников находятся на различных должностях");
                System.out.println("7.Показать сколько сотрудников получают больше n денег");
                System.out.println("8.Показать количество стаканов с объемом > n");
                System.out.println("0.Выход");
                String FIO;
                String sex;
                String post_name;
                String method_name;
                String description;
                String cocktail_name;
                int id_cocktail_after;
                int id_method_after;
                int id_method;
                int id_post;
                int id_employee;
                int count;
                int id_cocktail;
                int wage;
                int age;
                int fk_id_post;
                int volume;
                command = scanner.nextInt();
                if (command == 1) {
                    System.out.println("1. Employee");
                    System.out.println("2. Post");
                    System.out.println("3. Method");
                    System.out.println("4. Cocktail_to_method");
                    command = scanner.nextInt();
                    if (command == 1) {
                        System.out.println("Введите ФИО");
                        FIO = s.readLine();
                        System.out.println("Введите пол");
                        sex = scanner.next();
                        System.out.println("Введите возраст");
                        age = scanner.nextInt();
                        System.out.println("Введите id должности");
                        fk_id_post = scanner.nextInt();
                        ResultSet result = func.insert_employee(FIO, sex, age, fk_id_post);
                        while (result.next()) {
                            System.out.println("id добавленного сотрудника:" + result.getInt("id_employee"));
                        }

                    } else if (command == 2) {
                        System.out.println("Введите название должности");
                        post_name = s.readLine();
                        System.out.println("Введите зарплату");
                        wage = scanner.nextInt();
                        ResultSet result = func.insert_post(post_name, wage);
                    } else if (command == 3) {
                        System.out.println("Введите название метода");
                        method_name = s.readLine();
                        System.out.println("Введите описание метода");
                        description = s.readLine();
                        ResultSet result = func.insert_method(method_name, description);
                    } else if (command == 4) {
                        System.out.println("Таблица: ");
                        ResultSet res;
                        res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                        System.out.println("\n");
                        res = func.cocktail_to_method_insert_cocktail();
                        while (res.next()) {
                            System.out.println("id: " + res.getInt("id_cocktail") + "  Название: " + res.getString("Name"));
                        }

                        System.out.println("Введите id коктеля к которому хотите добавить метод");
                        id_cocktail = scanner.nextInt();
                        res = func.cocktail_to_method_insert_method();
                        System.out.println("Введите количество методов которое хотите добавить");
                        count = scanner.nextInt();
                        for (int i = 0; i < count; i++) {
                            while (res.next()) {
                                System.out.println("id: " + res.getInt("id_method") + "  Название: " + res.getString("Name"));
                            }
                            res = func.cocktail_to_method_insert_method();
                            id_method = scanner.nextInt();
                            func.insert_cocktail_to_method(id_cocktail, id_method);
                        }
                        res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                    }
                } else if (command == 2) {
                    System.out.println("1.Employee");
                    System.out.println("2.Post");
                    System.out.println("3.Method");
                    System.out.println("4.Cocktail_to_method");
                    command = scanner.nextInt();
                    if (command == 1) {
                        System.out.println("Введите id сотрудника");
                        id_employee = scanner.nextInt();
                        ResultSet result = func.delete_employee(id_employee);
                    } else if (command == 2) {
                        System.out.println("Введите название должности");
                        post_name = s.readLine();
                        ResultSet result = func.delete_post(post_name);
                    } else if (command == 3) {
                        System.out.println("Введите название метода");
                        method_name = s.readLine();
                        ResultSet result = func.delete_method(method_name);
                    } else if (command == 4) {
                        ResultSet res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                        System.out.println("Введите id коктейля");
                        id_cocktail = scanner.nextInt();
                        System.out.println("Введите id метода");
                        id_method = scanner.nextInt();
                        func.delete_cocktail_to_method(id_cocktail, id_method);
                        res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                    }
                    //обновление
                } else if (command == 3) {
                    System.out.println("1.Employee");
                    System.out.println("2.Post");
                    System.out.println("3.Method");
                    System.out.println("4.Cocktail_to_method");
                    command = scanner.nextInt();
                    if (command == 1) {
                        System.out.println("Введите id сотрудника");
                        id_employee = scanner.nextInt();
                        System.out.println("Введите ФИО");
                        FIO = s.readLine();
                        System.out.println("Введите пол");
                        sex = scanner.next();
                        System.out.println("Введите возраст");
                        age = scanner.nextInt();
                        System.out.println("Введите id должности");
                        fk_id_post = scanner.nextInt();
                        ResultSet result = func.update_employee(FIO, sex, age, fk_id_post, id_employee);
                    } else if (command == 2) {
                        System.out.println("Введите id должности");
                        id_post = scanner.nextInt();
                        System.out.println("Введите название дожности");
                        post_name = s.readLine();
                        System.out.println("Введите зарплату");
                        wage = scanner.nextInt();
                        ResultSet result = func.update_post(post_name, wage, id_post);
                    } else if (command == 3) {
                        System.out.println("Введите id метода");
                        id_method = scanner.nextInt();
                        System.out.println("Введите название метода");
                        method_name = s.readLine();
                        System.out.println("Введите описание метода");
                        description = s.readLine();
                        ResultSet result = func.update_method(id_method, method_name, description);
                    } else if (command == 4) {
                        ResultSet res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                        System.out.println("Введите id коктейля которое вы хотите изменить");
                        id_cocktail = scanner.nextInt();
                        System.out.println("Введите id метода который вы хотите изменить");
                        id_method = scanner.nextInt();
                        System.out.println("Введите id коктейля на которое вы хотите изменить");
                        id_cocktail_after = scanner.nextInt();
                        List<Method> list = func.method_select_all();
                        for (int i = 0; i < list.size(); i++) {
                            Method met = list.get(i);
                            System.out.println("Название метода: " + met.name + "  id :" + met.id);
                        }
                        System.out.println("Введите id метода на которое вы хотите изменить");
                        id_method_after = scanner.nextInt();
                        func.update_cocktail_to_method(id_cocktail, id_method, id_cocktail_after, id_method_after);
                        res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                    }
//получение данных
                } else if (command == 4) {
                    System.out.println("1.Employee");
                    System.out.println("2.Post");
                    System.out.println("3.Method");
                    System.out.println("4.Cocktail_to_method");
                    command = scanner.nextInt();
                    if (command == 1) {
                        System.out.println("Введите id сотрудника о котом хотите получить информацию");
                        id_employee = scanner.nextInt();
                        List<Employee> list = func.employee_select_id(id_employee);
                        Employee epml = list.get(0);
                        System.out.println(epml.fio + " Пол: " + epml.sex + "    Возраст: " + epml.age + "    Название должности: " + epml.id_post.post_name + "  Зарплата :" + epml.id_post.wage);
                    } else if (command == 2) {
                        System.out.println("Введите название должности о которой хотите получить информацию");
                        post_name = s.readLine();
                        List<Post> list = func.post_select_id(post_name);
                        Post pos = list.get(0);
                        System.out.println("Название должности: " + pos.post_name + "  Зарплата :" + pos.wage);
                    } else if (command == 3) {
                        System.out.println("Введите название метода о котором хотите получить информацию");
                        method_name = s.readLine();
                        List<Method> list = func.method_select_id(method_name);
                        Method met = list.get(0);
                        System.out.println("Название метода: " + met.name + "  Описание :" + met.description);
                    }
                      else  if(command==4){
                        System.out.println("Введите название коктейля о методах которого хотите получить информацию");
                        cocktail_name = s.readLine();
                        ResultSet res = func.cocktail_to_method_select_name(cocktail_name);
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString(4) + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                    }
                } else if (command == 5) {
                    System.out.println("1.Employee");
                    System.out.println("2.Post");
                    System.out.println("3.Method");
                    System.out.println("4.Cocktail_to_method");
                    command = scanner.nextInt();
                    if (command == 1) {
                        List<Employee> list = func.employee_select_all();
                        for (int i = 0; i < list.size(); i++) {
                            Employee epml = list.get(i);
                            System.out.println(epml.fio + " Пол: " + epml.sex + "    Возраст: " + epml.age + "    Название должности: " + epml.id_post.post_name);
                        }
                    } else if (command == 2) {
                        List<Post> list = func.post_select_all();
                        for (int i = 0; i < list.size(); i++) {
                            Post pos = list.get(i);
                            System.out.println("Название должности: " + pos.post_name + "  Зарплата :" + pos.wage);
                        }
                    } else if (command == 3) {
                        List<Method> list = func.method_select_all();
                        for (int i = 0; i < list.size(); i++) {
                            Method met = list.get(i);
                            System.out.println(met.id +"Название метода: " + met.name + "  Описание :" + met.description);
                        }
                    } else if (command == 4){
                        ResultSet res = func.cocktail_to_method_select();
                        while (res.next()) {
                            System.out.println(res.getInt("id_cocktail") + " - " + res.getString("coc") + "        " + res.getInt("id_method") + " - " + res.getString("met"));
                        }
                    }
                } else if (command == 6) {
                    System.out.println("Введите название должности");
                    post_name = s.readLine();
                    System.out.println("Вывод:");
                    ResultSet result = func.count_employee_post(post_name);
                    while (result.next()) {
                        System.out.println(result.getInt("count"));
                    }
                } else if (command == 7) {
                    System.out.println("Введите сумму");
                    wage = scanner.nextInt();
                    System.out.println("Вывод:");
                    ResultSet result = func.count_employee_wage(wage);
                    while (result.next()) {
                        System.out.println(result.getInt("count"));
                    }
                } else if (command == 8) {
                    System.out.println("Введите объем в мл.");
                    volume = scanner.nextInt();
                    ResultSet result = func.count_glass_volume(volume);
                    System.out.println("Вывод:");
                    while (result.next()) {
                        System.out.println(result.getInt("count"));
                    }
                } else if (command > 8 || command < 0) {
                    System.out.println("Некоррекрые данные");
                } else if (command == 0) {
                    System.out.println("Завершение работы");
                }

            }

    }
}
