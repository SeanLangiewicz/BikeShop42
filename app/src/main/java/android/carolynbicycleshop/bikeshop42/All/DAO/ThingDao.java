package android.carolynbicycleshop.bikeshop42.All.DAO;

import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Project: BikeShop42
 * Package: android.carolynbicycleshop.bikeshop42.All.DAO
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2021
 * Time: 2:33 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Dao
public interface ThingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Thing thing);

    @Update
    void update (Thing thing);

    @Delete
    void delete(Thing thing);

    @Query("SELECT * FROM THING_TABLE ORDER BY thingID ASC")
    List<Thing> getAllThings();
}
