## Results

Nature is the best artist. Giving enough time, the environment around us can almost always produce the optimal solution to any problem. Applying this idea and evolutionary algorithms on constrained problems to compute the (almost) optimal solution can produce some very interesting results where brute-force approachs may needs way too much time to be practical.

### Images Approximation

<table border="1" width="100%">
    <tr>
        <td><img src="images/022-naruto.gif" width="250"></td>
        <td><img src="images/030-steve.gif" width="250"></td>
        <td><img src="images/032-raupy.gif" width="250"></td>
    </tr>
</table>

<table border="1" width="100%">
    <tr>
        <td><img src="images/028-banksy.gif" width="250"></td>
        <td><img src="images/024-racoon.gif" width="250"></td>
        <td><img src="images/026-saitama.gif" width="250"></td>
    </tr>
</table>

---

### Traveling Salesman

Solution on 10 cities:

```
0 58 94 91 77 99 75 84 59 67 
58 0 85 52 55 85 88 74 84 82 
94 85 0 52 76 53 56 99 95 53 
91 52 52 0 70 84 50 66 87 53 
77 55 76 70 0 99 77 76 59 66 
99 85 53 84 99 0 67 89 94 84 
75 88 56 50 77 67 0 79 87 69 
84 74 99 66 76 89 79 0 99 84 
59 84 95 87 59 94 87 99 0 77 
67 82 53 53 66 84 69 84 77 0 

Genetic algorithm's solution after 2 seconds: Shortest path 313.0 - Longest path 842.0
```

Solution on 20 cities:
```
0 97 88 92 71 61 61 65 53 54 90 79 59 59 80 56 89 76 59 56 
97 0 78 67 50 96 73 60 98 86 55 70 83 67 93 94 87 52 64 57 
88 78 0 70 61 62 65 92 98 56 89 68 68 93 58 76 69 63 62 94 
92 67 70 0 58 67 64 60 56 83 97 94 60 65 79 72 52 55 60 57 
71 50 61 58 0 50 90 72 76 65 51 71 82 86 89 97 61 85 71 55 
61 96 62 67 50 0 65 65 58 60 51 65 66 55 56 64 62 55 82 85 
61 73 65 64 90 65 0 87 53 72 63 74 94 61 82 68 67 59 88 74 
65 60 92 60 72 65 87 0 64 96 59 94 88 66 92 70 84 94 55 76 
53 98 98 56 76 58 53 64 0 88 58 55 67 64 61 64 63 59 76 77 
54 86 56 83 65 60 72 96 88 0 65 57 63 66 90 72 75 73 91 50 
90 55 89 97 51 51 63 59 58 65 0 78 93 79 74 55 78 75 83 66 
79 70 68 94 71 65 74 94 55 57 78 0 57 65 53 83 67 55 94 62 
59 83 68 60 82 66 94 88 67 63 93 57 0 51 55 95 76 96 58 79 
59 67 93 65 86 55 61 66 64 66 79 65 51 0 91 99 99 80 96 75 
80 93 58 79 89 56 82 92 61 90 74 53 55 91 0 81 63 57 54 95 
56 94 76 72 97 64 68 70 64 72 55 83 95 99 81 0 50 74 58 65 
89 87 69 52 61 62 67 84 63 75 78 67 76 99 63 50 0 87 87 83 
76 52 63 55 85 55 59 94 59 73 75 55 96 80 57 74 87 0 53 54 
59 64 62 60 71 82 88 55 76 91 83 94 58 96 54 58 87 53 0 64 
56 57 94 57 55 85 74 76 77 50 66 62 79 75 95 65 83 54 64 0 

Genetic algorithm's solution after 3 seconds: Shortest path 942.0 - Longest path 1574.0
```

