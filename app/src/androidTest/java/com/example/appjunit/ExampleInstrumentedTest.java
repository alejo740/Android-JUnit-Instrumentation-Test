package com.example.appjunit;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import static com.example.appjunit.DemoInstrumentedTest.PREFIX_TEST;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class ExampleInstrumentedTest {

    //@Rule
    public MyCustomRule1 myCustomRule1 = new MyCustomRule1();

    //@Rule
    public MyCustomRule2 myCustomRule2 = new MyCustomRule2();

    @Rule
    public final RuleChain chain = RuleChain.outerRule(myCustomRule1).around(myCustomRule2);

    @Rule
    public final TestName testName = new TestName();

    @Test
    public void useAppContext1() {
        Log.i(PREFIX_TEST,"---Test In progress 1---" + testName.getMethodName());
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.appjunit", appContext.getPackageName());
        Log.i(PREFIX_TEST,"---Test END 1---");
    }

}


