import com.theoxao.test.App;

import java.util.concurrent.CompletableFuture;

class Foo {
    public static String asyncJava() {
        String my = await App.Companion.future();
        return my;
    }
}
