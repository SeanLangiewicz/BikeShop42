package android.carolynbicycleshop.bikeshop42.All.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Project: BikeShop42
 * Package: android.carolynbicycleshop.bikeshop42.All.Entities
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2021
 * Time: 2:29 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Entity (tableName="thing_table")
public class Thing {
    @PrimaryKey(autoGenerate = true)
    private int thingID;


    private String thingName;

    public Thing(int thingID, String thingName) {
        this.thingID = thingID;
        this.thingName = thingName;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "thingName='" + thingName + '\'' +
                '}';
    }

    public int getThingID() {
        return thingID;
    }

    public void setThingID(int thingID) {
        this.thingID = thingID;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }
}
