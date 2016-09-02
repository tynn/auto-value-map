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


@AutoValue
@SuppressWarnings("unused")
public abstract class Property {

    public abstract String getKey();

    public abstract String getName();

    public abstract String getValue();

    public abstract String getType();

    public abstract String getNullable();

    @AutoValue.Builder
    interface Builder {

        Builder setKey(String key);

        Builder setName(String name);

        Builder setValue(String value);

        Builder setType(String type);

        Builder setNullable(String nullable);

        Property create();
    }
}
