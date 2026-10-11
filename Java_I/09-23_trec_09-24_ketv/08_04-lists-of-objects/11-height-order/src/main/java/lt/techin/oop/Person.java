package lt.techin.oop;

public class Person {
 private final String name;
 private final int height;

 public Person(String name, int height) {
  this.name = name;
  this.height = height;
 }

 public String getName() {
  return name;
 }

 public int getHeight() {
  return height;
 }

 @Override
 public String toString() {
  return name + " (" + height + " cm)";
 }

 @Override
 public boolean equals(Object other) {
  if (this == other) {
   return true;
  }
  if (!(other instanceof Person p)) {
   return false;
  }
  return height == p.height && java.util.Objects.equals(name, p.name);
 }

 @Override
 public int hashCode() {
  return java.util.Objects.hash(name, height);
 }
}