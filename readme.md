# `Jinx`

## A `10hex` backtracking configurable implementation

### Building

`Jinx` can be built with `Gradle` using the `build` task:

```
gradle build
```

The `build` task will generate a jar file.

### Usage

```
java -jar jinx-0.1.0.jar -key 0A221100000 -count 100
```

### History

#### Version 0.1.0

First release of `Jinx`.

- Sequential iteration over the _normal_ key search space;
- Added the `-key` parameter for configuring length of key and the starting point for the search;
- Added the `-count` parameter for configuring the number of keys to generate.

### License