Solution on 30 cities:
```
0 51 51 91 50 76 86 77 86 84 64 54 95 74 60 65 57 84 61 71 98 68 98 83 62 71 99 62 97 89 
51 0 75 51 77 53 85 67 55 55 92 51 76 74 82 76 71 81 93 95 53 54 75 93 53 59 52 98 86 61 
51 75 0 96 90 72 71 75 91 75 99 71 78 59 64 73 83 60 67 58 99 81 72 66 61 94 94 95 56 78 
91 51 96 0 84 87 65 90 64 95 68 84 60 65 94 90 91 60 99 83 93 89 77 89 71 50 85 85 97 61 
50 77 90 84 0 61 74 79 65 63 68 65 54 84 84 89 82 67 73 69 79 57 83 90 68 99 83 83 87 78 
76 53 72 87 61 0 90 62 61 52 60 96 55 94 73 99 87 88 85 67 68 66 91 98 74 90 93 59 59 80 
86 85 71 65 74 90 0 55 78 88 69 55 89 97 71 82 54 75 79 93 68 76 74 62 69 55 81 95 60 55 
77 67 75 90 79 62 55 0 88 92 96 90 77 62 79 85 78 57 50 99 57 56 55 54 67 94 79 71 93 74 
86 55 91 64 65 61 78 88 0 72 95 94 52 72 87 85 84 52 70 67 51 77 74 93 54 83 66 87 63 53 
84 55 75 95 63 52 88 92 72 0 57 53 91 74 70 58 65 95 74 55 91 89 55 85 52 52 98 62 50 65 
64 92 99 68 68 60 69 96 95 57 0 68 93 60 61 73 56 50 64 51 64 75 52 63 79 75 51 58 74 82 
54 51 71 84 65 96 55 90 94 53 68 0 82 70 67 52 90 50 58 68 95 57 82 60 92 75 74 69 51 61 
95 76 78 60 54 55 89 77 52 91 93 82 0 84 87 80 99 94 99 52 79 75 64 90 86 87 83 55 95 67 
74 74 59 65 84 94 97 62 72 74 60 70 84 0 73 56 75 52 97 65 62 71 92 57 69 76 50 83 84 83 
60 82 64 94 84 73 71 79 87 70 61 67 87 73 0 83 73 95 60 54 93 71 82 71 97 70 89 80 74 51 
65 76 73 90 89 99 82 85 85 58 73 52 80 56 83 0 72 68 57 92 69 72 96 91 54 64 81 77 53 62 
57 71 83 91 82 87 54 78 84 65 56 90 99 75 73 72 0 75 57 64 63 92 86 60 84 93 52 72 65 87 
84 81 60 60 67 88 75 57 52 95 50 50 94 52 95 68 75 0 97 79 55 76 97 62 50 63 71 94 79 80 
61 93 67 99 73 85 79 50 70 74 64 58 99 97 60 57 57 97 0 57 81 73 90 82 84 79 69 54 86 61 
71 95 58 83 69 67 93 99 67 55 51 68 52 65 54 92 64 79 57 0 87 55 55 68 88 77 80 53 56 69 
98 53 99 93 79 68 68 57 51 91 64 95 79 62 93 69 63 55 81 87 0 77 59 59 93 82 80 80 61 68 
68 54 81 89 57 66 76 56 77 89 75 57 75 71 71 72 92 76 73 55 77 0 92 87 64 98 99 56 92 56 
98 75 72 77 83 91 74 55 74 55 52 82 64 92 82 96 86 97 90 55 59 92 0 57 73 60 73 62 77 69 
83 93 66 89 90 98 62 54 93 85 63 60 90 57 71 91 60 62 82 68 59 87 57 0 57 64 90 80 84 97 
62 53 61 71 68 74 69 67 54 52 79 92 86 69 97 54 84 50 84 88 93 64 73 57 0 80 85 52 93 51 
71 59 94 50 99 90 55 94 83 52 75 75 87 76 70 64 93 63 79 77 82 98 60 64 80 0 59 51 91 67 
99 52 94 85 83 93 81 79 66 98 51 74 83 50 89 81 52 71 69 80 80 99 73 90 85 59 0 92 70 64 
62 98 95 85 83 59 95 71 87 62 58 69 55 83 80 77 72 94 54 53 80 56 62 80 52 51 92 0 65 91 
97 86 56 97 87 59 60 93 63 50 74 51 95 84 74 53 65 79 86 56 61 92 77 84 93 91 70 65 0 76 
89 61 78 61 78 80 55 74 53 65 82 61 67 83 51 62 87 80 61 69 68 56 69 97 51 67 64 91 76 0 

Genetic algorithm's solution after 4 seconds: Shortest path 1658.0 - Longest path 2395.0
```

