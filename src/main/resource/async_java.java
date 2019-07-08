import com.theoxao.test.App;

import java.util.concurrent.CompletableFuture;

class Foo {

    public static String asyncJava() {
        String my = await future();
        return my.concat("(这条消息来自未来)");
    }

    public static CompletableFuture<String> future(){
        return CompletableFuture.completedFuture("this is a message from future");
    }

}
