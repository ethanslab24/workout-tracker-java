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
        System.out.println("4. Search workout");
        System.out.println("5. Exit"); 
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
                      
            case 4 : boolean found = false;
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

                    
            case 5 : System.out.println("Exit"); running = false; break;
            default: System.err.println("Not a viable input.");
            }
        
        }
        
        keyboard.close();
    }
}