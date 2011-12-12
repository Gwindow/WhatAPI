


package api.cli;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import api.util.Tuple;

/**
 * The Class Reflector.
 * 
 * @author Gwindow
 */
public class Reflector {
	
	/** The class stack. */
	private Stack<Class<?>> classStack = new Stack<Class<?>>();
	
	/** The object stack. */
	private Stack<Object> objectStack = new Stack<Object>();
	
	/** The tokenizer. */
	private StringTokenizer tokenizer;

	/**
	 * Invoke.
	 * 
	 * @param input
	 *            the input
	 */
	public void invoke(String input) {
		if (input.startsWith("new")) {
			String className = splitClassName(input);
			List<String> constructorParams = splitParametersList(input);
			try {
				Utils.print(className);
				Utils.print(constructorParams);
				invokeConstructor(className, constructorParams);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String methodName = splitMethodName(input);
			List<String> methodParams = splitParametersList(input);
			try {
				invokeMethod(methodName, methodParams);
				Utils.print("method invoked");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Split class name.
	 * 
	 * @param input
	 *            the input
	 * @return the string
	 */
	private String splitClassName(String input) {
		String className = input.replace("new", "").trim();
		className = className.replaceAll("\\((.*?)\\)", "");
		return className;
	}

	/**
	 * Split method name.
	 * 
	 * @param input
	 *            the input
	 * @return the string
	 */
	private String splitMethodName(String input) {
		String methodName = input.replaceAll("\\((.*?)\\)", "").trim();
		return methodName;
	}

	/**
	 * Invoke constructor.
	 * 
	 * @param className
	 *            the class name
	 * @param params
	 *            the params
	 * @throws Exception
	 *             the exception
	 */
	private void invokeConstructor(String className, List<String> params) throws Exception {
		Tuple<Class<?>[], Object[]> tuple = translateToParams(params);
		invokeConstructor(className, tuple.getA(), tuple.getB());
	}

	/**
	 * Invoke method.
	 * 
	 * @param methodName
	 *            the method name
	 * @param params
	 *            the params
	 * @throws Exception
	 *             the exception
	 */
	private void invokeMethod(String methodName, List<String> params) throws Exception {
		Tuple<Class<?>[], Object[]> tuple = translateToParams(params);
		invokeMethod(methodName, tuple.getA(), tuple.getB());
	}

	/**
	 * Split parameters list.
	 * 
	 * @param input
	 *            the input
	 * @return the array list
	 */
	private ArrayList<String> splitParametersList(String input) {
		ArrayList<String> parametersList = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\((.*?)\\)", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			tokenizer = new StringTokenizer(matcher.group(1), ",");
			while (tokenizer.hasMoreTokens()) {
				parametersList.add(tokenizer.nextToken().trim());
			}
			return parametersList;
		}
		return null;
	}

	/**
	 * Translate to params.
	 * 
	 * @param parametersList
	 *            the parameters list
	 * @return the tuple
	 */
	private Tuple<Class<?>[], Object[]> translateToParams(List<String> parametersList) {
		Class<?>[] classParams = new Class[parametersList.size()];
		Object[] methodParams = new Object[parametersList.size()];
		for (int i = 0; i < parametersList.size(); i++) {
			String s;
			s = Utils.split(parametersList.get(i), "\"", "\"");
			if (s != null) {
				classParams[i] = String.class;
				methodParams[i] = s;
				// System.err.println("string");
			} else if (parametersList.get(i).equalsIgnoreCase("true")) {
				classParams[i] = boolean.class;
				methodParams[i] = true;
				// System.err.println("true boolean");
			} else if (parametersList.get(i).equalsIgnoreCase("false")) {
				classParams[i] = boolean.class;
				methodParams[i] = false;
				// System.err.println("false boolean");
			} else if (parametersList.get(i).equalsIgnoreCase("null") || parametersList.equals("")) {
				classParams = null;
				methodParams = null;
				// System.err.println("null");
			} else {
				classParams[i] = Integer.class;
				methodParams[i] = parametersList.get(i);
				// System.err.println("integer");
			}
		}
		return new Tuple<Class<?>[], Object[]>(classParams, methodParams);
	}

	/**
	 * Invoke constructor.
	 * 
	 * @param className
	 *            the class name
	 * @param classParams
	 *            the class params
	 * @param constructorParams
	 *            the constructor params
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SecurityException
	 *             the security exception
	 * @throws NoSuchMethodException
	 *             the no such method exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws InstantiationException
	 *             the instantiation exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	private void invokeConstructor(String className, Class<?>[] classParams, Object[] constructorParams)
			throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException, InvocationTargetException {
		classStack.add(ClassLoader.getClassForKey(className));
		Constructor<?> constructor = classStack.peek().getConstructor(classParams);
		objectStack.add(constructor.newInstance(constructorParams));

	}

	/**
	 * Invoke method.
	 * 
	 * @param methodName
	 *            the method name
	 * @param classParams
	 *            the class params
	 * @param methodParams
	 *            the method params
	 * @throws SecurityException
	 *             the security exception
	 * @throws NoSuchMethodException
	 *             the no such method exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	private void invokeMethod(String methodName, Class<?>[] classParams, Object[] methodParams) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method method = classStack.peek().getMethod(methodName, classParams);
		// objectStack.add(method.invoke(objectStack.peek(), methodParams));
		method.invoke(objectStack.peek(), methodParams);
		Utils.printSingleIndent(objectStack.peek());
		System.out.println("return type");
		System.out.println(method.getGenericReturnType());
	}

	/**
	 * Prints the classes.
	 */
	public void printClasses() {
		Utils.print("List of classes");
		Utils.printSingleIndent(ClassLoader.getClassMap().keySet());
	}

	/**
	 * Prints the methods.
	 */
	public void printMethods() {
		if (!classStack.isEmpty()) {
			Utils.print("List of methods");
			Class<?> myClass = classStack.peek();
			for (int i = 0; i < myClass.getDeclaredMethods().length; i++) {
				String name = myClass.getDeclaredMethods()[i].getName();
				String params = "";
				for (int j = 0; j < myClass.getDeclaredMethods()[i].getParameterTypes().length; j++) {
					params = params + myClass.getDeclaredMethods()[i].getParameterTypes()[j].getName() + ",";
				}
				Utils.printSingleIndent(name + "(" + params + ")");
			}
		} else {
			Utils.print("No classes in stack");
		}
	}

	/**
	 * Checks if is stacks empty.
	 * 
	 * @return true, if is stacks empty
	 */
	public boolean isStacksEmpty() {
		if (classStack.isEmpty() || objectStack.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Clear stacks.
	 */
	public void clearStacks() {
		classStack.clear();
		objectStack.clear();
		Utils.print("Cleared");
	}

	/**
	 * Pop stacks.
	 */
	public void popStacks() {
		try {
			classStack.pop();
			objectStack.pop();
			Utils.print("Popped");
		} catch (Exception e) {
			Utils.print("Nothing to pop");
		}
	}

	/**
	 * Prints the stack.
	 */
	public void printStack() {
		try {
			Utils.print(classStack.peek().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Utils.print(objectStack.peek().toString());
			System.out.println("Size: " + objectStack.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!objectStack.empty()) {
			Utils.print("Current Object: " + classStack.peek().toString().replace("class ", ""));
			Utils.print(classStack.toString().replace("class ", ""));
		} else {
			Utils.print("Stack empty");
		}
	}
}
