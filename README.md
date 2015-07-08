# Cordova Serial Port

This plugin is a port from [android-serialport-api](https://code.google.com/p/android-serialport-api/)

The current Android SDK does not provide any API for reading and writing to the Linux TTY serial ports. You may find such serial ports on the connector of HTC Android phones.

This project wants to provide a simple API to connect, read and write data through theses serial ports.

The supported features are:

listing the available serial ports on the device, including USB to serial adapters
configuring a serial ports (baudrate, stop bits, permission, ...)
providing standard InputStream and OutputStream Java interfaces
What is NOT possible with this project:

receiving/sending data through an USB slave interface

THIS PLUGIN IS STILL ON EARLY DEV STAGE. DON'T EXPECT TO WORK YET.

 
## Using
Clone the plugin

    $ git clone https://github.com/fabiomig/serialport-plugin.git

Create a new Cordova Project

    $ cordova create hello com.example.helloapp Hello
    
Install the plugin

    $ cd hello
    $ cordova plugin add https://github.com/fabiomig/serialport-plugin.git
    
Install Android platform

    cordova platform add android
    
Run the code

    cordova run 

## More Info

For more information on setting up Cordova see [the documentation](http://cordova.apache.org/docs/en/4.0.0/guide_cli_index.md.html#The%20Command-Line%20Interface)

For more info on plugins see the [Plugin Development Guide](http://cordova.apache.org/docs/en/4.0.0/guide_hybrid_plugins_index.md.html#Plugin%20Development%20Guide)
