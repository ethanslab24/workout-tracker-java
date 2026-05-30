import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Workout> workouts = new ArrayList<>();
        String exercise;
        int sets;
        int reps;
        double weight;
        String date;
        
        boolean running = true;
        
        while(running){
        System.out.println("1. Add workout");
        System.out.println("2. View workouts");
        System.out.println("3. Delete workout");
        System.out.println("4. Exit");
        System.out.print("Enter Choice: ");

        int choice = keyboard.nextInt();

        switch(choice){
            case 1 : keyboard.nextLine();
                     Workout workout = new Workout();
                     System.out.println("\n" + "Exercise Name: "); 
                     exercise = keyboard.nextLine();
                     workout.exerciseName = exercise;
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
                     break;
            case 2 : for(int i = 0; i < workouts.size(); i++){
                         System.out.println(workouts.get(i));
                        }
                     break;
            case 3 : for(int i = 0; i < workouts.size(); i++){
                         System.out.print(i);
                         System.out.println(" : " + workouts.get(i).exerciseName);
                        } 
                     int delWorkout = keyboard.nextInt(); 
                     workouts.remove(delWorkout);
                     break;
                      
            case 4 : System.out.println("Exit"); running = false; break;
            default: System.err.println("Not a viable input.");
            }
        
        }
        
        keyboard.close();
    }
}