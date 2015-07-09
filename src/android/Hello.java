package com.serialport;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.serialport.SerialPort;

public class Hello extends CordovaPlugin {

    private SerialPort serialPort = null;

    Hello() throws IOException {

    }
    
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        File file = new File ("/dev/", "ttyS2");
        serialPort = new SerialPort(file, 115200, 1);

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
