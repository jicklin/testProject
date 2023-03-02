package test.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

/**
 * @author mal
 * @date 2023-03-01 10:51
 */
public class TestCompletableFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCompletableFuture testCompletableFuture = new TestCompletableFuture();
        testCompletableFuture.test();


       /* System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());*/

    }

    private void test() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "新沂";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "南京";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(
                () ->{
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "上海";
                }
        );

        //CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future1, future2, future3);
/*
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future1, future2, future3);
        System.out.println(anyFuture.thenApply(s -> s + "你好").get());

        System.out.println(anyFuture.thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return s + "哈哈哈";})).get());*/

        Stream.of(future1, future2, future3).map(CompletableFuture::join).forEach(System.out::println);

    }

}
