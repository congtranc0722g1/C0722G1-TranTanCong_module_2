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
    public long start(){
        this.startTime = System.currentTimeMillis();
        return this.startTime;
    }
    public long stop(){
        this.endTime = System.currentTimeMillis();
        return this.endTime;
    }
    public long getElapsedTime(){
        return stop() - start();
    }
}
