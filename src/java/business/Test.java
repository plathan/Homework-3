/*
 *Copyright 2015 Drew Bryant and Patrick Lathan
 */
package business;

/**
 *
 * @author drewbryant
 */
public class Test {
  public static void main(String[] args){
    Calculator calc = new Calculator(1000, 5, 10);
    double result = calc.calculate();
    System.out.println(result);
  }
}
