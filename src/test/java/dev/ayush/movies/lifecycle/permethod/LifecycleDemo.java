package dev.ayush.movies.lifecycle.permethod;


import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LifecycleDemo {

        @BeforeAll
        public static void beforeAll(){
            System.out.println("beforeAll() got executed!!");
        }
        public LifecycleDemo(){

            System.out.println("Constructor got executed!!");
        }

        @BeforeEach
        public void beforeEach(){
            System.out.println("beforeEach() got executed!!");
        }
        @Test
        public void testOne(){
            System.out.println("testOne() got executed!!!!");
        }
        @Test
        public void testTwo(){
            System.out.println("testTwo() got executed!!!!");
        }

        @AfterEach
        public void AfterEach(){
            System.out.println("AfterEach() got executed!!");
        }


        @AfterAll
        public static void afterAll(){
            System.out.println("afterAll() got executed!!");
        }
    }

