# Android-Maven-Docker
An android test framework written in java(build-tool:Maven) which includes appium and testng as a framework. This framework is wrapped in docker for easier setup of automation environment.

# Why is this approach needed at first place?
Helps in quick & easier setup of automation environment for appium + android.

Without this approach, you'll need to do each of the automation setup steps manually; which can be slow and error prone.

# Images Included:
# 1:
rgonalo/appium

# 2:
iamranit/appium-maven-docker:0.0.5

# How to run it:
# First things first!!!
Connect a real android device with your mac and update the capabilities in AndroidDriverManager class.

# Second !!!
Make sure you have docker latest version installed in your mac.

# Third !!!
Build the dockerfile and push the image created to your dockerhub repository with some tag.

# Fourth !!!
Make changes to the docker-compose.yml according to the image you have just created.

# Fifth . !!!
Setting up Android real device test on Docker macOSX

## Setting up Android real device test on Docker macOSX

1. Make sure you have latest docker installed on mac.

	```
	$ docker-machine --version
	$ docker-machine version 0.10.0, build 76ed2a6
	```

2. Create a docker-machine as follows

	```
	$ docker-machine create --driver virtualbox appium-test-machine
	```

3. Enable USB in created docker-machine

	```
	$ docker-machine stop appium-test-machine
	$ vboxmanage modifyvm appium-test-machine --usb on --usbehci on
	$ docker-machine start appium-test-machine
	```
	***Note:***
	You need to install [Extension Pack](https://www.virtualbox.org/wiki/Download_Old_Builds_5_1) depends on your virtualbox version, in case you get an Error "Implementation of the USB 2.0 controller not found"

4. Open Virtual box, move to appium-test-machine created, select USB and add Android device and Host Controller.

	![alt tag](images/virtualbox.png)

5. Remove your base machine's ownership over the Android device(s)

	```
	adb kill-server
	```

6. SSH into the docker machine created

	```
	$ docker-machine ssh appium-test-machine
	```

7. Go to the directory where the docker-compose.yml file is located


8. Turn the docker-compose up

	```
	$ docker-compose up
	```
 9. Run following command to verify adb devices can detect the connected android device.

	```
	$ docker exec -it container-appium adb devices
	``` 
  
### Share Android identification key

Each time, you will (re)create container, connected to container devices will ask for authorization after first
 connection.  To prevent that, you can share one identity through all created containers. To do that, you should:

- Connect all devices to docker physical machine
- Run `adb devices`
- Authorize all devices (do not forget to check **Always allow this computer**)
