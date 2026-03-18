package eu.happycoders.final_means_final.demo2;

import java.lang.reflect.Field;

public class BoxTestComplete {

    void main() throws NoSuchFieldException, IllegalAccessException {
        Field PRIVATE_FIELD = Box.class.getDeclaredField("privateField");
        Field PRIVATE_FINAL_FIELD = Box.class.getDeclaredField("privateFinalField");
        Field PUBLIC_FIELD = Box.class.getDeclaredField("publicField");
        Field PUBLIC_FINAL_FIELD = Box.class.getDeclaredField("publicFinalField");

        PRIVATE_FIELD.setAccessible(true);
        PRIVATE_FINAL_FIELD.setAccessible(true);
        PUBLIC_FIELD.setAccessible(true);
        PUBLIC_FINAL_FIELD.setAccessible(true);

        Box box = new Box();

        PRIVATE_FIELD.set(box, 42);
        IO.println(PRIVATE_FIELD.get(box));
        PRIVATE_FINAL_FIELD.set(box, 42);
        IO.println(PRIVATE_FINAL_FIELD.get(box));

        PUBLIC_FIELD.set(box, 42);
        IO.println(PUBLIC_FIELD.get(box));
        PUBLIC_FINAL_FIELD.set(box, 42);
        IO.println(PUBLIC_FINAL_FIELD.get(box));
    }

}
