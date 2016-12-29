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

import com.google.auto.value.AutoValue;

import java.util.Map;
import java.util.Set;

import berlin.volders.auto.value.map.MapKey;

@AutoValue
abstract class TestAutoMap<T> implements Map<String, Object> {

    abstract String key1();

    @Nullable
    abstract Integer key2();

    abstract int key3();

    abstract T key4();

    @MapKey("key_5")
    abstract Set<String> key5();

    @SerializedName("key_6")
    abstract boolean key6();

    @Json(name = "key_7")
    abstract int key7();

    @MapKey
    @SerializedName("key_8")
    @Json(name = "key_8")
    abstract int key8();

    @Field("key_9")
    abstract int key9();

    @Header("key_a")
    abstract int keya();

    @Part("key_b")
    abstract int keyb();

    @Query("key_c")
    abstract int keyc();
}
