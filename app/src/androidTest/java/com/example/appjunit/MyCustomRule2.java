package com.example.appjunit;

import android.util.Log;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static com.example.appjunit.DemoInstrumentedTest.PREFIX_TEST;

public class MyCustomRule2 implements TestRule {
    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                Log.i(PREFIX_TEST,"Before-the-test-2");

                try {
                    base.evaluate();
                } finally {

                    Log.i(PREFIX_TEST,"After-the-test-2");
                }
            }
        };
    }
}
