package eu.happycoders.final_means_final.demo_2;

import java.lang.reflect.Field;

public class BoxTest {

    void main() throws NoSuchFieldException, IllegalAccessException {
        Field PRIVATE_FIELD = Box.class.getDeclaredField("privateField");
        Field PRIVATE_FINAL_FIELD = Box.class.getDeclaredField("privateFinalField");
        Field PUBLIC_FIELD = Box.class.getDeclaredField("publicField");
        Field PUBLIC_FINAL_FIELD = Box.class.getDeclaredField("publicFinalField");

    }

}
