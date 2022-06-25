package android.carolynbicycleshop.bikeshop42.All.Database;

import android.carolynbicycleshop.bikeshop42.All.DAO.ThingDao;
import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Project: BikeShop42
 * Package: android.carolynbicycleshop.bikeshop42.All.Database
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2021
 * Time: 2:38 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Database(entities={Thing.class}, version=1,exportSchema = false)
public abstract class ThingDatabaseBuilder extends RoomDatabase {
    public abstract ThingDao thingDAO();

    private static volatile ThingDatabaseBuilder INSTANCE;

    static ThingDatabaseBuilder getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized(ThingDatabaseBuilder.class){
                if(INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ThingDatabaseBuilder.class, "MyThingDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
                }

                }
        return INSTANCE;
            }


}
