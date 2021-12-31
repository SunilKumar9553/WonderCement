package DesktopUtil;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class AppProcess {
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";
	static String winiumProcessName = "Winium.Desktop.Driver.exe";
	static Desktop desktop;

	public static boolean isProcessRunning(String serviceName) throws Exception {
		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			// System.out.println(line);
			if (line.contains(serviceName)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * KillProcess method used for kill the driver process if already running
	 * @Param serviceName
	 */
	public static void killProcess(String serviceName) throws Exception {
		if (isProcessRunning(serviceName)) {
			Runtime.getRuntime().exec(KILL + serviceName);
			System.out.println("*****************" + serviceName + " killed sucessfully*********************");
			Thread.sleep(3000);
		} else
			System.out.println("*****************" + serviceName + " killed sucessfully*********************");
	}

	/*
	 * startApplication used for start services
	 * 
	 * @Param serviceName
	 * 
	 * @Param appPath
	 */
	public static void startApplication(String serviceName, String appPath) throws Exception {
		if (!isProcessRunning(serviceName)) {
			desktop = Desktop.getDesktop();
			desktop.open(new File(appPath));
			System.out.println("*****************winium launched*********************");
			Thread.sleep(3000);
		} else
			System.out.println("*****************already winium launched*********************");
	}

	public static void main(String args[]) throws Exception {
		// System.out.print(isProcessRunning(processName));

	}
}