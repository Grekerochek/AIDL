package com.alexander.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

public class RemoteService extends Service {

    private DataStorage dataStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        dataStorage = new DataStorage(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IDataInterface.Stub() {
            @Override
            public void setData(String data) throws RemoteException {
                dataStorage.saveStorageData(data);
            }

            @Override
            public String getData() throws RemoteException{
                return dataStorage.getStorageData();
            }
        };
    }
}
