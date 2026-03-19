package eu.happycoders.final_means_final.demo5;

public class ChildDemo {

    static void main() {
        Child child = new Child("Berlin", 13088);
        IO.println("set                 = " + Base.SET);
        IO.println("set.contains(child) = " + Base.SET.contains(child));
    }

}