---

### N-Queen problem

```
Genetic algorithm's fittest solution (48.0) after 0 seconds: 

0 0 0 0 0 0 1 0 
0 0 0 0 1 0 0 0 
0 0 0 0 0 0 0 1 
0 1 0 0 0 0 0 0 
0 0 0 1 0 0 0 0 
0 0 0 0 0 1 0 0 
1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 
```

---

### Shakespeare Monkeys

<table border="1" width="100%">
    <tr>
        <td><img src="images/033-jfk.png" width="1000"></td>
    </tr>
</table>

---

### Knapsack

<table border="1" width="100%">
    <tr>
        <td><img src="images/034-knapsack.png" width="1000"></td>
    </tr>
</table>

---

## Some theory on Genetic algorithms

Genetic Algorithm (GA) is a search-based optimization technique based on the principles of Genetics and Natural Selection. 
It is frequently used to find optimal or near-optimal solutions to difficult problems which otherwise would take a lifetime
 o solve. It is frequently used to solve optimization problems, in research, and in machine learning.

### Introduction to optimization

Optimization is the process of making something better. 

Optimization refers to finding the values of inputs in such a way that we get the “best” output values. The definition 
of “best” varies from problem to problem, but in mathematical terms, it refers to maximizing or minimizing one or more 
objective functions, by varying the input parameters.

The set of all possible solutions or values which the inputs can take make up the search space. In this search space, 
lies a point or a set of points which gives the optimal solution. The aim of optimization is to find that point or set 
of points in the search space.

### Why genetic algorithms?

Nature has always been a great source of inspiration to all mankind. Genetic Algorithms (GAs) are search based algorithms 
based on the concepts of natural selection and genetics. GAs are a subset of a much larger branch of computation known as 
Evolutionary Computation.

GAs were developed by John Holland and his students and colleagues at the University of Michigan, most notably David E. Goldberg 
and has since been tried on various optimization problems with a high degree of success.

In GAs, we have a pool or a population of possible solutions to the given problem. These solutions then undergo recombination 
and mutation (like in natural genetics), producing new children, and the process is repeated over various generations. 
Each individual (or candidate solution) is assigned a fitness value (based on its objective function value) and the fitter 
individuals are given a higher chance to mate and yield more “fitter” individuals. This is in line with the Darwinian 
Theory of “Survival of the Fittest”.

In this way we keep “evolving” better individuals or solutions over generations, till we reach a stopping criterion.

Genetic Algorithms are sufficiently randomized in nature, but they perform much better than random local search (in which 
we just try various random solutions, keeping track of the best so far), as they exploit historical information as well.

### Advantages of GA
GAs have various advantages which have made them immensely popular. These include −

- Does not require any derivative information (which may not be available for many real-world problems).
- Is faster and more efficient as compared to the traditional methods.
- Has very good parallel capabilities.
- Optimizes both continuous and discrete functions and also multi-objective problems.
- Provides a list of “good” solutions and not just a single solution.
- Always gets an answer to the problem, which gets better over the time.
- Useful when the search space is very large and there are a large number of parameters involved.

### Limitations of GA

Like any technique, GAs also suffer from a few limitations. These include −
- GAs are not suited for all problems, especially problems which are simple and for which derivative information is available.
- Fitness value is calculated repeatedly which might be computationally expensive for some problems.
- Being stochastic, there are no guarantees on the optimality or the quality of the solution.
- If not implemented properly, the GA may not converge to the optimal solution.

### Motivation

