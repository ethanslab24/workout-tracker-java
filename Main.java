//import packages

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        
        Scanner keyboard = new Scanner(System.in);
        PrintWriter toFile = null;
        ArrayList<Workout> workouts = new ArrayList<>();
        boolean running = true;

        //String exerciseName;
        //int sets;
        //int reps;
        //double weight;
        //String date;

        //read txt for file persistence
        try{
            Scanner fileScanner = new Scanner(new File("workouts.txt"));
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                Workout workout = new Workout();
                workout.exerciseName = parts[0];
                int sets = Integer.parseInt(parts[1]);
                workout.sets = sets;
                int reps = Integer.parseInt(parts[2]);
                workout.reps = reps;
                double weight = Double.parseDouble(parts[3]);
                workout.weight = weight;
                workout.date = parts[4];
                workouts.add(workout);
            }
            fileScanner.close();
        }
        catch(FileNotFoundException e){
            System.err.println("File not found.");
        }
        
        //menu for user inputs
        while(running){
            System.out.println("1. Add workout");
            System.out.println("2. View workouts");
            System.out.println("3. Delete workout");
            System.out.println("4. Search workout");
            System.out.println("5. Edit Workout");
            System.out.println("6. Exit"); 
            System.out.print("Enter Choice: ");

            int choice = keyboard.nextInt();

            switch(choice){
                //adds workout
                case 1 : keyboard.nextLine();
                        Workout workout = new Workout();
                        System.out.println("\n" + "Exercise Name: "); 
                        workout.exerciseName = keyboard.nextLine();
                        System.out.println("Sets: ");
                        workout.sets = keyboard.nextInt();
                        System.out.println("Reps: ");
                        workout.reps = keyboard.nextInt();
                        System.out.println("Weight: ");
                        workout.weight = keyboard.nextDouble();
                        keyboard.nextLine();
                        System.out.println("Date: ");
                        workout.date = keyboard.nextLine();
                        workouts.add(workout);
                        try {
                            toFile = new PrintWriter(new FileWriter("workouts.txt", true));
                            toFile.println(workout.exerciseName + "," + workout.sets + "," + workout.reps + "," + workout.weight + "," + workout.date);
                            toFile.close();
                        } catch (IOException e) {
                            System.out.println("The workouts.txt could not be created");
                        }
                     
                        break;
                //view workouts
                case 2 : for(int i = 0; i < workouts.size(); i++){
                            System.out.println((i+1) + ": " +workouts.get(i));
                        }
                        System.out.print("\n");
                        break;
                //delete workouts
                case 3 :for(int i = 0; i < workouts.size(); i++){
                            System.out.print(i);
                            System.out.println(" : " + workouts.get(i).exerciseName);
                        } 
                        System.out.print("Enter workout number to delete: ");
                        int delWorkout = keyboard.nextInt(); 
                        if(delWorkout >= 0 && delWorkout < workouts.size()){
                            workouts.remove(delWorkout);
                        }else{
                            System.out.println("Invalid input.");
                            break;
                        }
                     
                        try {
                            toFile = new PrintWriter(new FileWriter("workouts.txt"));
                            for(int i = 0; i < workouts.size(); i++){
                            Workout w = workouts.get(i);
                            toFile.println(w.exerciseName + "," + w.sets + "," + w.reps + "," + w.weight + "," + w.date);
                        }
                        toFile.close();
                        } catch (IOException e) {
                            System.out.println("The workouts.txt could not be created");
                        }
                        break;
                      
                //search workouts
                case 4 :boolean found = false;
                        System.out.print("Type Workout: "); 
                        keyboard.nextLine();
                        String searchExercise = keyboard.nextLine();
                        for(int i = 0; i < workouts.size(); i++){
                            if(workouts.get(i).exerciseName.toLowerCase().contains(searchExercise.toLowerCase())){
                                System.out.println(workouts.get(i) + "\n");
                                found = true;
                            }
                        }
                        if (!found){
                            System.out.println("Workout not found.\n");
                            } break;

                //edit    
                case 5 : for(int i = 0; i < workouts.size(); i++){
                            System.out.print(i);
                            System.out.println(" : " + workouts.get(i).exerciseName);
                        } 
                        System.out.print("Enter workout number to edit: ");
                        int editWorkout = keyboard.nextInt(); 
                        if(editWorkout >= 0 && editWorkout < workouts.size()){
                            keyboard.nextLine();
                            Workout editedWorkout = workouts.get(editWorkout);
                            System.out.println("\n" + "Exercise Name: "); 
                            editedWorkout.exerciseName = keyboard.nextLine();
                            System.out.println("Sets: ");
                            editedWorkout.sets = keyboard.nextInt();
                            System.out.println("Reps: ");
                            editedWorkout.reps = keyboard.nextInt();
                            System.out.println("Weight: ");
                            editedWorkout.weight = keyboard.nextDouble();
                            keyboard.nextLine();
                            System.out.println("Date: ");
                            editedWorkout.date = keyboard.nextLine();
                            try {
                                toFile = new PrintWriter(new FileWriter("workouts.txt"));
                                for(int i = 0; i < workouts.size(); i++){
                                Workout w = workouts.get(i);
                                toFile.println(w.exerciseName + "," + w.sets + "," + w.reps + "," + w.weight + "," + w.date);
                                }
                                toFile.close();
                            } catch (IOException e) {
                            System.out.println("The workouts.txt could not be created");
                            }
                        }else{
                            System.out.println("Invalid input.");
                            break;
                        } break;
                //exit
                case 6 : System.out.println("Exit"); running = false; break;
                default: System.err.println("Not a viable input.");
            }
        
        }
        
            keyboard.close();
    }
}