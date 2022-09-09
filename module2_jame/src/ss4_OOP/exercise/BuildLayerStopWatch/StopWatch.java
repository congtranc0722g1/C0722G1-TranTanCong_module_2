package ss4_OOP.exercise.BuildLayerStopWatch;

public class StopWatch {
    long startTime;
    long endTime;
    public  StopWatch(){

    }
    public StopWatch (long startTime, long endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void start(){
        this. startTime = System.currentTimeMillis();
    }
    public void stop(){
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return  this.endTime - this.startTime;
    }
}