Genetic Algorithms have the ability to deliver a “good-enough” solution “fast-enough”. This makes genetic algorithms attractive 
for use in solving optimization problems. The reasons why GAs are needed are as follows −

- Solving Difficult Problems: In computer science, there is a large set of problems, which are NP-Hard. What this essentially 
means is that, even the most powerful computing systems take a very long time (even years!) to solve that problem. 
In such a scenario, GAs prove to be an efficient tool to provide usable near-optimal solutions in a short amount of time.

- Failure of Gradient Based Methods
Traditional calculus based methods work by starting at a random point and by moving in the direction of the gradient, till 
we reach the top of the hill. This technique is efficient and works very well for single-peaked objective functions like 
the cost function in linear regression. But, in most real-world situations, we have a very complex problem called as 
landscapes, which are made of many peaks and many valleys, which causes such methods to fail, as they suffer from an 
inherent tendency of getting stuck at the local optima.

Some difficult problems like the Travelling Salesperson Problem (TSP), have real-world applications like path finding and 
VLSI Design. Now imagine that you are using your GPS Navigation system, and it takes a few minutes (or even a few hours) 
to compute the “optimal” path from the source to destination. Delay in such real world applications is not acceptable 
and therefore a “good-enough” solution, which is delivered “fast” is what is required.

# Fundamentals

Some basic terminology

Population − It is a subset of all the possible (encoded) solutions to the given problem. The population for a GA is analogous to the population for human beings except that instead of human beings, we have Candidate Solutions representing human beings.

Chromosomes − A chromosome is one such solution to the given problem.

Gene − A gene is one element position of a chromosome.

Allele − It is the value a gene takes for a particular chromosome.

![](images/001-terminology.jpg)

Genotype − Genotype is the population in the computation space. In the computation space, the solutions are represented in a way which can be easily understood and manipulated using a computing system.

Phenotype − Phenotype is the population in the actual real world solution space in which solutions are represented in a way they are represented in real world situations.

Decoding and Encoding − For simple problems, the phenotype and genotype spaces are the same. However, in most of the cases, the phenotype and genotype spaces are different. 
Decoding is a process of transforming a solution from the genotype to the phenotype space, while encoding is a process of transforming from the phenotype to genotype space. 
Decoding should be fast as it is carried out repeatedly in a GA during the fitness value calculation.

For example, consider the 0/1 Knapsack Problem. The Phenotype space consists of solutions which just contain the item numbers of the items to be picked.

However, in the genotype space it can be represented as a binary string of length n (where n is the number of items). 
A 0 at position x represents that xth item is picked while a 1 represents the reverse. This is a case where genotype and phenotype spaces are different.

![](images/002-pheno_genotype_space.jpg)

Fitness Function − A fitness function simply defined is a function which takes the solution as input and produces the suitability of the solution as the output. In some cases, the fitness function and the objective function may be the same, while in others it might be different based on the problem.

Genetic Operators − These alter the genetic composition of the offspring. These include crossover, mutation, selection, etc.

### Basic structures

The basic structure of a GA is as follows −

We start with an initial population (which may be generated at random or seeded by other heuristics), select parents from 
this population for mating. Apply crossover and mutation operators on the parents to generate new off-springs. And finally 
these off-springs replace the existing individuals in the population and the process repeats. In this way genetic algorithms 
actually try to mimic the human evolution to some extent.

A generalized pseudo-code for a GA is explained in the following program −

```
GA()
   initialize population
   find fitness of population
   
   while (termination criteria is reached) do
      parent selection
      crossover with probability pc
      mutation with probability pm
      decode and fitness calculation
      survivor selection
      find best
   return best
```

### Genotype representation

One of the most important decisions to make while implementing a genetic algorithm is deciding the representation that 
we will use to represent our solutions. It has been observed that improper representation can lead to poor performance of the GA.

Therefore, choosing a proper representation, having a proper definition of the mappings between the phenotype and genotype 
spaces is essential for the success of a GA.

In this section, we present some of the most commonly used representations for genetic algorithms. However, representation 
is highly problem specific and the reader might find that another representation or a mix of the representations mentioned 
here might suit his/her problem better.

