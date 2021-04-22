package org.githubvictorhanxu.examples.spying;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyExampleTest {

    @Test
    public void spyExampleTest() {
        Map<String, String> hashMap = new HashMap<String, String>();
        Map<String, String> hashMapSpy = spy(hashMap);

        System.out.println("hashMap get:" + hashMap.get("key"));

        System.out.println("hashMapSpy get"+ hashMapSpy.get("key")); // Will print null.

        hashMapSpy.put("key", "A value");

        System.out.println("hashMap get:" + hashMap.get("key"));
        System.out.println("hashMapSpy" + hashMapSpy.get("key")); // Will print "A value".

        when(hashMapSpy.get("key")).thenReturn("Another value");
        System.out.println(hashMapSpy.get("key")); // Will print "Another value".

    }
}
