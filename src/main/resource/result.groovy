import java.util.concurrent.CompletableFuture;

class Boo {
    public static CompletableFuture<CompletableFuture<String>> asyncJava() {
        CompletableFuture<String> meFuture = future("theo");
        return meFuture.thenApply { me ->
            CompletableFuture<String> youFuture = future("sophia");
            return youFuture.thenApply { you ->
                return me.concat(you);
            }
        }
    }

    public static CompletableFuture<String> future(String name) {
        return CompletableFuture.completedFuture(name + " from future;");
    }

}