- Binary representation

This is one of the simplest and most widely used representation in GAs. In this type of representation the genotype consists of bit strings.

For some problems when the solution space consists of Boolean decision variables – yes or no, the binary representation is natural. 
Take for example the 0/1 Knapsack Problem. If there are n items, we can represent a solution by a binary string of n elements, 
where the xth element tells whether the item x is picked (1) or not (0).

![](images/003-binary_representation.jpg)

For other problems, specifically those dealing with numbers, we can represent the numbers with their binary representation. 
The problem with this kind of encoding is that different bits have different significance and therefore mutation and crossover 
operators can have undesired consequences. This can be resolved to some extent by using Gray Coding, as a change in one bit does 
not have a massive effect on the solution.

- Real Valued Representation

For problems where we want to define the genes using continuous rather than discrete variables, the real valued 
representation is the most natural. The precision of these real valued or floating point numbers is however limited to the computer.

![](images/004-real_valued_representation.jpg)

- Integer Representation

For discrete valued genes, we cannot always limit the solution space to binary ‘yes’ or ‘no’. For example, if we want 
to encode the four distances – North, South, East and West, we can encode them as {0,1,2,3}. In such cases, integer representation is desirable.

![](images/005-integer_representation.jpg)

- Permutation Representation

In many problems, the solution is represented by an order of elements. In such cases permutation representation is the most suited.

A classic example of this representation is the travelling salesman problem (TSP). In this the salesman has to take a tour 
of all the cities, visiting each city exactly once and come back to the starting city. The total distance of the tour 
has to be minimized. The solution to this TSP is naturally an ordering or permutation of all the cities and therefore using 
a permutation representation makes sense for this problem.

![](images/006-permutation_representation.jpg)

### Population

Population is a subset of solutions in the current generation. It can also be defined as a set of chromosomes. There are 
several things to be kept in mind when dealing with GA population −

- The diversity of the population should be maintained otherwise it might lead to premature convergence.

- The population size should not be kept very large as it can cause a GA to slow down, while a smaller population might 
not be enough for a good mating pool. Therefore, an optimal population size needs to be decided by trial and error.

The population is usually defined as a two dimensional array of – size population, size x, chromosome size.

There are two primary methods to initialize a population in a GA. They are −

- Random Initialization − Populate the initial population with completely random solutions.

- Heuristic initialization − Populate the initial population using a known heuristic for the problem.

It has been observed that the entire population should not be initialized using a heuristic, as it can result in the population 
having similar solutions and very little diversity. It has been experimentally observed that the random solutions are 
the ones to drive the population to optimality. Therefore, with heuristic initialization, we just seed the population 
with a couple of good solutions, filling up the rest with random solutions rather than filling the entire population with heuristic based solutions.

It has also been observed that heuristic initialization in some cases, only effects the initial fitness of the population, 
but in the end, it is the diversity of the solutions which lead to optimality.

There are two population models widely in use −

- Steady State: In steady state GA, we generate one or two off-springs in each iteration and they replace one or two 
individuals from the population. A steady state GA is also known as Incremental GA.

- Generational: In a generational model, we generate ‘n’ off-springs, where n is the population size, and the entire population 
is replaced by the new one at the end of the iteration.

### Fitness Function

The fitness function simply defined is a function which takes a candidate solution to the problem as input and produces 
as output how “fit” our how “good” the solution is with respect to the problem in consideration.

Calculation of fitness value is done repeatedly in a GA and therefore it should be sufficiently fast. A slow computation 
of the fitness value can adversely affect a GA and make it exceptionally slow.

In most cases the fitness function and the objective function are the same as the objective is to either maximize or 
minimize the given objective function. However, for more complex problems with multiple objectives and constraints, an 
Algorithm Designer might choose to have a different fitness function.

A fitness function should possess the following characteristics −

- The fitness function should be sufficiently fast to compute.

- It must quantitatively measure how fit a given solution is or how fit individuals can be produced from the given solution.

