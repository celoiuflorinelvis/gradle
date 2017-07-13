
package greeter

import spock.lang.Specification

class GreetingFormatterUnitTest extends Specification {
    def "greetings returns capitalize"() {
        setup:
        //def lib = new 

        when:
        def result = GreetingFormatter.greetings('ion')

        then:
        result == 'Hello, Ion'
    }
    
    def 'Creating greetings with capitalize'() {
    	expect: 'The greeeting to be correctly capitalized' 
    	GreetingFormatter.greetings('sorin') == 'Hello, Sorin' 
    }
}
