# auto-value-map [![Build Status][1]][2] [![Release][3]][4]
###### *Type-safe immutable generated value-type maps*

An [`AutoValue`][5] extension that generates a wrapper implementation for the
`Map<String, Object>` interface exposing all non-null properties.

## Usage

*auto-value-map* recognizes and applies to all `@AutoValue` annotated classes
implementing `Map<String, Object>`.

    @AutoValue
    public abstract class Foo implements Map<String, Object> {
        @MapKey("baz")
        public abstract String bar();
    }

To use a different value than the property name as key, annotate the abstract
method with `@MapKey` or any annotation named `@SerializedName` or `@Json`.

## Installation

Add a *auto-value-map* dependency to the [`apt`][6] and `provided` or
`compileOnly` configurations.

    apt "berlin.volders:auto-value-map:$autoValueMapVersion"
    provided "berlin.volders:auto-value-map:$autoValueMapVersion"

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
  [5]: https://github.com/google/auto
  [6]: https://bitbucket.org/hvisser/android-apt
