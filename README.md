# Project 1: Webpage Cache

* Author: Daniel Rosales-Rodriguez
* Class: CS321 Section #4001
* Semester: Fall 2023

## Overview

Webpage Cache is a class designed with a generic implementation of a cache utilizing a data structure based on the
LinkedList class in java. This project uses the concepts of websites and webpages and utilizes a generic cache to store
webpages. 

## Included Files

Cache.java - source file
CacheTest.java - source file
WebpageGenerator.java - source file (provided class - Do not modify!)
Webpage.java - source file (provided class - Do not modify!)
KeyInterface.java - source file (provided interface - Do not modify!)
LoremIpsumGenerator.java - source (provided class - Do not modify!)
fruits.txt - text file (provided database - Do not modify!)
run-tests.sh - test script (provided - Do not modify!)
README.md - this file

## Reflection

This project was interesting. I enjoyed writing the required classes for Webpage Cache. Cache.java was perhaps the easy
part of the project. The concept of a cache is easy to understand, the most recently used object gets added to the front
of the cache and the least recently used object is removed. Having understood the logic of how a cache is used and how
it functions the methods were not too difficult to write. My initial struggle was understanding the difference between
the K and V generic implementation. Shortly after its purposes were clarified the methods were easy to implement. The 
get() method took me the longest to write in the Cache class as I was understanding how a key generic was to be used 
with the value generic until I realized its purpose is to compare their respective values. 

CacheTest.java was the most difficult part of the project for various reasons. The class was difficult to write as it 
required more critical thinking to know what I want to test for when generating and accessing webpages in the cache. The
beginning of the class was simple to write. We needed to check for our arguments length and parse valid arguments to 
test for our cache. Shortly after, I needed to account for the optional debug levels of the cache test. I was 
overcomplicating it but once that was solved it was easy to follow through and write the provided pseudocode to generate
webpages. The end was easy as all I needed to do was account for the debug level arguments with if-else statements and a
toString() method to print the cache statistics. 

The last part of this project that gave me trouble was running the test scripts. I ran into some issues in which I had 
to troubleshoot. I was passing 6/8 test cases and believed I had an error in my code only to find out that my OS was 
adding a carriage return at the end of each line in a text file. Despite that I enjoyed the overall process. 


## Compiling and Using

From the directory containing all the source files, compile the classes:
$ javac Cache.java CacheTest.java KeyInterface.java LoremIpsumGenerator.java Webpage.java WebpageGenerator.java

Run CacheTest.java, the output will display how to run it.
$ java CacheTest

Output: java CacheTest "Usage: <cache-size> <number-of-Webpages> <standard-deviation> <debug-level=0-3> [<seed>]

Run CacheTest.java with arguments <10> <100> <3.0> <123> (See rest of debug levels in CacheTest):
$ java CacheTest 10 100 3.0 123

Outputs Cache Statistics:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Cache with 10 entries has been created
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Total number of references:        100
Total number of cache hits:        74
Cache hit percent:                 74.00%

----------------------------------------------------------------
Time elapsed: 90.0 milliseconds
----------------------------------------------------------------

Run dos2unix run-test.sh test-cases/* to convert text files to Linux Format:
$ dos2unix run-test.sh test-cases/*

Run chmod +x run-tests.sh on Onyx server to execute permission to run tests:
$ chmod +x run-tests.sh

Run ./run-tests.sh to run test-scripts:
$ ./run-tests.sh

Output:

=======================================================================
Running Test 1: java CacheTest 10 100 3.0 0 123
===>  Time elapsed: 150.0 milliseconds
---- Test 1 output matches! ----
=======================================================================
Running Test 2: java CacheTest 15 100 3.0 0 123
===>  Time elapsed: 119.0 milliseconds
---- Test 2 output matches! ----
=======================================================================
Running Test 3: java CacheTest 100 10000 30.0 0 123
===>  Time elapsed: 4315.0 milliseconds
---- Test 3 output matches! ----
=======================================================================
Running Test 4: java CacheTest 150 10000 30.0 0 123
===>  Time elapsed: 923.0 milliseconds
---- Test 4 output matches! ----
=======================================================================
Running Test 5: java CacheTest 200 10000 30.0 0 123
===>  Time elapsed: 615.0 milliseconds
---- Test 5 output matches! ----
=======================================================================
Running Test 6: java CacheTest 400 50000 150.0 0 123
===>  Time elapsed: 38145.0 milliseconds
---- Test 6 output matches! ----
=======================================================================
Running Test 7: java CacheTest 700 50000 150.0 0 123
===>  Time elapsed: 10898.0 milliseconds
---- Test 7 output matches! ----
=======================================================================
Running Test 8: java CacheTest 1000 50000 150.0 0 123
===>  Time elapsed: 9230.0 milliseconds
---- Test 8 output matches! ----
=======================================================================

## Results

Refer to compiling and using segment.

## Sources used

- https://github.com/BoiseState/CS321-resources.git
- https://docs.oracle.com/javase/8/docs/api/

## Notes
