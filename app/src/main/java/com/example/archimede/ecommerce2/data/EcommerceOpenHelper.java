import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by archimede on 26/06/17.
 */

public class EcommerceOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = EcommerceOpenHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String CATEGORY_LIST_TABLE = "category";
    private static final String DATABASE_NAME = "ecommerceDB";
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_IMAGEPATH = "http://www.nonsprecare.it/wp-content/uploads/2014/07/rimedi-naturali-pulci-gatti.jpg";
    private static final String[] COLUMNS = { KEY_ID, KEY_TITLE, KEY_SUBTITLE, KEY_IMAGEPATH };
    private static final String CATEGORIES_TABLE_CREATE =
            "CREATE TABLE " + CATEGORY_LIST_TABLE + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY, " +
                    // id will auto-increment if no value passed
                    KEY_TITLE + " TEXT );";
    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CATEGORIES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public EcommerceOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
