package lab_03;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    private static String lastName, firstName, middleName, dateOfBirth;
    private static boolean gender;
    private static int age;
    public static void main(String[] args) {
        lastName = inputData("Введите свою фамилию: ");
        firstName = inputData("Введите своё имя: ");
        middleName = inputData("Введите своё отчество: ");
        dateOfBirth = inputData("Введите свою дату рождения в формате дд.мм.гггг: ");
        gender = identifyGender();
        age = identifyAge();

        System.out.println("\nФИО: " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ".\nПол: " + (gender?"Мужской\n":"Женский\n") + "Возраст: " + age);
    }

    // input requested data by viewing message
    private static String inputData(String message){
        System.out.print(message);
        return (new Scanner(System.in)).nextLine();
    }

    // identify gender by middle name True=Male, False=Female
    private static boolean identifyGender(){
        return middleName.endsWith("ч");
    }

    // calculate difference between date of birth and today in years
    private static int identifyAge() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        // date[0]=day, date[1]=month, date[2]=year
        String[] dateNow = formatter.format(new Date()).split("\\.");
        String[] dateThen = dateOfBirth.split("\\.");

        int years = Integer.parseInt(dateNow[2]) - Integer.parseInt(dateThen[2]);
        int monthThen = Integer.parseInt(dateThen[1]);
        int monthNow = Integer.parseInt(dateNow[1]);

        if((monthThen > monthNow) || (monthThen == monthNow && Integer.parseInt(dateThen[0]) > Integer.parseInt(dateNow[0]))){
            years--;
        }
        return years;
    }
}
