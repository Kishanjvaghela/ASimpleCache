# ASimpleCache
[ ![Download](https://api.bintray.com/packages/kishanvaghela/maven/a-simple-cache/images/download.svg) ](https://bintray.com/kishanvaghela/maven/a-simple-cache/_latestVersion)

ASimpleCache is a lightweight open source cache framework for android.

### 1. What can it cache?
- String
- JsonObject 
- JsonArray 
- Bitmap, Drawable
- Serialized java object
- Serialized java object list
- Byte data.

### 2. Features!
  - Configurable, you can configure the cache path, cache size, cache number, and so on.
  - You can set the cache timeout, the cache timeout automatically expires, and is deleted.
  - Support multi-process.


### 3. How to use?
Add to global gradle
```gradle
maven {
       url 'https://dl.bintray.com/kishanvaghela/maven/'
   }
```
Add to app gradle
```gradle
compile 'org.afinal.simplecache:a-simple-cache:1.0'
```

Save Data
```java
ACache mCache = ACache.get(this);
mCache.put("test_key1", "test value");

// Save 10 seconds, if more than 10 seconds to get the key, will be null
mCache.put("test_key2", "test value", 10);

//Save for two days, if more than two days to get the key, will be null
mCache.put("test_key3", "test value", 2 * ACache.TIME_DAY);
```
Retrieve data
```java
ACache mCache = ACache.get(this);
String value = mCache.getAsString("test_key1");
```
For more examples see Demo 

# Change note
### v1.0
- Add support for Serialized java object list


# Note
This libary is forked from [yangfuhai/ASimpleCache](https://github.com/yangfuhai/ASimpleCache)
