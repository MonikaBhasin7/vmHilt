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


      Component
      -> When we pu the @AndroidEntryPoint over the top of class, Activity, Fragment, ViewModel etc,
         then Hilt generates the Component. It tells that this activity is ready to inject the
         fields inside it.
      -> The component will get destroy when the activity destroys in the case of Activity component.


     Scoping

        Android class           Generated component         Scope
        -------------            -----------------          ---------
        Application             Application component       @Singleton
        Activity	            ActivityRetainedComponent	@ActivityRetainedScoped
        ViewModel	            ViewModelComponent	        @ViewModelScoped
        Activity	            ActivityComponent	        @ActivityScoped
        Fragment	            FragmentComponent	        @FragmentScoped
        View	                ViewComponent	            @ViewScoped

        If we put @Singelton annotation on top of any dependency/binding, then its is scoped on/over the
        application component. It means it is used only in Application component or in its child component.


        By default, all bindings in Hilt are unscoped. This means that each time your app requests
        the binding, Hilt creates a new instance of the dependency.

        Hilt also allows a binding to be scoped to a particular component. Hilt only creates a scoped
        binding once per instance of the component that the binding is scoped to, and all
        requests for that binding share the same instance.

        Eg: if you scope AnalyticsAdapter to the ActivityComponent using @ActivityScoped,
        Hilt provides the same instance of AnalyticsAdapter throughout the life of the corresponding activity.
        If we calls the AnalyticsAdapter multiple times, it returns the same instance.

        Note: Scoping a binding to a component can be costly because the provided object stays in
        memory until that component is destroyed. Minimize the use of scoped bindings in your application.
        It is appropriate to use component-scoped bindings for bindings with an internal state that
        requires that same instance to be used within a certain scope, for bindings that need synchronization,
         or for bindings that you have measured to be expensive to create.


     Component Hierarchy

            ------------------
            @Singleton
            SingletonComponent
            ------------------
                    |
                    |
                    |
            -----------------------
            @ActivityRetainedScoped
            ActivityComponent
            ------------------------
                    |
                    |
                    |
             ----------------------
             @ActivityScoped
             ActivityComponent
             ----------------------

             The block tells us that if the dependency have the @Singleton annotation, then its is used
             in Singleton component/Activity component. But that same dependency can be accessed in any
             child component like Activity etc.
                

*/