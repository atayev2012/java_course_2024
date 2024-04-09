package lab_03;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    private static String lastName, firstName, middleName, dateOfBirth;
    private static boolean gender;
    private static int age;
    public static void main(String[] args) {
        try {
            lastName = inputData("lastName");
            firstName = inputData("firstName");
            middleName = inputData("middleName");
            dateOfBirth = inputData("dateOfBirth");
            gender = identifyGender();
            age = identifyAge();

            System.out.println("\nФИО: " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ".\nПол: " + (gender?"Мужской\n":"Женский\n") + "Возраст: " + age);
        }catch(WrongInputException err){
            System.err.println("Ошибка: " + err.getMessage());
        }

    }

    // input requested data by viewing message
    private static String inputData(String message) throws WrongInputException{
        String outputMessage="", inputData;
        switch(message){
            case "lastName":
                outputMessage = "Введите свою фамилию: ";
                break;
            case "firstName":
                outputMessage = "Введите своё имя: ";
                break;
            case "middleName":
                outputMessage = "Введите своё отчество: ";
                break;
            case "dateOfBirth":
                outputMessage = "Введите свою дату рождения в формате дд.мм.гггг: ";
                break;
        }

        System.out.print(outputMessage);
        inputData = new Scanner(System.in).nextLine();


        // Check for empty string error
        if(inputData == null || inputData.isEmpty()){
            throw new WrongInputException("Входящая строка пустая!");
        }

        // Check wrong input format error
        switch(message){
            case "middleName":
                char lastChar = inputData.toLowerCase().charAt(inputData.length() - 1);
                if(lastChar != 'ч' && lastChar != 'а'){
                    throw new WrongInputException("Отчество введено неправильно!");
                }
                break;
            case "dateOfBirth":
                if(inputData.length() != 10){
                    throw new WrongInputException("Дата рождения введена в неправильном формате!");
                }
                break;
        }

        return inputData.substring(0, 1).toUpperCase() + inputData.substring(1).toLowerCase();
    }

    // identify gender by middle name True=Male, False=Female
    private static boolean identifyGender(){ return middleName.endsWith("ч");}

    // calculate difference between date of birth and today in years
    private static int identifyAge()  throws WrongInputException, NumberFormatException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        // date[0]=day, date[1]=month, date[2]=year
        String[] dateNow = formatter.format(new Date()).split("\\.");
        String[] dateThen = dateOfBirth.split("\\.");

        // Check for correctness of date

        int dayThen, monthThen,yearThen;
        if(dateThen.length != 3){
            throw new WrongInputException("Дата рождения введена в неправильном формате!");
        }

        if(dateThen[2].length() != 4){
            throw new WrongInputException("Год даты рождения введен в неправильном формате!");
        }

        try{
            dayThen = Integer.parseInt(dateThen[0]);
        }catch(NumberFormatException err){
            throw new WrongInputException("День даты рождения должен быть числом!");
        }

        try{
            monthThen = Integer.parseInt(dateThen[1]);
        }catch(NumberFormatException err){
            throw new WrongInputException("Месяц даты рождения должен быть числом!");
        }

        try{
            yearThen = Integer.parseInt(dateThen[2]);
        }catch(NumberFormatException err){
            throw new WrongInputException("Год даты рождения должен быть числом!");
        }

        int[] monthlyDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(dateThen[1].length() != 2 || monthThen < 1 || monthThen > 12){
            throw new WrongInputException("Месяц даты рождения введен неправильно!\nМесяц должен быть от 01 до 12!");
        }

        if(monthThen == 2 && yearThen%4 == 0){
            monthlyDays[monthThen] = 29;
        }

        if(dayThen < 1 || dayThen > monthlyDays[monthThen]){
            throw new WrongInputException("День даты рождения введен непарвильно!\nДень в месяце " + monthThen + " должен быть от 01 - " + monthlyDays[monthThen] + "!");
        }

        int years = Integer.parseInt(dateNow[2]) - Integer.parseInt(dateThen[2]);
        int monthNow = Integer.parseInt(dateNow[1]);

        if((monthThen > monthNow) || (monthThen == monthNow && Integer.parseInt(dateThen[0]) > Integer.parseInt(dateNow[0]))){
            years--;
        }
        return years;
    }

    // exceptions
    private static class WrongInputException extends Exception{
        public WrongInputException(String errorMessage){
            super(errorMessage);
        }
    }
}
