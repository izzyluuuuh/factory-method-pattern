package com.mycompany.testfactory;
//Here is a public class named TestFactory to execute the Factory Method pattern implementation.
//I instantiated a Laptop objects named "min" and "reco" with its values each for the 2nd and 4th
parameters.
//Here will display the content of the two objects in separate lines.
public class TestFactory {

 public static void main(String[] args) {
 Laptop min = LaptopFactory.getSpecs("min", 8, 256, "i5-12450Hz");
 Laptop reco = LaptopFactory.getSpecs("min", 16, 512, "i7-12700Hz");
 System.out.println("Minimum Specs:");
 System.out.println(min);
 System.out.println("Recommended Specs");
 System.out.println(reco);
 }
}
//I created an abstract superclass named Laptop.
abstract class Laptop {
 public abstract int getRAM();
 public abstract int getSSD();
 public abstract String getCPU();
 @Override
 public String toString() {
 return "RAM="+this.getRAM()+"GB, SSD="+this.getSSD()+", CPU="+this.getCPU();
 }
}
//Here is a subclass named Minimum which extends my superclass Laptop.
//In this class, I declared 3 private variables.
class Minimum extends Laptop {
 private int ram;
 private int ssd;
 private String cpu;
//here is the constructor of the Minimum class and the methods that would return the value of the
instance variables,
 public Minimum(int ram, int ssd, String cpu){
 this.ram=ram;
 this.ssd=ssd;
 this.cpu=cpu;
 }
 @Override
 public int getRAM() {
 return ram;
 }
 @Override
 public int getSSD() {
 return ssd;
 }
 @Override
 public String getCPU() {
 return cpu;
 }
}
//Here is another subclass named Recommended that also extends the superclass Laptop
class Recommended extends Laptop {
 private int ram;
 private int ssd;
 private String cpu;
 //This is the constructor of the Recommended class and the methods that would return the value of
the instance variables.
 public Recommended(int ram, int ssd, String cpu) {
 this.ram=ram;
 this.ssd=ssd;
 this.cpu=cpu;
 }
 @Override
 public int getRAM() {
 return ram;
 }
 @Override
 public int getSSD() {
 return ssd;
 }
 @Override
 public String getCPU() {
 return cpu;
 }
}
//Here is the class named LaptopFactory
class LaptopFactory {
public static Laptop getSpecs(String type, int ram, int ssd, String cpu){
 if("min".equalsIgnoreCase(type))
 return new Minimum(ram, ssd, cpu);
 else if("reco".equalsIgnoreCase(type))
 return new Recommended(ram, ssd, cpu);
 return null;
}
}