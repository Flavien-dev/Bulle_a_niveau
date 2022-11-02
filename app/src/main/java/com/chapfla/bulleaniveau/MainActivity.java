package com.chapfla.bulleaniveau;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * classe principale de l'application
 */
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // déclaration des objets
    private SensorManager sensorManager;
    private TextView gravitySensorX;
    private TextView gravitySensorY;
    private Sensor gravSensor;

    /**
     * exécute le début du programme
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // initialise le gravity sensor
        gravSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        // champs des axes X et Y
        gravitySensorX = findViewById(R.id.textX);
        gravitySensorY = findViewById(R.id.textY);

        sensorManager.registerListener(this, gravSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    /**
     * s'exécute dès qu'une valeure est changée
     * @param sensorEvent
     */
    public void onSensorChanged(SensorEvent sensorEvent) {
        // affecte les valeurs dans les champs
        gravitySensorX.setText("X : " + sensorEvent.values[0]*10 + "%");
        gravitySensorY.setText("Y : " + sensorEvent.values[1]*10 + "%");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}