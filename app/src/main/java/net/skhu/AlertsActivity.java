package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AlertsActivity extends AppCompatActivity {

    int selectedAnimalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
    }

    public void button1_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.saveSuccess);
        builder.setNeutralButton(R.string.close,null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button2_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertsActivity.this,"삭제성공",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no,null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button3_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals,selectedAnimalIndex, null);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListView listView = ((AlertDialog)dialog).getListView();
                selectedAnimalIndex = listView.getCheckedItemPosition();
                String msg = selectedAnimalIndex + "번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this,msg,Toast.LENGTH_SHORT).show();

                int drawblelId = 0;
                switch(selectedAnimalIndex){
                    case 0: drawblelId = R.drawable.animal_cat_large; break;
                    case 1: drawblelId = R.drawable.animal_dog_large; break;
                    case 2: drawblelId = R.drawable.animal_owl_large; break;
                }
                ImageView imageView = (ImageView)findViewById(R.id.imageView1);
                imageView.setImageResource(drawblelId);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button4_clicked(View button){
        String[] stringArray = {"고양이", "강아지", "부엉이"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(adapter, selectedAnimalIndex, null);
    }

    public void button5_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        int drawableId = 0;

        builder.setPositiveButton(R.string.cat, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
                imageView1.setImageResource(R.drawable.animal_cat_large);
            }
        });
        builder.setNegativeButton(R.string.owl, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
                imageView1.setImageResource(R.drawable.animal_owl_large);
            }
        });
        builder.setNeutralButton(R.string.dog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
                imageView1.setImageResource(R.drawable.animal_dog_large);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

