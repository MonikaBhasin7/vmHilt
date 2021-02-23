package com.hk.vmhilt

/*
    Hilt creates the dependency at compile time and made available at run.

    Note: At build time, Hilt generates Dagger components for Android classes.
    Then, Dagger walks through your code and performs the following steps:
    Builds and validates dependency graphs, ensuring that there are no unsatisfied
    dependencies and no dependency cycles.
    Generates the classes that it uses at runtime to create the actual objects and their dependencies.


    Two Types of Injection ->
            Field Injection
             -> we mark our field injection with the @Inject annotation,
                thus telling Hilt that we need this dependency injected
                within this activity container.
            Constructor Injection



     @AndroidEntryPoint
     -> Generating or making the particular activity a component.
     -> Generates an individual Hilt component for each Android class in your project.
        These components can receive dependencies from their respective parent classes
        as described in Component hierarchy.
     -> In this activity we will be injecting member classes etc.
     -> This same annotation is used when it comes to injecting into fragments,
        views, services and broadcast receivers.


      @Inject
      -> Use the @Inject annotation on the constructor of a class to tell Hilt how to provide
         instances of that class
      -> Inject an notation on top of any field tell the hilt that this field is injectable, we have
         to provide this filed through injection into this component.
*/