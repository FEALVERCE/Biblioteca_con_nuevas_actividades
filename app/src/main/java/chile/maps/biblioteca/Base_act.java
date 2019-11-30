package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

        private EditText edtx1, edtx2, edtx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        edtx1 = (EditText)findViewById(R.id.cod);
        edtx2 = (EditText)findViewById(R.id.nombre);
        edtx3 = (EditText)findViewById(R.id.precio);

    }

    public void añadirLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        if(!edtx1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", edtx1.getText().toString());
            registro.put("nombre", edtx2.getText().toString());
            registro.put("precio", edtx3.getText().toString());

            BaseDatos.insert("tablalibros", null, registro);
            BaseDatos.close();

            Toast.makeText(this, "Se ha ingresado un registro de libro", Toast.LENGTH_LONG).show();
        }
    }


    public void actualizarLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        if(!edtx1.getText().toString().isEmpty())
        {
            String codigo = edtx1.getText().toString();
            ContentValues registro = new ContentValues();
            registro.put("codigo", edtx1.getText().toString());
            registro.put("nombre", edtx2.getText().toString());
            registro.put("precio", edtx3.getText().toString());

            BaseDatos.update("tablalibros", registro,"codigo=?",new  String[]{codigo} );
            BaseDatos.close();

            Toast.makeText(this, "Se ha actualizado registro de libro", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarLibro(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!edtx1.getText().toString().isEmpty())
        {
            String codigo = edtx1.getText().toString();

            BaseDeDatos.delete("tablalibros", "codigo=?", new String[]{codigo});
            BaseDeDatos.close();

            Toast.makeText(this, "Se ha eliminado el Libro con codigo " + codigo, Toast.LENGTH_LONG).show();
        }
    }


}
