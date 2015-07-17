package android_serialport_api;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;


import android_serialport_api.SerialPort;
import android_serialport_api.SerialPortFinder;

public class Hello extends CordovaPlugin {

    private SerialPort serialPort = null;
    protected OutputStream mOutputStream;
    private InputStream mInputStream;
    
    public boolean open_con(String message) throws JSONException, SecurityException, IOException, InvalidParameterException {

        try {
                File file = new File ("/dev/usb/", "ttyS2");
                serialPort = new SerialPort(file, 115200, 0);
                mOutputStream = serialPort.getOutputStream();
                //mInputStream  = serialPort.getInputStream();
                //mOutputStream.write(new String(text).getBytes());
                mOutputStream.write(new String(message).getBytes());
                serialPort.close();
                serialPort = null;
                
        } catch (IOException ex) {
                ex.printStackTrace();
                return false;
        }
        return true;
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        
        String message = data.getString(0);
        
        if (action.equals("greet")) {

            try {
                
                this.open_con(message);
                
            } catch (IOException ex) {
                
                ex.printStackTrace();
            
            }
            
            //String name = data.getString(0);
            //String message = "Hello, " + name;
            //callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }
}