In some cases, calculating the fitness function directly might not be possible due to the inherent complexities of the 
problem at hand. In such cases, we do fitness approximation to suit our needs.

The following image shows the fitness calculation for a solution of the 0/1 Knapsack. It is a simple fitness function which 
just sums the profit values of the items being picked (which have a 1), scanning the elements from left to right till the knapsack is full.

![](images/007-fitness_function.jpg)

### Parent selection

Parent Selection is the process of selecting parents which mate and recombine to create off-springs for the next generation. 
Parent selection is very crucial to the convergence rate of the GA as good parents drive individuals to a better and fitter solutions.

However, care should be taken to prevent one extremely fit solution from taking over the entire population in a few generations, 
as this leads to the solutions being close to one another in the solution space thereby leading to a loss of diversity. 
Maintaining good diversity in the population is extremely crucial for the success of a GA. This taking up of the entire 
population by one extremely fit solution is known as premature convergence and is an undesirable condition in a GA.

Fitness Proportionate Selection is one of the most popular ways of parent selection. In this every individual can become 
a parent with a probability which is proportional to its fitness. Therefore, fitter individuals have a higher chance of 
mating and propagating their features to the next generation. Therefore, such a selection strategy applies a selection 
pressure to the more fit individuals in the population, evolving better individuals over time.

### Crossover

The crossover operator is analogous to reproduction and biological crossover. In this more than one parent is selected 
and one or more off-springs are produced using the genetic material of the parents. Crossover 
is usually applied in a GA with a high probability – pc.

One Point Crossover - In this one-point crossover, a random crossover point is selected and the tails of its two parents are swapped to get new off-springs.

![](images/008-one_point_crossover.jpg)

Multi Point Crossover - Multi point crossover is a generalization of the one-point crossover wherein alternating segments are swapped to get new off-springs.

![](images/009-multi_point_crossover.jpg)

Uniform Crossover - In a uniform crossover, we don’t divide the chromosome into segments, rather we treat each gene separately. 
In this, we essentially flip a coin for each chromosome to decide whether or not it’ll be included in the off-spring. We can 
also bias the coin to one parent, to have more genetic material in the child from that parent.

![](images/010-uniform_crossover.jpg)

Whole Arithmetic Recombination - This is commonly used for integer representations and works by taking the weighted average 
of the two parents by using the following formulae −
                                 
Child1 = α.x + (1-α).y
Child2 = α.x + (1-α).y

Obviously, if α = 0.5, then both the children will be identical as shown in the following image.

![](images/011-whole_arithmetic_recombination.jpg)

Davis’ Order Crossover (OX1) - OX1 is used for permutation based crossovers with the intention of transmitting information 
about relative ordering to the off-springs. It works as follows −

- Create two random crossover points in the parent and copy the segment between them from the first parent to the first offspring.

- Now, starting from the second crossover point in the second parent, copy the remaining unused numbers from the second 
parent to the first child, wrapping around the list.

- Repeat for the second child with the parent’s role reversed.

![](images/012-david_order_crossover.jpg)

### Mutation

In simple terms, mutation may be defined as a small random tweak in the chromosome, to get a new solution. It is used to 
maintain and introduce diversity in the genetic population and is usually applied with a low probability – pm. If the 
probability is very high, the GA gets reduced to a random search.

Mutation is the part of the GA which is related to the “exploration” of the search space. It has been observed that mutation 
is essential to the convergence of the GA while crossover is not.

Bit Flip Mutation - In this bit flip mutation, we select one or more random bits and flip them. This is used for binary encoded GAs.

![](images/013-bit_flip_mutation.jpg)

Random Resetting - Random Resetting is an extension of the bit flip for the integer representation. In this, a random value from the set of permissible values is assigned to a randomly chosen gene.

Swap Mutation - In swap mutation, we select two positions on the chromosome at random, and interchange the values. This is common in permutation based encodings.

![](images/014-swap_mutation.jpg)

