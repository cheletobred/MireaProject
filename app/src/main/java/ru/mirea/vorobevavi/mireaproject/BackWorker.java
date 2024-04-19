package ru.mirea.vorobevavi.mireaproject;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class BackWorker extends Worker {
    private static final String TAG = "BackWorker";

    public BackWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "Работа началась");
        try {
            Thread.sleep(3000);
            Log.d(TAG, "Работа сделана.");
        } catch (InterruptedException e) {
            Log.e(TAG, "Ошибка", e);
            return Result.failure();
        }
        return Result.success();
    }
}