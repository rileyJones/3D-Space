import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

public class Timer implements Runnable{
    private int FPS;
    private ArrayList<Updatable> updatableObjects;
    public Timer(int FPS, Updatable... updatableObjects){
        this.FPS=FPS;
        this.updatableObjects = new ArrayList<Updatable>();
        for(Updatable updatableObject : updatableObjects) {
            this.updatableObjects.add(updatableObject);
        }
    }

    @Override
    public void run(){
        long time = currentTimeMillis();
        double count=1;
        while(!Thread.currentThread().isInterrupted()){
            if(currentTimeMillis()-time>=count*1000/FPS){
                count=count%FPS+1;
                if(count==1.0){
                    time+=1000;
                }
                /*
                if ((currentTimeMillis() - time >= count *1000/ FPS)) {
                    System.out.println("slow");
                    Thread.currentThread().interrupt();
                }
                //*/
                for(Updatable updatableObject : updatableObjects){
                    updatableObject.update();
                }

            }
        }
    }
}
