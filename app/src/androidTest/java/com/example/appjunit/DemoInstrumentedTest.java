package com.example.appjunit;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class DemoInstrumentedTest {

    public static final String PREFIX_TEST = "jtest-";

    //@Rule
    //public final Timeout timeout = Timeout.seconds(100);

    @Rule
    public final TestName testName = new TestName();

    @Rule
    public final MyCustomRule1 rule1 = new MyCustomRule1();

    @Rule
    public final MyCustomRule2 rule2 = new MyCustomRule2();

    //@Rule
    //public final RuleChain chain = RuleChain.outerRule(rule1).around(rule2);

    @Rule
    public final TemporaryFolder tempFolder = new TemporaryFolder();

    private static String watchedLog = "\n";

    //@Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description.getDisplayName() + " " + "success!\n";
            Log.i(PREFIX_TEST,"Succeed! Watchlog:\n" + watchedLog);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
            Log.i(PREFIX_TEST,"Failed! Watchlog:\n" + watchedLog);
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
            Log.i(PREFIX_TEST,"Starting test! Watchlog:\n" + watchedLog);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
            Log.i(PREFIX_TEST,"Test finished! Watchlog:\n" + watchedLog
                    +"\n------------------------------------\n");
        }
    };

    @Test
    public void useAppContext() {
        Log.i(PREFIX_TEST,"---Test In progress---" + testName.getMethodName());

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.appjunit", appContext.getPackageName());

        Log.i(PREFIX_TEST,"---Test using AppContext---");
    }

    @Test
    public void createTempFilesTest() throws IOException {
        File icon = tempFolder.newFile("icon.png");
        File assets = tempFolder.newFolder("assets");

        Log.i(PREFIX_TEST,"---Test In progress--- " + testName.getMethodName());

        assertTrue(assets.exists());
        assertFalse(!icon.exists());

    }

}
