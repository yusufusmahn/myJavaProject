package CreditCardTest;

import OLDSNACKS.CreditCardValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    @Test
    public void testThatGetCreditCardTypeWorks() {
        CreditCardValidator creditCard = new CreditCardValidator();
        assertEquals("Mastercard", creditCard.getCreditCardType(new int[]{5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 3}));
        assertEquals("INVALID CARD NUMBER", creditCard.getCreditCardType(new int[]{2, 3, 4, 3, 1, 9, 2, 8, 3, 0, 4, 4, 9, 5, 8, 2}));
    }

    @Test
    public void testSumOfSecondDigitsRightToLeft() {
        CreditCardValidator creditCard = new CreditCardValidator();
        int[] creditCardNumber = {4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};
        assertEquals(37,creditCard.sumOfSecondDigitsRightToLeft(creditCardNumber));

    }




    @Test
    public void testSumOfDigitsInOddPositionRightToLeft() {
        CreditCardValidator creditCard = new CreditCardValidator();
        int[] creditCardNumber = {4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};
        assertEquals(38,creditCard.sumOfOddIndexes(creditCardNumber));
    }


    @Test
    public void testIsValidateCreditCard() {
        CreditCardValidator creditCard = new CreditCardValidator();
        int[] creditCardNumber = {4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};
        assertFalse(creditCard.isValidateCreditCard(creditCardNumber));

    }

    @Test
    public void testValidateCreditCard() {
        CreditCardValidator creditCard = new CreditCardValidator();
        int[] creditCardNumber = {4,3,8,8,5,7,6,0,1,8,4,1,0,7,0,7};
        assertTrue(creditCard.isValidateCreditCard(creditCardNumber));
    }

}
