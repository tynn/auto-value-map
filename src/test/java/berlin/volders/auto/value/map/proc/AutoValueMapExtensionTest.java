/*
 * Copyright (C) 2016 volders GmbH with <3 in Berlin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package berlin.volders.auto.value.map.proc;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AutoValueMapExtensionTest {

    final String key1 = "key1";
    final int key2 = 2;
    final int key3 = 3;
    final CharSequence key4 = "key4";
    final Set<String> key5 = Collections.singleton("key5");
    final boolean key6 = true;
    final int key7 = 7;
    final int key8 = 8;
    final int key9 = 9;
    final int keya = 10;
    final int keyb = 11;
    final int keyc = 12;

    @Test
    public void map_containing_all_key_values() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();

        assertKeyValue(actual, "key1", key1);
        assertKeyValue(actual, "key2", key2);
        assertKeyValue(actual, "key3", key3);
        assertKeyValue(actual, "key4", key4);
        assertKeyValue(actual, "key_5", key5);
        assertKeyValue(actual, "key_6", key6);
        assertKeyValue(actual, "key_7", key7);
        assertKeyValue(actual, "key8", key8);
        assertKeyValue(actual, "key_9", key9);
        assertKeyValue(actual, "key_a", keya);
        assertKeyValue(actual, "key_b", keyb);
        assertKeyValue(actual, "key_c", keyc);
    }

    @Test
    public void map_not_containing_optional_key() throws Exception {
        TestAutoMap<CharSequence> actual = new AutoValue_TestAutoMap<>(key1, null,
                key3, key4, key5, key6, key7, key8, key9, keya, keyb, keyc);

        assertNoKey(actual, "key2");
    }

    @Test
    public void map_not_containing_any_other_key() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();
        Set<String> expected = new HashSet<>(Arrays.asList(
                "key1", "key2", "key3", "key4", "key_5", "key_6", "key_7", "key8", "key_9",
                "key_a", "key_b", "key_c"));

        assertTrue("map not containing other key", expected.containsAll(actual.keySet()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void map_is_immutable_with_put() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();
        actual.put("key1", key1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void map_is_immutable_with_putAll() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();
        actual.putAll(Collections.singletonMap("key1", key1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void map_is_immutable_with_remove() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();
        actual.remove("key1");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void map_is_immutable_with_clear() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();
        actual.clear();
    }

    void assertNoKey(TestAutoMap<CharSequence> actual, String key) {
        assertFalse("map not containing " + key, actual.containsKey(key));
    }

    void assertKeyValue(TestAutoMap<CharSequence> actual, String key, Object value) {
        assertTrue("map containing " + key, actual.containsKey(key));
        assertEquals("map value for " + key, value, actual.get(key));
    }

    TestAutoMap<CharSequence> setupTestAutoMap() {
        return new AutoValue_TestAutoMap<>(key1, key2, key3, key4, key5, key6, key7, key8, key9,
                keya, keyb, keyc);
    }
}
