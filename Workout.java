public class Workout {
    public String exerciseName;
    public int sets;
    public int reps;
    public double weight;
    public String date;
    
    public String toString() {
           return exerciseName + " | Sets: " + sets + " | Reps: " + reps + " | Weight: " + weight + " | Date: " + date;
    }
}