[[_TimeComplexityGuide]]

# [A Time Complexity Guide](https://codeforces.com/blog/entry/104888)

## Abstract
Handle: Often in Competitive Programming, we have to choose between multiple algorithms/ approaches for a problem. How do we decide which algorithm is better and which algorithm to go for? ==Runnning an algorithm comes at the cost in the form== of time taken or memory consumed. In this blog, we will try to ==compare algorithms or approaches based on their Time Complexity==, which simply put is the time taken by them to run.

## Key concepts
#time_complexity; #bubble_sort; #method/competitive_programming; #competitive_programming; #LinkedIn

## Quote
> That we have seen an example of experimentally getting the time taken by a program / algorithm to run, we can move on to theoretically predicting the time complexity of a program based on the number of primitive operations performed by the program for a given input size

## Key points
- Handle: Often in Competitive Programming, we have to choose between multiple algorithms/ approaches for a problem
- The Big O Notation (O()&quot; role=&quot;presentation&quot;&gt;O()O()) provides a mathematical notation to understand the complexity of an algorithm or to represent the complexity of an algorithm
- The idea is that time taken for an algorithm or a program to run is some function of the input size (n)
- It removes constant factors so that the running time can be estimated in relation to n. the Big O notation is for the upper bound assessment and is the worst case consideration of the time complexity
- The following is the graphical representation of the number of primitive operatons vs input size of some of the common time complexities that one may come across — (This is the cleanest graphical representation I could find, and I got it from This LinkedIn Post)
- That we have seen an example of experimentally getting the time taken by a program / algorithm to run, we can move on to theoretically predicting the time complexity of a program based on the number of primitive operations performed by the program for a given input size


## Summary

### Time Complexity Analysis
Time complexity analysis is a crucial aspect of competitive programming, as it helps determine the efficiency of an algorithm.
The time complexity of an algorithm is typically represented using Big O notation, which provides an upper bound on the number of operations performed by the algorithm.

### Understanding Big O Notation
Big O notation is used to represent the time complexity of an algorithm.
It is a mathematical notation that describes the complexity of an algorithm in terms of the size of the input.
For example, an algorithm with a time complexity of O(n^2) means that the number of operations performed by the algorithm grows quadratically with the size of the input.

### Types Of Time Complexity
There are several types of time complexity, including:
O(1) - constant time complexity, where the number of operations is independent of the size of the input
O(log n) - logarithmic time complexity, where the number of operations grows logarithmically with the size of the input

### Analyzing Time Complexity
To analyze the time complexity of an algorithm, we need to consider the number of operations performed by the algorithm and how it grows with the size of the input.
This can be done by:
Counting the number of operations performed by the algorithm
Identifying the loop variables and their ranges
Applying the master theorem to solve recurrence relations

### Importance Of Time Complexity Analysis
Time complexity analysis is crucial in competitive programming, as it helps determine the efficiency of an algorithm.
An algorithm with a low time complexity can solve large inputs quickly, while an algorithm with a high time complexity may take a long time to solve small inputs.
Understanding time complexity analysis helps programmers:
Choose the most efficient algorithm for a problem
Optimize their code to reduce the time complexity
Predict the performance of their code on large inputs

### Understanding Time Complexity
The text discusses the importance of understanding time complexity in problem-solving.
It explains that even if the time complexity of each individual test case is O(n), the overall time complexity can still be acceptable if the sum of n over all test cases does not exceed a certain limit (in this case, 10^7).
This is because the time complexity is calculated based on the sum of the individual values of n, not the product of t and n.
The text also mentions that online judges can perform a large number of operations per second (around 5*10^8), which affects the time complexity.
Additionally, it notes that memory complexity is also important and should be considered, especially when solving tasks that require a lot of memory.

### Key Findings
The Big O Notation (O()&quot; role=&quot;presentation&quot;&gt;O()O()) provides a mathematical notation to understand the complexity of an algorithm or to represent the complexity of an algorithm
The idea is that time taken for an algorithm or a program to run is some function of the input size (n)
It removes constant factors so that the running time can be estimated in relation to n. the Big O notation is for the upper bound assessment and is the worst case consideration of the time complexity
The following is the graphical representation of the number of primitive operatons vs input size of some of the common time complexities that one may come across — (This is the cleanest graphical representation I could find, and I got it from This LinkedIn Post)
That we have seen an example of experimentally getting the time taken by a program / algorithm to run, we can move on to theoretically predicting the time complexity of a program based on the number of primitive operations performed by the program for a given input size

## Data analysis
- #method/binary_search_algorithm
- #method/t_test

