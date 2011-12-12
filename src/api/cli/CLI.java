package api.cli;

import java.util.Scanner;

/**
 * The Class CLI.
 * 
 * @author Gwindow
 */
public class CLI {
	
	/** The scanner. */
	private Scanner scanner = new Scanner(System.in);
	
	/** The reflector. */
	private Reflector reflector = new Reflector();

	/**
	 * Inits the.
	 * 
	 * @param path
	 *            the path
	 */
	public void init(String path) {
		ClassLoader.setRootPath(path);
		ClassLoader.loadClassFiles();
		inputListener();
	}

	/**
	 * Input listener.
	 */
	private void inputListener() {
		while (true) {
			String s = scanner.nextLine();
			if (s.trim().equalsIgnoreCase("/HELP")) {
				showHelpMenu();
			} else if (s.trim().equalsIgnoreCase("/QUIT")) {
				Utils.print("Quiting...");
				System.exit(0);
			} else if (s.trim().equalsIgnoreCase("/CLEAR")) {
				reflector.clearStacks();
			} else if (s.trim().equalsIgnoreCase("/POP")) {
				reflector.popStacks();
			} else if (s.trim().equalsIgnoreCase("/STACK")) {
				reflector.printStack();
			} else if (s.trim().equalsIgnoreCase("/CLASSES")) {
				reflector.printClasses();
			} else if (s.trim().equalsIgnoreCase("/METHODS")) {
				reflector.printMethods();
			} else if (!s.trim().isEmpty()) {
				reflector.invoke(s);
			} else {
				Utils.print("Create new object or enter /help or /quit");
			}
		}
	}

	/**
	 * Show help menu.
	 */
	private void showHelpMenu() {
		Utils.print("Type /exit at anytime to exit help");
		Class<?> myClass;
		while (true) {
			Utils.print("Enter class you want help with or type /list");
			String input = scanner.nextLine();
			if (input.trim().equalsIgnoreCase("/LIST")) {
				Utils.print("List of classes");
				Utils.printSingleIndent(ClassLoader.getClassMap().keySet());

			} else if (input.trim().equalsIgnoreCase("/EXIT")) {
				Utils.print("Exited");
				break;
			} else {
				try {
					String className = input;
					myClass = ClassLoader.getClassForKey(className);
					Utils.print("List of methods");
					for (int i = 0; i < myClass.getDeclaredMethods().length; i++) {
						String name = myClass.getDeclaredMethods()[i].getName();
						String params = "";
						for (int j = 0; j < myClass.getDeclaredMethods()[i].getParameterTypes().length; j++) {
							params = params + myClass.getDeclaredMethods()[i].getParameterTypes()[j].getName() + ",";
						}
						Utils.printSingleIndent(name + "(" + params + ")");
					}
				} catch (Exception e) {
					Utils.print("Command does not exist");
				}
			}
		}
	}
}
