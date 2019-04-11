package com.example.appjunit;

import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class DemoActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeText_OnClickButton() {
        onView(withId(R.id.myButton)).perform(ViewActions.click());

        onView(withId(R.id.myText)).check(matches(withText("")));

        onView(withId(R.id.myButton)).perform(ViewActions.click());

        onView(withId(R.id.myText)).check(matches(withText("This is a Demo")));
    }

}
