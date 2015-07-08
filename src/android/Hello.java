package com.serialport;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.FileDescriptor;
import com.serialport.SerialPort;

public class Hello extends CordovaPlugin {

    File file = new File ("/dev/", "ttyS2");
    private final SerialPort serialPort = new SerialPort(file, 115200, 1);

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("greet")) {

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
