package ro.codewars.morsecode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {
	
    @Test
    public void testSomething01() {
        assertEquals("HEY JUDE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000")));
    }
    
    @Test
    public void testSomething02() {
        assertEquals("E", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000011000000")));
    }
    
    @Test
    public void testSomething03() {
        assertEquals("", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00000000000000000")));
    }
    
    @Test
    public void testSomething04() {
        assertEquals("A", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000011011111100000")));
    }
    
    @Test
    public void testSomething05() {
        assertEquals("A", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00000000110111100000")));
    }
    
    @Test
    public void testSomething06() {
        assertEquals("P", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000001101111101111110100000")));
    }
    
    @Test
    public void testSomething07() {
        assertEquals("M", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000001111100111111000000")));
    }
    
    @Test
    public void testSomething08() {
    	// - .... .     --.- ..- .. -.-. -.-     -... .-. --- .-- -.     ..-. --- -..-     .--- ..- -- .--. ...     --- ...- . .-.     - .... .     .-.. .- --.. -.--     -.. --- --.
    	//111111111000000111011101110111000000111000000000000000000011111111101111111110111011111111100000011101110111111111000000111011100000011111111101110111111111011100000011111111101110111111111000000000000000000011111111101110111011100000011101111111110111000000111111111011111111101111111110000001110111111111011111111100000011111111101110000000000000000000111011101111111110111000000111111111011111111101111111110000001111111110111011101111111110000000000000000000111011111111101111111110111111111000000111011101111111110000001111111110111111111000000111011111111101111111110111000000111011101110000000000000000000111111111011111111101111111110000001110111011101111111110000001110000001110111111111011100000000000000000001111111110000001110111011101110000001110000000000000000000111011111111101110111000000111011111111100000011111111101111111110111011100000011111111101110111111111011111111100000000000000000001111111110111011100000011111111101111111110111111111000000111111111011111111101110
        assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", 
        		MorseCodeDecoder.decodeMorse(
        				MorseCodeDecoder.decodeBitsAdvanced(
        						"00000001111111110000001110111011101110000001110000000000000000000111111111011111111101110111111111000000111011101111111110000001110111000000111111111011101111111110111000000111111111011101111111110000000000000000000111111111011101110111000000111011111111101110000001111111110111111111011111111100000011101111111110111111111000000111111111011100000000000000000001110111011111111101110000001111111110111111111011111111100000011111111101110111011111111100000000000000000001110111111111011111111101111111110000001110111011111111100000011111111101111111110000001110111111111011111111101110000001110111011100000000000000000001111111110111111111011111111100000011101110111011111111100000011100000011101111111110111000000000000000000011111111100000011101110111011100000011100000000000000000001110111111111011101110000001110111111111000000111111111011111111101110111000000111111111011101111111110111111111000000000000000000011111111101110111000000111111111011111111101111111110000001111111110111111111011100000000000000000000000000")));
    }
    
    @Test
    public void testSomething09() {
        assertEquals("I", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00000000011011000000")));
        assertEquals("I", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000000110011000000")));
    }
    
    @Test
    public void testSomething10() {
        assertEquals("E E", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000000110000011000000")));
        assertEquals("EE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000001100011000000")));
    }
    
    @Test
    public void testSomething11() {
        assertEquals("EE EEE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000001100000110000000010000100001000000")));
    }
    
    @Test
    public void testSomething12() {
        assertEquals("IE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000001010001000000")));
    }
    
    @Test
    public void testSomething13() {
        assertEquals("EE E", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000000100010000001000000")));
    }
    
    @Test
    public void testSomething14() throws Exception {
    	assertEquals("HEY JUDE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")));
    }
    
    @Test
    public void testSomething15() {
        assertEquals("I E", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00000000010100000001000000")));
    }
    
    @Test
    public void testSomething16() {
    	assertEquals("I", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000001010000000")));
    	assertEquals("I", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00000000110110000000")));
        assertEquals("EE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00000000100010000000")));
        assertEquals("EE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("0000000011000110000000")));
        assertEquals("I", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000001110001110000000")));
        
        //assertEquals("EE", MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000001100110000000")));
    }
    
    
    
    @Test
    public void testDictionary() {
        System.out.println("TEST: " + MorseCode.get(".-"));
        assertEquals("E", MorseCode.get("."));
    }
    
    @Test
    public void testTrimBy001() {
    	assertEquals("10111000001", MorseCodeDecoder.trimBy0("10111000001"));
    }
    
    @Test
    public void testTrimBy002() {
    	assertEquals("10111000001", MorseCodeDecoder.trimBy0("0101110000010"));
    }
    
    @Test
    public void testTrimBy003() {
    	assertEquals("10111000001", MorseCodeDecoder.trimBy0("00000000000000000000001011100000100000000000000000000"));
    }
    
    @Test
    public void testTrimBy004() {
    	assertEquals("10111000001", MorseCodeDecoder.trimBy0("1011100000100000"));
    }
    
    @Test
    public void testTrimBy005() {
    	assertEquals("10111000001", MorseCodeDecoder.trimBy0("00000010111000001"));
    }
    
    @Test
    public void testTrimBy006() {
    	assertEquals("", MorseCodeDecoder.trimBy0("00000000000000000000000"));
    }
    
    @Test
    public void testTrimBy007() {
    	assertEquals("", MorseCodeDecoder.trimBy0(""));
    }
    
    @Test
    public void testTrimBy008() {
    	assertEquals("", MorseCodeDecoder.trimBy0(null));
    }
    
    @Test
    public void testBuildObservations01() {
    	List<Integer> observations = 
    			MorseCodeDecoder.buildObservations(
    					MorseCodeDecoder.trimBy0(
    							"0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000"));
    	// Checks for: 
    	//1:   2   2   1   3   2   6   1   5   6    3   8   5   5   1   2   6   5   3   2   1
    	//0:     1   1   2   5   6   1   2   2   11   1   1   1   6   1   3   5   2   1   5
    	
    	Assert.assertArrayEquals(new Integer[] { 2, 1, 2, 1, 1, 2, 3, 5, 2, 6, 6, 1, 1, 2, 5, 2, 6, 11, 3, 1, 8, 1, 5, 1, 5, 6, 1, 1, 2, 3, 6, 5, 5, 2, 3, 1, 2, 5, 1 }, observations.toArray(new Integer[] {}));
    	
    }
    
    @Test
    public void testBuildMorseCode01() {
    	List<Integer> observations = 
    			MorseCodeDecoder.buildObservations(
    					MorseCodeDecoder.trimBy0(
    							"0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000"));
    	
    	String morseCode = 
    			MorseCodeDecoder.buildMorseCode(observations);
    	
    	// Expected: 
    	// .... . -.--   .--- ..- -.. .
    	
    	assertEquals(".... . -.--   .--- ..- -.. .", morseCode);
    	
    }
    
    
    @Test
    public void testExampleFromDescription() throws Exception {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")), is("HEY JUDE"));
    }

    @Test
    public void testBasicBitsDecoding() {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("1")), is("E"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("101")), is("I"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("10001")), is("EE"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("10111")), is("A"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("1110111")), is("M"));
    }

    @Test
    public void testMultipleBitsPerDotHandling() {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("111")), is("E"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("1111111")), is("E"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("110011")), is("I"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("111000111")), is("I"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("111110000011111")), is("I"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("11111100111111")), is("M"));
        
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("111000000000111")), is("EE"));
                
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("111000111000111")), is("S"));
    }

    @Test
    public void testExtraZerosHandling() {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("01110")), is("E"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("000000011100000")), is("E"));
    }

    @Test
    public void testLongMessagesHandling() {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110")), is("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBitsAdvanced("11111111111111100000000000000011111000001111100000111110000011111000000000000000111110000000000000000000000000000000000011111111111111100000111111111111111000001111100000111111111111111000000000000000111110000011111000001111111111111110000000000000001111100000111110000000000000001111111111111110000011111000001111111111111110000011111000000000000000111111111111111000001111100000111111111111111000000000000000000000000000000000001111111111111110000011111000001111100000111110000000000000001111100000111111111111111000001111100000000000000011111111111111100000111111111111111000001111111111111110000000000000001111100000111111111111111000001111111111111110000000000000001111111111111110000011111000000000000000000000000000000000001111100000111110000011111111111111100000111110000000000000001111111111111110000011111111111111100000111111111111111000000000000000111111111111111000001111100000111110000011111111111111100000000000000000000000000000000000111110000011111111111111100000111111111111111000001111111111111110000000000000001111100000111110000011111111111111100000000000000011111111111111100000111111111111111000000000000000111110000011111111111111100000111111111111111000001111100000000000000011111000001111100000111110000000000000000000000000000000000011111111111111100000111111111111111000001111111111111110000000000000001111100000111110000011111000001111111111111110000000000000001111100000000000000011111000001111111111111110000011111000000000000000000000000000000000001111111111111110000000000000001111100000111110000011111000001111100000000000000011111000000000000000000000000000000000001111100000111111111111111000001111100000111110000000000000001111100000111111111111111000000000000000111111111111111000001111111111111110000011111000001111100000000000000011111111111111100000111110000011111111111111100000111111111111111000000000000000000000000000000000001111111111111110000011111000001111100000000000000011111111111111100000111111111111111000001111111111111110000000000000001111111111111110000011111111111111100000111110000000000000001111100000111111111111111000001111100000111111111111111000001111100000111111111111111")), is("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
    }
    
    
}
