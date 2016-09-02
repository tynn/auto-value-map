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

    @Test
    public void map_containing_all_keys() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();

        assertTrue("map containing key1", actual.containsKey("key1"));
        assertEquals("map value for key1", key1, actual.get("key1"));
        assertTrue("map containing key2", actual.containsKey("key2"));
        assertEquals("map value for key2", key2, actual.get("key2"));
        assertTrue("map containing key3", actual.containsKey("key3"));
        assertEquals("map value for key3", key3, actual.get("key3"));
        assertTrue("map containing key4", actual.containsKey("key4"));
        assertEquals("map value for key4", key4, actual.get("key4"));
        assertTrue("map containing key_5", actual.containsKey("key_5"));
        assertEquals("map value for key_5", key5, actual.get("key_5"));
        assertTrue("map containing key_6", actual.containsKey("key_6"));
        assertEquals("map value for key_6", key6, actual.get("key_6"));
    }

    @Test
    public void map_not_containing_optional_key() throws Exception {
        TestAutoMap<CharSequence> actual =
                new AutoValue_TestAutoMap<>(key1, null, key3, key4, key5, key6);

        assertTrue("map containing key1", actual.containsKey("key1"));
        assertEquals("map value for key1", key1, actual.get("key1"));
        assertFalse("map not containing key2", actual.containsKey("key2"));
        assertEquals("map value for key3", null, actual.get("key2"));
        assertTrue("map containing key3", actual.containsKey("key3"));
        assertEquals("map value for key3", key3, actual.get("key3"));
        assertTrue("map containing key4", actual.containsKey("key4"));
        assertEquals("map value for key4", key4, actual.get("key4"));
        assertTrue("map containing key_5", actual.containsKey("key_5"));
        assertEquals("map value for key_5", key5, actual.get("key_5"));
        assertTrue("map containing key_6", actual.containsKey("key_6"));
        assertEquals("map value for key_6", key6, actual.get("key_6"));
    }

    @Test
    public void map_not_containing_any_other_key() throws Exception {
        TestAutoMap<CharSequence> actual = setupTestAutoMap();
        Set<String> expected = new HashSet<>(Arrays.asList(
                "key1", "key2", "key3", "key4", "key_5", "key_6"));

        assertEquals("map not containing other key", expected, actual.keySet());
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

    private TestAutoMap<CharSequence> setupTestAutoMap() {
        return new AutoValue_TestAutoMap<>(key1, key2, key3, key4, key5, key6);
    }
}
