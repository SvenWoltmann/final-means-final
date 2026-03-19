package eu.happycoders.final_means_final.demo5;

public class ChildDemoFixed {

    static void main() {
        ChildFixed child = new ChildFixed("Berlin", 13088);
        IO.println("set                 = " + Base.SET);
        IO.println("set.contains(child) = " + Base.SET.contains(child));
    }

}
