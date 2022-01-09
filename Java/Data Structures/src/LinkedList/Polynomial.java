package LinkedList;
import LinkedList.PolynomilalArithmetic.Node;

public class Polynomial
{
    public void addition(Node polynomial1, Node polynomial2)
    {
        Node pointer1 = polynomial1;
        Node pointer2 = polynomial2;
        Node polynomial3 = null;

        PolynomilalArithmetic polynomilalArithmetic = new PolynomilalArithmetic();

        while (pointer1 != null && pointer2 != null)
        {
            if (pointer1.exponent == pointer2.exponent)
            {
                polynomial3 = polynomilalArithmetic.insert(polynomial3, pointer1.coefficient + pointer2.coefficient, pointer1.exponent);
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            else if (pointer1.exponent > pointer2.exponent)
            {
                polynomial3 = polynomilalArithmetic.insert(polynomial3, pointer1.coefficient, pointer1.exponent);
                pointer1 = pointer1.next;
            }
            else if (pointer1.exponent < pointer2.exponent)
            {
                polynomial3 = polynomilalArithmetic.insert(polynomial3, pointer2.coefficient, pointer2.exponent);
                pointer2 = pointer2.next;
            }
        }

        while (pointer1 != null)
        {
            polynomial3 = polynomilalArithmetic.insert(polynomial3, pointer1.coefficient, pointer1.exponent);
            pointer1 = pointer1.next;
        }

        while (pointer2 != null)
        {
            polynomial3 = polynomilalArithmetic.insert(polynomial3, pointer2.coefficient, pointer2.exponent);
            pointer2 = pointer2.next;
        }
        System.out.println("Added Polynomial is: ");
        polynomilalArithmetic.print(polynomial3);
    }

    public void multiplication(Node polynomial1, Node polynomial2)
    {
        Node pointer1 = polynomial1;
        Node pointer2 = polynomial2;
        Node polynomial3 = null;

        PolynomilalArithmetic polynomilalArithmetic = new PolynomilalArithmetic();

        while (pointer1 != null)
        {
            pointer2 = polynomial2;
            while (pointer2 != null)
            {
                polynomial3 = polynomilalArithmetic.insert(polynomial3, pointer1.coefficient * pointer2.coefficient, pointer1.exponent + pointer2.exponent);
                pointer2 = pointer2.next;
            }
            pointer1 = pointer1.next;
        }
        System.out.println("Multiplied Polynomial is: ");
        polynomilalArithmetic.print(polynomial3);
    }

    public static void main(String[] args)
    {
        PolynomilalArithmetic polynomilalArithmetic = new PolynomilalArithmetic();
        Node polynomial1 = polynomilalArithmetic.create();
        polynomilalArithmetic.print(polynomial1);
        System.out.println();

        PolynomilalArithmetic polynomilalArithmetic2 = new PolynomilalArithmetic();
        Node polynomial2 = polynomilalArithmetic2.create();
        polynomilalArithmetic2.print(polynomial2);
        System.out.println();

        //PolynomialAddition polynomialAddition = new PolynomialAddition();
        //polynomialAddition.addition(polynomial1, polynomial2);

        Polynomial polynomialAddition = new Polynomial();
        polynomialAddition.multiplication(polynomial1, polynomial2);

    }
}