Scramble Mutation - Scramble mutation is also popular with permutation representations. In this, from the entire chromosome, a subset of genes is chosen and their values are scrambled or shuffled randomly.

![](images/016-scramble_mutation.jpg)

Inversion Mutation - In inversion mutation, we select a subset of genes like in scramble mutation, but instead of shuffling the subset, we merely invert the entire string in the subset.

![](images/015-inversion_mutation.jpg)

### Survivor Selection

The Survivor Selection Policy determines which individuals are to be kicked out and which are to be kept in the next 
generation. It is crucial as it should ensure that the fitter individuals are not kicked out of the population, while 
at the same time diversity should be maintained in the population.

Some GAs employ Elitism. In simple terms, it means the current fittest member of the population is always propagated to 
the next generation. Therefore, under no circumstance can the fittest member of the current population be replaced.

The easiest policy is to kick random members out of the population, but such an approach frequently has convergence 
issues, therefore the following strategies are widely used.

- Age Based Selection

In Age-Based Selection, we don’t have a notion of a fitness. It is based on the premise that each individual is allowed 
in the population for a finite generation where it is allowed to reproduce, after that, it is kicked out of the 
population no matter how good its fitness is.

For instance, in the following example, the age is the number of generations for which the individual has been in the 
population. The oldest members of the population i.e. P4 and P7 are kicked out of the population and the ages of the 
rest of the members are incremented by one.

![](images/017-age_based_selection.jpg)

- Fitness Based Selection

In this fitness based selection, the children tend to replace the least fit individuals in the population. The 
selection of the least fit individuals may be done using a variation of any of the selection policies described 
before – tournament selection, fitness proportionate selection, etc.

For example, in the following image, the children replace the least fit individuals P1 and P10 of the population. It 
is to be noted that since P1 and P9 have the same fitness value, the decision to remove which individual from the 
population is arbitrary.

![](images/018-fitness_based_selection.jpg)

### Termination Condition

The termination condition of a Genetic Algorithm is important in determining when a GA run will end. It has been observed 
that initially, the GA progresses very fast with better solutions coming in every few iterations, but this tends to 
saturate in the later stages where the improvements are very small. We usually want a termination condition such that 
our solution is close to the optimal, at the end of the run.

Usually, we keep one of the following termination conditions −

- When there has been no improvement in the population for X iterations.
- When we reach an absolute number of generations.
- When the objective function value has reached a certain pre-defined value.

For example, in a genetic algorithm we keep a counter which keeps track of the generations for which there has been no 
improvement in the population. Initially, we set this counter to zero. Each time we don’t generate off-springs which are 
better than the individuals in the population, we increment the counter.

However, if the fitness any of the off-springs is better, then we reset the counter to zero. The algorithm terminates 
when the counter reaches a predetermined value.

Like other parameters of a GA, the termination condition is also highly problem specific and the GA designer should try 
out various options to see what suits his particular problem the best.

### Models Of Lifetime Adaptation

Till now in this tutorial, whatever we have discussed corresponds to the Darwinian model of evolution – natural selection 
and genetic variation through recombination and mutation. In nature, only the information contained in the individual’s 
genotype can be transmitted to the next generation. This is the approach which we have been following in the tutorial so far.

However, other models of lifetime adaptation – Lamarckian Model and Baldwinian Model also do exist. It is to be noted that 
whichever model is the best, is open for debate and the results obtained by researchers show that the choice of lifetime 
adaptation is highly problem specific.

Often, we hybridize a GA with local search – like in Memetic Algorithms. In such cases, one might choose do go with either 
Lamarckian or Baldwinian Model to decide what to do with individuals generated after the local search.

- Lamarckian Model
The Lamarckian Model essentially says that the traits which an individual acquires in his/her lifetime can be passed 
on to its offspring. It is named after French biologist Jean-Baptiste Lamarck.

Even though, natural biology has completely disregarded Lamarckism as we all know that only the information in the 
genotype can be transmitted. However, from a computation view point, it has been shown that adopting the Lamarckian 
model gives good results for some of the problems.

