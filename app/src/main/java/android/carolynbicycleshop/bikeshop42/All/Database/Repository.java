package android.carolynbicycleshop.bikeshop42.All.Database;

import android.app.Application;
import android.carolynbicycleshop.bikeshop42.All.DAO.ThingDao;
import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: BikeShop42
 * Package: android.carolynbicycleshop.bikeshop42.All.Database
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2021
 * Time: 2:48 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
public class Repository {
    private ThingDao mThingDAO;
    private List<Thing>mAllThings;
    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        ThingDatabaseBuilder db=ThingDatabaseBuilder.getDatabase(application);
        mThingDAO=db.thingDAO();
    }
    public List<Thing> getAllThings(){
        databaseExecutor.execute(()->{
            mAllThings=mThingDAO.getAllThings();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllThings;
    }

    public void update(Thing thing){
        databaseExecutor.execute(()->{
            mThingDAO.update(thing);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void insert(Thing thing){
        databaseExecutor.execute(()->{
            mThingDAO.insert(thing);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(Thing thing){
        databaseExecutor.execute(()->{
            mThingDAO.delete(thing);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
