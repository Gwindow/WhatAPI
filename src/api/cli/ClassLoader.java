package api.cli;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

public class ClassLoader {
	private static final HashMap<String, Class<?>> classMap = new HashMap<String, Class<?>>();
	private static File root;

	public static void setRootPath(String path) {
		root = new File(path);
	}

	public static void loadClassFiles() {
		File[] list = root.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				recursiveDirectorySearch(list[i]);
			}
			if (isClassFile(list[i])) {
				addFileToMap(list[i]);
			}
		}
	}

	private static void recursiveDirectorySearch(File dir) {
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				recursiveDirectorySearch(list[i]);
			}
			if (isClassFile(list[i])) {
				addFileToMap(list[i]);
			}
		}
	}

	private static void addFileToMap(File file) {
		FileClassLoader loader = new FileClassLoader();
		Class<?> clazz;
		try {
			clazz = loader.createClass(file);
			String className = clazz.getCanonicalName();
			int levels = className.replaceAll("[^.]*", "").length();
			File root = file.getParentFile();
			for (int j = 0; j < levels; j++) {
				root = root.getParentFile();
			}
			loader.addURL(root.toURI().toURL());
			classMap.put(clazz.getName(), clazz);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean isClassFile(File file) {
		if (file.isFile()) {
			String fileName = file.getName();
			int i = fileName.lastIndexOf(".");
			String ext = fileName.substring(i + 1, fileName.length());
			if (ext.equalsIgnoreCase("class"))
				return true;
			else
				return false;
		} else
			return false;
	}

	public static Class<?> getClassForKey(Object key) {
		if (classMap.containsKey(key))
			return classMap.get(key);
		else
			return null;
	}

	public static HashMap<String, Class<?>> getClassMap() {
		return classMap;
	}
}