In the Lamarckian model, a local search operator examines the neighborhood (acquiring new traits), and if a better 
chromosome is found, it becomes the offspring.

- Baldwinian Model
The Baldwinian model is an intermediate idea named after James Mark Baldwin (1896). In the Baldwin model, the 
chromosomes can encode a tendency of learning beneficial behaviors. This means, that unlike the Lamarckian model, we 
don’t transmit the acquired traits to the next generation, and neither do we completely ignore the acquired traits like 
in the Darwinian Model.

The Baldwin Model is in the middle of these two extremes, wherein the tendency of an individual to acquire certain traits 
is encoded rather than the traits themselves.

In this Baldwinian Model, a local search operator examines the neighborhood (acquiring new traits), and if a better 
chromosome is found, it only assigns the improved fitness to the chromosome and does not modify the chromosome itself. 
The change in fitness signifies the chromosomes capability to “acquire the trait”, even though it is not passed 
directly to the future generations.

### Effective Implementation

GAs are very general in nature, and just applying them to any optimization problem wouldn’t give good results. 
In this section, we describe a few points which would help and assist a GA designer or GA implementer in their work.

- Introduce problem-specific domain knowledge

It has been observed that the more problem-specific domain knowledge we incorporate into the GA; the better objective 
values we get. Adding problem specific information can be done by either using problem specific crossover or mutation 
operators, custom representations, etc.

- Reduce Crowding

Crowding happens when a highly fit chromosome gets to reproduce a lot, and in a few generations, the entire population 
is filled with similar solutions having similar fitness. This reduces diversity which is a very crucial element to 
ensure the success of a GA. There are numerous ways to limit crowding. Some of them are −

Mutation to introduce diversity.

Switching to rank selection and tournament selection which have more selection pressure than fitness proportionate selection 
for individuals with similar fitness.

Fitness Sharing − In this an individual’s fitness is reduced if the population already contains similar individuals.

- Randomization Helps!

It has been experimentally observed that the best solutions are driven by randomized chromosomes as they impart 
diversity to the population. The GA implementer should be careful to keep sufficient amount of randomization and diversity 
in the population for the best results.

- Hybridize GA with Local Search

Local search refers to checking the solutions in the neighborhood of a given solution to look for better objective values.

It may be sometimes useful to hybridize the GA with local search. The following image shows the various places in 
which local search can be introduced in a GA.

![](images/019-hybridize_ga.jpg)

### Constrained Optimization Problems

Constrained Optimization Problems are those optimization problems in which we have to maximize or minimize a given 
objective function value that is subject to certain constraints. Therefore, not all results in the solution space are 
feasible, and the solution space contains feasible regions as shown in the following image.

![](images/020-constrained_optimization.jpg)

In such a scenario, crossover and mutation operators might give us solutions which are infeasible. Therefore, 
additional mechanisms have to be employed in the GA when dealing with constrained Optimization Problems.

Some of the most common methods are −

- Using penalty functions which reduces the fitness of infeasible solutions, preferably so that the fitness is reduced in 
proportion with the number of constraints violated or the distance from the feasible region.

- Using repair functions which take an infeasible solution and modify it so that the violated constraints get satisfied.

- Not allowing infeasible solutions to enter into the population at all.

- Use a special representation or decoder functions that ensures feasibility of the solutions.

### Schema Theorem

Researchers have been trying to figure out the mathematics behind the working of genetic algorithms, and 
Holland’s Schema Theorem is a step in that direction. Over the year’s various improvements and suggestions have been 
done to the Schema Theorem to make it more general.

- A Schema is a “template”. Formally, it is a string over the alphabet = {0,1,*},
where * is don’t care and can take any value. Therefore, *10*1 could mean 01001, 01011, 11001, or 11011.
Geometrically, a schema is a hyper-plane in the solution search space.
- Order of a schema is the number of specified fixed positions in a gene.
- Defining length is the distance between the two furthest fixed symbols in the gene.

The schema theorem states that this schema with above average fitness, short defining length and lower order 
is more likely to survive crossover and mutation.

