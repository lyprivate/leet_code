package com.xiongxinqiang.thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author X.xq
 * @version 1.0
 * @date 2021/8/17 10:26 上午
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method("list");
    }


    public static void method(String a) throws ExecutionException, InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>());
        ReentrantLock lock = new ReentrantLock(true);
        long l = System.currentTimeMillis();
        List<CompletableFuture<String>> futures = new ArrayList<>();
        List<String> list = new ArrayList<>();
        //手动创建线程 or 线程池执行
        HashMap<String, Integer> map = new HashMap<String, Integer>(16) {{
            put("1", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("0", 0);
        }};
        for (int i = 0; i < 5; i++) {
            process(executor, futures, String.valueOf(i), map, lock);
        }
        //获取每个线程的响应
        for (CompletableFuture<String> future : futures) {
            list.add(future.get());
        }
        System.out.println(list);
        System.out.println(map);
        System.out.println(System.currentTimeMillis() - l);
        executor.shutdown();
    }


    public static void process(ExecutorService executor,
                               List<CompletableFuture<String>> futures,
                               String key, HashMap<String, Integer> map, ReentrantLock lock) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("线程名称：" + Thread.currentThread().getName());
            System.out.println("是否为守护线程：" + Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().getName() + ",获取锁，锁状态" + lock.isLocked());
            lock.lock();
            //故意用hashMap，模拟一次只有1个线程可以操作map
            map.put("1", map.get(key) + 1);
            lock.unlock();
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName() + ",执行完毕");
            return String.valueOf(map.get(key));
        }, executor);
        futures.add(future);
    }


}
