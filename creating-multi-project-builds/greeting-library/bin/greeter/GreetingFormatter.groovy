package greeter

import groovy.transform.CompileStatic

@CompileStatic
class GreetingFormatter {
	
	static String greetings(final String name) {
		"Hello, ${name.capitalize()}" 
	}
	
}
