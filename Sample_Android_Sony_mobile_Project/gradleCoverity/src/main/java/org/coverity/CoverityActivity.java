package org.coverity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.test.mock.MockContext;
import java.io.File;

public class CoverityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase myDB;
        // Bug.  Don't use QLiteDatabase.openOrCreateDatabase 3 params
        myDB = SQLiteDatabase.openOrCreateDatabase("DB1", null, null);
        myDB.close();
        // Bug.  Don't use QLiteDatabase.openOrCreateDatabase 2 params
        myDB = SQLiteDatabase.openOrCreateDatabase("DB1", null);
        myDB.close();
        // Bug.  Don't use QLiteDatabase.openOrCreateDatabase 2 params File
        File myFile = new File("D:/My Projects/Sony/checkers/testFile.txt");
        myDB = SQLiteDatabase.openOrCreateDatabase(myFile, null);
        myDB.close();
        myFile.delete();

        // Bug.  Don't use QLiteDatabase.openDatabase 4 params
        myDB = SQLiteDatabase.openDatabase("DB1", null, 0, null);
        myDB.close();
        // Bug.  Don't use QLiteDatabase.openDatabase 3 params
        myDB = SQLiteDatabase.openDatabase("DB1", null, 0);
        myDB.close();

        MockContext context = new MockContext();
        // Not a Bug.  Using Context with MODE_PRIVATE
        myDB = context.openOrCreateDatabase("DB1", Context.MODE_PRIVATE, null);
        myDB.close();
        // Bug.  Cant be World Writable
        myDB = context.openOrCreateDatabase("DB1", Context.MODE_WORLD_WRITEABLE, null);
        myDB.close();
        // Bug.  Cant be World Readable
        myDB = context.openOrCreateDatabase("DB1", Context.MODE_WORLD_READABLE, null);
        myDB.close();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);
    }

     @Override
    public void onStart() {
        super.onStart();
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText("Hello world!");
    }
}
