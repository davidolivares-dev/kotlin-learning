# Tour Collections

| Collection Type | Description                                                             |
|:----------------|:------------------------------------------------------------------------|
| Lists           | Ordered collections of items                                            |
| Sets            | Unique unordered collections of items                                   |
| Maps            | Sets of key-value pairs where keys are unique and map to only one value |

## List

Lists store items in the order that they are added, and allow for duplicate items.

To create a read-only list (`List`), use the `listOf()` fun.

To create a mutable list (`MutableList`), use the `mutableListOf()` fun.

### List Operations

- Use `[index]` to access an item in the list
- Use `.first()` and `.last()` functions to get the first and last items in a list
- Use `.count()` to get the number of items in a list
  - `.size` is a property – it's stored on the collection
  - `.count()` and `.size` give the same result, but `.size` is preferred since it's more direct.
  - Use `.count { }` when you need filtered counting.
- Use `.add()` and `.remove()` functions to add or remove items from a mutable list
- To check that an item is in a list use the `in` operator

## Set

Lists are orders and allow duplicate items, sets are `unordered` and only store `unique` items

To create a read-only set (`Set`), use the `setOf()` fun.

To create a mutable set (`MutableSet`), use the `mutableSetOf()` fun.

### Set Operations

- Use `.count()` to get the number of items in a set
    - `.size` is a property – it's stored on the collection
    - `.count()` and `.size` give the same result, but `.size` is preferred since it's more direct.
    - Use `.count { }` when you need filtered counting.
- Use `.add()` and `.remove()` functions to add or remove items from a mutable set
- To check that an item is in a set use the `in` operator

## Map

Maps store items as key-value pairs. You access the value by referencing the key.
Maps are useful if you want to look up a value without using a numbered index, like in a list.

To create a read-only map (`Map`), use the `mapOf()` fun.

To create a mutable map (`MutableMap`), use the `mutableMapOf()` fun.

### Map Operations

- The easiest way to create maps is to use the `to` operator between each key and its value
- Use `[key]` to access a value in a map or add items to a mutable map
- Use `.remove()` fun to remove items from a mutable map
- Use `.count()` to get the number of items in a map
- Use `.containsKey()` to check if a specific key is already included in a map
- Use `.keys` or `.values` properties to obtain a collection of the keys or values of a map
- To check that an item is in a map use the `in` operator
- `map[key]` returns a nullable value (i.e. `String?`) – if the key doesn't exist it returns `null`

