# AutoValue: Map Extension
[![Build][1]][2] [![Release][3]][4] [![Arsenal][5]][6]
###### *Type-safe immutable generated value-type maps*

An [`AutoValue`][auto] extension that generates a wrapper implementation for
the `Map<String, Object>` interface, exposing all non-null properties.


## Usage

*auto-value-map* recognizes and applies to all `@AutoValue` annotated classes
implementing `Map<String, Object>`.

    @AutoValue
    public abstract class Foo implements Map<String, Object> {
        @MapKey("baz")
        public abstract String bar();
    }

To use a different name than the property name as key, annotate the abstract
method with `@MapKey` or any annotation with value `@Json.name()` or named
`@SerializedName`, `@Field`, `@Header`, `@Part` or `@Query`. An empty key will
default to the original property name.


## Installation

Add a *auto-value* and *auto-value-map* dependency to the [`apt`][apt] and
the annotations with *auto-value-map-no-proc* to the `provided` or
`compileOnly` configuration.

    apt "com.google.auto.value:auto-value:$autoValueVersion"

    apt "berlin.volders:auto-value-map:$autoValueMapVersion"
    provided "berlin.volders:auto-value-map:$autoValueMapVersion:no-proc"


## Limitations

This `AutoValueExtension` consumes all `entrySet()`, `isEmpty()`, `keySet()`,
`size()` and `values()` methods and thus such properties cannot be used.


## License

    Copyright (C) 2016 volders GmbH with <3 in Berlin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
   
        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


  [1]: https://travis-ci.org/volders/auto-value-map.svg?branch=master
  [2]: https://travis-ci.org/volders/auto-value-map
  [3]: https://jitpack.io/v/berlin.volders/auto-value-map.svg
  [4]: https://jitpack.io/#berlin.volders/auto-value-map
  [5]: https://img.shields.io/badge/Android%20Arsenal-auto--value--map-blue.svg
  [6]: https://android-arsenal.com/details/1/5068
  [auto]: https://github.com/google/auto
  [apt]: https://bitbucket.org/hvisser/android-apt
