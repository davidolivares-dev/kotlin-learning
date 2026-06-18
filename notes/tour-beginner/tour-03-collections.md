# Tour Collections

| Collection Type | Description                                                             |
|:----------------|:------------------------------------------------------------------------|
| Lists           | Ordered collections of items                                            |
| Sets            | Unique unordered collections of items                                   |
| Maps            | Sets of key-value pairs where keys are unique and map to only one value |

## List

Lists store items in the order they are added and allow duplicate items.

- `listOf()` — read-only `List`
- `mutableListOf()` — mutable `MutableList`

### List Operations

- `[index]` — access an item by index
- `.first()`, `.last()` — get the first or last item
- `.size` — preferred over `.count()` for simple counts; `.count { }` for filtered counts
- `.add()`, `.remove()` — add or remove items (mutable only)
- `in` — check if an item exists in the list

## Set

Unlike lists, sets are unordered and only store unique items.

- `setOf()` — read-only `Set`
- `mutableSetOf()` — mutable `MutableSet`

### Set Operations

- `.size` — preferred for simple counts; `.count { }` for filtered counts
- `.add()`, `.remove()` — add or remove items (mutable only)
- `in` — check if an item exists in the set

## Map

Maps store key-value pairs. You look up a value by its key rather than an index.

- `mapOf()` — read-only `Map`
- `mutableMapOf()` — mutable `MutableMap`

### Map Operations

- `to` — create key-value pairs: `mapOf(1 to "one", 2 to "two")`
- `[key]` — access a value; returns a nullable type (`String?`) — returns `null` if the key doesn't exist
- `.remove()` — remove an entry (mutable only)
- `.containsKey()` — check if a key exists
- `.keys`, `.values` — get a collection of all keys or all values
- `in` — check if a key exists in the map
